class SinglyLinkedList<Item> {
  private int size = 0;
  private ListNode<Item> header;

  public static class ListNode<Item> {
    public ListNode<Item> next = null;
    public Item el = null;
  }

  public SinglyLinkedList() {
    header = new ListNode<Item>();
  }

  public int size() {
    return size;
  }

  // Set function for unit testing purposes
  public void setList(ListNode<Item> list, int listSize) {
    header.next = list;
    size = listSize;
  }

  // Iterator class for unit testing purposes
  public Iterator<Item> getIterator() {
    return new Iterator<Item>(header);
  }
  // Iterator class for unit testing purposes
  public static class Iterator<Item> {
    private ListNode<Item> current;

    private Iterator(ListNode<Item> header) {
      current = header;
    }

    public Item next() {
      current = current.next;
      return current.el;
    }

    public boolean hasNext() {
      return current.next != null;
    }
  }

  public Item get(int n) {

    if (n >= size || n < 0) {
      throw new IllegalArgumentException("Index ouf of bounds");
    } else {

      ListNode<Item> currentNode = header.next;

      for (int i = 0; i < n; i++) {
        currentNode = currentNode.next;
      }
      return currentNode.el;
    }
  }

  // Insert element x at index n in the list
  public void insertAt(int n, Item x) {

    if (n > size || n < 0) {
      throw new IllegalArgumentException("Index ouf of bounds");
    }
    if (n == 0){
      add(x);
    } else {
      ListNode<Item> currentNode = header.next;
      for (int i = 0; i < n-1;i++){
        currentNode = currentNode.next;
      }
      ListNode<Item> newNode = new ListNode<>();
      newNode.next = currentNode.next;
      currentNode.next = newNode;
      newNode.el = x;
      size++;
    }
  }



  // Remove the element at index n from the list
  public void removeAt(int n) {

    if (n >= size || n < 0) {
      throw new IllegalArgumentException("Index ouf of bounds");
    }
    if (n == 0){
      header.next = header.next.next;
    } else {
      ListNode<Item> currentNode = header.next;

      for (int i = 0; i < n-1; i++){
        currentNode = currentNode.next;
      }
      currentNode.next = currentNode.next.next;
    }
    size--;
  }

  // Reverse the list
  public void reverse() {

    ListNode<Item> node = header.next;
    ListNode<Item> next = null;
    ListNode<Item> previous = null;

    while (node != null){

      next = node.next;
      node.next = previous;
      previous = node;
      node = next;

    }

    header.next = previous;



  }

  public void add(Item x){
    ListNode<Item> currentNode = new ListNode<>();
    currentNode.el = x;

    if (header.next == null){
      header.next = currentNode;

    } else {
      currentNode.next = header.next;
      header.next = currentNode;
    }
    size++;
  }

  // Represent the contents of the list as a String
  /*
  public String toString() {
    StringBuilder res = new StringBuilder("{");
    if (size > 0) {
      res.append(header.el.toString());
      for (int i = 1; i < size; i++) {
        res.append(", ");
        res.append(header.toString());
      }
    }
    res.append("}");
    return res.toString();
  }*/

  public boolean hasNextOfficial(ListNode<Item> node){

    if (node != null){
      return true;
    } else{
      return false;
    }
  }

  @Override
  public String toString() {

    ListNode<Item> currentNode = new ListNode<>();
    currentNode = header.next;

    StringBuilder res = new StringBuilder("[" );
    if (size > 0) {

      while (currentNode != null) {
        res.append(currentNode.el.toString());
        currentNode = currentNode.next;
        if (hasNextOfficial(currentNode)) {
          res.append(", ");
        }
      }
    }
    res.append("]");
    return res.toString();
  }

  public static void main(String[] args) {
    SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();

    l.size = 0;

    /*l.add(-3);
    l.add(-21);
    l.add(-2);
    l.add(1);
    l.add(14);
    l.add(11);
    l.add(-13);
    l.add(23);
    l.add(16);
    l.add(-23);*/

    System.out.println(l.toString());
    l.insertAt(0,0);
    System.out.println(l.toString());
    System.out.println(l.get(1));

  }
}
