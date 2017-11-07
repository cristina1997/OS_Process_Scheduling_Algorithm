package gmit.ie;

public class RoundRobin {
	private int input, burst, waitTime, currentTime;
	private int quant, remainTime;
	
	public RoundRobin(int input, int burst, int currentTime, int waitTime, int quant, int remainTime) {
		super();
		this.input = input;
		this.burst = burst;
		this.currentTime = currentTime;
		this.waitTime = waitTime;
		this.quant = quant;
		this.remainTime = remainTime;
	}

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

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public int getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(int remainTime) {
		this.remainTime = remainTime;
	}
}
