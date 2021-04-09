package com.bomstart.tobyspring.user;

import com.bomstart.tobyspring.user.dao.UserDao;
import com.bomstart.tobyspring.user.domain.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@ContextConfiguration(locations = "/applicationContext.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void mockUpFixture() throws SQLException {
        this.user1 = new User("test1", "testName1", "!@#$%");
        this.user2 = new User("test2", "testName2", "!@#$%");
        this.user3 = new User("test3", "testName3", "!@#$%");
    }

    @AfterEach
    void clearDB() throws SQLException {
        userDao.deleteAll();
    }

    @Test
    @DisplayName("유저 생성 테스트")
    void addUser() throws SQLException {
        userDao.add(user1);

        User user = userDao.get(user1.getId());

        assertThat(user.getId(), is(user1.getId()));
        assertThat(user.getName(), is(user1.getName()));
        assertThat(user.getPassword(), is(user1.getPassword()));
    }

    @Test
    @DisplayName("유저수 조회 테스트")
    void count() throws SQLException {
        assertThat(userDao.getCount(), is(0));

        userDao.add(user1);
        assertThat(userDao.getCount(), is(1));

        userDao.add(user2);
        assertThat(userDao.getCount(), is(2));

        userDao.add(user3);
        assertThat(userDao.getCount(), is(3));
    }

    @Test
    @DisplayName("유저 생성과 조회 테스트")
    void addAndGet() throws SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        userDao.add(user1);
        assertThat(userDao.getCount(), is(1));

        User user = userDao.get(user1.getId());

        assertThat(user.getId(), is(user1.getId()));
        assertThat(user.getName(), is(user1.getName()));
        assertThat(user.getPassword(), is(user1.getPassword()));
    }

    @Test
    @DisplayName("잘못된 유저 조회 테스트")
    void getUserFailure() throws SQLException {
        userDao.deleteAll();

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            assertThat(userDao.getCount(), is(0));

            userDao.get("unkown_id");
        });
    }

    @Test
    @DisplayName("모든 유저 조회")
    void getAll() throws  SQLException{
        userDao.deleteAll();

        assertThat(userDao.getAll().size(), is(0));

        userDao.add(user1);
        List<User> users1 = userDao.getAll();
        assertThat(users1.size(), is(1));
        checkSameUser(user1, users1.get(0));

        userDao.add(user2);
        List<User> users2 = userDao.getAll();
        assertThat(users2.size(), is(2));
        checkSameUser(user1, users2.get(0));
        checkSameUser(user2, users2.get(1));
    }

    private void checkSameUser(User user1, User user2) {
        assertThat(user1.getId(), is(user2.getId()));
        assertThat(user1.getName(), is(user2.getName()));
        assertThat(user1.getPassword(), is(user2.getPassword()));
    }

}
