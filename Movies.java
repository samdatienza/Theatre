package project_1;

import java.util.Date;

public class Movies {
	
	// Data fields
	private Date releaseDate;
	private String name;
	private String desc;
	private Date receivedDate;
	private enum Status {
		RECEIVED, RELEASED;
	}
	private Status status;
	
	// Constructors
	public Movies() {}
	
	public Movies(Date releaseDate, String name, String desc, Date receivedDate, Status status) {
		this.releaseDate = releaseDate;
		this.name = name;
		this.desc = desc;
		this.receivedDate = receivedDate;
		this.status = status;
	}
	
	// Methods
	public Date getReleaseDate() { return releaseDate; }
	public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getDescription() { return desc; }
	public void setDescription(String desc) { this.desc = desc; }
	
	public Date getReceivedDate() { return receivedDate; }
	public void setReceivedDate(Date receivedDate) { this.receivedDate = receivedDate; }
	
	public Status getStatus() { return status; }
	public void setStatus(Status status) { this.status = status; }
	
	@Override
	public String toString() {
		return name + ", " + releaseDate + ", " + desc + ", " + receivedDate + ", " + status;
	}
}
