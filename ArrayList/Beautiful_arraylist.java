package ArrayList;

import java.util.ArrayList;

public class Beautiful_arraylist {

    public static ArrayList<Integer> beautifulArray(int n) {

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        for (int i = 2; i <= n; i++) {

            ArrayList<Integer> temp = new ArrayList<>();

            for (Integer e : ans) {  //for even values
                if (2 * e <= n)
                    temp.add(e * 2);
            }
            for (Integer e : ans) {  //for odd values
                if (2 * e - 1 <= n)
                    temp.add(e * 2 - 1);
            }
            ans = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n =5;
        System.out.println(beautifulArray(n));
    }

}
