class Lokasi {
    NodeLoc head;
    public void add(String clue){
        NodeLoc newNodeLoc = new NodeLoc(clue);
        if (head == null) {
            head = newNodeLoc;
        }else{
            NodeLoc current = head;
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
            NodeLoc current = head;
            while (current != null) {
                System.out.println(current.clue);
                current = current.next;
            }
        }
    }
}
