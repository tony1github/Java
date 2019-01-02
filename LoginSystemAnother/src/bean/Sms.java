package bean;

public class Sms {

	int id;
	long Call_From;
	long Call_To;
	String Message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCall_From() {
		return Call_From;
	}
	public void setCall_From(long value) {
		Call_From = value;
	}
	public long getCall_To() {
		return Call_To;
	}
	public void setCall_To(long call_To) {
		Call_To = call_To;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public Sms(int id, long call_From, long call_To, String message) {
		super();
		this.id = id;
		Call_From = call_From;
		Call_To = call_To;
		Message = message;
	}
	public Sms() {
		super();
	}
	
	
	
}
