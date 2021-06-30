package com.crud.swapi.controller;


import com.crud.swapi.domain.Character;
import com.crud.swapi.domain.CharacterDto;
import com.crud.swapi.exception.CharacterNotFoundException;
import com.crud.swapi.mapper.CharacterMapper;
import com.crud.swapi.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/character")

public class StarWarsController {

    private final DbService dbService;
    private final CharacterMapper characterMapper;
    @Autowired
    public StarWarsController(DbService dbService, CharacterMapper characterMapper) {
        this.dbService = dbService;
        this.characterMapper = characterMapper;
    }

    @GetMapping(value = "getCharacters")
    public List<CharacterDto> getCharacters() {
        List<Character> characters = dbService.getAllCharacter();
        return characterMapper.mapToCharacterDtoList(characters);
    }
    @GetMapping(value = "getCharacter")
    public CharacterDto getCharacter(@RequestParam Long characterId) throws CharacterNotFoundException {
        return characterMapper.mapToCharacterDto(dbService.getCharacter(characterId).orElseThrow(CharacterNotFoundException::new));
    }
    @DeleteMapping(value = "deleteCharacter")
    public void deleteCharacter(Long characterId) {
    }
    @PostMapping(value = "createCharacter", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCharacter(@RequestBody CharacterDto characterDto){
        Character character = characterMapper.mapToCharacter(characterDto);
        dbService.saveCharacter(character);
    }
    @PutMapping(value = "updateCharacter")
    public CharacterDto updateTask(@RequestBody CharacterDto characterDto) {
        Character character = characterMapper.mapToCharacter(characterDto);
        Character savedCharacter = dbService.saveCharacter(character);
        return characterMapper.mapToCharacterDto(savedCharacter);
    }
}
