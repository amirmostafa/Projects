/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Hossam
 */
public class user {
    private int ID;
    private String Name;
    private String Password;
    private String mobileNumber;
    private String Address;

    public user(int ID, String Name, String Password, String mobileNumber, String Address) {
        this.ID = ID;
        this.Name = Name;
        this.Password = Password;
        this.mobileNumber = mobileNumber;
        this.Address = Address;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAddress() {
        return Address;
    }
    
    
}
