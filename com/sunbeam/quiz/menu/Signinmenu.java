package com.sunbeam.quiz.menu;

import java.util.Scanner;
enum ESignInMenu {
    LOGOUT, VIEW_QUIZZES, DISPLAY_SCORES,TAKE_QUIZ
}

public class Signinmenu {
    public static void signInMenuWithEnum(Scanner sc) {
        ESignInMenu[] arr = ESignInMenu.values();

        for (ESignInMenu element : arr)
            System.out.println(element.ordinal() + ". " + element.name());

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice < 0 || choice >= arr.length) {
            System.out.println("Invalid choice");
            return;
        }
    
        ESignInMenu enumChoice = arr[choice];

        switch (enumChoice) {
            case VIEW_QUIZZES:
                System.out.println("You have selected attempt quiz");
            	
                break;
            case DISPLAY_SCORES:
                System.out.println("You have selected Display quiz");
                break;
            case TAKE_QUIZ :
                System.out.println("You have selected Display Profile");
                break;
            case LOGOUT:
                System.out.println("Exiting...");
                break;
        }
    }
}

