package contentcl;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

/**
 * ������ɶԿ���ҳ��ı�д�� �û�����д ���������֤�ţ� �˻������룬���������Ϣ
 * 
 * ���һ������֤������ �������Ƿ�Ϸ������ģ��� ���֤���Ƿ�Ϸ��ȵ�
 * @author contentcl
 * @Date 2017��12��27�� ����8:32:19
 *
 */
public class Register extends JFrame implements ActionListener{
	
	JButton jb1, jb2;  //��ť
	JLabel jlb1, jlb2, jlb3,jlb4,jlb5, jlb6;  //��ǩ
	JTextField jtf1,jtf2,jtf3,jtf4, jtf5;   //�ı���
	JPasswordField jpf; //�����
	JPanel jp1,jp2,jp3, jp4,jp5,jp6,jp7;		//���
	
	public Register() {
		// TODO Auto-generated constructor stub
		//��ť
		jb1 = new JButton("ȷ��");
		jb2 = new JButton("����");
		//���ð�ť����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		//��ǩ��Ϣ
		
		jlb1 = new JLabel("        ����");
		jlb2 = new JLabel("���֤��");
		jlb3 = new JLabel("        �˺�");
		jlb4 = new JLabel("        ����");
		jlb6 = new JLabel("ע����Ϣ");
		jlb5 = new JLabel("�������");
		
		jlb6.setFont(new   java.awt.Font("Dialog",   1,   20));   //�����������ͣ��Ӵ֣���СΪ20
		//�ı���Ϣ
		jtf1 = new JTextField(13);
		jtf2 = new JTextField(13);
		jtf3 = new JTextField(13);
		jtf4 = new JTextField(13);
		jtf5 = new JTextField(13);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp7 = new JPanel();
		//����Ӧ��Ϣ���������
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		jp2.add(jlb2);
		jp2.add(jtf2);
		
		jp3.add(jlb3);
		jp3.add(jtf3);
		
		jp4.add(jlb4);
		jp4.add(jtf4);
		
		jp5.add(jlb5);
		jp5.add(jtf5);
		
		jp6.add(jb1);
		jp6.add(jb2);
		
		jp7.add(jlb6);
		
		//��JPane����JFrame��  
		this.add(jp7);  //�ȼ�����ʾ��
		
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3); 
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);
        
        //���ò���
        this.setTitle("ע����Ϣ");
        this.setLayout(new GridLayout(7, 1));
        this.setSize(350, 350);   //���ô����С
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
				register();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getActionCommand()=="����")
		{
			clear();
		}
		
	}
	//��֤ע����Ϣ����������
	public void register() throws IOException
	{
		//�ж���Ϣ�Ƿ�ȫ
		if (jtf1.getText().isEmpty()||jtf2.getText().isEmpty()||
				jtf3.getText().isEmpty()||jtf4.getText().isEmpty()||jtf5.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "��Ϣ�п�ȱ���벹ȫ��","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		//�ж����֤���Ƿ�Ϊ18λ
		else if (jtf2.getText().length()!=18)
		{
			JOptionPane.showMessageDialog(null, "�Ƿ����֤�ţ����������룡","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		//�жϽ���Ƿ�Ϸ�
		else if (!new Check().checkmoney(jtf5.getText()))
		{  
			JOptionPane.showMessageDialog(null, "������Ϸ�!","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		//�ж������Ƿ�Ϊȫ����
		else if (!new Check().checkname(jtf1.getText()))
		{
			JOptionPane.showMessageDialog(null, "�������Ϸ���","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		//�ж��˻����������Ƿ��������
		else if (new Check().checkcountname(jtf3.getText())||new Check().checkcountname(jtf4.getText()))
		{
			JOptionPane.showMessageDialog(null, "�û���������������ģ����Ϸ�!","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		//����Ҫ��
		else if (!jtf1.getText().isEmpty()&&!jtf2.getText().isEmpty()&&
				!jtf3.getText().isEmpty()&&!jtf4.getText().isEmpty()&&!jtf5.getText().isEmpty())
		{
			//ע��ɹ��� ���Ϊ��Ϣ���鴫�ݸ�UserMessage���и��²���
			String []message = new String[5]; 
			message[0] = jtf1.getText();   //��ȡ������ı���Ϣ
			message[1] = jtf2.getText();
			message[2] = jtf3.getText();
			message[3] = jtf4.getText();
			message[4] = jtf5.getText();
			if (!new Check().check2(message[2]))   //����Check��check��������û��Ƿ���ڣ� ���������ִ��
			{
				new UserMessage().write(message);   //����UserMseeage��write��������д������ ����Ϣ��ʽ������
				JOptionPane.showMessageDialog(null,"ע��ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				dispose();  //ʹ������ʧ
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"�˺��Ѵ��ڣ����������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				//dispose();
			}
		}
	}
	
	//����˺ź������
	private void clear() {
		// TODO Auto-generated method stub
		jtf1.setText("");    //����Ϊ��
	    jtf2.setText("");  
	    jtf3.setText("");  
	    jtf4.setText("");  
	    jtf5.setText("");  
			
	}
	

}
