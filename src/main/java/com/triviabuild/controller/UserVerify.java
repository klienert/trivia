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

@WebServlet(
        urlPatterns = {"/verify"}
)
@Log
public class UserVerify extends HttpServlet {
    private HttpSession session;
    GenericDao userDao;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();

//        HashMap<String, String> userMap = (HashMap<String, String>) session.getAttribute("user");

        String username = (String)session.getAttribute("username");
        String email = (String)session.getAttribute("email");
        String fname = (String)session.getAttribute("firstName");
        String lname = (String)session.getAttribute("lastName");

        getUser(username, email, fname, lname); // checks if it is new or not, puts in the DB
        setUserInSession(username, email); // puts username/email in the session

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);

    }

    public void setUserInSession(String username, String email) {
         session.setAttribute("username", username);
         session.setAttribute("email", email);
    }


    /**
     * Takes user info and checks if it is new, if so, inserts into DB
     *
     * @param username the username
     * @param email    the email
     * @param fname    the fname
     * @param lname    the lname
     */
    public void getUser (String username, String email, String fname, String lname) {
        User user;
        userDao = new GenericDao(User.class);
        List<User> foundUser = userDao.getByPropertyEqual("userName", username);
        if (foundUser.isEmpty()) { // not in DB
            // create new user
            User newUser = new User();
            newUser.setUserName(username);
            newUser.setEmail(email);
            newUser.setFirstName(fname);
            newUser.setLastName(lname);
            int newUserId = userDao.insert(newUser);
//            user = (User)userDao.getById(newUserId);
//            log.info("new user: " + user.getUserName());
        } else { // exists in DB, get that user
//            log.info("user in DB: " + foundUser.get(0).getUserName());
        }
    }
}
