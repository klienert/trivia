package com.triviabuild.controller;

import com.triviabuild.entity.*;
import com.triviabuild.persistence.*;
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
import java.util.*;

/**
 * The type Select quiz.
 */
@WebServlet (
        urlPatterns = {"/registeredUser"}
)
@Log
public class selectQuiz extends HttpServlet {

    GenericDao<Attempt> attemptDao;
    GenericDao<Category> categoryDao;
    GenericDao<Difficulty> difficultyDao;
    GenericDao<Quiz> quizDao;
    GenericDao<User> userDao;
    triviaDAO triviaDao;
    Date currDate;

    @Override
    public void init() throws ServletException {
        super.init();

        attemptDao = new GenericDao<>(Attempt.class);
        categoryDao = new GenericDao<>(Category.class);
        difficultyDao = new GenericDao<>(Difficulty.class);
        quizDao = new GenericDao<>(Quiz.class);
        userDao = new GenericDao<>(User.class);
        triviaDao = new triviaDAO();
        currDate = new Date();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init();
        HttpSession session = req.getSession();
        String username = session.getAttribute("username").toString();
        int score = 0;
        int numQuestions = 8;

        // get userInfo
        int userID = getUserId(username);
        User user = userDao.getById(userID);

        // Quiz Info
        String quizDesc = quizDescription(userID);

        session.setAttribute("attemptDate", currDate);
        session.setAttribute("score", score);

        // Get params - get quiz questions
        if (req.getParameter("submit").equals("quiz")) {
            int cat = Integer.parseInt(req.getParameter("category"));
            String diff = req.getParameter("difficulty");

            int newQuiz = newQuiz(quizDesc, cat, diff, userID);
            Quiz quiz = quizDao.getById(newQuiz);
            Attempt newAtt = new Attempt(currDate, score, user, quiz);
            attemptDao.insert(newAtt);

            List<ResultsItem> api = triviaDao.getEightQuestions(cat, diff).getResults();

            req.setAttribute("q", api.get(0));
            req.setAttribute("ans", showAns(api.get(0).getCorrectAnswer(), api.get(0).getIncorrectAnswers()));
            req.setAttribute("api", api.toString()); // this prints the WHOLE thing


            // TODO: change this to a servet that will go through each question and log correct answers
            RequestDispatcher dispatcher = req.getRequestDispatcher("/ready.jsp");
            dispatcher.forward(req, resp);
        } else {
            log.severe("Error - no params");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
        }
    }


    /**
     * Returns a HashSet (unordered) of the correct answer and 3 incorrect answers
     *
     * @param correctAns the correct ans
     * @param incAns     the inc ans
     * @return HashSet String of four answers
     */
    public HashSet<String> showAns(String correctAns, List<String> incAns) {
        HashSet<String> newSet = new HashSet<>();
        newSet.add(correctAns);
        newSet.add(incAns.get(0));
        newSet.add(incAns.get(1));
        newSet.add(incAns.get(2));
        return newSet;
    }

    ////////////////////////////////////////
    //// Helper Methods
    /////////////////////////////////////////


    /**
     * Creates a quiz description for each quiz, username -- date of quiz
     *
     * @param userId the user id
     * @return string containing the user name and current date
     */
    public String quizDescription (int userId) {
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss Z");
        String currDate = DateFor.format(date);
        User user = userDao.getById(userId);
        return user.getUserName() + " -- " + currDate;
    }

    /**
     * Defines a new Quiz based on the params
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
        log.info("Cat for new Quiz: " + cat + "  " + cat.getTopic());

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
