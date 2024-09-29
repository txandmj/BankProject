/*
The linked list to store available IDs;
id added to the tail of avail
 */
public class AvailableIdList {
    IdNode head = null;
    IdNode tail = null; //point the new userId
    int size = 0;

    public int removeHead() {
        int removedId = head.id;
        head = head.next;
        size--;
        return removedId;
    }

    public void addId(int userId) {
        IdNode newUser = new IdNode(userId);
        if(head == null) {
            head = newUser;
        } else {
            tail.next = newUser;
        }
        tail = newUser; // Update the tail pointer
        size++;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
