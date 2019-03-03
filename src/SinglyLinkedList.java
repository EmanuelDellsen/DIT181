
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

    if (n < 0){
      throw new IllegalArgumentException("Index ouf of bounds");

    }
    int counter = 0;
    ListNode currentNode = header;
    if(size == 0){
      return null;
    }
    while (currentNode != null){
      if (counter == n) {
        return (Item) currentNode.el;
      }else{
        counter++;
        currentNode = currentNode.next;
      }
    }


    throw new IllegalArgumentException("Index ouf of bounds");
  }

  // Insert element x at index n in the list
  public void insertAt(int n, Item x) {

    if (n > size || n < 0) {
      throw new IllegalArgumentException("Index ouf of bounds");
    }

      ListNode<Item> currentNode = header;
    for (int i = 0; i < n ; i++) {
      currentNode = currentNode.next;
    }

    ListNode temp = currentNode.next;
    ListNode<Item> insertNode = new ListNode<>();
    insertNode.el = x;
    currentNode.next = insertNode;
    insertNode.next = temp;
    size++;
  }



  // Remove the element at index n from the list
  public void removeAt(int n) {

    if (size == 0){
      throw new IllegalArgumentException("Index ouf of bounds");
    }

    ListNode temp = header;

    if (n == 0){
      header = temp.next;
      return;
    }

    // if (...)

    throw new UnsupportedOperationException();
  }

  // Reverse the list
  public void reverse() {
    throw new UnsupportedOperationException();
  }

  // Represent the contents of the list as a String
  /*
  public String toString() {
    StringBuilder res = new StringBuilder("{");
    if (size > 0) {
      res.append(firstEl.toString());
      for (int i = 1; i < size; ++i) {
        res.append(", ");
        res.append(el.toString());
      }
    }
    res.append("}");
    return res.toString();
  }*/

  public static void main(String[] args) {
    SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
    System.out.println(l.size());
  }
}
