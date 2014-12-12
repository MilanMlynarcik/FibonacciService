package ie.gmit;

public class FibonacciRequest {
	
	private int jobNumber;
	private int max;
	
	
	public FibonacciRequest(int jobNumber, int max) {
		super();
		this.jobNumber = jobNumber;
		this.max = max;
	}
	
	

	public int getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(int jobNumber) {
		this.jobNumber = jobNumber;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
}
