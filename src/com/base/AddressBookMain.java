package com.base;

import java.util.Scanner;

public class AddressBookMain {

    public static String choice = "0";
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Problem");
        AddressBookManager addressBookManager = new AddressBookManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Select any option: \n 1. Add New Address Book \n 2. Display All Address Book \n" +
                             " 3. Display Address Book By Name \n 4. Manage Address Book By Name " +
                             "\n 5. Delete Address Book By Name \n 6. Delete All Address Book \n 7. Exit \n");
            String option = "0";
            option = sc.next();
            switch (option){
                case "1":
                    addressBookManager.addAddressBook();
                    break;

                case "2":
                    addressBookManager.getAllAddressBook();
                    break;

                case "3":
                    addressBookManager.getAddressBookByName();
                    break;

                case "4":
                    addressBookManager.manageAddressBookByName();
                    break;

                case "5":
                    addressBookManager.deleteAddressBookByName();
                    break;

                case "6":
                    addressBookManager.deleteAllAddressBook();
                    break;

                case "7":
                    System.exit(0);

                default:
                    System.out.println("Enter valid option");
            }
        }

    }

}
