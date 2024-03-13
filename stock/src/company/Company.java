package company;

import java.util.Date;

public class Company {
	private String ceo_name;
	private int company_id;
	private String company_name;
	private Date foundation_date;
	private int holding;
	private String infomation;
	private int stock_id;
	private int volume;
	public String getCeo_name() {
		return ceo_name;
	}
	public void setCeo_name(String ceo_name) {
		this.ceo_name = ceo_name;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public Date getFoundation_date() {
		return foundation_date;
	}
	public void setFoundation_date(Date foundation_date) {
		this.foundation_date = foundation_date;
	}
	public int getHolding() {
		return holding;
	}
	public void setHolding(int holding) {
		this.holding = holding;
	}
	public String getInfomation() {
		return infomation;
	}
	public void setInfomation(String infomation) {
		this.infomation = infomation;
	}
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Company(int company_id, int stock_id, String company_name,String ceo_name,   Date foundation_date, int holding,
			 int volume,String infomation) {
		super();
		this.ceo_name = ceo_name;
		this.company_id = company_id;
		this.company_name = company_name;
		this.foundation_date = foundation_date;
		this.holding = holding;
		this.infomation = infomation;
		this.stock_id = stock_id;
		this.volume = volume;
	}
	@Override
	public String toString() {
		return "Company [ceo_name=" + ceo_name + ", company_id=" + company_id + ", company_name=" + company_name
				+ ", foundation_date=" + foundation_date + ", holding=" + holding + ", infomation=" + infomation
				+ ", stock_id=" + stock_id + ", volume=" + volume + "]";
	}
	public Company() {
	}
	
}
