public class AvailableIdList {
    IdNode head = null;
    int size = 0;

    public int removeHead() {
        IdNode dummyHead = new IdNode(-1, head);
        dummyHead.next = head.next;
        size--;
        return head.id;
    }

    public void addId(int userId) {
        IdNode dummyHead = new IdNode(-1, head);
        IdNode cur = dummyHead;
        IdNode newUser = new IdNode(userId);
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = newUser;
        size++;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
}
