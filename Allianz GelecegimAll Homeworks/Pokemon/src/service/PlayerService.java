package service;

import model.trainer.PokemonTrainer;
import model.Player;

public class PlayerService {

    public Player createPlayer(String name, PokemonTrainer pokemonTrainer) {
        return new Player(name, pokemonTrainer);
    }



}
