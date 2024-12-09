package BinarySearchTree;

import java.util.*;

public class Basic_BST {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Build a Binary Search Tree
    public static Node buildBST(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
           root.left =  buildBST(root.left, val);
        }
        else{
            root.right = buildBST(root.right, val);
        }
        return root;
    }

    
    //Inorder Traversal - Sorted Sequence
    public static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }


    //Search in BST - O(H)
    public static boolean searchBST(Node root, int key){  
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }else if(root.data > key){
            return searchBST(root.left, key);
        }else{
            return searchBST(root.right, key);
        }
    }


    //Delete a Given node
    public static Node deleteNode(Node root,int n){
        if(root.data > n){
            root.left = deleteNode(root.left, n);
        }else if(root.data < n){
            root.right = deleteNode(root.right, n);
        }else{
            //root.data == n(value) -- delete that node

            //case:1 - If value is LeafNode
            if(root.left == null && root.right == null){
                return null;
            }

            //case:2 - If value has single child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //case:3 - If value has two children
            //Then we first find IS(Inorder Successor) for the value and replace that IS with the value.
            //Is always find at leftmost node in right SubTree.
            Node IS = findinOrderSucccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);

            }
            return root;
    }

    public static Node findinOrderSucccessor(Node root){
        while(root.left == null){
            root = root.left;
        }
        return root;
    }



    //print in Range
    public static void rangePrint(Node root,int k1, int k2){
        if(root == null){
            return;
        }

        if(root.data >= k1 && root.data <= k2){
            rangePrint(root.left, k1, k2);
            System.out.print(root.data+" ");
            rangePrint(root.right, k1, k2);
        }else if(root.data < k1){
            rangePrint(root.left, k1, k2);    
        }
        else{
            rangePrint(root.right, k1, k2);   
        }
    }


    //Root to LeafNode Path
    
    public static void printAL(ArrayList <Integer> path){
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }

    public static void pathToLeaf(Node root,ArrayList <Integer> path){
        if(root == null){
            return;
        }

        path.add(root.data);

        if(root.right == null && root.left == null){
          printAL(path);     
        }

        pathToLeaf(root.left,path);
        pathToLeaf(root.right,path);
        path.remove(path.size()-1);
    }



    //Check A BST is valid
    //Simple App - If inorder traversal is sorted then it is Valid BST
    //App:2 Below
    public static boolean isValidBST(Node root, Node max , Node min){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false; 
        }

        return isValidBST(root.left, root, min) && isValidBST(root.right, max, root);
    }



    //Mirror the BST 
    public static Node mirrorBST(Node root){
        if(root == null){
            return null;
        }

        Node temp = root.right;
        root.right = root.left;
        root.left = temp;

        mirrorBST(root.left);
        mirrorBST(root.right);

        return root;
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void main(String[] args) {
        int values[] = {8,5,10,3,6,11};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
           root =  buildBST(root,values[i]);
        }
        rangePrint(root, 5, 12); // o/p - 5 6 8 10 11

        System.out.println();
        if(isValidBST(root, null , null)){
            System.out.println("Valid BST");
        }else{
            System.out.println("Not Valid BST");
        }

        System.out.println(mirrorBST(root).data);
        // inOrder(root);  // always in decreasing order bcz it is mirror of BST
        preOrder(root);

        System.out.println();
        ArrayList <Integer> path = new ArrayList<>();
        pathToLeaf(root,path);

        System.out.println(searchBST(root, 2));  // O(H)
        inOrder(root);

        // root = deleteNode(root, 10);
        // System.out.println();
        // inOrder(root);

    }
}
