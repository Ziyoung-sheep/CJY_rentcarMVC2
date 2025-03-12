package kr.basic.model;

public class ReservationVO {
	
	private int reserve_seq; //예약번호
	private int num; //차량 넘버
	private String userid; //유저 아이디
	private int qty; //빌린 대수
	private int dday; //대여일
	private String rday; //빌린 날짜
	private int usein; //보험 적용 여부
	private int usewifi; //wifi 적용 여부
	private int usenavi; //네비게이션 적용 여부
	private int useseat; //베이비시트 적용 여부
	
    public ReservationVO() {
    }
    

	
	public int getReserve_seq() {
		return reserve_seq;
	}
	public void setReserve_seq(int reserve_seq) {
		this.reserve_seq = reserve_seq;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getDday() {
		return dday;
	}
	public void setDday(int dday) {
		this.dday = dday;
	}
	public String getRday() {
		return rday;
	}
	public void setRday(String rday) {
		this.rday = rday;
	}
	public int getUsein() {
		return usein;
	}
	public void setUsein(int usein) {
		this.usein = usein;
	}
	public int getUsewifi() {
		return usewifi;
	}
	public void setUsewifi(int usewifi) {
		this.usewifi = usewifi;
	}
	public int getUsenavi() {
		return usenavi;
	}
	public void setUsenavi(int usenavi) {
		this.usenavi = usenavi;
	}
	public int getUseseat() {
		return useseat;
	}
	public void setUseseat(int useseat) {
		this.useseat = useseat;
	}
	
	
	public ReservationVO(int reserve_seq, int num, String userid, int qty, int dday, String rday, int usein,
			int usewifi, int usenavi, int useseat) {
		super();
		this.reserve_seq = reserve_seq;
		this.num = num;
		this.userid = userid;
		this.qty = qty;
		this.dday = dday;
		this.rday = rday;
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
	}

	public ReservationVO(int num, String userid, int qty, int dday, String rday, int usein, int usewifi, int usenavi,
			int useseat) {
		super();
		this.num = num;
		this.userid = userid;
		this.qty = qty;
		this.dday = dday;
		this.rday = rday;
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
	}
	
}
