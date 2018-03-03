package com.puneettokhi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by puneettokhi on 3/17/17.
 */
public class NutsNBolts {

    public static void main(String[] args) throws IOException

    {


        Scanner sc1 = new Scanner(new File("src/nuts.txt"));        // reads the data from the text files
        Scanner sc2 = new Scanner(new File("src/bolts.txt"));


        ArrayList<Integer> nuts_list = new ArrayList<Integer>();   // creating an array list of nuts


        while (sc1.hasNextInt()) {

            nuts_list.add(sc1.nextInt());     // fill the nuts_list with the data from the nuts.txt file
        }

        /*  Integer[] nuts_array = nuts.toArray(new Integer[0]);  */

        System.out.println("\n\nReading nuts from file:\n");
        for (int i = 0; i < nuts_list.size(); i++) {

            System.out.print(nuts_list.get(i) + " ");    // displays the content from the nuts.txt file
        }


        ArrayList<Integer> bolts_list = new ArrayList<Integer>();   // creating an array list of bolts

        while (sc2.hasNextInt()) {

            bolts_list.add(sc2.nextInt());             // fills the bolts_list with the data from the bolts.txt file
        }

        System.out.println("\n\nReading bolts from file:\n");

        /*  Integer[] bolts_array = bolts.toArray(new Integer[0]); */

        for (int i = 0; i < bolts_list.size(); i++) {

            System.out.print(bolts_list.get(i) + " ");        // // displays the content from the nuts.txt file
        }

        sort_NutsNBolts(nuts_list,bolts_list,0, nuts_list.size()-1 );   // calling the sort_NutsNBolts function

        System.out.println("\n\nSorted Nuts:\n");

        for (int i = 0; i < nuts_list.size(); i++) {

            System.out.print(nuts_list.get(i)+ " ");    // displays the sorted numbers from the nuts.txt file

        }

        System.out.println("\n\nSorted Bolts:\n");

        for (int i = 0; i < bolts_list.size(); i++) {

            System.out.print(bolts_list.get(i)+ " ");     // displays the sorted numbers from the nuts.txt file

        }
        System.out.println("\n");
    }


    // This method sorts the contents of the nuts and bolts present in the text file

    public static void sort_NutsNBolts(ArrayList<Integer> nuts, ArrayList<Integer> bolts, int start, int end) {

        if (start < end) {     // to make sure arrayList does not go out of bounds

            int pivot = sort_it(nuts, bolts.get(end), start, end);  // we initialize pivot with the value returned from the sort_it method coded below

            sort_it(bolts, nuts.get(pivot), start, end );   // calling the sort_it method

            sort_NutsNBolts(nuts, bolts, start, pivot - 1);   // recursive call to the function and in this case end is
            // set as (pivot - 1) to account for the numbers to the left of the pivot


            sort_NutsNBolts(nuts, bolts, pivot + 1, end);  // recursive call to the function and in this case start is
            // set as (pivot + 1) to account for the numbers to the right of the pivot
        }
    }

    // This method does the sorting of the nuts and bolts and uses algorithm similar to
    // randomized quickSort where pivot is picked at random, thus achieving, 0(n log n) complexity.

    public static int sort_it(ArrayList<Integer> array_list, int pivot, int start, int end) {

        int i = start;     // set i to the starting position of the list

        int temp_variable1, temp_variable2;    // local variables

        for (int j = start; j < end; j++) {   // for loop which loops till the end of the list

            if (array_list.get(j) < pivot) {         // if elements in array are less than the pivot point

                // The code below is used to swap the array_list with index i and j


                temp_variable1 = array_list.get(i);   // storing the contents of arrayList in a temporary variable

                array_list.set(i, array_list.get(j));     // sets the array_list content to array_list.get(j) in the ith position
                array_list.set(j, temp_variable1);        // swaps i and j by using temp_variable

                i++;    // increment i to move on to next element


            } else if (array_list.get(j) == pivot) {     // if elements in array are equal to pivot point

                temp_variable1 = array_list.get(j);   // storing the contents of arrayList in a temporary variable

                array_list.set(j, array_list.get(end));   // sets the array_list content to array_list.get(end) with set the
                // last element in the jth position

                array_list.set(end, temp_variable1);    // swaps i and j by using temp_variable1
                j--;    // decrement the j since the pivot is found
            }
        }

        // After the for loop ends, a temp_variable is used to place the sorted contents in the array list

        temp_variable2 = array_list.get(i);
        array_list.set(i, array_list.get(end));       // correct swapping takes place in the arrayList here
        array_list.set(end, temp_variable2);

        return i;    // returns the correct index position of the pivot

    }
}

