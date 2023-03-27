package sdbms;

import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



import CustomException.InvalidChoiceException;
import CustomException.StudentNotFoundException;
import CustomSorting.sortStudentByAge;
import CustomSorting.sortStudentById;
import CustomSorting.sortStudentByMarks;
import CustomSorting.sortStudentByName;

public class StudentManagementSystemImpl implements StudentManagementSystem {


	Scanner scan = new Scanner(System.in);

	Map<String,Student> db= new LinkedHashMap<String,Student>();

	@Override
	public void addStudent()
	{   
		System.out.println("Enter Student Age:");
		int age=scan.nextInt();
		System.out.println("Enter Student Name:");
		String name=scan.next();
		System.out.println("Enter Student Marks:");
		int marks=scan.nextInt();

		Student std= new Student(age,name,marks);
		db.put(std.getId(),std);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("Student Id is:"+std.getId());


	}
	@Override
	public void displayStudent()
	{
		System.out.println("Enter Student Id:");
		String id= scan.next(); ///String id=scan.next();
		id=id.toUpperCase(); // database converting into upper case

		if(db.containsKey(id))
		{
			Student std=db.get(id);
			System.out.println("Id:"+std.getId());
			System.out.println("Age:"+std.getAge());
			System.out.println("Name:"+std.getName());
			System.out.println("Marks:"+std.getMarks());
			//System.out.println(std)-> printing ref variabler as toString() is Overriden     

		}
		else
		{
			try {
				String message="Student with the Id"+id+"is NotFound!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudent()
	{   
		if(db.size()!=0)
		{
			System.out.println("Student Deatils are Follows:");
			System.out.println("----------------------------");
			Set<String> keys= db.keySet();//JSP101 JSP102 JSP103 //map into set->keySet()
			for(String key:keys)// for each loop to traverse keys
			{
				Student value= db.get(key);
				System.out.println(value); // db.get(key)-> getting value(student objects)
			}
		}
		else
		{
			try {
				String message="Student Records Not Available to Display!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeStudent()
	{
		System.out.println("Enter Student Id:");
		String id= scan.next(); ///String id=scan.next();
		id=id.toUpperCase(); // database converting into upper case
		if(db.containsKey(id)) 
		{
			System.out.println("Student Record Found!");
			System.out.println(db.get(id)); //printing student object
			db.remove(id);
			System.out.println(" Student Record Deleted Succussefully!");

		}
		else
		{
			try
			{
				String message="Student With th If"+id+" is Not Found!";
				throw new StudentNotFoundException(message); 
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudent()
	{
		if(db.size()!=0) {
			System.out.println("Students Records Available:"+db.size());
			db.clear();
			System.out.println("All Student Records Deleted Succussefully!");
			System.out.println("Students Records Available:"+db.size());
		}

		else
		{
			try {
				String message="Student Database is Empty!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}	
		}
	}

	@Override
	public void updateStudent()
	{
		System.out.println("Enter the Student Id: ");
		String id=scan.next().toUpperCase();
		if(db.containsKey(id))
		{
			Student std=db.get(id);
			System.out.println("1:UpdateAge\n2:UpdateName\n3:Marks");
			System.out.println("Enter your choice: ");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the Age: ");
				int age=scan.nextInt();
				std.setAge(age);
				break;
			case 2:
				System.out.println("Enter the Age: ");
				String name=scan.next();
				std.setName(name);
				break;
			case 3:
				System.out.println("Enter the Age: ");
				int marks=scan.nextInt();
				std.setMarks(marks);//std.setMarks(ip.nextInt());
				break;
			default:
				try
				{   
					String message="Invalid Choice, Enter Valid Choice!";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}	
			}

		}
		else
		{
			try
			{   
				String message="Student with The Id"+id+"is Not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}	
		}

	}


	@Override
	public void countStudent()
	{
		System.out.println("No Of Student Records :"+db.size());
	}
	
	@Override
	public void sortStudent()
	{
		if(db.size()>=2) {
			Set<String> keys= db.keySet();
			List <Student>list= new ArrayList<Student>();
			for(String key:keys)
			{
				list.add(db.get(key));
			}
			System.out.println("Display1:sortStudentById/n2:sortStudentByAge/n3:sortStudentByName/n4:sortStudentByMarks/n Enter Choice");
			int choice=scan.nextInt();
			switch(choice)
			{

			case 1:
				Collections.sort(list, new sortStudentById());
				for(Student s:list)
				{
					System.out.println(s);
				}
				break;

			case 2:
				Collections.sort(list, new sortStudentByAge());
				for(Student s:list)
				{
					System.out.println(s);
				}
				break;
			case 3:
				Collections.sort(list, new sortStudentById());
				for(Student s:list)
				{
					System.out.println(s);
				}
				break;

			case 4:
				Collections.sort(list, new sortStudentByMarks());
				for(Student s:list)
				{
					System.out.println(s);
				}
				break;

			default:
				try {
					String message="Invalid Choice , Enter Valid Choice:";
					throw new InvalidChoiceException("message");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		else
		{
			try
			{   
				String message="No Sufficient Student Objects to Compare!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}	
		}
	}

	private static void display(List<Student> list)
	{
		for(Student s:list)
		{

			System.out.println(s);
		}

	}

	@Override
	public void getStudentWithLowestMarks()
	{
		if(db.size()>=2) {
			Set<String> keys= db.keySet();
			List <Student>list= new ArrayList<Student>();
			for(String key:keys)
			{
				list.add(db.get(key));
			}
			Collections.sort(list, new sortStudentByMarks());
			System.out.println(list.get(0)); //getting std object & printing it->toString();	
		}
		else
		{
			try
			{   
				String message="No Sufficient Student Objects to Compare";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}	

		}
	}

	@Override
	public void getStudentWithHighestMarks()
	{
		if(db.size()>=2) {
			Set<String> keys= db.keySet();
			List <Student>list= new ArrayList<Student>();
			for(String key:keys)
			{
				list.add(db.get(key));
			}
			Collections.sort(list, new sortStudentByMarks());
			System.out.println(list.get(list.size()-1));
		}
		else
		{
			try
			{   
				String message="No Sufficient Student Objects to Compare";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}	
		}

	}
}
