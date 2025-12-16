package com.sunbeam.quiz.menu;

import java.util.Scanner;
enum EAdminMenu {
    LOGOUT, ENTER_QUIZ, LIST_QUIZ,DISPLAY_STUDENTS,
}

public class AdminMenu {
    public static void adminMenuWithEnum(Scanner sc) {
        EAdminMenu[] arr = EAdminMenu.values();

        for (EAdminMenu element : arr)
            System.out.println(element.ordinal() + ". " + element.name());

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice < 0 || choice >= arr.length) {
            System.out.println("Invalid choice");
            return;
        }
        
        
    
        EAdminMenu enumChoice = arr[choice];

        switch (enumChoice) {
            case ENTER_QUIZ:
                System.out.println("You have selected Enter quiz");
            	
                break;
            case LIST_QUIZ:
                System.out.println("Schedule the Quiz Case Selected");
                break;
            case DISPLAY_STUDENTS :
                System.out.println("You have selected Display All Students");
                break;
          
           
            
            case LOGOUT:
                System.out.println("You have selected Logout");
                break;
                
        }
    

}
}

