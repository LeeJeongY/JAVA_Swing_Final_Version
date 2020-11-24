package movie;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Point_InputNum extends JPanel implements ActionListener{
	private JButton num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, backScreen, backSpace, clear, printBtn; 
	private Image backgroundImage; // 배경이미지
	private JLabel pointNum; // 포인트적립 레이블
	private JLabel completed; //픽업대 안내 (마지막 페이지)
	private String str = ""; // 적립레이블 담는상자
	private ImageIcon img3;
	
	public JLabel lbWarn;
	private String[] info;
	
	private boolean whichOne; //매점인지, 티켓 구매인지 확인
	private int howMuch; //원금 받아오기
	Main_Frame mf;
	
	Point_InputNum(Main_Frame mf, boolean whichOne, int howMuch){ //생성자
		this.mf = mf;
		this.whichOne = whichOne;
		this.howMuch = howMuch;
		
		this.setSize(700, 1000);
		this.setLayout(null);
		
		try {
			backgroundImage = ImageIO.read(new File("키패트배경최종.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		makeButtons(); //버튼 만들고 꾸미기
		
	}
	private void makeButtons(){
		pointNum = new JLabel("",SwingConstants.CENTER);
		pointNum.setBounds(200, 270, 300, 100);
		pointNum.setFont(new Font("맑은 고딕", Font.PLAIN,25));
		pointNum.setForeground(Color.white);
		pointNum.setOpaque(false);
		
		lbWarn = new JLabel("",SwingConstants.CENTER);
		lbWarn.setBounds(200, 345, 300, 100);
		lbWarn.setFont(new Font("맑은 고딕", Font.PLAIN,25));
		lbWarn.setForeground(Color.red);
		lbWarn.setOpaque(false);
		
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
		
		backSpace = new JButton("지우기");
		backSpace.addActionListener(this);
		backSpace.setFont(new Font("맑은 고딕", Font.PLAIN,20));
		backSpace.setBounds(120, 750, 100, 90);
		backSpace.setForeground(Color.white);
		backSpace.setBorderPainted(false); //버튼 라인 삭제
		backSpace.setFocusPainted(false); //버튼 클릭 라인 삭제
		backSpace.setContentAreaFilled(false); //버튼 배경 삭제
		
		clear = new JButton("확인");
		clear.addActionListener(this);
		clear.setFont(new Font("맑은 고딕", Font.PLAIN,35));
		clear.setBounds(200, 895, 300, 70);
		clear.setBackground(new Color(77,25,77));
		clear.setForeground(Color.white);
		clear.setBorderPainted(false); //버튼 라인 삭제
		clear.setFocusPainted(false); //버튼 클릭 라인 삭제
		
		this.add(lbWarn);
		this.add(pointNum);
		this.add(num1);
		this.add(num2);
		this.add(num3);
		this.add(num4);
		this.add(num5);
		this.add(num6);
		this.add(num7);
		this.add(num8);
		this.add(num9);
		this.add(num0);
		this.add(backScreen);
		this.add(backSpace);
		this.add(clear);
	}
	private void makeLastPage(){
		printBtn = new JButton(new ImageIcon("printer.png"));
		printBtn.addActionListener(this);
		printBtn.setBounds(300, 600, 100, 100);
		printBtn.setBorderPainted(false); //버튼 라인 삭제
		printBtn.setFocusPainted(false); //버튼 클릭 라인 삭제
		printBtn.setContentAreaFilled(false); //버튼 배경 삭제

		img3 = new ImageIcon("팝콘 주문완료.jpg");
		completed = new JLabel();
		completed.setBounds(0, 100, 700, 800);
		completed.setIcon(img3);
		completed.add(printBtn);
		this.add(completed);

	}

	
	private void settingPointInfo(){//날짜, 지점, 내역, 적립 포인트
		info = new String[4]; //날짜, 지점, 내역, 적립 포인트
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		Calendar time = Calendar.getInstance();
		info[0] = format1.format(time.getTime());
		
		info[1] = "부산 서면점";
		
		if (whichOne == true){
			info[2] = "매점";
		} else {
			info[2] = "티켓 구매";
		}
		
		info[3] = (int)(howMuch*0.01d)+"";
		
		
		PrintWriter pw = null;
		try {
			File f = new File("01012345678.txt");
			pw = new PrintWriter(new FileWriter(f,true)); //생성된 파일 뒤에 이어서 쓰기
			
			String infoResult ="";
			for(int i = 0; i <info.length; i++){
				infoResult += info[i]+"/";
			}
			pw.println(infoResult);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {							
			if(pw != null)pw.close();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backSpace){
			pointNum.setText((pointNum.getText()).substring(0, pointNum.getText().length()-1));
			str = pointNum.getText();
		}else if(e.getSource() == backScreen){// 홈 버튼 누르면 홈으로
			mf.point_InputNumToNext(1);
		}else if(e.getSource() == clear){
			String s = pointNum.getText();
			if (lbWarn.getText() != ""){ //경고창 초기화
				lbWarn.setText("");
			}
			if (s.length()!=11){
				lbWarn.setText("* 11자리를 입력해 주세요.");
			} else {
				if (s.equals("01012345678")){// 확인버튼 누르면 다음 화면으로
					settingPointInfo();//날짜, 지점, 내역, 적립 포인트 값 셋팅
					if (whichOne == true) {
						this.removeAll(); //다음 화면 처리
						makeLastPage();
						this.repaint();
					} else {
						mf.point_InputNumToNext(2); //주차안내 
					}
					
				} else {
					lbWarn.setText("* 없는 번호 입니다.");
				}
			}
		}else if(e.getSource() == printBtn){ //홈화면
			mf.point_InputNumToNext(1);
		}else{ // 숫자버튼을 레이블에 보여주는 기능
			JButton btn = (JButton) e.getSource(); // 작동된 액션을 버튼타입 btn에 담음
			str = str + btn.getActionCommand(); // str은 담는상자 = 현재값 + 누른버튼의 이름
			pointNum.setText(str);
		}
	}
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}

}
