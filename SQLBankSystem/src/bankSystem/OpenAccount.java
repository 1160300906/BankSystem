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
		frame.setTitle("注册用户");
		frame.setBounds(400, 200, 450, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane.setText(" 用户名");
		textPane.setBounds(45, 42, 93, 42);
		frame.getContentPane().add(textPane);
		//添加用户名输入文本框
		textField = new JTextField();
		textField.setBounds(148, 42, 178, 42);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		//添加密码输入文本框
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 94, 178, 44);
		frame.getContentPane().add(passwordField);
		//添加确认密码输入文本框
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(148, 148, 178, 42);
		frame.getContentPane().add(passwordField_1);
		//添加开户金额输入文本框
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(148,198, 178, 42);
		frame.getContentPane().add(passwordField_2);
		passwordField_2.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setText(" 密码");
		textPane_1.setBounds(55, 94, 85, 44);
		frame.getContentPane().add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBackground(SystemColor.control);
		textPane_2.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane_2.setText("确认密码");
		textPane_2.setBounds(33, 148, 105, 52);
		frame.getContentPane().add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBackground(SystemColor.control);
		textPane_3.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane_3.setText("开户金额");
		textPane_3.setBounds(33, 198, 105, 52);
		frame.getContentPane().add(textPane_3);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				float money =Float.parseFloat(passwordField_2.getText());
				//获取密码框中的密码并转换为字符串
				char[] password =passwordField.getPassword();
				String psw=new String(password);
				char[] password1 =passwordField_1.getPassword();
				String psw1=new String(password1);
				try {
					int str=BankSystem.openAccount(name,psw,psw1,money,work);
					if(str!=0)
					{
					JOptionPane.showMessageDialog(btnNewButton,"注册成功，您的账号为"+str);
					}
					else
						JOptionPane.showMessageDialog(btnNewButton,"错误，请重新输入！","Error", JOptionPane.ERROR_MESSAGE);
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
