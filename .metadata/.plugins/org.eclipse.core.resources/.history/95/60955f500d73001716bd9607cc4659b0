package Users;
import java.util.List;
import javax.sql.DataSource;
public interface UserDAO {
	
	public void setDataSource(DataSource ds);
	
	public void create(String email, String password);
	
	public User getUser(String email);
	
	public List<User> listUsers();
	
	public void delete(String email);
	
	public void update(String email, String password);
}
