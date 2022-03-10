package com.example.task.builder;

import com.example.task.player.model.PlayerDTO;
import com.example.task.player.model.Position;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PlayerBuilder {
    private PlayerDTO playerDTO = new PlayerDTO();

    public PlayerBuilder buildSomeDummy(){
        /*this.playerDTO.setFirstName("hasan");
        this.playerDTO.setLastName("aktas");
        this.playerDTO.setPosition(Position.SHOOTING_GUARD);*/
        return this;
    }

    public PlayerBuilder withFirstName(String firstName){
        this.playerDTO.setFirstName(firstName);
        return this;
    }

    public PlayerBuilder withLastName(String lastName){
        this.playerDTO.setLastName(lastName);
        return this;
    }
    public PlayerBuilder withPosition(Position position){
        this.playerDTO.setPosition(position);
        return this;
    }

    public PlayerDTO build(){ return this.playerDTO; }
}
