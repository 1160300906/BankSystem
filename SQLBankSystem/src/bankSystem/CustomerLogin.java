package bankSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class CustomerLogin {
	private JFrame frame;
	public JFrame getFrame()
	{
		return frame;
	}
	public CustomerLogin(String work){
		initialize(work);
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String work) {
		frame = new JFrame();
		frame.setTitle("����ϵͳ");
		frame.setForeground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("΢���ź�", Font.BOLD, 16));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setFont(null);
		frame.setBackground(Color.GRAY);
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnNewButton = new JButton("��    ��");
		btnNewButton.setBounds(10, 83, 175, 33);
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					OpenAccount window = new OpenAccount(work);
					window.getFrame().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("��    ��");
		btnNewButton_1.setBounds(10, 155, 175, 33);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposite window = new Deposite(work);
				window.getFrame().setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("ȡ    ��");
		button.setBounds(10, 220, 175, 33);
		button.setBackground(SystemColor.control);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Withdraw window = new Withdraw(work);
					window.getFrame().setVisible(true);
			}
		});
		frame.getContentPane().add(button);
		
		JButton btnNewButton_2 = new JButton("ת    ��");
		btnNewButton_2.setBounds(249, 157, 175, 29);
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferAccounts window =new  TransferAccounts(work);
				window.getFrame().setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("��    ��");
		btnNewButton_3.setBounds(249, 222, 178, 29);
		btnNewButton_3.setBackground(SystemColor.control);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton_3, "�ڴ����´�ʹ�ã��ټ�");
			//	System.exit(0);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("��   ѯ");
		btnNewButton_4.setBounds(249, 83, 175, 33);
		btnNewButton_4.setBackground(SystemColor.control);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Inquiry window = new Inquiry();
					window.getFrame().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnNewButton_4);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(80, 20, 298, 33);
		frame.getContentPane().add(textPane);
		textPane.setFont(new Font("����", Font.BOLD, 14));
		textPane.setBackground(SystemColor.control);
		textPane.setText("��ӭ�����û��������棬��ѡ���������");
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setText("   ��ע���ܱ߻�����ȫ");
		textPane_1.setBounds(143, 52, 150, 21);
		frame.getContentPane().add(textPane_1);
	}
}
