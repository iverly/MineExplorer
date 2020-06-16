package minexplorer.mines;

import minexplorer.ChoixElement;
import minexplorer.elements.Diamant;
import minexplorer.elements.Fer;
import minexplorer.elements.Pierre;

/**
 * @author iverly on 16/06/2020
 * @project SpaceExplorer
 */
public class Centralia extends Mine {

    public Centralia() {
        super("Centralia", "USA", (byte) 2);
    }

    @Override
    public void remplirMine() {
        ChoixElement choix1 = new ChoixElement(new Fer(), new Pierre(), new Fer());
        ChoixElement choix2 = new ChoixElement(new Diamant(), new Fer(), new Fer());
        ChoixElement choix3 = new ChoixElement(new Pierre(), new Pierre(), new Fer());
        ChoixElement choix4 = new ChoixElement(new Diamant(), new Fer(), new Diamant());
        ChoixElement choix5 = new ChoixElement(new Pierre(), new Pierre(), new Pierre());
        ChoixElement choix6 = new ChoixElement(new Diamant(), new Diamant(), new Fer());
        ajouterChoix(choix1, choix2, choix3, choix4, choix5, choix6);
    }

    @Override
    public String messageArriver() {
        return "Hello and welcome to the Centralia minexplorer.mine\n\n" +
                "Quelle chance ! Encore personne n'a mis les pieds ici. A vous la richesse";
    }
}
