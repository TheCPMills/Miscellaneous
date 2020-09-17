import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> O = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int[] i1 = {5, 6, 7, 8, 9};
        Item o1 = new Item(i1);
        int[] i2 = {1, 4, 5, 8, 9};
        Item o2 = new Item(i2);
        int[] i3 = {1, 2, 3, 5, 9};
        Item o3 = new Item(i3);
        Item[] i = {o1, o2, o3};
        only(i);
    }

    public static void only(Item[] i) {
        List<ArrayList<Integer>> p = new ArrayList<ArrayList<Integer>>();
        for(int I = 0; I < 3; I++) {
            Item main = i[I];
            p.add(new ArrayList<Integer>());
            for (int j = 0; j < main.options.size(); j++) {
                boolean isUnique = true;
                for (int k = 0; k < 3; k++) {
                    if(I != k && i[k].options.indexOf(main.options.get(j)) != -1) {
                        isUnique = false;
                    }
                }
                if (isUnique) {
                    p.get(I).add(main.options.get(j));
                }
            }
        }
        for(int I = 0; I < 3; I++) {
            i[I].options = p.get(I);
            System.out.println("Array #" + (I + 1) + " is the only one to contain " + p.get(I));
        }
        
    }
}

class Item {
    List<Integer> options = new ArrayList<Integer>();

    public Item(int[] i) {
        for(int j : i) {
            options.add(new Integer(j));
        }
    }
}