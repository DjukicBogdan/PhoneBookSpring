package controllers;

import model.PhoneBook;
import model.PhoneBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PhoneBookController {
    @Autowired
    PhoneBookDao dao;

    @RequestMapping("/form")
    public String showform(Model m){
        m.addAttribute("command", new PhoneBook());
        return "form";
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("person") PhoneBook phoneBook){
        dao.savePerson(phoneBook);
        return "redirect:/viewPhoneBook";
    }

    @GetMapping("/")
    public String getPhoneBook() {
        return "redirect:/viewPhoneBook";
    }

    @RequestMapping(value="/viewPhoneBook",method = RequestMethod.GET)
    public String viewPhoneBook(Model m){
        List<PhoneBook> list=dao.getPhoneBook();
        m.addAttribute("list",list);
        return "viewPhoneBook";
    }

    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable int id, Model m){
        PhoneBook phoneBook=dao.getPersonById(id);
        m.addAttribute("command",phoneBook);
        return "editform";
    }

    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("person") PhoneBook phoneBook){
        dao.updatePerson(phoneBook);
        return "redirect:/viewPhoneBook";
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        dao.deletePerson(id);
        return "redirect:/viewPhoneBook";
    }

}
