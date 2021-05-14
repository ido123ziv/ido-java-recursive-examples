package com.company;

/**
 * Maman14
 * @author Ido Ziv
 * @version 13-05-2021
 */

public class Main {

    public static void main(String[] args) {
        int [] a = {1,2,3,4};
        int [] b = {4,2,3,1};
        int [] b1 = {0,2,3,1};
        int [] b2 = {5,2,3,1};
        System.out.println("is permutation a & b: "  + isPermutation(a,b) + " needs to be true");
        System.out.println("is permutation b1 & b2: "  + isPermutation(b1,b2) + " needs to be false");
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
    public static int isSink (int [][] mat){
        int i =0,j = 0;
        while (i < mat.length){
            if (j < mat.length){ // as long as we are inside the row
                if (mat[i][j] == 0){ // if the cell is 0 we can continue
                    if (mat[j][i] == 1 || i == j){ // whether the col is 1 or the cell int [k][k] is 0
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

    /**
     * Creates a 2 dim array with 0 values form specific size
     */
    public static void createArr(int s){
        for (int i =0; i < s; i++) {
            System.out.print('{');
            for (int j = 0; j < s - 1; j++)
                System.out.print(0 + ",");
            System.out.println("0},");
        }
    }
    public static void createBooleanTrueArr(int m, int n){
        for (int i =0; i < m; i++) {
            System.out.print('{');
            for (int j = 0; j < n -1; j++)
                System.out.print(true + ",");
            System.out.println("true},");
        }
    }
    public static void createBooleanFalseArr(int m, int n){
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
    public static void printArr(int [] [] a){
            for (int i =0; i < a.length; i++) {
                System.out.print('{');
                for (int j = 0; j < a[0].length-1; j++)
                    System.out.print(a[i][j] + ",");
                System.out.println(a[i][a[0].length-1] + "}");
            }

        }
    public static void printBoolArr(boolean [] [] a){
            for (int i =0; i < a.length; i++) {
                System.out.print('{');
                for (int j = 0; j < a[0].length-1; j++)
                    System.out.print(a[i][j] + ",");
                System.out.println(a[i][a[0].length-1] + "}");
            }

        }
// testing ex1
     public static void testMaximalDrop(){
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
    public static void testIsSync(){
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
        int [] [] c = {{0,1,0,1,1,0},
                {1,0,1,1,0,0},
                {0,0,0,1,0,1},
                {0,0,0,0,0,0},
                {1,0,1,1,0,0},
                {0,1,0,1,1,1}};
        int [] [] d = {{0,1,0,0,0,1},
                {1,0,0,1,1,1},
                {0,0,0,0,0,0},
                {1,1,1,1,1,1},
                {0,1,0,1,0,1},
                {1,0,0,0,1,0}};
        System.out.println("c ->" +isSink(c));
        System.out.println("d ->" +isSink(d));
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
    public static int getSize(boolean[][] mat, int x, int y,boolean[][] visited){
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
    public static void fillBlanks(boolean[][] mat,int x,int y){
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
    }
    public static boolean isPermutation (int [] a, int [] b){
        return isPermutation(a,0, b);
    }
    public static boolean isPermutation (int [] a,int ai, int [] b){
        if (ai == a.length -1) //check last cell
        {
            if (a.length > 1)
                return isPermutation(a,ai,b,0);
            return a[ai] == b[ai]; // edge case -> both array are one cell length
        }
        if (ai < a.length){
            return isPermutation(a,ai,b,0) && isPermutation(a,ai+1,b);
        }
        return false; // edge case -> index oob -> null array
    }
    public static boolean isPermutation (int [] a,int ai, int [] b, int bi){
        if (bi < b.length)
            return a[ai] == b[bi] || isPermutation(a,ai,b,bi+1);
        return false;
    }



}


