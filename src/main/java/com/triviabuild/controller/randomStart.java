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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * The type Random start.
 */
@WebServlet(
        urlPatterns = {"/randomStart"}
)
/**
 * This servlet uses the TriviaDao and retrieves a random trivia question for the user to answer
 * Log-in is not required, no record will be kept to the DB
 */
@Log
public class randomStart extends HttpServlet {
    /**
     * The Dao.
     */
    triviaDAO dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // getting randomized question from API
        int cat = randomCategory();
        String diff = randomDiff();
        int score = 0;
        session.setAttribute("score", score);

        HashMap<String, Object> currMap = getQuestion(cat, diff);
        req.setAttribute("api", currMap);
        session.setAttribute("map", currMap);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/random.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Takes the params, accesses API Get and returns a SINGLE random question
     *
     * @param category   -- category for the question
     * @param difficulty -- difficulty level of question
     * @return hashmap that allows access to the random question data
     */
    public HashMap<String, Object> getQuestion (int category, String difficulty) {
        dao = new triviaDAO();
        HashMap<String, Object> newMap = new HashMap<>();
        // NOTE: This is hardcoded to be all multiple choice (4 answers total)
        List<ResultsItem> list = dao.randomQuestion(1, category, difficulty).getResults();

        for (int i = 0; i < list.size(); i++) {
            newMap.put("question", list.get(i).getQuestion());
            newMap.put("type", list.get(i).getType());
            newMap.put("correctAnswer", list.get(i).getCorrectAnswer());
            newMap.put("incorrectAnswers", list.get(i).getIncorrectAnswers());
            newMap.put("difficulty", list.get(i).getDifficulty());
            newMap.put("category", list.get(i).getCategory());
            newMap.put("allAns", showAns(list.get(i).getCorrectAnswer(), list.get(i).getIncorrectAnswers()));
            newMap.put("ansLen", list.get(i).getIncorrectAnswers().size() + 1);
        }
        return newMap;
    }


    /**
     * Generates a random number between 9 - 32, correlating with the range of topics for trivia
     *
     * @return a random number
     */
    public int randomCategory() {
        int min = 9;
        int max = 32;

        int randomCat = (int)Math.floor(Math.random() * (max - min + 1) + min);
        return randomCat; // meow :)
    }

    /**
     * Generates a random term from the 3 options of difficulty from the Trivia API
     *
     * @return random difficulty level (term -- i.e., Easy, Medium, or Difficult)
     */
    public String randomDiff() {
        HashMap<Integer, String> newMap = new HashMap<>();
        newMap.put(1, "easy");
        newMap.put(2, "medium");
        newMap.put(3, "hard");

        int rand = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
        return newMap.get(rand);

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

}
