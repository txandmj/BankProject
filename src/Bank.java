import java.util.LinkedList;
import java.util.List;

public class Bank {
    public String bankName;
    private MyLinkedList usersList;//store users
    public int idCounter = 0; //self-increment
    public AvailableIdList availableIdList;

    public MyLinkedList getUsersList() {
        return usersList;
    }

    public Bank(String bankName) {
        this.bankName = bankName;
        usersList = new MyLinkedList();
        availableIdList = new AvailableIdList();
    }
    public int getNewId() {
        if(availableIdList.isEmpty()) {
            return idCounter++;
        }
        return availableIdList.removeHead();
    }
    public void AddNewUser(String name, String address, String ssn, double balance) {
        int newId = getNewId();
        User newUser = new User(newId, name, address, ssn, balance);
        int insertSite = usersList.getInsertSite(newId);
        usersList.AddAtIndex(newUser, insertSite);
        System.out.println("User added: " + newUser);
    }
    public void deleteUser(int userId) {
        if(userId < 0 || userId > idCounter) {
            System.out.println("Invalid user Id");
            return;
        }
        if(usersList.deleteId(userId)) {
            availableIdList.addId(userId); //add id into availableIdList
            System.out.println("User " + userId + " deleted");
        } else {
            System.out.println("User " + userId + " not found");
        }

    }
    public void payUserToUser(int payerId, int payeeId, double amount) {
        User payer = usersList.get(payerId);
        User payee = usersList.get(payeeId);
        if(payer != null && payee != null && payer.getBalance() >= amount) {
            payer.setBalance(payer.getBalance() - amount);
            payee.setBalance(payee.getBalance() + amount);
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
            double total = user1.getBalance() + user2.getBalance();
            if(id1 > id2) {
                user1.setBalance(total);
                deleteUser(id2);
                System.out.println("Account " + id1 + " and " + id2 + " merged into " + id1 + ". The balance is " + total);
            } else {
                user2.setBalance(total);
                deleteUser(id1);
                System.out.println("Account " + id1 + " and " + id2 + " merged into " + id2 + ". The balance is " + total);
            }
        }
        System.out.println("Cannot merge accounts: Invalid details or mismatch.");
    }
    public void bankMerge(Bank other) {
        ListNode cur = other.usersList.getHead();
        while(cur != null) {
            int id = cur.getUser().getId();
            User user = usersList.get(id);
        }
    }
}
