package movie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class Purchase_ChooseMovieAndTime extends JPanel implements ActionListener{
	private JButton btnBack, btnOk; // 뒤로 가기, 티켓 페이지
	private JButton btnTime1,btnTime2,btnTime3,btnTime4,btnTime5,btnTime6,btnTime7,btnTime8,btnTime9,btnTime10,btnTime11,btnTime12,btnTime13;
	    //3관 16:55   19:15    5관 12:55 15:15    17:35    4관 13:15   15:30   17:45    20:00    2관 12:50   15:10   17:30     19:50
	private JButton btnSeatA1,btnSeatA2, btnSeatA3, btnSeatA4, btnSeatA5, btnSeatA6, btnSeatB1, btnSeatB2, btnSeatB3, btnSeatB4, btnSeatB5,btnSeatB6,btnSeatC1, btnSeatC2, btnSeatC3, btnSeatC4, btnSeatC5, btnSeatC6; 
	private JButton customerok, timeok; //인원수 선택 완료, 시간대 선택 완료, 좌석 완료
	private JButton resetcustomer, resettime1, resettime2, resettime3, resetseat; // 인원수 초기화, 1관/2관/3관 시간대 선택 초기화, 좌석 선택 초기화
	
	private JSpinner spinner1, spinner2;
	private JTabbedPane tp;
	private JPanel pnMid, pnInside2, timePnl,seatPnl;; //탭에 들어가는 패널
	
	/**값 주고 받기*/
	String[] info = new String[9]; // 0 영화 제목, 1 일반, 2 일반 인원, 3 청소년, 4 청소년 인원, 5 관, 6 시간, 7 열, 8 좌석번호
	String[] seatnums = new String[18]; //좌석 번호 값을 담을 배열
	Main_Frame mf;
	//Ticket tk;
	
	int choiceMovie, seatindex; // 버튼 누른 횟수를 seatindex에 저장
	int adult, teenager, customer; // ★ 선택 좌석 수, 일반 인원, 청소년 인원, 일반 + 청소년	
	
	public Purchase_ChooseMovieAndTime(Main_Frame mf, int choiceMovie){ //생성자
		this.mf = mf;
		this.choiceMovie = choiceMovie;
		/**틀 잡기*/
		this.setSize(700,1000);
		this.setLayout(new BorderLayout());
		
		makeUpAndDown();//틀 만드는 메소드
		
		/**중간 화면 채우기*/
		pnMid = new JPanel(new GridLayout(0,1)); 
			
		chooseMov();//영화 고르는 메소드
		
		pnInside2 = new JPanel(); //인원 패널
		pnInside2.setLayout(null);
		choosePeoNum(); //인원 선택하는 메소드
		
		timePnl = new JPanel(null);
		chooseTimeTable(); //시간 고르는 메소드
		
		seatPnl = new JPanel();
		seatPnl.setLayout(null);
		chooseSeat(); //좌석을 고르는 메소드
		
		tp = new JTabbedPane(); 
		tp.add("인원",pnInside2);
		tp.add("상영 시간",timePnl);
		tp.add("좌석",seatPnl);
		
		tp.setEnabledAt(1, false); // 시간 선택 탭 잠금
		tp.setEnabledAt(2, false); // 좌석 선택 탭 잠금
		
		pnMid.add(tp);
		this.add(pnMid, "Center");
	}
	
	private void makeUpAndDown(){ //틀 만드는 메소드
		ImageIcon imgName = new ImageIcon("이름.PNG");
		Image image = imgName.getImage();
		Image changeImage = image.getScaledInstance(700,100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImage);
		JLabel lb1 = new JLabel(changeIcon);
		this.add(lb1,"North");
		//밑에 버튼 넣기
		JPanel pn = new JPanel(new BorderLayout());
		pn.setBackground(new Color(39,38,64));
		
		ImageIcon imgBtn1 = new ImageIcon("BACK_W.gif");
		Image image2 = imgBtn1.getImage();
		Image changeImage2 = image2.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImage2);
		btnBack = new JButton(changeIcon2);
		
		ImageIcon imgBtn2 = new ImageIcon("체크_흰색.gif");
		Image image3 = imgBtn2.getImage();
		Image changeImage3 = image3.getScaledInstance(80,80, Image.SCALE_SMOOTH);
		ImageIcon changeIcon3 = new ImageIcon(changeImage3);
		btnOk = new JButton(changeIcon3);
		
		btnBack.setBorderPainted(false);
		btnOk.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		btnOk.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnOk.setContentAreaFilled(false);
		btnBack.addActionListener(this);
		btnOk.addActionListener(this);
		
		btnOk.setEnabled(false); // 버튼 비활성화
		
		pn.add(btnBack,"West");
		pn.add(btnOk,"East");
		this.add(pn,"South");
		
	}

	private void chooseMov(){ //영화 고르는 메소드
		JPanel pnInside = new JPanel();
		pnInside.setLayout(null);
		
		if (choiceMovie == 1){
			ImageIcon changeIcon2 = new ImageIcon(((new ImageIcon("movie1.jpg")).getImage()).getScaledInstance(180,260, Image.SCALE_SMOOTH));
			JButton btnPic = new JButton(changeIcon2);
			btnPic.setBounds(20,20,180,260);
			btnPic.setBorderPainted(false);
			btnPic.setFocusPainted(false);
			btnPic.setContentAreaFilled(false);
			JLabel lbTitle = new JLabel("도굴");
			lbTitle.setBounds(230,25,200,50);
			lbTitle.setFont(new Font("맑은 고딕", Font.BOLD,25));
			JLabel lbMov1 = new JLabel("115분, 한국");
			lbMov1.setBounds(295,27,200,50);
			lbMov1.setFont(new Font("맑은 고딕", Font.PLAIN,15));
			JLabel lbMov2 = new JLabel("감독 : 박정배 ");
			lbMov2.setBounds(230,85,500,50);
			lbMov2.setFont(new Font("맑은 고딕", Font.PLAIN,20));
			JLabel lbMov3 = new JLabel("배우 : 이제훈, 조우진, 신혜선, 임원희 ");
			lbMov3.setBounds(230,130,500,50);
			lbMov3.setFont(new Font("맑은 고딕", Font.PLAIN,20));
			JLabel lbMov4 = new JLabel("장르 : 범죄 / 기본 : 12세 이상 ");
			lbMov4.setBounds(230,175,500,50);
			lbMov4.setFont(new Font("맑은 고딕", Font.PLAIN,20));
			JLabel lbMov5 = new JLabel("개봉 : 2020.11.04 ");
			lbMov5.setBounds(230,220,500,50);
			lbMov5.setFont(new Font("맑은 고딕", Font.PLAIN,20));
			
			pnInside.add(btnPic);
			pnInside.add(lbTitle);
			pnInside.add(lbMov1);
			pnInside.add(lbMov2);
			pnInside.add(lbMov3);
			pnInside.add(lbMov4);
			pnInside.add(lbMov5);
			
			info[0] = lbTitle.getText();
		} else if(choiceMovie == 2){
			ImageIcon changeIcon2 = new ImageIcon(((new ImageIcon("movie2.jpg")).getImage()).getScaledInstance(180,260, Image.SCALE_SMOOTH));
			JButton btnPic = new JButton(changeIcon2);
			btnPic.setBounds(20,20,180,260);
			btnPic.setBorderPainted(false);
			btnPic.setFocusPainted(false);
			btnPic.setContentAreaFilled(false);
			JLabel lbTitle = new JLabel("삼진그룹 영어토익반");
			lbTitle.setBounds(230,25,500,50);
			lbTitle.setFont(new Font("맑은 고딕", Font.BOLD,25));
			JLabel lbMov1 = new JLabel("110분, 한국");
			lbMov1.setBounds(470,27,200,50);
			lbMov1.setFont(new Font("맑은 고딕", Font.PLAIN,15));
			JLabel lbMov2 = new JLabel("감독 : 이종필 ");
			lbMov2.setBounds(230,85,500,50);
			lbMov2.setFont(new Font("맑은 고딕", Font.PLAIN,20));
			JLabel lbMov3 = new JLabel("배우 : 고아성, 이솜, 박혜수 ");
			lbMov3.setBounds(230,130,500,50);
			lbMov3.setFont(new Font("맑은 고딕", Font.PLAIN,20));
			JLabel lbMov4 = new JLabel("장르 : 드라마 / 기본 : 12세 이상 ");
			lbMov4.setBounds(230,175,500,50);
			lbMov4.setFont(new Font("맑은 고딕", Font.PLAIN,20));
			JLabel lbMov5 = new JLabel("개봉 : 2020.10.21 ");
			lbMov5.setBounds(230,220,500,50);
			lbMov5.setFont(new Font("맑은 고딕", Font.PLAIN,20));
			
			pnInside.add(btnPic);
			pnInside.add(lbTitle);
			pnInside.add(lbMov1);
			pnInside.add(lbMov2);
			pnInside.add(lbMov3);
			pnInside.add(lbMov4);
			pnInside.add(lbMov5);
			
			info[0] = lbTitle.getText();
		} else if(choiceMovie == 3){
			ImageIcon changeIcon2 = new ImageIcon(((new ImageIcon("movie3.jpg")).getImage()).getScaledInstance(180,260, Image.SCALE_SMOOTH));
			JButton btnPic = new JButton(changeIcon2);
			btnPic.setBounds(20,20,180,260);
			btnPic.setBorderPainted(false);
			btnPic.setFocusPainted(false);
			btnPic.setContentAreaFilled(false);
			JLabel lbTitle = new JLabel("내가 죽던 날");
			lbTitle.setBounds(230,25,500,50);
			lbTitle.setFont(new Font("맑은 고딕", Font.BOLD,25));
			JLabel lbMov1 = new JLabel("116분, 한국");
			lbMov1.setBounds(380,27,200,50);
			lbMov1.setFont(new Font("맑은 고딕", Font.PLAIN,15));
			JLabel lbMov2 = new JLabel("감독 : 박지완 ");
			lbMov2.setBounds(230,85,500,50);
			lbMov2.setFont(new Font("맑은 고딕", Font.PLAIN,20));
			JLabel lbMov3 = new JLabel("배우 : 김혜수, 이정은, 노정의");
			lbMov3.setBounds(230,130,500,50);
			lbMov3.setFont(new Font("맑은 고딕", Font.PLAIN,20));
			JLabel lbMov4 = new JLabel("장르 : 드라마 / 기본 : 12세 이상 ");
			lbMov4.setBounds(230,175,500,50);
			lbMov4.setFont(new Font("맑은 고딕", Font.PLAIN,20));
			JLabel lbMov5 = new JLabel("개봉 : 2020.11.12 ");
			lbMov5.setBounds(230,220,500,50);
			lbMov5.setFont(new Font("맑은 고딕", Font.PLAIN,20));
			
			pnInside.add(btnPic);
			pnInside.add(lbTitle);
			pnInside.add(lbMov1);
			pnInside.add(lbMov2);
			pnInside.add(lbMov3);
			pnInside.add(lbMov4);
			pnInside.add(lbMov5);
			
			info[0] = lbTitle.getText();
		}
		pnMid.add(pnInside);
	}
	
	private void choosePeoNum(){ //인원 선택하는 메소드
		
		JLabel lbPerNumNor = new JLabel("일반");
		lbPerNumNor.setFont(new Font("맑은 고딕", Font.BOLD,20));
		lbPerNumNor.setBounds(150,50,200,50);
		pnInside2.add(lbPerNumNor);
		
		JLabel lbPerNumStu = new JLabel("청소년");
		lbPerNumStu.setFont(new Font("맑은 고딕", Font.BOLD,20));
		lbPerNumStu.setBounds(150,130,200,50);
		pnInside2.add(lbPerNumStu);
		
		JLabel lbPerNumChi = new JLabel("어린이");
		lbPerNumChi.setFont(new Font("맑은 고딕", Font.BOLD,20));
		lbPerNumChi.setBounds(150,210,200,50);
		pnInside2.add(lbPerNumChi);
		
		JLabel lbPerwarn = new JLabel("*어린이 관람 불가");
		lbPerwarn.setFont(new Font("맑은 고딕", Font.BOLD,13));
		lbPerwarn.setBounds(155,235,200,50);
		pnInside2.add(lbPerwarn);
		
		SpinnerNumberModel numberModel = new SpinnerNumberModel(0,0,4,1); // 일반 관객 스피너
		spinner1 = new JSpinner(numberModel);
		spinner1.setBounds(350,55,180,40);
		spinner1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		JComponent editor1 = spinner1.getEditor();
		if(editor1 instanceof JSpinner.DefaultEditor) {
			JSpinner.DefaultEditor spinnerEditor1 = (JSpinner.DefaultEditor)editor1;
			spinnerEditor1.getTextField().setHorizontalAlignment(JTextField.CENTER);
		}
		pnInside2.add(spinner1);
		
		SpinnerNumberModel numberModel2 = new SpinnerNumberModel(0,0,4,1); // 청소년 관객 스피너
		spinner2 = new JSpinner(numberModel2);
		spinner2.setBounds(350,135,180,40);
		spinner2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		JComponent editor2 = spinner2.getEditor();
		if(editor2 instanceof JSpinner.DefaultEditor) {
			JSpinner.DefaultEditor spinnerEditor2 = (JSpinner.DefaultEditor)editor2;
			spinnerEditor2.getTextField().setHorizontalAlignment(JTextField.CENTER);
		}
		pnInside2.add(spinner2);
		
		SpinnerNumberModel numberModel3 = new SpinnerNumberModel(0,0,4,1);
		JSpinner spinner3 = new JSpinner(numberModel3);
		spinner3.setEnabled(false);	
		spinner3.setBounds(350,215,180,40);
		spinner3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		JComponent editor3 = spinner3.getEditor();
		if(editor3 instanceof JSpinner.DefaultEditor) {
			JSpinner.DefaultEditor spinnerEditor3 = (JSpinner.DefaultEditor)editor3;
			spinnerEditor3.getTextField().setHorizontalAlignment(JTextField.CENTER);
		}
		pnInside2.add(spinner3);
		
		if(spinner1.getModel().getValue() == null){
			info[1] = "";
			info[2] = "";
		} else if(spinner1.getModel().getValue() != null){
			info[1] = "일반";
			info[2] = String.valueOf(spinner1.getValue());
		}
		if(spinner2.getModel().getValue() == null){
			info[3] = "";
			info[4] = "";
		} else if(spinner2.getModel().getValue() != null){
			info[3] = "청소년";
			info[4] = String.valueOf(spinner2.getValue());
		}
		
		
		resetcustomer = new JButton("다시 선택");
		resetcustomer.addActionListener(this);
		resetcustomer.setFont(new Font("맑은 고딕",Font.BOLD,16));
		resetcustomer.setForeground(Color.white);
		resetcustomer.setBackground(new Color(39,38,64));
		resetcustomer.setBorderPainted(false);
		resetcustomer.setFocusPainted(false);
		resetcustomer.setBounds(0,320,180,40);
		pnInside2.add(resetcustomer);
		
		customerok = new JButton("선택 완료");
		customerok.addActionListener(this);
		customerok.setPreferredSize(new Dimension(100, 30));
		customerok.setFont(new Font("맑은 고딕",Font.BOLD,16));
		customerok.setForeground(Color.white);
		customerok.setBackground(new Color(39,38,64));
		customerok.setBorderPainted(false);
		customerok.setFocusPainted(false);
		customerok.setBounds(510,320,180,40);
		pnInside2.add(customerok);
		
		ImageIcon imgpark = new ImageIcon("exclamation-mark.png");//프린트 아이콘 사이즈 조절
		Image imagepark = imgpark.getImage();
		Image changepark = imagepark.getScaledInstance(50,50, Image.SCALE_SMOOTH);
		ImageIcon iconPark = new ImageIcon(changepark);
		JButton btnGuide = new JButton(iconPark);
		btnGuide.setBorderPainted(false);
		btnGuide.setFocusPainted(false);
		btnGuide.setContentAreaFilled(false);
		btnGuide.setBounds(630,265,50,50);
		pnInside2.add(btnGuide);
		}
	
	private void chooseTimeTable(){//시간 고르는 메소드
		if (choiceMovie == 1){ //영화 1번 했을 때
			
			//timePnl
			JLabel lb1 = new JLabel("3관");
			lb1.setBounds(160, 110, 100, 50);
			lb1.setFont(new Font("맑은 고딕", Font.BOLD,20));
			timePnl.add(lb1);
			
			btnTime1 = new JButton("16:55");
			btnTime1.setBounds(275, 120, 70, 30);
			btnTime2 = new JButton("19:15");
			btnTime2.setBounds(355, 120, 70, 30);
			timePnl.add(btnTime1);
			timePnl.add(btnTime2);
			
			JLabel lb2 = new JLabel("5관");
			lb2.setBounds(160, 200, 100, 50);
			lb2.setFont(new Font("맑은 고딕", Font.BOLD,20));
			timePnl.add(lb2);
			
			btnTime3 = new JButton("12:55");
			btnTime3.setBounds(235, 210, 70, 30);
			btnTime4 = new JButton("15:15");
			btnTime4.setBounds(315, 210, 70, 30);
			btnTime5 = new JButton("17:35");
			btnTime5.setBounds(395, 210, 70, 30);
			timePnl.add(btnTime3);
			timePnl.add(btnTime4);
			timePnl.add(btnTime5);
			
			ImageIcon imgpark = new ImageIcon("exclamation-mark.png");//프린트 아이콘 사이즈 조절
			Image imagepark = imgpark.getImage();
			Image changepark = imagepark.getScaledInstance(50,50, Image.SCALE_SMOOTH);
			ImageIcon iconPark = new ImageIcon(changepark);
			JButton btnGuide = new JButton(iconPark);
			btnGuide.setBorderPainted(false);
			btnGuide.setFocusPainted(false);
			btnGuide.setContentAreaFilled(false);
			btnGuide.setBounds(630,265,50,50);
			timePnl.add(btnGuide);
			 
			timeok = new JButton("선택 완료");
			timeok.setFont(new Font("맑은 고딕", Font.BOLD,16));
			timeok.setBounds(510, 320, 180, 40);
			timeok.addActionListener(this);
			timeok.setForeground(Color.white);
			timeok.setBackground(new Color(39,38,64));
			timeok.setBorderPainted(false);
			timeok.setFocusPainted(false);
			
			resettime1 = new JButton("다시 선택"); 
			resettime1.addActionListener(this);
			resettime1.setFont(new Font("맑은 고딕", Font.BOLD,16));
			resettime1.setBounds(0, 320, 180, 40);
			resettime1.setForeground(Color.white);
			resettime1.setBackground(new Color(39,38,64));
			resettime1.setBorderPainted(false);
			resettime1.setFocusPainted(false);

			btnTime1.addActionListener(this);
			btnTime2.addActionListener(this);
			btnTime3.addActionListener(this);
			btnTime4.addActionListener(this);
			btnTime5.addActionListener(this);
			
			timePnl.add(timeok);
			timePnl.add(resettime1);
			
		} else if (choiceMovie == 2){ //영화 2번 했을 때
			
			JLabel lb1 = new JLabel("4관");
			lb1.setFont(new Font("맑은 고딕", Font.BOLD,20));
			lb1.setBounds(230, 110, 100, 50);
			timePnl.add(lb1);
			
			btnTime6 = new JButton("13:15");
			btnTime6.setBounds(280, 120, 70, 30);
			btnTime7 = new JButton("15:30");
			btnTime7.setBounds(360, 120, 70, 30);
			timePnl.add(btnTime6);
			timePnl.add(btnTime7);
			
			btnTime8 = new JButton("17:45");
			btnTime8.setBounds(280, 180, 70, 30);
			btnTime9 = new JButton("20:00");
			btnTime9.setBounds(360, 180, 70, 30);
			timePnl.add(btnTime8);
			timePnl.add(btnTime9);
			
			ImageIcon imgpark = new ImageIcon("exclamation-mark.png");//프린트 아이콘 사이즈 조절
			Image imagepark = imgpark.getImage();
			Image changepark = imagepark.getScaledInstance(50,50, Image.SCALE_SMOOTH);
			ImageIcon iconPark = new ImageIcon(changepark);
			JButton btnGuide = new JButton(iconPark);
			btnGuide.setBorderPainted(false);
			btnGuide.setFocusPainted(false);
			btnGuide.setContentAreaFilled(false);
			btnGuide.setBounds(630,265,50,50);
			timePnl.add(btnGuide);
			
			timeok = new JButton("선택 완료");
			timeok.setBounds(510, 320, 180, 40);
			timeok.setFont(new Font("맑은 고딕", Font.BOLD,16));
			timeok.addActionListener(this);
			timeok.setForeground(Color.white);
			timeok.setBackground(new Color(39,38,64));
			timeok.setBorderPainted(false);
			timeok.setFocusPainted(false);
			
			resettime2 = new JButton("다시 선택"); 
			resettime2.setBounds(0, 320, 180, 40);
			resettime2.setFont(new Font("맑은 고딕", Font.BOLD,16));
			resettime2.addActionListener(this);
			resettime2.setForeground(Color.white);
			resettime2.setBackground(new Color(39,38,64));
			resettime2.setBorderPainted(false);
			resettime2.setFocusPainted(false);
			
			btnTime6.addActionListener(this);
			btnTime7.addActionListener(this);
			btnTime8.addActionListener(this);
			btnTime9.addActionListener(this);
			
			timePnl.add(timeok);
			timePnl.add(resettime2);
			
		} else if (choiceMovie == 3){ //영화 3번 했을 때
			
			JLabel lb1 = new JLabel("2관");
			lb1.setFont(new Font("맑은 고딕", Font.BOLD,20));
			lb1.setBounds(230, 110, 100, 50);
			timePnl.add(lb1);
			
			btnTime10 = new JButton("12:50");
			btnTime10.setBounds(280, 120, 70, 30);
			btnTime11 = new JButton("15:10");
			btnTime11.setBounds(360, 120, 70, 30);
			timePnl.add(btnTime10);
			timePnl.add(btnTime11);
			
			btnTime12 = new JButton("17:30");
			btnTime12.setBounds(280, 180, 70, 30);
			btnTime13 = new JButton("19:50");
			btnTime13.setBounds(360, 180, 70, 30);
			timePnl.add(btnTime12);
			timePnl.add(btnTime13);
			
			ImageIcon imgpark = new ImageIcon("exclamation-mark.png");//프린트 아이콘 사이즈 조절
			Image imagepark = imgpark.getImage();
			Image changepark = imagepark.getScaledInstance(50,50, Image.SCALE_SMOOTH);
			ImageIcon iconPark = new ImageIcon(changepark);
			JButton btnGuide = new JButton(iconPark);
			btnGuide.setBorderPainted(false);
			btnGuide.setFocusPainted(false);
			btnGuide.setContentAreaFilled(false);
			btnGuide.setBounds(630,265,50,50);
			timePnl.add(btnGuide);
			
			timeok = new JButton("선택 완료");
			timeok.setBounds(510, 320, 180, 40);
			timeok.setFont(new Font("맑은 고딕", Font.BOLD,16));
			timeok.addActionListener(this);
			timeok.setForeground(Color.white);
			timeok.setBackground(new Color(39,38,64));
			timeok.setBorderPainted(false);
			timeok.setFocusPainted(false);
			
			resettime3 = new JButton("다시 선택");
			resettime3.setBounds(0, 320, 180, 40);
			resettime3.addActionListener(this);
			resettime3.setFont(new Font("맑은 고딕", Font.BOLD,16));
			resettime3.setPreferredSize(new Dimension(100,30));
			resettime3.setForeground(Color.white);
			resettime3.setBackground(new Color(39,38,64));
			resettime3.setBorderPainted(false);
			resettime3.setFocusPainted(false);
			
			btnTime10.addActionListener(this);
			btnTime11.addActionListener(this);
			btnTime12.addActionListener(this);
			btnTime13.addActionListener(this);
			
			timePnl.add(timeok);
			timePnl.add(resettime3);
			
		}
	}
	
	private void chooseSeat(){ //좌석을 고르는 메소드
		JLabel lbScreen = new JLabel("Screen");
		lbScreen.setOpaque(true);
		lbScreen.setForeground(Color.white);
		lbScreen.setBackground(new Color(39,38,64));
		lbScreen.setHorizontalAlignment(JLabel.CENTER);
		lbScreen.setFont(new Font("맑은 고딕", Font.BOLD,20));
		lbScreen.setBounds(100,10,500,30);
		seatPnl.add(lbScreen);
		
		JLabel lbNoSeat = new JLabel("A열");
		lbNoSeat.setFont(new Font("맑은 고딕", Font.PLAIN,25));
		lbNoSeat.setBounds(110,60,50,50);
		seatPnl.add(lbNoSeat);
		
		JLabel lbNoSeat2 = new JLabel("B열");
		lbNoSeat2.setFont(new Font("맑은 고딕", Font.PLAIN,25));
		lbNoSeat2.setBounds(110,140,50,50);
		seatPnl.add(lbNoSeat2);
		
		JLabel lbNoSeat3 = new JLabel("C열");
		lbNoSeat3.setFont(new Font("맑은 고딕", Font.PLAIN,25));
		lbNoSeat3.setBounds(110,220,50,50);
		seatPnl.add(lbNoSeat3);
		
		btnSeatA1 = new JButton("1"); 		btnSeatA2 = new JButton("2");
		btnSeatA3 = new JButton("3");		btnSeatA4 = new JButton("4");
		btnSeatA5 = new JButton("5");		btnSeatA6 = new JButton("6");
		btnSeatB1 = new JButton("1");		btnSeatB2 = new JButton("2");
		btnSeatB3 = new JButton("3");		btnSeatB4 = new JButton("4");
		btnSeatB5 = new JButton("5");		btnSeatB6 = new JButton("6");
		btnSeatC1 = new JButton("1");		btnSeatC2 = new JButton("2");
		btnSeatC3 = new JButton("3");		btnSeatC4 = new JButton("4");
		btnSeatC5 = new JButton("5");		btnSeatC6 = new JButton("6");
		
		btnSeatA1.addActionListener(this); btnSeatA2.addActionListener(this);
		btnSeatA3.addActionListener(this); btnSeatA4.addActionListener(this);
		btnSeatA5.addActionListener(this); btnSeatA6.addActionListener(this);
		btnSeatB1.addActionListener(this); btnSeatB2.addActionListener(this);
		btnSeatB3.addActionListener(this); btnSeatB4.addActionListener(this);
		btnSeatB5.addActionListener(this); btnSeatB6.addActionListener(this);
		btnSeatC1.addActionListener(this); btnSeatC2.addActionListener(this);
		btnSeatC3.addActionListener(this); btnSeatC4.addActionListener(this);
		btnSeatC5.addActionListener(this); btnSeatC6.addActionListener(this);
		
		btnSeatA1.setBounds(170,72,50,30);
		btnSeatA2.setBounds(223,72,50,30);
		btnSeatA3.setBounds(300,72,50,30);
		btnSeatA4.setBounds(353,72,50,30);
		btnSeatA5.setBounds(430,72,50,30);
		btnSeatA6.setBounds(483,72,50,30);
		btnSeatB1.setBounds(170,152,50,30);
		btnSeatB2.setBounds(223,152,50,30);
		btnSeatB3.setBounds(300,152,50,30);
		btnSeatB4.setBounds(353,152,50,30);
		btnSeatB5.setBounds(430,152,50,30);
		btnSeatB6.setBounds(483,152,50,30);
		btnSeatC1.setBounds(170,232,50,30);
		btnSeatC2.setBounds(223,232,50,30);
		btnSeatC3.setBounds(300,232,50,30);
		btnSeatC4.setBounds(353,232,50,30);
		btnSeatC5.setBounds(430,232,50,30);
		btnSeatC6.setBounds(483,232,50,30);
		
		seatPnl.add(btnSeatA1);
		seatPnl.add(btnSeatA2);
		seatPnl.add(btnSeatA3);
		seatPnl.add(btnSeatA4);
		seatPnl.add(btnSeatA5);
		seatPnl.add(btnSeatA6);
		seatPnl.add(btnSeatB1);
		seatPnl.add(btnSeatB2);
		seatPnl.add(btnSeatB3);
		seatPnl.add(btnSeatB4);
		seatPnl.add(btnSeatB5);
		seatPnl.add(btnSeatB6);
		seatPnl.add(btnSeatC1);
		seatPnl.add(btnSeatC2);
		seatPnl.add(btnSeatC3);
		seatPnl.add(btnSeatC4);
		seatPnl.add(btnSeatC5);
		seatPnl.add(btnSeatC6);
		
		resetseat = new JButton("다시 선택"); 
		resetseat.addActionListener(this);
		resetseat.setPreferredSize(new Dimension(100,39));
		resetseat.setFont(new Font("맑은 고딕", Font.BOLD,16));
		resetseat.setForeground(Color.white);
		resetseat.setBackground(new Color(39,38,64));
		resetseat.setBorderPainted(false);
		resetseat.setFocusPainted(false);
		resetseat.setBounds(0,320,180,40);
		seatPnl.add(resetseat);
		
		ImageIcon imgpark = new ImageIcon("exclamation-mark.png");//프린트 아이콘 사이즈 조절
		Image imagepark = imgpark.getImage();
		Image changepark = imagepark.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		ImageIcon iconPark = new ImageIcon(changepark);
		JButton btnGuide = new JButton(iconPark);
		btnGuide.setBorderPainted(false);
		btnGuide.setFocusPainted(false);
		btnGuide.setContentAreaFilled(false);
		btnGuide.setBounds(600,280,70,70);
		seatPnl.add(btnGuide);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==customerok){ // 인원수 값 넘기고 시간대 버튼 전부 활성화
			adult = (int)(spinner1.getValue());
			teenager = (int)(spinner2.getValue());
			customer = adult + teenager;			
			if(customer >= 1){
				tp.setEnabledAt(1, true);
				tp.setSelectedIndex(1);
			}
		}			
		if(e.getSource()==resetcustomer){  // 인원 선택 취소하고 스피너 초기값으로 되돌리기
			spinner1.setValue(0);
			spinner2.setValue(0);
			adult = 0;
			teenager = 0;
			info[5] = "";
			info[6] = "";
			info[7] = "";
			info[8] = "";
			seatindex = 0;
			btnOk.setEnabled(false);
			tp.setEnabledAt(1, false);
			tp.setEnabledAt(2, false);
		}
