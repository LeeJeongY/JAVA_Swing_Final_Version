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

public class Reservation_Ticket extends JPanel implements ActionListener{
	private JLabel title, time, placeOfMovie, seat, cusNum, ageGroup;
				// 0 영화 제목, 1 일반, 2 일반 인원, 3 학생, 4 학생 인원,
				// 5 관, 6 시간, 7 열, 8 좌석번호
	private JButton btnPrint, btnBack;
	
	private Image backgroundImage;
	public Main_Frame mf;
	String[] info ={};
	
	public Reservation_Ticket(Main_Frame mf, String[] s){ //생성자
		this.mf=mf;
		this.info = s;
		/**틀 잡기*/
		this.setSize(700,1000);
		this.setLayout(new BorderLayout());
		
		//배경 화면 입히기
		try {
			backgroundImage = ImageIO.read(new File("예매내역배경.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		buttonsPanel(); //버튼 패널
		contentsPanel();
		changeContents();
		
		
	}
	private void changeContents(){
		title.setText(info[0]);
		time.setText(info[6]);
		placeOfMovie.setText(info[5]);
		seat.setText(info[8]);
		cusNum.setText(info[2]);
		ageGroup.setText(info[1]);
	}
	private void buttonsPanel(){ //버튼 패널
		JPanel pnlBtn = new JPanel(new GridLayout(0,5)); 
		
		ImageIcon imgPrint = new ImageIcon("printer_W.gif");//프린트 아이콘 사이즈 조절
		Image image2 = imgPrint.getImage();
		Image changeImage2 = image2.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImage2);
		
		ImageIcon imgBack = new ImageIcon("BACK_W.gif");//뒤로 가기 아이콘 사이즈 조절
		Image image3 = imgBack.getImage();
		Image changeImage3 = image3.getScaledInstance(70,70, Image.SCALE_SMOOTH);
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

	private void contentsPanel(){ //내용 패널
		/**내용 채우기*/
		JPanel pnlLb = new JPanel(); //레이블 패널
		pnlLb.setLayout(null);
		pnlLb.setBackground(new Color(255, 255, 255, 0));    //투명

		
		JLabel type = new JLabel("2D");
		JLabel age = new JLabel("12세 이상"); //관람 연령
		title = new JLabel("제목"); //제목
		JLabel place = new JLabel("부산 서면,"); //영화관 위치
		JLabel Date = new JLabel("2020-11-25"); //날짜
		time = new JLabel("시간"); //시간 대
		placeOfMovie = new JLabel("상영관 이름(층수)"); // 상영관 이름
		seat = new JLabel("좌석"); //좌석
		cusNum = new JLabel("0명"); //관람인원
		ageGroup = new JLabel("(학생/일반)"); // 어린이/학생/일반
		
		
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
		seat.setBounds(170,415,300,150);
		cusNum.setBounds(170,480,300,150);
		ageGroup.setBounds(220,480,300,150);
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
	
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnPrint){ //출력 화면으로
			mf.reservation_TicketToNext(1);
		}else if(e.getSource() == btnBack){ //뒤로가기
			mf.reservation_TicketToNext(2);
		}
	}
}
