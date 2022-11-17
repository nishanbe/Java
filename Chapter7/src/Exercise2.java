public class Exercise2 {

    public static void main(String[] args) {
        int[][] original = {
                { 1, 2, 3},
                { 10, 20, 30},
                { 100, 200, 300}
        };
        System.out.println("Original matrix:");
        print2DArray(original);
        System.out.println();

        System.out.println("The transpose:");
        print2DArray( createTranspose(original) );
        System.out.println("\n");

        original = new int[][] {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3},
                {4, 4, 4},
                {5, 5, 5},
                {6, 6, 6},
                {7, 7, 7},
        };
        System.out.println("Original matrix:");
        print2DArray(original);
        System.out.println();

        System.out.println("The transpose:");
        print2DArray( createTranspose(original) );
        System.out.println();

    }

    public static int[][] createTranspose(int[][] matrix ) {
        int[][] transpose;
        int R = matrix.length;     // the number of rows in matrix
        int C = matrix[0].length;  // the number of columns in matrix
        transpose = new int[C][R];
        for ( int i = 0; i < C; i++) { // goes through ROWS of the transpose
            for ( int j = 0; j < R; j++ ) { // goes through COLUMNS of the transpose
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }

    /**
     * Prints out the items of a 2D array of ints in rows and columns,
     * with 6 spaces in each column.
     */
    public static void print2DArray(int[][] array ) {
        for ( int[] row : array ) {
            // print 1 row from the array
            System.out.print("   ");
            for ( int item : row ) {
                System.out.print(item +" ");
            }
            System.out.println();
        }
    }




}