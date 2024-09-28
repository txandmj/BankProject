public class BankTest {
    public static void main(String[] args) {
        Bank orangeBank = new Bank("Bank of Orange");

        orangeBank.AddNewUser("Alice", "123 Main St", "111-11-1111", 1000);
        orangeBank.AddNewUser("Bob", "456 Oak St", "222-22-2222", 500);
        orangeBank.AddNewUser("Charlie", "789 Pine St", "333-33-3333", 1500);
        int size = orangeBank.getUsersList().getSize();
        System.out.println(size);
        //orangeBank.deleteUser(2);
    }
}
