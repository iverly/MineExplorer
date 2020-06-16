package minexplorer;

import minexplorer.elements.Diamant;
import minexplorer.elements.Fer;
import minexplorer.elements.Pierre;
import minexplorer.mines.Mine;

import java.util.*;

/**
 * @author iverly on 16/06/2020
 * @project MineExplorer
 */
public class Game {

    private List<Mine> mines;
    private int nombreDeTours;

    private Scanner scanner;

    public Game(int nombreDeTours) {
        this.mines = new ArrayList<>();
        this.nombreDeTours = nombreDeTours;

        this.scanner = new Scanner(System.in);
    }

    public void ajouterMines(Mine... mines) {
        this.mines.addAll(Arrays.asList(mines));
    }

    public void start() {
        // todo: check if nbtour * 2 > mines.size

        System.out.println(
                "Bienvenue dans MineExplorer,\n" +
                "Votre but est de devenir le plus riche possible en explorant des mines.\n" +
                "Chaque mine a un niveau de rareté qui défini votre nombre de choix dans cette derniere.\n\n" +
                "Voici les prix des différents matériaux du jeu:\n" +
                new Diamant().getNom() + ": " + new Diamant().getPrix() + " $\n" +
                new Fer().getNom() + ": " + new Fer().getPrix() + " $\n" +
                new Pierre().getNom() + ": " + new Pierre().getPrix() + " $\n\n" +
                "Vous pourrez explorer " + nombreDeTours + " mines en tout ! Alors bonne chance et bon jeu !"
        );

        for (int i = 0; i < this.nombreDeTours; i++) {
            System.out.println("Tour " + i);
            Mine[] twoRandomMine = getTwoRandomMine();
            System.out.println(Arrays.toString(twoRandomMine));
        }

        System.out.println("Fin du jeu !");
    }

    public Mine[] getTwoRandomMine() {
        Mine[] mines = new Mine[2];
        Random random = new Random();
        mines[0] = this.mines.get(random.nextInt(this.mines.size()));
        this.mines.remove(mines[0]);
        mines[1] = this.mines.get(random.nextInt(this.mines.size()));
        this.mines.remove(mines[1]);
        return mines;
    }

}
