package gmit.ie;
import java.lang.reflect.Array;
import java.util.*;

public class Runner {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		//Variables
		int choice, i = 0; //user choice and iterations
		int input, burst, waitTime, currentTime; //inputs
		int processNo; //counter
		double total, average; //calculations
		String avgBool = "";
		
		//Initialize to sent currentTim and waitTime a value of 0 to the FCFS class
		waitTime = currentTime = 0;
		
		System.out.println("Please enter the amount of processes ");
		processNo = userInput.nextInt();
		FCFS[] fcfs = new FCFS[processNo];
		//RR[] roundR = new RR[processNo];
		
		while (i != processNo) {
			
			System.out.println("Enter process number");
			input = userInput.nextInt();		
			System.out.println("Enter burst time");  
			burst = userInput.nextInt();
			
			fcfs[i] = new FCFS(input, burst, currentTime, waitTime);					
			//roundR[i] = new RR(input, burst, waitTime);			
			i++;
		}	
		
		do {
			
			System.out.println("Enter your input number");  
			System.out.println("Press 1 for round robin");  
			System.out.println("Press 2 for FCFS");  
			System.out.println("Press 3 for SJF");  
			System.out.println("Press 4 to exit");  
			choice = userInput.nextInt(); 
			
			switch(choice){
			case 1:				
				//System.out.println("Enter quantum");  
				//quantum = userInput.nextInt();
				choice = 4;
				break;				
			case 2:								
				fcfs[0].setWaitTime(waitTime);
				for (i = 0; i < processNo; i++) {					
					waitTime = calculateWaitTime(waitTime, i, fcfs);					
				}//for
				
				average = average(processNo, i, fcfs);
				displayMethod(processNo, fcfs);				
				System.out.printf("\n\tWait Time Average is %.2f\n", average);				
				choice = 4;
				break;				
			case 3:			
				
				fcfs[0].setWaitTime(waitTime);				
				for (i = 0; i < processNo; i++){
					Arrays.sort(fcfs);
					waitTime = calculateWaitTime(waitTime, i, fcfs);
					
				}//for
				
				average = average(processNo, i, fcfs);
				displayMethod(processNo, fcfs);
				System.out.printf("\n\tWait Time Average is %.2f\n", average);
				choice = 4;
				break;
			case 4:
				break;				
			}//switch
			
		} while (choice != 4);	
		
	}//main

	public static int calculateWaitTime(int wait, int i, FCFS[] fcfs) {
		if (i != 0) {
			wait += fcfs[i-1].getBurst();
			fcfs[i].setWaitTime(wait);
			fcfs[i].setCurrentTime(wait);			
		}
		
		return fcfs[i].getWaitTime();	
	}//calculateWaitTime
	
	public static void displayMethod(int processCount, FCFS[] fcfs) {
		System.out.println("Name	Burst	StartTime	WaitTime");
		for (int i = 0; i < processCount; i++) {			
			fcfs[i].display();
		}
	}//displayMethod
	
	public static double average(int processCount, int i, FCFS[] fcfs) {
		double total, avg;
		total = avg = 0;
		
		for (i = 0; i < processCount; i++) 
			total += fcfs[i].getWaitTime();		
		avg = total / processCount;
				
		return avg;
	}//average

}//Runner
