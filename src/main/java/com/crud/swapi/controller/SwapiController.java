package com.crud.swapi.controller;

import com.crud.swapi.client.SwapiClient;
import com.crud.swapi.domain.CharacterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/swapi")
public class SwapiController {

    private final SwapiClient swapiClient;

    @GetMapping("getSwapiBoards")
    public void getSwapiBoards() {

        List<CharacterDto> swapiBoards = swapiClient.getCharacters();

        swapiBoards.forEach(characterDto -> {
            System.out.println(characterDto.getId() + " " + characterDto.getName());
        });
    }


}
