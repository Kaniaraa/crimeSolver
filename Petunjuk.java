class Tunjuk {
    String clue;
    Tunjuk next; 
    public Tunjuk(String clue) {
        this.clue = clue;
        this.next = null;
    }
}
class Petunjuk {
    private String clue;
    public Petunjuk() {
        this.clue = "";
    }
    public void addClue(String clue) {
        this.clue = clue;
    }
    public String getClue() {
        return this.clue;
    }
}