package com.crud.swapi.mapper;

import com.crud.swapi.domain.Character;
import com.crud.swapi.domain.CharacterDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterMapper {
    public Character mapToCharacter(final CharacterDto characterDto){
        return new Character(
                characterDto.getId(),
                characterDto.getName()
        );
    }
    public CharacterDto mapToCharacterDto(final Character character){
        return new CharacterDto(
                character.getId(),
                character.getName()
        );
    }
    public List<CharacterDto> mapToCharacterDtoList(final List<Character> characterList){
        return characterList.stream()
                .map(this::mapToCharacterDto)
                .collect(Collectors.toList());
    }
}
