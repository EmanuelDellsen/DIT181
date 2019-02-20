public class Queue {

    int front, back, size;
    int capacity;
    int array[];

    public Queue(int capacity){
        this.capacity = capacity;
        front = this.size = 0;
        back = -1;
        array = new int [this.capacity];
    }

    boolean isFull(Queue queue){
        return (queue.size == queue.capacity);
    }

    boolean isEmpty (Queue queue){
        return (queue.size == 0);
    }

    void enqueue (int item){
        if (isFull(this)) {
            System.out.println("Queue is full");
            return;
        }
        back = (back+1) % capacity;
        array[back] = item;
        size++;
        System.out.println(item+ " enqueded to queue");
    }

    int dequeue (){
        int value = 0;
        if(isEmpty(this)) {
            System.out.println("Queue is empty!");
        }
        int temp = array[front];
        array[front] = value;
        front = (front + 1) % capacity;
        size--;
        return temp;
    }

    private void printCircularQueue(Queue queue){

        
    }

    public static void main(String[] args) {
     Queue queue = new Queue(7);

     queue.enqueue(43);
     queue.enqueue(12);
     queue.enqueue(35);

     System.out.println(queue.dequeue() +" dequed from queue");
    }
}
