public class Users {
    private int id;
    private String name;
    private String address;
    private int SSN;
    private double amount;
    public Users(int id, String name, String address, int SSN, double amount) {
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

    public int getSocialSecurityNum() {
        return SSN;
    }

    public void setSocialSecurityNum(int socialSecurityNum) {
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
}

