import java.util.*;

public class Sudoku {
    public static void main(String[] args) {
        // create grid
        Grid g = new Grid();

        // initialize solved boxes
        g.getBox("B1").setValue(2);
        g.getBox("D2").setValue(6);
        g.getBox("I2").setValue(3);
        g.getBox("B3").setValue(7);
        g.getBox("C3").setValue(4);
        g.getBox("E3").setValue(8);
        g.getBox("F4").setValue(3);
        g.getBox("I4").setValue(2);
        g.getBox("B5").setValue(8);
        g.getBox("E5").setValue(4);
        g.getBox("H5").setValue(1);
        g.getBox("A6").setValue(6);
        g.getBox("D6").setValue(5);
        g.getBox("E7").setValue(1);
        g.getBox("G7").setValue(7);
        g.getBox("H7").setValue(8);
        g.getBox("A8").setValue(5);
        g.getBox("F8").setValue(9);
        g.getBox("H9").setValue(4);
      
        // display grid
        System.out.println(g + "\n\n");

        // solve
        long begin = new Date().getTime();
        
        do {
            if(new Date().getTime() - begin >= 5000) {
                System.out.println("Took too long to solve");
                return;
            }
            for(Box b : g.r1.getBoxes()) {
                b.checkRow();
                b.checkColumn();
                b.checkSubgrid();
            }
            for(Box b : g.r2.getBoxes()) {
                b.checkRow();
                b.checkColumn();
                b.checkSubgrid();
            }
            for(Box b : g.r3.getBoxes()) {
                b.checkRow();
                b.checkColumn();
                b.checkSubgrid();
            }
            for(Box b : g.r4.getBoxes()) {
                b.checkRow();
                b.checkColumn();
                b.checkSubgrid();
            }
            for(Box b : g.r5.getBoxes()) {
                b.checkRow();
                b.checkColumn();
                b.checkSubgrid();
            }
            for(Box b : g.r6.getBoxes()) {
                b.checkRow();
                b.checkColumn();
                b.checkSubgrid();
            }
            for(Box b : g.r7.getBoxes()) {
                b.checkRow();
                b.checkColumn();
                b.checkSubgrid();
            }
            for(Box b : g.r8.getBoxes()) {
                b.checkRow();
                b.checkColumn();
                b.checkSubgrid();
            }
            for(Box b : g.r9.getBoxes()) {
                b.checkRow();
                b.checkColumn();
                b.checkSubgrid();
            }
            g.r1.getBoxes()[0].checkUniqueValues();
            g.r2.getBoxes()[1].checkUniqueValues();
            g.r3.getBoxes()[2].checkUniqueValues();
            g.r4.getBoxes()[3].checkUniqueValues();
            g.r5.getBoxes()[4].checkUniqueValues();
            g.r6.getBoxes()[5].checkUniqueValues();
            g.r7.getBoxes()[6].checkUniqueValues();
            g.r8.getBoxes()[7].checkUniqueValues();
            g.r9.getBoxes()[8].checkUniqueValues();
        }
        while(!g.solved());

        // display solved grid
        System.out.println(g);
    }
}

class Grid {
    Row r1, r2, r3, r4, r5, r6, r7, r8, r9;
    Column c1, c2, c3, c4, c5, c6, c7, c8, c9;
    Subgrid s1, s2, s3, s4, s5, s6, s7, s8, s9;

    public Grid() {
        init();
        addRowsAndColumns(s1);
        addRowsAndColumns(s2);
        addRowsAndColumns(s3);
        addRowsAndColumns(s4);
        addRowsAndColumns(s5);
        addRowsAndColumns(s6);
        addRowsAndColumns(s7);
        addRowsAndColumns(s8);
        addRowsAndColumns(s9);
    }

