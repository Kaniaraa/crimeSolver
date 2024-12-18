import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        // Mengambil daftar petunjuk ke dalam array
        List<String> clues = new ArrayList<>();
        Tunjuk current = head;
        while (current != null) {
            clues.add(current.clue);
            current = current.next;
        }

        // Sorting petunjuk
        Collections.sort(clues);

        // Menampilkan petunjuk yang sudah diurutkan
        for (String clue : clues) {
            System.out.println(clue);
        }
    }
}

}