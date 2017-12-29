package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;

    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String address, Model model) {
        signupRepository.save(new Signup(name, address));
        return "done";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listSignees(Model model) {
        List<Signup> signees = signupRepository.findAll();
        List<String> signeeData = new ArrayList<>();
        for (Signup signee: signees) {
            signeeData.add(signee.getName() + " " + signee.getAddress() + " " + signee.getSensitiveData());
        }
        model.addAttribute("signees", signeeData);
        return "list";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPanel() {
        return "admin";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam String url) {
        return "redirect:" + url;
    }

}
