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
	private String header[] = {"상품명","사이즈","개수","가격"};
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
	void PopconPanel(){// 탭 - 팝콘
		JPanel popPnl = new JPanel();	
		popPnl.setLayout(new BorderLayout()); ///팝콘 패널의 전체 틀
		popPnl.setPreferredSize(new Dimension(650,510));
		
		JPanel popPnlC = new JPanel();///팝콘 센터 패널
		JPanel popPnlE = new JPanel();///팝콘 East 패널
		JPanel popPnlS = new JPanel();/// 팝콘 South 패널
		JPanel popPnlN = new JPanel();/// 팝콘 North 패널
		
		////팝콘 center 패널
		Border borderC = BorderFactory.createTitledBorder("");
		popPnlC.setBorder(borderC);
		JPanel popPnlL = new JPanel();  //나중에 그림넣을 패널!
		JPanel popPnlR = new JPanel();	// 오른쪽 라디오버튼이랑 글자 들어갈 패널
		pop1 = new JRadioButton("오리지널 팝콘",true);
		pop2 = new JRadioButton("치즈 팝콘");
		pop3 = new JRadioButton("카라멜 팝콘");
		
		pop1.setFont(new Font("Serif",Font.BOLD,20));
		pop2.setFont(new Font("Serif",Font.BOLD,20));
		pop3.setFont(new Font("Serif",Font.BOLD,20));
		
		JLabel lbl1 = new JLabel("                   M   5000원");
		JLabel lbl2 = new JLabel("                   M   6000원");
		JLabel lbl3 = new JLabel("                   M   6500원");
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
		////////////// 팝콘 이미지////////////////
		ImageIcon original = new ImageIcon("오리지널팝콘.png"); 
		JLabel originalpop = new JLabel(original);
		popPnlL.add(originalpop);
		ImageIcon cheeze= new ImageIcon("치즈팝콘.png"); 
		JLabel cheezepop = new JLabel(cheeze);
		popPnlL.add(cheezepop);
		ImageIcon caramel = new ImageIcon("카라멜팝콘.png"); 
		JLabel caramelpop = new JLabel(caramel);
		popPnlL.add(caramelpop);
		/////////////////////////////////
		popPnlC.add(popPnlL);
		popPnlC.add(popPnlR);
		popPnl.add(popPnlC);
		////////////////// 팝콘 North 패널
		JLabel popcon = new JLabel("               팝콘");
		JLabel size = new JLabel("                                  사이즈");
		popcon.setFont(new Font("Serif",Font.BOLD,30));
		size.setFont(new Font("Serif",Font.BOLD,30));
		
		popPnlN.add(popcon);    
		popPnlN.add(size);
		popPnl.add(popPnlN,"North");
		////////////////// 팝콘 South 패널
		btnbasket = new JButton("담기");
		btnbasket.addActionListener(this);
		popPnlS.add(btnbasket);
		popPnl.add(popPnlS,"South");
		///////////////// 팝콘 East패널
		JPanel popPnlE2 = new JPanel();
		JPanel popPnlE3 = new JPanel();
		Border borderE2 = BorderFactory.createTitledBorder("");
		popPnlE2.setBorder(borderE2);
		popPnlE3.setBorder(borderE2);
		popPnlE.setLayout(new BorderLayout());
		popPnlE2.setLayout(new GridLayout(0,1));
		popPnlE3.setLayout(new GridLayout(0,1));

		JLabel lbl8 = new JLabel("       수량 ");
		txt = new JLabel("",SwingConstants.CENTER);
		txt.setFont(new Font("Serif",Font.BOLD,30));
		lbl8.setFont(new Font("Serif",Font.BOLD,30));
		JLabel lbl5 = new JLabel("             +1000원");
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
		tab.add("팝콘",popPnl);
		///////// 흰배경
		popPnlE.setBackground(Color.WHITE);popPnlS.setBackground(Color.WHITE);
		popPnlN.setBackground(Color.WHITE);popPnlR.setBackground(Color.WHITE);popPnlC.setBackground(Color.WHITE);pop1.setBackground(Color.WHITE);
		pop2.setBackground(Color.WHITE);pop3.setBackground(Color.WHITE);pop4.setBackground(Color.WHITE);pop5.setBackground(Color.WHITE);
		popPnlL.setBackground(Color.WHITE);txt.setBackground(Color.WHITE);popPnlE2.setBackground(Color.WHITE);popPnlE3.setBackground(Color.WHITE);
		popPnlE.setBackground(Color.WHITE);
	} 
	void CokePanel(){// 탭 - 음료
		
		JPanel cokePnl = new JPanel();
		
		cokePnl.setLayout(new BorderLayout()); ///음료 패널의 전체 틀
		cokePnl.setPreferredSize(new Dimension(650,480));
		JPanel cokePnlC = new JPanel();///음료 센터 패널
		JPanel cokePnlE = new JPanel();///음료 East 패널
		JPanel cokePnlS = new JPanel();/// 음료 South 패널
		JPanel cokePnlN = new JPanel();/// 음료 North 패널
		
		////음료 center 패널
		Border borderCoke = BorderFactory.createTitledBorder("");
		cokePnlC.setBorder(borderCoke);
		JPanel cokePnlL = new JPanel();  // 그림넣을 패널!
		JPanel cokePnlR = new JPanel();	// 오른쪽 라디오버튼이랑 글자 들어갈 패널
		
		coke1 = new JRadioButton("콜라",true);
		coke2 = new JRadioButton("아메리카노");
		coke3 = new JRadioButton("아메리카노(ICED)");
		
		coke1.setFont(new Font("Serif",Font.BOLD,20));
		coke2.setFont(new Font("Serif",Font.BOLD,20));
		coke3.setFont(new Font("Serif",Font.BOLD,20));
		
		JLabel cokelbl1 = new JLabel("                   M   2000원");
		JLabel cokelbl2 = new JLabel("                   M   2000원");
		JLabel cokelbl3 = new JLabel("                   M   2500원");
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
		////////////// 음료 이미지////////////////
		ImageIcon coke = new ImageIcon("콜라.png"); 
		JLabel cokelbl = new JLabel(coke);
		cokePnlL.add(cokelbl);
		ImageIcon mountin= new ImageIcon("따아.png"); 
		JLabel mountinlbl = new JLabel(mountin);
		cokePnlL.add(mountinlbl);
		ImageIcon ade = new ImageIcon("아아.png"); 
		JLabel adelbl = new JLabel(ade);
		cokePnlL.add(adelbl);
		/////////////////////////////////
		cokePnlC.add(cokePnlL);
		cokePnlC.add(cokePnlR);	
		cokePnl.add(cokePnlC);
		////////////////// 음료 North 패널
		JLabel	beverage  = new JLabel("               음료");
		JLabel size2 = new JLabel("                                  사이즈");
		beverage.setFont(new Font("Serif",Font.BOLD,30));
		size2.setFont(new Font("Serif",Font.BOLD,30));
		
		cokePnlN.add(beverage);    
		cokePnlN.add(size2);
		cokePnl.add(cokePnlN,"North");
		
		////////////////// 음료 South 패널
		btnbasket2 = new JButton("담기");
		btnbasket2.addActionListener(this);
		
		cokePnlS.add(btnbasket2);
		cokePnl.add(cokePnlS,"South");
		
		///////////////// 음료 East패널
		JPanel cokePnlE2 = new JPanel();
		JPanel cokePnlE3 = new JPanel();
		Border borderCoke2 = BorderFactory.createTitledBorder("");
		cokePnlE2.setBorder(borderCoke2);
		Border borderCoke3 = BorderFactory.createTitledBorder("");
		cokePnlE3.setBorder(borderCoke3);
		cokePnlE.setLayout(new BorderLayout());
		cokePnlE2.setLayout(new GridLayout(0,1));
		cokePnlE3.setLayout(new GridLayout(0,1));
		JLabel cokelbl8 = new JLabel("       수량 ");
		txt2 = new JLabel("",SwingConstants.CENTER);
		cokelbl8.setFont(new Font("Serif",Font.BOLD,30));
		JLabel cokelbl5 = new JLabel("             +1000원");
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
		tab.add("음료",cokePnl);
		////////흰 배경//////
		cokePnlE.setBackground(Color.WHITE);cokePnlS.setBackground(Color.WHITE);cokePnlN.setBackground(Color.WHITE);cokePnlR.setBackground(Color.WHITE);
		cokePnlC.setBackground(Color.WHITE);coke1.setBackground(Color.WHITE);coke2.setBackground(Color.WHITE);coke3.setBackground(Color.WHITE);
		coke4.setBackground(Color.WHITE);coke5.setBackground(Color.WHITE);cokePnlL.setBackground(Color.WHITE);cokePnlE2.setBackground(Color.WHITE);
		cokePnlE3.setBackground(Color.WHITE);cokePnlE.setBackground(Color.WHITE);txt2.setBackground(Color.WHITE);
	}	
	void SidePanel(){// 탭 - 사이드
		//////////////////////사이드시작 	sidePnl
		JPanel sidePnl = new JPanel();
		
		sidePnl.setLayout(new BorderLayout()); ///사이드 패널의 전체 틀
		sidePnl.setPreferredSize(new Dimension(650,480));
		JPanel sidePnlC = new JPanel();///사이드 센터 패널
		JPanel sidePnlE = new JPanel();///사이드 East 패널
		JPanel sidePnlS = new JPanel();/// 사이드 South 패널
		JPanel sidePnlN = new JPanel();/// 사이드 North 패널
		
		////사이드 center 패널
		Border borderside = BorderFactory.createTitledBorder("");
		sidePnlC.setBorder(borderside);
		JPanel sidePnlL = new JPanel();  // 그림넣을 패널!
		JPanel sidePnlR = new JPanel();	// 오른쪽 라디오버튼이랑 글자 들어갈 패널
		side1 = new JRadioButton("나쵸",true);
		side2 = new JRadioButton("오징어");
		side3 = new JRadioButton("핫도그");
		
		side1.setFont(new Font("Serif",Font.BOLD,20));
		side2.setFont(new Font("Serif",Font.BOLD,20));
		side3.setFont(new Font("Serif",Font.BOLD,20));
		
		JLabel sidelbl1 = new JLabel("                       4000원");
		JLabel sidelbl2 = new JLabel("                       5000원");
		JLabel sidelbl3 = new JLabel("                       3000원");
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
		////////////// 사이드 이미지////////////////	
		ImageIcon nacho = new ImageIcon("나쵸.png"); 
		JLabel nacholbl = new JLabel(nacho);
		sidePnlL.add(nacholbl);
		ImageIcon squid= new ImageIcon("오징어.png"); 
		JLabel squidlbl = new JLabel(squid);
		sidePnlL.add(squidlbl);
		ImageIcon hotdog = new ImageIcon("핫도그.png"); 
		JLabel hotdoglbl = new JLabel(hotdog);
		sidePnlL.add(hotdoglbl);
		/////////////////////////////////
		sidePnlC.add(sidePnlL);
		sidePnlC.add(sidePnlR);
		sidePnl.add(sidePnlC);
		////////////////// 사이드 North 패널
		JLabel side = new JLabel("               사이드");
		JLabel size3 = new JLabel("                              사이즈");
		side.setFont(new Font("Serif",Font.BOLD,30));
		size3.setFont(new Font("Serif",Font.BOLD,30));
		
		sidePnlN.add(side);    
		sidePnlN.add(size3);
		sidePnl.add(sidePnlN,"North");
		
		////////////////// 사이드 South 패널
		btnbasket3 = new JButton("담기");
		btnbasket3.addActionListener(this);
		sidePnlS.add(btnbasket3);
		sidePnl.add(sidePnlS,"South");
		///////////////// 사이드 East패널
		JPanel sidePnlE2 = new JPanel();
		JPanel sidePnlE3 = new JPanel();
		Border borderside2 = BorderFactory.createTitledBorder("");
		sidePnlE2.setBorder(borderside2);
		Border borderside3 = BorderFactory.createTitledBorder("");
		sidePnlE3.setBorder(borderside3);
		sidePnlE.setLayout(new BorderLayout());
		sidePnlE2.setLayout(new GridLayout(0,1));
		sidePnlE3.setLayout(new GridLayout(0,1));
		JLabel sidelbl8 = new JLabel("       수량 ");
		txt3 = new JLabel("",SwingConstants.CENTER);
		sidelbl8.setFont(new Font("Serif",Font.BOLD,30));
		JLabel sidelbl5 = new JLabel("             +1000원");
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
		tab.add("사이드",sidePnl);
		///////////////////////흰배경//////////////////
		sidePnlE.setBackground(Color.WHITE);sidePnlS.setBackground(Color.WHITE);sidePnlN.setBackground(Color.WHITE);sidePnlR.setBackground(Color.WHITE);
		sidePnlC.setBackground(Color.WHITE);side1.setBackground(Color.WHITE);side2.setBackground(Color.WHITE);side3.setBackground(Color.WHITE);
		side4.setBackground(Color.WHITE);side5.setBackground(Color.WHITE);sidePnlL.setBackground(Color.WHITE);sidePnlE2.setBackground(Color.WHITE);
		sidePnlE3.setBackground(Color.WHITE);sidePnlE.setBackground(Color.WHITE);txt3.setBackground(Color.WHITE);
	}
	void ComboPanel(){// 탭 - 콤보
	JPanel comboPnl = new JPanel();
	comboPnl.setLayout(new BorderLayout()); ///음료 패널의 전체 틀
	comboPnl.setPreferredSize(new Dimension(650,510));
	JPanel comboPnlC = new JPanel();///음료 센터 패널
	JPanel comboPnlE = new JPanel();///음료 East 패널
	JPanel comboPnlS = new JPanel();/// 음료 South 패널
	JPanel comboPnlN = new JPanel();/// 음료 North 패널
	
	////음료 center 패널
	Border bordercombo = BorderFactory.createTitledBorder("");
	comboPnlC.setBorder(bordercombo);
	JPanel comboPnlL = new JPanel();  // 그림넣을 패널!
	JPanel comboPnlR = new JPanel();	// 오른쪽 라디오버튼이랑 글자 들어갈 패널
	combo1 = new JRadioButton("싱글콤보",true);
	combo2 = new JRadioButton("커플콤보");
	combo3 = new JRadioButton("라지콤보");
	
	combo1.setFont(new Font("Serif",Font.BOLD,20));
	combo2.setFont(new Font("Serif",Font.BOLD,20));
	combo3.setFont(new Font("Serif",Font.BOLD,20));
	
	JLabel combolbl1 = new JLabel("                       6500원");
	JLabel combolbl2 = new JLabel("                       9000원");
	JLabel combolbl3 = new JLabel("                       14000원");
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
	////////////// 음료 이미지////////////////
	ImageIcon singleCombo = new ImageIcon("싱글콤보.png"); 
	JLabel singleCombolbl = new JLabel(singleCombo);
	comboPnlL.add(singleCombolbl);
	ImageIcon coupleCombo = new ImageIcon("커플콤보.png"); 
	JLabel coupleCombolbl = new JLabel(coupleCombo);
	comboPnlL.add(coupleCombolbl);
	ImageIcon largeCombo = new ImageIcon("라지콤보.png"); 
	JLabel largeCombolbl = new JLabel(largeCombo);
	comboPnlL.add(largeCombolbl);
	/////////////////////////////////
	comboPnlC.add(comboPnlL);
	comboPnlC.add(comboPnlR);
	comboPnl.add(comboPnlC);
	////////////////// 음료 North 패널
	JLabel	combo  = new JLabel("               콤보");
	JLabel size4 = new JLabel("                                  사이즈");
	combo.setFont(new Font("Serif",Font.BOLD,30));
	size4.setFont(new Font("Serif",Font.BOLD,30));
	
	comboPnlN.add(combo);    
	comboPnlN.add(size4);
	comboPnl.add(comboPnlN,"North");
	
	////////////////// 음료 South 패널
	btnbasket4 = new JButton("담기");
	btnbasket4.addActionListener(this);
	
	comboPnlS.add(btnbasket4);
	comboPnl.add(comboPnlS,"South");
	
	///////////////// 음료 East패널
	JPanel comboPnlE2 = new JPanel();
	JPanel comboPnlE3 = new JPanel();
	Border bordercombo2 = BorderFactory.createTitledBorder("");
	comboPnlE2.setBorder(bordercombo2);
	Border bordercombo3 = BorderFactory.createTitledBorder("");
	comboPnlE3.setBorder(bordercombo3);
	comboPnlE.setLayout(new BorderLayout());
	comboPnlE2.setLayout(new GridLayout(0,1));
	comboPnlE3.setLayout(new GridLayout(0,1));
	JLabel combolbl8 = new JLabel("       수량 ");
	txt4 = new JLabel("",SwingConstants.CENTER);
	combolbl8.setFont(new Font("Serif",Font.BOLD,30));
	JLabel combolbl5 = new JLabel("             +1000원");
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
	tab.add("콤보",comboPnl);
	//////////////////흰배경 //////////////////////////
	comboPnlE.setBackground(Color.WHITE);comboPnlS.setBackground(Color.WHITE);comboPnlN.setBackground(Color.WHITE);comboPnlR.setBackground(Color.WHITE);comboPnlC.setBackground(Color.WHITE);
	combo1.setBackground(Color.WHITE);combo2.setBackground(Color.WHITE);combo3.setBackground(Color.WHITE);combo4.setBackground(Color.WHITE);combo5.setBackground(Color.WHITE);
	comboPnlL.setBackground(Color.WHITE);comboPnlE2.setBackground(Color.WHITE);comboPnlE3.setBackground(Color.WHITE);comboPnlE.setBackground(Color.WHITE);txt4.setBackground(Color.WHITE);
}
	void TablePanel(){// 계산 패널
	JPanel downPnl = new JPanel(new BorderLayout());
	JPanel downPnl1 = new JPanel();
	JPanel downPnl2 = new JPanel();
	JPanel downPnl3 = new JPanel();
	JPanel downPnl4 = new JPanel();
	JPanel downPnlL = new JPanel(new BorderLayout());
	JPanel downPnlR = new JPanel(new BorderLayout());

	model = new DefaultTableModel(contents, header){/////// 테이블 수정 불가
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
	table.getColumn("상품명").setPreferredWidth(150);
	table.getColumn("개수").setPreferredWidth(15);
	table.getColumn("사이즈").setPreferredWidth(15);
	downPnl1.add(sp);
	sp.setBackground(Color.WHITE);
	
	lbltotal = new JLabel("결제 금액 :                                0원" );
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
	void UpPanel(){//뒷배경 위 Green Cinema 패널
		ImageIcon imgName = new ImageIcon("이름.PNG");
		Image image = imgName.getImage();
		Image changeImage = image.getScaledInstance(700,100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImage);
		JLabel lb1 = new JLabel(changeIcon);
		this.add(lb1,"North");
		//밑에 버튼 넣기
		JPanel pn = new JPanel(new BorderLayout());
		pn.setBackground(new Color(39,38,64));
		
		ImageIcon imgBtn1 = new ImageIcon("home_w.gif");
		Image image2 = imgBtn1.getImage();
		Image changeImage2 = image2.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImage2);
		btnBack = new JButton(changeIcon2);
		
//		ImageIcon imgBtn2 = new ImageIcon("체크_흰색.gif");
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
	//////////////////	계산 메서드
	void Popcon(String str,int a){
		int curr=-1;
		int count=Integer.parseInt(txt.getText());
		if(pop1.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("오리지널 팝콘")){
					if(table.getValueAt(i,1).equals(str)){
						curr = i;
						break;
					}
				}
			}///// 이미 줄에 있는지 확인하고 있다면 줄의 위치를 curr에 담음
			
			if(curr !=-1){ //한줄이라도 존재한다면
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(5000+a)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"오리지널 팝콘",str,txt.getText(),(5000+a)*Integer.parseInt(txt.getText())+""};
				model.addRow(s);
			}
	}
	
	}
	void cheezePop(String str,int a){
		int curr=-1;
		int count=Integer.parseInt(txt.getText());
		if(pop2.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("치즈 팝콘")){
					if(table.getValueAt(i,1).equals(str)){
						curr = i;
						break;
					}
				}
			}///// 이미 줄에 있는지 확인하고 있다면 줄의 위치를 curr에 담음
			
			if(curr !=-1){ //한줄이라도 존재한다면
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(6000+a)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"치즈 팝콘",str,txt.getText(),(6000+a)*Integer.parseInt(txt.getText())+""};
				model.addRow(s);
			}
	}
	}
	void caramelPop(String str,int a){
		int curr=-1;
		int count=Integer.parseInt(txt.getText());
		if(pop3.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("카라멜 팝콘")){
					if(table.getValueAt(i,1).equals(str)){
						curr = i;
						break;
					}
				}
			}///// 이미 줄에 있는지 확인하고 있다면 줄의 위치를 curr에 담음
			
			if(curr !=-1){ //한줄이라도 존재한다면
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(6500+a)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"카라멜 팝콘",str,txt.getText(),(6500+a)*Integer.parseInt(txt.getText())+""};
				model.addRow(s);
			}
	}
	}
	void coke(String str,int a){
		int curr=-1;
		int count=Integer.parseInt(txt2.getText());
		if(coke1.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("콜라")){
					if(table.getValueAt(i,1).equals(str)){
						curr = i;
						break;
					}
				}
			}///// 이미 줄에 있는지 확인하고 있다면 줄의 위치를 curr에 담음
			
			if(curr !=-1){ //한줄이라도 존재한다면
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(2000+a)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"콜라",str,txt2.getText(),(2000+a)*Integer.parseInt(txt2.getText())+""};
				model.addRow(s);
			}
	}
	
	}
	void mountin(String str,int a){
		int curr=-1;
		int count=Integer.parseInt(txt2.getText());
		if(coke2.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("아메리카노")){
					if(table.getValueAt(i,1).equals(str)){
						curr = i;
						break;
					}
				}
			}///// 이미 줄에 있는지 확인하고 있다면 줄의 위치를 curr에 담음
			
			if(curr !=-1){ //한줄이라도 존재한다면
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(2000+a)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"아메리카노",str,txt2.getText(),(2000+a)*Integer.parseInt(txt2.getText())+""};
				model.addRow(s);
			}
	}
	}
	void ade(String str,int a){
		int curr=-1;
		int count=Integer.parseInt(txt2.getText());
		if(coke3.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("아메리카노(ICED)")){
					if(table.getValueAt(i,1).equals(str)){
						curr = i;
						break;
					}
				}
			}///// 이미 줄에 있는지 확인하고 있다면 줄의 위치를 curr에 담음
			
			if(curr !=-1){ //한줄이라도 존재한다면
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(2500+a)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"아메리카노(ICED)",str,txt2.getText(),(2500+a)*Integer.parseInt(txt2.getText())+""};
				model.addRow(s);
			}
	}
	}
	void naCho(){
		int curr=-1;
		int count=Integer.parseInt(txt3.getText());
		if(side1.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("나쵸")){
						curr = i;
						break;
					
				}
			}///// 이미 줄에 있는지 확인하고 있다면 줄의 위치를 curr에 담음
			
			if(curr !=-1){ //한줄이라도 존재한다면
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(4000)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"나쵸","-",txt3.getText(),(4000)*Integer.parseInt(txt3.getText())+""};
				model.addRow(s);
			}
	}
	
	}
	void squid(){
		int curr=-1;
		int count=Integer.parseInt(txt2.getText());
		if(side2.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("오징어")){
						curr = i;
						break;
				}
			}///// 이미 줄에 있는지 확인하고 있다면 줄의 위치를 curr에 담음
			
			if(curr !=-1){ //한줄이라도 존재한다면
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(5000)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"오징어","-",txt3.getText(),(5000)*Integer.parseInt(txt3.getText())+""};
				model.addRow(s);
			}
	}
	}
	void hotdog(){
		int curr=-1;
		int count=Integer.parseInt(txt2.getText());
		if(side3.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("핫도그")){
						curr = i;
						break;
				}
			}///// 이미 줄에 있는지 확인하고 있다면 줄의 위치를 curr에 담음
			
			if(curr !=-1){ //한줄이라도 존재한다면
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(3000)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"핫도그","-",txt3.getText(),(3000)*Integer.parseInt(txt3.getText())+""};
				model.addRow(s);
			}
	}
	}
	void singleCombo(){
		int curr=-1;
		int count=Integer.parseInt(txt4.getText());
		if(combo1.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("싱글콤보")){
						curr = i;
						break;
					
				}
			}///// 이미 줄에 있는지 확인하고 있다면 줄의 위치를 curr에 담음
			
			if(curr !=-1){ //한줄이라도 존재한다면
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(6500)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"싱글콤보","-",txt4.getText(),(6500)*Integer.parseInt(txt4.getText())+""};
				model.addRow(s);
			}
	}
	
	}
	void coupleCombo(){
		int curr=-1;
		int count=Integer.parseInt(txt4.getText());
		if(combo2.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("커플콤보")){
						curr = i;
						break;
				}
			}///// 이미 줄에 있는지 확인하고 있다면 줄의 위치를 curr에 담음
			
			if(curr !=-1){ //한줄이라도 존재한다면
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(9000)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"커플콤보","-",txt4.getText(),(9000)*Integer.parseInt(txt4.getText())+""};
				model.addRow(s);
			}
	}
	}
	void largeCombo(){
		int curr=-1;
		int count=Integer.parseInt(txt4.getText());
		if(combo3.isSelected()==true){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i, 0).equals("라지콤보")){
						curr = i;
						break;
				}
			}///// 이미 줄에 있는지 확인하고 있다면 줄의 위치를 curr에 담음
			
			if(curr !=-1){ //한줄이라도 존재한다면
				String cnt = (Integer.parseInt((String) table.getValueAt(curr, 2))+count)+"";
				String price = (Integer.parseInt((String) table.getValueAt(curr, 3))+(14000)*count)+"";
				table.setValueAt(cnt, curr, 2);
				table.setValueAt(price, curr, 3);
			}else {
				String[] s = {"라지콤보","-",txt4.getText(),(14000)*Integer.parseInt(txt4.getText())+""};
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
		lbltotal.setText("결제 금액 :                                "+ moneysum + "원" );
		
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
			JOptionPane.showMessageDialog(mf,"목록을 선택해주세요!");
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
			JOptionPane.showMessageDialog(mf,"1개이상 선택해주세요.");	
		}
		if(Integer.parseInt(txt2.getText())<1){	
			txt2.setText("1");
			JOptionPane.showMessageDialog(mf,"1개이상 선택해주세요.");	
		}
		if(Integer.parseInt(txt3.getText())<1){	
			txt3.setText("1");
			JOptionPane.showMessageDialog(mf,"1개이상 선택해주세요.");	
		}
		if(Integer.parseInt(txt4.getText())<1){	
			txt4.setText("1");
			JOptionPane.showMessageDialog(mf,"1개이상 선택해주세요.");	
		}
	}
	void btnOption(JButton btn){
		btn.setBorderPainted(false); //버튼 라인 삭제
		btn.setFocusPainted(false); //버튼 클릭 라인 삭제
		btn.setContentAreaFilled(false); //버튼 배경 삭제
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		Basket(arg0);
		UpDown(arg0);
		if (arg0.getSource() == btnorder){//결제 화면
			if (moneysum == 0){
				JOptionPane.showMessageDialog(mf,"메뉴를 선택해주세요.");	
			} else {
				boolean whichOne = 	true; //매점인지, 티켓 구매인지 확인
				int howMuch = moneysum; //원금 받아오기
				
				mf.cafeteria_CafeteriaMainToNext(1,whichOne,howMuch);
			}
		} else if(arg0.getSource() == btnBack){ //홈으로
			boolean whichOne = 	true; //매점인지, 티켓 구매인지 확인
			int howMuch = 0; //원금 받아오기
			mf.cafeteria_CafeteriaMainToNext(2, whichOne, howMuch);
		}	
	}	

}