package com.example.task.player.service;

import com.example.task.player.entity.EPosition;
import com.example.task.player.entity.Position;
import com.example.task.player.repository.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public Position savePosition(Position position) throws Exception {

        if (position.getPosition() == null) {
            throw new Exception("Oyuncu pozisyonunu null olamaz");
        }
        return positionRepository.save(position);

    }
    public Position findTopByName(EPosition name) {

        return positionRepository.findTopByPosition(name);
    }
}
