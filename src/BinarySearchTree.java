// Java program to demonstrate delete and insert operations in binary search tree
class BinarySearchTree
{
    /* Class containing left and right child of current node and key value*/
    class Node
    {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree()
    {
        root = null;
    }

    // This method mainly calls remove()
    void removeKey(int key)
    {
        root = remove(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node remove(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null) return root;

        /* Otherwise, recursively go down the tree */
        if (key < root.key)
            root.left = remove(root.left, key);
        else if (key > root.key)
            root.right = remove(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = findMin(root.right);

            // Delete the inorder successor
            root.right = remove(root.right, root.key);
        }

        return root;
    }

    int findMin(Node root)
    {
        int min = 0;
        while(root.left != null){
            findMin(root.left);
        }
        if (root.left==null){
            return root.key;

        }
        /* YOU ARE SUPPOSED TO COMPLETE THIS PART */

        return min;

    }

    // This method mainly calls insertRec()
    void insertKey(int key)
    {
        root = insert(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node insert(Node root, int key)
    {

        /* If the tree is empty, return a new node */
        /* YOU ARE SUPPOSED TO COMPLETE THIS PART */



        /* Otherwise, recursively go down the tree */
        /* YOU ARE SUPPOSED TO COMPLETE THIS PART */



        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder()
    {
        printInOrder(root);
    }

    // A utility function to do inorder traversal of BST
    void printInOrder(Node root)
    {
        if (root != null)
        {
            printInOrder(root.left);
            System.out.print(root.key + " ");
            printInOrder(root.right);
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
        // inserting 3, 1, 4, 6, 9, 2, 5 and 7

        //Insert 3
        tree.insertKey(3);
        System.out.println("Inorder traversal of the given tree after insertion of 3");
        tree.inorder();

        //Insert 1
        tree.insertKey(1);
        System.out.println("Inorder traversal of the given tree after insertion of 1");
        tree.inorder();

        //Insert 4
        tree.insertKey(4);
        System.out.println("Inorder traversal of the given tree after insertion of 4");
        tree.inorder();

        //Insert 6
        tree.insertKey(6);
        System.out.println("Inorder traversal of the given tree after insertion of 6");
        tree.inorder();

        //Insert 9
        tree.insertKey(9);
        System.out.println("Inorder traversal of the given tree after insertion of 9");
        tree.inorder();

        //Insert 2
        tree.insertKey(2);
        System.out.println("Inorder traversal of the given tree after insertion of 2");
        tree.inorder();

        //Insert 5
        tree.insertKey(5);
        System.out.println("Inorder traversal of the given tree after insertion of 5");
        tree.inorder();

        //Insert 7
        tree.insertKey(7);
        System.out.println("Inorder traversal of the given tree after insertion of 7");
        tree.inorder();

        System.out.println("\nRemove the root");
        tree.removeKey(3);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println(tree.findMin(tree.root));


    }
}
