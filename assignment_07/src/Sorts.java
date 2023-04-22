/* 
 * Assignment #: 7
 * Name: David Nevarez
 * StudentID: xxxxxxxxxx
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This class is used to sort the movies in the reviewList by the comparator that is passed in. It uses the Quicksort algorithm to sort the movies.
*/

import java.util.ArrayList;
import java.util.Comparator;

public class Sorts {
    
    public static void sort(ArrayList<Movie> reviewList, Comparator<Movie> xComparator) {
        /*
         * This sort method is used to sort the movies in the reviewList by the
         * comparator that is passed in. It uses the Quicksort algorithm to sort
         * the movies.
         */
        quickSort(reviewList, 0, reviewList.size() - 1, xComparator);
    }

    // This method is used to sort the movies in the reviewList using the comparator
    private static void quickSort(ArrayList<Movie> reviewList, int first, int last, Comparator<Movie> xComparator) {
        // This if statement is used to sort the movies in the reviewList using the comparator while the first index is less than the last index
        if (first < last) {
            // the following line of code is used to partition the movies in the reviewList using the comparator
            int pivotIndex = partition(reviewList, first, last, xComparator); // will return the pivot index
            quickSort(reviewList, first, pivotIndex - 1, xComparator); // will sort the movies in the reviewList using the comparator, but only the movies before the pivot index
            quickSort(reviewList, pivotIndex + 1, last, xComparator); // will sort the movies in the reviewList using the comparator, but only the movies after the pivot index
        }
    }

    // This method is used to partition the movies in the reviewList using the comparator
    private static int partition(ArrayList<Movie> reviewList, int first, int last, Comparator<Movie> xComparator) {
        Movie pivot = reviewList.get(first);
        int up = first; // the up index will represent the first index
        int down = last; // the down index will represent the last index

        // This loop is used to partition the movies in the reviewList using the comparator while the up index is less than the down index
        do {
            while ((up < last) && (xComparator.compare(reviewList.get(up), pivot) <= 0)) // while the movie at the up index is less than or equal to the pivot movie, then the up index will be incremented
                up++;
            while (xComparator.compare(reviewList.get(down), pivot) > 0) // while the movie at the down index is greater than the pivot movie, then the down index will be decremented
                down--;
            if (up < down) {
                // while any interation of the loop, if the up index is less than the down index, then the movies at the up index and the down index will be swapped
                Movie temp = reviewList.get(up);
                reviewList.set(up, reviewList.get(down));
                reviewList.set(down, temp);
            }
        } while (up < down);

        // after the loop, the movies at the first index and the down index will be swapped
        // and sets the down index as the pivot index

        reviewList.set(first, reviewList.get(down)); 
        reviewList.set(down, pivot);

        return down; // the down index will be returned
    }




    // These methods were extra methods I made to practice with sorting algorithms
    // the don't have explanations because they are just extra methods I made for practice


    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    // merge sort
    // private static void mergeSort(ArrayList<Movie> reviewList, int first, int last, Comparator<Movie> xComparator) {
    //     if (first < last) {
    //         int mid = (first + last) / 2;
    //         mergeSort(reviewList, first, mid, xComparator);
    //         mergeSort(reviewList, mid + 1, last, xComparator);
    //         merge(reviewList, first, mid, last, xComparator);
    //     }
    // }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    // private static void merge(ArrayList<Movie> reviewList, int first, int mid, int last, Comparator<Movie> xComparator) {
    //     ArrayList<Movie> temp = new ArrayList<>();
    //     int first1 = first, last1 = mid;
    //     int first2 = mid + 1, last2 = last;
    //     int index = first1;

    //     while ((first1 <= last1) && (first2 <= last2)) {
    //         if (xComparator.compare(reviewList.get(first1), reviewList.get(first2)) < 0) {
    //             temp.add(reviewList.get(first1));
    //             first1++;
    //         } else {
    //             temp.add(reviewList.get(first2));
    //             first2++;
    //         }
    //         index++;
    //     }

    //     while (first1 <= last1) {
    //         temp.add(reviewList.get(first1));
    //         first1++;
    //         index++;
    //     }

    //     while (first2 <= last2) {
    //         temp.add(reviewList.get(first2));
    //         first2++;
    //         index++;
    //     }

