class Graph {//ini buat nyimpen lokasi
    Node head;
    public void addLokasi(String name){
        Node newNode = new Node(name);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void cariLokasi(String name){
        Node current = head;
        while(current != null){
            if(current.name.equals(name)){
                return current;
            }
            current = current.next;
        }
        return null;
    }
    public void displayLoc(){
        if(head == null){
            System.out.println("Takdee lokesyeen!!!");
            return;
        }
        System.out.println("Daftar lokasi mas: ");
        Node current = head;
        while(current != null){
            System.out.println("- " + current.name);
            current = current.next;
        }
    }
}
