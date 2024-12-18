class Petunjuk {
    Tunjuk head;

    // Method untuk menambahkan petunjuk ke dalam linked list
    public void add(String clue) {
        Tunjuk newClue = new Tunjuk(clue);  // buat petunjuk baru
        if (head == null) {
            head = newClue;
        } else {
            Tunjuk current = head;
            while (current.next != null) {
                current = current.next;  // cari petunjuk terakhir
            }
            current.next = newClue;  // tambah petunjuk baru di akhir
        }
    }

    // Method untuk menampilkan petunjuk yang diurutkan
    public void display() {
        if (head == null) {
            System.out.println("Tidak ada petunjuk di lokasi ini.");
        } else {
            // Bubble sort untuk mengurutkan petunjuk dalam linked list
            boolean swapped;
            do {
                swapped = false;
                Tunjuk current = head;
                while (current != null && current.next != null) {
                    if (current.clue.compareTo(current.next.clue) > 0) {
                        // Tukar petunjuk jika urutannya salah
                        String temp = current.clue;
                        current.clue = current.next.clue;
                        current.next.clue = temp;
                        swapped = true;
                    }
                    current = current.next;
                }
            } while (swapped);

            // Menampilkan petunjuk yang sudah diurutkan
            Tunjuk current = head;
            while (current != null) {
                System.out.println(current.clue);
                current = current.next;
            }
        }
    }

    // Kelas Tunjuk untuk representasi node dalam linked list
    class Tunjuk {
        String clue;
        Tunjuk next;

        Tunjuk(String clue) {
            this.clue = clue;
            this.next = null;
        }
    }
}
