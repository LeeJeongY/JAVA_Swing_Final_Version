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

public class Reservation_Ticket extends JPanel implements ActionListener{
	private JLabel title, time, placeOfMovie, seat, cusNum, ageGroup;
				// 0 ��ȭ ����, 1 �Ϲ�, 2 �Ϲ� �ο�, 3 �л�, 4 �л� �ο�,
				// 5 ��, 6 �ð�, 7 ��, 8 �¼���ȣ
	private JButton btnPrint, btnBack;
	
	private Image backgroundImage;
	public Main_Frame mf;
	String[] info ={};
	
	public Reservation_Ticket(Main_Frame mf, String[] s){ //������
		this.mf=mf;
		this.info = s;
		/**Ʋ ���*/
		this.setSize(700,1000);
		this.setLayout(new BorderLayout());
		
		//��� ȭ�� ������
		try {
			backgroundImage = ImageIO.read(new File("���ų������.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		buttonsPanel(); //��ư �г�
		contentsPanel();
		changeContents();
		
		
	}
	private void changeContents(){
		title.setText(info[0]);
		time.setText(info[6]);
		placeOfMovie.setText(info[5]);
		seat.setText(info[8]);
		cusNum.setText(info[2]);
		ageGroup.setText(info[1]);
	}
	private void buttonsPanel(){ //��ư �г�
		JPanel pnlBtn = new JPanel(new GridLayout(0,5)); 
		
		ImageIcon imgPrint = new ImageIcon("printer_W.gif");//����Ʈ ������ ������ ����
		Image image2 = imgPrint.getImage();
		Image changeImage2 = image2.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImage2);
		
		ImageIcon imgBack = new ImageIcon("BACK_W.gif");//�ڷ� ���� ������ ������ ����
		Image image3 = imgBack.getImage();
		Image changeImage3 = image3.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		ImageIcon changeIcon3 = new ImageIcon(changeImage3);
		
		btnPrint = new JButton(changeIcon2); //��ư ����, ������ �Է�
		btnBack = new JButton(changeIcon3);
		btnPrint.addActionListener(this); //�׼� ������ ���
		btnBack.addActionListener(this);
		btnPrint.setBorderPainted(false); //��ư ���� ����
		btnBack.setBorderPainted(false);
		btnPrint.setFocusPainted(false); //��ư Ŭ�� ���� ����
		btnBack.setFocusPainted(false);
		btnPrint.setContentAreaFilled(false); //��ư ��� ����
		btnBack.setContentAreaFilled(false);
		
		pnlBtn.add(new JLabel());
		pnlBtn.add(btnPrint);
		pnlBtn.add(new JLabel());
		pnlBtn.add(btnBack);
		pnlBtn.add(new JLabel());
		pnlBtn.setBackground(new Color(39,38,64));
		this.add(pnlBtn, "South");
	}

	private void contentsPanel(){ //���� �г�
		/**���� ä���*/
		JPanel pnlLb = new JPanel(); //���̺� �г�
		pnlLb.setLayout(null);
		pnlLb.setBackground(new Color(255, 255, 255, 0));    //����

		
		JLabel type = new JLabel("2D");
		JLabel age = new JLabel("12�� �̻�"); //���� ����
		title = new JLabel("����"); //����
		JLabel place = new JLabel("�λ� ����,"); //��ȭ�� ��ġ
		JLabel Date = new JLabel("2020-11-25"); //��¥
		time = new JLabel("�ð�"); //�ð� ��
		placeOfMovie = new JLabel("�󿵰� �̸�(����)"); // �󿵰� �̸�
		seat = new JLabel("�¼�"); //�¼�
		cusNum = new JLabel("0��"); //�����ο�
		ageGroup = new JLabel("(�л�/�Ϲ�)"); // ���/�л�/�Ϲ�
		
		
		ImageIcon imageQR = new ImageIcon("qr.png");//qr ��ư �̹��� ����
		Image image4 = imageQR.getImage();
		Image changeImage4 = image4.getScaledInstance(180,180, Image.SCALE_SMOOTH);
		ImageIcon changeIcon4 = new ImageIcon(changeImage4);

		JButton btnQR = new JButton(changeIcon4);
		btnQR.setBorderPainted(false);
		btnQR.setFocusPainted(false);
		btnQR.setContentAreaFilled(false);
		
		type.setForeground(Color.white);
		age.setForeground(Color.white);
		title.setForeground(Color.white);
		place.setForeground(Color.white);
		Date.setForeground(Color.white);
		time.setForeground(Color.white);
		placeOfMovie.setForeground(Color.white);
		seat.setForeground(Color.white);
		cusNum.setForeground(Color.white);
		ageGroup.setForeground(Color.white);
		
		
		type.setBounds(170,170,100,100);
		age.setBounds(440,170,100,100);
		title.setBounds(170,210,300,150);
		place.setBounds(170,290,300,150);
		Date.setBounds(260,290,300,150);
		time.setBounds(170,325,300,150);
		placeOfMovie.setBounds(170,380,300,150);
		seat.setBounds(170,415,300,150);
		cusNum.setBounds(170,480,300,150);
		ageGroup.setBounds(220,480,300,150);
		btnQR.setBounds(260,590,180,180);
		
		
		type.setFont(new Font("�޸�����ü", Font.PLAIN,25));
		age.setFont(new Font("�޸�����ü", Font.PLAIN,25));
		title.setFont(new Font("�޸�����ü", Font.PLAIN,35));
		place.setFont(new Font("�޸�����ü", Font.PLAIN,20));
		Date.setFont(new Font("�޸�����ü", Font.PLAIN,20));
		time.setFont(new Font("�޸�����ü", Font.PLAIN,20));
		placeOfMovie.setFont(new Font("�޸�����ü", Font.PLAIN,20));
		seat.setFont(new Font("�޸�����ü", Font.PLAIN,20));
		ageGroup.setFont(new Font("�޸�����ü", Font.PLAIN,20));
		cusNum.setFont(new Font("�޸�����ü", Font.PLAIN,20));
		
		
		
		pnlLb.add(type);
		pnlLb.add(age);
		pnlLb.add(title);
		pnlLb.add(place);
		pnlLb.add(Date);
		pnlLb.add(time);
		pnlLb.add(placeOfMovie);
		pnlLb.add(seat);
		pnlLb.add(ageGroup);
		pnlLb.add(cusNum);
		pnlLb.add(btnQR);
		this.add(pnlLb);
	}
	
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnPrint){ //��� ȭ������
			mf.reservation_TicketToNext(1);
		}else if(e.getSource() == btnBack){ //�ڷΰ���
			mf.reservation_TicketToNext(2);
		}
	}
}
