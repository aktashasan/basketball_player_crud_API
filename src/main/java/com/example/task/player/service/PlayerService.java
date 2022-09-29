package com.example.task.player.service;

import com.example.task.player.entity.*;
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

    @Autowired
    private final PositionService positionService;

    public PlayerDTO addPlayer(PlayerDTO playerDTO) throws Exception{
        if (playerDTO.getFirstName() == null && playerDTO.getLastName() == null ) {
            throw  new Exception("Tüm alanlar Boş olamaz!");
        }
        else if (playerDTO.getFirstName() == null) {
           throw  new Exception("İsim Boş olamaz!");
        }
        else if(playerDTO.getLastName() == null){
            throw new Exception("Soyadı alanı boş olamaz!");
        }
        List<Position> positionListToSave = new ArrayList<>();

        List<Position> positionList = playerDTO.getPositionList();
        if (positionList != null && !positionList.isEmpty()) {
            for (Position item : positionList) {
                Position position = positionService.findTopByName(item.getPosition());
                if (position == null) {
                    positionService.savePosition(item);
                    positionListToSave.add(item);
                } else if (position.getPosition() != null) {
                    positionListToSave.add(position);
                }
            }
        }
        if (positionListToSave != null && !positionListToSave.isEmpty()) {
            playerDTO.setPositionList(positionListToSave);
        }

        Player player = playerRepository.save(PlayerMapperImpl.toEntity(playerDTO));
        return PlayerMapperImpl.toDTO(player);
    }

    public PlayerDTO findPlayerById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("Id boş olamaz!");
        }
        Optional<Player> optional = playerRepository.findById(id);

        if (optional.isPresent()) {
            Player player = optional.get();
            return PlayerMapperImpl.toDTO(player);
        }
        return null;
    }

    public Boolean deletePlayerById(Long id) throws Exception {
        if (id == null ) {
            throw new Exception("Id boş olamaz!");
        }
        playerRepository.deleteById(id);

        return Boolean.TRUE;

    }

    public List<PlayerDTO> findAllPlayer() throws Exception {
        List<Player> playerList = playerRepository.findAll();
        if(playerList.size() == 0){
            throw new Exception("Liste boş olamaz!");
        }
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        for(Player player:playerList){
            playerDTOList.add(PlayerMapperImpl.toDTO(player));
        }
        return playerDTOList;
    }


}
