
class HashTable {
    // The hash table implements a set of integers.
    // Empty buckets are null, occupied ones
    // store the relevant integer

    protected Integer[] arr;
    protected int size = 0; // Number of (occupied) elements
    private boolean withLinearProbing;

    /**
     * Creates a new HashTable
     *
     * @param capacity The capacity of the hash table
     * @param withLinearProbing true if Linear Probing is used, false if
     * Quadratic Probing is used
     */
    public HashTable(int capacity, boolean withLinearProbing) {
        arr = new Integer[capacity];
        this.withLinearProbing = withLinearProbing;
    }

    /**
     * Returns what the load factor of the hash table is. Load factor is how
     * much of the table that is filled.
     *
     * @return the load factor of the hash table
     */
    public double loadFactor() {
        return ((double) size) / arr.length;
    }

    public int size() {
        return size;
    }

    /**
     *
     * Insert an integer into the hash table.
     *
     * @param x the integer to insert
     */
    public void insert(int x) {
        costOfInsert(x);
    }

    /**
     * Insert an integer into the hash table, returning the cost of insertion.
     * The cost is how many times the table had to "probe" to find an available
     * spot for insertion. No probing means cost = 1;
     *
     * @param x the integer to insert
     * @return the cost
     */
    public int costOfInsert(int x) {
        throw new UnsupportedOperationException();
        // Do implementation here! You are welcome to do as many private
        // methods as you wish to complete the task
    }

    public static void main(String[] args) {
        //Here is a good place to run your simulation.
    }

}
