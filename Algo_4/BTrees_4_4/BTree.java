/*
BT.1.    Implement the following methods for a binary tree that each take as argument a Node that is the root of a binary tree.
        size(): number of nodes in the tree.
        leaves(): number of nodes whose links are both null
        total(): sum of the key values in all nodes

    Your methods should all run in linear time.
*/



package JavaBook.Algo_4.BTrees_4_4;

import java.util.Arrays;
import java.util.Random;

public class BTree<V> {

    public Node root;                    

    public class Node {
        int key;
        V value;
        Node left;
        Node right;
        
        private Node(int in_key, V in_value) {
            this.key = in_key;
            this.value = in_value;
        }
    }
    
    public BTree() {
        root = null;
    }
    public BTree(int in_key, V in_value) {
        root = new Node(in_key, in_value);
    }

    public void put(int key, V value) {
        root = put(root, key, value);
    }
    private Node put(Node aNode, int key, V value) {
        if (aNode == null) {
            aNode = new Node(key, value);
        }
        else if (key < aNode.key) {
            aNode.left = put(aNode.left, key, value);
        }
        else if (key > aNode.key) {
            aNode.right = put(aNode.right, key, value);
        }
        else aNode.value = value;
        return aNode;
    }        
    
    public V get(int key) {
        return get (root, key);
    }
    private V get(Node aNode, int key) {
        if (aNode == null) {
            return null;
        }
        else if (key < aNode.key) {
            return get(aNode.left, key);
        }
        else if (key > aNode.key) {
            return get(aNode.right, key);
        }
        else return aNode.value;
    }    

    public int size() {
        return size(this.root);
    }
    private int size(Node _root) {
        if (_root == null) {
            return 0;
        }
        int size = 1;
        size += size(_root.left);
        size += size(_root.right);
        return size;
    }

    public int leaves() {
        return leaves(this.root);
    }
    private int leaves(Node _root) {
        int leaves = 0;
        if (_root.left == null && _root.right == null) {
            leaves++;
        }
        else{
            if(_root.left != null) {
                leaves += leaves(_root.left);
            }
            if(_root.right != null) {
                leaves += leaves(_root.right);
            } 
        }
        return leaves;
    }

    public int total() {
        return total(this.root);
    }    
    private int total(Node _root) {
        int sum = _root.key;
        if(_root.left != null) {
            sum += total(_root.left);
        }
        if(_root.right != null) {
            sum += total(_root.right);
        }       
        return sum;   
    }   

    public int height() {
        return height(this.root, 0, 0);
    }
    private int height(Node aNode, int currentMax, int globalMax) {
        if (aNode == null) {
            return globalMax;
        }
        else if (aNode.left == null && aNode.right == null) {
            return Math.max(++currentMax, globalMax);
        }
        else {
            currentMax ++;
            globalMax = this.height(aNode.left, currentMax, globalMax);
            globalMax = height(aNode.right, currentMax, globalMax);
            return globalMax;
        }
    }
    
    public static void main(String[] args) {
        BTree<String> myTree = new BTree<>();
        int tests = 10;
        int[] testsVal = new int[tests];
        for (int i = 0; i < tests; i++) {
            testsVal[i] = i;
        }
        shuffleArray (testsVal);
        // myTree.put(1,"Some");
        // System.out.println("Root: " + myTree.root.value);
        
        for (int i = 0; i < tests; i++) {
            myTree.put(testsVal[i], "String number "+ i + " (key " + testsVal[i] + ")");
        }
        

        shuffleArray (testsVal);
        for (int i = 0; i < tests; i++) {
            // System.out.println("trying to get number "+ testsVal[i] + ":");
            System.out.println("key " + testsVal[i] + ": " + myTree.get(testsVal[i]));        
        }
        
        System.out.println("Size of the tree = " + myTree.size());
        System.out.println("Number of leaves in the tree = " + myTree.leaves());
        System.out.println("Height of the tree = " + myTree.height());
        System.out.println("SUm of the keys in the tree = " + myTree.total());
        

        
    }
    
    private static void shuffleArray(int[] a) {
        Random random = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    }
}    
