package service;

import model.Player;
import model.pokemon.Pokemon;
import model.pokemonskill.PokemonSkill;
import model.trainer.PokemonTrainer;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The GameMaster class handles the main logic of the Pokémon game. It allows players to pick their trainers
 * and Pokémon, conducts battles between the players, and manages the exchange of Pokémon after each battle.
 * The class also keeps track of the number of wins required to finish the game and determines the ultimate
 * winner based on the win counts of the players.
 */
public class GameMaster {

    private Scanner scanner;
    private BattleService battleService;
    private LoadService loadService;
    private Player player1;
    private Player player2;
    private Random random;
    private List<Pokemon> pokemonList;
    private int p1WinCount = 0;
    private int p2WinCount = 0;
    private int battleCount = 1;
    private int pokemonLimit = 2;
    private int winsRequiredToFinish = 2;

    public GameMaster() {
        scanner = new Scanner(System.in);
        loadService = new LoadService();
        random = new Random();
        battleService = new BattleService(scanner, random);
        pokemonList = loadService.loadPokemons();
    }

    /**
     * Runs the Pokémon game by setting up players, picking Pokémon, conducting battles, and determining the winner.
     */
    public void run() {
        System.out.println("============ POKEMON ============");
        setPlayers();
        pickPokemon();
        while (p1WinCount < winsRequiredToFinish && p2WinCount < winsRequiredToFinish) {
            System.out.println("============ BATTLE " + battleCount + " ============");
            battleService.battle(player1, player2);
            refreshPokemonsAndTrainers();
            if (player1.isWinner()) {
                p1WinCount++;
                System.out.println(player1.getName() + " wins the battle! Total wins: " + p1WinCount);
                exchangePokemons(player1, player2);
            } else {
                p2WinCount++;
                System.out.println(player2.getName() + " wins the battle! Total wins: " + p2WinCount);
                exchangePokemons(player2, player1);
            }
            battleCount++;
        }

        if (p1WinCount == 2) {
            System.out.println(player1.getName() + " wins! "
                    + player1.getName() + " is the best Pokémon trainer of all time!");
        }
        if (p2WinCount == 2) {
            System.out.println(player2.getName() + " wins! "
                    + player2.getName() + " is the best Pokémon trainer of all time!");
        }

    }

    /**
     * Refreshes the health and skill uses of the Pokémon and trainers after each battle round.
     */
    private void refreshPokemonsAndTrainers() {
        player1.getPokemonTrainer().getTrainerSkill().refreshRemainingUses();
        player2.getPokemonTrainer().getTrainerSkill().refreshRemainingUses();
        for (Pokemon pokemon : player1.getPokemonTrainer().getPokemonList()) {
            pokemon.healCompletely();
            for (PokemonSkill pokemonSkill : pokemon.getPokemonSkillList()) {
                pokemonSkill.refreshRemainingUses();
            }
        }
        for (Pokemon pokemon : player2.getPokemonTrainer().getPokemonList()) {
            pokemon.healCompletely();
            for (PokemonSkill pokemonSkill : pokemon.getPokemonSkillList()) {
                pokemonSkill.refreshRemainingUses();
            }
        }
    }

