package movie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.SwingConstants;

public class MembershipPointCheck_InputNum extends JPanel implements ActionListener{
	private JButton num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, backSpace, backScreen, clear;
	private Image backgroundImage; // ����̹���
	private String str = ""; // Ƽ�Ϲ�ȣ ����� ��»���
	
	Main_Frame mf;
	public JLabel ticketNum; // Ƽ���Է¹޴°�
	public JLabel lbWarn;
	
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}
	
	public MembershipPointCheck_InputNum(Main_Frame mf){ // ������
		this.setLayout(null);
		this.mf=mf;
		
		try {
			backgroundImage = ImageIO.read(new File("����ƮȮ��Ű�е�.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		makePlaceToInput();
		settingBtn();
	}
	
	private void makePlaceToInput(){ //�Է¹��� ���̺�
		ticketNum = new JLabel("",SwingConstants.CENTER);
		ticketNum.setBounds(200, 270, 300, 100);
		ticketNum.setFont(new Font("���� ���", Font.PLAIN,25));
		ticketNum.setForeground(Color.white);
		ticketNum.setOpaque(false);
		this.add(ticketNum);
		
		lbWarn = new JLabel("",SwingConstants.CENTER);
		lbWarn.setBounds(200, 345, 300, 100);
		lbWarn.setFont(new Font("���� ���", Font.PLAIN,25));
		lbWarn.setForeground(Color.red);
		lbWarn.setOpaque(false);
		this.add(lbWarn);
	}
	
	private void settingBtn(){ //��ư �ٹ̱�
		num1 = new JButton("1");
		num1.addActionListener(this);
		num1.setFont(new Font("���� ���", Font.PLAIN,40));
		num1.setBounds(120, 450, 100, 100);
		num1.setForeground(Color.white);
		num1.setBorderPainted(false); //��ư ���� ����
		num1.setFocusPainted(false); //��ư Ŭ�� ���� ����
		num1.setContentAreaFilled(false); //��ư ��� ����
		
		num2 = new JButton("2");
		num2.addActionListener(this);
		num2.setFont(new Font("���� ���", Font.PLAIN,40));
		num2.setBounds(300, 450, 100, 100);
		num2.setForeground(Color.white);
		num2.setBorderPainted(false); //��ư ���� ����
		num2.setFocusPainted(false); //��ư Ŭ�� ���� ����
		num2.setContentAreaFilled(false); //��ư ��� ����
		
		num3 = new JButton("3");
		num3.addActionListener(this);
		num3.setFont(new Font("���� ���", Font.PLAIN,40));
		num3.setBounds(480, 450, 100, 100);
		num3.setForeground(Color.white);
		num3.setBorderPainted(false); //��ư ���� ����
		num3.setFocusPainted(false); //��ư Ŭ�� ���� ����
		num3.setContentAreaFilled(false); //��ư ��� ����
	
		num4 = new JButton("4");		
		num4.addActionListener(this);
		num4.setFont(new Font("���� ���", Font.PLAIN,40));
		num4.setBounds(120, 550, 100, 100);
		num4.setForeground(Color.white);
		num4.setBorderPainted(false); //��ư ���� ����
		num4.setFocusPainted(false); //��ư Ŭ�� ���� ����
		num4.setContentAreaFilled(false); //��ư ��� ����
		
		num5 = new JButton("5");
		num5.addActionListener(this);
		num5.setFont(new Font("���� ���", Font.PLAIN,40));
		num5.setBounds(300, 550, 100, 100);
		num5.setForeground(Color.white);
		num5.setBorderPainted(false); //��ư ���� ����
		num5.setFocusPainted(false); //��ư Ŭ�� ���� ����
		num5.setContentAreaFilled(false); //��ư ��� ����
		
		num6 = new JButton("6");
		num6.addActionListener(this);
		num6.setFont(new Font("���� ���", Font.PLAIN,40));
		num6.setBounds(480, 550, 100, 100);
		num6.setForeground(Color.white);
		num6.setBorderPainted(false); //��ư ���� ����
		num6.setFocusPainted(false); //��ư Ŭ�� ���� ����
		num6.setContentAreaFilled(false); //��ư ��� ����
		
		num7 = new JButton("7");
		num7.addActionListener(this);
		num7.setFont(new Font("���� ���", Font.PLAIN,40));
		num7.setBounds(120, 650, 100, 100);
		num7.setForeground(Color.white);
		num7.setBorderPainted(false); //��ư ���� ����
		num7.setFocusPainted(false); //��ư Ŭ�� ���� ����
		num7.setContentAreaFilled(false); //��ư ��� ����
		
		num8 = new JButton("8");
		num8.addActionListener(this);
		num8.setFont(new Font("���� ���", Font.PLAIN,40));
		num8.setBounds(300, 650, 100, 100);
		num8.setForeground(Color.white);
		num8.setBorderPainted(false); //��ư ���� ����
		num8.setFocusPainted(false); //��ư Ŭ�� ���� ����
		num8.setContentAreaFilled(false); //��ư ��� ����
		
		num9 = new JButton("9");
		num9.addActionListener(this);
		num9.setFont(new Font("���� ���", Font.PLAIN,40));
		num9.setBounds(480, 650, 100, 100);
		num9.setForeground(Color.white);
		num9.setBorderPainted(false); //��ư ���� ����
		num9.setFocusPainted(false); //��ư Ŭ�� ���� ����
		num9.setContentAreaFilled(false); //��ư ��� ����
		
		backSpace = new JButton("�����");
		backSpace.addActionListener(this);
		backSpace.setFont(new Font("���� ���", Font.PLAIN,20));
		backSpace.setBounds(120, 750, 100, 100);
		backSpace.setForeground(Color.white);
		backSpace.setBorderPainted(false); //��ư ���� ����
		backSpace.setFocusPainted(false); //��ư Ŭ�� ���� ����
		backSpace.setContentAreaFilled(false); //��ư ��� ����
		
		num0 = new JButton("0");
		num0.addActionListener(this);
		num0.setFont(new Font("���� ���", Font.PLAIN,40));
		num0.setBounds(300, 750, 100, 100);
		num0.setForeground(Color.white);
		num0.setBorderPainted(false); //��ư ���� ����
		num0.setFocusPainted(false); //��ư Ŭ�� ���� ����
		num0.setContentAreaFilled(false); //��ư ��� ����
		
		ImageIcon iconHome = new ImageIcon("home_w_s.gif");
		backScreen = new JButton(iconHome);
		backScreen.addActionListener(this);
		backScreen.setBounds(460, 750, 150, 100);
		backScreen.setBorderPainted(false); //��ư ���� ����
		backScreen.setFocusPainted(false); //��ư Ŭ�� ���� ����
		backScreen.setContentAreaFilled(false); //��ư ��� ����
		
		clear = new JButton("Ȯ��");
		clear.addActionListener(this);
		clear.setFont(new Font("���� ���", Font.PLAIN,35));
		clear.setBounds(200, 887, 300, 70);
		clear.setForeground(Color.white);
		clear.setBorderPainted(false); //��ư ���� ����
		clear.setFocusPainted(false); //��ư Ŭ�� ���� ����
		clear.setContentAreaFilled(false); //��ư ��� ����
		
		
		this.add(num1);
		this.add(num2);
		this.add(num3);
		this.add(num4);
		this.add(num5);
		this.add(num6);
		this.add(num7);
		this.add(num8);
		this.add(num9);
		this.add(backSpace);
		this.add(num0);
		this.add(backScreen);
		this.add(clear);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backSpace){ //�����
			ticketNum.setText((ticketNum.getText()).substring(0, ticketNum.getText().length()-1));
			str = ticketNum.getText();
		}else if(e.getSource() == backScreen){ //����ȭ������
			mf.membershipPointCheck_InputNumToNext(1);
		}else if(e.getSource() == clear){ //������ ���� ȭ��(2)���� Ʋ����  Ʋ���ٴ� ȭ��(3)����
			String s = ticketNum.getText();
			if (lbWarn.getText() != ""){ //���â �ʱ�ȭ
				lbWarn.setText("");
			}
			if (s.length()!=11){
				lbWarn.setText("* 11�ڸ��� �Է��� �ּ���.");
			} else {
				if (s.equals("01012345678")){ //�Է��� ���� ������
					mf.membershipPointCheck_InputNumToNext(2);
				} else{ //�Է��� ���� Ʋ����
					lbWarn.setText("* ���� ��ȣ �Դϴ�.");
				}
			}
		}else{
			JButton btn = (JButton) e.getSource(); // �۵��� �׼��� ��ưŸ�� btn�� ����
			str = str+btn.getActionCommand(); // str�� ��»��� = ���簪 + ������ư�� �̸�
			ticketNum.setText(str);
		}

	}
}
