class Stack {
    private class NodeStack {
        String lokasi;
        NodeStack next;

        public NodeStack(String lokasi) {
            this.lokasi = lokasi;
            this.next = null;
        }
    }

    private NodeStack top; 

    public Stack() {
        this.top = null; 
    }


    public void push(String lokasinya) {
        NodeStack newNode = new NodeStack(lokasinya);
        newNode.next = top; 
        top = newNode;      
        System.out.println("Anda telah mengunjungi: " + lokasinya);
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada lokasi yang bisa dihapus.");
            return null;
        }

        String lokasiDihapus = top.lokasi; // Ambil lokasi dari node teratas
        top = top.next; // Pindahkan top ke node berikutnya
        System.out.println("Kembali dari lokasi: " + lokasiDihapus);
        return lokasiDihapus;
    }


    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Belum ada lokasi yang dikunjungi.");
            return;
        }

        System.out.println("Jejak perjalanan pemain:");
        NodeStack current = top;
        while (current != null) {
            System.out.println("- " + current.lokasi);
            current = current.next;
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada lokasi yang sedang dikunjungi.");
            return null;
        }
        return top.lokasi;
    }
}

public class StackGame {
    public static void main(String[] args) {
        Stack jejakPerjalanan = new Stack();

        // Pemain menjelajahi lokasi
        jejakPerjalanan.push("Rumah korban");
        jejakPerjalanan.push("Kantor detektif");
        jejakPerjalanan.push("Hutan");

        // Menampilkan jejak perjalanan
        jejakPerjalanan.display();

        // Pemain kembali ke lokasi sebelumnya
        jejakPerjalanan.pop();

        // Menampilkan lokasi terakhir yang dikunjungi
        System.out.println("Lokasi terakhir: " + jejakPerjalanan.peek());

        // Menampilkan jejak perjalanan setelah kembali
        jejakPerjalanan.display();
    }
}