//////////////////////////////////////인원 선택 버튼/////////////////////////////////////////
		
		if (e.getSource() == btnTime1) { //시간 버튼
			info[5] = "3관";
			info[6] = "16:55";
			btnTime1.setBackground(Color.ORANGE);
			btnTime2.setEnabled(false);
			btnTime3.setEnabled(false);
			btnTime4.setEnabled(false);
			btnTime5.setEnabled(false);
		} else if (e.getSource() == btnTime2) {
			info[5] = "3관";
			info[6] = "19:15";
			btnTime2.setBackground(Color.ORANGE);
			btnTime1.setEnabled(false);
			btnTime3.setEnabled(false);
			btnTime4.setEnabled(false);
			btnTime5.setEnabled(false);
		} else if (e.getSource() == btnTime3) {
			info[5] = "5관";
			info[6] = "12:55";
			btnTime3.setBackground(Color.ORANGE);
			btnTime2.setEnabled(false);
			btnTime1.setEnabled(false);
			btnTime4.setEnabled(false);
			btnTime5.setEnabled(false);
		} else if (e.getSource() == btnTime4) {
			info[5] = "5관";
			info[6] = "15:15";
			btnTime4.setBackground(Color.ORANGE);
			btnTime2.setEnabled(false);
			btnTime3.setEnabled(false);
			btnTime1.setEnabled(false);
			btnTime5.setEnabled(false);	
		} else if (e.getSource() == btnTime5) {
			info[5] = "5관";
			info[6] = "17:35";
			btnTime5.setBackground(Color.ORANGE);
			btnTime2.setEnabled(false);
			btnTime3.setEnabled(false);
			btnTime4.setEnabled(false);
			btnTime1.setEnabled(false);
		}  else if (e.getSource() == btnTime6) {
			info[5] = "4관";
			info[6] = "13:15";
			btnTime6.setBackground(Color.ORANGE);
			btnTime7.setEnabled(false);
			btnTime8.setEnabled(false);
			btnTime9.setEnabled(false);
			btnOk.setEnabled(false);			
		} else if (e.getSource() == btnTime7) {
			info[5] = "4관";
			info[6] = "15:30";
			btnTime7.setBackground(Color.ORANGE);
			btnTime6.setEnabled(false);
			btnTime8.setEnabled(false);
			btnTime9.setEnabled(false);	
		} else if (e.getSource() == btnTime8) {
			info[5] = "4관";
			info[6] = "17:45";
			btnTime8.setBackground(Color.ORANGE);
			btnTime7.setEnabled(false);
			btnTime6.setEnabled(false);
			btnTime9.setEnabled(false);
		} else if (e.getSource() == btnTime9) {
			info[5] = "4관";
			info[6] = "20:00";
			btnTime9.setBackground(Color.ORANGE);
			btnTime7.setEnabled(false);
			btnTime8.setEnabled(false);
			btnTime6.setEnabled(false);
		} else if (e.getSource() == btnTime10) {
			info[5] = "2관";
			info[6] = "12:50";
			btnTime10.setBackground(Color.ORANGE);
			btnTime11.setEnabled(false);
			btnTime12.setEnabled(false);
			btnTime13.setEnabled(false);
			btnSeatC3.setEnabled(false);
		} else if (e.getSource() == btnTime11) {
			info[5] = "2관";
			info[6] = "15:10";
			btnTime11.setBackground(Color.ORANGE);
			btnTime10.setEnabled(false);
			btnTime12.setEnabled(false);
			btnTime13.setEnabled(false);
		} else if (e.getSource() == btnTime12) {
			info[5] = "2관";
			info[6] = "17:30";
			btnTime12.setBackground(Color.ORANGE);
			btnTime11.setEnabled(false);
			btnTime10.setEnabled(false);
			btnTime13.setEnabled(false);
		} else if (e.getSource() == btnTime13) {
			info[5] = "2관";
			info[6] = "19:50";
			btnTime13.setBackground(Color.ORANGE);
			btnTime11.setEnabled(false);
			btnTime12.setEnabled(false);
			btnTime10.setEnabled(false);
			
		}
		
		if(e.getSource()==resettime1){ // 도굴 상영관 시간 선택 초기화
			btnOk.setEnabled(false); 
			info[5] = "";
			info[6] = "";
			tp.setEnabledAt(2, false); // 좌석 탭 잠금
			if(btnTime1.getBackground() == Color.orange){
				btnTime1.setBackground(null);
				btnTime2.setEnabled(true);
				btnTime3.setEnabled(true);
				btnTime4.setEnabled(true);
				btnTime5.setEnabled(true);
			}else if(btnTime2.getBackground() == Color.orange){
				btnTime2.setBackground(null);
				btnTime1.setEnabled(true);
				btnTime3.setEnabled(true);
				btnTime4.setEnabled(true);
				btnTime5.setEnabled(true);
			}else if(btnTime3.getBackground() == Color.orange){
				btnTime3.setBackground(null);
				btnTime2.setEnabled(true);
				btnTime1.setEnabled(true);
				btnTime4.setEnabled(true);
				btnTime5.setEnabled(true);
			} else if(btnTime4.getBackground() == Color.orange){
				btnTime4.setBackground(null);
				btnTime2.setEnabled(true);
				btnTime1.setEnabled(true);
				btnTime3.setEnabled(true);
				btnTime5.setEnabled(true);
			} else if(btnTime5.getBackground() == Color.orange){
				btnTime5.setBackground(null);
				btnTime2.setEnabled(true);
				btnTime1.setEnabled(true);
				btnTime4.setEnabled(true);
				btnTime3.setEnabled(true);
			}
		}
		
		if(e.getSource()==timeok){  // 시간 선택 완료, 좌석 탭 활성화 
			if(info[5]!=null && info[6]!=null){
				tp.setEnabledAt(2, true);
				tp.setSelectedIndex(2);
				btnOk.setEnabled(true);
			}
		}
		
		if(e.getSource()==resettime2){ // 삼진토익반 상영관 시간 선택 초기화
			btnOk.setEnabled(false);
			info[5] = "";
			info[6] = "";
			tp.setEnabledAt(2, false); // 좌석 탭 잠금
			
			if(btnTime6.getBackground() == Color.orange){
				btnTime6.setBackground(null);
				btnTime7.setEnabled(true);
				btnTime8.setEnabled(true);
				btnTime9.setEnabled(true);
			}else if(btnTime7.getBackground() == Color.orange){
				btnTime7.setBackground(null);
				btnTime6.setEnabled(true);
				btnTime8.setEnabled(true);
				btnTime9.setEnabled(true);
			}else if(btnTime8.getBackground() == Color.orange){
				btnTime8.setBackground(null);
				btnTime6.setEnabled(true);
				btnTime7.setEnabled(true);
				btnTime9.setEnabled(true);
			}else if(btnTime9.getBackground() == Color.orange){
				btnTime9.setBackground(null);
				btnTime6.setEnabled(true);
				btnTime7.setEnabled(true);
				btnTime8.setEnabled(true);
			}			
		}
		
		if(e.getSource()==resettime3){ // 내가 죽던 날 상영관 시간 선택 초기화
			btnOk.setEnabled(false);
			info[5] = "";
			info[6] = "";
			tp.setEnabledAt(2, false); // 좌석 탭 잠금
			
			if(btnTime10.getBackground() == Color.orange){
				btnTime10.setBackground(null);
				btnTime11.setEnabled(true);
				btnTime12.setEnabled(true);
				btnTime13.setEnabled(true);
			}else if(btnTime11.getBackground() == Color.orange){
				btnTime11.setBackground(null);
				btnTime10.setEnabled(true);
				btnTime12.setEnabled(true);
				btnTime13.setEnabled(true);
			}else if(btnTime12.getBackground() == Color.orange){
				btnTime12.setBackground(null);
				btnTime10.setEnabled(true);
				btnTime11.setEnabled(true);
				btnTime13.setEnabled(true);
			}else if(btnTime13.getBackground() == Color.orange){
				btnTime13.setBackground(null);
				btnTime10.setEnabled(true);
				btnTime12.setEnabled(true);
				btnTime11.setEnabled(true);
			}
		}
