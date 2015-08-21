package net.shakaihatsu.devforum.solution.case1;

public class Task {
	private Status status;
		
	public Task(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [status=" + status + "]";
	}
}
