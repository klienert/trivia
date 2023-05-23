package com.triviabuild.controller;

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
import java.util.Date;
import java.util.HashSet;
import java.util.List;


/**
 * The type Quiz question.
 */
@WebServlet(
        urlPatterns = {"/questions"}
)

@Log
public class quizQuestion extends HttpServlet {
    triviaDAO triviaDao;
    Date currDate;

    @Override
    public void init() throws ServletException {
        super.init();
        triviaDao = new triviaDAO();
        currDate = new Date();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init();
        HttpSession session = req.getSession();
        int numQuestion = (int) session.getAttribute("questionNum");

        List<ResultsItem> list = (List<ResultsItem>) session.getAttribute("api");

        req.setAttribute("api", list.get(numQuestion));
        req.setAttribute("allAns", showAns(list.get(numQuestion).getCorrectAnswer(), list.get(numQuestion).getIncorrectAnswers()));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/quizQuestion.jsp");
        dispatcher.forward(req, resp);

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
        if (incAns.size() > 1) {
            newSet.add(correctAns);
            newSet.add(incAns.get(0));
            newSet.add(incAns.get(1));
            newSet.add(incAns.get(2));
        } else {
            newSet.add(correctAns);
            newSet.add(incAns.get(0));
        }
        return newSet;
    }
}