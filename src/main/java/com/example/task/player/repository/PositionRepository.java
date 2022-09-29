package com.example.task.player.repository;

import com.example.task.player.entity.EPosition;
import com.example.task.player.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
@Repository
public interface PositionRepository extends JpaRepository<Position, Id> {


    Position findTopByPosition(EPosition name);
}
