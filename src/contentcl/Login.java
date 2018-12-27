package contentcl;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

	JButton jb1, jb2, jb3;  //��ť
	JPanel jp1,jp2,jp3, jp4;		//���
	JTextField jtf;   //�ı���
	JLabel jlb1, jlb2, jlb3; //��ǩ
	JPasswordField jpf; //�����
	
	String name = "123";   //�˺�����
	String pwd = "123"; 
	String order;
	
	public Login(String order) {
		this.order = order;
		// TODO Auto-generated constructor stub
		jb1 = new JButton("��¼");
		jb2 = new JButton("����");
		//���ð�ť����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jp1 = new JPanel();  //�������
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jlb1 = new JLabel("�û���");  //��ӱ�ǩ
		jlb2 = new JLabel("  ��  ��");
		
		jtf = new JTextField(10);	//�����ı���������
		jpf = new JPasswordField(10);
		
		//���������
		jp1.add(jlb1);
		jp1.add(jtf);
		
		jp2.add(jlb2);
		jp2.add(jpf);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//��JPane����JFrame��  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        
       //���ò���
        this.setTitle("�û���¼");
        this.setLayout(new GridLayout(3,1));
        this.setSize(300, 200);   //���ô����С
        this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����
        
        this.setVisible(true);  //���ÿɼ�
        this.setResizable(false);	//���ò��������С
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="��¼")
		{
			try {
				login();
			} catch (HeadlessException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand()=="����")  
        {  
             clear();  
        }
	}
	//����˺ź������
	private void clear() {
		// TODO Auto-generated method stub
		jtf.setText("");    //����Ϊ��
        jpf.setText("");  
		
	}

	//��֤��¼��Ϣ����������
	public void login() throws HeadlessException, IOException
	{
		//�ж��˻����������Ƿ��������
		if (new Check().checkcountname(jtf.getText())||new Check().checkcountname(jpf.getText()))
		{
			JOptionPane.showMessageDialog(null, "�û���������������ģ����Ϸ�!","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "�˺�����Ϊ�գ������룡","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		else if (jtf.getText().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null, "�˺�Ϊ�գ������룡","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		else if (jpf.getText().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null, "����Ϊ�գ������룡","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
			
		}
		else if (new Check().check1(jtf.getText(),jpf.getText()))
		{
			JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			//dispose();  //ʹ��ԭ������ʧ
			if (order.equals("��ѯ"))
			{
				new Inquiry(jtf.getText()); //��ת����¼������Ϣѡ�����
				dispose();
			}
			if (order.equals("���"))
			{
				new SaveMoney(jtf.getText());
				dispose();
			}
			if (order.equals("ȡ��"))
			{
				new DrawMoney(jtf.getText());
				dispose();
			}
			if (order.equals("����"))
			{
				new Modify(jtf.getText());
				dispose();
			}
			if (order.equals("ת��"))
			{
				new Transfer(jtf.getText());
				dispose();
			}
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "�˺�����������������룡","��Ϣ��ʾ",JOptionPane.ERROR_MESSAGE);
			clear();  //�����������
		}
	}
	

	
}
