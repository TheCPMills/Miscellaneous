import java.util.*;

public class Sudoku {

}

class Box {
    int value;
    List<Integer> options = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    Point index;

    public Box(Point p) {
        index = p;
    }
    
    public toString() {
        return "Box " + index.toString();
    }
}