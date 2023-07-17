import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("1234");
        list.add(1);
        list.add("Hello!");

        for (Object o : list)
            System.out.println(o);

        printList(list);

    }
    public static void printList(List<? super Number> list){
        for (Object o : list)
            System.out.print(o + " ");

    }
}
