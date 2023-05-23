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
import java.util.HashMap;

/**
 * The type Random answer.
 */
@WebServlet(
        urlPatterns = {"/randomAnswer"}
)
/**
 * This servlet uses the TriviaDao and retrieves a random trivia question for the user to answer
 * Log-in is not required, no record will be kept to the DB
 */
@Log
public class randomAnswer extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        HashMap<String, Object> map = (HashMap<String, Object>) session.getAttribute("map");
        String givenAns =  req.getParameter("btn");
        String corrAns = String.valueOf(map.get("correctAnswer"));

        req.setAttribute("q", map);
        req.setAttribute("a", givenAns);
        req.setAttribute("isCorrect", isCorrect(givenAns, corrAns));
        int oldScore = (int) session.getAttribute("score");
        if (isCorrect(givenAns, corrAns)) {
            oldScore++;
            session.setAttribute("score", oldScore);
        } else {
            oldScore--;
            session.setAttribute("score", oldScore);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/randomAnswer.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * compares two strings, returns a boolean whether they are the same or not
     * @param givenAns
     * @param corrAns
     * @return  boolean response
     */
    private boolean isCorrect(String givenAns, String corrAns) {
        if (givenAns.equals(corrAns)) {
            return true;
        }
        return false;
    }

}
