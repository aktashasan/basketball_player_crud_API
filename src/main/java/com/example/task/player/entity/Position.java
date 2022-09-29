package com.example.task.player.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "positions")
@Data
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private EPosition position;

}
