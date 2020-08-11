package com.base;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    private String addressBookName;
    public ArrayList<PersonInfo> persons;
    public Map<String ,List<PersonInfo>> groupByCity;
    public Map<String,List<PersonInfo>> groupByState;

    AddressBook(String addressBookName){
        this.addressBookName = addressBookName;
        persons = new ArrayList<PersonInfo>();
    }

    public String getAddressBookName() {
        return addressBookName;
    }

    public void addPerson() {

        Scanner scanner  = new Scanner(System.in);
        System.out.println("Enter the first name:-");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name:-");
        String lastName = scanner.nextLine();
        if(getPersonByFullName(firstName+" "+lastName) != null){
            System.out.println("Already exist person with name:- " + firstName + " " + lastName);
            return;
        }
        System.out.println("Enter the address name:-");
        String address = scanner.nextLine();
        System.out.println("Enter the city name:-");
        String cityName = scanner.nextLine();
        System.out.println("Enter the state name:-");
        String stateName = scanner.nextLine();
        System.out.println("Enter the zip code name:-");
        String zipCode = scanner.nextLine();
        System.out.println("Enter the phone number name:-");
        String phoneNumber = scanner.nextLine();

        PersonInfo personInfo = new PersonInfo(firstName,lastName,address,cityName,stateName,zipCode,phoneNumber);
        personInfo.setFullName(firstName,lastName);
        persons.add(personInfo);
        updateMapByCityOrState();
        System.out.println("Added person successfully.");
    }

    public void editPersonInfo(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Enter the person name you want to edit:-");
        String fullNameOfPerson = scanner.nextLine();
        PersonInfo personInfo = getPersonByFullName(fullNameOfPerson);
        if(personInfo == null){
            System.out.println("No entry found for this user name :- "+ fullNameOfPerson);
        }else {
            System.out.println("Enter the address name:-");
            String address = scanner.nextLine();
            System.out.println("Enter the city name:-");
            String cityName = scanner.nextLine();
            System.out.println("Enter the state name:-");
            String stateName = scanner.nextLine();
            System.out.println("Enter the zip code name:-");
            String zipCode = scanner.nextLine();
            System.out.println("Enter the phone number name:-");
            String phoneNumber = scanner.nextLine();
            personInfo.setAddress(address);
            personInfo.setCityName(cityName);
            personInfo.setStateName(stateName);
            personInfo.setZipCode(zipCode);
            personInfo.setPhoneNumber(phoneNumber);
            System.out.println("Updated Person info successfully");
            updateMapByCityOrState();
            displayAddressBookByName(fullNameOfPerson);
        }
   }

   public void deletePersonByFullName(){
       Scanner scanner  = new Scanner(System.in);
       System.out.println("Enter the person name you want to delete:-");
       String fullNameOfPerson = scanner.nextLine();
       PersonInfo personInfo = getPersonByFullName(fullNameOfPerson);
       if(personInfo == null) {
           System.out.println("No entry found for this user name :- " + fullNameOfPerson);
       }else{
           persons.remove(personInfo);
           System.out.println("Deleted person info successfully");
       }
       updateMapByCityOrState();
   }


   public void addMultiplePersonInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of entry you want to add: ");
        int numberOfEntry = sc.nextInt();
        for(int entryNumber = 1;entryNumber <= numberOfEntry;entryNumber++){
            addPerson();
        }
   }

   public void sortAddressBook(){
       List<PersonInfo> sortedAddressBook = null;
       Scanner scanner  = new Scanner(System.in);
       int option = 0;
       System.out.println("Sort on basis of:- \n 1. Name \n 2. City \n 3. Zip Code \n 4. State");
       option = scanner.nextInt();
       switch (option){
           case 1:
               sortedAddressBook = persons.stream()
                                          .sorted(Comparator.comparing(PersonInfo::getFullName))
                                          .collect(Collectors.toList());
               break;

           case 2:
               sortedAddressBook = persons.stream()
                                          .sorted(Comparator.comparing(PersonInfo::getCityName))
                                          .collect(Collectors.toList());
               break;

           case 3:
               sortedAddressBook = persons.stream()
                                          .sorted(Comparator.comparing(PersonInfo::getZipCode))
                                          .collect(Collectors.toList());
               break;

           case 4:
               sortedAddressBook = persons.stream()
                                          .sorted(Comparator.comparing(PersonInfo::getStateName))
                                          .collect(Collectors.toList());
               break;

       }

       displayAddressBook(sortedAddressBook);
   }


    private PersonInfo getPersonByFullName(String fullName){
        PersonInfo person = persons.stream()
                .filter(personInfo -> fullName.equals(personInfo.getFullName()))
                .findAny()
                .orElse(null);
        return person;
    }

    public void displayAddressBook(){
        if(persons.size() == 0){
            System.out.println("Empty Address Book");
        }else{
            for(PersonInfo personInfo : persons){
                System.out.println(personInfo.toString());
            }
            System.out.println();
        }
    }

    public void displayAddressBook(List<PersonInfo> sortedPersonInfoList){
        if(sortedPersonInfoList.size() == 0){
            System.out.println("Empty Address Book");
        }else{
            for(PersonInfo personInfo : sortedPersonInfoList){
                System.out.println(personInfo.toString());
            }
            System.out.println();
        }
    }

    private void displayAddressBookByName(String fullName){
        for(PersonInfo personInfo : persons){
            if(personInfo.getFullName().equals(fullName)){
                System.out.println(personInfo);
                return;
            }
        }
        System.out.println("No entry found for this person :- " + fullName);
    }

    private void updateMapByCityOrState(){
        groupByCity = persons.stream().collect(Collectors.groupingBy(PersonInfo::getCityName));
        groupByState = persons.stream().collect(Collectors.groupingBy(PersonInfo::getStateName));
    }

    public void viewPersonByCityOrState(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Want to view by:- \n 1. City \n 2. State \n");
        int option = scanner.nextInt();
        if(option == 1) {
            groupByState.forEach((key, value) -> System.out.println(key + "->" + value));
        }else if(option == 2){
            groupByCity.forEach((key, value) -> System.out.println(key + "->" + value));
        }else {
            System.out.println("Enter valid option");
        }
    }

    public void searchPersonsByCityOrState(){
        Scanner scanner = new Scanner(System.in);
        String searchParam;
        System.out.print("Want to search by:- \n 1. City \n 2. State \n");
        int option = scanner.nextInt();
        if(option == 1) {
            System.out.println("Enter city name:- ");
            searchParam = scanner.next();
            List<PersonInfo> personInfos = groupByCity.get(searchParam);
            if(personInfos == null){
                System.out.println("No records for the city:- "+ searchParam);
                return;
            }else{
                displayAddressBook(personInfos);
            }
        }else if(option == 2){
            System.out.println("Enter state name:- ");
            searchParam = scanner.next();
            List<PersonInfo> personInfos = groupByState.get(searchParam);
            if(personInfos == null){
                System.out.println("No records for the state:- "+ searchParam);
                return;
            }else{
                displayAddressBook(personInfos);
            }
        }else {
            System.out.println("Enter valid option");
        }
    }
}
