import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int val) {
            this.value = val;
        }
    }

    public Node root;

    public BST() {
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        } else if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            inOrderTraversal(root.left);
            System.out.println("Value of Node --->" + root.value);
            inOrderTraversal(root.right);
        }

    }

    public void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println("Node Value --->" + root.value);
        }

    }

    public void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.println("Node Value --->" + root.value);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);

        }

    }

    public List<List<Integer>> BFS(Node root) {
        List<List<Integer>> answerList = new ArrayList<>();
        if (root == null) {
            return answerList;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int queueSize = queue.size();
                List<Integer> currentList = new ArrayList<>();
                    for(int i =0; i<queueSize;i++){

                        Node temp = queue.poll();
                        currentList.add(temp.value);
                        if (temp.left != null) {
                            queue.add(temp.left);
                        }
                        if (temp.right != null) {
                            queue.add(temp.right);
                        }
                }
               answerList.add(currentList);
            }
        }
        return answerList;
    }
}













