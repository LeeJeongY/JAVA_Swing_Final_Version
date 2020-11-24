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

public class Purchase_Ticket extends JPanel implements ActionListener{
	private JLabel title, place, time, placeOfMovie, seat, cusNum, ageGroup;
	private JButton btnPrint, btnBack;
	private Image backgroundImage;
	private JPanel pnlLb;
	private String[] data; //�޴� �迭
	private String[] dataToPay  = new String[2]; //����â�� ���� �ִ� �迭
	Main_Frame mf;

	
	public Purchase_Ticket(Main_Frame mf, String data[]){ //������
		this.mf = mf;
		this.data = data;
		/**Ʋ ���*/
		this.setSize(700,1000);
		this.setLayout(new BorderLayout());
		
		//��� ȭ�� ������
		try {
			backgroundImage = ImageIO.read(new File("���ų������.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	
		makeButtons(); //��ư �г�
		
		/**���� ä���*/
		makeTickets(); //Ƽ�ϸ����
		settingTikcet(data); //Ƽ�� ���� ����
		
		
	}
	private void makeButtons(){
		JPanel pnlBtn = new JPanel(new GridLayout(0,5)); //��ư �г�
		
		ImageIcon imgPrint = new ImageIcon("credit-card-w.gif");//����Ʈ ������ ������ ����
		Image image2 = imgPrint.getImage();
		Image changeImage2 = image2.getScaledInstance(100,100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImage2);
		
		ImageIcon imgBack = new ImageIcon("BACK_W.gif");//�ڷ� ���� ������ ������ ����
		Image image3 = imgBack.getImage();
		Image changeImage3 = image3.getScaledInstance(100,100, Image.SCALE_SMOOTH);
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
	
	private void makeTickets(){
		pnlLb = new JPanel(); //���̺� �г�
		pnlLb.setLayout(null);
		pnlLb.setBackground(new Color(255, 255, 255, 0));    //����

		
		JLabel type = new JLabel("2D");
		JLabel age = new JLabel("12�� �̻�"); //���� ����
		title = new JLabel("����"); //����
		place = new JLabel("�λ� ����,"); //��ȭ�� ��ġ
		JLabel Date = new JLabel("2020-11-25"); //��¥
		time = new JLabel("�ð�"); //�ð� ��
		placeOfMovie = new JLabel("�󿵰� �̸�(����)"); // �󿵰� �̸� & ����
		seat = new JLabel("�¼�"); //�¼�
		cusNum = new JLabel("��"); //�����ο�
		ageGroup = new JLabel("(�л�/����)"); // ���/�л�/����
		
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
		seat.setBounds(160,415,300,150);
		cusNum.setBounds(170,480,300,150);
		ageGroup.setBounds(300,480,300,150);
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
	
	void settingTikcet(String[] d){ //Ƽ�Ͽ� �� �޾ƿ���
		title.setText(data[0]);
		time.setText(data[1]);
		placeOfMovie.setText(data[2]);
		seat.setText(data[3]);
		cusNum.setText("�����ο� "+data[4]+"��");
		ageGroup.setText("�Ϲ�"+data[5]+", �л�"+data[6]);
		
		dataToPay[0] = data[5];//�Ϲ� �ο� ��
		dataToPay[1] = data[6];//�л� �ο� ��
	}
	
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnPrint){
			mf.purchase_TicketToNext(1,dataToPay);
		}else if(e.getSource() == btnBack){ //���� ȭ������ ���ư���
			mf.purchase_TicketToNext(2,dataToPay);
		}
	}
	
}
