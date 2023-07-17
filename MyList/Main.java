package MyList;

public class Main {
    public static void main(String[] args) {
        GBlist<Integer> gBlist = new GBArrayList<>();
        gBlist.add(1);
        gBlist.add(2);
        gBlist.add(3);
        gBlist.add(4);
        gBlist.join(5).join(6).join(7);
        System.out.println(gBlist);
        System.out.println((gBlist).size());
        gBlist.remove(3);
        System.out.println(gBlist);
        System.out.println((gBlist).size());

        System.out.println(gBlist.get(2));
        gBlist.update(2, 10);
        System.out.println(gBlist.get(2));
    }
}
