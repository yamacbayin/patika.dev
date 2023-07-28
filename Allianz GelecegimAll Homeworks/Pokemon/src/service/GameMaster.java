package service;

import model.Player;
import model.pokemon.Pokemon;
import model.pokemonskill.PokemonSkill;
import model.trainer.PokemonTrainer;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameMaster {

    private Scanner scanner;
    private BattleService battleService;
    private LoadService loadService;
    private Player player1;
    private Player player2;
    private Random random;
    private List<Pokemon> pokemonList;

    public GameMaster() {
        scanner = new Scanner(System.in);
        loadService = new LoadService();
        random = new Random();
        battleService = new BattleService(scanner, random);
        pokemonList = loadService.loadPokemons();
    }

    public void run() {
        System.out.println("============ POKEMON ============");
        setPlayers();
        pickPokemon();
        battleService.battle(player1, player2);
    }

    private void setPlayers() {
        System.out.println("Enter a name for the first player: ");
        String player1Name = scanner.nextLine();
        System.out.println("Enter a name for the second player: ");
        String player2Name = scanner.nextLine();

        List<PokemonTrainer> pokemonTrainerList = loadService.loadTrainers();

        boolean player1picksFirst = random.nextBoolean();

        if (player1picksFirst) {
            setPlayer1(player1Name, pokemonTrainerList);
            setPlayer2(player2Name, pokemonTrainerList);
        } else {
            setPlayer2(player2Name, pokemonTrainerList);
            setPlayer1(player1Name, pokemonTrainerList);
        }

        System.out.println(player1);
        System.out.println(player2);


    }

    private void printList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    private void setPlayer1(String player1Name, List<PokemonTrainer> pokemonTrainerList) {
        System.out.println(player1Name + " picks a Pokemon Trainer. Enter a trainer's number to pick: ");
        printList(pokemonTrainerList);
        int trainerNumber;
        do {
            trainerNumber = scanner.nextInt();
            --trainerNumber;
        } while (trainerNumber < 0 || trainerNumber >= pokemonTrainerList.size());

        player1 = new Player(player1Name, pokemonTrainerList.get(trainerNumber));
        pokemonTrainerList.remove(trainerNumber);
    }

    private void setPlayer2(String player2Name, List<PokemonTrainer> pokemonTrainerList) {
        System.out.println(player2Name + " picks a Pokemon Trainer. Enter a trainer's number to pick: ");
        printList(pokemonTrainerList);
        int trainerNumber;
        do {
            trainerNumber = scanner.nextInt();
            --trainerNumber;
        } while (trainerNumber < 0 || trainerNumber >= pokemonTrainerList.size());

        player2 = new Player(player2Name, pokemonTrainerList.get(trainerNumber));
        pokemonTrainerList.remove(trainerNumber);
    }

    private void pickPokemon() {


        boolean player1picksFirst = random.nextBoolean();

        if (player1picksFirst) {
            while (player1.getPokemonTrainer().getPokemonList().size() < 2 &&
                    player2.getPokemonTrainer().getPokemonList().size() < 2) {
                choosePokemon(player1);
                choosePokemon(player2);
            }
        } else {
            while (player1.getPokemonTrainer().getPokemonList().size() < 2 &&
                    player2.getPokemonTrainer().getPokemonList().size() < 2) {
                choosePokemon(player2);
                choosePokemon(player1);
            }
        }

        addSkillsToRemainingPokemons();


        System.out.println(player1);
        System.out.println(player2);

        System.out.println(pokemonList);
    }

    private void choosePokemon(Player player) {
        System.out.println("Player " + player.getName() + " picks a Pokemon. Enter the pokemon's number to pick: ");
        printList(pokemonList);
        int pokemonNumber;
        do {
            pokemonNumber = scanner.nextInt();
            --pokemonNumber;
        } while (pokemonNumber < 0 || pokemonNumber >= pokemonList.size());

        Pokemon selectedPokemon = pokemonList.get(pokemonNumber);
        choosePokemonSkill(selectedPokemon);
        player.getPokemonTrainer().addPokemonToTrainer(selectedPokemon);
        pokemonList.remove(pokemonNumber);
    }

    private void choosePokemonSkill(Pokemon pokemon) {
        List<PokemonSkill> availablePokemonSkills = new java.util.ArrayList<>(loadService.loadPokemonSkills().stream().
                filter(pokemonSkill -> pokemonSkill.getSkillType() == pokemon.getPokemonType()).toList());
        if (pokemon.getMaxSkillCount() == 3) {
            System.out.println("Pokemon " + pokemon.getName() + " gets all the skills!");
            for (PokemonSkill skill : availablePokemonSkills) {
                pokemon.addSkill(skill);
            }
        } else {
            while (pokemon.getPokemonSkillList().size() < pokemon.getMaxSkillCount()) {
                System.out.println("Pick a skill for your pokemon. Enter the skill number: ");
                printList(availablePokemonSkills);
                int skillNumber;
                do {
                    skillNumber = scanner.nextInt();
                    --skillNumber;
                } while (skillNumber < 0 || skillNumber >= availablePokemonSkills.size());
                pokemon.addSkill(availablePokemonSkills.get(skillNumber));
                availablePokemonSkills.remove(skillNumber);
            }
        }
    }

    private void addSkillsToRemainingPokemons() {
        for (Pokemon pokemon : pokemonList) {
            List<PokemonSkill> availablePokemonSkills = new java.util.ArrayList<>(loadService.loadPokemonSkills().stream().
                    filter(pokemonSkill -> pokemonSkill.getSkillType() == pokemon.getPokemonType()).toList());
            if (pokemon.getMaxSkillCount() == 3) {
                for (PokemonSkill skill : availablePokemonSkills) {
                    pokemon.addSkill(skill);
                }
            } else {
                while (pokemon.getPokemonSkillList().size() < pokemon.getMaxSkillCount()) {
                    int randomSkill = random.nextInt(availablePokemonSkills.size());
                    pokemon.addSkill(availablePokemonSkills.get(randomSkill));
                    availablePokemonSkills.remove(randomSkill);
                }
            }
        }

    }


}
