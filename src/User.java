public class User {
    private int id;
    private String name;
    private String address;
    private String SSN;
    private double amount;
    public User() {}
    public User(int id, String name, String address, String SSN, double amount) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.SSN = SSN;
        this.amount = amount;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", SSN=" + SSN +
                ", amount=" + amount +
                '}';
    }
    public boolean equals(User other) {
        if(name.equals(other.name) && address.equals(other.address)
                && SSN.equals(other.SSN) && amount == other.amount) {
            return true;
        }
        return false;
    }
}

