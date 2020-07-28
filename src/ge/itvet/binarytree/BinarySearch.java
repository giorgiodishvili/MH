package ge.itvet.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch<V> {
    List<V> data = new ArrayList<>();
    Comparator<V> comparator;

    public BinarySearch(Comparator<V> comparator) {
        this.comparator = comparator;
    }

    public void setData(List<V> data) {
        Collections.sort(data, comparator);
        this.data = data;
    }

    public boolean contains(V x) {
        if (data.size() - 1 >= 0) {
            int mid = data.size() / 2;
            if (comparator.compare(data.get(mid), x) == 0)
                return true;

            if (0 > comparator.compare(data.get(mid), x))
                return contains(x);

            return contains(x);
        }


        return false;
    }
}
