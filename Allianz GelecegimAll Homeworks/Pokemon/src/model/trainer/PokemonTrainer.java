package model.trainer;

import model.pokemon.Pokemon;
import model.trainerskill.TrainerSkill;

import java.util.ArrayList;

public class PokemonTrainer {
    private String name;
    private TrainerSkill trainerSkill;
    private ArrayList<Pokemon> pokemonList;

    public PokemonTrainer(String name, TrainerSkill trainerSkill) {
        this.name = name;
        this.trainerSkill = trainerSkill;
        this.pokemonList = new ArrayList<>();
    }

    public void addPokemonToTrainer(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrainerSkill getTrainerSkill() {
        return trainerSkill;
    }

    public void setTrainerSkill(TrainerSkill trainerSkill) {
        this.trainerSkill = trainerSkill;
    }

    public ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(ArrayList<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    @Override
    public String toString() {
        StringBuilder pokemons = new StringBuilder();
        for (Pokemon pokemon : pokemonList) {
            pokemons.append(pokemon.toString()).append("\n");
        }
        return "Trainer " + name + "\n" +
                trainerSkill + "\n" +
                "Pokemon List: \n" + pokemons;
    }
}
