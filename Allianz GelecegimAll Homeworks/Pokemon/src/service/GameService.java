package service;

import model.Player;
import model.pokemon.Pokemon;

public class GameService {

/*    public void attack(Player attacker, Player defender, boolean isPokeSpecialAttack, boolean isCharSpecialAttack) {
        Pokemon attackingPokemon = attacker.getCharacter().getPokemonList().get(0);
        Pokemon defendingPokemon = defender.getCharacter().getPokemonList().get(0);

        boolean specialAttack = false;
        if (isPokeSpecialAttack && isCharSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainingUses() > 0
                    && attacker.getCharacter().getSpecialPower().getRemainingUses() > 0;
        } else if (isPokeSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainingUses() > 0;
        } else if (isCharSpecialAttack) {
            specialAttack = attacker.getCharacter().getSpecialPower().getRemainingUses() > 0;
        }

        int charRemainingRights = attacker.getCharacter().getSpecialPower().getRemainingUses();

        int damage = 0;
        if (specialAttack) {
            if (isPokeSpecialAttack && isCharSpecialAttack) {
                damage += attackingPokemon.specialAttack();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainingUses(charRemainingRights - 1);
            } else if (isPokeSpecialAttack) {
                damage += attackingPokemon.specialAttack();
            } else {
                damage += attackingPokemon.getBaseDamage();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainingUses(charRemainingRights - 1);
            }
        } else {
            if (isPokeSpecialAttack || isCharSpecialAttack) {
            } else {
                damage += attackingPokemon.getBaseDamage();
            }
        }

        defendingPokemon.setCurrentHealth(defendingPokemon.getCurrentHealth() - damage);
    }*/

    private boolean checkGameOver(Pokemon p1, Pokemon p2) {
        return p1.getCurrentHealth() > 0 && p2.getCurrentHealth() > 0;
    }

    public void fight(Player p1, Player p2) {

        Pokemon p1Pokemon = p1.getCharacter().getPokemonList().get(0);
        Pokemon p2Pokemon = p2.getCharacter().getPokemonList().get(0);

        boolean isGameOver = false;
        while (!isGameOver) {

            isGameOver = checkGameOver(p1Pokemon, p2Pokemon);
        }
    }



}