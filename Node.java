class Node {
    String name;       // Nama lokasi
    Petunjuk petunjuk;
    Node next;
    public Node(String name) {
        this.name = name;
        this.petunjuk = new Petunjuk();
        this.next = null;
    }
    public void addClue(String clue) {
        petunjuk.add(clue);  // nambah petunjuk ke lokasi
    }
    public void displayClue() {
        System.out.println("Petunjuk di lokasi " + name + ":");
        petunjuk.display();  // petunjuk di lokasi
    }
}