package Backtraking;

import java.util.ArrayList;

public class Solution {
    final static char[][] L = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
            { 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public static ArrayList<String> possibleWords(int arr[], int N) {

        ArrayList<String> list = new ArrayList<>();

        if (N == 0) {
            list.add("");
            return list;
        }

        bfs(0, N, list,new StringBuilder(), arr);

        return list;
    }


  

    public static void bfs(int pos, int len, ArrayList<String> list,StringBuilder sb, int arr[]) {
        if (pos == len){
           list.add(sb.toString());
           return;
            }
            else {
            char[] letters = L[arr[pos]];
            // System.out.println(L[Character.getNumericValue(D.charAt(pos))]);
            
            for (int i = 0; i < letters.length; i++)
               bfs(pos+1, len,list, new StringBuilder(sb).append(letters[i]), arr);
            }
        }

    public static void main(String[] args) {
        int a[] = { 2, 3, 4 };
        System.out.println(possibleWords(a, 3));
    }
}
