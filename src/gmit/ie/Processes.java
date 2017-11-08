package gmit.ie;

import java.util.*;

public class Process {
	private String processName; 
    private int burst, waitTime, currentTime, remainingTime, numCycles;

    public Process(String processName, int burst, int currentTime, int waitTime) {
        this.processName = processName;
        this.burst = burst;
        this.currentTime = currentTime;
        this.waitTime = waitTime;
        this.remainingTime = 0;        
        this.numCycles = 0;
    }//FCFS

    public boolean isAlive(){
        return remainingTime > 0;
    }

    public int getRemainingTime(){
        return remainingTime;
    }
    
	public int getNumCycles(){
        return numCycles;
    }

    public void wait(int time){
        numCycles++;
        remainingTime -= time;
    }    
    
    public String getPocessName() {
        return processName;
    } 

    public void setProcessName(String processName) {
		this.processName = processName;
	}

	public int getBurst() {
        return burst;
    }

	public void setBurst(int burst) {
		this.burst = burst;
		this.remainingTime = burst;
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

    public void display()
    {

        System.out.printf("%d \t%d \t%d \t\t%d\n", processName, burst, currentTime, waitTime);

    }//display

	@Override
	public String toString() {
		return "Process [processName=" + processName + ", burst=" + burst + ", waitTime=" + waitTime + ", currentTime="
				+ currentTime + ", remainingTime=" + remainingTime + "]";
	}

	public static class burstComparator implements Comparator<Process> {

		public int compare(Process p1, Process p2){
			int burstTime1 = p1.getBurst();
			int burstTime2 = p2.getBurst();
			
			if (burstTime1 == burstTime2)
				return 0;
			else if (burstTime1 > burstTime2)
				return 1;
			else
				return -1;
			}

	}
    
    

}//FCFS
