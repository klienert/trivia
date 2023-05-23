package com.triviabuild.controller;

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
import java.util.List;

/**
 * The type Quiz answer.
 */
@WebServlet(
        urlPatterns = {"/quizAnswer"}
)
@Log
public class quizAnswer  extends HttpServlet {

    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int numQuestion = (int) session.getAttribute("questionNum");
        int currScore = (int) session.getAttribute("score");
        int count = (int) session.getAttribute("countdown");
        List<ResultsItem> list = (List<ResultsItem>) session.getAttribute("api");

        String givenAns = req.getParameter("btn");
        String corrAns = list.get(numQuestion).getCorrectAnswer();

        req.setAttribute("q", list.get(numQuestion));
        req.setAttribute("a", givenAns);
        req.setAttribute("isCorrect", isCorrect(givenAns, corrAns));
        if (isCorrect(givenAns, corrAns)) {
            currScore++;
            session.setAttribute("score", currScore);
        } else {
//            currScore--; // removing this to avoid a negative score
            session.setAttribute("score", currScore);
        }

        // increment numQuestion
        numQuestion++;
        session.setAttribute("questionNum", numQuestion);
        // decrement count
        count--;
        session.setAttribute("countdown", count);

        if (numQuestion <= 7 ) {
            req.setAttribute("gameOver", false);
        } else {
            req.setAttribute("gameOver", true);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/quizAnswer.jsp");
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