    /**
     * Exchanges Pokémon between the winning and defeated players after each battle.
     * The winner gets the best Pokémon of the defeated player.
     * The defeated player gets the worst Pokémon in the game in exchange.
     *
     * @param winnerPlayer   The player who won the battle.
     * @param defeatedPlayer The player who lost the battle.
     */
    private void exchangePokemons(Player winnerPlayer, Player defeatedPlayer) {
        int bestPokemonOfDefeatedPlayer = 0;
        int bestPokemonStrength = 0;
        // find the best pokemon of the defeated player
        for (int i = 0; i < defeatedPlayer.getPokemonTrainer().getPokemonList().size(); i++) {
            if (defeatedPlayer.getPokemonTrainer().getPokemonList().get(i).getPokemonStrength() > bestPokemonStrength) {
                bestPokemonStrength = defeatedPlayer.getPokemonTrainer().getPokemonList().get(i).getPokemonStrength();
                bestPokemonOfDefeatedPlayer = i;
            }
        }
        Pokemon fromDefeatedToWinner = defeatedPlayer.getPokemonTrainer().getPokemonList().get(bestPokemonOfDefeatedPlayer);
        defeatedPlayer.getPokemonTrainer().getPokemonList().remove(bestPokemonOfDefeatedPlayer);
        winnerPlayer.getPokemonTrainer().getPokemonList().add(fromDefeatedToWinner);

        int weakestPokemonOfWinnerIndex = 0;
        int weakestPokemonStrength = Integer.MAX_VALUE;
        for (int i = 0; i < winnerPlayer.getPokemonTrainer().getPokemonList().size(); i++) {
            if (winnerPlayer.getPokemonTrainer().getPokemonList().get(i).getPokemonStrength() < weakestPokemonStrength) {
                weakestPokemonStrength = winnerPlayer.getPokemonTrainer().getPokemonList().get(i).getPokemonStrength();
                weakestPokemonOfWinnerIndex = i;
            }
        }
        Pokemon fromWinnerToPokemonList = winnerPlayer.getPokemonTrainer().getPokemonList().get(weakestPokemonOfWinnerIndex);
        winnerPlayer.getPokemonTrainer().getPokemonList().remove(weakestPokemonOfWinnerIndex);
        pokemonList.add(fromWinnerToPokemonList);

        System.out.println(winnerPlayer.getName() + " receives " + defeatedPlayer.getName()
                + "'s best Pokémon " + fromDefeatedToWinner.getName() + ".");
        System.out.println(winnerPlayer.getName() + "'s weakest Pokémon " + fromWinnerToPokemonList.getName() +
                " returns to the pokemon list.");

        int worstPokemonIndex = 0;
        int worstPokemonStrength = Integer.MAX_VALUE;
        for (int i = 0; i < pokemonList.size(); i++) {
            if (pokemonList.get(i).getPokemonStrength() < worstPokemonStrength) {
                worstPokemonStrength = pokemonList.get(i).getPokemonStrength();
                worstPokemonIndex = i;
            }
        }
        Pokemon fromPokemonListToDefeated = pokemonList.get(worstPokemonIndex);
        pokemonList.remove(worstPokemonIndex);
        defeatedPlayer.getPokemonTrainer().getPokemonList().add(fromPokemonListToDefeated);
        System.out.println(defeatedPlayer.getName() + " gets " + fromPokemonListToDefeated.getName()
                + ", the worst Pokémon in the game.");
    }

    /**
     * Sets up the players for the Pokémon game by allowing them to pick their names and trainers.
     */
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

    }

    private void printList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    /**
     * Sets the first player's name and allows them to pick a Pokémon trainer from the available list.
     *
     * @param player1Name        The name of the first player.
     * @param pokemonTrainerList The list of available Pokémon trainers.
     */
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

    /**
     * Sets the second player's name and allows them to pick a Pokémon trainer from the available list.
     *
     * @param player2Name        The name of the second player.
     * @param pokemonTrainerList The list of available Pokémon trainers.
     */
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

    /**
     * Allows the players to pick their Pokémon by choosing from the available list.
     */
    private void pickPokemon() {


        boolean player1picksFirst = random.nextBoolean();

        if (player1picksFirst) {
            while (player1.getPokemonTrainer().getPokemonList().size() < pokemonLimit &&
                    player2.getPokemonTrainer().getPokemonList().size() < pokemonLimit) {
                choosePokemon(player1);
                choosePokemon(player2);
            }
        } else {
            while (player1.getPokemonTrainer().getPokemonList().size() < pokemonLimit &&
                    player2.getPokemonTrainer().getPokemonList().size() < pokemonLimit) {
                choosePokemon(player2);
                choosePokemon(player1);
            }
        }

        addSkillsToRemainingPokemons();

        System.out.println("-------------------------------------------------");
        System.out.println(player1);
        System.out.println("-------------------------------------------------");
        System.out.println(player2);
        System.out.println("-------------------------------------------------");

        System.out.println("The remanining Pokémon's get random skills.");
    }


    /**
     * Allows a player to choose a Pokémon from the available list and add it to their Pokémon trainer's team.
     *
     * @param player The player who is choosing the Pokémon.
     */
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

    /**
     * Allows a player to choose skills for a selected Pokémon from the available list of skills.
     *
     * @param pokemon The selected Pokémon for which the player is choosing skills.
     */
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

    /**
     * Adds skills to the remaining Pokémon in the available list after players have made their selections.
     */
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
