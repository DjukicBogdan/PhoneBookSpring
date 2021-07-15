package model;

public class PhoneBook {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String adress;

    public PhoneBook(int id, String name, String phoneNumber, String email, String adress) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;
    }

    public PhoneBook(String name, String phoneNumber, String email, String adress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;
    }

    public PhoneBook() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
