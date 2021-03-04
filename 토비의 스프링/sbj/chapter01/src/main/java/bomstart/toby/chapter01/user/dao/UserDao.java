package bomstart.toby.chapter01.user.dao;

import bomstart.toby.chapter01.user.domain.User;

import java.sql.*;

/**
 * 관심사: 유저 정보 (등록, 조회)
 *
 * 전략 패턴의 컨텍스트에 해당하는 클래스
 */
public class UserDao {
    private ConnectionMaker connectionMaker;

    /**
     * 변경이 필요한 DB 연결 방식의 ConnectionMaker라는 인터페이스를 정의하고,
     * 이를 구현한 클래스(전략)을 UserDao를 사용하는 클라이언트가 바꿔가면서 사용할 수 있도록 한다.
     *
     * @param connectionMaker (DConnectionMaker | NConnectionMaker) - DB 연결 방식을 구현한 클래스
     */
    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    /**
     * 유저 저장
     * @param user
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("INSERT INTO users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    /**
     * 유저 조회
     * @param id
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE id = ? ");
        ps.setString(1, id );
        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
