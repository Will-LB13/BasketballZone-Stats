package com.nba.basketball_zone.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
        @RequestParam(required = false) String name, @RequestParam(required = false) String team,
        @RequestParam(required = false) String position, @RequestParam(required = false) String age){

            if(team != null && position != null){
                return playerService.getPlayersByTeamAndPosition(team, position);
            } else if(team != null){
                return playerService.getPlayersByTeam(team);
            } else if(position != null){
                return playerService.getPlayersByPosition(position);
            } else if(name != null){
                return playerService.getPlayersByName(name);
            // } else if (age != null){
            //     return playerService.getPlayersByAge(age);
            } else{
                return playerService.getPlayers();
            }
        }

        @PostMapping
        public ResponseEntity<Player> addPlayer(@RequestBody Player player){
            Player newPlayer = playerService.addPlayer(player);
            return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
        }

        @PutMapping
        public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
            Player resultPlayer = playerService.updatePlayer(player);

            if(resultPlayer != null){
                return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
            } else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        //Handles http request to delete player by name
        @DeleteMapping("/{playerName}")
        public ResponseEntity<String> deletePlayer(@PathVariable String playerName){
            playerService.deletePlayer(playerName);
            return new ResponseEntity<>("Player Deleted Successfully", HttpStatus.OK);
        }
}
