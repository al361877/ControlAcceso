package es.uji.ei1027.ControlAcceso.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    private UserDao userDao;

    @Autowired
    public void setSociDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/list")
    public String listSocis(HttpSession session, Model model) {
        if (session.getAttribute("user") == null){
            UserDetails user =new UserDetails();
            model.addAttribute("user", user);
            session.setAttribute("nextUrl", "beneficiario/index");
            session.setAttribute("autorizado",user.getAutorizado());
            return "login";
        }else {
            UserDetails user = (UserDetails) session.getAttribute("user");
            session.setAttribute("autorizado",user.getAutorizado());
        }
        model.addAttribute("users", userDao.listAllUsers());
        return "beneficiario/index";
    }

    @RequestMapping("/index")
    public String index(HttpSession session, Model model) {
        return "user/index";
    }
}

