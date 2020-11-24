package movie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Purchase_Ticket extends JPanel implements ActionListener{
	private JLabel title, place, time, placeOfMovie, seat, cusNum, ageGroup;
	private JButton btnPrint, btnBack;
	private Image backgroundImage;
	private JPanel pnlLb;
	private String[] data; //받는 배열
	private String[] dataToPay  = new String[2]; //결제창에 값을 주는 배열
	Main_Frame mf;

	
	public Purchase_Ticket(Main_Frame mf, String data[]){ //생성자
		this.mf = mf;
		this.data = data;
		/**틀 잡기*/
		this.setSize(700,1000);
		this.setLayout(new BorderLayout());
		
		//배경 화면 입히기
		try {
			backgroundImage = ImageIO.read(new File("예매내역배경.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	
		makeButtons(); //버튼 패널
		
		/**내용 채우기*/
		makeTickets(); //티켓만들기
		settingTikcet(data); //티켓 내용 셋팅
		
		
	}
	private void makeButtons(){
		JPanel pnlBtn = new JPanel(new GridLayout(0,5)); //버튼 패널
		
		ImageIcon imgPrint = new ImageIcon("credit-card-w.gif");//프린트 아이콘 사이즈 조절
		Image image2 = imgPrint.getImage();
		Image changeImage2 = image2.getScaledInstance(100,100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImage2);
		
		ImageIcon imgBack = new ImageIcon("BACK_W.gif");//뒤로 가기 아이콘 사이즈 조절
		Image image3 = imgBack.getImage();
		Image changeImage3 = image3.getScaledInstance(100,100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon3 = new ImageIcon(changeImage3);
		
		btnPrint = new JButton(changeIcon2); //버튼 생성, 아이콘 입력
		btnBack = new JButton(changeIcon3);
		btnPrint.addActionListener(this); //액션 리스너 등록
		btnBack.addActionListener(this);
		btnPrint.setBorderPainted(false); //버튼 라인 삭제
		btnBack.setBorderPainted(false);
		btnPrint.setFocusPainted(false); //버튼 클릭 라인 삭제
		btnBack.setFocusPainted(false);
		btnPrint.setContentAreaFilled(false); //버튼 배경 삭제
		btnBack.setContentAreaFilled(false);
		
		pnlBtn.add(new JLabel());
		pnlBtn.add(btnPrint);
		pnlBtn.add(new JLabel());
		pnlBtn.add(btnBack);
		pnlBtn.add(new JLabel());
		pnlBtn.setBackground(new Color(39,38,64));
		this.add(pnlBtn, "South");
	}
	
	private void makeTickets(){
		pnlLb = new JPanel(); //레이블 패널
		pnlLb.setLayout(null);
		pnlLb.setBackground(new Color(255, 255, 255, 0));    //투명

		
		JLabel type = new JLabel("2D");
		JLabel age = new JLabel("12세 이상"); //관람 연령
		title = new JLabel("제목"); //제목
		place = new JLabel("부산 서면,"); //영화관 위치
		JLabel Date = new JLabel("2020-11-25"); //날짜
		time = new JLabel("시간"); //시간 대
		placeOfMovie = new JLabel("상영관 이름(층수)"); // 상영관 이름 & 층수
		seat = new JLabel("좌석"); //좌석
		cusNum = new JLabel("명"); //관람인원
		ageGroup = new JLabel("(학생/성인)"); // 어린이/학생/성인
		
		ImageIcon imageQR = new ImageIcon("qr.png");//qr 버튼 이미지 조정
		Image image4 = imageQR.getImage();
		Image changeImage4 = image4.getScaledInstance(180,180, Image.SCALE_SMOOTH);
		ImageIcon changeIcon4 = new ImageIcon(changeImage4);

		JButton btnQR = new JButton(changeIcon4);
		btnQR.setBorderPainted(false);
		btnQR.setFocusPainted(false);
		btnQR.setContentAreaFilled(false);
		
		type.setForeground(Color.white);
		age.setForeground(Color.white);
		title.setForeground(Color.white);
		place.setForeground(Color.white);
		Date.setForeground(Color.white);
		time.setForeground(Color.white);
		placeOfMovie.setForeground(Color.white);
		seat.setForeground(Color.white);
		cusNum.setForeground(Color.white);
		ageGroup.setForeground(Color.white);
		
		type.setBounds(170,170,100,100);
		age.setBounds(440,170,100,100);
		title.setBounds(170,210,300,150);
		place.setBounds(170,290,300,150);
		Date.setBounds(260,290,300,150);
		time.setBounds(170,325,300,150);
		placeOfMovie.setBounds(170,380,300,150);
		seat.setBounds(160,415,300,150);
		cusNum.setBounds(170,480,300,150);
		ageGroup.setBounds(300,480,300,150);
		btnQR.setBounds(260,590,180,180);
		
		type.setFont(new Font("휴먼편지체", Font.PLAIN,25));
		age.setFont(new Font("휴먼편지체", Font.PLAIN,25));
		title.setFont(new Font("휴먼편지체", Font.PLAIN,35));
		place.setFont(new Font("휴먼편지체", Font.PLAIN,20));
		Date.setFont(new Font("휴먼편지체", Font.PLAIN,20));
		time.setFont(new Font("휴먼편지체", Font.PLAIN,20));
		placeOfMovie.setFont(new Font("휴먼편지체", Font.PLAIN,20));
		seat.setFont(new Font("휴먼편지체", Font.PLAIN,20));
		ageGroup.setFont(new Font("휴먼편지체", Font.PLAIN,20));
		cusNum.setFont(new Font("휴먼편지체", Font.PLAIN,20));
		
		pnlLb.add(type);
		pnlLb.add(age);
		pnlLb.add(title);
		pnlLb.add(place);
		pnlLb.add(Date);
		pnlLb.add(time);
		pnlLb.add(placeOfMovie);
		pnlLb.add(seat);
		pnlLb.add(ageGroup);
		pnlLb.add(cusNum);
		pnlLb.add(btnQR);
		this.add(pnlLb);
	}
	
	void settingTikcet(String[] d){ //티켓에 값 받아오기
		title.setText(data[0]);
		time.setText(data[1]);
		placeOfMovie.setText(data[2]);
		seat.setText(data[3]);
		cusNum.setText("관람인원 "+data[4]+"명");
		ageGroup.setText("일반"+data[5]+", 학생"+data[6]);
		
		dataToPay[0] = data[5];//일반 인원 수
		dataToPay[1] = data[6];//학생 인원 수
	}
	
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnPrint){
			mf.purchase_TicketToNext(1,dataToPay);
		}else if(e.getSource() == btnBack){ //이전 화면으로 돌아가기
			mf.purchase_TicketToNext(2,dataToPay);
		}
	}
	
}
