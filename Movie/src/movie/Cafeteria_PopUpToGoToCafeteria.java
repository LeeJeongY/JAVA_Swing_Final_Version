package movie;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Cafeteria_PopUpToGoToCafeteria extends JPanel implements ActionListener{
	private Image backgroundImage;
	private JButton cancel, order; //하단 버튼
	Main_Frame mf;
	
	public Cafeteria_PopUpToGoToCafeteria(Main_Frame mf){
		try {
			backgroundImage = ImageIO.read(new File("메뉴 화면.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.mf = mf;
		this.setSize(700,1000);
		this.setLayout(null);
		Buttons();
	}
	private void Buttons(){
		ImageIcon originalIcon1 = new ImageIcon("home_w.gif");
		ImageIcon originalIcon2 = new ImageIcon("체크_흰색.gif");
		Image originImg01 = originalIcon1.getImage();
		Image originImg02 = originalIcon2.getImage();
		Image changeImg01 = originImg01.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		Image changeImg02 = originImg02.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon back = new ImageIcon(changeImg01);
		ImageIcon check = new ImageIcon(changeImg02);
		
		cancel = new JButton(back); // 좌측 취소 버튼
		order = new JButton(check); // 우측 주문 버튼
		
		cancel.setBorderPainted(false);
		order.setBorderPainted(false);
		cancel.setContentAreaFilled(false);
		order.setContentAreaFilled(false);
		cancel.setFocusPainted(false);
		order.setFocusPainted(false);
		cancel.setBounds(40, 885, 200, 80);
		order.setBounds(450, 885, 200, 80);
		cancel.addActionListener(this); 
		order.addActionListener(this); 
	
		this.add(order);
		this.add(cancel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancel) { //홈화면으로 간다
			mf.cafeteria_PopUpToGoToCafeteriaToNext(1);
		}else { //매점화면으로 간다
			mf.cafeteria_PopUpToGoToCafeteriaToNext(2);
		} 
	}
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}

}
