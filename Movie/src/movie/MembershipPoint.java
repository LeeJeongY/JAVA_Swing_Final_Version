package movie;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class MembershipPoint extends JPanel implements ActionListener{
	private Image backgroundImage;
	private BufferedReader br;
	private int pointSum;
	private JButton btnGoToMain;
	
	private DefaultTableModel model;
	private JTable jTable1;
	
	Main_Frame mf;
	
	
	public MembershipPoint (Main_Frame mf) { 
		try {
			backgroundImage = ImageIO.read(new File("Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.mf = mf;
		this.setSize(700,100);
		this.setLayout(new GridLayout(0,1));
		
		topPage(); 
		middlePage();
		bottomPage();
		tableCellCenter(jTable1);
	}
	private void topPage() {
		JPanel pnlTop = new JPanel();
		pnlTop.setLayout(null);
		pnlTop.setBackground(new Color(0,0,0,0));
		
		JLabel customerID = new JLabel("ÃÖ*¼® ´ÔÀÇ");
		JLabel customerText = new JLabel("Æ÷ÀÎÆ® ³»¿ªÀ» È®ÀÎÇÕ´Ï´Ù. ");
		
		customerID.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN,50));
		customerText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN,30));
		
		customerID.setBounds(100, 150, 500, 50);
		customerText.setBounds(100, 220, 500, 50);
		
		customerID.setForeground(Color.white);
		customerText.setForeground(Color.white);
		
		pnlTop.add(customerID);
		pnlTop.add(customerText);
		
		this.add(pnlTop);
	}
	private void middlePage() {
		JPanel pnlMid = new JPanel();
		pnlMid.setBackground(new Color(0,0,0,0));

		jTable1 = new JTable(model);
		jTable1.setDefaultEditor(Object.class, null);
		JScrollPane sp = new JScrollPane(jTable1);
		
		sp.setPreferredSize(new Dimension(530,300));
		sp.setBackground(Color.WHITE);
		
		
		
		String filePath = "01012345678.txt";
		File file = new File(filePath);
		
		try {
			br = new BufferedReader(new FileReader(file));
            String firstLine = null;
			try {
				firstLine = br.readLine().trim();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
            String[] columnsName = firstLine.split(",");
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setColumnIdentifiers(columnsName);
            Object[] tableLines = br.lines().toArray();
            
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("/");
                model.addRow(dataRow);
            }
            
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} finally {
			try{
				if(br != null)br.close();
			}catch(IOException e2){
				e2.printStackTrace();
			}
		}
		
		
		pnlMid.add(sp);
		this.add(pnlMid);
		
	}

	private void bottomPage() {
		JPanel pnlBot = new JPanel();
		pnlBot.setBackground(new Color(0,0,0,0));
		pnlBot.setLayout(null);
		
		JLabel lbPointis = new JLabel("  Æ÷ÀÎÆ® ÃÑ ÇÕ:                   Æ÷ÀÎÆ® ");
		JLabel lbPointAll = new JLabel("0");
		
		lbPointis.setOpaque(true);
		lbPointis.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN,30));
		lbPointis.setForeground(new Color(39,38,64));
		lbPointis.setBackground(Color.white);
		lbPointis.setBounds(82, 10, 530, 50);
		
		lbPointAll.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN,30));
		lbPointAll.setForeground(new Color(39,38,64));
		lbPointAll.setBounds(280, 10, 200, 50);
		lbPointAll.setHorizontalAlignment(JLabel.RIGHT); 
		
		sumPoint();
		lbPointAll.setText(pointSum+"");
		pnlBot.add(lbPointAll);
		pnlBot.add(lbPointis);
		
		btnGoToMain = new JButton("È®ÀÎ");
		btnGoToMain.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN,30));
		btnGoToMain.setBackground(new Color(6,90,96));
		btnGoToMain.setForeground(Color.white);
		btnGoToMain.setBounds(235, 150, 200, 80);
		btnGoToMain.setBorderPainted(false); 
		btnGoToMain.setFocusPainted(false); 
		btnGoToMain.addActionListener(this);
		
		pnlBot.add(btnGoToMain);
		
		this.add(pnlBot);
	}
	
	private void sumPoint() { 
		int row = jTable1.getRowCount();
		for(int i=0;i<row;i++){
			pointSum += Integer.parseInt(jTable1.getValueAt(i, 3)+"");
			
		}
	}
	public void tableCellCenter(JTable t){  
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = t.getColumnModel();
		for(int i = 0; i< tcm.getColumnCount();i++){
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mf.membershipPointToNext();
	}
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}

}
