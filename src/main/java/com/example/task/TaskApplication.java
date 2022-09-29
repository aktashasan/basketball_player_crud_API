package com.example.task;


import com.example.task.player.entity.EPosition;
import com.example.task.player.entity.Position;
import com.example.task.player.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@SpringBootApplication
public class TaskApplication {

    @Autowired
    private PositionService service;

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    @PostConstruct
    // If you want to run code-first,you should add this annotation.
    public void init() throws Exception {

        if (service.findTopByName(EPosition.CENTER) == null) {
            Position position = new Position();
            position.setPosition(EPosition.CENTER);
            service.savePosition(position);
        }
        if (service.findTopByName(EPosition.POINT_GUARD) == null) {
            Position position = new Position();
            position.setPosition(EPosition.POINT_GUARD);
            service.savePosition(position);
        }
        if (service.findTopByName(EPosition.POWER_FORWARD) == null) {
            Position position = new Position();
            position.setPosition(EPosition.POWER_FORWARD);
            service.savePosition(position);
        }
        if (service.findTopByName(EPosition.SHOOTING_GUARD) == null) {
            Position position = new Position();
            position.setPosition(EPosition.SHOOTING_GUARD);
            service.savePosition(position);
        }
        if (service.findTopByName(EPosition.SMALL_FORWARD) == null) {
            Position position = new Position();
            position.setPosition(EPosition.SMALL_FORWARD);
            service.savePosition(position);
        }


    }
}
