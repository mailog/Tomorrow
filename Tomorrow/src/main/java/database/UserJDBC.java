package database;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import Security.EncryptMethod;

public class UserJDBC implements UserDAO{
	
	private static DataSource datasource;
	private static JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource ds){
		this.datasource = ds;
		jdbcTemplateObject = new JdbcTemplate(datasource);
	}
	
	public void createUser(User user)
	{
		String SQL = "insert into account (email, username, password) values (?, ?, ?)";
		jdbcTemplateObject.update(SQL, user.getEmail(), user.getUsername(), user.getPassword());
		System.out.println("Created Record Name: " +"\nEmail: " + user.getEmail() + "\nUsername: " + user.getUsername() + "\nPW: " + user.getPassword());
	}
	
	public User getUser(String email){
		String SQL = "select * from account where email=?";
		User user = jdbcTemplateObject.queryForObject(SQL, new Object[]{email}, new UserMapper());
		System.out.println("Got " + user.getEmail());
		return user;
	}
	
	public List<User> listUsers(){
		String SQL = "select * from account";
		List<User> users = jdbcTemplateObject.query(SQL, new UserMapper());
		return users;
	}
	
	public void deleteUser(String email){
		String SQL = "delete from account where email = ?";
		jdbcTemplateObject.update(SQL, email);
		System.out.println("Deleted " + email + " from Users");
	}
	
	public void updateUser(String email, String password){
		String SQL = "update account set password = ? where email = ?";
		jdbcTemplateObject.update(SQL, password, email);
		System.out.println("Updated " + email);
	}
}
