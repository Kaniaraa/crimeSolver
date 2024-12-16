class Teka {
    String QnA; // Menyimpan pertanyaan
    Teka yesBranch;  // Cabang jika jawabannya "ya"
    Teka noBranch;   // Cabang jika jawabannya "tidak"
    public Teka(String QnA) {
        this.QnA = QnA;
        this.yesBranch = null;
        this.noBranch = null;
    }
}