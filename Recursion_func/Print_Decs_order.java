package Recursion_func;

public class Print_Decs_order {

    public static void Desc_Order(int n)
{
    if(n == 1){
        System.out.print(n);
        return;   //It return whole call stack values
    }
    else{
        System.out.print(n+" ");
        Desc_Order(n-1);
    }
}

    public static void main(String[] args) {
        int n = 10;
        Desc_Order(n);
    }
}
