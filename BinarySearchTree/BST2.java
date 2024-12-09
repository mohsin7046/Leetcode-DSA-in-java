package BinarySearchTree;

import java.util.*;

public class BST2 {

    public static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    // Create a Balanced BST from a Sorted Array
    public static Node sortedBST(int arr[], int ft, int lt) {
        if (ft > lt) {
            return null;
        }

        int mid = (lt + ft) / 2;
        Node node = new Node(arr[mid]);

        // for left
        node.left = sortedBST(arr, ft, mid - 1);
        node.right = sortedBST(arr, mid + 1, lt);

        return node;

    }

    // PreOrder Traversal of BST
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Convert the BST to the Balanced BST
    // For that we convert the BST to sorted array and than convert it to Balanced
    // BST
    public static Node convertBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        // inorder sequence
        getInorder(root, list);

        // sorted inorder --> balanced BST
        root = sortedinOrderBST(list, 0, list.size() - 1);
        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);
    }

    public static Node sortedinOrderBST(ArrayList<Integer> inorder, int ft, int lt) {
        if (ft > lt) {
            return null;
        }

        int mid = (lt + ft) / 2;
        Node node = new Node(inorder.get(mid));

        // for left
        node.left = sortedinOrderBST(inorder, ft, mid - 1);
        node.right = sortedinOrderBST(inorder, mid + 1, lt);

        return node;

    }



   


    // Size of Largest BST in BT
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;
        int sum;

        public Info(boolean isBST,int size, int min, int max,int sum){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public static int maxBST = 0;
    public static int ans = 0;
    public static Info largestBST(Node root){
        if(root == null){ 
            return new Info(true,0 , Integer.MAX_VALUE, Integer.MIN_VALUE,0);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int max = Math.max(root.data,Math.max(leftInfo.max, rightInfo.max));
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));

        if(root.data >= rightInfo.min || root.data <= leftInfo.max){
            return new Info(false, size, min, max,0);
        }
        final int sum = root.data + leftInfo.sum + rightInfo.sum;
        ans = Math.max(ans, sum);

        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            
            return new Info(true, size, min, max,sum);
        }
        
        return new Info(false, size, min, max,0);
    }



    //Merge Two BST 
    // first find sorted inorder sequence of both BST and then make a final Sorted through this we make a balanced BST
    public static Node mergeBSTs(Node BST1 , Node BST2){
        ArrayList <Integer> list1 = new ArrayList<>();
        ArrayList <Integer> list2 = new ArrayList<>();

        getInorder(BST1, list1);
        getInorder(BST2, list2);

        int i = 0, j =0;
        ArrayList <Integer> finalsorted = new ArrayList<>();
        while (i<list1.size() && j < list2.size()) {
            if(list1.get(i) <= list2.get(j)){
                finalsorted.add(list1.get(i));
                i++;
            }else{
                finalsorted.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            finalsorted.add(list1.get(i));
            i++;
        }
        while(j < list2.size()) {
            finalsorted.add(list2.get(j));
            j++;
        }

        return sortedinOrderBST(finalsorted, 0, finalsorted.size()-1);
    }



     //Que: find ther closet element in BST  --> O(H)
     static int min_diff;
     static int min_diff_key;
     public static void closetele(Node root,int key){
        if(root == null){
            return ;
        }

        if(root.data == key){
            min_diff_key = key;
            return;
        }

        if(min_diff > Math.abs(root.data - key)){
            min_diff = Math.abs(root.data - key);
            min_diff_key = root.data;
        }

        if(key > root.data){
            closetele(root.right, key);
        }else{
            closetele(root.left, key);
        }
    
    }

    public static int printclosetele(Node root,int key){
        min_diff = Integer.MAX_VALUE;
        min_diff_key = -1;
        closetele(root, key);
        return min_diff_key;
    }
    

    //Que: find kth-smallest element in BST  --> O(H)
    static int count = 0;
    public static int kthsmallest(Node root,int k){
        if(root == null){
            return -1;
        }

        int left = kthsmallest(root.left, k);
        if(left != -1){
            return left;
        }   

        count ++ ;  
        if(count == k){
            return root.data;
        }

        return kthsmallest(root.right, k);
    }



    //Two Sum in BST
    public static int twosum(Node root,int key){
        if(root == null){
            return 0;
        }

        if(root.data == key){
            return key;
        }

        int left = twosum(root.left, key - root.data);
        if(left != 0){
            return left;
        }
        int right = twosum(root.right, key - root.data);
        if(right != 0){
            return right;
        }
        return 0;
    }


    
    public static boolean findTarget(Node root, int k, Set<Integer> set) {
        if(root == null) {
            return false;
        }
        if(set.contains(root.data)) {
            return true;
        } 
        set.add(k - root.data);
        return findTarget(root.left, k,set) || findTarget(root.right, k,set);
    }


    //predessor and successsor

        public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
               if(root == null ) return;
               
               // case1 : if we find the key in tree:
               //          a) pred: right most of the immediate left node(largest from the left )
               //          b) suc : left most of the immediate right node(smallest from the right)
               
               if( root.data == key){
                   // pred:
                   if( root.left != null ){
                       Node temp = root.left;
                       while(temp.right!= null){
                           temp = temp.right;
                       }
                       pre[0] = temp;
                   }
                   
                   // succ:
                   if( root.right != null ){
                       Node temp = root.right;
                       while(temp.left!= null){
                           temp = temp.left;
                       }
                       suc[0] = temp;
                   }
                   return;
               }
               
               // case2 : if we don't find the key in tree:
               //          a) recursion on left subtree if root is greater
               //          b) recursion on right subtree if root is smaller
               if( root.data > key){
                   suc[0] = root; // left subtree might not have a right subtree
                   findPreSuc(root.left ,pre, suc, key) ;
               }
               else {
                   pre[0] = root; // right subtree might not have a left subtree
                   findPreSuc(root.right, pre, suc, key) ;
               } 
               return;
           }
       
    
    

        public static void main(String[] args) {
            int arr[] = { 3, 5, 6, 8, 10, 11, 12 };

            Node node = sortedBST(arr, 0, arr.length - 1);
            preOrder(node);

            Node root = new Node(8);
            root.left = new Node(6);
            root.left.left = new Node(5);
            root.left.left.left = new Node(3);

            root.right = new Node(10);
            root.right.right = new Node(11);
            root.right.right.right = new Node(12);

            System.out.println(convertBST(root).data);

            Node root1 = new Node(50);
            root1.left = new Node(30);
            root1.left.left = new Node(5);
            root1.left.right = new Node(20);

            root1.right = new Node(60);
            root1.right.left = new Node(45);
            root1.right.right = new Node(70);
            root1.right.right.left = new Node(65);
            root1.right.right.right = new Node(80);
            Set<Integer> set = new HashSet<>();

            System.out.println("closet element of BST = "+printclosetele(root1, 6));
            System.out.println("kth smallest element = "+kthsmallest(root1, 4));
            System.out.println("Two sum in BST = " + findTarget(root1,15,set));

            Node[] pre = new Node[1];
            Node[] suc = new Node[1];
            findPreSuc(root1, pre, suc, 10);


            // expected BST:
            /*
             * 60
             * / \
             * 45 70
             * / \
             * 65 80
             */
           Info info = largestBST(root1);
           System.out.println("Largest BST in BT = "+maxBST);
           System.out.println("Sum of BST in BT = " + ans);

           Node BST1 = new Node(2);
           BST1.left = new Node(1);
           BST1.right = new Node(4);

           Node BST2 = new Node(9);
           BST2.left = new Node(3);
           BST2.right = new Node(12);

          Node rootsorted = mergeBSTs(BST1, BST2);
           preOrder(rootsorted);

        }
}
