package com.android.abdulkarim.recyclerview.common;

import com.android.abdulkarim.recyclerview.model.Contact;

import java.util.ArrayList;
import java.util.List;

public  class Data {

    public List<Contact> getContactList (){

        List<Contact> contactList = new ArrayList<>();

        contactList.add(new Contact("0 ","+880123456789","10:27 pm"));
        contactList.add(new Contact("1 ","+880123445555","11:00 pm"));
        contactList.add(new Contact("2 ","+8801700000000","11:30 pm"));
        contactList.add(new Contact("3 ","+8801777777777","12:00 am"));
        contactList.add(new Contact("4 ","+8801800000000","12:30 am"));
        contactList.add(new Contact("5 ","+8801900000000","1:00 am"));
        contactList.add(new Contact("6 ","+8801700000000","1:30 am"));
        contactList.add(new Contact("7 ","+8801700000000","2:00 am"));
        contactList.add(new Contact("8 ","+8801700000000","2:30 am"));
        contactList.add(new Contact("9 ","+8801700000000","9:00 pm"));
        contactList.add(new Contact("10","+8801700000000","10:20 pm"));
        contactList.add(new Contact("11","+8801700000000","11:07 pm"));
        contactList.add(new Contact("12","+8801700000000","11:30 pm"));
        contactList.add(new Contact("13","+8801700000000","11:50 pm"));
        contactList.add(new Contact("14","+8801700000000","11:50 pm"));
        contactList.add(new Contact("15 ","+880123445555","11:00 pm"));
        contactList.add(new Contact("16 ","+880123445555","11:00 pm"));
        contactList.add(new Contact("17 ","+880123445555","11:00 pm"));
        contactList.add(new Contact("18 ","+880123445555","11:00 pm"));
        contactList.add(new Contact("19 ","+880123445555","11:00 pm"));

        return contactList;

    }
}
