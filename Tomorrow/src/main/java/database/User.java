package database;

public class User {
	public String email;
	public String username;
	public String password;
	public User(){	
		this.email="";
		this.username = "";
		this.password = "";
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setUsername(String username){
		this.username = username;
		
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword(){
		return password;
	}

}
