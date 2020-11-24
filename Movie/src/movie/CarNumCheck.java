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
		btnOk.setBorderPainted(false); //��ư ���� ����
		btnOk.setFocusPainted(false); //��ư Ŭ�� ���� ����
		btnOk.setContentAreaFilled(false); //��ư ��� ����
		btnOk.setBounds(225, 230, 40, 40);
		btnOk.addActionListener(this);
		
		car = new ImageIcon("car.png");
		carlb = new JLabel(car);
		carlb.setBounds(15, 15, 180, 180);
		
		JLabel lbl = new JLabel("�̹� ��ϵ�");
		lbl.setFont(new Font("�������", Font.BOLD, 20));
		lbl.setBounds(220, 100, 200, 40);
		JLabel lbl3 = new JLabel("��ȣ �Դϴ�.");
		lbl3.setFont(new Font("�������", Font.BOLD, 20));
		lbl3.setBounds(220, 130, 200, 40);
		
		JLabel lblEnr2 = new JLabel("���� ���� �ִ� �ð��� 3�ð� �Դϴ�.");
		lblEnr2.setFont(new Font("�������", Font.BOLD, 15));
		lblEnr2.setBounds(125, 200, 400, 40);
		
		JLabel lbl2 = new JLabel(data[0] + "" + data[1] + "" + data[2]);
		lbl2.setFont(new Font("�������", Font.BOLD, 30));
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