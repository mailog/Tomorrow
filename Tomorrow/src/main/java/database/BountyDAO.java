package database;
import java.util.List;
import javax.sql.DataSource;
public interface BountyDAO {
	
	public void setDataSource(DataSource ds);
	
	public void createBounty(Bounty bounty);
	
	public Bounty getBounty(int id);
	
	public List<Bounty> listBounties();
	
	public void deleteBounty(int id);
	
	public void updateUser(int id, String title, String criteria, String description, double value, String expiration);
}
