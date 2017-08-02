package database;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import Security.EncryptMethod;

public class BountyJDBC implements BountyDAO{
	
	private static DataSource datasource;
	private static JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource ds){
		this.datasource = ds;
		jdbcTemplateObject = new JdbcTemplate(datasource);
	}
	
	public void createBounty(Bounty bounty)
	{
		String SQL = "insert into bounty (id, title, criteria, description, value, expiration) values (?, ?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(SQL, bounty.getId(), bounty.getTitle(), bounty.getCriteria(), bounty.getDescription(), bounty.getValue(), bounty.getExpiration());
		System.out.println("Created Record Name: " + bounty.getTitle() + "with ID: " + bounty.getId());
	}
	
	public Bounty getBounty(int id){
		String SQL = "select * from bounty where email=?";
		Bounty bounty = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new BountyMapper());
		return bounty;
	}
	
	public List<Bounty> getBounties(){
		String SQL = "select * from bounty";
		List<Bounty> bounties = jdbcTemplateObject.query(SQL, new BountyMapper());
		return bounties;
	}
	
	public List<Bounty> listBounties(){
		String SQL = "select * from bounty";
		List<Bounty> bounties = jdbcTemplateObject.query(SQL, new BountyMapper());
		return bounties;
	}
	
	public void deleteBounty(int id){
		String SQL = "delete from bounty where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted " + id + " from bounty");
	}
	
	public void updateUser(int id, String title, String criteria, String description, double value, String expiration){
		String SQL = "update bounty set title = ? set criteria = ? set description = ? set value = ? set expiration = ?";
		jdbcTemplateObject.update(SQL, title, criteria, description, value, expiration);
		System.out.println("Updated " + id);
	}
}
