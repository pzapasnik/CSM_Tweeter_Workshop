package pl.coderslab.workshop6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.workshop6.Entity.User;
import pl.coderslab.workshop6.Repository.UserRepository;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loggin(Model model) {
        User user = new User ();
        boolean pass = true;
        model.addAttribute("user", user);
        model.addAttribute("pass", pass);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submitLoggin(@Valid User user, BindingResult result, @PathVariable boolean pass) {

// Sprawdzm Czy użytkownik istnieje w Bazie danych

        if (userRepository.findByEmail(user.getEmail()) == null) {
            FieldError error = new FieldError
                    ("noSuchUser","email", "There is no such User with posed email");
            result.addError(error);

//  Sprawdzam zgodność hasła

        } else {
            if (!user.checkPassword(user.getPassword())) {
                FieldError wrongPass = new FieldError(
                        "wrongPass", "password", "Wrong Password for given Email adress");
                result.addError(wrongPass);
            }
        }

        if (result.hasErrors()) {
            return "index";
        } else {
            return "/" + user.getEmail() + "/home";
        }
    }



    
    @RequestMapping(value = "/{email}/home", method = RequestMethod.GET)
    public String userHomePage(@PathVariable String email, Model model){
        return "";
    }
}
