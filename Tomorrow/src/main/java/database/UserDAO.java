package database;
import java.util.List;
import javax.sql.DataSource;
public interface UserDAO {
	
	public void setDataSource(DataSource ds);
	
	public void createUser(User user);
	
	public User getUser(String email);
	
	public List<User> listUsers();
	
	public void deleteUser(String email);
	
	public void updateUser(String email, String password);
}
