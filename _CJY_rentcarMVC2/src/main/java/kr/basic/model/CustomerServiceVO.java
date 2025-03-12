package kr.basic.model;

public class CustomerServiceVO {
	
	private int num_qna;
	private String userid;
	private String title;
	private String main;
	private String answer;
	
	public int getNum_qna() {
		return num_qna;
	}
	public void setNum_qna(int num_qna) {
		this.num_qna = num_qna;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public CustomerServiceVO(int num_qna, String userid, String title, String main, String answer) {
		super();
		this.num_qna = num_qna;
		this.userid = userid;
		this.title = title;
		this.main = main;
		this.answer = answer;
	}
	public CustomerServiceVO(String userid, String title, String main, String answer) {
		super();
		this.userid = userid;
		this.title = title;
		this.main = main;
		this.answer = answer;
	}
	
	public CustomerServiceVO(String userid, String title, String main) {
		super();
		this.userid = userid;
		this.title = title;
		this.main = main;
		this.answer = answer;
	}
	public CustomerServiceVO() {}
	
	
	


}
