package com.ty;

import java.util.Scanner;

public class Array_Diagonal {

	public static void main(String[] args) {
		  // 3
        // 3
        /*
         * 1 1 1
         * 2 2 2
         * 3 4 5
         * 
         */

        Scanner sc = new Scanner(System.in);
        int row_size = sc.nextInt(); // 3
        int col_size = sc.nextInt(); // 3
        int[][] arr = new int[row_size][col_size];

        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                arr[row_size][col_size] = sc.nextInt();
            }
        }

        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                System.out.print(arr[row_size][col_size]);
            }
        }

	}

}
