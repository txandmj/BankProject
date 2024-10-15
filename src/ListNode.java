//Define a ListNode class to represent each node in the linked list.
public class ListNode {
    private final User user;
    private ListNode next;

    public ListNode(User user, ListNode next) {
        this.user = user;
        this.next = next;
    }
    public User getUser() {
        return user;
    }
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
}
