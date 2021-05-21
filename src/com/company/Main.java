package com.company;

/**
 * Maman14
 * @author Ido Ziv
 * @version 13-05-2021
 */

public class Main {

    public static void main(String[] args) {
        int [][] ido = {
                {0,1,0,0,0,1},
                {1,0,0,1,1,1},
                {0,0,0,0,0,1},
                {1,1,1,1,1,1},
                {0,1,0,1,0,1},
                {0,1,0,0,0,0}
        };
        System.out.println(isSink(ido) +  " -1");
//        int [] a = {1,2,3,4};
//        int [] b = {4,2,3,1};
//        int [] b1 = {0,2,3,1};
//        int [] b2 = {5,2,3,1};
//        int [] q101 = new int[]{5,5,5,-5},  q102 =new int[]{-5,5,-5,5};
//        int [] q11 = new int[]{-5,5,5,-5} ,q12 = new int[]{5,5,-5,5};     // 11
//        int [] q141 = new int[]{1,2,4,4}, q142 = new int[]{1,2,4,2};        // 14
//        System.out.println("is permutation a & b: "  + isPermutation(a,b) + " needs to be true");
//        System.out.println("is permutation b1 & b2: "  + isPermutation(b1,b2) + " needs to be false");
//        System.out.println("is permutation q101 & q102: "  + isPermutation(q101,q102) + " needs to be false");
//        System.out.println("is permutation q11 & q12: "  + isPermutation(q11,q12) + " needs to be false");
//        System.out.println("is permutation q141 & q142: "  + isPermutation(q141,q142) + " needs to be false");
//        testIsSink();/
//        testSize();
    }

    /**
     * Returns the maximal drop between two numbers in the array.
     * the larger number has to come first in the array
     * @param a - The Array
     * @return -> the number of the highest drop
     * @time_complexity -> O(n)
     * @memory_complexity -> O(1)
     */
    public static int maximalDrop (int [] a){
       int highestNum = a[0];
       int maxDiff = -1;
       int index = 1;
       while (index < a.length){
           if (highestNum - a[index] > maxDiff)
               maxDiff = highestNum - a[index];
           if (a[index] > highestNum)
               highestNum = a[index];
           index ++;
       }
       if (maxDiff == -1)
           System.out.println("No diff available");
       return maxDiff;
    }

    /**
     * this method returns whether there is a sink in the mat, if there is a row that all the cells inside of it are 0
     * and all the cell in the matching col is 1
     * @param mat -> the matrix
     * @return sink row number or -1 if there is no sink
     */
 /*
    public static int isSink (int [][] mat){
        boolean [] sinkDisqualified = new boolean[mat.length]; // setting a blacklist of cells
        for (int r = 0; r< sinkDisqualified.length; r++)
            sinkDisqualified[r] = false; // set the array
        int i =0,j = 0;
        while (i < mat.length){
            if (sinkDisqualified[i]) // the row is already false
            {
                i++;
                continue;
            }
            if (j < mat.length){ // as long as we are inside the row
                if (mat[i][j] == 0){ // if the cell is 0 we can continue
                    if (i != j) //
                        sinkDisqualified[j] = true;
                    if (mat[j][i] == 1 || i == j){ // whether the col is 1 or the cell int [k][k] is 0
                        if (i != j) //
                            sinkDisqualified[j] = true; // the j row is disqualified because [j][i] has a 1
                        j++; // if so continue with the col
                    }
                    else { // if not the row is not good, return to first col and proceed to next row
                        j =0;
                        i++;
                    }
                }
                else { // if not, the row is not good, return to first col and proceed to next row
                    j =0;
                    i++;
                }
            }
            else // if we finished the search return the row number
                return i;
        }
        // edge case -> the mat size is [0][0]
        return -1; // we got here because we couldn't find any match. return -1
    }
*/

    public static int isSink (int [][] mat) {
        int row = 0, col = 0, sumR = 0, sumC = 0;
//        I'll go over the mat once. if a cell is not complaint I'm moving to the next row -> O(n)
        while (row < mat.length && col < mat[0].length) {
            if (mat[row][col] == 0)  // if the cell is good we can continue with this row
                col++;
            else  // proceed to the next
                row++;
        }
        if (row == mat.length) return -1; // row out of bound means no sink
        for (int i = 0; i < mat.length; i++) { // sum the row and col of the findings, O(n) -> iterate once
            sumC += mat[i][row]; // sum up the column, the number of row is the one of the col so we can use it like that
            sumR += mat[row][i]; // sum up the row
        }
        if (sumC == mat.length - 1 && sumR == 0) return row;
        return -1; // we got here because we couldn't find any match. return -1
    }

