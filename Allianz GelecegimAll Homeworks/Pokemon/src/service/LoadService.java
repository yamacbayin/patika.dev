package service;

import model.ElementalTypeEnum;
import model.pokemonskill.*;
import model.trainer.Ash;
import model.trainer.Brock;
import model.trainer.Misty;
import model.trainer.PokemonTrainer;
import model.pokemon.*;
import model.trainerskill.Heal;
import model.trainerskill.Motivate;
import model.trainerskill.TrainerSkill;

import java.util.ArrayList;
import java.util.List;

public class LoadService {

    public List<TrainerSkill> loadTrainerSkills() {
        List<TrainerSkill> trainerSkillArrayList = new ArrayList<>();

        TrainerSkill heal = new Heal();
        TrainerSkill motivate = new Motivate();

        trainerSkillArrayList.add(heal);
        trainerSkillArrayList.add(motivate);

        return trainerSkillArrayList;
    }

    public List<PokemonTrainer> loadTrainers() {

        List<PokemonTrainer> pokemonTrainerArrayList = new ArrayList<>();

        PokemonTrainer ash = new Ash("Ash", new Motivate());
        PokemonTrainer brock = new Brock("Brock", new Motivate());
        PokemonTrainer misty = new Misty("Misty", new Heal());

        pokemonTrainerArrayList.add(ash);
        pokemonTrainerArrayList.add(brock);
        pokemonTrainerArrayList.add(misty);

        return pokemonTrainerArrayList;

    }

    public List<PokemonSkill> loadPokemonSkills() {
        List<PokemonSkill> pokemonSkillArrayList = new ArrayList<>();

        PokemonSkill spark = new Spark();
        PokemonSkill voltSwitch = new VoltSwitch();
        PokemonSkill thunder = new Thunder();

        pokemonSkillArrayList.add(spark);
        pokemonSkillArrayList.add(voltSwitch);
        pokemonSkillArrayList.add(thunder);

        PokemonSkill fireBlast = new FireBlast();
        PokemonSkill overheat = new Overheat();
        PokemonSkill flamethrower = new Flamethrower();

        pokemonSkillArrayList.add(fireBlast);
        pokemonSkillArrayList.add(overheat);
        pokemonSkillArrayList.add(flamethrower);

        PokemonSkill aquaJet = new AquaJet();
        PokemonSkill waterPulse = new WaterPulse();
        PokemonSkill hydroCannon = new HydroCannon();

        pokemonSkillArrayList.add(aquaJet);
        pokemonSkillArrayList.add(waterPulse);
        pokemonSkillArrayList.add(hydroCannon);

        PokemonSkill vineWhip = new VineWhip();
        PokemonSkill razorLeaf = new RazorLeaf();
        PokemonSkill frenzyPlant = new FrenzyPlant();

        pokemonSkillArrayList.add(vineWhip);
        pokemonSkillArrayList.add(razorLeaf);
        pokemonSkillArrayList.add(frenzyPlant);

        return pokemonSkillArrayList;
    }

    public ArrayList<Pokemon> loadPokemons() {

        Pokemon pikachu = new Pikachu("Pikachu", 110, 17, ElementalTypeEnum.ELECTRIC, 2);
        Pokemon charmander = new Charmander("Charmander", 150, 11, ElementalTypeEnum.FIRE, 2);
        Pokemon squirtle = new Squirtle("Squirtle", 120, 15, ElementalTypeEnum.WATER, 2);
        Pokemon bulbasaur = new Bulbasaur("Bulbasaur", 150, 11, ElementalTypeEnum.EARTH, 2);
        Pokemon raichu = new Raichu("Raichu", 220, 30, ElementalTypeEnum.ELECTRIC, 3);
        Pokemon charizard = new Charizard("Charizard", 270, 23, ElementalTypeEnum.FIRE, 3);
        Pokemon blastoise = new Blastoise("Blastoise", 225, 28, ElementalTypeEnum.WATER, 3);
        Pokemon venusaur = new Venusaur("Venusaur", 240, 25, ElementalTypeEnum.EARTH, 3);
        ArrayList<Pokemon> pokemonList = new ArrayList<>();

        pokemonList.add(pikachu);
        pokemonList.add(charmander);
        pokemonList.add(squirtle);
        pokemonList.add(bulbasaur);
        pokemonList.add(raichu);
        pokemonList.add(charizard);
        pokemonList.add(blastoise);
        pokemonList.add(venusaur);

        return pokemonList;
    }
}
