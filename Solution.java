package sdbms;

import java.util.Scanner;

import CustomException.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Student DB Management System");
		System.out.println("---------------");
		
		Scanner ip= new Scanner(System.in);
		StudentManagementSystem sms= new StudentManagementSystemImpl();
		while(true)
		{
			System.out.println("display 1:Add Student/n2:Display Student");
			System.out.println("3:Display All Student/n4:Remove Student");
			System.out.println("5:Remove All Student/n6:Update Student");
			System.out.println("7:Count Student/n8Sort Student");
			System.out.println("9:Get Student With Lowest Marks/n10Get Student With Highest Marks/n11EXIT");
			System.out.println("Enter The Choice");

			int choice=ip.nextInt();
			switch(choice)
			{
			case 1:
				sms.addStudent();
				System.out.println();
				break;

			case 2:
				sms.displayStudent();
				System.out.println();
				break;

			case 3:
				sms.displayAllStudent();
				System.out.println();
				break;

			case 4:
				sms.removeStudent();
				System.out.println();
				break;

			case 5:
				sms.removeAllStudent();
				System.out.println();
				break;

			case 6:
				sms.updateStudent();
				System.out.println();
				break;

			case 7:
				sms.countStudent();
				System.out.println();
				break;

			case 8:
				sms.sortStudent();
				System.out.println();
				break;

			case 9:
				sms.getStudentWithLowestMarks();
				System.out.println();
				break;

			case 10:
				sms.getStudentWithHighestMarks();
				System.out.println();
				break;

			case 11:
				System.out.println("Thank You");
				System.exit(0);

			default:
				try {
					throw new InvalidChoiceException ("Invalid Choice!!!");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}

			} // end of switch

			System.out.println("-----------------");

		} //end of while loop

	}// end of main()

} //end of class
