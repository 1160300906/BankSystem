package bankSystem;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
 
public class Withdraw {
 
	JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;
 
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Withdraw window = new Withdraw();
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
	public JFrame getFrame()
	{
		return frame;
	}
	public Withdraw(String work){
		initialize(work);
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String work) {
		frame = new JFrame();
		frame.setTitle("取 款");
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane.setText(" 账号");
		textPane.setBounds(37, 37, 116, 45);
		frame.getContentPane().add(textPane);
		//添加账号输入文本框
		textField = new JTextField();
		textField.setBounds(176, 37, 186, 45);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane_1.setText(" 密码");
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setBounds(38, 102, 115, 45);
		frame.getContentPane().add(textPane_1);
		//添加密码输入文本框
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 102, 186, 45);
		frame.getContentPane().add(passwordField);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBackground(SystemColor.control);
		textPane_2.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane_2.setText(" 取款金额");
		textPane_2.setBounds(37, 170, 116, 45);
		frame.getContentPane().add(textPane_2);
		//添加取款金额输入文本框
		textField_2 = new JTextField();
		textField_2.setBounds(178, 170, 184, 45);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1 = textField.getText();
				int num=Integer.valueOf(num1);
				//获取密码框中的密码并转换为字符串
				char[] password =passwordField.getPassword();
				String psw=new String(password);
				try {
				float money =Float.parseFloat(textField_2.getText());
				boolean bl=BankSystem.accountBalance(num,money);
				
					if(bl==false)
					{
						JOptionPane.showMessageDialog(btnNewButton,"您的余额不足或账户不存在");
						textField_2.setText("");
					}
					else
					{
						boolean b =BankSystem.withdraw(num,psw,money,work);
						if(b==true)
						{
							JOptionPane.showMessageDialog(btnNewButton, "取款成功，请收好您的现金！");
							textField_2.setText("");
							passwordField.setText("");
							textField.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(btnNewButton, "密码错误,请重新输入","Error",JOptionPane.ERROR_MESSAGE);
							passwordField.setText("");
						}
					}
		
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(btnNewButton, "输入的取款金额必须是数字！","Error",JOptionPane.ERROR_MESSAGE);
					textField_2.setText("");
				}
			
			}
		});
		btnNewButton.setBounds(131, 225, 115, 36);
		frame.getContentPane().add(btnNewButton);
		
	}
 
}