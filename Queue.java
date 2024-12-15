public class Queue {
    private Node front, rear;

    public Queue() {
        front = rear = null;
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void printQueue() {
        Node current = front;
        while (current != null) {
            System.out.println("- " + current.data);
            current = current.next;
        }
    }
}
