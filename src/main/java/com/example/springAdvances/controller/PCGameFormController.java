package com.example.springAdvances.controller;

import com.example.springAdvances.dto.PCGameForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/pc-games")
public class PCGameFormController {

    @GetMapping
    public String showForm(ModelMap modelMap){
        PCGameForm test = new PCGameForm();
        test.setGenre("RPG");
        test.setIsAAA(true);
        test.setTitle("Starcraft");
        test.setProducer("Blizzard");
        modelMap.addAttribute("pcGameForm", test);
//        modelMap.addAttribute("pcGameForm", new PCGameForm());
        modelMap.addAttribute("createMessage","Create PC Game");
        return "pcgame";
    }

    @PostMapping
    public String createGame(@ModelAttribute PCGameForm pcGameForm, ModelMap modelMap){
        modelMap.addAttribute("pcGame",pcGameForm);
        return "pcgame_info";
    }
}
