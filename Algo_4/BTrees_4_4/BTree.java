/*
BT.1.    Implement the following methods for a binary tree that each take as argument a Node that is the root of a binary tree.
        size(): number of nodes in the tree.
        leaves(): number of nodes whose links are both null
        total(): sum of the key values in all nodes

    Your methods should all run in linear time.
*/



package JavaBook.Algo_4.BTrees_4_4;

public class BTree<K extends Comparable & Iterable<K>, V> {

    private final Node root;        
    //private int size;             

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        
        private Node(K in_key, V in_value) {
            this.key = in_key;
            this.value = in_value;
        }
    }
    
    public BTree() {
        root = null;
        //size = 0;
    }
    
    public BTree(K in_key, V in_value) {
        root = new Node(in_key, in_value);
        //size = 0;
    }
    
    public int size() {
        int size = 1;
        if(this.root.left != null) {
            
        }
        if(this.root.right != null) {
            
        }       
        return size;
    }

    public int leaves(BTree root) {
     
    }

    public int total(BTree root) {
   
    }   
}    
