package bankSystem;

//import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
 
public class Deposite {
 
	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
 
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Deposite window = new Deposite();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
 
	/**
	 * Create the application.
	 */
	public JFrame getFrame()
	{
		return frame;
	}
	public Deposite(String work) {
		initialize(work);
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String work) {
		frame = new JFrame();
		frame.setTitle(" ���");
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("����", Font.PLAIN, 22));
		textPane.setText(" �˺�");
		textPane.setBounds(37, 37, 116, 45);
		frame.getContentPane().add(textPane);
		//����˺������ı���
		textField_1 = new JTextField();
		textField_1.setBounds(176, 37, 186, 45);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("����", Font.PLAIN, 22));
		textPane_1.setText(" ����");
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setBounds(38, 102, 115, 45);
		frame.getContentPane().add(textPane_1);
		//������������ı���
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 102, 186, 45);
		frame.getContentPane().add(passwordField);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBackground(SystemColor.control);
		textPane_2.setFont(new Font("����", Font.PLAIN, 22));
		textPane_2.setText(" �洢���");
		textPane_2.setBounds(37, 170, 116, 45);
		frame.getContentPane().add(textPane_2);
		//��Ӵ�����ı���
		textField_2 = new JTextField();
		textField_2.setBounds(178, 170, 184, 45);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1 = textField_1.getText();
				int num=Integer.valueOf(num1);
			//	System.out.println(num1+","+num);
				//��ȡ������е����벢ת��Ϊ�ַ���
				char[] password =passwordField.getPassword();
				String psw=new String(password);
				try {
				float money =Float.parseFloat(textField_2.getText());
				try {
					boolean b =BankSystem.deposite(num, psw, money,work);
					if(b==true)
					{
						JOptionPane.showMessageDialog(btnNewButton, "�洢�ɹ���");
						textField_2.setText("");
						passwordField.setText("");
						textField_1.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, "�������,����������","Error",JOptionPane.ERROR_MESSAGE);
						passwordField.setText("");
					}
				} catch (ClassNotFoundException | SQLException e2) {
					JOptionPane.showMessageDialog(btnNewButton, "�������˺Ų����ڣ�����������","Error",JOptionPane.ERROR_MESSAGE);
					textField_1.setText("");
				} 
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(btnNewButton, "����Ĵ������������֣�","Error",JOptionPane.ERROR_MESSAGE);
					textField_2.setText("");
				}
			
			}
		});
		btnNewButton.setBounds(131, 225, 115, 36);
		frame.getContentPane().add(btnNewButton);
		
	}
 
}
