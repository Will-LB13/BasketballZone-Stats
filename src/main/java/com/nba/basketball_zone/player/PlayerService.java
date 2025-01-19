package com.nba.basketball_zone.player;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByTeam(String team){
        return playerRepository.findAll().stream().filter(player -> team.equals(player.getTeam()))
        .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String searchText){
        return playerRepository.findAll().stream().filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
        .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPosition(String searchText){
        return playerRepository.findAll().stream()
        .filter(player -> player.getPosition().toLowerCase().contains(searchText.toLowerCase()))
        .collect(Collectors.toList());
    }

    // public List<Player> getPlayersByAge(String searchText){

    //     try{
    //         int searchAge = Integer.parseInt(searchText);
    //     } catch (NumberFormatException e){
    //         System.out.println("Invalid input.");
    //         return playerRepository.findAll();
    //     }

    //     return playerRepository.findAll().stream().filter(player -> player.getPosition());
    // }

    public List<Player> getPlayersByTeamAndPosition(String team, String position){
        return playerRepository.findAll().stream()
        .filter(player -> team.equals(player.getTeam()) && position.equals(player.getPosition()))
        .collect(Collectors.toList());
    }

    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player player){
        Optional<Player> existingPlayer = playerRepository.findByName(player.getName());

        if(existingPlayer.isPresent()){
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(player.getName());
            playerToUpdate.setPosition(player.getPosition());
            playerToUpdate.setAge(player.getAge());
            playerToUpdate.setTeam(player.getTeam());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }

        return null;
    }

    @Transactional
    public void deletePlayer(String playerName){
        playerRepository.deleteByName(playerName);
    }
}
