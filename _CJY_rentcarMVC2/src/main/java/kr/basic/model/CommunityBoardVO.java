package kr.basic.model;

public class CommunityBoardVO {
	
	private int num_commuboard;
	private String userid;
	private String title;
	private String main;
	private String img;
	
	
	public int getNum_commuboard() {
		return num_commuboard;
	}
	public void setNum_commuboard(int num_commuboard) {
		this.num_commuboard = num_commuboard;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public CommunityBoardVO() {}
	
	public CommunityBoardVO(int num_commuboard, String userid, String title, String main, String img) {
		super();
		this.num_commuboard = num_commuboard;
		this.userid = userid;
		this.title = title;
		this.main = main;
		this.img = img;
	}
	
	public CommunityBoardVO(String userid, String title, String main, String img) {
		super();
		this.userid = userid;
		this.title = title;
		this.main = main;
		this.img = img;
	}

}
