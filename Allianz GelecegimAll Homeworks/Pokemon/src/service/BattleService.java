package service;

import model.Player;
import model.WeatherTypeEnum;
import model.pokemon.Pokemon;
import model.pokemonskill.PokemonSkill;
import model.trainer.PokemonTrainer;
import model.trainerskill.TrainerSkillTypeEnum;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The BattleService class represents a service that manages Pokémon battles between two players.
 * It handles the flow of the battle, including player and Pokémon selection, attacks, weather effects,
 * and determining the winner of the battle.
 */
public class BattleService {

    private Scanner scanner;
    private Random random;
    private Player player1;
    private Player player2;
    private WeatherTypeEnum weather;
    /**
     * The extra damage caused by the weather effect.
     */
    private int weatherExtraDamage = 0;

    /**
     * Constructs a BattleService object with the given Scanner and Random objects.
     *
     * @param scanner The Scanner object to read user input during the battle.
     * @param random  The Random object to generate random events during the battle.
     */
    public BattleService(Scanner scanner, Random random) {
        this.scanner = scanner;
        this.random = random;
    }

    /**
     * Checks if the battle is over by calculating the total health of each player's Pokémon.
     *
     * @param p1PokemonList The list of Pokémon belonging to the first player.
     * @param p2PokemonList The list of Pokémon belonging to the second player.
     * @return true if the battle is over, false otherwise.
     */
    private boolean checkBattleOver(List<Pokemon> p1PokemonList, List<Pokemon> p2PokemonList) {
        int p1TotalHealth = 0;
        int p2TotalHealth = 0;

        for (Pokemon pokemon : p1PokemonList) {
            p1TotalHealth += pokemon.getCurrentHealth();
        }

        for (Pokemon pokemon : p2PokemonList) {
            p2TotalHealth += pokemon.getCurrentHealth();
        }

        if (p1TotalHealth <= 0) {
            player2.setWinner(true);
            return true;
        }
        if (p2TotalHealth <= 0) {
            player1.setWinner(true);
            return true;
        }
        return false;
    }

    /**
     * Starts the battle between the given players.
     * Randomly selects a player to attack first on each round.
     *
     * @param p1 The first player.
     * @param p2 The second player.
     */
    public void battle(Player p1, Player p2) {

        player1 = p1;
        player2 = p2;
        System.out.println("======== POKEMON BATTLE BEGINS ========");

        int round = 1;
        boolean isBattleOver = false;
        while (!isBattleOver) {
            changeWeather();
            boolean player1AttacksFirst = random.nextBoolean();
            System.out.println("Round " + round + "! Players must select pokemons to fight!");
            Pokemon p1SelectedPokemon;
            Pokemon p2SelectedPokemon;
            if (player1AttacksFirst) {
                System.out.println("Player " + player1.getName() + " attacks first!");
                p1SelectedPokemon = selectPokemon(player1);
                p2SelectedPokemon = selectPokemon(player2);
                attack(player1, p1SelectedPokemon, p2SelectedPokemon);
                attack(player2, p2SelectedPokemon, p1SelectedPokemon);
            } else {
                System.out.println("Player " + player2.getName() + " attacks first!");
                p2SelectedPokemon = selectPokemon(player2);
                p1SelectedPokemon = selectPokemon(player1);
                attack(player2, p2SelectedPokemon, p1SelectedPokemon);
                attack(player1, p1SelectedPokemon, p2SelectedPokemon);
            }
            System.out.println("Round " + round + " ends! Check your pokemons!");
            System.out.println(p1SelectedPokemon.getPokemonInfo());
            System.out.println(p2SelectedPokemon.getPokemonInfo());
            round++;
            isBattleOver = checkBattleOver(player1.getPokemonTrainer().getPokemonList(),
                    player2.getPokemonTrainer().getPokemonList());
        }
    }

    private void printList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    private Pokemon selectPokemon(Player player) {
        System.out.println("Player " + player.getName() + " selects a pokemon. Enter the pokemon number: ");
        List<Pokemon> availablePokemons = player.getPokemonTrainer().getPokemonList();
        printList(availablePokemons);
        boolean canSelectedPokemonFight = false;
        int selectedPokemon = 0;
        while (!canSelectedPokemonFight) {
            do {
                selectedPokemon = scanner.nextInt();
                --selectedPokemon;
                scanner.nextLine();
            } while (selectedPokemon < 0 || selectedPokemon >= availablePokemons.size());
            if (availablePokemons.get(selectedPokemon).getCurrentHealth() <= 0) {
                System.out.println(availablePokemons.get(selectedPokemon).getName() +
                        " cannot fight anymore! Select another pokemon...");
            } else {
                canSelectedPokemonFight = true;
            }
        }
        return availablePokemons.get(selectedPokemon);
    }

