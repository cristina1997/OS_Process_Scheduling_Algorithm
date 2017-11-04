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
		double average; //calculations
		
		//Initialize to send currentTime and waitTime a value of 0 to the FCFS class
		waitTime = currentTime = 0;
		
		//Asks user to input the amount of processes wished to be executed 
		System.out.println("Please enter the amount of processes ");
		processNo = userInput.nextInt(); 
		
		FCFS_and_SJF[] fcfs = new FCFS_and_SJF[processNo]; //creates an array for FCFS AND SJF giving it the no. of processes
		//RR[] roundR = new RR[processNo]; //creates an array for RR giving it the no. of processes
		
		while (i != processNo) {
			
			//Asks user to input the process name and burst time
			System.out.println("Enter process number");
			input = userInput.nextInt();		
			System.out.println("Enter burst time");  
			burst = userInput.nextInt();
			
			fcfs[i] = new FCFS_and_SJF(input, burst, currentTime, waitTime);					
			//roundR[i] = new RR(input, burst, waitTime);			
			i++;
		}	
		
		do {
			
			//Input the choice from the user as chosen below
			System.out.println("\tPlease enter one of the 4 options below.");
			System.out.println("Enter your input number");  
			System.out.println("Press 1 for round robin");  
			System.out.println("Press 2 for FCFS");  
			System.out.println("Press 3 for SJF");  
			System.out.println("Press 4 to exit");  
			choice = userInput.nextInt(); 
			
			switch(choice){
			
			//Round Robin
			case 1:				
				//System.out.println("Enter quantum");  
				//quantum = userInput.nextInt();
				choice = 4;
				break;	
				
			//First Come First Served
			case 2:								
				fcfs[0].setWaitTime(waitTime); //make the first element in the array equal to waitTime (which is 0)
				
				//Loop through the array until i reaches the no. of elements in the list chosen by the user (processNo)
				for (i = 0; i < processNo; i++) {
					
					waitTime = calculateWaitTime(waitTime, i, fcfs); //make wait time equal to the new wait time calculated in the function below				
				}//for
				
				average = average(processNo, i, fcfs); //calculate the wait time average in the average() function below
				displayMethod(processNo, fcfs);	//display the output of whichever case the user chooses (fcfs in this case)
				System.out.printf("\n\tWait Time Average is %.2f\n", average);	//display the average wait time calculated above using average() function			
				choice = 4; //make choice = to 4 to exit the switch case as well as the while loop
				break;
				
			//Shortest Job First
			case 3:			
				
				fcfs[0].setWaitTime(waitTime); //make the first element in the array equal to waitTime (which is 0)		
				for (i = 0; i < processNo; i++){
					Arrays.sort(fcfs); //sort the fcfs array using the toCompare method from the FCFS class
					waitTime = calculateWaitTime(waitTime, i, fcfs); //make wait time equal to the new wait time calculated in the function below
					
				}//for
				
				average = average(processNo, i, fcfs); //calculate the wait time average in the average() function below
				displayMethod(processNo, fcfs);	//display the output of whichever case the user chooses (fcfs in this case)
				System.out.printf("\n\tWait Time Average is %.2f\n", average);	//display the average wait time calculated above using average() function			
				choice = 4; //make choice = to 4 to exit the switch case as well as the while loop
				break;
			case 4:
				break;	
			default:
				System.out.println("\tPlease enter one of the 4 options below."); //if the user enters any no. other than 1, 2, 3 or 4 (mentioned above) it continues the switch statement until the user enters a choice available in the switch statemend
				continue;
			}//switch
			
		} while (choice != 4);	
		
	}//main

	public static int calculateWaitTime(int wait, int i, FCFS_and_SJF[] fcfs) {
		
		//As long as i is not 0 execute the if statement
		if (i != 0) {
			wait += fcfs[i-1].getBurst(); //the next wait becomes the previous burst
			fcfs[i].setWaitTime(wait); //waitTime is set to the wait value
			fcfs[i].setCurrentTime(wait); //currentTime is set to the wait value
		}
		
		return fcfs[i].getWaitTime(); //waitTime is returned to be used again
	}//calculateWaitTime
	
	public static void displayMethod(int processCount, FCFS_and_SJF[] fcfs) {
		//Heading for Name Burst Start Time and Wait Time
		System.out.println("Name	Burst	Start Time	Wait Time");
		
		//Loops through until i is smaller than the no. of processes (processCount)
		for (int i = 0; i < processCount; i++) {			
			fcfs[i].display(); //calls the display() function from the FCFS class
		}
	}//displayMethod
	
	public static double average(int processCount, int i, FCFS_and_SJF[] fcfs) {
		//Variables
		double total, avg;
		
		//Initialize
		total = avg = 0;
		
		//Loops through until i is smaller than the no. of processes (processCount)
		for (i = 0; i < processCount; i++) 
			total += fcfs[i].getWaitTime();	//it gets the wait time total
		avg = total / processCount; //it calculates the wait time average
				
		return avg; //average is returned and displayed in the main method
	}//average

}//Runner
