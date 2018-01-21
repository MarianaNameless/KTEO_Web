package gr.hua.dit;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// when url = /rules
	@RequestMapping(value = "/rules", method = RequestMethod.GET)
	public String rules(Model model) {
		return "rules";
	}

	// when url = /points
	@RequestMapping(value = "/points", method = RequestMethod.GET)
	public String points(Model model) {
		return "points";
	}

	// when url = /instructions
	@RequestMapping(value = "/instructions", method = RequestMethod.GET)
	public String instructions(Model model) {
		return "instructions";
	}

	// when url = /check
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String check(Model model) {
		return "check";
	}

	// when the submit button is hit, get the form's content
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String checkDate(Model model, @ModelAttribute("date") String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date checkDate = new Date();
		try {
			checkDate = format.parse(date);//date provided by user
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date currentDate = new Date();// today's date
		int currentYear;
		if (currentDate.before(checkDate)){//date cannot be in the future
			model.addAttribute("message", "Λάθος ημερομηνία");	
		}
		if (currentDate.after(checkDate)){
			currentYear = (currentDate.getYear() - 2);//if check happened tow years ago
			currentDate.setYear(currentYear);
			if (currentDate.after(checkDate)){
				model.addAttribute("message", "Πρέπει να περάσετε από έλεγχο KΤΕΟ");
			} else {
				model.addAttribute("message", "Δεν χρειάζεται να περάσετε από έλεγχο ακόμη");
			}
		}
		return "check";
	}
}
