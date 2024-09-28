public class User {
    private int id;
    private String name;
    private String address;
    private String SSN;
    private double balance;
    public User() {}
    public User(int id, String name, String address, String SSN, double balance) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.SSN = SSN;
        this.balance = balance;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSocialSecurityNum() {
        return SSN;
    }

    public void setSocialSecurityNum(String socialSecurityNum) {
        this.SSN = socialSecurityNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", SSN=" + SSN +
                ", amount=" + balance +
                '}';
    }
    public boolean equals(User other) {
        if(name.equals(other.name) && address.equals(other.address)
                && SSN.equals(other.SSN) && balance == other.balance) {
            return true;
        }
        return false;
    }
}