    /**
     * Creates a 2 dim array with 0 values form specific size
     */
    private static void createArr(int s){
        for (int i =0; i < s; i++) {
            System.out.print('{');
            for (int j = 0; j < s - 1; j++)
                System.out.print(0 + ",");
            System.out.println("0},");
        }
    }
    private static void createBooleanTrueArr(int m, int n){
        for (int i =0; i < m; i++) {
            System.out.print('{');
            for (int j = 0; j < n -1; j++)
                System.out.print(true + ",");
            System.out.println("true},");
        }
    }
    private static void createBooleanFalseArr(int m, int n){
        for (int i =0; i < m; i++) {
            System.out.print('{');
            for (int j = 0; j < n - 1; j++)
                System.out.print(false + ",");
            System.out.println("false},");
        }
    }

    /**
     * prints given array
     * @param a -> array
     */
    private static void printArr(int [] [] a){
            for (int i =0; i < a.length; i++) {
                System.out.print('{');
                for (int j = 0; j < a[0].length-1; j++)
                    System.out.print(a[i][j] + ",");
                System.out.println(a[i][a[0].length-1] + "}");
            }

        }
    private static void printBoolArr(boolean [] [] a){
            for (int i =0; i < a.length; i++) {
                System.out.print('{');
                for (int j = 0; j < a[0].length-1; j++)
                    System.out.print(a[i][j] + ",");
                System.out.println(a[i][a[0].length-1] + "}");
            }

        }
// testing ex1
    private static void testMaximalDrop(){
	// write your code here
        int [] a= {5, 21, 3, 22, 12, 7, 27, 6, 4};
        int [] b = {5, 21, 3, 22, 12, 7, 26, 14};
        int [] c = {5, 15, 3, 22, 12, 7, 27, 14};
        int [] c1 = {50, 0, 51, 1, 40, 40, 40, 40};
        int [] d = {5, 21, 3, 22, 12, 7, 27, 6, 48};
        int [] e = {50, 15, 3, 22, 12, 7, 27, 14};
        System.out.println("a -> " + maximalDrop(a) + " 27-4=23");
        System.out.println("b -> " +maximalDrop(b) + " 21-4=18");
        System.out.println("c -> " +maximalDrop(c) + " 22-7=15");
        System.out.println("c1 -> " +maximalDrop(c1) + " 51-1=50");
        System.out.println("d -> " +maximalDrop(d) + " 27-6=21");
        int [] f = {50};
        System.out.println("f -> " +maximalDrop(f) + " -");
        int [] g = {1,2,3,4};
        System.out.println("g -> " +maximalDrop(g) + " ");
    }
    // testing ex2
    private static void testIsSink(){
        //        printArr();
        int [] [] a =
                {
                        {0,0,0,0,0,0,0,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0}
                };
        System.out.println("a ->" + isSink(a));
        int [] [] e =
                {
                        {0,0,0,0,0,1},
                        {0,0,0,0,0,1},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,1},
                        {0,0,0,0,0,1},
                        {0,0,0,0,0,1}
                };
        System.out.println("e ->" +isSink(e));
        int [] [] b =
                {
                        {0,0,0,0,0,1},
                        {0,0,0,0,0,1},
                        {0,0,0,0,0,1},
                        {0,0,0,0,0,1},
                        {0,0,0,0,0,1},
                        {0,0,0,0,0,0}
                };
        System.out.println("b ->" +isSink(b));
        int [] [] c = {
                {0,1,0,1,1,0},
                {1,0,1,1,0,0},
                {0,0,0,1,0,1},
                {0,0,0,0,0,0},
                {1,0,1,1,0,0},
                {0,1,0,1,1,1}};
        int [] [] d = {
                {0,1,0,0,0,1},
                {1,0,0,1,1,1},
                {0,0,0,0,0,0},
                {1,1,1,1,1,1},
                {0,1,0,1,0,1},
                {1,0,0,0,1,0}};
        System.out.println("A ->" +isSink(c));
        System.out.println("B ->" +isSink(d));
//        createArr();
//        System.out.println(a);

    }

    /**
     * this is a recursive static method that determines the size of a "stain" in the matrix.
     * stain is sequence of cells with the value of True
     * @param mat -> boolean matrix
     * @param x -> x position of the start of the search in the matrix
     * @param y -> y position of the start of the search in the matrix
     * @return the size of a "stain" in the matrix.
     */
    public static int size (boolean[][] mat, int x, int y) {
        if (mat.length == 0)
            return 0;
        boolean [][] visited = new boolean[mat.length][mat[0].length];
        fillBlanks(visited,0,0);
        System.out.println("visited:");
        printBoolArr(visited);
        System.out.println();
        return getSize(mat,x,y, visited);
    }

    /**
     * this is a recursive helper method that checks if a cell has already been visited before
     * @param mat -> the matrix we are searching on
     * @param x -> x position of the start of the search in the matrix
     * @param y -> y position of the start of the search in the matrix
     * @param visited -> second metrics which remembers whether or not a cell haa been visited
     * @return the size of a "stain" in the matrix.
     */
    private static int getSize(boolean[][] mat, int x, int y,boolean[][] visited){
        if (x > mat.length - 1 || y > mat[0].length - 1 || x < 0 || y < 0)
            return 0;
        if (mat[x][y] && !visited[x][y]){
            visited[x][y] = true;
            return 1 + getSize(mat,x+1,y, visited) // one to the right
                    + getSize(mat,x -1,y, visited) // one to the left
                    + getSize(mat,x ,y + 1, visited) // one up
                    + getSize(mat,x,y - 1, visited) // one down
                    + getSize(mat,x - 1,y + 1, visited) // one to the left and down
                    + getSize(mat,x - 1,y - 1, visited) // one to the left and up
                    + getSize(mat,x + 1,y - 1, visited) // one to the right and up
                    + getSize(mat,x + 1,y + 1, visited); // one to the right and down
        }
        return 0;
    }

    /**
     * A recursive method that fills a blank matrics with false value
     * (the request was to make all the methods recursive)
     * @param mat -> the matrics we are filling
     * @param x -> the x value of the cell we are currently filling
     * @param y -> the y value of the cell we are currently filling
     */
    private static void fillBlanks(boolean[][] mat,int x,int y){
        if (x < mat.length && y < mat[0].length){
            mat[x][y] = false;
            fillBlanks(mat,x+1,y);
            fillBlanks(mat,x,y+1);
        }
    }
    public static void testSize(){
        createBooleanTrueArr(5,5);
        createBooleanFalseArr(5,5);
        //        testSize();
        boolean [] [] mat1 = {
                {true,true,true,true,true},
                {true,true,true,true,true},
                {true,true,true,true,true},
                {true,true,true,true,true},
                {true,true,true,true,true}
        };
        boolean [] [] mat2 =
                {
                        {false,false,false,false,false},
                        {false,false,false,false,false},
                        {false,false,false,false,false},
                        {false,false,false,false,false},
                        {false,false,false,false,false}
                };
        boolean [] [] mat3 =
                {
                        {false,true,false,false,true},
                        {true,false,false,true,true},
                        {false,false,true,true,false},
                        {true,false,false,false,false},
                        {true,true,true,false,false}
                };
        System.out.println("mat 3: ");
        printBoolArr(mat3);
        System.out.println();

        System.out.println("mat3,0,1 -> " + size(mat3,0,1) + " needs to be 2");
        System.out.println("mat3,1,3 -> " + size(mat3,1,3) + " needs to be 5");
        System.out.println("mat3,4,0 -> " + size(mat3,4,0) + " needs to be 4");
        System.out.println("mat3,4,4 -> " + size(mat3,4,4) + " needs to be 0");
        int l = size(new boolean[][]{
                {true,false},
                {false,true}
        }, 0, 0);
        System.out.println(2 + " " + l);
    }

    /**
     * A recursive method that deremines is two arrays have the exact same numbers
     * @param a -> array 1
     * @param b -> array 2
     * @return true if the numbers are sam
     */
    public static boolean isPermutation (int [] a, int [] b){
        if (a.length != b.length) //edge case -> the arrays are not the same lenght
            return false;
        boolean [] isVisited = new boolean[b.length];
        fillIsVisited(isVisited,0);
        return isPermutation(a,0, b,isVisited);
    }

    /**
     * helper method that checks on all the cells in the first array
     * @param a -> the first array
     * @param ai -> array one index
     * @param b -> the second array
     * @return true if all the cells in a are in b
     */
    private static boolean isPermutation (int [] a,int ai, int [] b,boolean [] isVisited){
        if (ai == a.length -1) //check last cell
        {
            if (a.length > 1)
                return isPermutation(a,ai,b,0, isVisited);
            return a[ai] == b[ai]; // edge case -> both array are one cell length
        }
        if (ai < a.length){
            return isPermutation(a,ai,b,0, isVisited) && isPermutation(a,ai+1,b, isVisited);
        }
        return false; // edge case -> index oob -> null array
    }

    /**
     * helper method that checks on all the cells in the second array
     * @param a -> the first array
     * @param ai -> array one index
     * @param b -> the second array
     * @param bi -> array two index
     * @return true if found cell in b
     */
    private static boolean isPermutation (int [] a,int ai, int [] b, int bi, boolean [] isVisited){
        if (bi < b.length){
            if (a[ai] == b[bi] && !isVisited[bi]){ // validate that we don't repeat steps
                isVisited[bi] = true;
                return true;
            }
            return isPermutation(a,ai,b,bi+1, isVisited);
        }
        return false;
    }

    /**
     * private method that fills the array with the values of false
     * @param isVisited -> the given array
     * @param i -> the index
     */
    private static void fillIsVisited(boolean [] isVisited, int i){
        if (i < isVisited.length){
            isVisited[i] = false;
            fillIsVisited(isVisited,i+1);
        }
    }



}


