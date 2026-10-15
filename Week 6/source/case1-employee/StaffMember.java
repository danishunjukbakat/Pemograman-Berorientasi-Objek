public abstract class StaffMember {
    protected String name, address, phone;

    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public abstract double pay();

    @Override
    public String toString() {
        return name + "\nAddress: " + address + "\nPhone: " + phone;
    }
}
