package com.example.kh.myapplication.Module;

/**
 * Created by kh on 6/14/2017.
 */

public class Contact {
    private int Id;
    private String Phone;
    private String Email;
    private String Name;
    private String Src;

    public Contact(int Id, String Name, String Email, String Phone, String Src) {
        this.Id = Id;
        this.Name = Name;
        this.Phone = Phone;
        this.Email = Email;
        this.Src = Src;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSrc() {
        return Src;
    }

    public void setSrc(String url) {
        Src = url;
    }
}
