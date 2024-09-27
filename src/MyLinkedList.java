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

    public void AddAtHead(User user) {
        ListNode dummyHead = new ListNode(new User(), head);
        ListNode newUser = new ListNode(user);
        newUser.setNext(dummyHead.getNext());
        dummyHead.setNext(newUser);
        size++;
    }
    public void AddAtTail(User user) {
        ListNode dummyHead = new ListNode(new User(), head);
        ListNode newUser = new ListNode(user);
        ListNode cur = dummyHead;
        while(cur.getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(newUser);
        size++;
    }
    public void AddAtIndex(User user, int index) {
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
