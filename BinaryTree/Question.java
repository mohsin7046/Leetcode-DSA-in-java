package BinaryTree;
import java.util.*;

public class Question {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Que:1 Check if Tree is Univalued or not
    public static boolean uniValuedTree(Node root) {
        // If tree is an empty tree
        if (root == null) {
            return true;
        }

        // If all the nodes on the left subtree have not value equal to root node
        if (root.left != null && root.data != root.left.data)
            return false;

        // If all the nodes on the left subtree have not value equal to root node
        if (root.right != null
                && root.data != root.right.data)
            return false;

        // Recurse on left and right subtree
        return uniValuedTree(root.left)
                && uniValuedTree(root.right);

    }

    //Que:2 Invert the tree
    public static Node invertTree(Node root) {
        if (root == null) {
            return null;
        }
        
        //swap the right side to the left side 
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    //Que:3 Delete the LeafNode which is equal to the target(and also if leafnode is delete check parent is convert to leafNode and equal to taget) 
    public static Node deleteLeafNode(Node root, int target) {
        if(root == null){
            return root;
        }

        root.left = deleteLeafNode(root.left, target);  
        root.right = deleteLeafNode(root.right, target);

        if(root.left == null && root.right == null && root.data == target){
            return null;
        }

        return root;
    }


    //find Duplicate a Tree
     public static List<Node> findDuplicateSubtrees(Node root) {
        List<Node> res=new ArrayList<>();
        HashMap<String,Integer> hm=new HashMap<>();
        helper(res,root,hm);
        return res;
    }

    public static String helper(List<Node> res,Node root,HashMap<String,Integer> hm){
        if(root==null)
            return "";
        String left=helper(res,root.left,hm);
        String right=helper(res,root.right,hm);
        int currroot=root.data;
        String stringformed=currroot+"$"+left+"$"+right;
        // if the hashmap contains the stringformed and the value is 1, it means the subtree is duplicate
        if(hm.getOrDefault(stringformed,0)==1){
            res.add(root);
        }
        // increment the value of the stringformed in the hashmap
        hm.put(stringformed,hm.getOrDefault(stringformed,0)+1);
        return stringformed;
    }



    //Que:4 Maximum path sum in Binary Tree
    private static int result;
    public static int maxSum(Node root) {
         result = Integer.MIN_VALUE;
        maxPathSum(root);
        return result;
    }

    public static int maxPathSum(Node root) {
        if(root == null){
            return 0;
        }

        int leftMax = maxPathSum(root.left);
       int rightMax = maxPathSum(root.right);
        //ignoring negative value
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        //compute with splitting node
        result = Math.max(result, root.data + leftMax + rightMax);

        //compute without splitting node    
        return root.data + Math.max(leftMax, rightMax);
    }


    //Que:5 Serialize and deserialize Binary Tree
    public static String serialize(Node root) {
        ArrayList<String> sb = new ArrayList<>();
        ser_preOrder(root, sb);
        return String.join(",", sb);
    }

    public static void ser_preOrder(Node root, ArrayList<String> sb) {
        if (root == null) {
            sb.add("N");
            return;
        }
        sb.add(String.valueOf(root.data));
        ser_preOrder(root.left, sb);
        ser_preOrder(root.right, sb);
    }

    //Deserialize the String to the Binary Tree
    private static int count = 0;
    public static Node deserialize(String data) {
        String[] vals = data.split(",");
        Node newNode = des_preOrder(vals);
        return newNode;
    }

    public static Node des_preOrder(String[] vals) {
        if(vals[count].equals("N")){
            count++;
            return null;
        }
        Node node = new Node(Integer.parseInt(vals[count++]));
        node.left = des_preOrder(vals);
        node.right = des_preOrder(vals);
        return node;
    }

    //Que:6 level Order Traversal-II
    public static List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        levellist(root, 0, res);
        Collections.reverse(res);
        return res;
    }
    public static void levellist(Node root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.data);
        levellist(root.left, level + 1, res);
        levellist(root.right, level + 1, res);
    }
    

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(5);
        root.left.right = new Node(1);
        root.right.left = new Node(1);
        root.right.right = new Node(1);

        // System.out.println(uniValuedTree(root));

        // System.out.println(invertTree(root).data);

        // System.out.println(deleteLeafNode(root, 1).data);

        System.out.println(findDuplicateSubtrees(root).get(0).data);


        Node root2 = new Node(-10);
        root2.left = new Node(9);
        root2.right = new Node(20);
        root2.left.left = new Node(15);
        root2.left.right = new Node(7);

        System.out.println(maxSum(root2));

        String str = serialize(root2);
        System.out.println(str);
        System.out.println(deserialize(str).data);

        List<List<Integer>> res = levelOrderBottom(root2);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
        }
    }
}
