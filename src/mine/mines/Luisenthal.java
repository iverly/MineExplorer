package mine.mines;

import elements.ChoixElement;
import elements.Fer;
import elements.Pierre;
import mine.Mine;

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
                "Pas de chance, cette mine est déjà bien explorer, vous ne trouverez pas grand chose ...";
    }

}
