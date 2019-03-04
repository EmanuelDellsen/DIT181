
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

    ListNode<Item> currentNode = header;
    int counter = 0;
    if (size() <= 0 || 0 > n || n > size()) {
      throw new IllegalArgumentException("Index ouf of bounds");
    } else {
      while (currentNode.next != null && counter < n) {
          currentNode = currentNode.next;
          counter++;
        }
        return currentNode.el;
    }
  }

  // Insert element x at index n in the list
  public void insertAt(int n, Item x) {
    ListNode<Item> currentNode = header;
    int counter = 0;
    if (n > size || n < 0) {
      throw new IllegalArgumentException("Index ouf of bounds");
    }
    while( currentNode.next != null  ){
      if (counter == n-1){
        ListNode<Item> newNode = new ListNode<>();
        newNode.el=x;
        newNode.next=currentNode.next;
        currentNode.next = newNode;
      } else {
        currentNode=currentNode.next;
        counter ++;
      }
    }
    size++;
  }



  // Remove the element at index n from the list
  public void removeAt(int n) {

    ListNode<Item> tempNode = header;
    int counter = 0;
    if (n > size || n < 0) {
      throw new IllegalArgumentException("Index ouf of bounds");
    }
    while( tempNode.next != null  ){
      if (counter == n){
        tempNode.next= tempNode.next.next;

      } else {
        tempNode=tempNode.next;
        counter ++;
      }
    }
    size--;
  }

  // Reverse the list
  public void reverse() {
    throw new UnsupportedOperationException();
  }

  public void addFirst(Item x){


    ListNode<Item> currentNode = new ListNode<>();
    currentNode.el = x;
    currentNode.next = header;
    header=currentNode;
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

    if (node.next != null){
      return true;
    } else{
      return false;
    }
  }

  @Override
  public String toString() {

    ListNode<Item> currentNode = new ListNode<>();
    currentNode = header;

    StringBuilder res = new StringBuilder("[" );
    if (size > 0) {

      while (currentNode.next != null) {
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


    l.size =9;

    l.addFirst(-3);
    l.addFirst(-21);
    l.addFirst(-2);
    l.addFirst(1);
    l.addFirst(14);
    l.addFirst(11);
    l.addFirst(-13);
    l.addFirst(23);
    l.addFirst(16);
    l.addFirst(-23);


    System.out.println(l);
    System.out.println(l.get(-1));
    System.out.println(l);



  }
}
