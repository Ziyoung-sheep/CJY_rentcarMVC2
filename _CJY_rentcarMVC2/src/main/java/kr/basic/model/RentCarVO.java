package kr.basic.model;

public class RentCarVO {
	
	private int num;
	private String name;
	private int category;
	private int price;
	private int usepeople; //승차인원
	private int total_qty; //차량 총 수량
	private String company; //차량 회사
	private String img; //차량 이미지
	private String info; //차량 정보
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCategory() {
		return category;
	}
	
	public void setCategory(int category) {
		this.category = category;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getUsepeople() {
		return usepeople;
	}
	
	public void setUsepeople(int usepeople) {
		this.usepeople = usepeople;
	}
	
	public int getTotal_qty() {
		return total_qty;
	}
	
	public void setTotal_qty(int total_qty) {
		this.total_qty = total_qty;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setConmpany(String company) {
		this.company = company;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}

	public RentCarVO(int num, String name, int category, int price, int usepeople, int total_qty, String company,
			String img, String info) {
		super();
		this.num = num;
		this.name = name;
		this.category = category;
		this.price = price;
		this.usepeople = usepeople;
		this.total_qty = total_qty;
		this.company = company;
		this.img = img;
		this.info = info;
	}
	
	public RentCarVO(String name, int category, int price, int usepeople, int total_qty, String company,
			String img, String info) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.usepeople = usepeople;
		this.total_qty = total_qty;
		this.company = company;
		this.img = img;
		this.info = info;
	}

}
