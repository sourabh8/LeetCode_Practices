public class SortedArrayToBST {
    static Node root;

    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int value){
            this.val = value;
        }
    }

    public static void main(String args[]){
            int[] nums = {20,23,34,46,50};
            SortedArrayToBST bst = new SortedArrayToBST();
            bst.inOrderTraversal(bst.createBST(nums,0,nums.length-1));

    }

    public Node createBST(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int middleIndex = start + (end - start) / 2;
        Node root = new Node(nums[middleIndex]);
        root.left = createBST(nums,start,middleIndex-1);
        root.right = createBST(nums,middleIndex+1,end);
        return root;
    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            inOrderTraversal(root.left);
            System.out.println("Value of Node --->" + root.val);
            inOrderTraversal(root.right);
        }

    }
}
