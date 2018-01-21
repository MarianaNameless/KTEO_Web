package gr.hua.dit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.hua.dit.dao.UserDAO;
import gr.hua.dit.models.User;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

	@Autowired
	private UserDAO userDAO;

	//show registration form
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	//what happens when registration form is submitted
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String newUser(Model model, @ModelAttribute("user") User user) {
		String userid = user.getUserID();
		String name = user.getName();
		String password = user.getPassword();
		int i = 0;

		if (userid == null || userid.equals("")) {
			i = i + 1;
			model.addAttribute("error", "Το UserID δεν μπορεί να είναι κενό");
		} else {
			i = userDAO.compare(userid);//check if this user name is already in use
			if (i != 0)
				model.addAttribute("error", "Αυτό το UserID χρησιμοποιείται ήδη");
		}
		if (name == null || name.equals("")) {
			i = i + 1;
			model.addAttribute("error", "Το όνομα δεν μπορεί να είναι κενό");
		}
		if (password == null || password.equals("")) {
			i = i + 1;
			model.addAttribute("error", "To password δεν μπορεί να είναι κενό");
		}
		if (i == 0) {
			userDAO.register(user);
			model.addAttribute("message", "Ο νέος χρήστης προστέθηκε");
		}

		return "register";
	}

	//view login form
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	//when login form is submitted
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(Model model, @ModelAttribute("user") User user){
		String view = new String();
		String userid=user.getUserID();
		String password=user.getPassword();
		int i=0;
		
		if (userid== null || userid.equals("")){
			i = i + 1;
			model.addAttribute("error", "Το UserID δεν μπορεί να είναι κενό");
		}
		if (password == null || password.equals("")){
			i = i + 1;
			model.addAttribute("error", "To password δεν μπορεί να είναι κενό");
		}
		if (i==0){
			User newUser = new User();//check if user exists
			newUser = userDAO.login(userid, password);
			if (newUser == null){
				model.addAttribute("message", "no such user, try again");
				view="login";//if  not, attempt to login again
			}else{
				model.addAttribute("message", "success");
			 	view="redirect:user/{userid:\\w+}";//else, redirect to personal page
			}
		}
		return view;
	}

	//personal page of each user, unfortunately not working
	@RequestMapping(value="user/{userid:\\w+}", method=RequestMethod.GET)
		public String getUser(Model model, @PathVariable("userid") String userid){
		
			User user = userDAO.getById(userid);
			model.addAttribute("user", user);
			return "user";
	}
}
