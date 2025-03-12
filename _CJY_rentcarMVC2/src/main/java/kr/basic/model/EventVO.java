package kr.basic.model;

public class EventVO {
	
	private int num_event;
	private String title;
	private String start_date;
	private String end_date;
	private String event_img;
	public int getNum_event() {
		return num_event;
	}
	public void setNum_event(int num_event) {
		this.num_event = num_event;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getEvent_img() {
		return event_img;
	}
	public void setEvent_img(String event_img) {
		this.event_img = event_img;
	}
	
	public EventVO() {}
	
	public EventVO(String title, String start_date, String end_date, String event_img) {
		super();
		this.title = title;
		this.start_date = start_date;
		this.end_date = end_date;
		this.event_img = event_img;
	}
	public EventVO(int num_event, String title, String start_date, String end_date, String event_img) {
		super();
		this.num_event = num_event;
		this.title = title;
		this.start_date = start_date;
		this.end_date = end_date;
		this.event_img = event_img;
	}
	
	

}
