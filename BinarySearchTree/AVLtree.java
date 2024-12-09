package BinarySearchTree;
import java.util.*;



public class AVLtree {

    public static class Node{
        int data,height;
        Node left,right;
        public Node(int data){
            this.data = data;
            height =1;
        }
    }
    
    public static Node root;
    
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    
    }
    public static int getBalance(Node root){
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }
    public static Node leftRotate(Node x)
    {
        Node y = x.right;
        Node T2 = y.left;
    
        //perform rotation
        y.left = x;
        x.right = T2;
    
        //update height
        x.height = 1 +  Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        
        //Return new node - y
        return y;
    }
    
    public static Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;
    
        //rotation
        x.right = y;
        y.left = T2;
    
        x.height = 1 +  Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
    
        //return new node - x
        return x;
    }
    
    public static Node insert(Node root, int key){
        if(root == null)
            return new Node(key);
        
        if(key < root.data){
            root.left = insert(root.left, key);
        }else if(key > root.data){
            root.right = insert(root.right, key);
        }else{
            return root;  //Duplicate key isnot allowed
        }
    
        //update root height
        root.height = 1+ Math.max(height(root.left), height(root.right));
    
        //Get root's balance factor 
        int bf = getBalance(root);
    
        //case:1 - left-left (bf > 1)
        if(bf > 1 && key<root.left.data ){
            return rightRotate(root);
        }
    
        //case:2 - Right-Right (bf < -1)
        if(bf < -1 && key > root.right.data){
            return leftRotate(root);
        }
    
        //case:3 - Left-Right
        if(bf > 1 && key > root.left.data ){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
    
        //case:4 - Right-left
        if(bf < -1 && key < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
    
        return root;
    }
    
    public static void preOrder(Node root){
        if(root == null ){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);   
        preOrder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root,10);
        root = insert(root,20);
        root = insert(root,30);
        root = insert(root,40);
        root = insert(root,50);
        root = insert(root,25);
        
        /* AVL TREE
                 30
                /  \
               20  40
              / \   \
             10 25  50
         */
        preOrder(root);
    }
}
