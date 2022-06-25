package com.example.NRLApplication.controller;

import com.example.NRLApplication.dto.NrlTeamPlayersDto;
import com.example.NRLApplication.service.NrlTeamPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NrlTeamPlayersController {

    @Autowired
    public NrlTeamPlayerService nrlTeamPlayerService;

    public NrlTeamPlayersController(NrlTeamPlayerService nrlTeamPlayerService) {

        this.nrlTeamPlayerService = nrlTeamPlayerService;
    }

    /***************************************Save***************************************************/

    //savePlayers
    @RequestMapping("/api/savePlayer")
    @PostMapping
    public ResponseEntity savePlayer(@RequestBody NrlTeamPlayersDto dto) {

        return nrlTeamPlayerService.savePlayer(dto);
    }

    /***************************************Update***************************************************/

    //updatePlayers
    @RequestMapping("/api/updatePlayer/{playerName}")
    @PostMapping
    public ResponseEntity updatePlayer(@RequestBody NrlTeamPlayersDto dto, @PathVariable String playerName) {

        return nrlTeamPlayerService.updatePlayer(dto, playerName);
    }

    /***************************************Get***************************************************/

    //getAllPlayers
    @GetMapping("/api/allPlayers")
    @ResponseBody
    public List<NrlTeamPlayersDto> getAllPlayers() {

        return nrlTeamPlayerService.getAllPlayers();
    }

    //getPlayersByPlayerTeam
    @GetMapping("/api/playerTeam/{playerTeam}")
    @ResponseBody
    public List<NrlTeamPlayersDto> getPlayersByTeamName(@PathVariable String playerTeam) {

        return nrlTeamPlayerService.getPlayersByPlayerTeam(playerTeam);
    }

    //getPlayersByPlayerPosition
    @GetMapping("/api/playerPosition/{playerPosition}")
    @ResponseBody
    public List<NrlTeamPlayersDto> getPlayersByPlayerPosition(@PathVariable String playerPosition) {

        return nrlTeamPlayerService.getPlayersByPlayerPosition(playerPosition);
    }

    //getPlayersByPlayerNumber
    @GetMapping("/api/playerNumber/{playerNumber}")
    @ResponseBody
    public List<NrlTeamPlayersDto> getPlayersByPlayerPosition(@PathVariable long playerNumber) {

        return nrlTeamPlayerService.getPlayersByPlayerNumber(playerNumber);
    }

    //getPlayerByPlayerName
    @GetMapping("/api/playerName/{playerName}")
    @ResponseBody
    public NrlTeamPlayersDto getPlayersByPlayerName(@PathVariable String playerName) {

        return nrlTeamPlayerService.getPlayerByPlayerName(playerName);
    }
}