
class QueueArray<Item> {

    private final int initial_capacity = 4;
    private int capacity = initial_capacity;
    private int size = 0;
    private Item[] arr;
    private int writePos;
    private int readPos;

    // We need this pragma to avoid warnings triggerred by
    // the unsafe cast to Item[]. Java does not support generic arrays. 
    @SuppressWarnings("unchecked")
    public QueueArray() {
        arr = (Item[]) new Object[initial_capacity];
        writePos = 0;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * A help function to increment index in a circular buffer
     *
     * @param position the position we're in now
     * @return the incrementation of the position
     */
    private int increment(int position) {
        throw new UnsupportedOperationException();
    }

    /**
     * Adds an item in the end of the queue
     *
     * @param x the item to add
     */
    public void enqueue(Item x) {
        throw new UnsupportedOperationException();
    }

    /**
     * Picks the first item in the queue
     *
     * @return the first item in the queue
     */
    public Item dequeue() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        QueueArray<Integer> q = new QueueArray<Integer>();

    }
}
