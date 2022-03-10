package com.example.task.player.controller;

import com.example.task.player.model.PlayerDTO;
import com.example.task.player.service.PlayerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/app")
@AllArgsConstructor
public class PlayerResource {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/player/save")
    public ResponseEntity<PlayerDTO> addPlayer(@RequestBody PlayerDTO playerDTO) throws Exception {
        PlayerDTO savedPlayer = playerService.addPlayer(playerDTO);
        return savedPlayer == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(savedPlayer);

    }

    @GetMapping("/player/delete/{id}")
    public ResponseEntity<Boolean> deletePlayerById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(playerService.deletePlayerById(id));
    }

    @GetMapping("/players/get")
    public ResponseEntity<List<PlayerDTO>> findAllPlayers() throws Exception {
        return ResponseEntity.ok(playerService.findAllPlayer());
    }
}
