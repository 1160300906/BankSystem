package bankSystem;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class showPasswdTable extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6612976492439956169L;
	private JTable table=null;
	public showPasswdTable() {
		super("用户密码信息");
	try {	
		
		table=BankSystem.readPasswd();
		add(new JScrollPane(table));
	   setSize(400, 300); 
	   setLocationRelativeTo(null); 
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   setVisible(true);
	}catch (Exception e1) {
		e1.printStackTrace();
      }  
	}

}

