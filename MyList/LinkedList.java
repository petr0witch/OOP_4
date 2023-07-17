// TODO: 1) На основе интерфейса GBList создать свою реализацию LinkedList с методами вставки в начало,
//  конец списка, получения размера списка и получения элемента по индексу
package MyList;

import com.sun.nio.sctp.MessageInfo;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class LinkedList<E> implements InterfaceLinkedList<E>, Iterable<E>, DescendingIterator<E> {

    public static void main(String[] args) {
        LinkedList<String> stringLinked = new LinkedList<>();
        stringLinked.addLast("abc");
        stringLinked.addLast("de");
        stringLinked.addFirst("013");
        System.out.println(stringLinked.size());
        System.out.println(stringLinked.getElemByIndex(0));
        System.out.println(stringLinked);
        // TODO: Почему-то в обрат. порядке выводит нормально, а последовательно - бесконечный цикл с выводом первого элемента
//        Iterator iter = stringLinked.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
        Iterator iterator = stringLinked.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size = 0;

    public LinkedList() {
        lstNode = new Node<E>(null, fstNode, null);
        fstNode = new Node<E>(null, null, lstNode);
    }

    @Override
    public void addLast(E e) {
        Node<E> prev = lstNode; //  инициализируем переменную для последнего элемента
        prev.setCurrentElem(e); // присваиваем значение этому последнему элементу
        lstNode = new Node<E>(null, prev, null); // Создаём новый последний пустой элемент, со ссылкой на пред. добавленный
        prev.setNextElem(lstNode); // создаем указатель для добавленного элемента ссылку на след пустой
        size++; // увеличиваем размер на +1
    }

    @Override
    public void addFirst(E e) {
        Node<E> next = fstNode; //  инициализируем переменную для первого элемента
        next.setCurrentElem(e); // присваиваем значение этому первому элементу
        fstNode = new Node<E>(null, null, next); // Создаём новый первый пустой элемент, со ссылкой на пред. добавленный
        next.setNextElem(fstNode); // Создаем указатель для добавленного элемента ссылку на пред. пустой
        size++; // увеличиваем размер на +1
    }

    @Override
    public int size() {
        return size;
    }

    // TODO: Вот этот принцип не очень понял ____________________________________________
    @Override
    public E getElemByIndex(int counter) {
        Node<E> target = fstNode.getNextElem(); //берем первую ноду и получаем ее след элемент
        for (int i = 0; i < counter; i++) {
            target = getNextElement(target); //
        }
        return target.getCurrentElem();
    }
    private Node<E> getNextElement(Node<E> current){
        return current.getNextElem();
    }
    //___________________________________________________________________________________

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return getElemByIndex(counter);
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int counter = size - 1;
            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public E next() {
                return getElemByIndex(counter--);
            }
        };
    }


    private class Node<E> {
        private E currentElem;
        private Node<E> nextElem;
        private Node<E> prevElem;

        private Node(E currentElem, Node<E> prevElem, Node<E> nextElem) { // Constructor
            this.currentElem = currentElem;
            this.prevElem = prevElem;
            this.nextElem = nextElem;
        }

        public E getCurrentElem() {
            return currentElem;
        }
        public void setCurrentElem(E currentElem) {
            this.currentElem = currentElem;
        }
        public Node<E> getNextElem() {
            return nextElem;
        }
        public void setNextElem(Node<E> nextElem) {
            this.nextElem = nextElem;
        }
        public Node<E> getPrevElem() {
            return prevElem;
        }
        public void setPrevElem(Node<E> prevElem) {
            this.prevElem = prevElem;
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "fstNode=" + fstNode +
                ", lstNode=" + lstNode +
                ", size=" + size +
                '}';
    }
}
