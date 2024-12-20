class Nodequeue {
    String username;
    Nodequeue next;  

    public Nodequeue(String username) {
        this.username = username;
        this.next = null;
    }
}
class QueueLogin {
    private Nodequeue front, rear; 
    private int size;

    public QueueLogin() {
        front = rear = null;
        size = 0;
    }
    public void enqueue(String username) {
        Nodequeue newNode = new Nodequeue(username);
        if (rear == null) {
            front = rear = newNode; 
        } else {
            rear.next = newNode; 
            rear = newNode;
        }
        size++;
        System.out.println("Akun " + username + " berhasil ditambahkan.");
    }
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue kosong, tidak ada akun yang dapat dikeluarkan!");
            return null;
        }
        String username = front.username;
        front = front.next; 
        if (front == null) {
            rear = null; 
        }
        size--;
        System.out.println("Akun " + username + " telah dikeluarkan dari queue.");
        return username;
    }
    public void displayLoginAccounts() {
        if (isEmpty()) {
            System.out.println("Tidak ada akun yang login.");
            return;
        }
        System.out.println("Akun yang sudah login:");
        Nodequeue current = front;
        while (current != null) {
            System.out.println("- " + current.username);
            current = current.next;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int getSize() {
        return size;
    }
}