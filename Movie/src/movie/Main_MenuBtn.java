package movie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main_MenuBtn extends JPanel implements ActionListener,MouseListener{
	private Image backgroundImage;
	private JButton btnReservation, btnPurchase, btnPopcon, btnPoint;
	private JLabel lblReservation, lblPurchase, lblPopcon, lblPoint;
	private int firstMenuNum;
	public ChangeImage change;
	Main_Frame mf;
	
	public Main_MenuBtn(Main_Frame mf){
		try {
			backgroundImage = ImageIO.read(new File("Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.mf=mf;
		this.setLayout(null);
		poster(); //������ �޼ҵ�
		buttons(); //��ư �޼ҵ�
		
		change = new ChangeImage();
		change.setBounds(120,125,450,620);
		this.add(change);
		this.revalidate();
		this.repaint();
	}
	private void poster(){//������
		ImageIcon movie1 = new ImageIcon("movie1.jpg"); 
		JLabel lblmv1 = new JLabel(movie1);
		lblmv1.setBounds(120,125,450,620);
		this.add(lblmv1);
	}

	private void buttons(){ //��ư
		JPanel pnl_btn = new JPanel();
		pnl_btn.setBounds(0, 800, 700, 200);
		pnl_btn.setBackground(new Color(39,38,64));
		
		ImageIcon ticket1 = new ImageIcon("ticket.png");  //��ư �̹��� ���̱�
		ImageIcon reservation1 = new ImageIcon("reservation.png"); 
		ImageIcon popcon1 = new ImageIcon("popcon.png");
		ImageIcon point1 = new ImageIcon("001-cash-flow.png");
		
		Image originImg01 = ticket1.getImage();
		Image changeImg01 = originImg01.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon ticket = new ImageIcon(changeImg01);
		
		Image originImg02 = reservation1.getImage();
		Image changeImg02 = originImg02.getScaledInstance(110, 110, Image.SCALE_SMOOTH);
		ImageIcon reservation = new ImageIcon(changeImg02);
		
		Image originImg03 = popcon1.getImage();
		Image changeImg03 = originImg03.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon popcon = new ImageIcon(changeImg03);
		
		Image originImg04 = point1.getImage();
		Image changeImg04 = originImg04.getScaledInstance(110, 110, Image.SCALE_SMOOTH);
		ImageIcon point = new ImageIcon(changeImg04);
		
		btnReservation = new JButton(reservation); //��ư �ʱ�ȭ
		btnPurchase = new JButton(ticket);
		btnPopcon = new JButton(popcon);
		btnPoint = new JButton(point);
		
		btnReservation.addActionListener(this); //��ư �׼� ������
		btnPurchase.addActionListener(this);
		btnPopcon.addActionListener(this);
		btnPoint.addActionListener(this);
		
		btnReservation.addMouseListener(this); //��ư ���콺 ������
		btnPurchase.addMouseListener(this);
		btnPopcon.addMouseListener(this);
		btnPoint.addMouseListener(this);
		
		btnReservation.setBorderPainted(false); //��ư ���� ����
		btnPurchase.setBorderPainted(false);
		btnPopcon.setBorderPainted(false);
		btnPoint.setBorderPainted(false);
		
		btnReservation.setFocusPainted(false); //��ư Ŭ�� ���� ����
		btnPurchase.setFocusPainted(false);
		btnPopcon.setFocusPainted(false);
		btnPoint.setFocusPainted(false);
		
		btnReservation.setContentAreaFilled(false); //��ư ��� ����
		btnPurchase.setContentAreaFilled(false);
		btnPopcon.setContentAreaFilled(false);
		btnPoint.setContentAreaFilled(false);
		
		lblReservation = new JLabel("����Ȯ��"); //�󺧻���
		lblPurchase = new JLabel("���屸��");
		lblPopcon = new JLabel("�޺�����");
		lblPoint = new JLabel("����ƮȮ��");
		
		lblReservation.setBounds(100, 770, 100, 50); //�� ��ġ ������
		lblPurchase.setBounds(250, 770, 100, 50);
		lblPopcon.setBounds(400, 770, 100, 50);
		lblPoint.setBounds(540, 770, 100, 50);
		
		lblReservation.setForeground(Color.white);//��Ʈ���� ���
		lblPurchase.setForeground(Color.white);
		lblPopcon.setForeground(Color.white);
		lblPoint.setForeground(Color.white);
		
		lblReservation.addMouseListener(this); //�� ���콺 ������
		lblPurchase.addMouseListener(this);
		lblPopcon.addMouseListener(this);
		lblPoint.addMouseListener(this);
		
		pnl_btn.add(btnReservation); //��ư�гο� ��ư ���̱�
		pnl_btn.add(btnPurchase);
		pnl_btn.add(btnPopcon);
		pnl_btn.add(btnPoint);
		
		this.add(pnl_btn); //��ư�гκ��̱�
		this.add(lblReservation); //���� �� ���̱�
		this.add(lblPurchase);
		this.add(lblPopcon);
		this.add(lblPoint);
		lblReservation.setVisible(false);// ó�� ȭ�� �ε� �� ���� �Ⱥ��̱�
		lblPurchase.setVisible(false);
		lblPopcon.setVisible(false);
		lblPoint.setVisible(false);
		this.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReservation){
			firstMenuNum = 1;
		} else if (e.getSource() == btnPurchase){
			firstMenuNum = 2;
		} else if (e.getSource() == btnPopcon){
			firstMenuNum = 3;
		} else if( e.getSource() == btnPoint){
			firstMenuNum = 4;
		}
		mf.firstMenuToNext(firstMenuNum);
	}
	@Override public void mouseEntered(MouseEvent arg0) { //��ư�� Ŀ���� �ö󰥶�
		if(arg0.getSource()==btnReservation) {
			lblReservation.setVisible(true);
			lblPurchase.setVisible(false);
			lblPopcon.setVisible(false);
			lblPoint.setVisible(false);
			
		}else if(arg0.getSource()==btnPurchase) {
			lblPurchase.setVisible(true);
			lblReservation.setVisible(false);
			lblPopcon.setVisible(false);
			lblPoint.setVisible(false);
			
		}else if(arg0.getSource()==btnPopcon) {
			lblPopcon.setVisible(true);
			lblReservation.setVisible(false);
			lblPurchase.setVisible(false);
			lblPoint.setVisible(false);
			
		}else if(arg0.getSource()==btnPoint) {
			lblPoint.setVisible(true);
			lblReservation.setVisible(false);
			lblPurchase.setVisible(false);
			lblPopcon.setVisible(false);
		}
		
	}
	@Override public void mouseExited(MouseEvent arg0) { //Ŀ���� ��ư���� ��������
		if(arg0.getSource()==btnReservation) {
			lblReservation.setVisible(false);

		}else if(arg0.getSource()==btnPurchase) {
			lblPurchase.setVisible(false);
			
		}else if(arg0.getSource()==btnPopcon) {
			lblPopcon.setVisible(false);
		}
		else if(arg0.getSource()==btnPoint) {
			lblPoint.setVisible(false);
		}
	}
	@Override public void mouseClicked(MouseEvent arg0) {}
	@Override public void mousePressed(MouseEvent arg0) {}
	@Override public void mouseReleased(MouseEvent arg0) {}

}


class ChangeImage extends JPanel{
	private ImageIcon icon1,icon2,icon3;
	private JLabel lbl;
	private int i;
	
	public ChangeImage() {
		icon1 = new ImageIcon("movie1.jpg");
		icon2 = new ImageIcon("movie2.jpg");
		icon3 = new ImageIcon("movie3.jpg");
		
		lbl = new JLabel(icon1);
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(i==0){
					lbl.setIcon(icon1);
					i++;
				}else if(i==1){
					lbl.setIcon(icon2);
					i++;
				}else if(i==2){
					lbl.setIcon(icon3);
					i=0;;
				}
			}
		};
		
		Timer timer = new Timer(2000,al);
		timer.start();		
		
		this.setLayout(null);
		this.add(lbl);
		lbl.setBounds(0,0,450,620);
		this.setVisible(true);
	}
}
