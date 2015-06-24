package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 24.06.2015.
 */
public abstract class AbstractComposite<E extends Component> implements Composite<E> {
    private List<E> elements = new ArrayList<E>();

    //    constructor
//    adding method
//    source string method
    public AbstractComposite(List<E> elements) {
        this.elements = elements;
    }

    public AbstractComposite() {
    }

    public String toSourceString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E element : elements) {
            stringBuilder.append(element.toSourceString());
        }
        return stringBuilder.toString();
    }

    public void add(E e) {
        elements.add(e);
    }

    public E get(int index) {
        return elements.get(index);
    }

    public List<E> getElements() {
        return elements;
    }
}