    public void init() {
        r1 = new Row(0);
        r2 = new Row(1);
        r3 = new Row(2);
        r4 = new Row(3);
        r5 = new Row(4);
        r6 = new Row(5);
        r7 = new Row(6);
        r8 = new Row(7);
        r9 = new Row(8);

        c1 = new Column(0);
        c2 = new Column(1);
        c3 = new Column(2);
        c4 = new Column(3);
        c5 = new Column(4);
        c6 = new Column(5);
        c7 = new Column(6);
        c8 = new Column(7);
        c9 = new Column(8);

        s1 = new Subgrid(0);
        s2 = new Subgrid(1);
        s3 = new Subgrid(2);
        s4 = new Subgrid(3);
        s5 = new Subgrid(4);
        s6 = new Subgrid(5);
        s7 = new Subgrid(6);
        s8 = new Subgrid(7);
        s9 = new Subgrid(8);
    }

    private void addRowsAndColumns(Subgrid s) {
        for(Box b : s.getBoxes()) {
            switch (b.getLocation().getX()) {
                case 0:
                    b.setColumn(c1);
                    c1.getBoxes()[b.getLocation().getY()] = b;
                    break;
                case 1:
                    b.setColumn(c2);
                    c2.getBoxes()[b.getLocation().getY()] = b;
                    break;
                case 2:
                    b.setColumn(c3);
                    c3.getBoxes()[b.getLocation().getY()] = b;
                    break;
                case 3:
                    b.setColumn(c4);
                    c4.getBoxes()[b.getLocation().getY()] = b;
                    break;
                case 4:
                    b.setColumn(c5);
                    c5.getBoxes()[b.getLocation().getY()] = b;
                    break;
                case 5:
                    b.setColumn(c6);
                    c6.getBoxes()[b.getLocation().getY()] = b;
                    break;
                case 6:
                    b.setColumn(c7);
                    c7.getBoxes()[b.getLocation().getY()] = b;
                    break;
                case 7:
                    b.setColumn(c8);
                    c8.getBoxes()[b.getLocation().getY()] = b;
                    break;
                case 8:
                    b.setColumn(c9);
                    c9.getBoxes()[b.getLocation().getY()] = b;
                    break;
            }
            switch (b.getLocation().getY()) {
                case 0:
                    b.setRow(r1);
                    r1.getBoxes()[b.getLocation().getX()] = b;
                    break;
                case 1:
                    b.setRow(r2);
                    r2.getBoxes()[b.getLocation().getX()] = b;
                    break;
                case 2:
                    b.setRow(r3);
                    r3.getBoxes()[b.getLocation().getX()] = b;
                    break;
                case 3:
                    b.setRow(r4);
                    r4.getBoxes()[b.getLocation().getX()] = b;
                    break;
                case 4:
                    b.setRow(r5);
                    r5.getBoxes()[b.getLocation().getX()] = b;
                    break;
                case 5:
                    b.setRow(r6);
                    r6.getBoxes()[b.getLocation().getX()] = b;
                    break;
                case 6:
                    b.setRow(r7);
                    r7.getBoxes()[b.getLocation().getX()] = b;
                    break;
                case 7:
                    b.setRow(r8);
                    r8.getBoxes()[b.getLocation().getX()] = b;
                    break;
                case 8:
                    b.setRow(r9);
                    r9.getBoxes()[b.getLocation().getX()] = b;
                    break;
            }
        }
    }

    public Box getBox(String s) {
        switch(Integer.parseInt(s.substring(1))) {
            case 1:
                return r1.getBoxes()[(s.charAt(0) - 'A')];
            case 2:
                return r2.getBoxes()[(s.charAt(0) - 'A')];
            case 3:
                return r3.getBoxes()[(s.charAt(0) - 'A')];
            case 4:
                return r4.getBoxes()[(s.charAt(0) - 'A')];
            case 5:
                return r5.getBoxes()[(s.charAt(0) - 'A')];
            case 6:
                return r6.getBoxes()[(s.charAt(0) - 'A')];
            case 7:
                return r7.getBoxes()[(s.charAt(0) - 'A')];
            case 8:
                return r8.getBoxes()[(s.charAt(0) - 'A')];
            case 9:
                return r9.getBoxes()[(s.charAt(0) - 'A')];
        }
        return null;
    }

