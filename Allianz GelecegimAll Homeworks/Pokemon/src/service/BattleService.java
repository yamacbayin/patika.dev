package service;

import model.Player;
import model.pokemon.Pokemon;
import model.pokemonskill.PokemonSkill;
import model.trainer.PokemonTrainer;
import model.trainerskill.TrainerSkillTypeEnum;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleService {

    private Scanner scanner;
    private Random random;
    private Player player1;
    private Player player2;

    public BattleService(Scanner scanner, Random random) {
        this.scanner = scanner;
        this.random = random;
    }


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

    public void battle(Player p1, Player p2) {

        player1 = p1;
        player2 = p2;
        System.out.println("======== POKEMON BATTLE BEGINS ========");

        int round = 1;
        boolean isBattleOver = false;
        while (!isBattleOver) {
            boolean player1AttacksFirst = random.nextBoolean();
            System.out.println("Round " + round + "! Players must select pokemons to fight!");
            Pokemon p1SelectedPokemon;
            Pokemon p2SelectedPokemon;
            if (player1AttacksFirst) {
                System.out.println("Player " + player1.getName() + " attacks first!");
                p1SelectedPokemon = selectPokemon(player1);
                p2SelectedPokemon = selectPokemon(player2);
                attack(player1, p1SelectedPokemon, player2, p2SelectedPokemon);
                attack(player2, p2SelectedPokemon, player1, p1SelectedPokemon);
            } else {
                System.out.println("Player " + player2.getName() + " attacks first!");
                p2SelectedPokemon = selectPokemon(player2);
                p1SelectedPokemon = selectPokemon(player1);
                attack(player2, p2SelectedPokemon, player1, p1SelectedPokemon);
                attack(player1, p1SelectedPokemon, player2, p2SelectedPokemon);
            }
            System.out.println("Round" + round + "ends! Check your pokemons!");
            System.out.println(p1SelectedPokemon);
            System.out.println(p2SelectedPokemon);
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
                        " cannot fight anymore! Select another pokemon");
            } else {
                canSelectedPokemonFight = true;
            }
        }
        return availablePokemons.get(selectedPokemon);
    }

    public void attack(Player attacker, Pokemon attackerPokemon, Player defender, Pokemon defenderPokemon) {


        System.out.println("Player " + attacker.getName() + " attacks!");
        PokemonTrainer attackerTrainer = attacker.getPokemonTrainer();

        boolean useTrainerSkill = useTrainerSkill();
        boolean usePokemonSkill = usePokemonSkill();
        PokemonSkill pokemonSkillToUse = null;
        if (usePokemonSkill) {
            pokemonSkillToUse = selectPokemonSkill(attackerPokemon);
        }

        int damage = 0;
        boolean punishPlayer = (usePokemonSkill && pokemonSkillToUse.getRemainingUses() <= 0)
                || (useTrainerSkill && attackerTrainer.getTrainerSkill().getRemainingUses() <= 0);


        if (punishPlayer) {
            System.out.println(attacker.getName() + "  gets punished for attempting to use a skill with no remaining uses.");
            damage = 0;
        } else {
            if (usePokemonSkill) {
                System.out.println(attackerPokemon.getName() + " uses " + pokemonSkillToUse.getSkillName()
                        + ". Increases damage by " + pokemonSkillToUse.getExtraDamage() + "!");
                damage += pokemonSkillToUse.getExtraDamage();
                pokemonSkillToUse.decreaseRemainingUses();
            }
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
                    System.out.println(attackerTrainer.getName() + " uses special power "
                            + attackerTrainer.getTrainerSkill().getSkillName()
                            + " and heals " + attackerPokemon.getName() + " for "
                            + attackerTrainer.getTrainerSkill().getSkillEffectAmount() + " health points.");
                    attackerPokemon.heal(attackerTrainer.getTrainerSkill().getSkillEffectAmount());
                    attackerTrainer.getTrainerSkill().decreaseRemainingUses();
                }
            }
            damage += attackerPokemon.getNormalDamage();
        }

        System.out.println(attackerPokemon.getName() + " hits " + defenderPokemon.getName() + " for " + damage + "!");
        defenderPokemon.takeDamage(damage);
    }

    private boolean useTrainerSkill() {
        boolean selection = false;
        boolean runLoop = true;
        while (runLoop) {
            System.out.print("Do you want to use your trainer's skill? [y/N]: ");

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
            System.out.print("Do you want to use a pokemon skill? [y/N]: ");

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


}
