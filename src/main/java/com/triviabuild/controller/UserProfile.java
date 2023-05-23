package com.triviabuild.controller;

import com.triviabuild.entity.*;
import com.triviabuild.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
 * The type User profile.
 */
@WebServlet(
        urlPatterns = {"/profile"}
)

public class UserProfile extends HttpServlet{
    private final Logger log = LogManager.getLogger(this.getClass());
    GenericDao userDao;
    GenericDao attemptDao;
    GenericDao quizDao;
    HttpSession session;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDao = new GenericDao<>(User.class);
        attemptDao = new GenericDao<>(Attempt.class);
        quizDao = new GenericDao<>(Quiz.class);

        session = req.getSession();

        String userName = (String) session.getAttribute("username");

        if (userName == null) {
            resp.sendRedirect("error.jsp");
        } else {
            //Get User info
            List<User> users = userDao.getByPropertyEqual("userName", userName);
            User user = users.get(0);

            req.setAttribute("user", user);

            // get Attempt Info
            List<Attempt> attemptsByUser = attemptsByUser(user);
            List<Quiz> quizByUser = quizByUser(user);

            ArrayList<HashMap<String, Object>> list = quizAttemptList(quizByUser, attemptsByUser);
            req.setAttribute("list", list);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
            dispatcher.forward(req, resp);
        }
    }

    /**
     * Retrieves a list of attempts by the specified user
     * @param user
     * @return  Array List of attempts
     */
    private List<Attempt> attemptsByUser (User user) {
        List<Attempt> attByUser = new ArrayList<>();
        List<Attempt> attempts = attemptDao.getAll();
        for (Attempt i : attempts) {
            if (i.getUser().equals(user)) {
                attByUser.add(i);
            }
        }
        return attByUser;
    }

    /**
     * Retrives a list of quizzes by the specified user
     * @param user
     * @return Array list of quizzes by user
     */
    private List<Quiz> quizByUser (User user) {
        List<Quiz> quizByUser = new ArrayList<>();
        List<Quiz> quizzes = quizDao.getAll();
        for (Quiz i : quizzes) {
            if (i.getUser().equals(user)) {
                quizByUser.add(i);
            }
        }
//        log.info("quizByUser - " + quizByUser);
        return quizByUser;
    }

    /**
     * Assembles an array list of hashmaps that contains all attempts/quiz info for a user
     * @param quizzes
     * @param attempts
     * @return
     */
    private ArrayList<HashMap<String, Object>> quizAttemptList (List<Quiz> quizzes, List<Attempt> attempts) {
        ArrayList<HashMap<String, Object>> newList = new ArrayList<>();
        for (int i = 0; i < attempts.size(); i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("description", quizzes.get(i).getDescription());
            map.put("difficulty", quizzes.get(i).getDifficulty().getDifficulty());
            map.put("topic", quizzes.get(i).getCategory().getTopic());
            map.put("score", attempts.get(i).getScore());
            map.put("completed", dateFormat(attempts.get(i).getFinishedDate()));
            newList.add(map);
        }
        log.info("list of attempts\n " + newList + "\n");
        return newList;
    }



    private String dateFormat (Date date) {
//        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMM dd, yyyy h:mm a");
        String result = "";
        try {
            result = outputFormat.format(date);
            log.info("Date formatted: " + result);
        } catch (Exception e) {
            log.debug("Date formatter Exception" + e);
        }
        return result;
    }

}
