class NodeStack {
    String lokasi;  
    NodeStack next; 

    public NodeStack(String lokasi) {
        this.lokasi = lokasi;
        this.next = null;
    }
}
class Stack {
    private NodeStack top;  // Titik atas stack
    public Stack() {
        this.top = null;
    }
    public void push(String lokasi) {
        NodeStack newNode = new NodeStack(lokasi);  // node baru
        newNode.next = top;  // tamabah ke stack
        top = newNode;
        System.out.println("Anda telah mengunjungi lokasi: " + lokasi);
    }
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada lokasi untuk dihapus.");
            return null;
        }
        String lokasiDihapus = top.lokasi;  // ambil lokasi dari stack
        top = top.next;  // Pindah ke node berikutnya
        System.out.println("Kembali dari lokasi: " + lokasiDihapus);
        return lokasiDihapus;
    }
    public boolean isEmpty() {
        return top == null;  // cek apakah stack kosong
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Belum ada lokasi yang dikunjungi.");
        } else {
            System.out.println("Jejak perjalanan:");
            NodeStack current = top;
            while (current != null) {
                System.out.println("- " + current.lokasi);  // Menampilkan jejak perjalanan
                current = current.next;
            }
        }
    }
}