/////////////////////////////////////// 시간대 버튼 //////////////////////////////////////////////////////////		
		if (e.getSource() == btnSeatA1){ //좌석 고르기
			seatnums[0] = "A1";
			btnSeatA1.setBackground(Color.ORANGE);
			btnSeatA1.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatA2){
			seatnums[1] = "A2";
			btnSeatA2.setBackground(Color.ORANGE);
			btnSeatA2.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatA3){
			seatnums[2] = "A3";
			btnSeatA3.setBackground(Color.ORANGE);
			btnSeatA3.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatA4){
			seatnums[3] = "A4";
			btnSeatA4.setBackground(Color.ORANGE);
			btnSeatA4.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatA5){
			seatnums[4] = "A5";
			btnSeatA5.setBackground(Color.ORANGE);
			btnSeatA5.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatA6){
			seatnums[5] = "A6";
			btnSeatA6.setBackground(Color.ORANGE);
			btnSeatA6.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatB1){
			seatnums[6] = "B1";
			btnSeatB1.setBackground(Color.ORANGE);
			btnSeatB1.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatB2){
			seatnums[7] = "B2";
			btnSeatB2.setBackground(Color.ORANGE);
			btnSeatB2.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatB3){
			seatnums[8] = "B3";
			btnSeatB3.setBackground(Color.ORANGE);
			btnSeatB3.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatB4){
			seatnums[9] = "B4";
			btnSeatB4.setBackground(Color.ORANGE);
			btnSeatB4.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatB5){
			seatnums[10] = "B5";
			btnSeatB5.setBackground(Color.ORANGE);
			btnSeatB5.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatB6){
			seatnums[11] = "B6";
			btnSeatB6.setBackground(Color.ORANGE);
			btnSeatB6.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatC1){
			seatnums[12] = "C1";
			btnSeatC1.setBackground(Color.ORANGE);
			btnSeatC1.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatC2){
			seatnums[13] = "C2";
			btnSeatC2.setBackground(Color.ORANGE);
			btnSeatC2.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatC3){
			seatnums[14] = "C3";
			btnSeatC3.setBackground(Color.ORANGE);
			btnSeatC3.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatC4){
			seatnums[15] = "C4";
			btnSeatC4.setBackground(Color.ORANGE);
			btnSeatC4.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatC5){
			seatnums[16] = "C5";
			btnSeatC5.setBackground(Color.ORANGE);
			btnSeatC5.setEnabled(false);
			seatindex++;
		} else if (e.getSource() == btnSeatC6){
			seatnums[17] = "C6";
			btnSeatC6.setBackground(Color.ORANGE);
			btnSeatC6.setEnabled(false);
			seatindex++;
		} 
		
		if(e.getSource()==resetseat){ // 좌석 선택 초기화 버튼
			btnSeatA1.setBackground(null);
			btnSeatA1.setEnabled(true);
			btnSeatA2.setBackground(null);
			btnSeatA2.setEnabled(true);
			btnSeatA3.setBackground(null); 
			btnSeatA3.setEnabled(true);
			btnSeatA4.setBackground(null); 
			btnSeatA4.setEnabled(true);
			btnSeatA5.setBackground(null); 
			btnSeatA5.setEnabled(true);
			btnSeatA6.setBackground(null);
			btnSeatA6.setEnabled(true);
			btnSeatB1.setBackground(null);
			btnSeatB1.setEnabled(true);
			btnSeatB2.setBackground(null);
			btnSeatB2.setEnabled(true);
			btnSeatB3.setBackground(null); 
			btnSeatB3.setEnabled(true);
			btnSeatB4.setBackground(null);
			btnSeatB4.setEnabled(true);
			btnSeatB5.setBackground(null);
			btnSeatB5.setEnabled(true);
			btnSeatB6.setBackground(null);
			btnSeatB6.setEnabled(true);
			btnSeatC1.setBackground(null);
			btnSeatC1.setEnabled(true);
			btnSeatC2.setBackground(null);
			btnSeatC2.setEnabled(true);
			btnSeatC3.setBackground(null);
			btnSeatC3.setEnabled(true);
			btnSeatC4.setBackground(null);
			btnSeatC4.setEnabled(true);
			btnSeatC5.setBackground(null);
			btnSeatC5.setEnabled(true);
			btnSeatC6.setBackground(null);
			btnSeatC6.setEnabled(true);
			seatindex = 0;
			seatnums[0] = "";
			seatnums[1] = "";
			seatnums[2] = "";
			seatnums[3] = "";
			seatnums[4] = "";
			seatnums[5] = "";
			seatnums[6] = "";
			seatnums[7] = "";
			seatnums[8] = "";
			seatnums[9] = "";
			seatnums[10] = "";
			seatnums[11] = "";
			seatnums[12] = "";
			seatnums[13] = "";
			seatnums[14] = "";
			seatnums[15] = "";
			seatnums[16] = "";
			seatnums[17] = "";
//			btnOk.setEnabled(false);
		}
		
