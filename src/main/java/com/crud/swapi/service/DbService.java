package com.crud.swapi.service;

import com.crud.swapi.domain.Character;
import com.crud.swapi.mapper.CharacterMapper;
import com.crud.swapi.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    @Autowired
    private  CharacterRepository characterRepository;


    public List<Character> getAllCharacter(){
        return characterRepository.findAll();
    }
    public Optional<Character> getCharacter(final Long characterId) {
        return characterRepository.findById(characterId);
    }
    public Character saveCharacter(Character character){
        return characterRepository.save(character);
    }
}
