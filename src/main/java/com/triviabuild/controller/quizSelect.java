package com.triviabuild.controller;

import com.triviabuild.entity.User;
import com.triviabuild.persistence.GenericDao;
import lombok.extern.java.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * The type Quiz select.
 */
@WebServlet(
        urlPatterns = {"/quizselect"}
)
@Log
public class quizSelect extends HttpServlet {
    GenericDao<User> userDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDao = new GenericDao<>(User.class);
        HttpSession session = req.getSession();

        if (session.getAttribute("username") == null) {
            resp.sendRedirect("error.jsp");

        } else {
            String username = (String) session.getAttribute("username");
//            log.info("username From Session: " + username);

            List<User> user = userDao.getByPropertyLike("userName", username);
//            log.info("get length: " + user.size());
            User currUser = user.get(0);

            req.setAttribute("user", currUser);

            session.setAttribute("score", 0);
            session.setAttribute("questionNum", 0);
            session.setAttribute("countdown", 8);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/selectedQuiz.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
