package movie;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ParkingDialog extends JDialog implements ActionListener, FocusListener {
	private JPanel pnBack; //바탕패널
	private JTextField tf1, tf2; //각 차번호 입력창
	private JTextField tfCurrent; //합치는 입력창
	private String str = "", str2 = ""; //값 받을 곳
	private JComboBox<String> box;
	private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	private JButton btnCancel, btnEnr, btnDelete;
	Main_Frame mf;
	String[] data;
	String air = "";
	BufferedReader br = null;
	FileReader fr = null;
	
	public ParkingDialog(Main_Frame mf){ //메인프레임
		super(mf, true);
		this.mf=mf;
		this.setSize(500, 340);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		
		//바탕 패널
		pnBack = new JPanel();
		pnBack.setBackground(Color.WHITE);
		pnBack.setLayout(null);
		
		guideInputNum(); //안내 문구
		makeFields(); //입력받을곳
		makeNumKey(); //버튼
		
		this.add(pnBack);
		this.setVisible(true);
	}
	private void guideInputNum(){ //안내 문구
		JLabel lbl = new JLabel("차량의 번호를 선택해주세요.");
		lbl.setFont(new Font("맑은고딕", Font.BOLD, 20));
		lbl.setBounds(105, -20, 300, 100);
		pnBack.add(lbl);
	}
	private void makeFields(){ //입력받을 곳
		tf1 = new JTextField(5);
		tf2 = new JTextField(10);
		
		tf1.setBounds(140, 70, 40, 20);
		tf2.setBounds(250, 70, 80, 20);
		tf1.addFocusListener(this);
		tf2.addFocusListener(this);
		tf1.setEditable(false);
		tf2.setEditable(false);
		
		String Carnumber[]={"가", "나", "다", "라", "마", "거", "너", "더", "러", "머", "버", "서", "어", "저", "고", "노", "도", "로", "모", "보", "소", "오", "조", "구", "누", "두", "루", "무", "부", "수", "우", "주", "아", "바", "사", "자", "배", "하", "허", "호"};
		box = new JComboBox<String>(Carnumber);
		box.setBounds(195, 70, 40, 20);
		
		pnBack.add(tf1);
		pnBack.add(tf2);
		pnBack.add(box);
		
	}
	private void makeNumKey(){ //버튼
		//번호버튼
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btn0 = new JButton("0");
		
		btn1.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		btn2.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		btn3.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		btn4.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		btn5.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		btn6.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		btn7.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		btn8.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		btn9.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		btn0.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		
		btn1.setBounds(90, 110, 50, 50);
		btn2.setBounds(150, 110, 50, 50);
		btn3.setBounds(210, 110, 50, 50);
		btn4.setBounds(270, 110, 50, 50);
		btn5.setBounds(330, 110, 50, 50);
		btn6.setBounds(90, 170, 50, 50);
		btn7.setBounds(150, 170, 50, 50);
		btn8.setBounds(210, 170, 50, 50);
		btn9.setBounds(270, 170, 50, 50);
		btn0.setBounds(330, 170, 50, 50);
		
		btn1.setBorderPainted(false); //버튼 라인 삭제
		btn2.setBorderPainted(false); 
		btn3.setBorderPainted(false);
		btn4.setBorderPainted(false);
		btn5.setBorderPainted(false); 
		btn6.setBorderPainted(false);
		btn7.setBorderPainted(false);
		btn8.setBorderPainted(false);
		btn9.setBorderPainted(false); 
		btn0.setBorderPainted(false); 
		
		btn1.setFocusPainted(false); //버튼 클릭 라인 삭제
		btn2.setFocusPainted(false); 
		btn3.setFocusPainted(false); 
		btn4.setFocusPainted(false); 
		btn5.setFocusPainted(false); 
		btn6.setFocusPainted(false); 
		btn7.setFocusPainted(false); 
		btn8.setFocusPainted(false); 
		btn9.setFocusPainted(false); 
		btn0.setFocusPainted(false); 
		
		btn1.setContentAreaFilled(false); //버튼 배경 삭제
		btn2.setContentAreaFilled(false); 
		btn3.setContentAreaFilled(false); 
		btn4.setContentAreaFilled(false); 
		btn5.setContentAreaFilled(false); 
		btn6.setContentAreaFilled(false); 
		btn7.setContentAreaFilled(false); 
		btn8.setContentAreaFilled(false); 
		btn9.setContentAreaFilled(false); 
		btn0.setContentAreaFilled(false); 
		
		btn1.addActionListener(this); //액션리스너
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn0.addActionListener(this);
		
		pnBack.add(btn1);
		pnBack.add(btn2);
		pnBack.add(btn3);
		pnBack.add(btn4);
		pnBack.add(btn5);
		pnBack.add(btn6);
		pnBack.add(btn7);
		pnBack.add(btn8);
		pnBack.add(btn9);
		pnBack.add(btn0);
		
		//그 외 버튼		
		btnCancel = new JButton(new ImageIcon("Back111.png"));
		btnDelete = new JButton("지우기");
		btnEnr = new JButton(new ImageIcon("Confirm.png"));
		
		btnCancel.setBorderPainted(false); //버튼 라인 삭제
		btnDelete.setBorderPainted(false); 
		btnEnr.setBorderPainted(false); 
		
		btnCancel.setContentAreaFilled(false); //버튼 배경 삭제
		btnDelete.setContentAreaFilled(false); 
		btnEnr.setContentAreaFilled(false); 
		
		btnCancel.setBounds(90, 230, 40, 40);
		btnDelete.setBounds(190, 236, 100, 30);
		btnEnr.setBounds(350, 230, 40, 40);
			
		btnCancel.addActionListener(this);
		btnDelete.addActionListener(this);
		btnEnr.addActionListener(this);
		
		btnDelete.setFont(new Font("맑은고딕", Font.BOLD, 20));
		
		pnBack.add(btnCancel);
		pnBack.add(btnDelete);
		pnBack.add(btnEnr);
		
	
	}
	
	
	void fileSave(File f, String str){
		PrintWriter pw = null;
		FileWriter fw = null;
		try{
			fw = new FileWriter(f, true);
			pw = new PrintWriter(fw);
			
			pw.println(str);
		}catch(Exception e){
			e.getStackTrace();
		}finally{
			try{
				if(fw != null) fw.close();
				if(pw != null) pw.close();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	
	@Override
	public void focusGained(FocusEvent arg0) { //포커스 설정
		if(arg0.getSource() == tf1){
			tfCurrent = tf1;
		} else {
			tfCurrent = tf2;
		}
	}
	public void focusLost(FocusEvent arg0) {} //사용 안함

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDelete) { // 지우기 버튼 눌렀을때
			if(tfCurrent == tf1 && !tf1.getText().trim().equals("")) { // tf1이 선택되어있고 tf1이 공백이 아니면
				tf1.setText((tf1.getText()).substring(0, tf1.getText().length() - 1)); // tf1에 담겨있는 값을 마지막부터 1개씩 자른다
				str = tf1.getText(); //tf1에 담겨있는 값을 str에 넣기
			}
			
			if(tfCurrent == tf2 && !tf2.getText().trim().equals("")) {
				tf2.setText((tf2.getText()).substring(0, tf2.getText().length() - 1));
				str2 = tf2.getText();
			}
		} else if(e.getSource() == btnEnr) { //차량번호를 입력하기 눌렀을 때
			data = new String[3];
			data[0] = tf1.getText();
			data[1] = box.getSelectedItem().toString();
			data[2] = tf2.getText();
			air = data[0] + data[1] + data[2];
			
				if(str.length() != 2 || str2.length() != 4){
					JOptionPane.showMessageDialog(mf, "차량번호를 선택해주세요.");
			
				}else if(str.length() == 2 && str2.length() == 4){
					File f = null;
					
					boolean isExist = false;
					try{
						f = new File("CarPark.txt");

						boolean isExistFile = f.exists();
						if (isExistFile) {
							br = new BufferedReader(new FileReader(f));

							String l = null;
							while((l = br.readLine()) != null){							
								if(l.equals(air)){
									isExist=true;
									break;
								}
							}
							System.out.println(isExist);
							if(isExist){
								this.setVisible(false);
								new CarNumCheck(data, this, mf);
							}else{
								this.setVisible(false);
								fileSave(f, air);
								new ParkingEnrDialog(data, this, mf);
							}
							
						}else{// 처음에 파일이없을 때 한번만 실행됨
							fileSave(f, air);
							this.dispose();
							new ParkingEnrDialog(data, this, mf);
						}
						
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
		
			this.dispose();
		}else { //번호 입력 버튼
			JButton btn = (JButton)e.getSource();
			if(tfCurrent == tf1) {
				str = str + btn.getActionCommand();
				tfCurrent.setText(str);
				if(tf1.getText().length() > 2){ //앞자리 제한
					str = "";
					tf1.setText("");
					JOptionPane.showMessageDialog(mf, "2자리만 선택 가능합니다.");
				}
			} else {
				str2 = str2 + btn.getActionCommand();
				tfCurrent.setText(str2);
				if(tf2.getText().length() > 4){ // 뒷자리 제한
					str2 = "";
					tf2.setText("");
					JOptionPane.showMessageDialog(mf, "4자리만 선택 가능합니다.");
				}
			}
		}
	}
}