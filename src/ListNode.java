public class ListNode {
    private User user;
    private ListNode next;

    public ListNode(User user) {
        this.user = user;
        this.next = null;
    }
//    public ListNode(ListNode next) {
//        this.user = null;
//        this.next = next;
//    }
    public ListNode(User user, ListNode next) {
        this.user = user;
        this.next = next;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
}
