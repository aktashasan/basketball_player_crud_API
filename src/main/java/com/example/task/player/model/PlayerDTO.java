package com.example.task.player.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerDTO implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Position position;
}