    //     for (index = first; index <= last; index++) {
    //         reviewList.set(index, temp.get(index - first));
    //     }
    // }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    // bubble sort
    // private static void bubbleSort(ArrayList<Movie> reviewList, int first, int last, Comparator<Movie> xComparator) {
    //     int index;
    //     for (index = first; index < last; index++) {
    //         for (int loc = first; loc < last - index + first; loc++) {
    //             if (xComparator.compare(reviewList.get(loc), reviewList.get(loc + 1)) > 0) {
    //                 Movie temp = reviewList.get(loc);
    //                 reviewList.set(loc, reviewList.get(loc + 1));
    //                 reviewList.set(loc + 1, temp);
    //             }
    //         }
    //     }
    // }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    // heap sort
    // private static void heapSort(ArrayList<Movie> reviewList, int first, int last, Comparator<Movie> xComparator) {
    //     int index;
    //     for (index = (last - first) / 2; index >= 0; index--) {
    //         reheapDown(reviewList, index, last, xComparator);
    //     }
    //     for (index = last; index > first; index--) {
    //         Movie temp = reviewList.get(first);
    //         reviewList.set(first, reviewList.get(index));
    //         reviewList.set(index, temp);
    //         reheapDown(reviewList, first, index - 1, xComparator);
    //     }
    // }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    // private static void reheapDown(ArrayList<Movie> reviewList, int root, int bottom, Comparator<Movie> xComparator) {
    //     int maxChild;
    //     int rightChild;
    //     int leftChild;

    //     leftChild = root * 2 + 1;
    //     rightChild = root * 2 + 2;
    //     if (leftChild <= bottom) {
    //         if (leftChild == bottom) {
    //             maxChild = leftChild;
    //         } else {
    //             if (xComparator.compare(reviewList.get(leftChild), reviewList.get(rightChild)) <= 0) {
    //                 maxChild = rightChild;
    //             } else {
    //                 maxChild = leftChild;
    //             }
    //         }
    //         if (xComparator.compare(reviewList.get(root), reviewList.get(maxChild)) < 0) {
    //             Movie temp = reviewList.get(root);
    //             reviewList.set(root, reviewList.get(maxChild));
    //             reviewList.set(maxChild, temp);
    //             reheapDown(reviewList, maxChild, bottom, xComparator);
    //         }
    //     }
    // }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    // insertion sort
    // private static void insertionSort(ArrayList<Movie> reviewList, int first, int last, Comparator<Movie> xComparator) {
    //     int index;
    //     for (index = first + 1; index <= last; index++) {
    //         Movie temp = reviewList.get(index);
    //         int loc = index;
    //         while ((loc > first) && (xComparator.compare(temp, reviewList.get(loc - 1)) < 0)) {
    //             reviewList.set(loc, reviewList.get(loc - 1));
    //             loc--;
    //         }
    //         reviewList.set(loc, temp);
    //     }
    // }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    // selection sort
    // private static void selectionSort(ArrayList<Movie> reviewList, int first, int last, Comparator<Movie> xComparator) {
    //     int index;
    //     for (index = first; index < last; index++) {
    //         int indexOfNextSmallest = getIndexOfSmallest(reviewList, index, last, xComparator);
    //         Movie temp = reviewList.get(index);
    //         reviewList.set(index, reviewList.get(indexOfNextSmallest));
    //         reviewList.set(indexOfNextSmallest, temp);
    //     }
    // }

    // private static int getIndexOfSmallest(ArrayList<Movie> reviewList, int first, int last, Comparator<Movie> xComparator) {
    //     Movie min = reviewList.get(first);
    //     int indexOfMin = first;
    //     int index;
    //     for (index = first + 1; index <= last; index++) {
    //         if (xComparator.compare(reviewList.get(index), min) < 0) {
    //             min = reviewList.get(index);
    //             indexOfMin = index;
    //         }
    //     }
    //     return indexOfMin;
    // }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    // binary search
    // private static int binarySearch(ArrayList<Movie> reviewList, int first, int last, Movie target, Comparator<Movie> xComparator) {
    //     int mid;
    //     if (first > last) {
    //         return -1;
    //     } else {
    //         mid = (first + last) / 2;
    //         if (xComparator.compare(target, reviewList.get(mid)) == 0) {
    //             return mid;
    //         } else if (xComparator.compare(target, reviewList.get(mid)) < 0) {
    //             return binarySearch(reviewList, first, mid - 1, target, xComparator);
    //         } else {
    //             return binarySearch(reviewList, mid + 1, last, target, xComparator);
    //         }
    //     }
    // }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    // linear search
    // private static int linearSearch(ArrayList<Movie> reviewList, int first, int last, Movie target, Comparator<Movie> xComparator) {
    //     int index;
    //     for (index = first; index <= last; index++) {
    //         if (xComparator.compare(target, reviewList.get(index)) == 0) {
    //             return index;
    //         }
    //     }
    //     return -1;
    // }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    

}

