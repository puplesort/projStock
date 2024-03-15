package stock;

import java.util.Scanner;

import board.BoardService;
import trader.TraderService;

public class Menu {
	private TraderService tservice;
	private BoardService bservice;
	
	public Menu() {
		tservice = new TraderService();
		bservice = new BoardService();
	}
	
	public void run(Scanner sc) {
		while(true) {
			System.out.print("계속하려면 아무 번호나 눌러주세요 (종료는 0) : ");
			
			int m = sc.nextInt();
			if(m == 0) {
				break;
			}
			
			// 제일 먼저 계좌 개설을 하는 단계를 거쳐야함
			// 어떤 사람이든 계좌를 개설해야 회원가입을 하는 상황에서 계좌번호와 은행명을 입력할 수 있음
			// account, trader 테이블 수정
			// board 테이블 회사이름 컬럼 추가 후 company랑 비교해서 참조할지 말지 결정
			
			if(TraderService.loginId == null) {
				runTraderLogout(sc);
			} else {
				if(TraderService.authority == 1) {
					runMasterLogin(sc);
				} else {
					runTraderLogin(sc);
				}
			}
		}
	}
	
	// 로그인 X
	public void runTraderLogout(Scanner sc) {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1.계좌개설 2.로그인 3.회원가입 4.종료");
			System.out.print("선택 : ");
			int m = sc.nextInt();
			
			switch(m) {
			case 1:
				// 계좌개설
				break;
			case 2:
				flag = !tservice.login(sc);
				break;
			case 3: 
				tservice.addTrader(sc);
				break;
			case 4:
				flag = false;
				break;
			}
		}
	}
	
	// 로그인 -> 회원 메뉴(authority = 0)
	public void runTraderLogin(Scanner sc) {
		
		// 알림 추기 위치 -> 로그인 했을 때 모든 주식 상승률/하락률 출력
		
		boolean flag = true;
		while(flag) {
			//System.out.println("1.내정보 확인(보유 주식/자산) 2.내정보 수정 3.매도 4.매수 5.로그아웃 6.탈퇴 7.게시판");
			System.out.println("1.내정보 확인(보유 주식/자산) 2.내정보 수정 3.매도 4.매수 5.게시판 6.로그아웃 7.탈퇴");
			// 내정보 확인 메뉴 -> 보유 주식 목록, 보유 자산, 내계좌 조회
			System.out.print(": ");
			int m = sc.nextInt();
			
			switch(m) {
			case 1:
				tservice.printTrader(sc);
				break;
			case 2:
				tservice.editPwdTrader(sc);
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				runBoard(sc);
				break;
			case 6:
				tservice.logout();
				return;
			case 7:
				tservice.delTrader();
				break;			
			}
		}
	}
	
	// 로그인 -> 관리자 메뉴(authority = 1)
	public void runMasterLogin(Scanner sc) {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1.회사관리 2.모든 회원정보열람 3.게시글 관리 4.로그아웃");
			// 회사 관리 -> 1.회사등록(주식 자동생성) 2.회사삭제(주식 자동삭제) 3.회사수정(회사 정보수정)
			// (완료)게시글 관리 -> 1.게시글 목록 2.게시글 제목으로 검색(수정, 삭제) 3.상세페이지 종료
			System.out.print(": ");
			int m = sc.nextInt();
			
			switch(m) {
			case 1:
				System.out.println("회사관리 준비중");
				//runTrade(sc);
				break;
			case 2:
				tservice.printAll();
				break;
			case 3:
				runMasterBoard(sc);
				break;
			case 4:
				tservice.logout();
				return;
			}
		}
	}
	
	// 게시판 메뉴 - 회원
	public void runBoard(Scanner sc) {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1.게시물 작성 2.ID로 검색 3.제목으로 검색 4. 회사명으로 검색 5.전체목록 6.게시판 종료");
			System.out.print(": ");
			int m = sc.nextInt();
			
			switch(m) {
			case 1:
				bservice.addBoard(sc);
				break;
			case 2:
				bservice.getByWriter(sc);
				break;
			case 3:
				bservice.getByTitle(sc);
			case 4:
				bservice.getByCompanyName(sc);
				break;
			case 5:
				bservice.getAll();
				break;
			case 6:
				flag = false;
				break;
			}
		}
	}
	
	// 게시글 관리 - 관리자용 
	public void runMasterBoard(Scanner sc) {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1.게시글 목록 2.게시글 검색(ID) 3.게시글 관리 종료");
			System.out.print(": ");
			int m = sc.nextInt();
			
			switch(m) {
			case 1:
				bservice.getAll();
				break;
			case 2:
				bservice.getByTitle(sc);
				break;
			case 3:
				flag = false;
				break;
			}
		}
	}
}
