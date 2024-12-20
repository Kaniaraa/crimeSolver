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
    // Menambahkan akun ke dalam queue
    public void enqueue(String username) {
        Nodequeue newNode = new Nodequeue(username);
        if (rear == null) {
            front = rear = newNode;  // Jika queue kosong
        } else {
            rear.next = newNode;  // Menambahkan elemen ke belakang queue
            rear = newNode;
        }
        size++;
        System.out.println("Akun " + username + " berhasil ditambahkan.");
    }
    // Mengeluarkan akun dari queue
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue kosong, tidak ada akun yang dapat dikeluarkan!");
            return null;
        }
        String username = front.username;
        front = front.next;  // Pindahkan pointer front ke elemen berikutnya
        if (front == null) {
            rear = null;  // Jika queue menjadi kosong
        }
        size--;
        System.out.println("Akun " + username + " telah dikeluarkan dari queue.");
        return username;
    }
    // Menampilkan semua akun yang login
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
    // Mengecek apakah queue kosong
    public boolean isEmpty() {
        return size == 0;
    }
    // Mendapatkan ukuran queue
    public int getSize() {
        return size;
    }
}