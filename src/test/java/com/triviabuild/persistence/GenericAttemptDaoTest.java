package com.triviabuild.persistence;

import com.triviabuild.entity.*;
import com.triviabuild.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 * The type Attempt dao test.
 */
public class GenericAttemptDaoTest {
    /**
     * The Attempt dao.
     */
    GenericDao<Attempt> attemptDao;
    GenericDao<User> userDao;
    GenericDao<Quiz> quizDao;
    Date currDate;


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        attemptDao = new GenericDao<>(Attempt.class);
        userDao = new GenericDao<>(User.class);
        quizDao = new GenericDao<>(Quiz.class);
        currDate = new Date();
        Database database = Database.getInstance();
        database.runSQL("newClean.sql");
    }

    /**
     * Gets all Attempts success.
     */
    @Test
    void getAllAttempts_Success() {
        List<Attempt> allAttempts = attemptDao.getAll();
        assertEquals(1, allAttempts.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        Attempt retrievedAttempts = attemptDao.getById(1);
        assertNotNull(retrievedAttempts);
        assertEquals(5, retrievedAttempts.getScore());
    }

    /**
     * Insert Attempt success.
     */
    @Test
    void insertAttempt_Success() {
        Attempt newAtt = new Attempt(currDate, 6, userDao.getById(1), quizDao.getById(1));
        int id = attemptDao.insert(newAtt);
        assertNotEquals(0, id);
        Attempt retrievedAtt = attemptDao.getById(id);
        assertEquals(newAtt.getScore(), retrievedAtt.getScore());
    }

    /**
     * Update Attempt success.
     */
    @Test
    void updateAttempt_Success() {
        Attempt attToUpdate = attemptDao.getById(1);
        attToUpdate.setScore(8);
        attemptDao.saveOrUpdate(attToUpdate);
        Attempt retrievedAtt = attemptDao.getById(1);
        assertEquals(8, retrievedAtt.getScore());
    }

    /**
     * Delete User success.
     */
    @Test
    void deleteUserSuccess() {
        // insert dummy attempt first
        Attempt newAtt = new Attempt(currDate, 2, userDao.getById(1), quizDao.getById(1));
        int newAttID = attemptDao.insert(newAtt);
        attemptDao.delete(attemptDao.getById(newAttID));
        assertNull(attemptDao.getById(newAttID));
    }
}

