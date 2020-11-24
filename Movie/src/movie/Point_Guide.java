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
	private Image backgroundImage; // ���
	private ImageIcon img1, img2, img3; 
	private JLabel loding, completed; // ������ ��� �� ����, �����Ϸ� ����
	
	Main_Frame mf;
	
	public Point_Guide(Main_Frame mf){ //������
		this.mf = mf;
		this.setLayout(null);
		this.setSize(700,1000);
		//Ÿ�̸� �� �̹���
		img1 = new ImageIcon("ī������ȳ��̹���.jpg");
		img2 = new ImageIcon("������.JPG");
		img3 = new ImageIcon("���� �ֹ��Ϸ�.jpg");
		
		try {
			backgroundImage = ImageIO.read(new File("Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		makeFirstPage();
		settingTimer();
	}
	private void makeFirstPage(){
		JLabel paymentSelect = new JLabel("�����Ͻ� ����� �������ּ���");
		paymentSelect.setFont(new Font("�������", Font.PLAIN,30));
		paymentSelect.setForeground(Color.white);
		paymentSelect.setBounds(150, 110, 500, 250);
		
		JButton moneyBtn = new JButton(new ImageIcon("paymentmoney.png"));
		moneyBtn.setBounds(100, 320, 200, 200);
		moneyBtn.setBorderPainted(false); //��ư ���� ����
		moneyBtn.setFocusPainted(false); //��ư Ŭ�� ���� ����
		moneyBtn.setContentAreaFilled(false); //��ư ��� ����
		moneyBtn.setEnabled(false);
		
		cardBtn = new JButton(new ImageIcon("paymentcard.png"));
		cardBtn.addActionListener(this);
		cardBtn.setBounds(390, 320, 200, 200);
		cardBtn.setBorderPainted(false); //��ư ���� ����
		cardBtn.setFocusPainted(false); //��ư Ŭ�� ���� ����
		cardBtn.setContentAreaFilled(false); //��ư ��� ����
		
		backScreen = new JButton(new ImageIcon("back.png"));
		backScreen.addActionListener(this);
		backScreen.setBounds(290, 650, 115, 115);
		backScreen.setBorderPainted(false); //��ư ���� ����
		backScreen.setFocusPainted(false); //��ư Ŭ�� ���� ����
		backScreen.setContentAreaFilled(false); //��ư ��� ����
		
		this.add(paymentSelect);
		this.add(moneyBtn);
		this.add(cardBtn);
		this.add(backScreen);
	}
	private void settingTimer(){
		yesBtn = new JButton(new ImageIcon("check.png"));
		yesBtn.addActionListener(this);
		yesBtn.setBounds(100, 280, 100, 100);
		yesBtn.setBorderPainted(false); //��ư ���� ����
		yesBtn.setFocusPainted(false); //��ư Ŭ�� ���� ����
		yesBtn.setContentAreaFilled(false); //��ư ��� ����
		
		noBtn = new JButton(new ImageIcon("jump.png"));
		noBtn.addActionListener(this);
		noBtn.setBounds(390, 280, 100, 100);
		noBtn.setBorderPainted(false); //��ư ���� ����
		noBtn.setFocusPainted(false); //��ư Ŭ�� ���� ����
		noBtn.setContentAreaFilled(false); //��ư ��� ����
		
		this.add(yesBtn);
		this.add(noBtn);
		yesBtn.setVisible(false);
		noBtn.setVisible(false);
		
	}
	private void makeLastPage(){
		printBtn = new JButton(new ImageIcon("printer.png"));
		printBtn.addActionListener(this);
		printBtn.setBounds(300, 600, 100, 100);
		printBtn.setBorderPainted(false); //��ư ���� ����
		printBtn.setFocusPainted(false); //��ư Ŭ�� ���� ����
		printBtn.setContentAreaFilled(false); //��ư ��� ����

		
		completed = new JLabel();
		completed.setBounds(0, 100, 700, 800);
		completed.setIcon(img3);
		completed.add(printBtn);
		this.add(completed);
	}
	@Override
	public void actionPerformed(ActionEvent e) { //���� ������
		if(e.getSource() == cardBtn){
			this.removeAll();
			
			loding = new JLabel();
			loding.setIcon(img1);
			loding.setBounds(50, 180, 590, 400);
			
			this.add(loding);
			Time();
			this.repaint();
		}else if(e.getSource() == backScreen){// �ڷΰ��� ȭ�� ������ ������ �Է����ּ���
			mf.point_GuideToNext(1);
		}else if(e.getSource() == yesBtn){// ����Ʈ ���� ȭ��
			mf.point_GuideToNext(2);
		}else if(e.getSource() == noBtn){
			this.removeAll();
			makeLastPage();
			this.repaint();
		}else if(e.getSource() == printBtn){//ù ȭ������ ���ư���
			mf.point_GuideToNext(3);
		}
	}
	private void Time(){ // ī������ϴ���
		Timer timer = new Timer();
		TimerTask t_task = new TimerTask(){
				@Override
				public void run(){ // �����ϴ½ð�3�� �� ���� �̹����� ��ư
					
					loding.setIcon(img2);
					loding.add(yesBtn);
					loding.add(noBtn);
					yesBtn.setVisible(true);
					noBtn.setVisible(true);
				}
		};
		timer.schedule(t_task, 3000); // ������ 3��
	}
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);
		g.setColor(Color.WHITE);
		g.drawRect(50, 180, 590, 400);
		
	}
	
}