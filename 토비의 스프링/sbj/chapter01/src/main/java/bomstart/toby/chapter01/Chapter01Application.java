package bomstart.toby.chapter01;

import bomstart.toby.chapter01.pattern.templatemethod.Beverage;
import bomstart.toby.chapter01.user.dao.ConnectionMaker;
import bomstart.toby.chapter01.user.dao.DConnectionMaker;
import bomstart.toby.chapter01.user.dao.UserDao;
import bomstart.toby.chapter01.user.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class Chapter01Application {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		ConnectionMaker connectionMaker = new DConnectionMaker();
//		UserDao dao = new UserDao(connectionMaker);
//
//		User user = new User();
//		user.setId("root");
//		user.setName("sbj");
//		user.setPassword("root");
//
//		dao.add(user);
//
//		System.out.println(user.getId() + " 등록 성공");
//
//		User user2 = dao.get(user.getId());
//		System.out.println(user2.getName());
//		System.out.println(user2.getPassword());
//		System.out.println(user2.getId() + " 조회 성공");

//		SpringApplication.run(Chapter01Application.class, args);
	}

}
