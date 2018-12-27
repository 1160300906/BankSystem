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
		frame.setTitle("��Ϣ��ѯ");
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//������������
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 136, 204, 43);
		frame.getContentPane().add(passwordField);
		//����˺������ı���
		textField = new JTextField();
		textField.setBounds(144, 59, 208, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("����", Font.PLAIN, 20));
		textPane.setText("      �˺�");
		textPane.setBounds(23, 59, 111, 43);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setFont(new Font("����", Font.PLAIN, 20));
		textPane_1.setText("  ����");
		textPane_1.setBounds(59, 136, 82, 43);
		frame.getContentPane().add(textPane_1);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1=textField.getText();
				int num=Integer.valueOf(num1);
				//��ȡ������е����벢ת��Ϊ�ַ���
				char[] password =passwordField.getPassword();
				String psw=new String(password);
				try {
					String[] str =BankSystem.balanceInquiry(num,psw);
					JOptionPane.showMessageDialog(btnNewButton, "�˺ţ�"+str[0]+"  �û�����"+str[1]+"  ��"+str[2]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnNewButton,"�˺�δע����������","Error", JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		btnNewButton.setBounds(172, 213, 111, 38);
		frame.getContentPane().add(btnNewButton);
	}
}
