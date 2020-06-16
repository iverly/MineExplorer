package minexplorer.mines;

import minexplorer.ChoixElement;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author iverly on 16/06/2020
 * @project SpaceExplorer
 */
public abstract class Mine {

    private String nom;
    private String localisation;
    private byte rarete;
    private LinkedList<ChoixElement> choixList;

    public Mine(String nom, String localisation, byte rarete) {
        this.nom = nom;
        this.localisation = localisation;
        this.rarete = rarete;
        this.choixList = new LinkedList<>();
    }

    public void ajouterChoix(ChoixElement... element) {
        this.choixList.addAll(Arrays.asList(element));
    }

    public abstract void remplirMine();

    public abstract String messageArriver();

    public String getNom() {
        return nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public byte getRarete() {
        return rarete;
    }

    public LinkedList<ChoixElement> getChoixList() {
        return choixList;
    }
}
