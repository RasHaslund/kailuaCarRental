package kailuaCarRental.model;


public class Customer {
    private int customerId;   // PK i databasen (0 før insert)
    private String name;
    private String address;
    private String zip;       // String så vi bevarer evt. foranstillede nuller
    private String city;
    private String phone;
    private String email;


    public Customer() {
    }


    public Customer(String name, String address, String zip, String city, String phone, String email) {
        this(0, name, address, zip, city, phone, email);
    }

    public Customer(int customerId, String name, String address, String zip, String city, String phone, String email) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%d | %s | %s | %s | %s | %s | %s",
                customerId, name, address, zip, city, phone, email);
    }
}