package ru.julie.rickandmorty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.julie.rickandmorty.model.Characters;
import ru.julie.rickandmorty.model.Result;
import ru.julie.rickandmorty.service.ServiceApi;

@Controller
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("/")
    public String getAllCharacters(Model model) {
        Characters allCharacters = serviceApi.getAllCharacters();
        model.addAttribute("characters", allCharacters.getResults());
        return "characters";
    }

    @GetMapping("/character/{id}")
    public String getCharacterDetails(@PathVariable("id") int characterId, Model model) {
        Result character = serviceApi.getCharacterById(characterId);
        model.addAttribute("character", character);
        return "characterDetails";
    }
}