class Graph {
    Node head;  // Titik awal dari daftar lokasi
    public void addLokasi(String name) {
        Node newNode = new Node(name);  // buat lokasi baru
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;  // cari lokasi terakhir
            }
            current.next = newNode;  // tambah lokasi baru di akhir
        }
    }
    public Node cariLokasi(String name) {
        Node current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                return current;  // nemu lokasi dengan nama yang sesuai
            }
            current = current.next;
        }
        return null;  // Lokasi tidak ada
    }
    public void displayLoc() {
        if (head == null) {
            System.out.println("Tidak ada lokasi!");
            return;
        }
        System.out.println("Daftar lokasi yang tersedia:");
        Node current = head;
        while (current != null) {
            System.out.println("- " + current.name);
            current = current.next;
        }
    }
}