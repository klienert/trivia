package com.triviabuild.controller;

import com.triviabuild.entity.Attempt;
import com.triviabuild.persistence.GenericDao;
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
import java.util.Date;
import java.util.List;

/**
 * The type Quiz end.
 */
@WebServlet(
        urlPatterns = {"/quizend"}
)

@Log
public class quizEnd extends HttpServlet {
    /**
     * The Attempt dao.
     */
    GenericDao<Attempt> attemptDao = new GenericDao<>(Attempt.class);
    /**
     * The Curr date.
     */
    Date currDate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currDate = new Date();
        HttpSession session = req.getSession();
        int finalScore = (int) session.getAttribute("score");
        List<ResultsItem> list = (List<ResultsItem>) session.getAttribute("api");
        Attempt att = (Attempt) session.getAttribute("attempt");
        int attID = att.getId();
        Attempt newAtt = attemptDao.getById(attID);
        newAtt.setScore(finalScore);
        newAtt.setFinishedDate(currDate);
        attemptDao.saveOrUpdate(newAtt);


        req.setAttribute("finalScore", finalScore);
        req.setAttribute("topic", list.get(0).getCategory());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/quizEnd.jsp");
        dispatcher.forward(req, resp);

    }

}
