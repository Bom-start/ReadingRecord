package bomstart.toby.chapter01.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker{
    /**
     * ConnectionMaker 인터페이스 구현 (bomstart2 DB에 연결)
     */
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/bomstart2", "", "");
        return c;
    }
}
