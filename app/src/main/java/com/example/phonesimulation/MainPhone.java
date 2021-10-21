package com.example.phonesimulation;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPhone {
    private static ArrayList<Contacts> contacts;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String[] args) {
        int id = 0;
        contacts = new ArrayList<>();
        System.out.println("Hello!");
        userOption();
    }

    private static void userOption () {
        System.out.println("Choose option...");
        System.out.println("\t" + "1.Manage Contacts" + "\n" + "\t" + "2.Send Message" + "\n" + "\t" + "3.Quit");
        Scanner userInput = new Scanner(System.in);
        int namba = userInput.nextInt();
        switch (namba) {
            case 1:
                manageContacts();
                break;
            case 2:
                sendMessage();
                //System.out.println("Case 2");
                break;
            case 3:
                System.out.println("Exiting Program");
                System.exit(0);
        }
    }

    private static void sendMessage() {
        System.out.println("Send Message To...");
        Scanner messageR = new Scanner(System.in);
        String messageReceiver = messageR.next();
        //create boolean to ensure contact exists in list
        boolean contactExist = false;
        //create for Each Loop
        for (Contacts contacts : contacts) {
            if (contacts.getName().equalsIgnoreCase(messageReceiver)) {
                contactExist = true;
                System.out.println("Type message:");
                Scanner mytext = new Scanner(System.in);
                String text = mytext.next();
                id++;
                //updating contacts' ArrayList
                Message newmessage = new Message(text,contacts.getName(), id);
                ArrayList<Message> messages = contacts.getMessages();
                messages.add(newmessage);
                contacts.setMessages(messages);

                Contacts newContact = contacts;
                contacts.remove(contacts); //removing contact is erroneous
                contacts.add(contacts);
                System.out.println("Message: "+newmessage.getTextMessage()+"\n"+"\t"+" HAS BEEN SENT TO: "
                        +newmessage.getReceiversName());
                userOption();
            }
        }
        //outside for loop
        if (!contactExist) {
            System.out.println("No existing contact!");
            userOption();

        }
    }

    private static void manageContacts() {
        System.out.println("\t" + "1.Show all contacts" + "\n" + "\t" + "2.Add new contact" +
                "\n" + "\t" + "3.Search for a Contact" + "\n" + "\t" + "4.Remove a Contact" + "\n" +
                "\t" + "5.Go back");
        Scanner userchoice = new Scanner(System.in);
        int choice = userchoice.nextInt();
        switch (choice) {
            case 1:
                //System.out.println("Manage ContactsM");
                //showContacts method
                showContacts();
                manageContacts();
                break;
            case 2:

                newContact();
                //showContacts();
                manageContacts();
                break;

            case 3:
                searchMethod();
                //System.out.println("Case 3");
                manageContacts();
                break;

            case 4:
                removeContact();
                //System.out.println("Case 4");
                manageContacts();
                break;
            case 5:
                //showContacts();
                System.out.println("Go back...");
                //manageContacts();
                userOption();
                break;
            default:
                //showContacts();
                manageContacts();
                break;
        }
    }

    private static void removeContact() {
        System.out.println("Enter name to delete:");
        Scanner nameOmit = new Scanner(System.in);
        String nameToOmit = nameOmit.next();
        //create a for [each] loop to look for that contact
        //create a boolean
        boolean ifNameExists = false;
        for (Contacts contacts : contacts) {
            if (contacts.getName().equals(nameToOmit)) {
                ifNameExists = true;
                System.out.println("Are you sure you want to delete? Y/N");
                Scanner yorN = new Scanner(System.in);
                String yesOrNo = yorN.next();
                if (yesOrNo.equalsIgnoreCase("Y")) {
                    //contacts.remove(contacts);
                    System.out.println("Contact removed!");
                    showContacts();
                } else if (yesOrNo.equalsIgnoreCase("N")) {
                    showContacts();
                } else {
                    showContacts();

                }
            }
        }
        //outside of for loop > boolean
        if (!ifNameExists) {
            System.out.println("Name does not exist in Contacts List");
            showContacts();
        }
    }

    private static void searchMethod() {
        System.out.println("Enter name for Search..");
        Scanner nameS = new Scanner(System.in);
        String nameSearch = nameS.next();
        //search loop so for loop
        boolean ifNameExists = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(nameSearch)) {
                contacts.get(i).getDetails();
                showContacts();
                //in this for loop, the boolean is true for it
                ifNameExists = true;
            }
        }
        if (!ifNameExists) {
            System.out.println("No match in contacts!");
            showContacts();
        }
    }

    private static void newContact() {
        System.out.println("Type in new Name: ");
        Scanner scanName1 = new Scanner(System.in);
        String scanName = scanName1.next();
        System.out.println("Type in email: ");
        Scanner scanEmail1 = new Scanner(System.in);
        String scanEmail = scanName1.next();
        System.out.println("Type in phone number: ");
        Scanner scanPhone1 = new Scanner (System.in);
        int scanPhone = scanPhone1.nextInt();
        //create new contact object
        //Class objName = new obj (attrb)
        Contacts addNewContact = new Contacts(scanName, scanEmail, scanPhone);
        contacts.add(addNewContact);
        System.out.println(scanName+", "+scanEmail+", "+scanPhone);
    }

    private static void showContacts() {
            for (Contacts contacts1 :contacts) {
                contacts1.getDetails();
                System.out.println("----------");
            }
        }
    }




