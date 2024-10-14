package Stack_Implementation;

import java.util.Stack;

public class Max_Area_Histogram {

    public static int Max_RectArea(int height []){
        Stack<Integer> s = new Stack<>();
        int max_Area = 0;
        int area =0;
       
        for (int i = 0; i < height.length; i++) {
            int count = 1;
            s.push(height[i]);
            for (int j = i; j < height.length; j++) {

                if(height[i] > height[j] && height[j] < s.peek()){
                 s.push(height[j]);
                }
                int top = s.peek();
                System.out.println("Stack top element:"+top);
                area = count * top;
                System.out.println("Area"+area);
                max_Area = Math.max(max_Area, area);
                count++;
            }
        }

        return max_Area;
    }



    public static int Max_HistArea(int height[]){
        int MaxArea = 0;
        int nsr [] = new int[height.length];  //for right smaller
        int nsl [] = new int[height.length];   //for left smaller

        //Next Smaller Right
        Stack<Integer> s = new Stack<>();

        for (int i = height.length-1; i >= 0; i--) {
            while(!s.isEmpty() && height[s.peek()] >= height[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = height.length;
            }else{
                nsr[i] = s.peek();
            }

            s.push(i);
        }

        //Next Smaller Left

         s = new Stack<>();  //for empty the stack

        for (int i = 0; i < height.length; i++) {
            while(!s.isEmpty() && height[s.peek()] >= height[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        //Current Area  width = j - i - 1 = nsr[i] - nsl[i] - 1
        for (int i = 0; i < height.length; i++) {
            int width = nsr[i] - nsl[i]-1;
            int area = height[i] * width;
            MaxArea = Math.max(MaxArea, area);
        }
        
        return MaxArea;
    }


    public static void main(String[] args) {
        int height [] = {2,1,5,6,2,3};
    //    System.out.println("Maximam area of the histogram is in O(n^2) : "+Max_RectArea(height));  // time complexity O(n^2) and space O(1)

       System.out.println("Maximam area of the histogram is in O(n) : "+ Max_HistArea(height));
    }
}
