/*package com.sunbeam.quiz.service;

import java.sql.SQLException;
import java.util.Scanner;
import java.io.*;
import java.util.List;

import com.sunbeam.quiz.dao.AdminDao;
import com.sunbeam.quiz.dao.QuestionDao;
import com.sunbeam.quiz.dao.QuizDao;
import com.sunbeam.quiz.util.QuestionFileParser;
import com.sunbeam.quiz.entity.Question;
import com.sunbeam.quiz.entity.Quiz;
import com.sunbeam.quiz.menu.AdminMenu;

public class AdminService {
	private static AdminMenu adm = new AdminMenu();
	public void loginAdmin(Scanner sc ) {
		System.out.print("Enter the E-mail : ");
		String email =sc.next();
		System.out.print("Enter the Password : ");
		String password =sc.next();
		
		try(AdminDao ad = new AdminDao())
		{
			if(ad.adminLogin(email, password)) {
				System.out.println("AdminLogin Successfully");
				adm.adminMenu(sc);
			}
			else System.out.println("AdminLogin Failed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void createQuiz(Scanner sc,int adminid) {
		System.out.print("Enter the Quiz title");
		String title=sc.nextLine();
		sc.next();
		System.out.println("Enter file path");
		File file=new File(sc.next());
		
		
		Quiz quiz=new Quiz();
		quiz.title=title;
		quiz.creator_id=adminid;
		List<Question> list=QuestionFileParser.parse(file);
		try(QuestionDao qdao=new QuestionDao()){
			for(Question q:list) {
				q.quizId=quizId;
				qdao.insert(q);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Quiz Created Successfully with id="+quizId);
			
	}
	}
}*/
package com.sunbeam.quiz.service;

import java.sql.SQLException;
import java.util.Scanner;
import java.io.File;
import java.util.List;

import com.sunbeam.quiz.dao.AdminDao;
import com.sunbeam.quiz.dao.QuestionDao;
import com.sunbeam.quiz.dao.QuizDao;
import com.sunbeam.quiz.util.QuestionFileParser;
import com.sunbeam.quiz.entity.Question;
import com.sunbeam.quiz.entity.Quiz;
import com.sunbeam.quiz.menu.AdminMenu;

public class AdminService {

    private static AdminMenu adm = new AdminMenu();

    public void loginAdmin(Scanner sc) {
        System.out.print("Enter the E-mail : ");
        String email = sc.next();

        System.out.print("Enter the Password : ");
        String password = sc.next();

        try (AdminDao ad = new AdminDao()) {
            if (ad.adminLogin(email, password)) {
                System.out.println("Admin Login Successfully");
                adm.adminMenu(sc);
            } else {
                System.out.println("Admin Login Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createQuiz(Scanner sc, int adminid) {

        sc.nextLine(); // consume leftover newline

        System.out.print("Enter the Quiz title: ");
        String title = sc.nextLine();

        System.out.print("Enter file path: ");
        File file = new File(sc.next());

        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        Quiz quiz = new Quiz();
        quiz.title = title;
        quiz.creator_id = adminid;

        try (QuizDao quizDao = new QuizDao()) {

            // Insert quiz and get generated quiz ID
            int quizId = quizDao.insert(quiz);

            List<Question> list = QuestionFileParser.parse(file);

            try (QuestionDao qdao = new QuestionDao()) {
                for (Question q : list) {
                    q.quizId = quizId;
                    qdao.insert(q);
                }
            }

            System.out.println("Quiz Created Successfully with id = " + quizId);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

