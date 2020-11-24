package movie;

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

public class Purchase_PointGuide extends JPanel implements ActionListener{
	private Image backgroundImage;
	private JButton btnYes, btnNo;
	Main_Frame mf;
	ParkingDialog pd;
	
	public Purchase_PointGuide(Main_Frame mf) {
		this.mf = mf;
		
		this.setSize(700, 1000);
		this.setLayout(new GridLayout(0,1));
		
		try {
			backgroundImage = ImageIO.read(new File("Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		northPnl();
		midlePnl();
		southPnl();
	}
	
	private void northPnl(){
		JPanel nor = new JPanel(new GridLayout(0,1));
		nor.setBackground(new Color(255, 0, 0, 0));
		
		JPanel nor1 = new JPanel();
		JPanel nor2 = new JPanel();
		nor1.setBackground(new Color(255, 0, 0, 0));
		nor2.setBackground(new Color(39,38,64));
		
		ImageIcon imgpark = new ImageIcon("001-cash-flow.png");//프린트 아이콘 사이즈 조절
		Image imagepark = imgpark.getImage();
		Image changepark = imagepark.getScaledInstance(130,130, Image.SCALE_SMOOTH);
		ImageIcon iconPark = new ImageIcon(changepark);
		JButton btn1 = new JButton(iconPark);
		btn1.setBounds(270,10,130,130);
		btn1.setBorderPainted(false);
		btn1.setFocusPainted(false);
		btn1.setContentAreaFilled(false);
		
		nor2.add(btn1);
		
		nor.add(nor1);
		nor.add(nor2);
		this.add(nor);
	}
	private void midlePnl(){
		JPanel mid = new JPanel();
		mid.setLayout(null);
		mid.setBackground(new Color(39,38,64));
		
		JPanel midInside = new JPanel();
		midInside.setLayout(null);
		midInside.setBounds(90,0,500,500);
		midInside.setBackground(new Color(6,90,96));
		JLabel lb = new JLabel("포인트 적립 하시겠습니까?");
		lb.setForeground(Color.white);
		lb.setFont(new Font("맑은 고딕", Font.PLAIN,30));
		lb.setBounds(90, 20, 500, 100);
		
		btnYes = new JButton("예");
		btnYes.setBackground(new Color(39,38,64));
		btnYes.setForeground(Color.white);
		btnYes.setFont(new Font("맑은 고딕", Font.PLAIN,50));
		btnYes.setBounds(45, 160, 200, 80);
		btnYes.setBorderPainted(false);
		btnYes.setFocusPainted(false);
		btnYes.addActionListener(this);
		
		btnNo = new JButton("아니오");
		btnNo.setBackground(new Color(39,38,64));
		btnNo.setForeground(Color.white);
		btnNo.setFont(new Font("맑은 고딕", Font.PLAIN,50));
		btnNo.setBounds(260, 160, 200, 80);
		btnNo.setBorderPainted(false); //버튼 라인 삭제
		btnNo.setFocusPainted(false); //버튼 클릭 라인 삭제
		btnNo.addActionListener(this);

		midInside.add(lb);
		midInside.add(btnYes);
		midInside.add(btnNo);
		
		mid.add(midInside);
		this.add(mid);
	}
	private void southPnl(){
		JPanel sou = new JPanel();
		sou.setBackground(new Color(39,38,64));

		this.add(sou);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnYes) {//포인트 적립칸
			mf.purchase_PointGuideToNext(1);
		} else if(e.getSource() == btnNo){//출력
			mf.purchase_PointGuideToNext(2);
		}
	}
}
