package movie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main_Frame extends JFrame implements MouseListener{
	Main_FirstScreen mfs; //메인화면1 아무것도 없는 화면
	Main_MenuBtn mmb; //메인화면 2 메뉴 선택창
	
	Reservation_InPutNum rpn; //예매번호 넣는 창
	Reservation_Ticket rt; //예약한 티켓 보는 창
	PrintedYourTicket pyt; //프린트 완료 창
	
	Purchase_MovieChoice pmc; //현장구매 영화 선택하는 창
	Purchase_ChooseMovieAndTime pcmat; //현장구매 인원,시간,좌석 선택하는 창
	Purchase_Ticket pt; //구매한 티켓
	Purchase_TicketPrice ptp; //결제창
	Purchase_TicketPriceDialog1 ptpd; //카드 로딩
	Purchase_PointGuide ppg; //포인트 적립 하시겠습니까?
	
	ParkingMain pm; //주차하시겠습니까? 질문창, 나머지는 다이얼로그 처리
	
	Cafeteria_PopUpToGoToCafeteria cptgtc; //매점 이용하라는 푸시창
	Cafeteria_CafeteriaMain ccm; //매점
	
	Point_Guide pg; //결제 선택 후 포인트 적립할래?
	Point_InputNum pin; //포인트 번호 입력창 
	MembershipPointCheck_InputNum mpc; //포인트 내역 조회 번호 입력창
	MembershipPoint mbsp; //포인트 내역
	
	
	/**포인트 변수*/
	private boolean whichOne; //매점인지, 티켓 구매인지 확인
	private int howMuch; //원금 받아오기
	
	public Main_Frame(){ //생성자
		this.setSize(700,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		mfs = new Main_FirstScreen(this);
		mfs.addMouseListener(this);
		this.add(mfs);
		
		this.setVisible(true);
	}
	void firstMenuToNext(int i){ //첫 버튼 화면에서 해당 버튼 페이지로 (완료) //포인트
		this.remove(mmb);
		if (i == 1){ //Reservation_InPutNum로
			rpn = new Reservation_InPutNum(this);
			this.add(rpn);
		} else if (i == 2){ //Purchase_MovieChoice로
			pmc = new Purchase_MovieChoice(this);
			this.add(pmc);
		} else if (i == 3){ //Cafeteria_CafeteriaMain로
			ccm = new Cafeteria_CafeteriaMain(this);
			this.add(ccm);
		} else if (i == 4){ //MembershipPoint로
			mpc = new MembershipPointCheck_InputNum(this);
			this.add(mpc);
		}
		this.repaint();
		this.revalidate();
	}
	void reservationNumToNext(int i){ //예약 번호 입력 화면 (완료)
		if (i == 1){ //뒤로가기
			this.remove(rpn);
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		} else if(i ==2){ //예약번호 맞음
			this.remove(rpn);
			String[] s = {"내가 죽던 날","1명","일반","","","2관","12:50","C열","C3"};
			// 0 영화 제목, 1 일반, 2 일반 인원, 3 청소년, 4 청소년 인원,
			// 5 관, 6 시간, 7 열, 8 좌석번호
			rt = new Reservation_Ticket(this, s);
			this.add(rt);
		}
		this.repaint();
		this.revalidate();
		
	}
	void reservation_TicketToNext(int i){//예약 티켓 화면  (완료)
		this.remove(rt); //결제 화면으로
		if (i == 1){
			pyt = new PrintedYourTicket(this);
			this.add(pyt);
		} else if(i == 2){
			rpn = new Reservation_InPutNum(this);
			this.add(rpn);
		}
		this.repaint();
		this.revalidate();
	}
	void printedYourTicketToNext(){ //티켓 출력 후 주차등록 창으로 (완료)
		this.remove(pyt);
		pm = new ParkingMain(this);
		this.add(pm);
		this.repaint();
		this.revalidate();
	}
	void parkingMainToNext(){ //주차하시겠습니까?~다이얼로그 (완료)
		//주차를 하지 않을 때 매점 팝업 화면으로
		//주차를 끝내고 매점 팝업 화면으로 // 무조건 매점 화면으로
		this.remove(pm);
		cptgtc =  new Cafeteria_PopUpToGoToCafeteria(this);
		this.add(cptgtc);
		this.repaint();
		this.revalidate();
	}
	void cafeteria_PopUpToGoToCafeteriaToNext(int i){ //매점 이용 홍보 창(완료)
		this.remove(cptgtc);
		if (i==1){ // 홈1화면으로
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		} else if(i ==2){ //매점 화면으로
			ccm = new Cafeteria_CafeteriaMain(this);
			this.add(ccm);
		}
		this.repaint();
		this.revalidate();
	}
	void cafeteria_CafeteriaMainToNext(int i, boolean b, int j){ //매점(완료)
		this.remove(ccm);
		if (i == 1){ //결제 화면 창으로
			whichOne = b;
			howMuch = j;
			pg = new Point_Guide(this);
			this.add(pg);
		} else if(i == 2){//홈화면으로
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		}
		this.repaint();
		this.revalidate();
	}
	void purchase_MovieChoiceToNext(int i){ //현장 구매 영화 선택 화면 (임시완성, 티켓 화면 수정 예정)
		this.remove(pmc);
		if (i == 1){ //도굴
			pcmat = new Purchase_ChooseMovieAndTime(this, 1);
			this.add(pcmat);
		} else if (i == 2){  //삼진그룹영어토익반
			pcmat = new Purchase_ChooseMovieAndTime(this, 2);
			this.add(pcmat);
		} else if (i == 3){//내가 죽던날
			pcmat = new Purchase_ChooseMovieAndTime(this, 3);
			this.add(pcmat);
		} else if (i == 4){  //메인으로
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		}
		this.repaint();
		this.revalidate();
	}
	void purchase_ChooseMovieAndTimeToNext(int i, String[] s){ //영화 인원,시간,좌석 선택(완료)
		this.remove(pcmat);
		if (i == 1){ //뒤로가기, 영화 고르는 화면으로
			pmc = new Purchase_MovieChoice(this);
			this.add(pmc);
		} else if(i ==2){ //확인, 티켓 화면으로
			pt = new Purchase_Ticket(this,s);
			this.add(pt);
		}
		this.repaint();
		this.revalidate();
	}
	void purchase_TicketToNext(int i, String[] s){ //티켓창에서 영화 선택이나 결제창으로(완료)
		this.remove(pt);
		if(i == 1){ //프린트 화면으로
			ptp = new Purchase_TicketPrice(this, s);
			this.add(ptp);
		} else if(i==2){ //이전 화면으로
			pmc = new Purchase_MovieChoice(this);
			this.add(pmc);
		}
		this.repaint();
		this.revalidate();
	}
	void purchase_TicketPriceToNext(int i, boolean b, int j){ //티켓 결제 선택창에서 영화 선택이나 결제창으로(완료)
		
		if (i ==1){ //결제하기
			JFrame f = new JFrame();
	        ptpd = new Purchase_TicketPriceDialog1(f);
	        Timer timer = new Timer(2000, new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	ptpd.setVisible(false);
	            	ptpd.dispose();
	            }
	        });
	        timer.setRepeats(false);
	        timer.start();
	        ptpd.setVisible(true); 
	        
	        whichOne = b; //PointInputNum 값 보내기 
	        howMuch = j;
	        
	        this.remove(ptp);
	        ppg = new Purchase_PointGuide(this);
	        this.add(ppg);
	        
		}else if(i ==2){ //영화 선택 창으로 //뒤로가기
			this.remove(ptp);
			pmc = new Purchase_MovieChoice(this);
			this.add(pmc);
		}
		
		this.repaint();
		this.revalidate();
	}
	void purchase_PointGuideToNext(int i){ //포인트 적립여부
		this.remove(ppg);
		if(i ==1){//적립창으로
			pin = new Point_InputNum(this, whichOne, howMuch);
			this.add(pin);
		} else if(i==2){ //출력되었습니다 안내, 주차 연결
			pyt = new PrintedYourTicket(this);
			this.add(pyt);
		}
		this.repaint();
		this.revalidate();
	}
	void membershipPointCheck_InputNumToNext(int i){ //메인 > 포인트 번호 입력 창!! > 포인트 조회창으로 (완료)
		this.remove(mpc);
		if(i == 1){
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		}else if(i ==2){
			mbsp = new MembershipPoint(this);
			this.add(mbsp);
		}
		this.repaint();
		this.revalidate();
	}
	void membershipPointToNext(){ //멤버십 포인트 조회 화면에서 홈으로 (완료)
		this.remove(mbsp);
		mmb = new Main_MenuBtn(this);
		this.add(mmb);
		this.repaint();
		this.revalidate();
	}
	void point_InputNumToNext(int i){ //포인트 입력하는 화면 (완료)
		this.remove(pin);
		if(i ==1 ) {
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		} else {
			pm = new ParkingMain(this);
			this.add(pm);
		}
		this.repaint();
		this.revalidate();
	}
	void point_GuideToNext(int i){ //결제수단 선택 후 결제되고 포인트 적립여부 묻는 화면 (완료)
		this.remove(pg);
		if (i == 1){//뒤로가기 //결제화면
			ccm = new Cafeteria_CafeteriaMain(this);
			this.add(ccm);
		} else if(i==2){//포인트 적립 화면으로 가기
			pin = new Point_InputNum(this, whichOne, howMuch);
			this.add(pin);
		} else if(i==3){//첫 화면으로 돌아간다
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		}
		this.repaint();
		this.revalidate();
	}
	@Override
	public void mouseClicked(MouseEvent e) { //첫 화면 마우스 (완료)
		this.remove(mfs);
		mmb = new Main_MenuBtn(this);
		this.add(mmb);
		this.repaint();
		this.revalidate();
	}
	public static void main(String[] args) { //메인
		new Main_Frame();
	}
	//안쓰는 이벤트
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

}
