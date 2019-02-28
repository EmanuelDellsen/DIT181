class DoublyLinkedList<Item> {

    private int size = 0;
    private Node<Item> head;
    private Node<Item> tail;

    /**
     * Linked list node helper data type
     *
     * @param <Item>
     */
    private static class Node<Item> {

        Node<Item> next = null;
        Item el = null;
        Node<Item> prev = null;

    }

    /**
     * Public constructor
     */
    public DoublyLinkedList() {

        this.size = size();

        head.next = tail;
        tail.prev = head;

        // add things in the constructor to create an empty linked list object.
    }

    public int size() {
        return size;
    }

    /**
     * Hands on 6, Exercise 1, Get element at index n from the list
     *
     * @param n the index of the element to get
     */
    public Item get(int n) {

        Node<Item> currentNode;
        int counter;

        if (n > (size/2) && n >= 0){
            currentNode = tail;
            counter = size-1;

            while(currentNode != null){
                if (counter == n){
                    return currentNode.el;
                }
                currentNode = currentNode.prev;
                counter--;
            }
        } else if (n >= 0) {
            currentNode = head;
            counter = 0;

            while(currentNode != null){
                if (counter == n){
                    return currentNode.el;
                }
                currentNode = currentNode.next;
                counter++;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * Hands on 6, Exercise 2, Insert element x at index n in the list
     *
     * @param n the index where we want to do the insertion
     * @param x the element to insert
     */
    public void insertAt(int n, Item x) {

        Node<Item> newNode = new Node<>();
        newNode.el = x;

        if (isEmpty() && n >= 0){
            tail = newNode;
            head = newNode;
        } else if (n == 0){
            newNode.next = head;
            newNode.prev = null;
            head = newNode;
        } else if (n == size-1){
            newNode.next = null;
            newNode.prev = tail;
            tail = newNode;
        } else {

            for (int i = 0; i < n; i++){


                //if (i == n)

            }



        }
        throw new UnsupportedOperationException();


    }

    /**
     * Hands on 6, Exercise 3, Remove the element at index n from the list
     *
     * @param n the index where we want to remove an element
     */
    public void removeAt(int n) {
        throw new UnsupportedOperationException();

    }

    /**
     * Hands on 6, Exercise 4, reverse the list
     *
     */
    public void reverse() {

        throw new UnsupportedOperationException();
    }

    /**
     * return whether the list is empty or not
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<Integer>();

       // l.insertAt(0, 1);


    }
}
