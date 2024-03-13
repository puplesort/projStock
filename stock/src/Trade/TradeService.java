package Trade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TradeService {
	private TradeDao dao;
	private int login;

	public TradeService() {
		dao = new TradeDao();
	}

	public void login(int login) {
		this.login = login;
	}

	public void addSell(Scanner sc) {
		System.out.println("---------매도--------");
		System.out.println("매도할 주식의 id를 입력하시오");
		int stockId= sc.nextInt();
		System.out.println("매도할 주식의 양를 입력하시오");
		int sell=sc.nextInt();
		// 보유 주식의 양과 판매할 양 비교 ,, price 주식 테이블에서 가져옴
		int price=0;
		dao.inset(new Trade(0,stockId,sell,0,login,price,new Date(0)));
		System.out.println("매도완료");
	}
	
	public void addBuy(Scanner sc) {
		printByStock(sc);
		System.out.println("---------매수--------");
		System.out.println("매수할 거래의 id를 입력하시오");
		int TradeId=sc.nextInt();
		Trade t=dao.selectById(TradeId);
		System.out.println("매수할 주식의 양를 입력하시오");
		int buy=sc.nextInt();
		// 보유 주식의 양과 판매할 양 비교 ,, price 주식 테이블에서 가져옴
		int price=0;
		dao.inset(new Trade(0,t.getStockId(),0,buy,login,price,new Date(0)));
		t.setSell(t.getSell()-buy);
		dao.update(t);
		System.out.println("매수완료");
	}
	
	public void printByStock(Scanner sc) {
		System.out.println("------주식별 목록-------");
		
		System.out.println("찾을 주식 id를 입력하시오");
		int stockId=sc.nextInt();
		ArrayList<Trade>list=dao.selectByStockId(stockId);
		for(Trade t:list) {
			System.out.println(t);
		}
	}
	public void printAll() {
		System.out.println("---------전체 목록--------");
		dao.selectAll();
	}
	
	public void updatePrice() {
		Random r=new Random();
		 int value = r.nextInt(100 + 0) + 0;
		    System.out.println(value);
	}


}
