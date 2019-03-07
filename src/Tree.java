
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Tree<Item extends Comparable<Item>> {
    // If the tree is empty, root is a null reference.


    private Node<Item> root = null;
    // A node of a tree contains a label, and optionally
    // references to the roots of its left and right subtrees,
    // which might be null if the subtrees are empty.

    public static class Node<Item> {

        public Node<Item> left = null;
        public Node<Item> right = null;
        public Item el = null;
        // Will print out the binary node structure

        public void print() {
            print("", true);
        }

        private void print(String prefix, boolean isTail) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + el.toString());
            if (right != null) {
                right.print(prefix + (isTail ? "    " : "│   "), false);
            }
            if (left != null) {
                left.print(prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }
    // For unit testing purposes

    public void setRoot(Node<Item> newRoot) {
        root = newRoot;
    }

    public Node<Item> getRoot() {
        return root;
    }

    // This method constructs the following
    // example tree with 5 in the root:
    //
    //   __5__
    //  /     \
    // /       \
    // 1       8
    //  \     /  \
    //  2    1    3
    //      / \
    //     5   7

    public static Tree<Integer> exampleTree() {
        Node<Integer> t = new Node<Integer>();
        t.el = 5;
        Node<Integer> t1 = new Node<Integer>();
        t.left = t1;
        t1.el = 1;
        Node<Integer> t2 = new Node<Integer>();
        t.right = t2;
        t2.el = 8;
        Node<Integer> t12 = new Node<Integer>();
        t1.right = t12;
        t12.el = 2;
        Node<Integer> t21 = new Node<Integer>();
        t2.left = t21;
        t21.el = 1;
        Node<Integer> t22 = new Node<Integer>();
        t2.right = t22;
        t22.el = 3;
        Node<Integer> t211 = new Node<Integer>();
        t21.left = t211;
        t211.el = 5;
        Node<Integer> t212 = new Node<Integer>();
        t21.right = t212;
        t212.el = 7;
        Tree<Integer> res = new Tree<Integer>();
        res.root = t;
        return res;
    }

    // This method constructs the following
    // example binary tree with 4 in the root:
    //
    //      __4__
    //     /     \
    //    /       \
    //   1         8
    //    \       / \
    //     2     6   9
    //          / \
    //          5 7
    public static Tree<Integer> exampleTreeBin() {
        Node<Integer> t = new Node<Integer>();
        t.el = -23;
        Node<Integer> t1 = new Node<Integer>();
        t.left = t1;
        t1.el = 16;
        Node<Integer> t2 = new Node<Integer>();
        t.right = t2;
        t2.el = 20;
        Node<Integer> t12 = new Node<Integer>();
        t1.right = t12;
        t12.el = 2;
        Node<Integer> t21 = new Node<Integer>();
        t2.left = t21;
        t21.el = 6;
        Node<Integer> t22 = new Node<Integer>();
        t2.right = t22;
        t22.el = 9;
        Node<Integer> t211 = new Node<Integer>();
        t21.left = t211;
        t211.el = 5;
        Node<Integer> t212 = new Node<Integer>();
        t21.right = t212;
        t212.el = 7;

        Tree<Integer> res = new Tree<Integer>();
        res.root = null;
        return res;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<Item> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }

    /**
     * Assignment 3 Question 7. Returns the nth element in Breadth First Search
     * (BFS) order
     *
     * @param n the position
     * @return the element found at the position
     */
    public Item nthBFS(int n) {

        if (root == null) {
            throw new NullPointerException("No tree");
        }
        Queue<Node<Item>> queue = new LinkedList<>();
        queue.add(root);
        int itemCounter = 0;
        Node<Item> itemNode = root;

        while (!(queue.isEmpty()) && itemCounter <= n) {
            itemNode = queue.peek();
            if (itemCounter == n) {
                return itemNode.el;
            }
            if (itemNode != null) {
                queue.remove();
                if (itemNode.left != null && itemCounter <= n) {
                    queue.add(itemNode.left);
                }
                if (itemNode.right != null && itemCounter <= n) {
                    queue.add(itemNode.right);
                }
            }
            itemCounter++;
        }
        return itemNode.el;
    }


    /**
     * Hands on session 7, exercise 2. Prints the labels of the tree's nodes in
     * breadth first order (BFS)
     */
    public void printBFT() {

        if (root == null) {
            throw new NullPointerException("No tree");
        }
        Queue<Node<Item>> queueList = new LinkedList<>();

        queueList.add(root);

        while (!(queueList.isEmpty())) {

            Node<Item> firstNode = queueList.poll();
            System.out.println(firstNode.el);

            if (firstNode.left != null) {
                queueList.add(firstNode.left);
            }
            if (firstNode.right != null) {
                queueList.add(firstNode.right);
            }
        }

    }

    /**
     * Hands on session 7, exercise 1. Returns the n:th element in Depth First
     * Search
     *
     * @param n the node to find
     * @return the element in the n:th place
     */
    public Item nthDFS(int n) {

        Stack<Node<Item>> myNodeStack = new Stack<>();
        Node<Item> currentNode = root;
        int itemCounter = 0;
        if (currentNode == null) {
            throw new NullPointerException("No tree");
        }
        myNodeStack.push(root);
        while (!myNodeStack.empty()) {
            Node<Item> item = myNodeStack.pop();
            if (itemCounter == n) {
                return item.el;
            } else {
                if (item.right != null) {
                    myNodeStack.push(item.right);
                }
                if (item.left != null) {
                    myNodeStack.push(item.left);
                }
            }
            itemCounter++;
        }
        throw new RuntimeException("hej");
    }

    /**
     * Assignment 3 Question 8. Prints the nodes of the tree in depth-first
     * order
     */
    public void printDFS() {

        if (root == null) {
            throw new NullPointerException("No tree");
        }

        Queue<Node<Item>> myQueue = new LinkedList<>();
        myQueue.add(root);
        Stack<Node<Item>> myStack = new Stack<>();

        while(!myQueue.isEmpty()){
            Node<Item> newNode = myQueue.remove();

            System.out.println(newNode.el.toString());
            if (newNode.right != null){
                myStack.push(newNode.right);
            }
            if (newNode.left != null){
                myQueue.add(newNode.left);
            } else if (!myStack.isEmpty()){
                myQueue.add(myStack.pop());
            }
        }


    }

    /**
     * Creates a string according to DFS.
     * Made public for unit testing
     *
     * @return a string representation of the tree in DFS order
     */
    public String toStringDFS() {
         StringBuilder sb = new StringBuilder();

        if (root == null) {
            throw new NullPointerException("No tree");
        }

        Queue<Node<Item>> myQueue = new LinkedList<>();
        myQueue.add(root);
        Stack<Node<Item>> myStack = new Stack<>();

        while(!myQueue.isEmpty()){
            Node<Item> newNode = myQueue.remove();

            sb.append(newNode.el+System.lineSeparator());
            if (newNode.right != null){
                myStack.push(newNode.right);
            }
            if (newNode.left != null){
                myQueue.add(newNode.left);
            } else if (!myStack.isEmpty()){
                myQueue.add(myStack.pop());
            }
        }

        return sb.toString();
    }

    /**
     * Assignment 3, Question 9. Insert i into a binary search tree
     *
     * @param i the Item to insert
     */
    public void insertBST2(Item i) {

        if (size() == 0) {
            root = new Node<>();
            root.el = i;
        } else {
            Node<Item> currentRoot = root;

            while (((currentRoot.left != null) && (currentRoot.right != null))) {
                if (i.compareTo(currentRoot.el) <= 0) {
                    currentRoot = currentRoot.left;
                } else {
                    currentRoot = currentRoot.right;
                }
            }

            Node<Item> newNode = new Node<>();
            newNode.el = i;

            if (i.compareTo(currentRoot.el) <= 0 ) {
                currentRoot.left = newNode;
            } else {
                currentRoot.right = newNode;
            }
        }
    }


    public void insertBST(Item i) {
        root = insertRecursively(root,i);
    }

    public Node<Item> insertRecursively(Node<Item> currentRoot, Item i){

        if (currentRoot == null){
            Node<Item> newNode = new Node<>();
            newNode.el = i;
            return newNode;
        }

        if (i.compareTo(currentRoot.el) <= 0){
            currentRoot.left = insertRecursively(currentRoot.left,i);
        } else {
            currentRoot.right = insertRecursively(currentRoot.right, i);
        }
        return currentRoot;

    }

    /**
     * Hands on session 7, exercise 3. Removes one item from a binary search
     * tree and then rearranges the nodes so that the tree after the item is
     * removed is still a binary search tree.
     *
     * @param i - the item to remove
     */
    public void removeBST(Item i) {

        if (root == null) {
            throw new NullPointerException("Tree is chopped");
        }

        if (root == i) ;

        // This method mainly calls deleteRec() 
        root = deleteRec(root, i);
        root = null;

    }

    /**
     * A recursive function to delete a new element in BST, assuming existing
     * tree is BST.
     *
     * @param root the current root node
     * @param i    the Item to delete
     * @return the new root node
     */
    private Node<Item> deleteRec(Node<Item> root, Item i) {

        if (i == root.el) {
            if (root.right == null && root.left == null) {
                return root;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node<Item> node = minValue(root.right);
                node.el = root.el;
                return node;
            }
        } else {
            int x = root.el.compareTo(i);
            if (x > 0) {
                deleteRec(root.left, i);
            } else {
                deleteRec(root.right, i);
            }
        }
        throw new RuntimeException("Something went wrong");
    }

    public Node<Item> minValue(Node<Item> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * A method for visualization and debugging
     */
    public void printTree() {
        if (root != null) {
            root.print();
        }
    }

    public static void main(String[] args) {
        Tree<Integer> t = exampleTreeBin();
        // System.out.println("Size: " + t.size());




        t.printTree();

        t.insertBST(-5);
        t.insertBST(-12);
        t.insertBST(20);
        t.insertBST(4);
        t.insertBST(21);
        t.insertBST(19);
        t.insertBST(17);
        t.insertBST(20);


       System.out.println(t.nthBFS(4));


        t.printTree();

    }
}
