package minexplorer;

import minexplorer.elements.Diamant;
import minexplorer.elements.Element;
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
    private float money;

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
                "Chaque mine a un niveau de rareté qui définit votre nombre de choix dans cette dernière..\n\n" +
                "Voici les prix des différents matériaux du jeu:\n" +
                new Diamant().getNom() + ": " + new Diamant().getPrix() + " $\n" +
                new Fer().getNom() + ": " + new Fer().getPrix() + " $\n" +
                new Pierre().getNom() + ": " + new Pierre().getPrix() + " $\n\n" +
                "Vous pourrez explorer " + nombreDeTours + " mines en tout ! Alors bonne chance et bon jeu !\n"
        );

        // todo: wait for ready

        for (int i = 0; i < this.nombreDeTours; i++) {
            Mine[] twoRandomMine = getTwoRandomMine();
            System.out.println(
                    "Vous croisez deux mines sur votre chemin, une à droite et une autre à gauche.\n" +
                    "Vous devez choisir l'une des deux mines:\n\n" +
                    "Celle de gauche: " + twoRandomMine[0].getNom() + " (" + twoRandomMine[0].getLocalisation() + ")\n" +
                    "Celle de droite: " + twoRandomMine[1].getNom() + " (" + twoRandomMine[1].getLocalisation() + ")\n\n" +
                    "Choisissez celle de votre choix: (1 = gauche / 2 = droite)"
            );

            int mineChoix = getInputAsInt(1, 2);
            Mine mine = twoRandomMine[mineChoix-1];
            mine.remplirMine();
            System.out.println(mine.messageArriver());

            for (ChoixElement choixElement : mine.getChoixList()) {
                System.out.println(
                        "Vous avez le choix entre trois tas de roches. Lequel choissez vous ?\n" +
                        "1 = première, 2 = deuxième et 3 = dernière"
                );
                int choix = getInputAsInt(1, 3);
                Element found;
                if (choix == 1) found = choixElement.getElement1();
                else if (choix == 2) found = choixElement.getElement2();
                else found = choixElement.getElement3();

                money += found.getPrix();
                System.out.println("Vous avez trouvé: " + found.getNom() + " (+" + found.getPrix() + " $)\n");
            }

            System.out.println(
                    "Vous avez fini d'explorer cette mine. Vous sortez avec " + money + " $ dans votre poche"
            );
        }

        System.out.println("Fin du jeu !");
    }

    private Mine[] getTwoRandomMine() {
        Mine[] mines = new Mine[2];
        Random random = new Random();
        mines[0] = this.mines.get(random.nextInt(this.mines.size()));
        this.mines.remove(mines[0]);
        mines[1] = this.mines.get(random.nextInt(this.mines.size()));
        this.mines.remove(mines[1]);
        return mines;
    }

    private int getInputAsInt(int min, int max) {
        int res;
        do {
            try {
                res = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                res = Integer.MIN_VALUE;
            }
        } while (res < min || res > max);
        return res;
    }

}
