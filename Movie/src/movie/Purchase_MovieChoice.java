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

public class Purchase_MovieChoice extends JPanel implements ActionListener{
	private Image backgroundImage;
	private JButton btnBack;//  �ڷΰ��� ��ư
	private JButton btnmovie01, btnmovie02, btnmovie03; //��ȭ 
	private JPanel pnlBack;
		// �߾� ��� �г�
	private ImageIcon icon01, icon02, icon03; // ��ȭ ������
	Main_Frame mf;	
	
	public Purchase_MovieChoice(Main_Frame mf){
		this.mf=mf;
		/**Ʋ ���*/
		this.setSize(700,1000);
		this.setLayout(new BorderLayout());
		
		try {
			backgroundImage = ImageIO.read(new File("Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
			//ȭ�鱸��
		makeDown();
		makeCenter();
		
		
		
	}
	private void putImage(){ //�̹��� ���̱� �۾�
		ImageIcon img1 = new ImageIcon("1.jpg");
		Image originImg01 = img1.getImage();
		Image changeImg01 = originImg01.getScaledInstance(200, 250, Image.SCALE_SMOOTH);
		icon01 = new ImageIcon(changeImg01);
		
		ImageIcon img2 = new ImageIcon("2.jpg");
		Image originImg02 = img2.getImage();
		Image changeImg02 = originImg02.getScaledInstance(200, 250, Image.SCALE_SMOOTH);
		icon02 = new ImageIcon(changeImg02);
		
		ImageIcon img3 = new ImageIcon("3.jpg");
		Image originImg03 = img3.getImage();
		Image changeImg03 = originImg03.getScaledInstance(200, 250, Image.SCALE_SMOOTH);
		icon03 = new ImageIcon(changeImg03);
	}
	
	private void makeCenter(){ //��� ȭ�� ���̱�
		pnlBack = new JPanel(new GridLayout(0,1));
		pnlBack.setBackground(new Color(255, 255, 255, 0));
		
		JPanel pnlUp = new JPanel();
		pnlUp.setLayout(null);
		pnlUp.setBackground(new Color(255, 255, 255, 0));
		
		JLabel lbText = new JLabel("������� ��ȭ�� �����ϼ���!");
		lbText.setBounds(160, 160, 500, 100);
		lbText.setFont(new Font("���� ���", Font.PLAIN,30));
		lbText.setForeground(Color.white);
		pnlUp.add(lbText);
		
		JPanel pnlMid = new JPanel(new GridLayout(0,3));
		pnlMid.setBackground(new Color(39,38,64));
		putImage(); //�̹��� ���̱� �۾� �޼ҵ�
		btnmovie01 = new JButton(icon01);
		btnmovie01.setBorderPainted(false);
		btnmovie01.setFocusPainted(false);
		btnmovie01.setContentAreaFilled(false);
		btnmovie01.addActionListener(this);
		btnmovie02 = new JButton(icon02);
		btnmovie02.setBorderPainted(false);
		btnmovie02.setFocusPainted(false);
		btnmovie02.setContentAreaFilled(false);
		btnmovie02.addActionListener(this);
		btnmovie03 = new JButton(icon03);
		btnmovie03.setBorderPainted(false);
		btnmovie03.setFocusPainted(false);
		btnmovie03.setContentAreaFilled(false);
		btnmovie03.addActionListener(this);
		
		pnlMid.add(btnmovie01);
		pnlMid.add(btnmovie02);
		pnlMid.add(btnmovie03);
		
		JPanel pnlDown = new JPanel();
		pnlDown.setBackground(new Color(39,38,64));
		pnlDown.setLayout(null);
		
		JLabel outback = new JLabel("");
		ImageIcon adoutback = new ImageIcon("outback.jpg");
		outback.setIcon(adoutback);
		outback.setBounds(1,100,700,200); // ��� �ƿ��� ����
		
		pnlDown.add(outback);
		
		pnlBack.add(pnlUp);
		pnlBack.add(pnlMid);
		pnlBack.add(pnlDown);
		this.add(pnlBack, "Center");
	}
	
	private void makeDown(){//�ؿ� ��ư ���̱�
		//�ؿ� ��ư �ֱ�
		JPanel pn = new JPanel(new BorderLayout());
		pn.setBackground(new Color(39,38,64));
		
		ImageIcon imgBtn1 = new ImageIcon("BACK_W.gif");
		Image image2 = imgBtn1.getImage();
		Image changeImage2 = image2.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImage2);
		btnBack = new JButton(changeIcon2);
		
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.addActionListener(this);
		
		pn.add(btnBack);
		this.add(pn,"South");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//��ư ȿ��
		if(e.getSource() == btnBack){
			mf.purchase_MovieChoiceToNext(4);
		} else if(e.getSource() == btnmovie01){
			mf.purchase_MovieChoiceToNext(1);
		} else if(e.getSource() == btnmovie02){
			mf.purchase_MovieChoiceToNext(2);
		} else if(e.getSource() == btnmovie03){
			mf.purchase_MovieChoiceToNext(3);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {	//�̹��� ������
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}
	
}
