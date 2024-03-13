package Trader;

public class Trader {
	private int trader_num;
	private String trader_id;
	private String pwd;
	private int cash;
	private int total;
	private String account_number;
	private String bank_name;
	private String list;
	private int profit;
	private int authority;
	
	public Trader() {
		
	}

	public Trader(int trader_num, String trader_id, String pwd, int cash, int total, String account_number,
			String bank_name, String list, int profit, int authority) {
		super();
		this.trader_num = trader_num;
		this.trader_id = trader_id;
		this.pwd = pwd;
		this.cash = cash;
		this.total = total;
		this.account_number = account_number;
		this.bank_name = bank_name;
		this.list = list;
		this.profit = profit;
		this.authority = authority;
	}

	public int getTrader_num() {
		return trader_num;
	}

	public void setTrader_num(int trader_num) {
		this.trader_num = trader_num;
	}

	public String getTrader_id() {
		return trader_id;
	}

	public void setTrader_id(String trader_id) {
		this.trader_id = trader_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Trader [trader_num=" + trader_num + ", trader_id=" + trader_id + ", pwd=" + pwd + ", cash=" + cash
				+ ", total=" + total + ", account_number=" + account_number + ", bank_name=" + bank_name + ", list="
				+ list + ", profit=" + profit + ", authority=" + authority + "]";
	}
	
}
