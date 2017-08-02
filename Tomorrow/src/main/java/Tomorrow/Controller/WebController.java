package Tomorrow.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import Security.EmailValidation;
import database.Bounty;
import database.BountyJDBC;
import database.User;
import database.UserJDBC;

@Controller
public class WebController extends WebMvcConfigurerAdapter{
	public static ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	public static UserJDBC userJDBC = (UserJDBC)context.getBean("userJDBCTemplate");
	public static BountyJDBC bountyJDBC = (BountyJDBC)context.getBean("bountyJDBCTemplate");
	public static EmailValidation emailVerify = new EmailValidation();
	
	/*-------------Home-------------------*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	ModelAndView getHome()
	{
		List<Bounty> bounties = bountyJDBC.getBounties();
		for(int i = 0; i < bounties.size(); i++)
		{
			System.out.println("Bounty " + (i+1) + ": " + bounties.get(i).getTitle());
		}
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("bounties", bounties);
		return modelAndView;
	}

	@RequestMapping(value = "/requests", method = RequestMethod.GET)
	ModelAndView getRequests()
	{
		ModelAndView modelAndView = new ModelAndView("requests");
		modelAndView.addObject("request", new Bounty());
		return modelAndView;
	}
	
	@RequestMapping(value = "/requests", method = RequestMethod.POST)
	ModelAndView submitRequests(@ModelAttribute("request") Bounty request)
	{
		boolean validity = false;
		ModelAndView modelAndView = new ModelAndView("requests-result");
		System.out.println("Request: " + request.getTitle() +"\nCriteria: " + request.getTitle() + 
							"\nDescription: " + request.getDescription() + "\nValue: " + request.getValue() + 
							"\nExpiration: " + request.getExpiration());
		try
		{
			bountyJDBC.createBounty(request);
			validity = true;
		}catch(Exception e){
			validity = false;
		}
		modelAndView.addObject("validity", validity);
		return modelAndView;
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	ModelAndView getAbout()
	{
		ModelAndView modelAndView = new ModelAndView("about");
		return modelAndView;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	ModelAndView getContact()
	{
		ModelAndView modelAndView = new ModelAndView("contact");
		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	ModelAndView getLogin()
	{
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("login_user", new User());
		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	ModelAndView submitLogin(@ModelAttribute("login_user") User login_user, HttpServletResponse response)
	{
		ModelAndView modelAndView = new ModelAndView("login-result");
		User tmpUser = userJDBC.getUser(login_user.getEmail());
		if(tmpUser.getPassword().equals(login_user.getPassword()))
		{
			modelAndView.addObject("validity", true);
			modelAndView.addObject("user", tmpUser);
			response.addCookie(new Cookie("USERNAME", tmpUser.getUsername()));
		}
		else
		{
			modelAndView.addObject("validity", false);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	ModelAndView getRegister()
	{
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("register_user", new User());
		return modelAndView;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	ModelAndView submitRegister(@ModelAttribute("register_user") User register_user)
	{
		boolean 
		ModelAndView modelAndView = new ModelAndView("register-result");
		try{
			userJDBC.createUser(register_user);
			modelAndView.addObject("user", register_user);
			modelAndView.addObject("validity", true);
		}catch(Exception e){
			modelAndView.addObject("validity", false);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	ModelAndView getAccount(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("account");
		String accountInfo;
		try{
			Cookie[] tmpCook = request.getCookies();
			accountInfo = tmpCook[0].getValue();
		}catch(Exception e)
		{
			accountInfo = "dingus";
		}
		modelAndView.addObject("username", accountInfo);
		return modelAndView;
	}
}
	
	
	
	