    public boolean solved() {
        for(Box b : r1.getBoxes()) {
            if(!b.isSolved()) {
                return false;
            }
        }
        for(Box b : r2.getBoxes()) {
            if(!b.isSolved()) {
                return false;
            }
        }
        for(Box b : r3.getBoxes()) {
            if(!b.isSolved()) {
                return false;
            }
        }
        for(Box b : r4.getBoxes()) {
            if(!b.isSolved()) {
                return false;
            }
        }
        for(Box b : r5.getBoxes()) {
            if(!b.isSolved()) {
                return false;
            }
        }
        for(Box b : r6.getBoxes()) {
            if(!b.isSolved()) {
                return false;
            }
        }
        for(Box b : r7.getBoxes()) {
            if(!b.isSolved()) {
                return false;
            }
        }
        for(Box b : r8.getBoxes()) {
            if(!b.isSolved()) {
                return false;
            }
        }
        for (Box b : r9.getBoxes()) {
            if (!b.isSolved()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String s1 = r1.toString().substring(19);
        String s2 = r2.toString().substring(19);
        String s3 = r3.toString().substring(19);
        String s4 = r4.toString().substring(19);
        String s5 = r5.toString().substring(19);
        String s6 = r6.toString().substring(19);
        String s7 = r7.toString().substring(19);
        String s8 = r8.toString().substring(19);
        String s9 = r9.toString().substring(19);
        return s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n" + s5 + "\n" + s6 + "\n" + s7 + "\n" + s8 + "\n" + s9;
    }
}

class Subgrid {
    private int index;
    private Box[] boxes = new Box[9];

    public Subgrid(int i) {
        index = i;
        int count = 0;
        for(int c = minCol(); c < minCol() + 3; c++) {
            for(int r = minRow(); r < minRow() + 3; r++) {
                boxes[count] = new Box(new Point(c, r), this);
                count++;
            }
        }
    }

    private int minCol() {
        switch(index) {
            case 0:
            case 3:
            case 6:
                return 0;
            case 1:
            case 4:
            case 7:
                return 3;
            case 2:
            case 5:
            case 8:
                return 6;
        }
        return -1;
    }

    private int minRow() {
        switch (index) {
            case 0:
            case 1:
            case 2:
                return 0;
            case 3:
            case 4:
            case 5:
                return 3;
            case 6:
            case 7:
            case 8:
                return 6;
        }
        return -1;
    }

    public Box[] getBoxes() {
        return boxes;
    }

    public String toString() {
        String s1 = "Subgrid #" + (index + 1) + " - Contains:";
        String s2 = boxes[0].toString() + ", " + boxes[3].toString() + ", " + boxes[6].toString();
        String s3 = boxes[1].toString() + ", " + boxes[4].toString() + ", " + boxes[7].toString();
        String s4 = boxes[2].toString() + ", " + boxes[5].toString() + ", " + boxes[8].toString();
        return s1 + "\n" + s2 + "\n" + s3 + "\n" + s4;
    }
}

class Column{
    private int index;
    private Box[] boxes = new Box[9];

    public Column(int i) {
        index = i;
    }

    public Box[] getBoxes() {
        return boxes;
    }

    public String toString() {
        String s1 = "Column #" + (index + 1) + " - Contains:";
        String s2 = boxes[0].toString() + ", ";
        String s3 = boxes[1].toString() + ", ";
        String s4 = boxes[2].toString() + ", ";
        String s5 = boxes[3].toString() + ", ";
        String s6 = boxes[4].toString() + ", ";
        String s7 = boxes[5].toString() + ", ";
        String s8 = boxes[6].toString() + ", ";
        String s9 = boxes[7].toString() + ", ";
        String s0 = boxes[8].toString() + ", ";
        return s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n" + s5 + "\n" + s6 + "\n" + s7 + "\n" + s8 + "\n" + s9 + "\n" + s0;
    }
}

class Row {
    private int index;
    private Box[] boxes = new Box[9];

    public Row(int i) {
        index = i;
    }

    public Box[] getBoxes() {
        return boxes;
    }

    public String toString() {
        return "Row #" + (index + 1) + " - Contains: " + 
        boxes[0].toString() + ", " + 
        boxes[1].toString() + ", " + 
        boxes[2].toString() + ", " +
        boxes[3].toString() + ", " + 
        boxes[4].toString() + ", " + 
        boxes[5].toString() + ", " + 
        boxes[6].toString() + ", " + 
        boxes[7].toString() + ", " + 
        boxes[8].toString();
    }
}

class Box {
    private Integer value;
    private Point location;
    private Row row;
    private Column col;
    private Subgrid subgrid;
    private String name;
    private boolean solved = false;
    private List<Integer> options = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    public Box(Point p, Subgrid s) {
        location = p;
        subgrid = s;
        name = "Box " + location.toString();
    }

    public void setValue(Integer i) {
        value = i;
        solved = true;
        options = new ArrayList<Integer>(Arrays.asList(i.intValue()));
    }

    public Integer getValue() {
        return value;
    }

    public Point getLocation() {
        return location;
    }

    public void setRow(Row r) {
        row = r;
    }

    public Row getRow() {
        return row;
    }

    public void setColumn(Column c) {
        col = c;
    }

    public Column getColumn() {
        return col;
    }

    public Subgrid getSubgrid() {
        return subgrid;
    }

    public String getName() {
        return name;
    }

    public boolean isSolved() {
        return solved;
    }

    public List<Integer> getOptions() {
        return options;
    }

    public String toString() {
        return solved ? value.toString() : name;
    }

    public void checkRow() {
        for(Box b : row.getBoxes()) {
            if(!b.equals(this) && b.isSolved()) {
                options.removeIf(i -> i.intValue() == b.getValue().intValue());
            }
        }
        if(options.size() == 1) {
            value = options.get(0);
            solved = true;
        }
    }

    public void checkColumn() {
        for(Box b : col.getBoxes()) {
            if(!b.equals(this) && b.isSolved()) {
                options.removeIf(i -> i.intValue() == b.getValue().intValue());
            }
        }
        if(options.size() == 1) {
            value = options.get(0);
            solved = true;
        }
    }
    
    public void checkSubgrid() {
        for(Box b : subgrid.getBoxes()) {
            if (!b.equals(this) && b.isSolved()) {
                options.removeIf(i -> i.intValue() == b.getValue().intValue());
            }
        }
        if(options.size() == 1) {
            value = options.get(0);
            solved = true;
        }
    }

    public void checkUniqueValues() {
        findUniqueValues(row.getBoxes());
        findUniqueValues(col.getBoxes());
        findUniqueValues(subgrid.getBoxes());
    }

    private void findUniqueValues(Box[] b) {
        List<ArrayList<Integer>> uniques = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < 9; i++) {
            Box main = b[i];
            uniques.add(new ArrayList<Integer>());
            for(int j = 0; j < main.options.size(); j++) {
                boolean isUnique = true;
                for(int k = 0; k < 9; k++) {
                    if(i != k && b[k].options.indexOf(main.options.get(j)) != -1) {
                        isUnique = false;
                    }
                }
                if(isUnique) {
                    uniques.get(i).add(main.options.get(j));
                }
            }
        }
        for(int i = 0; i < 9; i++) {
            if(uniques.get(i).size() > 0) {
                b[i].options = uniques.get(i);
            }
        }
    }
}

class Point {
    private int x, y;

    public Point(int X, int Y) {
        x = X;
        y = Y;
    }

    public String toString() {
        return String.valueOf((char) (x + 65)) + (y + 1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}