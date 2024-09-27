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
    public void deleteUser(int userId) {
        if(userId < 0 || userId > idCounter) {
            System.out.println("Invalid user Id");
            return;
        }
        if(usersList.deleteId(userId)) {
            System.out.println("User " + userId + " deleted");
        } else {
            System.out.println("User " + userId + " not found");
        }

    }
    public void payUserToUser(int payerId, int payeeId, double amount) {
        User payer = usersList.get(payerId);
        User payee = usersList.get(payeeId);
        if(payer != null && payee != null && payer.getAmount() >= amount) {
            payer.setAmount(payer.getAmount() - amount);
            payee.setAmount(payee.getAmount() + amount);
            System.out.println("Transfer successful: " + amount + " from " + payerId + " to " + payeeId);
        } else {
            System.out.println("Transfer failed: Insufficient funds or user not fund");
        }
    }
    public float getMedianId() {
        float res = 0;
        int listSize = usersList.getSize();
        int idMid = listSize / 2;
        if(listSize % 2 == 0) {
            res = (usersList.get(idMid).getId() + usersList.get(idMid + 1).getId()) >> 1;
        } else {
            res = usersList.get(idMid).getId();
        }
        return res;
    }

    public void mergeAccount(int id1, int id2) {
        User user1 = usersList.get(id1);
        User user2 = usersList.get(id2);
        if(user1.equals(user2)) {
            double total = user1.getAmount() + user2.getAmount();

        }
    }
}
