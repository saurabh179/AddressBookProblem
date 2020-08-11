package com.base;

import java.util.*;

public class AddressBookManager {

    Map<String, AddressBook> addressBooks;
    Scanner scanner;

    public AddressBookManager(){
        addressBooks = new HashMap<String, AddressBook>();
        scanner = new Scanner(System.in);
    }

    public void addAddressBook(){
        System.out.println("Enter the Address Book Name:- ");
        String addressBookName = scanner.next();
        if(addressBooks.containsKey(addressBookName)){
            System.out.println("Address Book with name :- " + addressBookName + " already exist");
            return;
        }
        AddressBook addressBook = new AddressBook(addressBookName);
        addressBooks.put(addressBookName,addressBook);
        manageAddressBook(addressBook);
    }


    public void manageAddressBook(AddressBook addressBook) {
        String choice = "0";
        while(true) {
            System.out.print("Select any option: \n 1. Get Address Book Name \n 2. Add Person \n 3. Display Address Book \n" +
                    " 4. Edit Person Info \n 5. Delete Person Info \n 6. Add Multiple Persons Info" +
                    " \n 7. Sort Address Book by Full Name \n 8. View Person By City and State" +
                    " \n 9. Search Persons By City and State \n 10. Exit \n");
            choice = scanner.next();
            switch (choice) {

                case "1":
                    System.out.println(addressBook.getAddressBookName());
                    break;

                case "2":
                    addressBook.addPerson();
                    break;

                case "3":
                    addressBook.displayAddressBook();
                    break;

                case "4":
                    addressBook.editPersonInfo();
                    break;

                case "5":
                    addressBook.deletePersonByFullName();
                    break;

                case "6":
                    addressBook.addMultiplePersonInfo();
                    break;

                case "7":
                    addressBook.sortAddressBook();
                    break;

                case "8":
                    addressBook.viewPersonByCityOrState();
                    break;

                case "9":
                    addressBook.searchPersonsByCityOrState();
                    break;

                case "10":
                    return;

                default:
                    System.out.println("Please enter valid option.");
            }
        }
    }

    public void getAddressBookByName(){
        System.out.println("Enter Address Book Name:- ");
        String addressBookName = scanner.next();
        if(addressBooks.containsKey(addressBookName)){
            addressBooks.get(addressBookName).displayAddressBook();
        }else{
            System.out.println("Address Book with the name :- " + addressBookName + " does not exist");
        }
    }

    public void manageAddressBookByName(){
        System.out.println("Enter Address book name:- ");
        String addressBookName = scanner.next();
        if(addressBooks.containsKey(addressBookName)){
            manageAddressBook(addressBooks.get(addressBookName));
        }else {
            System.out.println("Address Book with name :- " + addressBookName + " does not exist");
        }
    }


    public void getAllAddressBook() {
        if(addressBooks.isEmpty()){
            System.out.println("Empty Address Book");
            return;
        }
        Set<String> addressBookName = addressBooks.keySet();
        addressBookName.stream().forEach(System.out::println);
    }

    public void deleteAddressBookByName(){
        System.out.println("Enter Address book name:- ");
        String addressBookName = scanner.next();
        if(addressBooks.containsKey(addressBookName)){
            addressBooks.remove(addressBookName);
            System.out.println("Address Book " + addressBookName + " deleted successfully");
        }else{
            System.out.println("Address book " + addressBookName + " does not exist");
        }
    }

    public void deleteAllAddressBook(){
        addressBooks.clear();
    }

}
