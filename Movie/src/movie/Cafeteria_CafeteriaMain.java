package movie;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Cafeteria_CafeteriaMain extends JPanel implements ActionListener{
	private JTabbedPane tab = new JTabbedPane();;
	private JLabel lbltotal, txt, txt2,txt3,txt4;
	private JPanel centerPnl,upPnl;
	private JButton btnBack,btnbasket,btnorder,btndelete,up,up2,up3,up4,dw,dw2,dw3,dw4,btnbasket2,btnbasket3,btnbasket4;
	private JRadioButton pop1,pop2,pop3,pop4,pop5,coke1,coke2,coke3,coke4,coke5,side1,side2,side3,side4,side5,combo1,combo2,combo3,combo4,combo5;
	private JTable table;
	private DefaultTableModel model;
	private String header[] = {"��ǰ��","������","����","����"};
	private String contents[][] = {};
	private int moneysum;
	private int selRow;
	Main_Frame mf;
	Point_InputNum pin;
	private ButtonGroup	bg = new ButtonGroup();
	private ButtonGroup	bg2 = new ButtonGroup();
	private ImageIcon upup = new ImageIcon("up.png");
	private ImageIcon dwdw = new ImageIcon("down.png");
	
	public Cafeteria_CafeteriaMain(Main_Frame mf) {
		this.mf = mf;
		this.setSize(700,800);
		this.setLayout(new BorderLayout());
		centerPnl = new JPanel();
		centerPnl.setLayout(new BorderLayout());
		centerPnl.setBackground(Color.WHITE);
		upPnl = new JPanel();
		upPnl.setBackground(Color.WHITE);

		upPnl.add(tab);
		
		UpPanel();
		PopconPanel();
		CokePanel();
		SidePanel();
		ComboPanel();
		TablePanel();
		centerPnl.add(upPnl);
		this.add(centerPnl);

	}
	void PopconPanel(){// �� - ����
		JPanel popPnl = new JPanel();	
		popPnl.setLayout(new BorderLayout()); ///���� �г��� ��ü Ʋ
		popPnl.setPreferredSize(new Dimension(650,510));
		
		JPanel popPnlC = new JPanel();///���� ���� �г�
		JPanel popPnlE = new JPanel();///���� East �г�
		JPanel popPnlS = new JPanel();/// ���� South �г�
		JPanel popPnlN = new JPanel();/// ���� North �г�
		
		////���� center �г�
		Border borderC = BorderFactory.createTitledBorder("");
		popPnlC.setBorder(borderC);
		JPanel popPnlL = new JPanel();  //���߿� �׸����� �г�!
		JPanel popPnlR = new JPanel();	// ������ ������ư�̶� ���� �� �г�
		pop1 = new JRadioButton("�������� ����",true);
		pop2 = new JRadioButton("ġ�� ����");
		pop3 = new JRadioButton("ī��� ����");
		
		pop1.setFont(new Font("Serif",Font.BOLD,20));
		pop2.setFont(new Font("Serif",Font.BOLD,20));
		pop3.setFont(new Font("Serif",Font.BOLD,20));
		
		JLabel lbl1 = new JLabel("                   M   5000��");
		JLabel lbl2 = new JLabel("                   M   6000��");
		JLabel lbl3 = new JLabel("                   M   6500��");
		lbl1.setFont(new Font("Serif",Font.BOLD,15));
		lbl2.setFont(new Font("Serif",Font.BOLD,15));
		lbl3.setFont(new Font("Serif",Font.BOLD,15));
		
		bg.add(pop1);
		bg.add(pop2);
		bg.add(pop3);
		popPnlC.setLayout(new GridLayout(0,2));
		popPnlR.setLayout(new GridLayout(12,0));
		popPnlR.add(new JLabel(" "));
		popPnlR.add(pop1);
		popPnlR.add(lbl1);
		popPnlR.add(new JLabel(" "));
		popPnlR.add(new JLabel(" "));
		popPnlR.add(pop2);
		popPnlR.add(lbl2);
		popPnlR.add(new JLabel(" "));
		popPnlR.add(new JLabel(" "));
		popPnlR.add(pop3);
		popPnlR.add(lbl3);
		popPnlR.add(new JLabel(" "));
		////////////// ���� �̹���////////////////
		ImageIcon original = new ImageIcon("������������.png"); 
		JLabel originalpop = new JLabel(original);
		popPnlL.add(originalpop);
		ImageIcon cheeze= new ImageIcon("ġ������.png"); 
		JLabel cheezepop = new JLabel(cheeze);
		popPnlL.add(cheezepop);
		ImageIcon caramel = new ImageIcon("ī�������.png"); 
		JLabel caramelpop = new JLabel(caramel);
		popPnlL.add(caramelpop);
		/////////////////////////////////
		popPnlC.add(popPnlL);
		popPnlC.add(popPnlR);
		popPnl.add(popPnlC);
		////////////////// ���� North �г�
		JLabel popcon = new JLabel("               ����");
		JLabel size = new JLabel("                                  ������");
		popcon.setFont(new Font("Serif",Font.BOLD,30));
		size.setFont(new Font("Serif",Font.BOLD,30));
		
		popPnlN.add(popcon);    
		popPnlN.add(size);
		popPnl.add(popPnlN,"North");
		////////////////// ���� South �г�
		btnbasket = new JButton("���");
		btnbasket.addActionListener(this);
		popPnlS.add(btnbasket);
		popPnl.add(popPnlS,"South");
		///////////////// ���� East�г�
		JPanel popPnlE2 = new JPanel();
		JPanel popPnlE3 = new JPanel();
		Border borderE2 = BorderFactory.createTitledBorder("");
		popPnlE2.setBorder(borderE2);
		popPnlE3.setBorder(borderE2);
		popPnlE.setLayout(new BorderLayout());
		popPnlE2.setLayout(new GridLayout(0,1));
		popPnlE3.setLayout(new GridLayout(0,1));

		JLabel lbl8 = new JLabel("       ���� ");
		txt = new JLabel("",SwingConstants.CENTER);
		txt.setFont(new Font("Serif",Font.BOLD,30));
		lbl8.setFont(new Font("Serif",Font.BOLD,30));
		JLabel lbl5 = new JLabel("             +1000��");
		lbl5.setFont(new Font("Serif",Font.BOLD,15));
		pop4 = new JRadioButton("    M                       ",true);
		pop5 = new JRadioButton("    L                       ");
		pop4.setFont(new Font("Serif",Font.BOLD,20));
		pop5.setFont(new Font("Serif",Font.BOLD,20));
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(pop4);
		bg2.add(pop5);
		popPnlE2.add(new JLabel(" "));
		popPnlE2.add(pop4); 
		popPnlE2.add(new JLabel(" "));
		popPnlE2.add(pop5);
		popPnlE2.add(lbl5);
		popPnlE2.add(new JLabel(" "));
		
		txt.setText("1");
		txt.setFont(new Font("Serif",Font.BOLD,30));
		JLabel lblbl = new JLabel(" ");
		popPnlE3.add(lblbl);
		
		popPnlE3.add(lbl8);
		ImageIcon upup = new ImageIcon("up.png");
		ImageIcon dwdw = new ImageIcon("down.png");
		up = new JButton(upup);
		dw = new JButton(dwdw);
		btnOption(up);
		btnOption(dw);
		up.addActionListener(this);
		dw.addActionListener(this);
		up.setBackground(Color.WHITE);
		dw.setBackground(Color.WHITE);
		popPnlE3.add(up);
		popPnlE3.add(txt);
		popPnlE3.add(dw);
		
		popPnlE.add(popPnlE2,"North");
		popPnlE.add(popPnlE3,"South");
		popPnl.add(popPnlE,"East");
		tab.add("����",popPnl);
		///////// ����
		popPnlE.setBackground(Color.WHITE);popPnlS.setBackground(Color.WHITE);
		popPnlN.setBackground(Color.WHITE);popPnlR.setBackground(Color.WHITE);popPnlC.setBackground(Color.WHITE);pop1.setBackground(Color.WHITE);
		pop2.setBackground(Color.WHITE);pop3.setBackground(Color.WHITE);pop4.setBackground(Color.WHITE);pop5.setBackground(Color.WHITE);
		popPnlL.setBackground(Color.WHITE);txt.setBackground(Color.WHITE);popPnlE2.setBackground(Color.WHITE);popPnlE3.setBackground(Color.WHITE);
		popPnlE.setBackground(Color.WHITE);
	} 
	void CokePanel(){// �� - ����
		
		JPanel cokePnl = new JPanel();
		
		cokePnl.setLayout(new BorderLayout()); ///���� �г��� ��ü Ʋ
		cokePnl.setPreferredSize(new Dimension(650,480));
		JPanel cokePnlC = new JPanel();///���� ���� �г�
		JPanel cokePnlE = new JPanel();///���� East �г�
		JPanel cokePnlS = new JPanel();/// ���� South �г�
		JPanel cokePnlN = new JPanel();/// ���� North �г�
		
		////���� center �г�
		Border borderCoke = BorderFactory.createTitledBorder("");
		cokePnlC.setBorder(borderCoke);
		JPanel cokePnlL = new JPanel();  // �׸����� �г�!
		JPanel cokePnlR = new JPanel();	// ������ ������ư�̶� ���� �� �г�
		
		coke1 = new JRadioButton("�ݶ�",true);
		coke2 = new JRadioButton("�Ƹ޸�ī��");
		coke3 = new JRadioButton("�Ƹ޸�ī��(ICED)");
		
		coke1.setFont(new Font("Serif",Font.BOLD,20));
		coke2.setFont(new Font("Serif",Font.BOLD,20));
		coke3.setFont(new Font("Serif",Font.BOLD,20));
		
		JLabel cokelbl1 = new JLabel("                   M   2000��");
		JLabel cokelbl2 = new JLabel("                   M   2000��");
		JLabel cokelbl3 = new JLabel("                   M   2500��");
		cokelbl1.setFont(new Font("Serif",Font.BOLD,15));
		cokelbl2.setFont(new Font("Serif",Font.BOLD,15));
		cokelbl3.setFont(new Font("Serif",Font.BOLD,15));
		
		bg.add(coke1);
		bg.add(coke2);
		bg.add(coke3);
		
		cokePnlC.setLayout(new GridLayout(0,2));
		cokePnlR.setLayout(new GridLayout(12,0));
		cokePnlR.add(new JLabel());
		cokePnlR.add(coke1);
		cokePnlR.add(cokelbl1);
		cokePnlR.add(new JLabel());
		cokePnlR.add(new JLabel());
		cokePnlR.add(coke2);
		cokePnlR.add(cokelbl2);
		cokePnlR.add(new JLabel());
		cokePnlR.add(new JLabel());
		cokePnlR.add(coke3);
		cokePnlR.add(cokelbl3);
		cokePnlR.add(new JLabel());
		////////////// ���� �̹���////////////////
		ImageIcon coke = new ImageIcon("�ݶ�.png"); 
		JLabel cokelbl = new JLabel(coke);
		cokePnlL.add(cokelbl);
		ImageIcon mountin= new ImageIcon("����.png"); 
		JLabel mountinlbl = new JLabel(mountin);
		cokePnlL.add(mountinlbl);
		ImageIcon ade = new ImageIcon("�ƾ�.png"); 
		JLabel adelbl = new JLabel(ade);
		cokePnlL.add(adelbl);
		/////////////////////////////////
		cokePnlC.add(cokePnlL);
		cokePnlC.add(cokePnlR);	
		cokePnl.add(cokePnlC);
		////////////////// ���� North �г�
		JLabel	beverage  = new JLabel("               ����");
		JLabel size2 = new JLabel("                                  ������");
		beverage.setFont(new Font("Serif",Font.BOLD,30));
		size2.setFont(new Font("Serif",Font.BOLD,30));
		
		cokePnlN.add(beverage);    
		cokePnlN.add(size2);
		cokePnl.add(cokePnlN,"North");
		
		////////////////// ���� South �г�
		btnbasket2 = new JButton("���");
		btnbasket2.addActionListener(this);
		
		cokePnlS.add(btnbasket2);
		cokePnl.add(cokePnlS,"South");
		
		///////////////// ���� East�г�
		JPanel cokePnlE2 = new JPanel();
		JPanel cokePnlE3 = new JPanel();
		Border borderCoke2 = BorderFactory.createTitledBorder("");
		cokePnlE2.setBorder(borderCoke2);
		Border borderCoke3 = BorderFactory.createTitledBorder("");
		cokePnlE3.setBorder(borderCoke3);
		cokePnlE.setLayout(new BorderLayout());
		cokePnlE2.setLayout(new GridLayout(0,1));
		cokePnlE3.setLayout(new GridLayout(0,1));
		JLabel cokelbl8 = new JLabel("       ���� ");
		txt2 = new JLabel("",SwingConstants.CENTER);
		cokelbl8.setFont(new Font("Serif",Font.BOLD,30));
		JLabel cokelbl5 = new JLabel("             +1000��");
		cokelbl5.setFont(new Font("Serif",Font.BOLD,15));
		coke4 = new JRadioButton("    M                       ",true);
		coke5 = new JRadioButton("    L                       ");
		coke4.setFont(new Font("Serif",Font.BOLD,20));
		coke5.setFont(new Font("Serif",Font.BOLD,20));
		bg2.add(coke4);
		bg2.add(coke5);
		cokePnlE2.add(new JLabel());
		cokePnlE2.add(coke4); 
		cokePnlE2.add(new JLabel());
		cokePnlE2.add(coke5);
		cokePnlE2.add(cokelbl5);
		cokePnlE2.add(new JLabel());
		
		txt2.setText("1");
		txt2.setFont(new Font("Serif",Font.BOLD,30));
		JLabel lblbl1 = new JLabel(" ");
		cokePnlE3.add(lblbl1);
		cokePnlE3.add(cokelbl8);
		up2 = new JButton(upup);
		dw2 = new JButton(dwdw);
		btnOption(up2);
		btnOption(dw2);
		up2.addActionListener(this);
		dw2.addActionListener(this);
		up2.setBackground(Color.WHITE);
		dw2.setBackground(Color.WHITE);
		cokePnlE3.add(up2);
		cokePnlE3.add(txt2);
		cokePnlE3.add(dw2);
		
		cokePnlE.add(cokePnlE2,"North");
		cokePnlE.add(cokePnlE3,"South");
		cokePnl.add(cokePnlE,"East");
		tab.add("����",cokePnl);
		////////�� ���//////
		cokePnlE.setBackground(Color.WHITE);cokePnlS.setBackground(Color.WHITE);cokePnlN.setBackground(Color.WHITE);cokePnlR.setBackground(Color.WHITE);
		cokePnlC.setBackground(Color.WHITE);coke1.setBackground(Color.WHITE);coke2.setBackground(Color.WHITE);coke3.setBackground(Color.WHITE);
		coke4.setBackground(Color.WHITE);coke5.setBackground(Color.WHITE);cokePnlL.setBackground(Color.WHITE);cokePnlE2.setBackground(Color.WHITE);
		cokePnlE3.setBackground(Color.WHITE);cokePnlE.setBackground(Color.WHITE);txt2.setBackground(Color.WHITE);
	}	
	void SidePanel(){// �� - ���̵�
		//////////////////////���̵���� 	sidePnl
		JPanel sidePnl = new JPanel();
		
		sidePnl.setLayout(new BorderLayout()); ///���̵� �г��� ��ü Ʋ
		sidePnl.setPreferredSize(new Dimension(650,480));
		JPanel sidePnlC = new JPanel();///���̵� ���� �г�
		JPanel sidePnlE = new JPanel();///���̵� East �г�
		JPanel sidePnlS = new JPanel();/// ���̵� South �г�
		JPanel sidePnlN = new JPanel();/// ���̵� North �г�
		
		////���̵� center �г�
		Border borderside = BorderFactory.createTitledBorder("");
		sidePnlC.setBorder(borderside);
		JPanel sidePnlL = new JPanel();  // �׸����� �г�!
		JPanel sidePnlR = new JPanel();	// ������ ������ư�̶� ���� �� �г�
		side1 = new JRadioButton("����",true);
		side2 = new JRadioButton("��¡��");
		side3 = new JRadioButton("�ֵ���");
		
		side1.setFont(new Font("Serif",Font.BOLD,20));
		side2.setFont(new Font("Serif",Font.BOLD,20));
		side3.setFont(new Font("Serif",Font.BOLD,20));
		
		JLabel sidelbl1 = new JLabel("                       4000��");
		JLabel sidelbl2 = new JLabel("                       5000��");
		JLabel sidelbl3 = new JLabel("                       3000��");
		sidelbl1.setFont(new Font("Serif",Font.BOLD,15));
		sidelbl2.setFont(new Font("Serif",Font.BOLD,15));
		sidelbl3.setFont(new Font("Serif",Font.BOLD,15));
		
		bg.add(side1);
		bg.add(side2);
		bg.add(side3);
		sidePnlC.setLayout(new GridLayout(0,2));
		sidePnlR.setLayout(new GridLayout(12,0));
		sidePnlR.add(new JLabel());
		sidePnlR.add(side1);
		sidePnlR.add(sidelbl1);
		sidePnlR.add(new JLabel());
		sidePnlR.add(new JLabel());
		sidePnlR.add(side2);
		sidePnlR.add(sidelbl2);
		sidePnlR.add(new JLabel());
		sidePnlR.add(new JLabel());
		sidePnlR.add(side3);
		sidePnlR.add(sidelbl3);
		sidePnlR.add(new JLabel());
		////////////// ���̵� �̹���////////////////	
		ImageIcon nacho = new ImageIcon("����.png"); 
		JLabel nacholbl = new JLabel(nacho);
		sidePnlL.add(nacholbl);
		ImageIcon squid= new ImageIcon("��¡��.png"); 
		JLabel squidlbl = new JLabel(squid);
		sidePnlL.add(squidlbl);
		ImageIcon hotdog = new ImageIcon("�ֵ���.png"); 
		JLabel hotdoglbl = new JLabel(hotdog);
		sidePnlL.add(hotdoglbl);
		/////////////////////////////////
		sidePnlC.add(sidePnlL);
		sidePnlC.add(sidePnlR);
		sidePnl.add(sidePnlC);
		////////////////// ���̵� North �г�
		JLabel side = new JLabel("               ���̵�");
		JLabel size3 = new JLabel("                              ������");
		side.setFont(new Font("Serif",Font.BOLD,30));
		size3.setFont(new Font("Serif",Font.BOLD,30));
		
		sidePnlN.add(side);    
		sidePnlN.add(size3);
		sidePnl.add(sidePnlN,"North");
		
		////////////////// ���̵� South �г�
		btnbasket3 = new JButton("���");
		btnbasket3.addActionListener(this);
		sidePnlS.add(btnbasket3);
		sidePnl.add(sidePnlS,"South");
		///////////////// ���̵� East�г�
		JPanel sidePnlE2 = new JPanel();
		JPanel sidePnlE3 = new JPanel();
		Border borderside2 = BorderFactory.createTitledBorder("");
		sidePnlE2.setBorder(borderside2);
		Border borderside3 = BorderFactory.createTitledBorder("");
		sidePnlE3.setBorder(borderside3);
		sidePnlE.setLayout(new BorderLayout());
		sidePnlE2.setLayout(new GridLayout(0,1));
		sidePnlE3.setLayout(new GridLayout(0,1));
		JLabel sidelbl8 = new JLabel("       ���� ");
		txt3 = new JLabel("",SwingConstants.CENTER);
		sidelbl8.setFont(new Font("Serif",Font.BOLD,30));
		JLabel sidelbl5 = new JLabel("             +1000��");
		sidelbl5.setEnabled(false);
		sidelbl5.setFont(new Font("Serif",Font.BOLD,15));
		side4 = new JRadioButton("    M                       ",true);
		side5 = new JRadioButton("    L                       ");
		side4.setFont(new Font("Serif",Font.BOLD,20));
		side5.setFont(new Font("Serif",Font.BOLD,20));
		side4.setEnabled(false);
		side5.setEnabled(false);
		bg2.add(side4);
		bg2.add(side5);
		sidePnlE2.add(new JLabel());
		sidePnlE2.add(side4); 
		sidePnlE2.add(new JLabel());
		sidePnlE2.add(side5);
		sidePnlE2.add(sidelbl5);
		sidePnlE2.add(new JLabel());
	
		txt3.setText("1");
		txt3.setFont(new Font("Serif",Font.BOLD,30));
		JLabel lblbl2 = new JLabel(" ");
		sidePnlE3.add(lblbl2);
		sidePnlE3.add(sidelbl8);

		up3 = new JButton(upup);
		dw3 = new JButton(dwdw);
		btnOption(up3);
		btnOption(dw3);
		up3.addActionListener(this);
		dw3.addActionListener(this);
		up3.setBackground(Color.WHITE);
		dw3.setBackground(Color.WHITE);
		sidePnlE3.add(up3);
		sidePnlE3.add(txt3);
		sidePnlE3.add(dw3);
		
		sidePnlE.add(sidePnlE2,"North");
		sidePnlE.add(sidePnlE3,"South");
		sidePnl.add(sidePnlE,"East");
		tab.add("���̵�",sidePnl);
		///////////////////////����//////////////////
		sidePnlE.setBackground(Color.WHITE);sidePnlS.setBackground(Color.WHITE);sidePnlN.setBackground(Color.WHITE);sidePnlR.setBackground(Color.WHITE);
		sidePnlC.setBackground(Color.WHITE);side1.setBackground(Color.WHITE);side2.setBackground(Color.WHITE);side3.setBackground(Color.WHITE);
		side4.setBackground(Color.WHITE);side5.setBackground(Color.WHITE);sidePnlL.setBackground(Color.WHITE);sidePnlE2.setBackground(Color.WHITE);
		sidePnlE3.setBackground(Color.WHITE);sidePnlE.setBackground(Color.WHITE);txt3.setBackground(Color.WHITE);
	}
	void ComboPanel(){// �� - �޺�
	JPanel comboPnl = new JPanel();
	comboPnl.setLayout(new BorderLayout()); ///���� �г��� ��ü Ʋ
	comboPnl.setPreferredSize(new Dimension(650,510));
	JPanel comboPnlC = new JPanel();///���� ���� �г�
	JPanel comboPnlE = new JPanel();///���� East �г�
	JPanel comboPnlS = new JPanel();/// ���� South �г�
	JPanel comboPnlN = new JPanel();/// ���� North �г�
	
	////���� center �г�
	Border bordercombo = BorderFactory.createTitledBorder("");
	comboPnlC.setBorder(bordercombo);
	JPanel comboPnlL = new JPanel();  // �׸����� �г�!
	JPanel comboPnlR = new JPanel();	// ������ ������ư�̶� ���� �� �г�
	combo1 = new JRadioButton("�̱��޺�",true);
	combo2 = new JRadioButton("Ŀ���޺�");
	combo3 = new JRadioButton("�����޺�");
	
	combo1.setFont(new Font("Serif",Font.BOLD,20));
	combo2.setFont(new Font("Serif",Font.BOLD,20));
	combo3.setFont(new Font("Serif",Font.BOLD,20));
	
	JLabel combolbl1 = new JLabel("                       6500��");
	JLabel combolbl2 = new JLabel("                       9000��");
	JLabel combolbl3 = new JLabel("                       14000��");
	combolbl1.setFont(new Font("Serif",Font.BOLD,15));
	combolbl2.setFont(new Font("Serif",Font.BOLD,15));
	combolbl3.setFont(new Font("Serif",Font.BOLD,15));
	
	bg.add(combo1);
	bg.add(combo2);
	bg.add(combo3);
	comboPnlC.setLayout(new GridLayout(0,2));
	comboPnlR.setLayout(new GridLayout(12,0));
	comboPnlR.add(new JLabel());
	comboPnlR.add(combo1);
	comboPnlR.add(combolbl1);
	comboPnlR.add(new JLabel());
	comboPnlR.add(new JLabel());
	comboPnlR.add(combo2);
	comboPnlR.add(combolbl2);
	comboPnlR.add(new JLabel());
	comboPnlR.add(new JLabel());
	comboPnlR.add(combo3);
	comboPnlR.add(combolbl3);
	comboPnlR.add(new JLabel());
	////////////// ���� �̹���////////////////
	ImageIcon singleCombo = new ImageIcon("�̱��޺�.png"); 
	JLabel singleCombolbl = new JLabel(singleCombo);
	comboPnlL.add(singleCombolbl);
	ImageIcon coupleCombo = new ImageIcon("Ŀ���޺�.png"); 
	JLabel coupleCombolbl = new JLabel(coupleCombo);
	comboPnlL.add(coupleCombolbl);
	ImageIcon largeCombo = new ImageIcon("�����޺�.png"); 
	JLabel largeCombolbl = new JLabel(largeCombo);
	comboPnlL.add(largeCombolbl);
	/////////////////////////////////
	comboPnlC.add(comboPnlL);
	comboPnlC.add(comboPnlR);
	comboPnl.add(comboPnlC);
	////////////////// ���� North �г�
	JLabel	combo  = new JLabel("               �޺�");
	JLabel size4 = new JLabel("                                  ������");
	combo.setFont(new Font("Serif",Font.BOLD,30));
	size4.setFont(new Font("Serif",Font.BOLD,30));
	
	comboPnlN.add(combo);    
	comboPnlN.add(size4);
	comboPnl.add(comboPnlN,"North");
	
	////////////////// ���� South �г�
	btnbasket4 = new JButton("���");
	btnbasket4.addActionListener(this);
	
	comboPnlS.add(btnbasket4);
	comboPnl.add(comboPnlS,"South");
	
	///////////////// ���� East�г�
	JPanel comboPnlE2 = new JPanel();
	JPanel comboPnlE3 = new JPanel();
	Border bordercombo2 = BorderFactory.createTitledBorder("");
	comboPnlE2.setBorder(bordercombo2);
	Border bordercombo3 = BorderFactory.createTitledBorder("");
	comboPnlE3.setBorder(bordercombo3);
	comboPnlE.setLayout(new BorderLayout());
	comboPnlE2.setLayout(new GridLayout(0,1));
	comboPnlE3.setLayout(new GridLayout(0,1));
	JLabel combolbl8 = new JLabel("       ���� ");
	txt4 = new JLabel("",SwingConstants.CENTER);
	combolbl8.setFont(new Font("Serif",Font.BOLD,30));
	JLabel combolbl5 = new JLabel("             +1000��");
	combolbl5.setEnabled(false);
	combolbl5.setFont(new Font("Serif",Font.BOLD,15));
	combo4 = new JRadioButton("    M                       ",true);
	combo5 = new JRadioButton("    L                       ");
	combo4.setEnabled(false);
	combo5.setEnabled(false);
	combo4.setFont(new Font("Serif",Font.BOLD,20));
	combo5.setFont(new Font("Serif",Font.BOLD,20));
	bg2.add(combo4);
	bg2.add(combo5);
	comboPnlE2.add(new JLabel());
	comboPnlE2.add(combo4); 
	comboPnlE2.add(new JLabel());
	comboPnlE2.add(combo5);
	comboPnlE2.add(combolbl5);
	comboPnlE2.add(new JLabel());

	txt4.setText("1");
	txt4.setFont(new Font("Serif",Font.BOLD,30));
	JLabel lblbl3 = new JLabel(" ");
	comboPnlE3.add(lblbl3);
	comboPnlE3.add(combolbl8);
	up4 = new JButton(upup);
	dw4 = new JButton(dwdw);
	btnOption(up4);
	btnOption(dw4);
	up4.addActionListener(this);
	dw4.addActionListener(this);
	up4.setBackground(Color.WHITE);
	dw4.setBackground(Color.WHITE);
	comboPnlE3.add(up4);
	comboPnlE3.add(txt4);
	comboPnlE3.add(dw4);
	
	comboPnlE.add(comboPnlE2,"North");
	comboPnlE.add(comboPnlE3,"South");
	comboPnl.add(comboPnlE,"East");
	tab.add("�޺�",comboPnl);
	//////////////////���� //////////////////////////
	comboPnlE.setBackground(Color.WHITE);comboPnlS.setBackground(Color.WHITE);comboPnlN.setBackground(Color.WHITE);comboPnlR.setBackground(Color.WHITE);comboPnlC.setBackground(Color.WHITE);
	combo1.setBackground(Color.WHITE);combo2.setBackground(Color.WHITE);combo3.setBackground(Color.WHITE);combo4.setBackground(Color.WHITE);combo5.setBackground(Color.WHITE);
	comboPnlL.setBackground(Color.WHITE);comboPnlE2.setBackground(Color.WHITE);comboPnlE3.setBackground(Color.WHITE);comboPnlE.setBackground(Color.WHITE);txt4.setBackground(Color.WHITE);
}
	void TablePanel(){// ��� �г�
	JPanel downPnl = new JPanel(new BorderLayout());
	JPanel downPnl1 = new JPanel();
	JPanel downPnl2 = new JPanel();
	JPanel downPnl3 = new JPanel();
	JPanel downPnl4 = new JPanel();
	JPanel downPnlL = new JPanel(new BorderLayout());
	JPanel downPnlR = new JPanel(new BorderLayout());

	model = new DefaultTableModel(contents, header){/////// ���̺� ���� �Ұ�
		 @Override
		    public boolean isCellEditable(int row, int column) {
		        if (column >= 0) {
		            return false;
		        } else {
		            return true;
		        }
		    }
	};
	table = new JTable(model);
	JScrollPane sp = new JScrollPane(table);

	sp.setPreferredSize(new Dimension(530,170));
	table.getColumn("��ǰ��").setPreferredWidth(150);
	table.getColumn("����").setPreferredWidth(15);
	table.getColumn("������").setPreferredWidth(15);
	downPnl1.add(sp);
	sp.setBackground(Color.WHITE);
	
	lbltotal = new JLabel("���� �ݾ� :                                0��" );
	lbltotal.setFont(new Font("Serif",Font.BOLD,30));
	downPnl2.add(lbltotal);
	
	ImageIcon shop = new ImageIcon("buy.png");
	ImageIcon delete = new ImageIcon("delete.png");
	
	btndelete = new JButton(delete);
	btnorder = new JButton(shop);
	btnOption(btndelete);
	btnOption(btnorder);
	btndelete.addActionListener(this);
	btnorder.addActionListener(this);
	downPnl3.add(btndelete);
	downPnl4.add(btnorder);
	
	downPnlL.add(downPnl1,"Center");
	downPnlL.add(downPnl2,"South");
	downPnlR.add(downPnl3,"Center");
	downPnlR.add(downPnl4,"South");
	downPnl.add(downPnlL,"Center");
	downPnl.add(downPnlR,"East");
	centerPnl.add(downPnl,"South");
	
	downPnl1.setBackground(Color.WHITE);downPnl2.setBackground(Color.WHITE);downPnl3.setBackground(Color.WHITE);downPnl4.setBackground(Color.WHITE);
	table.setBackground(Color.WHITE);table.getParent().setBackground(Color.white);
	}
	void UpPanel(){//�޹�� �� Green Cinema �г�
		ImageIcon imgName = new ImageIcon("�̸�.PNG");
		Image image = imgName.getImage();
		Image changeImage = image.getScaledInstance(700,100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImage);
		JLabel lb1 = new JLabel(changeIcon);
		this.add(lb1,"North");
		//�ؿ� ��ư �ֱ�
		JPanel pn = new JPanel(new BorderLayout());
		pn.setBackground(new Color(39,38,64));
		
		ImageIcon imgBtn1 = new ImageIcon("home_w.gif");
		Image image2 = imgBtn1.getImage();
		Image changeImage2 = image2.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImage2);
		btnBack = new JButton(changeIcon2);
		
//		ImageIcon imgBtn2 = new ImageIcon("üũ_���.gif");
//		Image image3 = imgBtn2.getImage();
//		Image changeImage3 = image3.getScaledInstance(70,70, Image.SCALE_SMOOTH);
//		ImageIcon changeIcon3 = new ImageIcon(changeImage3);
//		btnOk = new JButton(changeIcon3);
		
		btnBack.setBorderPainted(false);
//		btnOk.setBorderPainted(false);
		btnBack.setFocusPainted(false);
//		btnOk.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
//		btnOk.setContentAreaFilled(false);
		btnBack.addActionListener(this);
//		btnOk.addActionListener(this);
		
		pn.add(btnBack,"Center");

		this.add(pn,"South");
	}
	//////////////////	��� �޼���
	void Popcon(String str,int a){
		int curr=-1;
		int count=Integer.parseInt(txt.getText());
		if(pop1.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("�������� ����")){
					if(table.getValueAt(i,1).equals(str)){
						curr = i;
						break;
					}
				}
			}///// �̹� �ٿ� �ִ��� Ȯ���ϰ� �ִٸ� ���� ��ġ�� curr�� ����
			
			if(curr !=-1){ //�����̶� �����Ѵٸ�
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(5000+a)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"�������� ����",str,txt.getText(),(5000+a)*Integer.parseInt(txt.getText())+""};
				model.addRow(s);
			}
	}
	
	}
	void cheezePop(String str,int a){
		int curr=-1;
		int count=Integer.parseInt(txt.getText());
		if(pop2.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("ġ�� ����")){
					if(table.getValueAt(i,1).equals(str)){
						curr = i;
						break;
					}
				}
			}///// �̹� �ٿ� �ִ��� Ȯ���ϰ� �ִٸ� ���� ��ġ�� curr�� ����
			
			if(curr !=-1){ //�����̶� �����Ѵٸ�
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(6000+a)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"ġ�� ����",str,txt.getText(),(6000+a)*Integer.parseInt(txt.getText())+""};
				model.addRow(s);
			}
	}
	}
	void caramelPop(String str,int a){
		int curr=-1;
		int count=Integer.parseInt(txt.getText());
		if(pop3.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("ī��� ����")){
					if(table.getValueAt(i,1).equals(str)){
						curr = i;
						break;
					}
				}
			}///// �̹� �ٿ� �ִ��� Ȯ���ϰ� �ִٸ� ���� ��ġ�� curr�� ����
			
			if(curr !=-1){ //�����̶� �����Ѵٸ�
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(6500+a)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"ī��� ����",str,txt.getText(),(6500+a)*Integer.parseInt(txt.getText())+""};
				model.addRow(s);
			}
	}
	}
	void coke(String str,int a){
		int curr=-1;
		int count=Integer.parseInt(txt2.getText());
		if(coke1.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("�ݶ�")){
					if(table.getValueAt(i,1).equals(str)){
						curr = i;
						break;
					}
				}
			}///// �̹� �ٿ� �ִ��� Ȯ���ϰ� �ִٸ� ���� ��ġ�� curr�� ����
			
			if(curr !=-1){ //�����̶� �����Ѵٸ�
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(2000+a)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"�ݶ�",str,txt2.getText(),(2000+a)*Integer.parseInt(txt2.getText())+""};
				model.addRow(s);
			}
	}
	
	}
	void mountin(String str,int a){
		int curr=-1;
		int count=Integer.parseInt(txt2.getText());
		if(coke2.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("�Ƹ޸�ī��")){
					if(table.getValueAt(i,1).equals(str)){
						curr = i;
						break;
					}
				}
			}///// �̹� �ٿ� �ִ��� Ȯ���ϰ� �ִٸ� ���� ��ġ�� curr�� ����
			
			if(curr !=-1){ //�����̶� �����Ѵٸ�
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(2000+a)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"�Ƹ޸�ī��",str,txt2.getText(),(2000+a)*Integer.parseInt(txt2.getText())+""};
				model.addRow(s);
			}
	}
	}
	void ade(String str,int a){
		int curr=-1;
		int count=Integer.parseInt(txt2.getText());
		if(coke3.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("�Ƹ޸�ī��(ICED)")){
					if(table.getValueAt(i,1).equals(str)){
						curr = i;
						break;
					}
				}
			}///// �̹� �ٿ� �ִ��� Ȯ���ϰ� �ִٸ� ���� ��ġ�� curr�� ����
			
			if(curr !=-1){ //�����̶� �����Ѵٸ�
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(2500+a)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"�Ƹ޸�ī��(ICED)",str,txt2.getText(),(2500+a)*Integer.parseInt(txt2.getText())+""};
				model.addRow(s);
			}
	}
	}
	void naCho(){
		int curr=-1;
		int count=Integer.parseInt(txt3.getText());
		if(side1.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("����")){
						curr = i;
						break;
					
				}
			}///// �̹� �ٿ� �ִ��� Ȯ���ϰ� �ִٸ� ���� ��ġ�� curr�� ����
			
			if(curr !=-1){ //�����̶� �����Ѵٸ�
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(4000)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"����","-",txt3.getText(),(4000)*Integer.parseInt(txt3.getText())+""};
				model.addRow(s);
			}
	}
	
	}
	void squid(){
		int curr=-1;
		int count=Integer.parseInt(txt2.getText());
		if(side2.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("��¡��")){
						curr = i;
						break;
				}
			}///// �̹� �ٿ� �ִ��� Ȯ���ϰ� �ִٸ� ���� ��ġ�� curr�� ����
			
			if(curr !=-1){ //�����̶� �����Ѵٸ�
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(5000)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"��¡��","-",txt3.getText(),(5000)*Integer.parseInt(txt3.getText())+""};
				model.addRow(s);
			}
	}
	}
	void hotdog(){
		int curr=-1;
		int count=Integer.parseInt(txt2.getText());
		if(side3.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("�ֵ���")){
						curr = i;
						break;
				}
			}///// �̹� �ٿ� �ִ��� Ȯ���ϰ� �ִٸ� ���� ��ġ�� curr�� ����
			
			if(curr !=-1){ //�����̶� �����Ѵٸ�
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(3000)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"�ֵ���","-",txt3.getText(),(3000)*Integer.parseInt(txt3.getText())+""};
				model.addRow(s);
			}
	}
	}
	void singleCombo(){
		int curr=-1;
		int count=Integer.parseInt(txt4.getText());
		if(combo1.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("�̱��޺�")){
						curr = i;
						break;
					
				}
			}///// �̹� �ٿ� �ִ��� Ȯ���ϰ� �ִٸ� ���� ��ġ�� curr�� ����
			
			if(curr !=-1){ //�����̶� �����Ѵٸ�
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(6500)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"�̱��޺�","-",txt4.getText(),(6500)*Integer.parseInt(txt4.getText())+""};
				model.addRow(s);
			}
	}
	
	}
	void coupleCombo(){
		int curr=-1;
		int count=Integer.parseInt(txt4.getText());
		if(combo2.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("Ŀ���޺�")){
						curr = i;
						break;
				}
			}///// �̹� �ٿ� �ִ��� Ȯ���ϰ� �ִٸ� ���� ��ġ�� curr�� ����
			
			if(curr !=-1){ //�����̶� �����Ѵٸ�
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(9000)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"Ŀ���޺�","-",txt4.getText(),(9000)*Integer.parseInt(txt4.getText())+""};
				model.addRow(s);
			}
	}
	}
	void largeCombo(){
		int curr=-1;
		int count=Integer.parseInt(txt4.getText());
		if(combo3.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("�����޺�")){
						curr = i;
						break;
				}
			}///// �̹� �ٿ� �ִ��� Ȯ���ϰ� �ִٸ� ���� ��ġ�� curr�� ����
			
			if(curr !=-1){ //�����̶� �����Ѵٸ�
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(14000)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"�����޺�","-",txt4.getText(),(14000)*Integer.parseInt(txt4.getText())+""};
				model.addRow(s);
			}
	}
	}
	/////////////////////
	void sum(){
		moneysum=0;
		int row = table.getRowCount();
		for(int j=0;j<row;j++){
			moneysum += Integer.parseInt(table.getValueAt(j, 3)+"");
		}
		lbltotal.setText("���� �ݾ� :                                "+ moneysum + "��" );
		
	}
	void Order(){
	 
		if(pop4.isSelected()==true){
			Popcon("M",0);
			cheezePop("M",0);
			caramelPop("M",0);
		}else if(pop5.isSelected()==true){
			Popcon("L",1000);
			cheezePop("L",1000);
			caramelPop("L",1000);
		}	
		if(coke4.isSelected()==true){
			coke("M",0);
			mountin("M",0);
			ade("M",0);
		}else if(coke5.isSelected()==true){
			coke("L",1000);
			mountin("L",1000);
			ade("L",1000);
		}			
		
		if(side1.isSelected()==true){	
			naCho();
		}else if(side2.isSelected()==true){
			squid();
		}else if(side3.isSelected()==true){
			hotdog();
		}
		if(combo1.isSelected()==true){	
			singleCombo();
		}else if(combo2.isSelected()==true){
			coupleCombo();
		}else if(combo3.isSelected()==true){
			largeCombo();
		}
	
		}
	void celremove(){
		
		selRow = table.getSelectedRow();
		if(selRow == -1){
			JOptionPane.showMessageDialog(mf,"����� �������ּ���!");
		}else{
			model.removeRow(selRow);
		}
	}
	void Basket(ActionEvent arg0){
		if(arg0.getSource()==btnbasket){
			Order();
			sum();
			txt.setText("1");
		}else if(arg0.getSource()==btnbasket2){
			Order();
			sum();
			txt2.setText("1");
		}else if(arg0.getSource()==btnbasket3){
			Order();
			sum();
			txt3.setText("1");
		}else if(arg0.getSource()==btnbasket4){
			Order();
			sum();
			txt4.setText("1");
		}else if(arg0.getSource()==btndelete){
			celremove();
			sum();
		}
	}
	void UpDown(ActionEvent arg0){
		if(arg0.getSource()==up){
			txt.setText(Integer.parseInt(txt.getText())+1+"");	
		}else if(arg0.getSource()==dw){
			txt.setText(Integer.parseInt(txt.getText())-1+"");	
		}else if(arg0.getSource()==up2){
			txt2.setText(Integer.parseInt(txt2.getText())+1+"");	
		}else if(arg0.getSource()==dw2){
			txt2.setText(Integer.parseInt(txt2.getText())-1+"");	
		}else if(arg0.getSource()==up3){
			txt3.setText(Integer.parseInt(txt3.getText())+1+"");	
		}else if(arg0.getSource()==dw3){
			txt3.setText(Integer.parseInt(txt3.getText())-1+"");	
		}else if(arg0.getSource()==up4){
			txt4.setText(Integer.parseInt(txt4.getText())+1+"");	
		}else if(arg0.getSource()==dw4){
			txt4.setText(Integer.parseInt(txt4.getText())-1+"");	
		}
		if(Integer.parseInt(txt.getText())<1){	
			txt.setText("1");
			JOptionPane.showMessageDialog(mf,"1���̻� �������ּ���.");	
		}
		if(Integer.parseInt(txt2.getText())<1){	
			txt2.setText("1");
			JOptionPane.showMessageDialog(mf,"1���̻� �������ּ���.");	
		}
		if(Integer.parseInt(txt3.getText())<1){	
			txt3.setText("1");
			JOptionPane.showMessageDialog(mf,"1���̻� �������ּ���.");	
		}
		if(Integer.parseInt(txt4.getText())<1){	
			txt4.setText("1");
			JOptionPane.showMessageDialog(mf,"1���̻� �������ּ���.");	
		}
	}
	void btnOption(JButton btn){
		btn.setBorderPainted(false); //��ư ���� ����
		btn.setFocusPainted(false); //��ư Ŭ�� ���� ����
		btn.setContentAreaFilled(false); //��ư ��� ����
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		Basket(arg0);
		UpDown(arg0);
		if (arg0.getSource() == btnorder){//���� ȭ��
			if (moneysum == 0){
				JOptionPane.showMessageDialog(mf,"�޴��� �������ּ���.");	
			} else {
				boolean whichOne = 	true; //��������, Ƽ�� �������� Ȯ��
				int howMuch = moneysum; //���� �޾ƿ���
				
				mf.cafeteria_CafeteriaMainToNext(1,whichOne,howMuch);
			}
		} else if(arg0.getSource() == btnBack){ //Ȩ����
			boolean whichOne = 	true; //��������, Ƽ�� �������� Ȯ��
			int howMuch = 0; //���� �޾ƿ���
			mf.cafeteria_CafeteriaMainToNext(2, whichOne, howMuch);
		}	
	}	

}