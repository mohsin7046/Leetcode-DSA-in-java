package BinaryTree;

import java.util.*;


public class PreOrdre_BT {

    static class Node{
        int data ;
        Node left;
        Node right;
        public  Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        //Traversing PreOrder
        public static void preOrder(Node root){
            if(root == null){
                System.out.print(" -1 ");
                return;
            }
            System.out.print(root.data +" ");
            preOrder(root.left);
            preOrder(root.right);
        }


        //Traversing InOrder
        public static void inOrder(Node root){
            if(root == null){
                System.out.print(" -1 ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data);
            inOrder(root.right);
        }

         //Traversing postOrder
        public static void postOrder(Node root){
            if(root == null){
                System.out.println(" -1 ");
                return ;
            }

            postOrder(root);
        }

        //Traversing LevelOrder
        public static void levelOrder(Node root){
            if(root == null){
                System.out.println(" -1 ");
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);

            while(!queue.isEmpty()){
                Node temp = queue.remove();
                if(temp == null){
                    System.out.println("->null");
                    if(queue.isEmpty()){
                        break;
                    }else{
                        queue.add(null);
                    }
                }else{
                    System.out.print(temp.data+" ");
                    if(temp.left != null){
                        queue.add(temp.left);    
                    }
                    if(temp.right != null){
                        queue.add(temp.right);
                    }
                }
            }
        }

        //Height of tree
        public static int height(Node root){
            if(root == null){
                return 0 ;
            }
            return Math.max(height(root.left), height(root.right)) + 1 ;
        }

        //count of Nodes
        public static int count(Node root){
            if(root == null){
                return 0;
            }
            return count(root.left) + count(root.right) + 1;
        }

        //Sum of Nodes
        public static int sum(Node root){
            if(root == null){
                return 0;   
            }
            return sum(root.left) + sum(root.right) + root.data;

        }

        //Diameter of the Tree - O(N^2)
        public static int diameterSum(Node root){
            if(root == null){
                return 0;
            }
            int ldiam = 0;
            int rdiam = 0;
            int rh = 0,lh = 0;

                ldiam = diameterSum(root.left);
                lh = height(root.left);
             
                rh = height(root.right);
                rdiam = diameterSum(root.right);
             
               int selfdiam = lh+rh+1;
             
             return Math.max(selfdiam,Math.max(ldiam,rdiam));
        }


        //Approach:2 for diameter of tree - O(N)  {not call recursive function for height}

        static class Info{
            int diameter;
            int height;

            public Info(int diameter,int height){
                this.diameter = diameter;
                this.height = height;
            }
        }

        public static Info diameter2(Node root){
            if(root == null){
                return new Info(0, 0);
            }

            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);

            int finaldiameter = Math.max(leftInfo.height + rightInfo.height + 1,Math.max(leftInfo.diameter,rightInfo.diameter)); 
           int ht = Math.max(leftInfo.height,rightInfo.height) + 1;

            return new Info(finaldiameter,ht);   
         }
    }


    public static void main(String[] args) {
        int nodes [] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree b = new BinaryTree();
       Node root =  b.buildTree(nodes);
       System.out.println(root.data);  //return 1 bcz it is root node

       b.preOrder(root);
       System.out.println();
       b.inOrder(root);
       b.levelOrder(root);
       System.out.println(b.height(root));
       System.out.println(b.count(root));
       System.out.println(b.sum(root));
       System.out.println(b.diameterSum(root));

       System.out.println(b.diameter2(root).diameter);
    }
}
