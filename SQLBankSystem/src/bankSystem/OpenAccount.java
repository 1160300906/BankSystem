package bankSystem;

//import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
 
public class OpenAccount {
 
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField passwordField_2;
 
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OpenAccount window = new OpenAccount();
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
	
	public OpenAccount(String work) {
		initialize(work);
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String work) {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setTitle("ע���û�");
		frame.setBounds(400, 200, 450, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("����", Font.PLAIN, 22));
		textPane.setText(" �û���");
		textPane.setBounds(45, 42, 93, 42);
		frame.getContentPane().add(textPane);
		//����û��������ı���
		textField = new JTextField();
		textField.setBounds(148, 42, 178, 42);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		//������������ı���
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 94, 178, 44);
		frame.getContentPane().add(passwordField);
		//���ȷ�����������ı���
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(148, 148, 178, 42);
		frame.getContentPane().add(passwordField_1);
		//��ӿ�����������ı���
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(148,198, 178, 42);
		frame.getContentPane().add(passwordField_2);
		passwordField_2.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setFont(new Font("����", Font.PLAIN, 22));
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setText(" ����");
		textPane_1.setBounds(55, 94, 85, 44);
		frame.getContentPane().add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBackground(SystemColor.control);
		textPane_2.setFont(new Font("����", Font.PLAIN, 22));
		textPane_2.setText("ȷ������");
		textPane_2.setBounds(33, 148, 105, 52);
		frame.getContentPane().add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBackground(SystemColor.control);
		textPane_3.setFont(new Font("����", Font.PLAIN, 22));
		textPane_3.setText("�������");
		textPane_3.setBounds(33, 198, 105, 52);
		frame.getContentPane().add(textPane_3);
		
		JButton btnNewButton = new JButton("ע��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				float money =Float.parseFloat(passwordField_2.getText());
				//��ȡ������е����벢ת��Ϊ�ַ���
				char[] password =passwordField.getPassword();
				String psw=new String(password);
				char[] password1 =passwordField_1.getPassword();
				String psw1=new String(password1);
				try {
					int str=BankSystem.openAccount(name,psw,psw1,money,work);
					if(str!=0)
					{
					JOptionPane.showMessageDialog(btnNewButton,"ע��ɹ��������˺�Ϊ"+str);
					}
					else
						JOptionPane.showMessageDialog(btnNewButton,"�������������룡","Error", JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						passwordField.setText("");
						passwordField_1.setText("");
						passwordField_2.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
	
			}
			}
		});
		btnNewButton.setBounds(183, 250, 85, 42);
		frame.getContentPane().add(btnNewButton);
	}
}
