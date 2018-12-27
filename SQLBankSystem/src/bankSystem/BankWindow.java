package bankSystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
 
public class BankWindow {
 
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JFrame frame1;
	private JFrame frame2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankWindow window = new BankWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * Create the application.
	 */
	public BankWindow() {
		initializelogin();
	}
 
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setTitle("自助银行系统");
//		frame.setForeground(Color.DARK_GRAY);
//		frame.getContentPane().setFont(new Font("微软雅黑", Font.BOLD, 16));
//		frame.getContentPane().setForeground(new Color(0, 0, 0));
//		frame.getContentPane().setBackground(SystemColor.control);
//		frame.setFont(null);
//		frame.setBackground(Color.GRAY);
//		frame.setBounds(400, 200, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		JButton btnNewButton = new JButton("开    户");
//		btnNewButton.setBounds(10, 83, 175, 33);
//		btnNewButton.setBackground(SystemColor.control);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					OpenAccount window = new OpenAccount();
//					window.getFrame().setVisible(true);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("存    款");
//		btnNewButton_1.setBounds(10, 155, 175, 33);
//		btnNewButton_1.setForeground(new Color(0, 0, 0));
//		btnNewButton_1.setBackground(SystemColor.control);
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Deposite window = new Deposite();
//				window.getFrame().setVisible(true);
//			}
//		});
//		frame.getContentPane().add(btnNewButton_1);
//		
//		JButton button = new JButton("取    款");
//		button.setBounds(10, 220, 175, 33);
//		button.setBackground(SystemColor.control);
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//					Withdraw window = new Withdraw();
//					window.getFrame().setVisible(true);
//			}
//		});
//		frame.getContentPane().add(button);
//		
//		JButton btnNewButton_2 = new JButton("转    账");
//		btnNewButton_2.setBounds(249, 157, 175, 29);
//		btnNewButton_2.setBackground(SystemColor.control);
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TransferAccounts window =new  TransferAccounts();
//				window.getFrame().setVisible(true);
//			}
//		});
//		frame.getContentPane().add(btnNewButton_2);
//		
//		JButton btnNewButton_3 = new JButton("退    出");
//		btnNewButton_3.setBounds(249, 222, 178, 29);
//		btnNewButton_3.setBackground(SystemColor.control);
//		btnNewButton_3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(btnNewButton_3, "期待您下次使用，再见");
//				System.exit(0);
//			}
//		});
//		frame.getContentPane().add(btnNewButton_3);
//		
//		JButton btnNewButton_4 = new JButton("查   询");
//		btnNewButton_4.setBounds(249, 83, 175, 33);
//		btnNewButton_4.setBackground(SystemColor.control);
//		btnNewButton_4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					Inquiry window = new Inquiry();
//					window.getFrame().setVisible(true);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
//		frame.getContentPane().add(btnNewButton_4);
//		
//		JTextPane textPane = new JTextPane();
//		textPane.setBounds(80, 20, 298, 33);
//		frame.getContentPane().add(textPane);
//		textPane.setFont(new Font("宋体", Font.BOLD, 14));
//		textPane.setBackground(SystemColor.control);
//		textPane.setText("你已经以管理员的身份进入，，请选择所需服务");
//		
//		JTextPane textPane_1 = new JTextPane();
//		textPane_1.setForeground(new Color(0, 0, 0));
//		textPane_1.setBackground(SystemColor.control);
//		textPane_1.setText("   请注意周边环境安全");
//		textPane_1.setBounds(143, 52, 150, 21);
//		frame.getContentPane().add(textPane_1);
//	}
	public void AdminPasswd() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(SystemColor.control);
		frame1.setTitle("Login");
		frame1.setBounds(400, 200, 450, 300);
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane.setText(" 用户名");
		textPane.setBounds(45, 42, 93, 42);
		frame1.getContentPane().add(textPane);
		//添加用户名输入文本框
		textField = new JTextField();
		textField.setBounds(148, 42, 178, 42);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		//添加密码输入文本框
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 94, 178, 44);
		frame1.getContentPane().add(passwordField);
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setText(" 密码");
		textPane_1.setBounds(55, 94, 85, 44);
		frame1.getContentPane().add(textPane_1);		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1=textField.getText();
			//	int num=Integer.valueOf(num1);
				//获取密码框中的密码并转换为字符串
				char[] password =passwordField.getPassword();
				String psw=new String(password);
				try {
					int bb=BankSystem.adminlogin(num1,psw);
					if(bb==1) {
						Admin1login window = new Admin1login();
					    window.getFrame().setVisible(true);
					}
					else if(bb==2) {
						Admin2login window = new Admin2login();
					    window.getFrame().setVisible(true);
					}
					else if(bb==3) {
						Admin3login window = new Admin3login();
					    window.getFrame().setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(btnNewButton,"账号未注册或密码错误！","Error", JOptionPane.ERROR_MESSAGE);
					}
			//		JOptionPane.showMessageDialog(btnNewButton, "账号："+str[0]+"  用户名："+str[1]+"  余额："+str[2]);
				} catch (ClassNotFoundException | SQLException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnNewButton,"账号未注册或密码错误！","Error", JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		btnNewButton.setBounds(172, 213, 111, 38);
		frame1.getContentPane().add(btnNewButton);
	}
	
	public void WorkerPasswd() {
		frame2 = new JFrame();
		frame2.getContentPane().setBackground(SystemColor.control);
		frame2.setTitle("Login");
		frame2.setBounds(400, 200, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane.setText(" 用户名");
		textPane.setBounds(45, 42, 93, 42);
		frame2.getContentPane().add(textPane);
		//添加用户名输入文本框
		textField = new JTextField();
		textField.setBounds(148, 42, 178, 42);
		frame2.getContentPane().add(textField);
		textField.setColumns(10);
		//添加密码输入文本框
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 94, 178, 44);
		frame2.getContentPane().add(passwordField);
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setText(" 密码");
		textPane_1.setBounds(55, 94, 85, 44);
		frame2.getContentPane().add(textPane_1);		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1=textField.getText();
			//	int num=Integer.valueOf(num1);
				//获取密码框中的密码并转换为字符串
				char[] password =passwordField.getPassword();
				String psw=new String(password);
				try {
					int bb=BankSystem.Workerlogin(num1,psw);
					if(bb==1) {
						CustomerLogin window = new CustomerLogin(num1);
					    window.getFrame().setVisible(true);
					}
//					else if(bb==2) {
//						Admin2login window = new Admin2login();
//					    window.getFrame().setVisible(true);
//					}
//					else if(bb==3) {
//						Admin3login window = new Admin3login();
//					    window.getFrame().setVisible(true);
//					}
					else {
						JOptionPane.showMessageDialog(btnNewButton,"账号未注册或密码错误！","Error", JOptionPane.ERROR_MESSAGE);
					}
			//		JOptionPane.showMessageDialog(btnNewButton, "账号："+str[0]+"  用户名："+str[1]+"  余额："+str[2]);
				} catch (ClassNotFoundException | SQLException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnNewButton,"账号未注册或密码错误！","Error", JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		btnNewButton.setBounds(172, 213, 111, 38);
		frame2.getContentPane().add(btnNewButton);
	}
	
	private void initializelogin() {
		frame = new JFrame();
		frame.setTitle("银行系统");
		frame.setForeground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("微软雅黑", Font.BOLD, 16));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setFont(null);
		frame.setBackground(Color.GRAY);
		frame.setBounds(400, 200, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("管理员身份登陆");
		btnNewButton.setBounds(10, 83, 175, 33);
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					Adminlogin window = new Adminlogin();
//					window.getFrame().setVisible(true);
					AdminPasswd();
					frame1.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("普通员工身份登陆");
		btnNewButton_1.setBounds(249, 83, 175, 33);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkerPasswd();
				frame2.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(80, 20, 298, 33);
		frame.getContentPane().add(textPane);
		textPane.setFont(new Font("宋体", Font.BOLD, 14));
		textPane.setBackground(SystemColor.control);
		textPane.setText("欢迎使用银行系统，请选择身份登陆");
		
	}
}
