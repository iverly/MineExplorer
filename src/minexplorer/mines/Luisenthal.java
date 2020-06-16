package minexplorer.mines;

import minexplorer.ChoixElement;
import minexplorer.elements.Fer;
import minexplorer.elements.Pierre;

/**
 * @author iverly on 16/06/2020
 * @project SpaceExplorer
 */
public class Luisenthal extends Mine {

    public Luisenthal() {
        super("Luisenthal", "Allemagne", (byte) 0);
    }

    @Override
    public void remplirMine() {
        ChoixElement choix1 = new ChoixElement(new Pierre(), new Pierre(), new Fer());
        ChoixElement choix2 = new ChoixElement(new Pierre(), new Fer(), new Fer());
        ajouterChoix(choix1, choix2);
    }

    @Override
    public String messageArriver() {
        return "Hallo und willkommen in der Loulezhal Mine\n\n" +
                "Pas de chance, cette minexplorer.mine est déjà bien explorer, vous ne trouverez pas grand chose ...";
    }

}
