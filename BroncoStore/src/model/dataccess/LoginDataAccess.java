package model.dataccess;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import model.entities.User;

public class LoginDataAccess {

	@SuppressWarnings("unchecked")
	public User verifyCredentials(User user) throws ClassNotFoundException, SQLException {
		
		/*final String URL = "jdbc:postgresql://localhost:5432/authentication";

		final String USER = "postgres";

		final String PWD = "123";

		Class.forName("org.postgresql.Driver");
		Connection conection = DriverManager.getConnection(URL, USER, PWD);

		final PreparedStatement stmt = conection.prepareStatement("SELECT * FROM users WHERE username=? and password=?");

		stmt.setString(1, user.getUserName());
		stmt.setString(2, user.getPassword());

		ResultSet rs = stmt.executeQuery();

		return rs.next();*/
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).
                                 buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		String hql = "from User s where s.userName=:userName and s.password=:password";
		List<User> result = session.createQuery(hql).setProperties(user).list();
        
		session.getTransaction().commit();
		
		return (result.size()>0?result.get(0):null);	   
		
	}

}

