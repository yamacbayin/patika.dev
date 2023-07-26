package model;

import model.trainer.PokemonTrainer;

public class Player {
    private String name;
    private PokemonTrainer pokemonTrainer;
    private boolean isWinner;

    public Player(String name, PokemonTrainer pokemonTrainer) {
        this.name = name;
        this.pokemonTrainer = pokemonTrainer;
        this.isWinner = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonTrainer getCharacter() {
        return pokemonTrainer;
    }

    public void setCharacter(PokemonTrainer pokemonTrainer) {
        this.pokemonTrainer = pokemonTrainer;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", characters=" + pokemonTrainer +
                ", isWinner=" + isWinner +
                '}';
    }
}
