/*
BT.1.    Implement the following methods for a binary tree that each take as argument a Node that is the root of a binary tree.
        size(): number of nodes in the tree.
        leaves(): number of nodes whose links are both null
        total(): sum of the key values in all nodes

    Your methods should all run in linear time.
*/



package JavaBook.Algo_4.BTrees_4_4;

 

public class BTree {

    private Node root;        
    //private int size;             

    private class Node {
        int value;
        BTree left;
        BTree right;
        
        private Node(int in_value) {
            this.value = in_value;
        }
    }
    
    public BTree() {
        root = null;
        //size = 0;
    }
    
    public BTree(int value) {
        root = null;
        //size = 0;
    }
    
    public int size(BTree rootA) {
        int size = 1;
        if(rootA.root.left != null) {
            size += size(rootA.root.left);
        }
        if(rootA.root.right != null) {
            size += size(rootA.root.right);
        }       
        return size;
    }

    public int leaves(BTree root) {
     
    }

    public int total(BTree root) {
   
    }   
}    
