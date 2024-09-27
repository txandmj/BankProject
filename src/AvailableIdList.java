public class AvailableIdList {
    IdNode head;
    public AvailableIdList(){
        head = new IdNode(0);
    }

    public int removeHead() {
        IdNode dummyHead = new IdNode(-1, head);
        dummyHead.next = head.next;
        return head.id;
    }
}
