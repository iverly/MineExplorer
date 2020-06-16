package elements;

/**
 * @author iverly on 16/06/2020
 * @project SpaceExplorer
 */
public class Element {

    private String nom;
    private float prix;

    public Element(String nom, float prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Element{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}
