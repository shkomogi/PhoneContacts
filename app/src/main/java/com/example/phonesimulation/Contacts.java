package com.example.phonesimulation;

import java.util.ArrayList;
import java.util.Scanner;

public class Contacts extends Main{
    /*
    •	Show all contacts
•	Add new contact
•	Search for a contact
•	Remove a contact
•	Go back

     */
    //Create a map
    //Map <String,Integer> myContacts = new HashMap<>();
    private ArrayList <Message> messages;
    private String name;
    private String email;
    private int phoneNumber;

    //constructor


    public void ContactsM(ArrayList<Message> messages, String name, String email, int phoneNumber) {
        this.messages = messages;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    //create a second constructor


    public Contacts(String name, String email, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        messages = new ArrayList<>(); //new Arraylist for messages- polymorphism
    }
    //getter setter


    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //create method
    public void ScannerMethod ( int UserInput){
        Scanner userOption = new Scanner(System.in);
        int Choice = userOption.nextInt();
        System.out.println(Choice);
    }

    public void ScannerTextMethod (String UserInputString){
        Scanner userOptionString = new Scanner(System.in);
        String ChoiceString = userOptionString.next();
        System.out.println(ChoiceString);
    }

    //create getDetails method + use ''this''Name coz in same class
    public void getDetails(){
        System.out.println("Name: "+this.name+" Email: "+this.email+" Phone: "+this.phoneNumber);
    }


    public void remove(Contacts contacts) {
    }

    public void add(Contacts contacts) {
    }
}
