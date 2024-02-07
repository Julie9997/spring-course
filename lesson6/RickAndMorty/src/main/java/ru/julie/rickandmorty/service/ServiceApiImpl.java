package ru.julie.rickandmorty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.julie.rickandmorty.model.Characters;
import ru.julie.rickandmorty.model.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ServiceApiImpl implements ServiceApi{

    @Value("${character.url}")
    private String characterApi;

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    @Override
    public Characters getAllCharacters() {
        Characters allCharacters = new Characters();
        List<Result> allResults = new ArrayList<>();
        String nextUrl = characterApi;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        while(nextUrl != null) {
            ResponseEntity<Characters> response = template.exchange(nextUrl, HttpMethod.GET, entity, Characters.class);
            Characters charactersResponse = response.getBody();

            allResults.addAll(charactersResponse.getResults());
            nextUrl = charactersResponse.getInfo().getNext();
        }

        allCharacters.setResults(allResults);
        return allCharacters;
    }

    @Override
    public Result getCharacterById(int id) {
        return getAllCharacters().getResults().stream().filter(item -> Objects.equals(item.getId(), id)).findFirst().get();
    }
}