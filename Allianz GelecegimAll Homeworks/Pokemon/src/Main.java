import model.pokemon.Pokemon;
import model.trainer.PokemonTrainer;
import service.GameMaster;
import service.LoadService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
/*        LoadService loadService = new LoadService();
        List<PokemonTrainer> pokemonTrainerList = loadService.loadTrainers();
        List<Pokemon> pokemonList = loadService.loadPokemons();

        System.out.println(pokemonTrainerList);
        System.out.println(pokemonList);*/

        GameMaster gameMaster = new GameMaster();
        gameMaster.run();
    }
}