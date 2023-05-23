package com.triviabuild.controller;


import com.triviabuild.entity.*;
import com.triviabuild.persistence.GenericDao;
import com.triviabuild.persistence.triviaDAO;
import com.triviabuild.trivia.ResultsItem;
import lombok.extern.java.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The type Quiz start.
 */
@WebServlet(
        urlPatterns = {"/quizstart"}
)
@Log
public class quizStart extends HttpServlet {
    GenericDao<User> userDao;
    triviaDAO triviaDao;
    GenericDao<Quiz> quizDao;
    GenericDao<Category> categoryDao;
    GenericDao<Difficulty> difficultyDao;
    GenericDao<Attempt> attemptDao;
    Date currDate;

    public void init() throws ServletException {
        super.init();
        userDao = new GenericDao<>(User.class);
        triviaDao = new triviaDAO();
        quizDao = new GenericDao<>(Quiz.class);
        categoryDao = new GenericDao<>(Category.class);
        difficultyDao = new GenericDao<>(Difficulty.class);
        attemptDao = new GenericDao<>(Attempt.class);
        currDate = new Date();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init();
        HttpSession session = req.getSession();
        String username = String.valueOf(session.getAttribute("username"));
        int currScore = (int) session.getAttribute("score");

        // user
        int userId = getUserId(username);
        User user = userDao.getById(userId);

        // quiz
        String quizDesc = quizDescription(userId);

        // get params, use conditional
        if (req.getParameter("submit").equals("quiz")) {
            int cat = Integer.parseInt(req.getParameter("category"));
            String diff = req.getParameter("difficulty");

            // start a new quiz
            int newQuiz = newQuiz(quizDesc, cat, diff, userId);
            Quiz quiz = quizDao.getById(newQuiz);
//            session.setAttribute("quiz", quiz);
            // new attempt
            Attempt newAtt = new Attempt(currDate, currScore, user, quiz);
            int attemptID = attemptDao.insert(newAtt);
            session.setAttribute("attempt", newAtt);

            // get results via api
            List<ResultsItem> api = triviaDao.getEightQuestions(cat, diff).getResults();

            // put results from api into a session
            session.setAttribute("api", api);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/questions");
            dispatcher.forward(req, resp);
        } else {
            log.severe("Error - no parameters");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
        }
    }

    ////////////////////////////
    //// Helper methods
    ///////////////////////////


    /**
     * Creates a quiz description for each quiz, username -- date of quiz
     *
     * @param userId the user id
     * @return string containing the username and current date
     */
    public String quizDescription (int userId) {
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("MMM dd, yyyy h:mm a");
        String currDate = DateFor.format(date);
        User user = userDao.getById(userId);
        return user.getUserName() + " -- " + currDate;
    }

    /**
     * Defines a new Quiz based on the params
     * Uploads info to DB
     *
     * @param description the description
     * @param topic       the topic
     * @param difficulty  the difficulty
     * @param userId      the user id
     * @return the new quizID
     */
    public int newQuiz (String description, int topic, String difficulty, int userId) {
        User user = userDao.getById(userId);
        Category cat = categoryDao.getById(topic);

        List<Difficulty> difficulties = difficultyDao.getByPropertyLike("difficulty", difficulty);
        Difficulty diff = difficulties.get(0);

        Quiz newQ = new Quiz(description, cat, diff, user, currDate);
        return quizDao.insert(newQ);
    }

    /**
     * This defines and adds a new user
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param username  the username
     * @param email     the email
     * @return the new user ID
     */
    public int newUser (String firstName, String lastName, String username, String email) {
        User user = new User(firstName, lastName, username, email);
        return userDao.insert(user);
    }

    /**
     * retrieves the userID based on the username
     *
     * @param username the username
     * @return int of the user ID
     */
    public int getUserId (String username) {
        List <User> user = userDao.getByPropertyLike("userName", username);
        return user.get(0).getId();
    }
}
