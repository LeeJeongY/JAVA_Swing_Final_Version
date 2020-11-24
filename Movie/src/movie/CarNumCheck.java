package movie;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarNumCheck extends JDialog implements ActionListener{
	private JButton btnOk;
	private ImageIcon car;
	private JLabel carlb;
	Main_Frame mf;
	
	public CarNumCheck(String data[], ParkingDialog pdialog, Main_Frame mf){
		super(pdialog, true);
		this.mf = mf;
		this.setSize(500, 340);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JPanel pnl = new JPanel(null);
		pnl.setBackground(Color.WHITE);
		
		btnOk = new JButton(new ImageIcon("Confirm.png"));
		btnOk.setBorderPainted(false); //버튼 라인 삭제
		btnOk.setFocusPainted(false); //버튼 클릭 라인 삭제
		btnOk.setContentAreaFilled(false); //버튼 배경 삭제
		btnOk.setBounds(225, 230, 40, 40);
		btnOk.addActionListener(this);
		
		car = new ImageIcon("car.png");
		carlb = new JLabel(car);
		carlb.setBounds(15, 15, 180, 180);
		
		JLabel lbl = new JLabel("이미 등록된");
		lbl.setFont(new Font("맑은고딕", Font.BOLD, 20));
		lbl.setBounds(220, 100, 200, 40);
		JLabel lbl3 = new JLabel("번호 입니다.");
		lbl3.setFont(new Font("맑은고딕", Font.BOLD, 20));
		lbl3.setBounds(220, 130, 200, 40);
		
		JLabel lblEnr2 = new JLabel("무료 주차 최대 시간은 3시간 입니다.");
		lblEnr2.setFont(new Font("맑은고딕", Font.BOLD, 15));
		lblEnr2.setBounds(125, 200, 400, 40);
		
		JLabel lbl2 = new JLabel(data[0] + "" + data[1] + "" + data[2]);
		lbl2.setFont(new Font("맑은고딕", Font.BOLD, 30));
		lbl2.setBounds(220, 40, 400, 50);
		
		pnl.add(lbl);
		pnl.add(lbl3);
		pnl.add(lbl2);
		pnl.add(lblEnr2);
		pnl.add(btnOk);
		pnl.add(carlb);
		
		this.add(pnl);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOk){
			this.setVisible(false);	
			mf.parkingMainToNext();
		}
	}
}