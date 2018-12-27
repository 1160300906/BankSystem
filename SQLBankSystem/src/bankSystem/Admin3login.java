package bankSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class Admin3login{
	private JFrame frame;
	public JFrame getFrame()
	{
		return frame;
	}
	public Admin3login() {
		initialize();
	}
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
		
		JButton btnNewButton = new JButton("查看顾客密码信息");
		btnNewButton.setBounds(10, 83, 175, 33);
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showPasswdTable();
//					OpenAccount window = new OpenAccount();
//					window.getFrame().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(80, 20, 298, 33);
		frame.getContentPane().add(textPane);
		textPane.setFont(new Font("宋体", Font.BOLD, 14));
		textPane.setBackground(SystemColor.control);
		textPane.setText("欢迎进入超级管理员界面，请选择所需服务");
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setText("   请注意周边环境安全");
		textPane_1.setBounds(143, 52, 150, 21);
		frame.getContentPane().add(textPane_1);
	}
}
