package entity;

import java.util.List;

/**
 * Created by Admin on 18.06.2015.
 */
public interface Composite<E extends Component> extends Component {
    String getBound();
    void setBound(String bound);
}
