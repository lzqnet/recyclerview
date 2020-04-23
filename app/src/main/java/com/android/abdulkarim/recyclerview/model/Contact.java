package com.android.abdulkarim.recyclerview.model;

public class Contact {

    private String contactName;
    private String contactNumber;
    private String cTime;

    public Contact(String contactName, String contactNumber,String cTime) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.cTime = cTime;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }
    public String getcTime(){
        return cTime;
    }
}
