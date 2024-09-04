package Recursion_func;


//Que: Print all binary String of size N without consecutive ones.
public class Binary_String {
    
    public static void BinaryString(int n,int last_place, String str){
        //Base case 

        if(n==0){
            System.out.println(str);
            return;
        }

        BinaryString(n-1, 0, str+"0");

        if(last_place ==0){
            BinaryString(n-1, 1, str+"1");
        }
    }

    public static void main(String[] args) {
        int n=3;
        int last_place = 0;
        String str = "";

        BinaryString(n,last_place,str);
    }
}
