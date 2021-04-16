package es.uji.ei1027.ControlAcceso.controller;

import javax.servlet.http.HttpSession;

import es.uji.ei1027.ControlAcceso.dao.UsuarioDao;
import es.uji.ei1027.ControlAcceso.model.Ciudadano;
import es.uji.ei1027.ControlAcceso.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UsuarioController {
    private UsuarioDao userDao;


    @Autowired
    public void setUsuario(UsuarioDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/list")
    public String listUusarios( Model model) {

        List<Usuario> lista = userDao.getCiudadanos();

        model.addAttribute("usuarios", userDao.getCiudadanos());

        return "user/list.html";
    }

    @RequestMapping(value="/add")
    public String addUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "user/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("usuario") Usuario user,BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "user/add";
        userDao.addUsuario(user);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{dni}", method = RequestMethod.GET)
    public String editUsuario(Model model, @PathVariable String dni) {
        model.addAttribute("usuario", userDao.getUsuarioDni(dni));
        return "usuario/update";
    }

    @RequestMapping(value="/busca/{dni}", method = RequestMethod.GET)
    public String buscaUsuario(Model model, @PathVariable String dni) {
        model.addAttribute("usuario", userDao.getUsuarioDni(dni));
        return "usuario/busca";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("usuario") Usuario usuario,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "usuario/update";
        userDao.updateUsuario(usuario);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{dni}")
    public String processDelete(@PathVariable String dni) {
        userDao.deleteUsuario(dni);
        return "redirect:../list";
    }
}

