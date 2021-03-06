package database;

public class Bounty {
	public int id;
	public String title;
	public String criteria;
	public String description;
	public double value;
	public String expiration;
	
	public Bounty(){	
		this.id = 0;
		this.title = "";
		this.criteria = "";
		this.description = "";
		this.value = 0;
		this.expiration = "";
	}
	
	public Bounty(int id, String title, String criteria, String description, double value, String expiration)
	{
		this.id = id;
		this.title = title;
		this.criteria = criteria;
		this.description = description;
		this.value = value;
		this.expiration = expiration;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setCriteria(String criteria)
	{
		this.criteria = criteria;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setValue(double value)
	{
		this.value = value;
	}
	
	public void setExpiration(String expiration)
	{
		this.expiration = expiration;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getCriteria()
	{
		return criteria;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public double getValue()
	{
		return value;
	}
	
	public String getExpiration()
	{
		return expiration;
	}
}
