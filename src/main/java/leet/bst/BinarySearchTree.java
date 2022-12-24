package leet.bst;

import lombok.NoArgsConstructor;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            left=null;
            right=null;
        }
        TreeNode(){
            left=null;
            right=null;
        }
    }

    TreeNode root;

    BinarySearchTree() {
        root=new TreeNode();
    }


    public BinarySearchTree getBSTNode() {
        BinarySearchTree bst= new BinarySearchTree();
        return bst;
    }

    public void insertNode(){
        TreeNode root= this.root;
        root.val = 10;
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(20);
    }

    public void inorder(TreeNode root) {

        if(root.left != null ){
            inorder(root.left);
        }
        System.out.println(root.val);

        if(root.right!= null ){
            inorder(root.right);
        }
    }

    public int rangeSumBst(TreeNode root, int low, int high) {
        if(root==null) return 0;
        if(root.val >= low && root.val<= high) {
            return root.val + rangeSumBst(root.left,low,high) + rangeSumBst(root.right,low,high);
        } else if(root.val < low){
            return rangeSumBst(root.right, low, high);
        } else {
            return rangeSumBst(root.left,low,high);
        }
    }

    public void inorderCreation(TreeNode root, List<Integer> ls) {
        if(root==null) return;

        // root.left != null go to that dir
        if(root.left!=null) {
            inorderCreation(root.left, ls);
        }

        // intialise ans and set the value
        ls.add(root.val);

        // root.right != null  go to that dir.
        if(root.right!=null)
            inorderCreation(root.right,ls);


    }

    public TreeNode increasingBst(TreeNode root) {

        List<Integer> ls =new ArrayList<>();
        inorderCreation(root,ls);
        TreeNode ans= new TreeNode(0), curr=ans;
        for(int i : ls ){
            curr.right = new TreeNode(i);
            curr=curr.right;
        }

        return ans.right;
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.root;

        bst.insertNode();
        bst.inorder(root);

        System.out.println("-----");

        // System.out.println("range sum " + bst.rangeSumBst(bst.root, 3,14));

       bst.inorder(bst.increasingBst(root).right.right);


    }

}
