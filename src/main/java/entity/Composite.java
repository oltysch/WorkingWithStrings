package entity;

import java.util.List;

/**
 * Created by Admin on 18.06.2015.
 */
public interface Composite<T> extends Component {
    List<T> addChild();
}