package com.example.task.player.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class PositionMapperImpl implements Serializable {

    public static PositionDTO toDTO(Position position){

        if (position == null) {
            return null;
        }

        PositionDTO positionDTO = new PositionDTO();

        positionDTO.setId(position.getId());
        positionDTO.setPosition(position.getPosition());

        return positionDTO;
    }
     public static Position toEntity(PositionDTO positionDTO){

         if (positionDTO == null) {
             return null;
         }

         Position position = new Position();

         position.setId(positionDTO.getId());
         position.setPosition(positionDTO.getPosition());

         return position;
     }
}
