package package1;
import java.util.Iterator;
import java.util.ListIterator;


public interface IList<E> extends Iterable<E> {
    boolean add(E element);
    boolean add(int index,E element);
    void clear();
    boolean contains(E element);
    E get(int index);                            // pobranie elementu z podanej pozycji
    E set(int index, E element);                 // ustawienie nowej wartości na pozycji
    int indexOf(E element);                      // pozycja szukanego elementu (equals())
    boolean isEmpty();                           // czy lista jest pusta
    Iterator<E> iterator();                      // zwraca iterator przed pierwszą pozycją
    ListIterator<E> listIterator();              // j.w. dla ListIterator
    E remove(int index);                         // usuwa element z podanej pozycji
    boolean remove(E element);                   // usuwa element (equals())
    int size();                                  // rozmiar listy

}