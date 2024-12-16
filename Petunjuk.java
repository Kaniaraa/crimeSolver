class Petunjuk {
    Tunjuk head;
    public void add(String clue) {
        Tunjuk newClue = new Tunjuk(clue);  // bikin petunjuk baru
        if (head == null) {
            head = newClue;
        } else {
            Tunjuk current = head;
            while (current.next != null) {
                current = current.next;  // cari petunjuk terakhir
            }
            current.next = newClue;  // tamabah petunjuk baru
        }
    }
    public void display() {
        if (head == null) {
            System.out.println("Tidak ada petunjuk di lokasi ini.");
        } else {
            Tunjuk current = head;
            while (current != null) {
                System.out.println(current.clue);
                current = current.next;
            }
        }
    }
}