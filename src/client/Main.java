package client;

import service.MainMenu;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void mainMenu() {
        System.out.println("Welcome To : LockedMe.com \n");
        System.out.println("Developed By: Amira Ismail \n");
    }

    public static void actionsMenu() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        MainMenu action = new MainMenu();
        int option;
        do {
            System.out.println("~~Main Menu~~ \n");
            System.out.println("Please select one of these options: \n");
            System.out.println("\t1. Display all current files \n");
            System.out.println("\t2. Modify files operation menu \n");
            System.out.println("\t3. Exit from the application \n");

            option=sc.nextInt();
            switch(option) {
                case 1:
                    action.retrieveAllFiles();
                    break;
                case 2:
                    int act;
                    do {
                        System.out.println("Please choose your action:");
                        System.out.println("\t1. Add a new file to a directory");
                        System.out.println("\t2. Delete a file from a directory");
                        System.out.println("\t3. Search for a file ");
                        System.out.println("\t4. Go back to the main menu");

                        act=sc.nextInt();
                        switch(act) {
                            case 1:
                                action.addFile();
                                break;
                            case 2:
                                action.deleteFile();
                                break;
                            case 3:
                                action.searchFile();
                                break;
                            case 4:
                                System.out.println("Back to the Main Menu...");
                                System.out.println("---------------------------------\n");
                                break;
                            default:
                                System.out.println("Invalid Choice");
                                break;
                        }
                    }while(act!=4);
                    break;
                case 3:
                    System.out.println("Closing the application....");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

          }while(option!=3);

    }
    public static void main(String[] args) throws FileNotFoundException {
        mainMenu();
        actionsMenu();
    }
}