    /**
     * Performs an attack by the given attacker Pokémon on the defender Pokémon, considering weather effects,
     * trainer skills, and Pokémon skills. The method calculates the damage caused by the attack and updates
     * the defender Pokémon's health accordingly.
     *
     * @param attacker        The player who is attacking.
     * @param attackerPokemon The Pokémon of the attacker.
     * @param defenderPokemon The Pokémon of the defender.
     */
    public void attack(Player attacker, Pokemon attackerPokemon, Pokemon defenderPokemon) {

        System.out.println("Player " + attacker.getName() + " attacks!");
        // Get the attacker's trainer.
        PokemonTrainer attackerTrainer = attacker.getPokemonTrainer();

        // Determine if the attacker will use their trainer skill or Pokémon skill or both.
        boolean useTrainerSkill = useTrainerSkill();
        boolean usePokemonSkill = usePokemonSkill();
        PokemonSkill pokemonSkillToUse = null;
        // If the attacker uses a Pokémon skill, let the attacker choose which skill to use.
        if (usePokemonSkill) {
            pokemonSkillToUse = selectPokemonSkill(attackerPokemon);
        }

        // Initialize damage caused by the attack.
        int damage = 0;

        // If the attacker's Pokémon type matches the weather type, increase the damage.
        if (weather.getString().equalsIgnoreCase(attackerPokemon.getPokemonType().getTypeString())) {
            System.out.println("The weather increases " + attackerPokemon.getName() + "'s attack by "
                    + weatherExtraDamage + "!");
            damage += weatherExtraDamage;
        }

        // Determine if the attacker should be punished for attempting to use a skill with no remaining uses.
        boolean punishPlayer = (usePokemonSkill && pokemonSkillToUse.getRemainingUses() <= 0)
                || (useTrainerSkill && attackerTrainer.getTrainerSkill().getRemainingUses() <= 0);

        // If the attacker is punished, set the damage to 0.
        if (punishPlayer) {
            System.out.println(attacker.getName() + "  gets punished for attempting to use a skill with no remaining uses.");
            damage = 0;
        } else {
            // If the attacker uses a Pokémon skill, increase the damage and decrement the remaining uses of the skill.
            if (usePokemonSkill) {
                System.out.println(attackerPokemon.getName() + " uses " + pokemonSkillToUse.getSkillName()
                        + ". The damage increases by " + pokemonSkillToUse.getExtraDamage() + "!");
                damage += pokemonSkillToUse.getExtraDamage();
                pokemonSkillToUse.decreaseRemainingUses();
            }
            // If the attacker uses a trainer skill, apply the skill effect to increase the damage or heal the Pokémon.
            if (useTrainerSkill) {
                if (attackerTrainer.getTrainerSkill().getSkillType() == TrainerSkillTypeEnum.DAMAGE) {

                    System.out.println(attackerTrainer.getName() + " uses special power "
                            + attackerTrainer.getTrainerSkill().getSkillName()
                            + " increases " + attackerPokemon.getName() + "'s attack by "
                            + attackerTrainer.getTrainerSkill().getSkillEffectAmount());

                    damage += attackerTrainer.getTrainerSkill().getSkillEffectAmount();
                    attackerTrainer.getTrainerSkill().decreaseRemainingUses();
                }
                if (attackerTrainer.getTrainerSkill().getSkillType() == TrainerSkillTypeEnum.HEAL) {
                    System.out.println(attackerTrainer.getName() + "  uses her special power, "
                            + attackerTrainer.getTrainerSkill().getSkillName()
                            + " and restores " + attackerTrainer.getTrainerSkill().getSkillEffectAmount()
                            + " health points to " + attackerPokemon.getName() + ".");
                    attackerPokemon.heal(attackerTrainer.getTrainerSkill().getSkillEffectAmount());
                    attackerTrainer.getTrainerSkill().decreaseRemainingUses();
                }
            }
            // Add the normal damage of the attacker's Pokémon to the overall damage.
            damage += attackerPokemon.getNormalDamage();
        }

        // Print the damage caused by the attack and update the defender's Pokémon health.
        System.out.println(attackerPokemon.getName() + " hits " + defenderPokemon.getName() + " for " + damage + "!");
        defenderPokemon.takeDamage(damage);
    }

    private boolean useTrainerSkill() {
        boolean selection = false;
        boolean runLoop = true;
        while (runLoop) {
            System.out.print("Do you want to use your Trainer's skill? [y/N]: ");

            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "y", "yes" -> {
                    selection = true;
                    runLoop = false;
                }
                case "n", "no" -> runLoop = false;
                default -> System.out.println("Unknown command.");
            }
        }
        return selection;
    }

    private boolean usePokemonSkill() {
        boolean selection = false;
        boolean runLoop = true;
        while (runLoop) {
            System.out.print("Do you want to use a Pokémon skill? [y/N]: ");

            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "y", "yes" -> {
                    selection = true;
                    runLoop = false;
                }
                case "n", "no" -> runLoop = false;
                default -> System.out.println("Unknown command.");
            }
        }
        return selection;
    }

    private PokemonSkill selectPokemonSkill(Pokemon pokemon) {
        System.out.println("Select a skill for " + pokemon.getName() + " to use. Enter the number: ");
        printList(pokemon.getPokemonSkillList());
        int selectedSkill;
        do {
            selectedSkill = scanner.nextInt();
            --selectedSkill;
            scanner.nextLine();
        } while (selectedSkill < 0 || selectedSkill >= pokemon.getPokemonSkillList().size());

        return pokemon.getPokemonSkillList().get(selectedSkill);
    }

    /**
     * Changes the weather in the battle to a random type and generates the extra damage caused by the weather.
     */
    private void changeWeather() {
        int randomInt = random.nextInt(4);
        weatherExtraDamage = random.nextInt(10) + 10;
        if (randomInt == 0) {
            weather = WeatherTypeEnum.RAIN;
            System.out.println("It starts to rain!  Increases water-type Pokémon's attack by " + weatherExtraDamage + ".");
        } else if (randomInt == 1) {
            weather = WeatherTypeEnum.SUNNY;
            System.out.println("The sun starts to shine! Increases fire-type Pokémon's attack by "
                    + weatherExtraDamage + ".");
        } else if (randomInt == 2) {
            weather = WeatherTypeEnum.THUNDERSTORM;
            System.out.println("A thunderstorm begins! Increases electric-type Pokémon's attack by "
                    + weatherExtraDamage + ".");
        } else {
            weather = WeatherTypeEnum.SANDSTORM;
            System.out.println("A sandstorm begins! Increases earth-type Pokémon's attack by "
                    + weatherExtraDamage + ".");
        }
    }


}
