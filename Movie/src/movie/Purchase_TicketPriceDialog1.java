package movie;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Purchase_TicketPriceDialog1 extends JDialog{
	JPanel pnl;
	private JLabel lbl_image;
	//Main_Frame mf;
	JFrame f;
	
	
	public Purchase_TicketPriceDialog1(JFrame f) {
		super(f, true);
		this.f = f;
		this.setSize(500,450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		pnl = new JPanel(); //��ü �г�
		pnl.setBackground(Color.white);
		
		firstPage(); //������
			
		this.add(pnl);
	}
	private void firstPage(){
		ImageIcon img_cash = new ImageIcon("Info2.jpg");
		
		lbl_image = new JLabel();
		lbl_image.setIcon(img_cash);
		
		pnl.add(lbl_image);
		
	}

}