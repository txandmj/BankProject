import java.util.LinkedList;
import java.util.List;

public class Bank {
    private String bankName;
    private MyLinkedList usersList;//store users
    private int idCounter = 0; //self-in
    public Bank(String bankName) {
        this.bankName = bankName;
        usersList = new MyLinkedList();
    }

    public void AddNewUser(String name, String address, String ssn, double balance) {
        int newId = idCounter++;
        User newUser = new User(newId, name, address, ssn, balance);
        usersList.AddAtTail(newUser);
        System.out.println("Adding a new user!");
    }
    public boolean deleteUser(int userId) {
        if(userId < 0 || userId > idCounter || usersList == null) {
            return false;
        }
        //ListNode dummyHead = new ListNode(new User(), usersList.getHead());
        ListNode cur = usersList.getHead();
        int index = 0;
        while(cur != null) {
            int curId = cur.getUser().getId();
            if(curId == userId) {
                usersList.deleteAtIndex(index);
                return true;
            }
            cur = cur.getNext();
            index++;
        }
        return false;
    }

}
