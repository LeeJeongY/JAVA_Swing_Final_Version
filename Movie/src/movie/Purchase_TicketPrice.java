package movie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Purchase_TicketPrice extends JPanel implements ActionListener{
	Main_Frame mf;
	Purchase_TicketPriceDialog1 ptpd1;
	private String[] dataToPay;
	private JButton btnBack; //뒤로가기 버튼
	private JButton btnCard; //결제 버튼
	private JLabel adultNum, adultMoney, studentNum, studentMoney, priceAll;
				//어른 숫자             성인 금액               학생 숫자         학생 금액               총 결제 금액 합산
	
	public Purchase_TicketPrice(Main_Frame mf, String[] s){
		this.mf = mf;
		this.dataToPay = s;
		this.setSize(700,1000);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		
		makeUpDown(); //틀만들기 메소드
		makeCenter();//중앙 패널 메소드
		settingPerNum();//일반, 학생 받아오기
	}
	
	private void makeUpDown(){//틀만들기 메소드
		//위
		ImageIcon imgName = new ImageIcon("이름.PNG");
		Image image = imgName.getImage();
		Image changeImage = image.getScaledInstance(700,100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImage);
		JLabel lb1 = new JLabel(changeIcon);
		this.add(lb1,"North");
		
		//아래
		JPanel pnDown = new JPanel();
		pnDown.setBackground(new Color(39,38,64));
		
		ImageIcon imgBtn1 = new ImageIcon("BACK_W.gif");
		Image image2 = imgBtn1.getImage();
		Image changeImage2 = image2.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImage2);
		
		btnBack = new JButton(changeIcon2); //뒤로가기버튼
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.addActionListener(this);
		
		pnDown.add(btnBack);
		this.add(pnDown, "South");
		
	}
	
	private void makeCenter(){//중앙 패널 메소드
		JPanel pnlCenter = new JPanel(new GridLayout(0,1)); // 중앙 큰 틀
		pnlCenter.setBackground(new Color(255,0,0,0));
		
		JPanel pnlPriceBack = new JPanel(); //위에 가격 있는 틀
		pnlPriceBack.setLayout(null);
		pnlPriceBack.setBackground(new Color(255,0,0,0));
		
		JPanel pnlPriceUp = new JPanel(new GridLayout(0,1));
		JPanel pnlPriceDown = new JPanel();
		pnlPriceDown.setLayout(null);
		pnlPriceUp.setBackground(new Color(20,69,82));
		pnlPriceDown.setBackground(new Color(20,69,82));
		pnlPriceUp.setBounds(70,40,550,250);
		pnlPriceDown.setBounds(70,300,550,50);
		
		JPanel pnl1 = new JPanel(new GridLayout(1,0));
		pnl1.setBackground(new Color(255,0,0,0));
		
		JLabel adult = new JLabel("성인");
		adultNum = new JLabel("0 명");
		adultMoney = new JLabel("0 원");
		adult.setForeground(Color.white);
		adultNum.setForeground(Color.white);
		adultMoney.setForeground(Color.white);
		adult.setFont(new Font("맑은 고딕", Font.BOLD,17));
		adultNum.setFont(new Font("맑은 고딕", Font.BOLD,17));
		adultMoney.setFont(new Font("맑은 고딕", Font.BOLD,17));
		
		pnl1.add(new JLabel(""));
		pnl1.add(adult);
		pnl1.add(new JLabel(""));
		pnl1.add(adultNum);
		pnl1.add(new JLabel(""));
		pnl1.add(new JLabel(""));
		pnl1.add(adultMoney);
		pnl1.add(new JLabel(""));
		
		JPanel pnl2 = new JPanel(new GridLayout(1,0));
		pnl2.setBackground(new Color(255,0,0,0));
		JLabel student = new JLabel("학생");
		studentNum = new JLabel("0 명");
		studentMoney = new JLabel("0 원");
		student.setForeground(Color.white);
		studentNum.setForeground(Color.white);
		studentMoney.setForeground(Color.white);
		student.setFont(new Font("맑은 고딕", Font.BOLD,17));
		studentNum.setFont(new Font("맑은 고딕", Font.BOLD,17));
		studentMoney.setFont(new Font("맑은 고딕", Font.BOLD,17));
		
		pnl2.add(new JLabel(""));
		pnl2.add(student);
		pnl2.add(new JLabel(""));
		pnl2.add(studentNum);
		pnl2.add(new JLabel(""));
		pnl2.add(new JLabel(""));
		pnl2.add(studentMoney);
		pnl2.add(new JLabel(""));
		
		JPanel pnl3 = new JPanel(new GridLayout(1,0));
		pnl3.setBackground(new Color(255,0,0,0));
		JLabel child = new JLabel("            어린이                    0 명                             0 원");
		child.setForeground(Color.white);
		child.setFont(new Font("맑은 고딕", Font.BOLD,17));
		pnl3.add(child);
		
		pnlPriceUp.add(new JLabel());
		pnlPriceUp.add(new JLabel());
		pnlPriceUp.add(pnl1);
		pnlPriceUp.add(pnl2);
		pnlPriceUp.add(pnl3);
		pnlPriceUp.add(new JLabel());
		pnlPriceUp.add(new JLabel());
		pnlPriceBack.add(pnlPriceUp);
		
		JLabel justText = new JLabel(" 총 결제 금액     :  ");
		justText.setForeground(Color.white);
		justText.setBounds(110, 5, 200, 40);
		justText.setFont(new Font("맑은 고딕", Font.BOLD,20));
		
		priceAll = new JLabel("11111원");
		priceAll.setForeground(Color.white);
		priceAll.setBounds(290, 5, 200, 40);
		priceAll.setFont(new Font("맑은 고딕", Font.BOLD,20));
		
		pnlPriceDown.add(justText,"West");
		pnlPriceDown.add(priceAll,"East");
		pnlPriceBack.add(pnlPriceDown);
		
		JPanel pnlChooseCheck = new JPanel(new GridLayout(0,2)); //아래 결제 버튼 있는 틀
		pnlChooseCheck.setBackground(Color.white);
	
		ImageIcon imgbtn1 = new ImageIcon("002-payment.png");
		Image image1 = imgbtn1.getImage();
		Image changeImage1 = image1.getScaledInstance(200,200, Image.SCALE_SMOOTH);
		ImageIcon changeIcon1 = new ImageIcon(changeImage1);
		JButton btnCash = new JButton(changeIcon1);
		
		ImageIcon imgbtn2 = new ImageIcon("003-payment-1.png");
		Image image2 = imgbtn2.getImage();
		Image changeImage2 = image2.getScaledInstance(200,200, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImage2);
		btnCard = new JButton(changeIcon2);
		
		btnCash.setBorderPainted(false);
		btnCash.setFocusPainted(false);
		btnCash.setContentAreaFilled(false);
		btnCash.addActionListener(this);
		btnCard.setBorderPainted(false);
		btnCard.setFocusPainted(false);
		btnCard.setContentAreaFilled(false);
		btnCard.addActionListener(this);
		btnCash.setEnabled(false);
		
		pnlChooseCheck.add(btnCash);
		pnlChooseCheck.add(btnCard);
		
		pnlCenter.add(pnlPriceBack);
		pnlCenter.add(pnlChooseCheck);
		this.add(pnlCenter);

	}

	private void settingPerNum(){//일반, 학생 받아오기
		adultNum.setText(dataToPay[0]+" 명");
		studentNum.setText(dataToPay[1]+" 명");
		
		int am = (Integer.parseInt(dataToPay[0]))*18000;
		adultMoney.setText(am+"원");
		
		int sm = (Integer.parseInt(dataToPay[1]))*12000;
		studentMoney.setText(sm+"원");
		
		priceAll.setText((am+sm)+"원");
		
		adultNum.setHorizontalAlignment(JLabel.RIGHT);
		adultMoney.setHorizontalAlignment(JLabel.RIGHT);
		studentNum.setHorizontalAlignment(JLabel.RIGHT);
		studentMoney.setHorizontalAlignment(JLabel.RIGHT);
		priceAll.setHorizontalAlignment(JLabel.RIGHT);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //뒤로가기, 카드 결제 하기
		if(e.getSource() ==btnCard ){ //결제하기
			boolean whichOne = 	false; //매점인지, 티켓 구매인지 확인
			int howMuch = (Integer.parseInt(dataToPay[0]))*18000 + (Integer.parseInt(dataToPay[1]))*12000; //원금 받아오기
			
			mf.purchase_TicketPriceToNext(1,whichOne,howMuch);
		} else if(e.getSource() == btnBack){ //뒤로가기
			boolean whichOne = false; //매점인지, 티켓 구매인지 확인
			int howMuch = 0;
			mf.purchase_TicketPriceToNext(2,whichOne,howMuch);
		}
	}
	
}


