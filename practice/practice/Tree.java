package practice;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private class Node {
        int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    // return;
                    break;
                }
                current = current.leftChild;
            } else if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    // return;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public void delete(int value) {
        if (root == null) {
            return;
        }
        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild.value == value) {
                    current.leftChild = helper(current.leftChild);
                    break;
                }
                current = current.leftChild;
            } else if (value > current.value) {
                if (current.rightChild.value == value) {
                    current.rightChild = helper(current.rightChild);
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    private Node helper(Node root) {
        if (root.leftChild == null) {
            return root.rightChild;
        }
        if (root.rightChild == null) {
            return root.leftChild;
        }
        Node right = root.rightChild;
        Node lastRight = findLastRight(root.leftChild);
        lastRight.rightChild = right;
        return root.leftChild;
    }

    private Node findLastRight(Node root) {
        if (root.rightChild == null) {
            return root;
        }
        return findLastRight(root.rightChild);
    }

    public void preOrder() {
        preOrder(root);
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public int height(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else if (value == current.value) {
                return heightOfNode(current);
            }

        }
        return -1;
    }

    private int heightOfNode(Node root) {
        if (root == null) {
            return -1;
        }
        if (root.leftChild == null && root.rightChild == null) {
            return 0;
        }
        return 1 + Math.max(heightOfNode(root.leftChild), heightOfNode(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {
        if (root.leftChild == null && root.rightChild == null) {
            return root.value;
        }
        int left = min(root.leftChild);
        int right = min(root.rightChild);
        return Math.min(Math.min(left, right), root.value);
    }

    public boolean equals(Tree tree2) {
        Node root2 = tree2.root;
        return equals(root, root2);
    }

    private boolean equals(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }
        return (root1.value == root2.value) &&
                equals(root1.leftChild, root2.leftChild) &&
                equals(root1.rightChild, root2.rightChild);
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.value < min) {
            return false;
        }
        if (root.value > max) {
            return false;
        }
        return isBST(root.leftChild, min, root.value - 1) && isBST(root.rightChild, root.value + 1, max);
    }

    public List<Integer> nodesAtaDistance(int distance) {
        List<Integer> list = new ArrayList<>();
        return nodesAtaDistance(root, list, distance);
    }

    private List<Integer> nodesAtaDistance(Node root, List<Integer> list, int distance) {
        if (distance == 0) {
            list.add(root.value);
            return list;
        }
        nodesAtaDistance(root.leftChild, list, distance - 1);
        nodesAtaDistance(root.rightChild, list, distance - 1);
        return list;

    }

    public void levelOrder() {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i <= heightOfNode(root); i++) {
            list = nodesAtaDistance(i);
            // System.out.println(list);
            for (int j : list) {
                list1.add(j);
            }
        }
        System.out.println(list1);
    }

    public int size() {
        List<Integer> list = new ArrayList<>();
        list = size(root, list);
        int size = list.size();
        return size;
    }

    private List<Integer> size(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        list.add(root.value);
        size(root.leftChild, list);
        size(root.rightChild, list);
        return list;
    }

    public int noOfLeaves() {
        List<Integer> list = new ArrayList<>();
        list = noOfLeaves(root, list);
        int noOfLeaves = list.size();
        return noOfLeaves;
    }

    private List<Integer> noOfLeaves(Node root, List<Integer> list) {
        if (root.leftChild == null && root.rightChild == null) {
            list.add(root.value);
            return list;
        }
        noOfLeaves(root.leftChild, list);
        noOfLeaves(root.rightChild, list);
        return list;

    }

    public int max() {
        return max(root);
    }

    private int max(Node root) {
        if (root.leftChild == null && root.rightChild == null) {
            return root.value;
        }
        int left = max(root.leftChild);
        int right = max(root.rightChild);
        return Math.max(Math.max(left, right), root.value);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else if (value == current.value) {
                return true;
            }
        }
        return false;
    }

    public boolean isSibilings(int first, int second) {
        return isSibilings(root, first, second);
    }

    private boolean isSibilings(Node root, int first, int second) {
        if (root == null) {
            return false;
        }
        if (root.leftChild == null && root.rightChild == null) {
            return false;
        }
        return (root.leftChild.value == first && root.rightChild.value == second) ||
                (root.leftChild.value == second && root.rightChild.value == second) ||
                isSibilings(root.leftChild, first, second) || isSibilings(root.rightChild, first, second);
    }

    public List<Integer> getAncesstors(int value) {
        List<Integer> list = new ArrayList<>();
        return getAncesstors(root, value, list);
    }

    private List<Integer> getAncesstors(Node root, int value, List<Integer> list) {
        // if(root.leftChild.value == value || root.rightChild.value == value){
        // list.add(root.value);
        // return list;
        // }
        if (root == null) {
            return list;
        }
        if (root.leftChild == null || root.rightChild == null) {
            return list;
        }
        if (root.leftChild.value == value || root.rightChild.value == value) {
            list.add(root.value);
            return list;
        }
        getAncesstors(root.leftChild, value, list);
        if (root.leftChild.value == value || list.contains(root.leftChild.value)
                || list.contains(root.rightChild.value)) {
            if (!list.contains(root.value))
                list.add(root.value);
        }
        getAncesstors(root.rightChild, value, list);
        if (root.rightChild.value == value || list.contains(root.leftChild.value)
                || list.contains(root.rightChild.value)) {
            if (!list.contains(root.value))
                list.add(root.value);
        }
        return list;
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.leftChild);
        System.out.print(root.value + " ");
        inOrder(root.rightChild);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.value + " ");
    }
}
