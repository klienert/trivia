package com.triviabuild.controller;

import lombok.extern.java.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * The type User sign out.
 */
@WebServlet(
        urlPatterns = {"/signOutUser"}
)
@Log
public class UserSignOut extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        session.removeAttribute("username");
        session.removeAttribute("score");
        session.removeAttribute("countdown");
        session.removeAttribute("questionNum");

        session.invalidate();


        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

}
