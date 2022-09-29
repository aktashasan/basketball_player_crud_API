package com.example.task.player.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PlayerDTO implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private List<Position> positionList;
}
