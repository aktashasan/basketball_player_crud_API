package com.example.task.player.service;

import com.example.task.builder.PlayerBuilder;
import com.example.task.player.model.PlayerDTO;
import com.example.task.player.model.Position;
import com.example.task.player.repository.PlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureDataJpa
class PlayerServiceTest {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void addPlayer() throws Exception {
        PlayerDTO playerDTO = new PlayerBuilder()
                .buildSomeDummy()
                .withFirstName("hasan")
                .withLastName("aktas")
                .withPosition(Position.CENTER)
                .build();
        PlayerDTO savedPlayer = playerService.addPlayer(playerDTO);
        System.out.println(savedPlayer);
        Assertions.assertNotNull(savedPlayer.getId());

    }

    @Test
    void findPlayerById() throws Exception {
        playerRepository.deleteAll();
        PlayerDTO playerDTO = new PlayerBuilder()
                .buildSomeDummy()
                .withFirstName("hasan")
                .withLastName("aktas")
                .withPosition(Position.CENTER)
                .build();
        PlayerDTO savedPlayer = playerService.addPlayer(playerDTO);
        PlayerDTO findPlayer = playerService.findPlayerById(savedPlayer.getId());
        System.out.println(findPlayer);
        Assertions.assertNotNull(findPlayer);
    }

    @Test
    void deletePlayerById() throws Exception {
        playerRepository.deleteAll();
        PlayerDTO playerDTO = new PlayerBuilder()
                .buildSomeDummy()
                .withFirstName("hasan")
                .withLastName("aktas")
                .withPosition(Position.CENTER)
                .build();
        PlayerDTO savedPlayer = playerService.addPlayer(playerDTO);
        Boolean deletedPlayer = playerService.deletePlayerById(savedPlayer.getId());
        Assertions.assertEquals(deletedPlayer,Boolean.TRUE);
    }

    @Test
    void findAllPlayer() throws Exception {
        playerRepository.deleteAll();
        PlayerDTO playerDTO = new PlayerBuilder()
                .buildSomeDummy()
                .withFirstName("hasan")
                .withLastName("aktas")
                .withPosition(Position.CENTER)
                .build();
        playerService.addPlayer(playerDTO);
        playerService.addPlayer(playerDTO);
        List<PlayerDTO> playerDTOList = playerService.findAllPlayer();
        System.out.println(playerDTOList);
        Assertions.assertEquals(2,playerDTOList.size());
    }
}