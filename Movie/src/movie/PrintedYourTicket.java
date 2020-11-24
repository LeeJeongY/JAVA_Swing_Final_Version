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

public class PrintedYourTicket extends JPanel implements ActionListener{
	private Image backgroundImage;
	private JButton okBtn;
	Main_Frame mf;
	
	public PrintedYourTicket(Main_Frame mf){
		this.mf = mf;
		this.setSize(700,1000);
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
		JPanel nor = new JPanel();
		nor.setLayout(null);
		nor.setBackground(new Color(39,38,64,0));
		ImageIcon imgwarn = new ImageIcon("print (1).png");//프린트 아이콘 사이즈 조절
		Image imagewarn = imgwarn.getImage();
		Image changewarn = imagewarn.getScaledInstance(230,230, Image.SCALE_SMOOTH);
		ImageIcon iconwarn = new ImageIcon(changewarn);
		JButton btn1 = new JButton(iconwarn);
		btn1.setBounds(230,90,230,230);
		btn1.setBorderPainted(false);
		btn1.setFocusPainted(false);
		btn1.setContentAreaFilled(false);
		nor.add(btn1);
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
		JLabel lb = new JLabel("티켓 출력이 완료되었습니다.");
		lb.setForeground(Color.white);
		lb.setFont(new Font("맑은 고딕", Font.PLAIN,30));
		lb.setBounds(60, 10, 500, 100);
		midInside.add(lb);
		okBtn = new JButton("확인");
		okBtn.setBackground(new Color(39,38,64));
		okBtn.setForeground(Color.white);
		okBtn.setFont(new Font("맑은 고딕", Font.PLAIN,50));
		okBtn.setBounds(90, 150, 300, 80);
		okBtn.setBorderPainted(false);
		okBtn.setFocusPainted(false);
		okBtn.addActionListener(this);
		midInside.add(okBtn);
		mid.add(midInside);
		this.add(mid);
	}
	private void southPnl(){
		JPanel sou = new JPanel();
		sou.setBackground(new Color(39,38,64));
		this.add(sou);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //주차등록 질문 패널로
		mf.printedYourTicketToNext();
	}
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}

}
