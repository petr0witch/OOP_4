package MyList;

import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.Iterator;

public class GBArrayList<E> implements GBlist<E> {

    private E[] values;
    @SuppressWarnings("unchecked")
    public GBArrayList() {
        this.values = (E[]) new Object[0];
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean add(E e) {
        try{E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException exception) {
            System.out.println(exception.getMessage());
        } return false;

    }

    @Override
    public void remove(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amauntElementsAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amauntElementsAfterIndex);

        } catch (ClassCastException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

//    @Override
//    public GBlist<E> join(E[] t) {
//        return null;
//    }
    @Override
    public GBlist<E> join(E e){
        try{E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;

        } catch (ClassCastException exception) {
            System.out.println(exception.getMessage());
        } return this;
    }


    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(values);
    }

    @Override
    public String toString() {
        return "GBArrayList{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
