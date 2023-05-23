package com.triviabuild.controller;

import com.triviabuild.entity.User;
import com.triviabuild.persistence.GenericDao;
import lombok.extern.java.Log;
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
import java.util.List;

/**
 * The type User profile edit.
 */
@WebServlet(
        urlPatterns = {"/profile-edit"}
)
@Log
public class UserProfileEdit extends HttpServlet{
    private final Logger logger = LogManager.getLogger(this.getClass());
    private final GenericDao userDao = new GenericDao<>(User.class);

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("username");
//        log.info("   ***SESSION username: " + userName);

        // get id from username
        List<User> getUser = userDao.getByPropertyEqual("userName", userName);
//        int userID = getUser.get(0).getId();

        

        req.setAttribute("user", getUser);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(req, resp);
    }
}
