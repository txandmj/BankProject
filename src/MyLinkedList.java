public class MyLinkedList {
    private int size = 0;
    private ListNode head = null;
    public int getSize(){
        return size;
    }
    public ListNode getHead() {
        return head;
    }
    public User get(int userId) {
        ListNode dummyHead = new ListNode(new User(), head);
        ListNode cur = dummyHead;
        while(cur != null) {
            if(cur.getUser().getId() == userId) {
                return cur.getUser();
            }
            cur = cur.getNext();
        }
        return null;
    }
    public int getInsertSite(int userId) {
        ListNode dummyHead = new ListNode(new User(), head);
        ListNode cur = dummyHead;
        int insertSite = 0;
        while(cur != null && cur.getUser().getId() < userId) {
            cur = cur.getNext();
            insertSite++;
        }
        return insertSite;
    }

    public void AddAtIndex(User user, int index) {
        //this linkedlist is empty
        if(head == null) {
            head = new ListNode(user);
            size++;
            return;
        }
        ListNode dummyHead = new ListNode(new User(), head);
        ListNode newUser = new ListNode(user);
        ListNode cur = dummyHead;
        for(int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        newUser.setNext(cur.getNext());
        cur.setNext(newUser);
        size++;
    }

    public boolean deleteId(int userId) {
        ListNode dummyHead = new ListNode(new User(), head);
        ListNode cur = dummyHead;
        while(cur != null) {
            int nextId = cur.getNext().getUser().getId();
            if(nextId == userId) {
                cur.setNext(cur.getNext().getNext());
                return true;
            } else {
                cur = cur.getNext();
            }
        }
        size--;
        return false;
    }
}
