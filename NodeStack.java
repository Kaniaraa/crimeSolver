class NodeStack {
    String lokasi;   // Lokasi yang dikunjungi
    NodeStack next;
    public NodeStack(String lokasi) {
        this.lokasi = lokasi;
        this.next = null;
    }
}