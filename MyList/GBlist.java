package MyList;

public interface GBlist<T> extends Iterable<T> {
    boolean add(T t);
    void remove(int index);
    T get(int index); // T - вначале - то что возвращает
    int size();
    void update(int index, T t);
    GBlist<T> join(T t);

}
