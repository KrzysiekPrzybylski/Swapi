package com.crud.swapi.client;

import com.crud.swapi.domain.CharacterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Component
@RequiredArgsConstructor
public class SwapiClient {

    private final RestTemplate restTemplate;

    @Value("${swapi.api.endpoint.prod}")
    private String swapiApiEndpoint;


    public List<CharacterDto> getCharacters() {
        URI url = UriComponentsBuilder.fromHttpUrl(swapiApiEndpoint + "/people/")
                .queryParam("search", "r2")
                .build().encode().toUri();

        CharacterDto[] boardsResponse = restTemplate.getForObject(url, CharacterDto[].class);

        return Optional.ofNullable(boardsResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }
}
