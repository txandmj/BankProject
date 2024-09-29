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
        ListNode cur = head;
        while(cur != null) {
            if(cur.getUser().getId() == userId) {
                return cur.getUser();
            }
            cur = cur.getNext();
        }
        return null;
    }

    public void addNode(User user)
    {
        ListNode prevNode = null;
        ListNode curNode = head;
        while(curNode != null && curNode.getUser().getId() < user.getId()) {
            prevNode = curNode;
            curNode = curNode.getNext();
        }
        if(prevNode == null) {// user ID is the smallest
            head = new ListNode(user, head);
        }
        else {
            ListNode tmp = prevNode.getNext();
            ListNode newNode = new ListNode(user, tmp);
            prevNode.setNext(newNode);
        }
        size++;
    }

    public boolean deleteNode(int userId) {
        ListNode dummyHead = new ListNode(new User(), head);
        ListNode cur = dummyHead;
        while(cur != null && cur.getNext() != null) {
            int nextId = cur.getNext().getUser().getId();
            if(nextId == userId) {
                cur.setNext(cur.getNext().getNext());
                size--;
                return true;
            } else {
                cur = cur.getNext();
            }
        }
        return false;
    }
}
