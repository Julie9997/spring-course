package ru.julie.rickandmorty.service;

import ru.julie.rickandmorty.model.Characters;
import ru.julie.rickandmorty.model.Result;

public interface ServiceApi {
    public Characters getAllCharacters();

    Result getCharacterById(int id);
}