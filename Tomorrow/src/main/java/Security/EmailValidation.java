package Security;

import database.User;

public class EmailValidation {

	public EmailValidation()
	{
		
	}
	
	public boolean CheckEmailSyntax(String email)
	{
		boolean emailSyntax = true;
		if(!email.contains("@"))
			emailSyntax = false;
		return emailSyntax;
	}
	
	public boolean passwordString(String password, User validUser)
	{
		boolean passwordValidity = true;
		if(!password.equals(validUser.getPassword()))
		{
			passwordValidity = false;
		}
		return passwordValidity;
	}
	
}
