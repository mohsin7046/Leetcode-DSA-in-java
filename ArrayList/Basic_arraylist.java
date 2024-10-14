package ArrayList;

import java.util.*;

public class Basic_arraylist {

    public static void Swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Add an element in AL -> O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Add at particular index -> O(n)
        list.add(2, 9);
        System.out.println(list); // output->[1, 2, 9, 3, 4, 5]

        // Get the element using index -> O(1)
        System.out.println(list.get(2)); // output-> 9

        // Remove the element using index -> O(n)
        list.remove(2);
        System.out.println(list); // Output -> [1, 2, 3, 4, 5]

        // Set Element at particular index -> O(n)
        list.set(2, 10);
        System.out.println(list); // output -> [1, 2, 10, 4, 5]

        // contain element {return only true or false} -> O(n)
        System.out.println(list.contains(10)); // true

        // Size of Arraylist
        System.out.println(list.size()); // 5

        // For loop in AL
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " "); // 1 2 10 4 5
        }
        System.out.println();

        // To find Maximum number in Arraylist
        int larger = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {

            larger = Math.max(larger, list.get(i));
        }
        System.out.println(larger);

        // Swap an element in Al
        Swap(list, 2, 4);
        System.out.println(list); // [1, 2, 10, 4, 5] -> [1, 2, 5, 4, 10]

        // Sorting the AL
        Collections.sort(list);
        System.out.println(list); // ascending order sorting [1, 2, 4, 5, 10]

        Collections.sort(list, Collections.reverseOrder()); // comparator Function
        System.out.println(list); // descending order sorting [10, 5, 4, 2, 1]

        // MultiDimensional ArrayList

        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        ArrayList<Integer> listfirst = new ArrayList<>();
        ArrayList<Integer> listsecond = new ArrayList<>();

        // Add element to list1 and list2
        listfirst.add(1);
        listfirst.add(2);
        listsecond.add(3);
        listsecond.add(4);

        mainlist.add(listfirst);
        mainlist.add(listsecond);
        System.out.println(mainlist); // [[1, 2], [3, 4]]

        for (int i = 0; i < mainlist.size(); i++) {
            ArrayList <Integer> currentList = mainlist.get(i);
            for (int j = 0; j < currentList.size(); j++) {
                System.out.print(currentList.get(j)+" ");          //1 2
                                                                  // 3 4
            }
            System.out.println();
        }
    }
}
