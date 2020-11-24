package movie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Point_Guide extends JPanel implements ActionListener{
	private JButton cardBtn, backScreen, yesBtn, noBtn, printBtn;
	private Image backgroundImage; // 배경
	private ImageIcon img1, img2, img3; 
	private JLabel loding, completed; // 영수증 출력 중 문구, 결제완료 문구
	
	Main_Frame mf;
	
	public Point_Guide(Main_Frame mf){ //생성자
		this.mf = mf;
		this.setLayout(null);
		this.setSize(700,1000);
		//타이머 들어갈 이미지
		img1 = new ImageIcon("카드결제안내이미지.jpg");
		img2 = new ImageIcon("영수증.JPG");
		img3 = new ImageIcon("팝콘 주문완료.jpg");
		
		try {
			backgroundImage = ImageIO.read(new File("Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		makeFirstPage();
		settingTimer();
	}
	private void makeFirstPage(){
		JLabel paymentSelect = new JLabel("결제하실 방법을 선택해주세요");
		paymentSelect.setFont(new Font("맑은고딕", Font.PLAIN,30));
		paymentSelect.setForeground(Color.white);
		paymentSelect.setBounds(150, 110, 500, 250);
		
		JButton moneyBtn = new JButton(new ImageIcon("paymentmoney.png"));
		moneyBtn.setBounds(100, 320, 200, 200);
		moneyBtn.setBorderPainted(false); //버튼 라인 삭제
		moneyBtn.setFocusPainted(false); //버튼 클릭 라인 삭제
		moneyBtn.setContentAreaFilled(false); //버튼 배경 삭제
		moneyBtn.setEnabled(false);
		
		cardBtn = new JButton(new ImageIcon("paymentcard.png"));
		cardBtn.addActionListener(this);
		cardBtn.setBounds(390, 320, 200, 200);
		cardBtn.setBorderPainted(false); //버튼 라인 삭제
		cardBtn.setFocusPainted(false); //버튼 클릭 라인 삭제
		cardBtn.setContentAreaFilled(false); //버튼 배경 삭제
		
		backScreen = new JButton(new ImageIcon("back.png"));
		backScreen.addActionListener(this);
		backScreen.setBounds(290, 650, 115, 115);
		backScreen.setBorderPainted(false); //버튼 라인 삭제
		backScreen.setFocusPainted(false); //버튼 클릭 라인 삭제
		backScreen.setContentAreaFilled(false); //버튼 배경 삭제
		
		this.add(paymentSelect);
		this.add(moneyBtn);
		this.add(cardBtn);
		this.add(backScreen);
	}
	private void settingTimer(){
		yesBtn = new JButton(new ImageIcon("check.png"));
		yesBtn.addActionListener(this);
		yesBtn.setBounds(100, 280, 100, 100);
		yesBtn.setBorderPainted(false); //버튼 라인 삭제
		yesBtn.setFocusPainted(false); //버튼 클릭 라인 삭제
		yesBtn.setContentAreaFilled(false); //버튼 배경 삭제
		
		noBtn = new JButton(new ImageIcon("jump.png"));
		noBtn.addActionListener(this);
		noBtn.setBounds(390, 280, 100, 100);
		noBtn.setBorderPainted(false); //버튼 라인 삭제
		noBtn.setFocusPainted(false); //버튼 클릭 라인 삭제
		noBtn.setContentAreaFilled(false); //버튼 배경 삭제
		
		this.add(yesBtn);
		this.add(noBtn);
		yesBtn.setVisible(false);
		noBtn.setVisible(false);
		
	}
	private void makeLastPage(){
		printBtn = new JButton(new ImageIcon("printer.png"));
		printBtn.addActionListener(this);
		printBtn.setBounds(300, 600, 100, 100);
		printBtn.setBorderPainted(false); //버튼 라인 삭제
		printBtn.setFocusPainted(false); //버튼 클릭 라인 삭제
		printBtn.setContentAreaFilled(false); //버튼 배경 삭제

		
		completed = new JLabel();
		completed.setBounds(0, 100, 700, 800);
		completed.setIcon(img3);
		completed.add(printBtn);
		this.add(completed);
	}
	@Override
	public void actionPerformed(ActionEvent e) { //엑션 리스너
		if(e.getSource() == cardBtn){
			this.removeAll();
			
			loding = new JLabel();
			loding.setIcon(img1);
			loding.setBounds(50, 180, 590, 400);
			
			this.add(loding);
			Time();
			this.repaint();
		}else if(e.getSource() == backScreen){// 뒤로가기 화면 나오는 생성자 입력해주세요
			mf.point_GuideToNext(1);
		}else if(e.getSource() == yesBtn){// 포인트 적립 화면
			mf.point_GuideToNext(2);
		}else if(e.getSource() == noBtn){
			this.removeAll();
			makeLastPage();
			this.repaint();
		}else if(e.getSource() == printBtn){//첫 화면으로 돌아간다
			mf.point_GuideToNext(3);
		}
	}
	private void Time(){ // 카드결제하는중
		Timer timer = new Timer();
		TimerTask t_task = new TimerTask(){
				@Override
				public void run(){ // 결제하는시간3초 후 나올 이미지와 버튼
					
					loding.setIcon(img2);
					loding.add(yesBtn);
					loding.add(noBtn);
					yesBtn.setVisible(true);
					noBtn.setVisible(true);
				}
		};
		timer.schedule(t_task, 3000); // 딜레이 3초
	}
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);
		g.setColor(Color.WHITE);
		g.drawRect(50, 180, 590, 400);
		
	}
	
}