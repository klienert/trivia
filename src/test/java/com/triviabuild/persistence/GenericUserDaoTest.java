package com.triviabuild.persistence;

import lombok.extern.java.Log;

/**
 * The type User dao test.
 */
@Log
public class GenericUserDaoTest {
    /**
     * The User dao.
     */
//    GenericDao<User> userDao;
//
//    /**
//     * Sets up.
//     */
//    @BeforeEach
//    void setUp() {
//        userDao = new GenericDao<>(User.class);
//        Database database = Database.getInstance();
//        database.runSQL("newClean.sql");
//    }
//
//    /**
//     * Gets all Users success.
//     */
//    @Test
//    void getAllUsersSuccess() {
//        List<User> Users = userDao.getAll();
//        assertEquals(4, Users.size());
//    }
//
//    /**
//     * Gets all user by name success.
//     */
//    @Test
//    void getAllUserByNameSuccess() {
//        List<User> bartUser = userDao.getByPropertyEqual("firstName", "Bart");
//        assertEquals(1, bartUser.size());
//        List<User> bartEmail = userDao.getByPropertyLike("email", "b");
//        assertEquals(1, bartEmail.size());
//    }
//
//
//    /**
//     * Gets by username success.
//     */
//    @Test
//    void getByUserNameSuccess() {
//        List<User> marge = userDao.getByPropertyEqual("userName", "msimpson");
//        String fName = marge.get(0).getFirstName();
//        assertEquals("Marge", fName);
//    }
//
//    /**
//     * Gets by id success.
//     */
//    @Test
//    void getByIdSuccess() {
//        User retrievedUser = userDao.getById(4);
//        assertNotNull(retrievedUser);
//        String fName = retrievedUser.getFirstName();
//        assertEquals("Lisa", fName);
//        String email = retrievedUser.getEmail();
//        assertEquals("lsimpson@email.com", retrievedUser.getEmail());
//    }
//
//    /**
//     * Insert User success.
//     */
//    @Test
//    void insertUserSuccess() {
//        User newUser = new User("Maggie", "Simpson", "magssimpson", "maggiesimpsom@email.com");
//        int id = userDao.insert(newUser);
//        assertNotEquals(0, id);
//        User insertedUser = userDao.getById(id);
//        assertTrue(insertedUser.equals(newUser));
//    }
//
//    /**
//     * Update User success.
//     */
//    @Test
//    void updateUserSuccess() {
//        String wrongName = "Harold";
//        User UserToUpdate = userDao.getById(1);
//        UserToUpdate.setFirstName(wrongName);
//        userDao.saveOrUpdate(UserToUpdate);
//        User retrievedUser = userDao.getById(1);
////        assertEquals(wrongName, retrievedUser.getFirstName());
//        assertTrue(wrongName.equals(retrievedUser.getFirstName()));
//    }
//
//    /**
//     * Delete User success.
//     */
//    @Test
//    void deleteUserSuccess() {
//        userDao.delete(userDao.getById(3));
//        assertNull(userDao.getById(3));
//    }
}

