package com.hibernate_folder.travel_journal_project.pra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TravelJournalManagement {

	public static void main(String[] args) {

		// For taking user choice
		int input = 0;
		
		// Fields
		int id;
		String destination;
		String name;
		LocalDate date;
		double budget;
		
		// Scanner class for taking input
		Scanner sc = new Scanner(System.in);
		
		// Create Spring XML configuration
		ApplicationContext con = 
				new ClassPathXmlApplicationContext("com/hibernate_folder/travel_journal_project/pra/Application-Context.xml");
		
		// Get required beans from Spring container
		TravelJournalDaoImpl daoImplimentation = con.getBean("tj_impli",TravelJournalDaoImpl.class);
		TravelJournal journal = con.getBean("Journal",TravelJournal.class);
		
		// Used to store multiple TravelJournal objects
		List<TravelJournal> list = new ArrayList<>();
		
		// Display menu and take user choice
		while(true) {
			System.out.println("Select your choice : ");
			System.out.println("1 for Insert Data : ");
			System.out.println("2 for Search Data Using ID : ");
			System.out.println("3 for Update Data : ");
			System.out.println("4 for Fetching All The Data : ");
			System.out.println("5 for Delete Data From DataBase : ");
			System.out.println("6 for Exit : ");
			
			System.out.println("Enter Your Choice : ");
			input = sc.nextInt();
			sc.nextLine();
			
			switch(input) {
			case 1 :
			{
			   // Take journal details from user
			   System.out.println("Enter your Id : ");
			   id=sc.nextInt();	
			   sc.nextLine();
			   System.out.println("Enter your Destination : ");
			   destination =sc.nextLine();
			   System.out.println("Enter your Name : ");
			   name=sc.nextLine();
               System.out.println("Enter Date : format ex - (2005-11-28) : ");
               String dateInput=sc.nextLine();
               date=LocalDate.parse(dateInput);
               System.out.println("Enter budget : ");
               budget=sc.nextDouble();
               
               // Set journal details
               journal.setId(id);
               journal.setDestination(destination);
               journal.setName(name);
               journal.setDate(date);
               journal.setBudget(budget);
               
               list.add(journal);
               
               // Save journal into database
               daoImplimentation.saveJournal(journal);
               
               System.out.println();
               break;
			   
			}
			case 2:
			{
				// Search journal by ID
				System.out.println("Enter Id for searching : ");
				id = sc.nextInt();
				sc.nextLine();
				
				TravelJournal t_Journal = daoImplimentation.getJounalById(id);
				
					if(t_Journal != null && t_Journal.getId() == id) {
						System.out.println("Your searching ID found.");
						System.out.println("Waiting for result...");
						journal = daoImplimentation.getJounalById(id);
						System.out.println(journal);
						
						System.out.println();
						break;
					}
					
					System.out.println("Please enter a correct ID.");
				
				System.out.println();
				break;
			}
			case 3:
			{
				// Update journal details
				while(true) {
					
					System.out.println("What you want to update : ");
					System.out.println("1 for Name Update : ");
					System.out.println("2 for Destination Update : ");
					System.out.println("3 for Date Update : ");
					System.out.println("4 for Budget Update : ");
					System.out.println("5 for Exit : ");
					System.out.println("Enter your choice : ");
					
					input =sc.nextInt();
					sc.nextLine();
					id=0;
					
					if(input != 5) {
						System.out.println("Enter Id for update : ");
						id=sc.nextInt();
						sc.nextLine();
					}
					
					switch(input) {
					case 1 :
					{
						// Update traveler name
						TravelJournal t_Journal = daoImplimentation.getJounalById(id);
						
							if(t_Journal != null && t_Journal.getId() == id) {
								System.out.println("Enter Update Name : ");
								name =sc.nextLine();
								t_Journal.setName(name);
								daoImplimentation.updateJournal(t_Journal);
								
								System.out.println();
								break;
							}
							
							System.out.println("Enter valid ID.");
						
						System.out.println();
						break;
					}
					case 2 :
					{
						// Update destination
						TravelJournal t_Journal = daoImplimentation.getJounalById(id);
						
						if(t_Journal != null && t_Journal.getId() == id) {
							System.out.println("Enter Update Destination : ");
							destination =sc.nextLine();
							t_Journal.setDestination(destination);
							daoImplimentation.updateJournal(t_Journal);
								
							System.out.println();
							break;
						}
							
						System.out.println("Enter valid ID.");
						
						System.out.println();
						break;
					}
					case 3 :
					{
						// Update travel date
						TravelJournal t_Journal = daoImplimentation.getJounalById(id);
			               
						if(t_Journal != null && t_Journal.getId() == id) {
							System.out.println("Enter Update Date : format ex - (2005-11-28) : ");
							String dateInput=sc.nextLine();
							date=LocalDate.parse(dateInput);
				               
							t_Journal.setDate(date);
							daoImplimentation.updateJournal(t_Journal);
								
							System.out.println();
							break;
						}
							
						System.out.println("Enter valid ID.");
						
						System.out.println();
						break;
					}
					case 4 :
					{
						// Update travel budget
						TravelJournal t_Journal = daoImplimentation.getJounalById(id);
						
						if(t_Journal != null && t_Journal.getId() == id) {
							System.out.println("Enter Update Budget : ");
							budget =sc.nextDouble();
							sc.nextLine();
							
							t_Journal.setBudget(budget);
							daoImplimentation.updateJournal(t_Journal);
								
							System.out.println();
							break;
						}
							
						System.out.println("Enter valid ID.");
						
						System.out.println();
						break;
					}
					case 5:
					{
						System.out.println("Update menu exited successfully.");
						break;
					}
					
					default : System.out.println("Please enter a valid choice.");
					}
					
					if(input == 5) {
						break;
					}
				}
				
				break;
			}
			
			case 4:
			{
				// Fetch all journal records
				List<TravelJournal>journals = 
						daoImplimentation.getAllJournals();
				
				for(TravelJournal getJournal : journals) {
					System.out.println(getJournal);
				}
				
				System.out.println();
				break;
			}
			
			case 5:
			{
				// Delete journal by ID
				System.out.println("Enter ID for Delete : ");
				id=sc.nextInt();
				sc.nextLine();
				daoImplimentation.deleteJournal(id);
				
				System.out.println();
				break;
			}
			
			case 6:
			{
				System.out.println("Application exited successfully.");
				System.exit(0);
			}
			
			default : System.out.println("Please choose a correct option.");
			}
		}
	}
}