package gmit.ie;

public class FCFS implements Comparable<FCFS>{		
	//Variables
	private int input, burst, waitTime, currentTime;
	private int sortResult;

	//Constructor with parameters
	public FCFS(int input, int burst, int currentTime, int waitTime) {
		super();
		this.input = input;
		this.burst = burst;
		this.currentTime = currentTime;
		this.waitTime = waitTime;
	}//FCFS

	//Getters and Setters
	public int getInput() {
		return input;
	}

	public void setInput(int input) {
		this.input = input;
	}

	public int getBurst() {
		return burst;
	}

	public void setBurst(int burst) {
		this.burst = burst;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	
	public int getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}

	//Display input, burst, start time and wait time
	public void display(){		
		System.out.printf("%d \t%d \t%d \t\t%d\n", input, burst, currentTime, waitTime);
	}//display
	
	@Override
	public int compareTo(FCFS arg) {
		// TODO Auto-generated method stub		
		sortResult = arg.burst;
		
		//ascending order
		return this.burst - sortResult;
				//descending order
				//return sortResult_compare - this.sortResult;
		
	}//compareTo
	
}//FCFS
