package service;

import model.trainer.Character;
import model.Player;

public class PlayerService {

    public Player createPlayer(String name, Character character) {
        return new Player(name, character);
    }



}
