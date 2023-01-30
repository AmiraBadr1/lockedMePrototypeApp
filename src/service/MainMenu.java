package service;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    List<String> retrieve= new ArrayList<String>();
    File [] file = new File("C:\\Users\\IsmailA14\\lockedMe").listFiles();

    public void retrieveAllFiles() {
        // TODO Auto-generated method stub
        for(File file : file) {
            if(file.isFile()) {
                retrieve.add(file.getName());
            }
        }
        retrieve.forEach(System.out::println);
    }
    public void addFile() {
        // TODO Auto-generated method stub
        System.out.println("Enter the file name you want to add:");
        Scanner scan=new Scanner(System.in);
        String filename=scan.nextLine();
        File fl= new File(filename);
        try {
            if(fl.createNewFile()) {
                System.out.println(filename+" file is added");
                Desktop.getDesktop().edit(fl);
            }
            else {
                System.out.println("This file is already exists");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void deleteFile() {
        // TODO Auto-generated method stub
        System.out.println("Enter the file name you want to delete:");
        Scanner scan=new Scanner(System.in);
        String fileName=scan.nextLine();
        File fl= new File(fileName);
        if(fl.delete())
            System.out.println(fileName+" File Successfully Deleted");
        else
            System.out.println("File Not Found");
    }

    public void searchFile() {

        // TODO Auto-generated method stub
        try {
            Scanner scan= new Scanner(System.in);
            File directory = new File("C:\\Users\\IsmailA14\\lockedMe");
            System.out.println("Enter the file name you want to search:");
            String fileName=scan.nextLine();
            File[] files=directory.listFiles();
            int flag=0;
            for (File file : files) {
                String name = file.getName();
                if (name.equals(fileName)) {
                    System.out.println("The filename "+fileName+" found in the directory");
                    File f= new File(fileName);
                    Scanner sc1 = new Scanner(f);
                    while(sc1.hasNextLine()) {
                        System.out.println(sc1.nextLine());
                    }
                    flag=1;
                }
            }
            if(flag==0) {
                System.out.println("File not found");
            }

        }catch(FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}

