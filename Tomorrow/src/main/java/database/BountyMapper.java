package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BountyMapper implements RowMapper<Bounty>{
	public Bounty mapRow(ResultSet rs, int rowNum) throws SQLException{
		Bounty bounty = new Bounty();
		bounty.setId(rs.getInt("id"));
		bounty.setTitle(rs.getString("title"));
		bounty.setCriteria(rs.getString("criteria"));
		bounty.setDescription(rs.getString("description"));
		bounty.setValue(rs.getDouble("value"));
		bounty.setExpiration(rs.getString("expiration"));
		return bounty;
	}

}