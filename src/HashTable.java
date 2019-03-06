import java.util.Random;

class HashTable {
    // The hash table implements a set of integers.
    // Empty buckets are null, occupied ones
    // store the relevant integer

    public static double storage = 0;
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
        storage += costOfInsert(x);
    }

    /**
     * Insert an integer into the hash table, returning the cost of insertion.
     * The cost is how many times the table had to "probe" to find an available
     * spot for insertion. No probing means cost = 0;
     *
     * @param x the integer to insert
     * @return the cost
     */
    public int costOfInsert(int x) {
        int cost = 0;
        int position = Math.abs(x) % arr.length;
        int i = 1;

        if (arr[position] == null) {
            arr[position] = x;
        } else {
            if (withLinearProbing) {
                while (arr[position] != null) {
                    if (position == arr.length - 1) {
                        position = 0;
                        cost++;
                    }
                    if (arr[position] == null) {
                        arr[position] = x;
                        return cost;
                    } else {
                        position++;
                        cost++;
                    }
                }
                arr[position] = x;
            } else {
                while (arr[position] != null) {
                    position = (position + (int) Math.pow(i,2)) % arr.length;
                    i++;
                    cost++;
                    if (arr[position] == null){
                        arr[position] = x;
                        return cost;
                    }
                }
            }
        }
        return cost;
    }


    public static void main(String[] args) {
        HashTable haschTable = new HashTable(100003,false);

        //**** TEST ****
        /*
        //10000 / 0.1 = 100000 -> 100003
        //10000 / 0.3 = 33333 -> 33343
        //10000 / 0.5 = 20000 -> 20011
        //10000 / 0.7 = 14286 -> 14293
        //10000 / 0.9 = 11111 -> 11113

        for (int i = 0; i < 10000; i++){
            haschTable.insert(new Random().nextInt());
        }

        System.out.println(storage/10000);
        */
        //**** END OF TEST ****



    }

}
