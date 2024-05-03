package com.javier.SOPE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    @GetMapping
    public String index(Model model) {
        List<Contacto> contactos = contactoRepository.findAll();
        model.addAttribute("contactos", contactos);
        return "index";

    }

    @GetMapping("/nuevo")
    public String nuevo (Model model) {
        model.addAttribute("contacto", new Contacto());
        return "form";
    }

    @PostMapping("/nuevo")
    public String crear (Contacto contacto){
        contactoRepository.save(contacto);
        return "redirect:/";
    }





}
