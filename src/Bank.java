public class Bank {
    public String bankName;
    private final MyLinkedList usersList;//store users
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
    public void addNewUser(String name, String address, String ssn, double balance) {
        int newId = getNewId();
        addNewUserWithId(newId, name, address, ssn, balance);
    }

    public void addNewUserWithId(int id, String name, String address, String ssn, double balance) {
        User newUser = new User(id, name, address, ssn, balance);
        usersList.addNode(newUser);
        System.out.println("User added: " + newUser);
    }

    public void deleteUser(int userId) {
        if(userId < 0 || userId > idCounter) {
            System.out.println("Invalid user Id");
            return;
        }
        User deleteUser = usersList.get(userId);
        if(usersList.deleteNode(userId)) {
            availableIdList.addId(userId); //add id into availableIdList
            //System.out.println("User " + userId + " deleted");
            System.out.println(deleteUser + " deleted");
        } else {
            System.out.println("User" + userId + " not found");
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
        float res;
        int listSize = usersList.getSize();
        if(listSize == 0) {
            System.out.println("The list is empty!");
            return -1;
        }
        int idMid = listSize / 2;
        if(listSize % 2 == 0) {
        float id1 = (float) usersList.get(idMid).getId();
        float id2 = (float) usersList.get(idMid - 1).getId();
        res = (id1 + id2) / 2;
        //wrong: store the result from int to float type
        //res = (usersList.get(idMid).getId() + usersList.get(idMid + 1).getId()) / 2;
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
            if(id1 < id2) {
                user1.setBalance(total);
                deleteUser(id2);
            } else {
                user2.setBalance(total);
                deleteUser(id1);
            }
            System.out.println("Account " + id1 + " and " + id2 + " merged into " + id1 + ". The balance is" + total);
            return;
        }
        System.out.println("Cannot merge accounts: Invalid details or mismatch.");
    }
    public void bankMerge(Bank other) {
        ListNode cur = other.usersList.getHead();
        while(cur != null) {
            int id = cur.getUser().getId();
            User user = usersList.get(id);

            if(user == null) { //no need new id
                addNewUserWithId(cur.getUser().getId(),cur.getUser().getName(), cur.getUser().getAddress(),
                        cur.getUser().getSocialSecurityNum(), cur.getUser().getBalance());
            } else {
                addNewUser(cur.getUser().getName(), cur.getUser().getAddress(),
                        cur.getUser().getSocialSecurityNum(), cur.getUser().getBalance());
            }
            cur = cur.getNext();
        }
    }
}
