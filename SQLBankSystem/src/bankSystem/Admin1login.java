package bankSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Admin1login {
	private JFrame frame;
	private JFrame frame1;
	private JTextField textField;
	
	public JFrame getFrame()
	{
		return frame;
	}
	public Admin1login() {
		initialize();
	}
	public void AdminPasswd() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(SystemColor.control);
		frame1.setTitle("Login");
		frame1.setBounds(400, 200, 450, 300);
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("宋体", Font.PLAIN, 15));
		textPane.setText("要查询的账号");
		textPane.setBounds(45, 42, 93, 42);
		frame1.getContentPane().add(textPane);
		//添加用户名输入文本框
		textField = new JTextField();
		textField.setBounds(148, 42, 178, 42);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1=textField.getText();
				int num=Integer.valueOf(num1);
				new ChaxunLoginByNum(num);	
			}
		});
		btnNewButton.setBounds(172, 213, 111, 38);
		frame1.getContentPane().add(btnNewButton);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("银行系统");
		frame.setForeground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("微软雅黑", Font.BOLD, 16));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setFont(null);
		frame.setBackground(Color.GRAY);
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnNewButton = new JButton("查看完整日志");
		btnNewButton.setBounds(10, 83, 175, 33);
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showLogTable();
//					OpenAccount window = new OpenAccount();
//					window.getFrame().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("按时间查询日志");
		btnNewButton_1.setBounds(10, 155, 175, 33);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Deposite window = new Deposite();
//				window.getFrame().setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("按用户查询日志");
		button.setBounds(10, 220, 175, 33);
		button.setBackground(SystemColor.control);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//					Withdraw window = new Withdraw();
//					window.getFrame().setVisible(true);
				AdminPasswd();
				frame1.setVisible(true);
			}
		});
		frame.getContentPane().add(button);
		
		JButton btnNewButton_2 = new JButton("按操作类型查询用户");
		btnNewButton_2.setBounds(249, 157, 175, 29);
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				TransferAccounts window =new  TransferAccounts();
//				window.getFrame().setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("退    出");
		btnNewButton_3.setBounds(249, 222, 178, 29);
		btnNewButton_3.setBackground(SystemColor.control);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton_3, "期待您下次使用，再见");
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_3);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(80, 20, 298, 33);
		frame.getContentPane().add(textPane);
		textPane.setFont(new Font("宋体", Font.BOLD, 14));
		textPane.setBackground(SystemColor.control);
		textPane.setText("欢迎进入审计日志界面，请选择所需服务");
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setText("   请注意周边环境安全");
		textPane_1.setBounds(143, 52, 150, 21);
		frame.getContentPane().add(textPane_1);
	}
}
