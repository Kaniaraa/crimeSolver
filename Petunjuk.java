class Petunjuk {
    Tunjuk head;
    public void add(String clue){
        Tunjuk newNodeLoc = new Tunjuk(clue);
        if (head == null) {
            head = newNodeLoc;
        }else{
            Tunjuk current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNodeLoc;
        }
    }
    public void display(){
        if(head == null){
            System.out.println("Takdee clue :P");
        }else{
            Tunjuk current = head;
            while (current != null) {
                System.out.println(current.clue);
                current = current.next;
            }
        }
    }
}
