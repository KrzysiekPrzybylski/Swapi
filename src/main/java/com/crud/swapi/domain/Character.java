package com.crud.swapi.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "characters")
public class Character {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;
    @Column(name = "name")
    @NotNull
    private String name;
}

