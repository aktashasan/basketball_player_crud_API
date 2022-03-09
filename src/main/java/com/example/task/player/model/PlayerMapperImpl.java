package com.example.task.player.model;


import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class PlayerMapperImpl implements Serializable {

    public static PlayerDTO toDTO(Player player){
        if (player == null) {
            return null;
        }
        PlayerDTO playerDTO = new PlayerDTO();

        playerDTO.setId(player.getId());
        playerDTO.setFirstName(player.getFirstName());
        playerDTO.setLastName(player.getLastName());
        playerDTO.setPosition(player.getPosition());

        return playerDTO;
    }

    public static Player toEntity(PlayerDTO playerDTO){
        if (playerDTO == null) {
            return null;
        }

        Player player = new Player();

        player.setId(playerDTO.getId());
        player.setFirstName(playerDTO.getFirstName());
        player.setLastName(playerDTO.getLastName());
        player.setPosition(playerDTO.getPosition());

        return player;
    }
}
