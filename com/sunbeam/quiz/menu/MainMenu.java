package com.sunbeam.quiz.menu;

import java.util.Scanner;

enum EMainMenu {
    EXIT, SIGNIN, SIGNUP, ADMIN
}

public class MainMenu {

    
    public static void mainMenuWithEnum(Scanner sc) {
        EMainMenu[] arr = EMainMenu.values();

        for (EMainMenu element : arr)
            System.out.println(element.ordinal() + ". " + element.name());

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice < 0 || choice >= arr.length) {
            System.out.println("Invalid choice");
            return;
        }

        EMainMenu enumChoice = arr[choice];

        switch (enumChoice) {
            case SIGNIN:
                System.out.println("You have selected Signin");
            	Signinmenu.signInMenuWithEnum(sc);
                break;
            case SIGNUP:
                System.out.println("You have selected Signup");
                break;
            case ADMIN:
                System.out.println("You have selected Admin");
            	AdminMenu.adminMenuWithEnum(sc);

                break;
            case EXIT:
                System.out.println("Exiting...");
                break;
        }
    }
}

  



		
	
	
	/*public static void mainMenu(Scanner sc) {
		int choice;
		while((choice=mainMenuOptions(sc))!=0) {
			switch(choice) {
			case 1:
				System.out.println("You  have selected signin case");
				Signinmenu.signInMenu(sc);
				break;
			case 2:
				System.out.println("You have selected signup case");
				break;
			case 3:
				System.out.println("You have selected Admin case");
				break;
				default :
				
					System.out.println("wrong choice");
					break;
				


			}
		}
		
	
	}
	



}*/
