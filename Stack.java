class NodeStack {
    String lokasi;   // Lokasi yang dikunjungi
    NodeStack next;  // Menghubungkan node satu dengan lainnya

    public NodeStack(String lokasi) {
        this.lokasi = lokasi;
        this.next = null;
    }
}
class Stack {
    private NodeStack top;  // Menggunakan NodeStack sebagai tipe untuk top

    public Stack() {
        this.top = null;
    }
    // Menambahkan lokasi ke stack
    public void push(String data) {
        NodeStack newNode = new NodeStack(data);
        newNode.next = top;  // Menyambungkan node baru ke node sebelumnya
        top = newNode;  // Menetapkan node baru sebagai top
    }
    // Menampilkan semua lokasi yang ada di stack
    public void display() {
        if (top == null) {
            System.out.println("Stack kosong, tidak ada lokasi yang dapat ditampilkan.");
            return;
        }
        NodeStack current = top;
        while (current != null) {
            System.out.println(current.lokasi);
            current = current.next;
        }
    }
}