class Node {
    String name;
    Lokasi petunjuk;
    Node next;
    public Node(String name){
        this.name = name;
        this.petunjuk = new Lokasi();
        this.next = null;
    }
    public void addClue(String clue){
        petunjuk.add(clue);
    }
    public void displayClue(){
        System.out.println("Petunjuk yang ada di lokasi");
        System.out.println("> " + name );
        petunjuk.display();
    }
}
