/*
BT.1.    Implement the following methods for a binary tree that each take as argument a Node that is the root of a binary tree.
        size(): number of nodes in the tree.
        leaves(): number of nodes whose links are both null
        total(): sum of the key values in all nodes

    Your methods should all run in linear time.
*/



package JavaBook.Algo_4.BTrees_4_4;

public class BTree<V> {

    private final Node root;                    

    private class Node {
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
    
    public int size() {
        return size(this.root);
    }
    
    private int size(Node _root) {
        int size = 1;
        if(_root.left != null) {
            size += size(_root.left);
        }
        if(_root.right != null) {
            size += size(_root.right);
        }       
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
}    
