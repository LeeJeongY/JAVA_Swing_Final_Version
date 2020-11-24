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
	private JButton btnBack; //�ڷΰ��� ��ư
	private JButton btnCard; //���� ��ư
	private JLabel adultNum, adultMoney, studentNum, studentMoney, priceAll;
				//� ����             ���� �ݾ�               �л� ����         �л� �ݾ�               �� ���� �ݾ� �ջ�
	
	public Purchase_TicketPrice(Main_Frame mf, String[] s){
		this.mf = mf;
		this.dataToPay = s;
		this.setSize(700,1000);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		
		makeUpDown(); //Ʋ����� �޼ҵ�
		makeCenter();//�߾� �г� �޼ҵ�
		settingPerNum();//�Ϲ�, �л� �޾ƿ���
	}
	
	private void makeUpDown(){//Ʋ����� �޼ҵ�
		//��
		ImageIcon imgName = new ImageIcon("�̸�.PNG");
		Image image = imgName.getImage();
		Image changeImage = image.getScaledInstance(700,100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImage);
		JLabel lb1 = new JLabel(changeIcon);
		this.add(lb1,"North");
		
		//�Ʒ�
		JPanel pnDown = new JPanel();
		pnDown.setBackground(new Color(39,38,64));
		
		ImageIcon imgBtn1 = new ImageIcon("BACK_W.gif");
		Image image2 = imgBtn1.getImage();
		Image changeImage2 = image2.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImage2);
		
		btnBack = new JButton(changeIcon2); //�ڷΰ����ư
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.addActionListener(this);
		
		pnDown.add(btnBack);
		this.add(pnDown, "South");
		
	}
	
	private void makeCenter(){//�߾� �г� �޼ҵ�
		JPanel pnlCenter = new JPanel(new GridLayout(0,1)); // �߾� ū Ʋ
		pnlCenter.setBackground(new Color(255,0,0,0));
		
		JPanel pnlPriceBack = new JPanel(); //���� ���� �ִ� Ʋ
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
		
		JLabel adult = new JLabel("����");
		adultNum = new JLabel("0 ��");
		adultMoney = new JLabel("0 ��");
		adult.setForeground(Color.white);
		adultNum.setForeground(Color.white);
		adultMoney.setForeground(Color.white);
		adult.setFont(new Font("���� ���", Font.BOLD,17));
		adultNum.setFont(new Font("���� ���", Font.BOLD,17));
		adultMoney.setFont(new Font("���� ���", Font.BOLD,17));
		
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
		JLabel student = new JLabel("�л�");
		studentNum = new JLabel("0 ��");
		studentMoney = new JLabel("0 ��");
		student.setForeground(Color.white);
		studentNum.setForeground(Color.white);
		studentMoney.setForeground(Color.white);
		student.setFont(new Font("���� ���", Font.BOLD,17));
		studentNum.setFont(new Font("���� ���", Font.BOLD,17));
		studentMoney.setFont(new Font("���� ���", Font.BOLD,17));
		
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
		JLabel child = new JLabel("            ���                    0 ��                             0 ��");
		child.setForeground(Color.white);
		child.setFont(new Font("���� ���", Font.BOLD,17));
		pnl3.add(child);
		
		pnlPriceUp.add(new JLabel());
		pnlPriceUp.add(new JLabel());
		pnlPriceUp.add(pnl1);
		pnlPriceUp.add(pnl2);
		pnlPriceUp.add(pnl3);
		pnlPriceUp.add(new JLabel());
		pnlPriceUp.add(new JLabel());
		pnlPriceBack.add(pnlPriceUp);
		
		JLabel justText = new JLabel(" �� ���� �ݾ�     :  ");
		justText.setForeground(Color.white);
		justText.setBounds(110, 5, 200, 40);
		justText.setFont(new Font("���� ���", Font.BOLD,20));
		
		priceAll = new JLabel("11111��");
		priceAll.setForeground(Color.white);
		priceAll.setBounds(290, 5, 200, 40);
		priceAll.setFont(new Font("���� ���", Font.BOLD,20));
		
		pnlPriceDown.add(justText,"West");
		pnlPriceDown.add(priceAll,"East");
		pnlPriceBack.add(pnlPriceDown);
		
		JPanel pnlChooseCheck = new JPanel(new GridLayout(0,2)); //�Ʒ� ���� ��ư �ִ� Ʋ
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

	private void settingPerNum(){//�Ϲ�, �л� �޾ƿ���
		adultNum.setText(dataToPay[0]+" ��");
		studentNum.setText(dataToPay[1]+" ��");
		
		int am = (Integer.parseInt(dataToPay[0]))*18000;
		adultMoney.setText(am+"��");
		
		int sm = (Integer.parseInt(dataToPay[1]))*12000;
		studentMoney.setText(sm+"��");
		
		priceAll.setText((am+sm)+"��");
		
		adultNum.setHorizontalAlignment(JLabel.RIGHT);
		adultMoney.setHorizontalAlignment(JLabel.RIGHT);
		studentNum.setHorizontalAlignment(JLabel.RIGHT);
		studentMoney.setHorizontalAlignment(JLabel.RIGHT);
		priceAll.setHorizontalAlignment(JLabel.RIGHT);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //�ڷΰ���, ī�� ���� �ϱ�
		if(e.getSource() ==btnCard ){ //�����ϱ�
			boolean whichOne = 	false; //��������, Ƽ�� �������� Ȯ��
			int howMuch = (Integer.parseInt(dataToPay[0]))*18000 + (Integer.parseInt(dataToPay[1]))*12000; //���� �޾ƿ���
			
			mf.purchase_TicketPriceToNext(1,whichOne,howMuch);
		} else if(e.getSource() == btnBack){ //�ڷΰ���
			boolean whichOne = false; //��������, Ƽ�� �������� Ȯ��
			int howMuch = 0;
			mf.purchase_TicketPriceToNext(2,whichOne,howMuch);
		}
	}
	
}


