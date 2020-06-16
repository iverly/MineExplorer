package minexplorer;

import minexplorer.elements.Element;

/**
 * @author iverly on 16/06/2020
 * @project SpaceExplorer
 */
public class ChoixElement {

    private Element element1;
    private Element element2;
    private Element element3;

    public ChoixElement(Element element1, Element element2, Element element3) {
        this.element1 = element1;
        this.element2 = element2;
        this.element3 = element3;
    }

    public Element getElement1() {
        return element1;
    }

    public Element getElement2() {
        return element2;
    }

    public Element getElement3() {
        return element3;
    }
}
