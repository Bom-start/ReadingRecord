package bomstart.toby.chapter01.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 관심사: DB 연결 방식
 *
 * UserDao에서 DB 연결이라는 관심사를 분리한다.
 */
public interface ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
