class Node {
    String name;
    Petunjuk petunjuk;
    Node next;
    public Node(String name){
        this.name = name;
        this.petunjuk = new Petunjuk();
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
