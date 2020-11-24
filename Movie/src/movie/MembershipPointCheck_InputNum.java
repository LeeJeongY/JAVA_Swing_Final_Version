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
	private Image backgroundImage; // 배경이미지
	private String str = ""; // 티켓번호 지우고 담는상자
	
	Main_Frame mf;
	public JLabel ticketNum; // 티켓입력받는곳
	public JLabel lbWarn;
	
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}
	
	public MembershipPointCheck_InputNum(Main_Frame mf){ // 생성자
		this.setLayout(null);
		this.mf=mf;
		
		try {
			backgroundImage = ImageIO.read(new File("포인트확인키패드.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		makePlaceToInput();
		settingBtn();
	}
	
	private void makePlaceToInput(){ //입력받을 레이블
		ticketNum = new JLabel("",SwingConstants.CENTER);
		ticketNum.setBounds(200, 270, 300, 100);
		ticketNum.setFont(new Font("맑은 고딕", Font.PLAIN,25));
		ticketNum.setForeground(Color.white);
		ticketNum.setOpaque(false);
		this.add(ticketNum);
		
		lbWarn = new JLabel("",SwingConstants.CENTER);
		lbWarn.setBounds(200, 345, 300, 100);
		lbWarn.setFont(new Font("맑은 고딕", Font.PLAIN,25));
		lbWarn.setForeground(Color.red);
		lbWarn.setOpaque(false);
		this.add(lbWarn);
	}
	
	private void settingBtn(){ //버튼 꾸미기
		num1 = new JButton("1");
		num1.addActionListener(this);
		num1.setFont(new Font("맑은 고딕", Font.PLAIN,40));
		num1.setBounds(120, 450, 100, 100);
		num1.setForeground(Color.white);
		num1.setBorderPainted(false); //버튼 라인 삭제
		num1.setFocusPainted(false); //버튼 클릭 라인 삭제
		num1.setContentAreaFilled(false); //버튼 배경 삭제
		
		num2 = new JButton("2");
		num2.addActionListener(this);
		num2.setFont(new Font("맑은 고딕", Font.PLAIN,40));
		num2.setBounds(300, 450, 100, 100);
		num2.setForeground(Color.white);
		num2.setBorderPainted(false); //버튼 라인 삭제
		num2.setFocusPainted(false); //버튼 클릭 라인 삭제
		num2.setContentAreaFilled(false); //버튼 배경 삭제
		
		num3 = new JButton("3");
		num3.addActionListener(this);
		num3.setFont(new Font("맑은 고딕", Font.PLAIN,40));
		num3.setBounds(480, 450, 100, 100);
		num3.setForeground(Color.white);
		num3.setBorderPainted(false); //버튼 라인 삭제
		num3.setFocusPainted(false); //버튼 클릭 라인 삭제
		num3.setContentAreaFilled(false); //버튼 배경 삭제
	
		num4 = new JButton("4");		
		num4.addActionListener(this);
		num4.setFont(new Font("맑은 고딕", Font.PLAIN,40));
		num4.setBounds(120, 550, 100, 100);
		num4.setForeground(Color.white);
		num4.setBorderPainted(false); //버튼 라인 삭제
		num4.setFocusPainted(false); //버튼 클릭 라인 삭제
		num4.setContentAreaFilled(false); //버튼 배경 삭제
		
		num5 = new JButton("5");
		num5.addActionListener(this);
		num5.setFont(new Font("맑은 고딕", Font.PLAIN,40));
		num5.setBounds(300, 550, 100, 100);
		num5.setForeground(Color.white);
		num5.setBorderPainted(false); //버튼 라인 삭제
		num5.setFocusPainted(false); //버튼 클릭 라인 삭제
		num5.setContentAreaFilled(false); //버튼 배경 삭제
		
		num6 = new JButton("6");
		num6.addActionListener(this);
		num6.setFont(new Font("맑은 고딕", Font.PLAIN,40));
		num6.setBounds(480, 550, 100, 100);
		num6.setForeground(Color.white);
		num6.setBorderPainted(false); //버튼 라인 삭제
		num6.setFocusPainted(false); //버튼 클릭 라인 삭제
		num6.setContentAreaFilled(false); //버튼 배경 삭제
		
		num7 = new JButton("7");
		num7.addActionListener(this);
		num7.setFont(new Font("맑은 고딕", Font.PLAIN,40));
		num7.setBounds(120, 650, 100, 100);
		num7.setForeground(Color.white);
		num7.setBorderPainted(false); //버튼 라인 삭제
		num7.setFocusPainted(false); //버튼 클릭 라인 삭제
		num7.setContentAreaFilled(false); //버튼 배경 삭제
		
		num8 = new JButton("8");
		num8.addActionListener(this);
		num8.setFont(new Font("맑은 고딕", Font.PLAIN,40));
		num8.setBounds(300, 650, 100, 100);
		num8.setForeground(Color.white);
		num8.setBorderPainted(false); //버튼 라인 삭제
		num8.setFocusPainted(false); //버튼 클릭 라인 삭제
		num8.setContentAreaFilled(false); //버튼 배경 삭제
		
		num9 = new JButton("9");
		num9.addActionListener(this);
		num9.setFont(new Font("맑은 고딕", Font.PLAIN,40));
		num9.setBounds(480, 650, 100, 100);
		num9.setForeground(Color.white);
		num9.setBorderPainted(false); //버튼 라인 삭제
		num9.setFocusPainted(false); //버튼 클릭 라인 삭제
		num9.setContentAreaFilled(false); //버튼 배경 삭제
		
		backSpace = new JButton("지우기");
		backSpace.addActionListener(this);
		backSpace.setFont(new Font("맑은 고딕", Font.PLAIN,20));
		backSpace.setBounds(120, 750, 100, 100);
		backSpace.setForeground(Color.white);
		backSpace.setBorderPainted(false); //버튼 라인 삭제
		backSpace.setFocusPainted(false); //버튼 클릭 라인 삭제
		backSpace.setContentAreaFilled(false); //버튼 배경 삭제
		
		num0 = new JButton("0");
		num0.addActionListener(this);
		num0.setFont(new Font("맑은 고딕", Font.PLAIN,40));
		num0.setBounds(300, 750, 100, 100);
		num0.setForeground(Color.white);
		num0.setBorderPainted(false); //버튼 라인 삭제
		num0.setFocusPainted(false); //버튼 클릭 라인 삭제
		num0.setContentAreaFilled(false); //버튼 배경 삭제
		
		ImageIcon iconHome = new ImageIcon("home_w_s.gif");
		backScreen = new JButton(iconHome);
		backScreen.addActionListener(this);
		backScreen.setBounds(460, 750, 150, 100);
		backScreen.setBorderPainted(false); //버튼 라인 삭제
		backScreen.setFocusPainted(false); //버튼 클릭 라인 삭제
		backScreen.setContentAreaFilled(false); //버튼 배경 삭제
		
		clear = new JButton("확인");
		clear.addActionListener(this);
		clear.setFont(new Font("맑은 고딕", Font.PLAIN,35));
		clear.setBounds(200, 887, 300, 70);
		clear.setForeground(Color.white);
		clear.setBorderPainted(false); //버튼 라인 삭제
		clear.setFocusPainted(false); //버튼 클릭 라인 삭제
		clear.setContentAreaFilled(false); //버튼 배경 삭제
		
		
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
		if(e.getSource() == backSpace){ //지우기
			ticketNum.setText((ticketNum.getText()).substring(0, ticketNum.getText().length()-1));
			str = ticketNum.getText();
		}else if(e.getSource() == backScreen){ //메인화면으로
			mf.membershipPointCheck_InputNumToNext(1);
		}else if(e.getSource() == clear){ //맞으면 다음 화면(2)으로 틀리면  틀리다는 화면(3)으로
			String s = ticketNum.getText();
			if (lbWarn.getText() != ""){ //경고창 초기화
				lbWarn.setText("");
			}
			if (s.length()!=11){
				lbWarn.setText("* 11자리를 입력해 주세요.");
			} else {
				if (s.equals("01012345678")){ //입력한 값이 맞으면
					mf.membershipPointCheck_InputNumToNext(2);
				} else{ //입력한 값이 틀리면
					lbWarn.setText("* 없는 번호 입니다.");
				}
			}
		}else{
			JButton btn = (JButton) e.getSource(); // 작동된 액션을 버튼타입 btn에 담음
			str = str+btn.getActionCommand(); // str은 담는상자 = 현재값 + 누른버튼의 이름
			ticketNum.setText(str);
		}

	}
}
