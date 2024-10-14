package Stack_Implementation;

import java.util.Stack;

public class Stock_Span {

    public static void stokeSpan(int stokes[],int span[]){
        Stack <Integer> s = new Stack<>();
        span[0] = 1;  //Because first span is always 1
        s.push(0);

        for (int i = 1; i < stokes.length; i++) {
            int currentprice = stokes[i];
            while (!s.isEmpty() && currentprice > stokes[s.peek()] ) {
                s.pop(); //all small value is popped
            }
            if(s.isEmpty()){
                span[i] = i+1;  //for the last index condition
            }else{
                int prevHigh = s.peek();
                span[i] = i-prevHigh;

            }
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int stokes[] = {100,80,60,70,60,85,100};
        int span [] = new int[stokes.length];
        stokeSpan(stokes,span);
        for (int i = 0; i < span.length; i++) {
            System.out.println("Span of "+stokes[i]+" is "+span[i] );
        }

    }
}
