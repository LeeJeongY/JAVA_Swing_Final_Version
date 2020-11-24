package movie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main_Frame extends JFrame implements MouseListener{
	Main_FirstScreen mfs; //����ȭ��1 �ƹ��͵� ���� ȭ��
	Main_MenuBtn mmb; //����ȭ�� 2 �޴� ����â
	
	Reservation_InPutNum rpn; //���Ź�ȣ �ִ� â
	Reservation_Ticket rt; //������ Ƽ�� ���� â
	PrintedYourTicket pyt; //����Ʈ �Ϸ� â
	
	Purchase_MovieChoice pmc; //���屸�� ��ȭ �����ϴ� â
	Purchase_ChooseMovieAndTime pcmat; //���屸�� �ο�,�ð�,�¼� �����ϴ� â
	Purchase_Ticket pt; //������ Ƽ��
	Purchase_TicketPrice ptp; //����â
	Purchase_TicketPriceDialog1 ptpd; //ī�� �ε�
	Purchase_PointGuide ppg; //����Ʈ ���� �Ͻðڽ��ϱ�?
	
	ParkingMain pm; //�����Ͻðڽ��ϱ�? ����â, �������� ���̾�α� ó��
	
	Cafeteria_PopUpToGoToCafeteria cptgtc; //���� �̿��϶�� Ǫ��â
	Cafeteria_CafeteriaMain ccm; //����
	
	Point_Guide pg; //���� ���� �� ����Ʈ �����ҷ�?
	Point_InputNum pin; //����Ʈ ��ȣ �Է�â 
	MembershipPointCheck_InputNum mpc; //����Ʈ ���� ��ȸ ��ȣ �Է�â
	MembershipPoint mbsp; //����Ʈ ����
	
	
	/**����Ʈ ����*/
	private boolean whichOne; //��������, Ƽ�� �������� Ȯ��
	private int howMuch; //���� �޾ƿ���
	
	public Main_Frame(){ //������
		this.setSize(700,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		mfs = new Main_FirstScreen(this);
		mfs.addMouseListener(this);
		this.add(mfs);
		
		this.setVisible(true);
	}
	void firstMenuToNext(int i){ //ù ��ư ȭ�鿡�� �ش� ��ư �������� (�Ϸ�) //����Ʈ
		this.remove(mmb);
		if (i == 1){ //Reservation_InPutNum��
			rpn = new Reservation_InPutNum(this);
			this.add(rpn);
		} else if (i == 2){ //Purchase_MovieChoice��
			pmc = new Purchase_MovieChoice(this);
			this.add(pmc);
		} else if (i == 3){ //Cafeteria_CafeteriaMain��
			ccm = new Cafeteria_CafeteriaMain(this);
			this.add(ccm);
		} else if (i == 4){ //MembershipPoint��
			mpc = new MembershipPointCheck_InputNum(this);
			this.add(mpc);
		}
		this.repaint();
		this.revalidate();
	}
	void reservationNumToNext(int i){ //���� ��ȣ �Է� ȭ�� (�Ϸ�)
		if (i == 1){ //�ڷΰ���
			this.remove(rpn);
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		} else if(i ==2){ //�����ȣ ����
			this.remove(rpn);
			String[] s = {"���� �״� ��","1��","�Ϲ�","","","2��","12:50","C��","C3"};
			// 0 ��ȭ ����, 1 �Ϲ�, 2 �Ϲ� �ο�, 3 û�ҳ�, 4 û�ҳ� �ο�,
			// 5 ��, 6 �ð�, 7 ��, 8 �¼���ȣ
			rt = new Reservation_Ticket(this, s);
			this.add(rt);
		}
		this.repaint();
		this.revalidate();
		
	}
	void reservation_TicketToNext(int i){//���� Ƽ�� ȭ��  (�Ϸ�)
		this.remove(rt); //���� ȭ������
		if (i == 1){
			pyt = new PrintedYourTicket(this);
			this.add(pyt);
		} else if(i == 2){
			rpn = new Reservation_InPutNum(this);
			this.add(rpn);
		}
		this.repaint();
		this.revalidate();
	}
	void printedYourTicketToNext(){ //Ƽ�� ��� �� ������� â���� (�Ϸ�)
		this.remove(pyt);
		pm = new ParkingMain(this);
		this.add(pm);
		this.repaint();
		this.revalidate();
	}
	void parkingMainToNext(){ //�����Ͻðڽ��ϱ�?~���̾�α� (�Ϸ�)
		//������ ���� ���� �� ���� �˾� ȭ������
		//������ ������ ���� �˾� ȭ������ // ������ ���� ȭ������
		this.remove(pm);
		cptgtc =  new Cafeteria_PopUpToGoToCafeteria(this);
		this.add(cptgtc);
		this.repaint();
		this.revalidate();
	}
	void cafeteria_PopUpToGoToCafeteriaToNext(int i){ //���� �̿� ȫ�� â(�Ϸ�)
		this.remove(cptgtc);
		if (i==1){ // Ȩ1ȭ������
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		} else if(i ==2){ //���� ȭ������
			ccm = new Cafeteria_CafeteriaMain(this);
			this.add(ccm);
		}
		this.repaint();
		this.revalidate();
	}
	void cafeteria_CafeteriaMainToNext(int i, boolean b, int j){ //����(�Ϸ�)
		this.remove(ccm);
		if (i == 1){ //���� ȭ�� â����
			whichOne = b;
			howMuch = j;
			pg = new Point_Guide(this);
			this.add(pg);
		} else if(i == 2){//Ȩȭ������
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		}
		this.repaint();
		this.revalidate();
	}
	void purchase_MovieChoiceToNext(int i){ //���� ���� ��ȭ ���� ȭ�� (�ӽÿϼ�, Ƽ�� ȭ�� ���� ����)
		this.remove(pmc);
		if (i == 1){ //����
			pcmat = new Purchase_ChooseMovieAndTime(this, 1);
			this.add(pcmat);
		} else if (i == 2){  //�����׷쿵�����͹�
			pcmat = new Purchase_ChooseMovieAndTime(this, 2);
			this.add(pcmat);
		} else if (i == 3){//���� �״���
			pcmat = new Purchase_ChooseMovieAndTime(this, 3);
			this.add(pcmat);
		} else if (i == 4){  //��������
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		}
		this.repaint();
		this.revalidate();
	}
	void purchase_ChooseMovieAndTimeToNext(int i, String[] s){ //��ȭ �ο�,�ð�,�¼� ����(�Ϸ�)
		this.remove(pcmat);
		if (i == 1){ //�ڷΰ���, ��ȭ ���� ȭ������
			pmc = new Purchase_MovieChoice(this);
			this.add(pmc);
		} else if(i ==2){ //Ȯ��, Ƽ�� ȭ������
			pt = new Purchase_Ticket(this,s);
			this.add(pt);
		}
		this.repaint();
		this.revalidate();
	}
	void purchase_TicketToNext(int i, String[] s){ //Ƽ��â���� ��ȭ �����̳� ����â����(�Ϸ�)
		this.remove(pt);
		if(i == 1){ //����Ʈ ȭ������
			ptp = new Purchase_TicketPrice(this, s);
			this.add(ptp);
		} else if(i==2){ //���� ȭ������
			pmc = new Purchase_MovieChoice(this);
			this.add(pmc);
		}
		this.repaint();
		this.revalidate();
	}
	void purchase_TicketPriceToNext(int i, boolean b, int j){ //Ƽ�� ���� ����â���� ��ȭ �����̳� ����â����(�Ϸ�)
		
		if (i ==1){ //�����ϱ�
			JFrame f = new JFrame();
	        ptpd = new Purchase_TicketPriceDialog1(f);
	        Timer timer = new Timer(2000, new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	ptpd.setVisible(false);
	            	ptpd.dispose();
	            }
	        });
	        timer.setRepeats(false);
	        timer.start();
	        ptpd.setVisible(true); 
	        
	        whichOne = b; //PointInputNum �� ������ 
	        howMuch = j;
	        
	        this.remove(ptp);
	        ppg = new Purchase_PointGuide(this);
	        this.add(ppg);
	        
		}else if(i ==2){ //��ȭ ���� â���� //�ڷΰ���
			this.remove(ptp);
			pmc = new Purchase_MovieChoice(this);
			this.add(pmc);
		}
		
		this.repaint();
		this.revalidate();
	}
	void purchase_PointGuideToNext(int i){ //����Ʈ ��������
		this.remove(ppg);
		if(i ==1){//����â����
			pin = new Point_InputNum(this, whichOne, howMuch);
			this.add(pin);
		} else if(i==2){ //��µǾ����ϴ� �ȳ�, ���� ����
			pyt = new PrintedYourTicket(this);
			this.add(pyt);
		}
		this.repaint();
		this.revalidate();
	}
	void membershipPointCheck_InputNumToNext(int i){ //���� > ����Ʈ ��ȣ �Է� â!! > ����Ʈ ��ȸâ���� (�Ϸ�)
		this.remove(mpc);
		if(i == 1){
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		}else if(i ==2){
			mbsp = new MembershipPoint(this);
			this.add(mbsp);
		}
		this.repaint();
		this.revalidate();
	}
	void membershipPointToNext(){ //����� ����Ʈ ��ȸ ȭ�鿡�� Ȩ���� (�Ϸ�)
		this.remove(mbsp);
		mmb = new Main_MenuBtn(this);
		this.add(mmb);
		this.repaint();
		this.revalidate();
	}
	void point_InputNumToNext(int i){ //����Ʈ �Է��ϴ� ȭ�� (�Ϸ�)
		this.remove(pin);
		if(i ==1 ) {
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		} else {
			pm = new ParkingMain(this);
			this.add(pm);
		}
		this.repaint();
		this.revalidate();
	}
	void point_GuideToNext(int i){ //�������� ���� �� �����ǰ� ����Ʈ �������� ���� ȭ�� (�Ϸ�)
		this.remove(pg);
		if (i == 1){//�ڷΰ��� //����ȭ��
			ccm = new Cafeteria_CafeteriaMain(this);
			this.add(ccm);
		} else if(i==2){//����Ʈ ���� ȭ������ ����
			pin = new Point_InputNum(this, whichOne, howMuch);
			this.add(pin);
		} else if(i==3){//ù ȭ������ ���ư���
			mmb = new Main_MenuBtn(this);
			this.add(mmb);
		}
		this.repaint();
		this.revalidate();
	}
	@Override
	public void mouseClicked(MouseEvent e) { //ù ȭ�� ���콺 (�Ϸ�)
		this.remove(mfs);
		mmb = new Main_MenuBtn(this);
		this.add(mmb);
		this.repaint();
		this.revalidate();
	}
	public static void main(String[] args) { //����
		new Main_Frame();
	}
	//�Ⱦ��� �̺�Ʈ
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

}
