package BinaryTree;
import java.util.*;

public class Subtree_Tree {
     static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Top view of Tree

    public static boolean isIdentical(Node root,Node subroot){
        if(root == null && subroot == null){
            return true;
        }else if(root == null || subroot == null || root.data != subroot.data){
            return false;
        }

        //not identical
        if(!isIdentical(root.left, subroot.left)){
            return false;
        }
        if(!isIdentical(root.right, subroot.right)){
            return false;
        }

        //indentical
        return true;

    }

     
    public static boolean isSubtree(Node root,Node subroot){
        if(root == null){
            return false;
        }
        //if subroot.data is present at root
        if(root.data == subroot.data){
            if(isIdentical(root, subroot)){
                return true;
            }
        }

        //if subroot.data isnot present at root, so find at right & left node
        boolean leftAns = isSubtree(root.left, subroot);
        boolean rightAns = isSubtree(root.right, subroot);

        return leftAns || rightAns;
    }


   //Kth level of the Tree(Recursive Method - O(N))
   public static void kthLevel(Node root,int level,int k){
       if(root == null){
        return;
       }

       if(level == k){
        System.out.print(root.data+" ");
        return;  //because it below level are greater than k 
       }

       kthLevel(root.left,level+1,k);
       kthLevel(root.right, level+1, k);
   }


   //Lowest Common Ancestor of two nodes in a Tree
   public static Node commonAncestor(Node root, int n1, int n2){  //O(N)
    ArrayList <Node> path1 = new ArrayList<>();
    ArrayList <Node> path2 = new ArrayList<>();

    getpath(root,n1,path1);
    getpath(root,n2,path2);

    //checking both path value
    // for (int index = 0; index < path1.size(); index++) {
    //     System.out.println(path1.get(index).data);
    // }
    // for (int i = 0; i < path2.size(); i++) {
    //     System.out.println(path2.get(i).data);
    // }

    //last common ancestor
    int i=0;
    for(;i<path1.size() && i < path2.size() ; i++){
        if(path1.get(i) != path2.get(i)){
            break;
        }
    }

    Node lca = path1.get(i-1);  //loop stop at i and the last ancestor is at i-1
    return lca;
   }

    public static boolean getpath(Node root,int n, ArrayList <Node> path){
        if(root == null){
            return false;
        }

        //first add the root to Arraylist
        path.add(root);
  
        if(root.data == n){
            return true;
        }

        boolean foundleft = getpath(root.left, n, path);
        boolean foundright = getpath(root.right, n, path);

        if(foundleft || foundright){
            return true;
        }

        //if not found than root is not common ancestor so delete from Arraylist
        path.remove(path.size()-1);

        return false;
    }


    //Apporach-2 for LowestCommon Ancestor(LCA)-O(N)
    public static Node lca_app2(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){  //if root itself is n1 or n2 so root become LCA
            return root;
        }

        Node leftFound = lca_app2(root.left, n1, n2);
        Node rightFound = lca_app2(root.right, n1, n2);

        if(leftFound == null){  // if left return null and right return valid value ==> LCA exist in rightside
            return rightFound;
        }
        if(rightFound == null){   // if right return null and left return valid value ==> LCA exist in leftside
            return leftFound;
        }

        return root;

    }


    //Minimum distance between nodes

    public static int distLCA(Node root, int n){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;   //if node data is equal then first itself has zero distance
        }

        //root not equal to n then find at right and left side
       int leftdist = distLCA(root.left, n);
       int rightdist = distLCA(root.right, n);

        if(leftdist == -1 && rightdist == -1){
            return -1;
        }
       else if(rightdist == -1){
            return leftdist+1;
        }
        else{
            return rightdist+1;
        }
    }

    public static int minDist(Node root,int n1,int n2){

        Node lca = lca_app2(root, n1, n2);
        int dist1 = distLCA(lca,n1);
        int dist2 = distLCA(lca,n2);

        int mindist = dist1+dist2;

        return mindist;
    }



    //Kth Ancestor of a Node in a Tree
    public static int kthAncestor(Node root,int n,int k){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftdist = kthAncestor(root.left, n, k);
        int rightdist = kthAncestor(root.right, n, k);

        if(leftdist == -1 && rightdist == -1){
            return -1;
        } 

        int max = Math.max(leftdist, rightdist);

        if(max+1 == k){
            System.out.println(root.data);
        }

        return max+1;
    }



    //Tansform a Tree to a sum Tree
    public static  int transform(Node root){

        if(root == null){
            return 0;
        }

        int leftchild = transform(root.left);
        int rightchild = transform(root.right);

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        int data = root.data;
        root.data = newLeft + leftchild + newRight + rightchild;

        return data;
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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*     1
             /   \
            2     3
           / \   / \
          4   5 6   7 

          */

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);
        // subroot.left.left = new Node(6);

        /* 
          2
         / \
        4   5

         */

        // System.out.println(isSubtree(root,subroot));

        // kthLevel(root, 1, 2);

        // System.out.println(commonAncestor(root, 4, 6).data);  //because it return the whole object location
        // System.out.println(lca_app2(root, 4, 6).data);  //Approach -2 of LCA
        // System.out.println(minDist(root, 4, 7));

        // kthAncestor(root, 4, 2);
       System.out.println(transform(root));
        preOrder(root);
    }
}
