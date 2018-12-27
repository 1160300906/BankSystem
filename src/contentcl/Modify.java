package contentcl;

import java.awt.GridLayout;
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

/**
 * ʵ�ָ��ܲ���
 * @author contentcl
 * @Date 2017��12��27�� ����9:53:18
 *
 */
public class Modify extends JFrame implements ActionListener{
	JButton jb1, jb2, jb3;  //��ť
	JPanel jp1,jp2,jp3, jp4;		//���
	JPasswordField jtf1,jtf2;   //�ı���
	JLabel jlb1, jlb2, jlb3; //��ǩ
	
	String name = "123";   //�˺�����
	String pwd = "123"; 
	String countname;
	
	public Modify(String countname) {
		this.countname = countname;
		// TODO Auto-generated constructor stub
		jb1 = new JButton("ȷ��");
		jb2 = new JButton("����");
		//���ð�ť����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jp1 = new JPanel();  //�������
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jlb1 = new JLabel("    ������");  //��ӱ�ǩ
		jlb2 = new JLabel("�ظ�����");
		
		jtf1 = new JPasswordField(10);	//�����ı���
		jtf2 = new JPasswordField(10);
		
		//���������
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		jp2.add(jlb2);
		jp2.add(jtf2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//��JPane����JFrame��  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        
       //���ò���
        this.setTitle("�û���¼");
        this.setLayout(new GridLayout(3,1));  //�������񲼾�
        this.setSize(300, 200);   //���ô����С
        this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����
        
        this.setVisible(true);  //���ÿɼ�
        this.setResizable(false);	//���ò��������С
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="ȷ��")
		{
			
			try {
				modify();  //������Ϣ�˶�
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		}
		else if (e.getActionCommand()=="����")
		{
			clear();   //�����Ϣ
		}
		
	}

	private void modify() throws IOException {
		// TODO Auto-generated method stub
		if (jtf1.getText().isEmpty()||jtf2.getText().isEmpty())  //�ж���Ϣ�Ƿ�Ϊ��
		{
			JOptionPane.showMessageDialog(null, "��Ϣδ��д��ɣ�","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		else if (jtf1.getText().equals(jtf2.getText()))
		{
			new UserMessage().updatepwd(countname, jtf1.getText());   //����UserMessage��updatepwd������������
			JOptionPane.showMessageDialog(null, "�޸ĳɹ���","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
			dispose();
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "2�����벻һ�£����������룡","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
			clear();
		}
		
	}
	//��������
	private void clear() 
	{
		// TODO Auto-generated method stub
		jtf1.setText("");    //����Ϊ��
        jtf2.setText("");  
	}
	

}
