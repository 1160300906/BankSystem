package contentcl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TransferToOthers extends JFrame implements ActionListener{
	JButton jb1, jb2, jb3;  //��ť
	JLabel jlb1, jlb2, jlb3,jlb4;  //��ǩ
	JTextField jtf1,jtf2,jtf3;   //�ı���
	JPasswordField jpf; //�����
	JPanel jp1,jp2,jp3,jp4;		//���
	String wantsave,countname,mycountname;
	//private boolean flag;
	
	public TransferToOthers(String mycountname, String countname, String wantsave) throws IOException {
		// TODO Auto-generated constructor stub
		this.wantsave = wantsave;
		this.countname = countname;
		this.mycountname = mycountname;
		
		jb1 = new JButton("ȷ��");
		jb2 = new JButton("ȡ��");
		//���ð�ť����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		//��ǩ��Ϣ
		
		jlb1 = new JLabel("�Է�����");
		jlb2 = new JLabel("���֤��");
		jlb3 = new JLabel("        �˺�");
		jlb4 = new JLabel("��ȷ�϶Է��˻���Ϣ");
		jlb4.setFont(new   java.awt.Font("Dialog",   1,   15));
		
		jtf1 = new JTextField(13);
		jtf2 = new JTextField(13);
		jtf3 = new JTextField(13);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		
		jp1.add(jlb1);
		jp1.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jtf2);
		jp3.add(jlb3);
		jp3.add(jtf3);
		jp4.add(jb1);
		jp4.add(jb2);
		
	    //���ò���
	    this.setTitle("ȷ����Ϣ");
	    this.setLayout(null);
	    
	    jlb4.setBounds(65, 20, 300 ,50);
	    jp1.setBounds(-10, 80, 300 ,50);
	    jp2.setBounds(-10, 150, 300 ,50);
	    jp3.setBounds(-10, 220, 300 ,50);
	    jp4.setBounds(-10, 290, 300 ,50);
	    
	    //��JPane����JFrame��  
	    this.add(jp1);  
	    this.add(jp2);  
	    this.add(jp3);
	    this.add(jp4);
	    this.add(jlb4);
	    
	    this.setSize(300, 400);   //���ô����С
	    this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����
	        
	    this.setVisible(true);  //���ÿɼ�
	    this.setResizable(false);	//���ò��������С
	    String []message = new UserMessage().read(countname);
	    //�������ĵ�һ���ֱ�Ϊ*
	    message[0] ="*"+message[0].substring(1,message[0].length());
	    //�����֤�ŵ�6��12λ���*
	    message[1] =message[1].substring(0,6)+"*******"+message[1].substring(13,message[1].length());
	    
	    jtf1.setText(message[0]);
	    jtf2.setText(message[1]);
	    jtf3.setText(countname);
	    
	    
	    
	    
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="ȷ��")
		{
			String nowmoney="";
			try {
				nowmoney = new UserMessage().updatemoney(mycountname,-Integer.parseInt(wantsave));
			} catch (NumberFormatException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			if (!nowmoney.equals("����"))
			{
				//jta2.setText("�������Ϊ:\n "+nowmoney);
				//jta1.setText("");
				//�Է��˻���Ǯ
				try {
					nowmoney = new UserMessage().updatemoney(countname,Integer.parseInt(wantsave));
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if (!nowmoney.equals("����"))
				{
					
					JOptionPane.showMessageDialog(null, "����ɹ����������Ϊ��"+nowmoney,"��Ϣ��ʾ",JOptionPane.PLAIN_MESSAGE);
					dispose();
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "��������������:","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
				dispose();
			}
		}
		else if (e.getActionCommand()=="ȡ��")
		{
			dispose();
		}
		
	}

	
	

}
