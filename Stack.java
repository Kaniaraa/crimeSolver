class NodeStack {
    String lokasi;  
    NodeStack next; 

    public NodeStack(String lokasi) {
        this.lokasi = lokasi;
        this.next = null;
    }
}
class Stack {
    private NodeStack top; 
    public Stack() {
        this.top = null;
    }
    public void push(String lokasi) {
        NodeStack newNode = new NodeStack(lokasi); 
        newNode.next = top;  
        top = newNode;
        System.out.println("Anda telah mengunjungi lokasi: " + lokasi);
    }
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada lokasi untuk dihapus.");
            return null;
        }
        String lokasiDihapus = top.lokasi; 
        top = top.next; 
        System.out.println("Kembali dari lokasi: " + lokasiDihapus);
        return lokasiDihapus;
    }
    public boolean isEmpty() {
        return top == null; 
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Belum ada lokasi yang dikunjungi.");
        } else {
            System.out.println("Jejak perjalanan:");
            NodeStack current = top;
            while (current != null) {
                System.out.println("- " + current.lokasi); 
                current = current.next;
            }
        }
    }
}