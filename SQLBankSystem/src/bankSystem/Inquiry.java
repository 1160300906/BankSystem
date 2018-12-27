package bankSystem;

//import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class Inquiry {
 
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
 
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Inquiry window = new Inquiry();
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
	public Inquiry() {
		initialize();
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("信息查询");
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//添加密码输入框
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 136, 204, 43);
		frame.getContentPane().add(passwordField);
		//添加账号输入文本框
		textField = new JTextField();
		textField.setBounds(144, 59, 208, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("宋体", Font.PLAIN, 20));
		textPane.setText("      账号");
		textPane.setBounds(23, 59, 111, 43);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textPane_1.setText("  密码");
		textPane_1.setBounds(59, 136, 82, 43);
		frame.getContentPane().add(textPane_1);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1=textField.getText();
				int num=Integer.valueOf(num1);
				//获取密码框中的密码并转换为字符串
				char[] password =passwordField.getPassword();
				String psw=new String(password);
				try {
					String[] str =BankSystem.balanceInquiry(num,psw);
					JOptionPane.showMessageDialog(btnNewButton, "账号："+str[0]+"  用户名："+str[1]+"  余额："+str[2]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnNewButton,"账号未注册或密码错误！","Error", JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		btnNewButton.setBounds(172, 213, 111, 38);
		frame.getContentPane().add(btnNewButton);
	}
}
