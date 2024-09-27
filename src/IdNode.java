public class IdNode {
    int id;
    IdNode next;
    public IdNode(){ }
    public IdNode(int id) {
        this.id = id;
        this.next = null;
    }
    public IdNode(int id, IdNode next){
        this.id = id;
        this.next = next;
    }
}
