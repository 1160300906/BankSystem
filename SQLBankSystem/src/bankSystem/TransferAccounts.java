package bankSystem;

//import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class TransferAccounts {
 
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_1;
 
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TransferAccounts window = new TransferAccounts();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
// 
	/**
	 * Create the application.
	 */
	public TransferAccounts(String work) {
		initialize(work);
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	public JFrame getFrame()
	{
		return frame;
	}
	private void initialize(String work) {
		frame = new JFrame();
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("����", Font.PLAIN, 20));
		textPane.setBackground(SystemColor.control);
		textPane.setText("   �˺�");
		textPane.setBounds(40, 29, 103, 32);
		frame.getContentPane().add(textPane);
		//����˺������ı���
		textField = new JTextField();
		textField.setBounds(153, 29, 176, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("����", Font.PLAIN, 20));
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setText("   ����");
		textPane_1.setBounds(40, 71, 103, 40);
		frame.getContentPane().add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBackground(SystemColor.control);
		textPane_2.setFont(new Font("����", Font.PLAIN, 20));
		textPane_2.setText(" �Է��˺�");
		textPane_2.setBounds(40, 121, 103, 40);
		frame.getContentPane().add(textPane_2);
		//��ӶԷ��˺������ı���
		textField_2 = new JTextField();
		textField_2.setBounds(153, 121, 176, 32);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		//������������ı���
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 71, 176, 32);
		frame.getContentPane().add(passwordField);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setFont(new Font("����", Font.PLAIN, 20));
		textPane_3.setBackground(SystemColor.control);
		textPane_3.setText(" ת�˽��");
		textPane_3.setBounds(40, 170, 103, 40);
		frame.getContentPane().add(textPane_3);
		//���ת�˽�������ı���
		textField_1 = new JTextField();
		textField_1.setBounds(155, 170, 174, 32);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("ȷ ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fromNum1 = textField.getText();
				int fromNum=Integer.valueOf(fromNum1);
				//��ȡ������е����벢ת��Ϊ�ַ���
				char[] password =passwordField.getPassword();
				String psw=new String(password);
				String toNum1 = textField_2.getText();
				int toNum=Integer.valueOf(toNum1);
				String str_money =textField_1.getText();
				if(fromNum1.equals(toNum1))
				{
					JOptionPane.showMessageDialog(btnNewButton, "�����ܸ��Լ�ת�ˣ�","Error",JOptionPane.ERROR_MESSAGE);
					textField_2.setText("");
				}
				else
				{
					try {
						float money=Float.parseFloat(str_money);
						boolean bl=BankSystem.accountBalance(fromNum, money);
						if(bl==false)
						{
							JOptionPane.showMessageDialog(btnNewButton,"����������˻�������");
							textField_1.setText("");
						}
						else 
						{
							boolean b = BankSystem.transferAccounts(fromNum, psw, toNum, money,work);
							if(b==true)
							{
								JOptionPane.showMessageDialog(btnNewButton,"ת�˳ɹ�");
								//textField.setText("");
								textField_1.setText("");
								textField_2.setText("");
								//passwordField.setText("");
							}
							else
							{
								JOptionPane.showMessageDialog(btnNewButton, "��������Է��˺Ų����ڣ�����������","Error",JOptionPane.ERROR_MESSAGE);
								passwordField.setText("");
								textField_2.setText("");
							}
						}
					}catch(Exception e1)
					{
						e1.printStackTrace();
						JOptionPane.showMessageDialog(btnNewButton, "�����ת�˽����������֣�","Error",JOptionPane.ERROR_MESSAGE);
						textField_1.setText("");
					}
				}
	  }
    });
		btnNewButton.setBounds(135, 220, 125, 31);
		frame.getContentPane().add(btnNewButton);
  }
}