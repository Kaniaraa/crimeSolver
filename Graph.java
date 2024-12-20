class Node {
    String name;
    Petunjuk petunjuk;
    Node next;
    Node connections; 

    public Node(String name) {
        this.name = name;
        this.petunjuk = new Petunjuk();
        this.next = null;
        this.connections = null;
    }
    public void addClue(String clue) {
        this.petunjuk.addClue(clue);
    }
    public void addConnection(Node node) {
        Node newConnection = new Node(node.name); 
        newConnection.next = this.connections;    
        this.connections = newConnection; 
    }
    public void displayClue() {
        if (this.petunjuk != null) {
            System.out.println("Petunjuk di lokasi " + this.name + ": " + this.petunjuk.getClue());
        }
    }
    public void displayConnections() {
        if (this.connections == null) {
            System.out.println("Tidak ada lokasi yang terhubung.");
            return;
        }
        System.out.println("Lokasi terhubung dengan " + this.name + ":");
        Node current = this.connections;
        while (current != null) {
            System.out.println("- " + current.name);
            current = current.next;
        }
    }
}
class Graph {
    private Node head;

    public void addLokasi(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public Node cariLokasi(String name) {
        Node current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    public void displayLoc() {
        if (head == null) {
            System.out.println("Belum ada lokasi yang ditambahkan.");
            return;
        }
        System.out.println("Daftar lokasi:");
        Node current = head;
        while (current != null) {
            System.out.println("- " + current.name);
            current = current.next;
        }
    }
    public void sortLocations() {
        if (head == null || head.next == null) {
            return; 
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.name.compareTo(current.next.name) > 0) { 
                    String temp = current.name;
                    current.name = current.next.name;
                    current.next.name = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("Lokasi berhasil diurutkan.");
    }
    public void connectLokasi(String loc1, String loc2) {
        Node node1 = cariLokasi(loc1);
        Node node2 = cariLokasi(loc2);
        if (node1 != null && node2 != null) {
            node1.addConnection(node2);
            node2.addConnection(node1);
        } 
    }
}