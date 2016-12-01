/**
 * Created by Samson on 20-11-2016.
 */
public class Main {

    public static void main(String[] args) {
        HashIntSet set = new HashIntSet();
        HashIntSet setTwo = new HashIntSet();


        //ex 1;
        /*
        set.add(-5);
        set.add(1);
        set.add(2);
        set.add(-3);
        System.out.println(set.toString());

        setTwo.add(2);
        setTwo.add(3);
        setTwo.add(6);
        setTwo.add(44);
        setTwo.add(79);
        System.out.println(setTwo.toString());
        set.addAll(setTwo);
        System.out.println(set.toString());
        */


        //ex 2;
        /*
        set.add(-2);
        set.add(3);
        set.add(5);
        set.add(6);
        set.add(8);

        setTwo.add(3);
        setTwo.add(6);
        setTwo.add(8);
//        setTwo.add(7);

        System.out.println(set.containsAll(setTwo));
        */


        //ex 2;
        /*
        set.add(1);
        set.add(2);
        set.add(3);

        setTwo.add(1);
        setTwo.add(2);
        setTwo.add(3);

        System.out.println(set.equals(setTwo));
        */

        /*
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        setTwo.add(1);
        setTwo.add(2);
        setTwo.add(6);
        setTwo.add(8);

        set.removeAll(setTwo);
        System.out.println(set.toString());
        */

        set.add(-2);
        set.add(3);
        set.add(5);
        set.add(6);
        set.add(8);

        setTwo.add(2);
        setTwo.add(3);
        setTwo.add(6);
        setTwo.add(8);
        setTwo.add(11);
        set.retainAll(setTwo);
        System.out.println(set.toString());


            System.out.println(set.toString());
            System.out.println(set.toArrayToString());



    }
}
