class QueueLogin {
    private String[] loginQueue;  
    private int front, rear, size;

    public QueueLogin(int capacity) {
        loginQueue = new String[capacity];  
        front = 0;
        rear = -1;
        size = 0;
    }

    
    public void enqueue(String username) {
        if (size == loginQueue.length) {
            System.out.println("Queue penuh, tidak bisa menambahkan akun!");
            return;
        }
        rear = (rear + 1) % loginQueue.length;
        loginQueue[rear] = username;
        size++;
    }

    public void displayLoginAccounts() {
        if (size == 0) {
            System.out.println("Tidak ada akun yang login.");
        } else {
            System.out.println("Akun yang sudah login:");
            int current = front;
            for (int i = 0; i < size; i++) {
                System.out.println(loginQueue[current]);
                current = (current + 1) % loginQueue.length;
            }
        }
    }

    
    public String dequeue() {
        if (size == 0) {
            System.out.println("Queue kosong!");
            return null;
        }
        String username = loginQueue[front];
        front = (front + 1) % loginQueue.length;
        size--;
        return username;
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public boolean isFull() {
        return size == loginQueue.length;
    }
}
