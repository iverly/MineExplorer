package minexplorer;

import minexplorer.mines.Centralia;
import minexplorer.mines.Luisenthal;

/**
 * @author iverly on 16/06/2020
 * @project MineExplorer
 */
public class Main {

    public static void main(String[] args) {
        Game game = new Game(1);
        game.ajouterMines(new Centralia(), new Luisenthal());
        game.start();
    }

}
