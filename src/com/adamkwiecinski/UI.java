package com.adamkwiecinski;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class UI {
    private final Scanner scanner;
    private final ContactRepository contactRepository;
    private final SearchEngine searchEngine;

    public UI(String filePath) {
        this.contactRepository = new ContactRepository(filePath);
        this.scanner = new Scanner(System.in);
        this.searchEngine = new SearchEngine(contactRepository.getContactRepository(), new SearchAny());

    }

    public void run(){
        boolean isRunning = true;
        while (isRunning){
            printMenu();
            String action = scanner.nextLine();
            switch (action){
                case "1":
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String choice = scanner.nextLine();
                    setSearchStrategy(choice);
                    System.out.println("Enter a name or email to search all suitable people:");
                    String searchQuery = scanner.nextLine();
                    printFoundRecords(searchQuery);
                    break;
                case "2":
                    printContactRepository();
                    break;
                case "0":
                    isRunning = false;
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Wrong option");
            }
        }
    }

    private void printFoundRecords(String searchQuery){
        List<String> foundRecords = searchEngine.search(Arrays.asList(searchQuery.split("\\s+")), searchEngine.getDictionary(), searchEngine.getIndex());
        if(foundRecords.size() > 0){
            System.out.println(foundRecords.size() + " persons found:");
            foundRecords.forEach(System.out::println);
        } else {
            System.out.println("No matching people found");
        }
    }

    private void printContactRepository(){
        if(contactRepository != null && contactRepository.getContactRepository().size() > 0){
            System.out.println("List of people:");
            contactRepository.getContactRepository().forEach(System.out::println);
        } else {
            System.out.println("Contact repository is empty");
        }
    }

    private void printMenu(){
        System.out.println("=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit");
    }

    private void setSearchStrategy(String choice){
        switch(choice){
            case "ANY":
                searchEngine.setSearchStrategy(new SearchAny());
                break;
            case "ALL":
                searchEngine.setSearchStrategy(new SearchAll());
                break;
            case "NONE":
                searchEngine.setSearchStrategy(new SearchNone());
                break;
            default:
                System.out.println("Wrong option");
        }
    }

}
