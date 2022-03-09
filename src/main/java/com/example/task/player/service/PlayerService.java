package com.example.task.player.service;

import com.example.task.player.model.Player;
import com.example.task.player.model.PlayerDTO;
import com.example.task.player.model.PlayerMapperImpl;
import com.example.task.player.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {

    @Autowired
    private final PlayerRepository playerRepository;

    public PlayerDTO addPlayer(PlayerDTO playerDTO){
        Player player = playerRepository.save(PlayerMapperImpl.toEntity(playerDTO));
        return PlayerMapperImpl.toDTO(player);
    }

    public PlayerDTO findPlayerById(Long id){
        Optional<Player> optional = playerRepository.findById(id);

        if (optional.isPresent()) {
            Player player = optional.get();
            return PlayerMapperImpl.toDTO(player);
        }
        return null;
    }

    public Boolean deletePlayerById(Long id){
        playerRepository.deleteById(id);

        return findPlayerById(id) == null ? Boolean.TRUE : Boolean.FALSE;

    }

    public List<PlayerDTO> findAllPlayer(){
        List<Player> playerList = playerRepository.findAll();
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        for(Player player:playerList){
            playerDTOList.add(PlayerMapperImpl.toDTO(player));
        }
        return playerDTOList;
    }


}