///////////////////////// 좌석 버튼 //////////////////////////////////////
//		if(adult != 0 || teenager != 0){// 넘어가기 버튼이 활성화 되는 조건문
//			if(info[5] != "" && info[6] != ""){
//				if(seatindex == customer){
//					btnOk.setEnabled(true);	
//				}else if(seatindex > customer){
//					btnOk.setEnabled(false);
//				}else if(seatindex < customer){
//					btnOk.setEnabled(false);
//				}
//			}
//		}  
		
		
		
		if (e.getSource()==btnOk){
			if(customer <1){
				JOptionPane.showMessageDialog(mf, customer + "명은 선택할 수 없습니다.");
			} else if(seatindex == customer){
				String[] data = new String[18];
				String str = "";
				
				for(int i = 0; i < seatnums.length; i++){
					if(seatnums[i] != null){
						str = str+" "+seatnums[i];
					}	
				}
				data[0] = info[0]; // 제목
				data[1] = info[6]; // 시간대
				data[2] = info[5]; // 상영관	
				data[3] = str; // 좌석 이어붙이기
				data[4] = (customer+"");  // 총 관람 인원
				data[5] = (adult+"");  // 일반 관객
				data[6] = (teenager+""); // 청소년 관객
				
				//인원 수 만큼 선택할 수 있도록 하기
				//인원수보다 많이 선택하면 팝업으로 두 자리만 선택가능하다 하고
				//인원수보다 적게 하면 인원수에 맞게 선택하라 띄우기
			
				mf.purchase_ChooseMovieAndTimeToNext(2, data);
			}else if(seatindex > customer){
				JOptionPane.showMessageDialog(mf, "선택한 인원수(" + customer + "명)보다 좌석수가 많습니다.");
			}else if(seatindex < customer){
				JOptionPane.showMessageDialog(mf, "선택한 인원수(" + customer + "명)에 맞게 좌석을 선택해주세요.");
			}	
		}

	}
}
	
	