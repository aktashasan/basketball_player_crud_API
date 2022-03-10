package com.example.task.player.controller;

import com.example.task.builder.PlayerBuilder;
import com.example.task.player.model.PlayerDTO;
import com.example.task.player.model.Position;
import com.example.task.player.repository.PlayerRepository;
import com.example.task.player.service.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
class PlayerResourceTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void addPlayer() throws Exception {
        playerRepository.deleteAll();
        PlayerDTO playerDTO = new PlayerBuilder()
                .buildSomeDummy()
                .withFirstName("hasan")
                .withLastName("aktas")
                .withPosition(Position.CENTER)
                .build();

        String jsonPlayer = objectMapper.writeValueAsString(playerDTO);

        ResultActions resultActions = this.mockMvc
                .perform(post("/app/player/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPlayer))
                .andDo(print())
                .andExpect(status().isOk());
        MvcResult mvcResult = resultActions.andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();

        PlayerDTO result = objectMapper.readValue(contentAsString, PlayerDTO.class);
        Assertions.assertNotNull(result.getId());
    }

    @Test
    void deletePlayerById() throws Exception{
        PlayerDTO playerDTO = new PlayerBuilder()
                .buildSomeDummy()
                .withFirstName("hasan")
                .withLastName("aktas")
                .withPosition(Position.CENTER)
                .build();
        PlayerDTO savedPlayer = playerService.addPlayer(playerDTO);

        ResultActions resultActions = this.mockMvc
                .perform(get("/app/player/delete/" + savedPlayer.getId()))
                .andDo(print())
                .andExpect(status().isOk());
        MvcResult mvcResult = resultActions.andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();

        Boolean result = objectMapper.readValue(contentAsString, Boolean.class);
        Assertions.assertEquals(Boolean.TRUE,result);
    }

    @Test
    void findAllPlayers() throws Exception{
        playerRepository.deleteAll();
        PlayerDTO playerDTO = new PlayerBuilder()
                .buildSomeDummy()
                .withFirstName("hasan")
                .withLastName("aktas")
                .withPosition(Position.CENTER)
                .build();
        PlayerDTO savedPlayer = playerService.addPlayer(playerDTO);

        ResultActions resultActions = this.mockMvc
                .perform(get("/app/players/get"))
                .andDo(print())
                .andExpect(status().isOk());
        MvcResult mvcResult = resultActions.andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();

        List<PlayerDTO> result = objectMapper.readValue(contentAsString, List.class);
        Assertions.assertEquals(1,result.size());
    }
}