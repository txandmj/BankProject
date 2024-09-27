public class MyLinkedList {
    private int size = 0;
    private ListNode head = null;
    public int getSize(){
        return size;
    }
    public ListNode getHead() {
        return head;
    }
    public User get(int index) {
        ListNode dummyHead = new ListNode(new User(), head);
        ListNode cur = dummyHead;
        for(int i = 0; i <= index; i++) {
            cur = cur.getNext();
        }
        return cur.getUser();
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

    public void deleteAtIndex(int index) {
        ListNode dummyHead = new ListNode(new User(), head);
        ListNode cur = dummyHead;
        for(int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        cur.setNext(cur.getNext().getNext());
        size--;
    }
}
