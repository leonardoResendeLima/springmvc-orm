package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import user.entity.User;
import user.services.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("userRegistration")
    public String showRegistrationPage() {
        return "userRegister";
    }

    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, ModelMap model) {
        int result = userService.save(user);
        model.addAttribute("result", "User Created with Id " + result);
        return "userRegister";
    }

    @RequestMapping("getUsers")
    public String loadUsers(ModelMap model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "displayUsers";
    }

    @RequestMapping("validateEmail")
    public @ResponseBody
    String validateEmail(@RequestParam int id) {
        User user = userService.findUser(id);
        String msg = "";

        if (user != null)
            return id + " is already exists";
        return msg;
    }
}
