package package1;

import java.util.Iterator;

public interface ListIterator<T> extends Iterator<T> {
    void add(T element);       // dodanie e w bieżącej pozycji, ZA kursor
    boolean hasNext();
    boolean hasPrevious();     // jak hasNext, ale w przeciwnym kierunku
    T next();
    int nextIndex();           // indeks elementu, który byłby zwrócony przez next()
    T previous();              //jak next(), ale w przeciwnym kierunku
    int previousIndex();       //jak nextIndex(), ale w przeciwnym kierunku
    void remove();             // usuwa ostatnio zwrócony element przez next() lub previous()
    void set(T element);       //wstawia wartość e do kolekcji pod ostatnio zwrócony element
}
