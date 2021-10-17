package main.math;

class Matrix {
    private long[][] matrix;
    Matrix(long[]... rows) {
        int rowCount = rows.length;
        int columnCount = rows[0].length;
        matrix = new long[rowCount][columnCount];
        for(int i = 0; i < rowCount; i++) {
            matrix[i] = rows[i];
        }
    }

    Matrix(int rows, int columns, long[] values) {
        matrix = new long[rows][columns];
        int currentColumn = 0;
        int currentRow = -1;
        for(int i = 0; i < values.length; i++) {
            if(i % columns == 0) {
                currentRow++;
                currentColumn = 0;
            }
            matrix[currentRow][currentColumn] = values[i];
            currentColumn++;
        }
    }

    public String toString() {
        String s = "";
        for(long[] row : matrix) {
            for(long val : row) {
                s += val + "\t";
            }
            s += "\n";
        }
        return s;
    }
    
    public static void main(String[] args) {
        long[] row1 = {1,2,3,4};
        long[] row2 = {5,6,7,8};
        long[] row3 = {9,10,11,12};
        Matrix test1 = new Matrix(row1, row2, row3);
        long[] row4 = {1,2,3,4,5,6,7,8,9,10,11,12};
        Matrix test2 = new Matrix(3, 4, row4);
        System.out.println(test1 + "\n\n" + test2);
    }
}