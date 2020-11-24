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

public class ParkingEnrDialog extends JDialog implements ActionListener {
	private JPanel pn;
	private JLabel lblEnr, lblEnr1, lblEnr2;
	private JButton btnOk;
	private ImageIcon car;
	private JLabel carlb;
	Main_Frame mf;
	
	public ParkingEnrDialog(String data[], ParkingDialog pdialog, Main_Frame mf) {
		super(pdialog, true);
		this.mf=mf;
		this.setSize(500, 340);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		car = new ImageIcon("car.png");
		carlb = new JLabel(car);
		carlb.setBounds(15, 15, 180, 180);
		
		pn = new JPanel();
		pn.setLayout(null);
		pn.setBackground(Color.WHITE);
		
		lblEnr = new JLabel(data[0]+""+data[1]+""+data[2]);
		lblEnr.setFont(new Font("맑은고딕", Font.BOLD, 25));
		lblEnr.setBounds(250, 50, 200, 35);
		
		lblEnr1 = new JLabel("등록 완료!");
		lblEnr1.setFont(new Font("맑은고딕", Font.BOLD, 35));
		lblEnr1.setBounds(250, 120, 200, 40);
		
		lblEnr2 = new JLabel("무료 주차 가능 시간은 3시간 입니다.");
		lblEnr2.setFont(new Font("맑은고딕", Font.BOLD, 15));
		lblEnr2.setBounds(125, 200, 400, 40);
		
		btnOk = new JButton(new ImageIcon("Confirm.png"));
		btnOk.setBorderPainted(false); //버튼 라인 삭제
		btnOk.setFocusPainted(false); //버튼 클릭 라인 삭제
		btnOk.setContentAreaFilled(false); //버튼 배경 삭제
		btnOk.setBounds(225, 250, 40, 40);
		btnOk.addActionListener(this);
		
		pn.add(lblEnr);
		pn.add(lblEnr1);
		pn.add(lblEnr2);
		pn.add(btnOk);
		pn.add(carlb);
		
		this.add(pn);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			this.setVisible(false);	
			mf.parkingMainToNext();
	}		
}
