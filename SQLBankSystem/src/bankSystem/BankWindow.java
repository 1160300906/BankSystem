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
//		frame.setTitle("��������ϵͳ");
//		frame.setForeground(Color.DARK_GRAY);
//		frame.getContentPane().setFont(new Font("΢���ź�", Font.BOLD, 16));
//		frame.getContentPane().setForeground(new Color(0, 0, 0));
//		frame.getContentPane().setBackground(SystemColor.control);
//		frame.setFont(null);
//		frame.setBackground(Color.GRAY);
//		frame.setBounds(400, 200, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		JButton btnNewButton = new JButton("��    ��");
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
//		JButton btnNewButton_1 = new JButton("��    ��");
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
//		JButton button = new JButton("ȡ    ��");
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
//		JButton btnNewButton_2 = new JButton("ת    ��");
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
//		JButton btnNewButton_3 = new JButton("��    ��");
//		btnNewButton_3.setBounds(249, 222, 178, 29);
//		btnNewButton_3.setBackground(SystemColor.control);
//		btnNewButton_3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(btnNewButton_3, "�ڴ����´�ʹ�ã��ټ�");
//				System.exit(0);
//			}
//		});
//		frame.getContentPane().add(btnNewButton_3);
//		
//		JButton btnNewButton_4 = new JButton("��   ѯ");
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
//		textPane.setFont(new Font("����", Font.BOLD, 14));
//		textPane.setBackground(SystemColor.control);
//		textPane.setText("���Ѿ��Թ���Ա����ݽ��룬����ѡ���������");
//		
//		JTextPane textPane_1 = new JTextPane();
//		textPane_1.setForeground(new Color(0, 0, 0));
//		textPane_1.setBackground(SystemColor.control);
//		textPane_1.setText("   ��ע���ܱ߻�����ȫ");
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
		textPane.setFont(new Font("����", Font.PLAIN, 22));
		textPane.setText(" �û���");
		textPane.setBounds(45, 42, 93, 42);
		frame1.getContentPane().add(textPane);
		//����û��������ı���
		textField = new JTextField();
		textField.setBounds(148, 42, 178, 42);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		//������������ı���
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 94, 178, 44);
		frame1.getContentPane().add(passwordField);
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setFont(new Font("����", Font.PLAIN, 22));
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setText(" ����");
		textPane_1.setBounds(55, 94, 85, 44);
		frame1.getContentPane().add(textPane_1);		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1=textField.getText();
			//	int num=Integer.valueOf(num1);
				//��ȡ������е����벢ת��Ϊ�ַ���
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
						JOptionPane.showMessageDialog(btnNewButton,"�˺�δע����������","Error", JOptionPane.ERROR_MESSAGE);
					}
			//		JOptionPane.showMessageDialog(btnNewButton, "�˺ţ�"+str[0]+"  �û�����"+str[1]+"  ��"+str[2]);
				} catch (ClassNotFoundException | SQLException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnNewButton,"�˺�δע����������","Error", JOptionPane.ERROR_MESSAGE);
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
		textPane.setFont(new Font("����", Font.PLAIN, 22));
		textPane.setText(" �û���");
		textPane.setBounds(45, 42, 93, 42);
		frame2.getContentPane().add(textPane);
		//����û��������ı���
		textField = new JTextField();
		textField.setBounds(148, 42, 178, 42);
		frame2.getContentPane().add(textField);
		textField.setColumns(10);
		//������������ı���
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 94, 178, 44);
		frame2.getContentPane().add(passwordField);
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setFont(new Font("����", Font.PLAIN, 22));
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setText(" ����");
		textPane_1.setBounds(55, 94, 85, 44);
		frame2.getContentPane().add(textPane_1);		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1=textField.getText();
			//	int num=Integer.valueOf(num1);
				//��ȡ������е����벢ת��Ϊ�ַ���
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
						JOptionPane.showMessageDialog(btnNewButton,"�˺�δע����������","Error", JOptionPane.ERROR_MESSAGE);
					}
			//		JOptionPane.showMessageDialog(btnNewButton, "�˺ţ�"+str[0]+"  �û�����"+str[1]+"  ��"+str[2]);
				} catch (ClassNotFoundException | SQLException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnNewButton,"�˺�δע����������","Error", JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		btnNewButton.setBounds(172, 213, 111, 38);
		frame2.getContentPane().add(btnNewButton);
	}
	
	private void initializelogin() {
		frame = new JFrame();
		frame.setTitle("����ϵͳ");
		frame.setForeground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("΢���ź�", Font.BOLD, 16));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setFont(null);
		frame.setBackground(Color.GRAY);
		frame.setBounds(400, 200, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("����Ա��ݵ�½");
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
		
		JButton btnNewButton_1 = new JButton("��ͨԱ����ݵ�½");
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
		textPane.setFont(new Font("����", Font.BOLD, 14));
		textPane.setBackground(SystemColor.control);
		textPane.setText("��ӭʹ������ϵͳ����ѡ����ݵ�½");
		
	}
}
