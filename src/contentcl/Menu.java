package contentcl;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * 
 * @author contentcl
 * Menu��һ�� �˵��࣬Ҳ����Ϊ�ײ��һ����
 * �ṩ�������ܵİ�ť
 * 
 * ����δʹ�ò��֣� ����ʹ������̶��˸�����ǩ�Ͱ�ť��λ��
 *
 */

public class Menu extends JFrame implements ActionListener{
	
	JButton jb1, jb2, jb3,jb4,jb5,jb6,jb7, jb8;  //������ť
	JLabel jlb1, jlb2, jlb3;   //��ǩ
	public Menu() 
	{
		jb1 = new JButton("��ѯ");
		jb2 = new JButton("���");
		jb3 = new JButton("ȡ��");
		jb4 = new JButton("ת��");
		jb5 = new JButton("����");
		jb6 = new JButton("����");
		jb7 = new JButton("�˿�");
		jb8 = new JButton("��ʧ");
		
		
		jlb1 = new JLabel("֪�㳣������");
		jlb1.setFont(new   java.awt.Font("Dialog",   1,   23)); //�����������ͣ� �Ƿ�Ӵ֣��ֺ�
		jlb2 = new JLabel("��ӭ��");
		jlb2.setFont(new   java.awt.Font("Dialog",   1,   20));
		jlb3 = new JLabel("����ѡ�����");
		jlb3.setFont(new   java.awt.Font("Dialog",   1,   22));
		
		jb1.addActionListener(this);   //�¼�����
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		jb7.addActionListener(this);
		jb8.addActionListener(this);
		
		this.setTitle("���й������ϵͳ");  //���ô������
		this.setSize(450, 500); 		//���ô����С
		this.setLocation(400, 200);		//����λ��
		this.setLayout(null);			//���ò��֣������ò���
		
		//���ð�ť��λ�úʹ�С
		jb1.setBounds( 0,50,90,60);   
		jb2.setBounds( 0,150,90,60);
		jb3.setBounds( 0,250,90,60);
		jb8.setBounds(0,350,90,60);
		jb4.setBounds( 354,50,90,60);
		jb5.setBounds( 354,150,90,60);
		jb6.setBounds( 354,250,90,60);
		jb7.setBounds(354,350,90,60);
		
		//���ñ�ǩ��λ�úʹ�С
		jlb1.setBounds(150,120,150,50);
		jlb2.setBounds(190,160,150,50);
		jlb3.setBounds(150,250,150,50);
		
		this.add(jb1);   //���봰��
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		this.add(jb7);
		this.add(jb8);
		this.add(jlb1);
		this.add(jlb2);
		this.add(jlb3);
		
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);  //���ÿɹر�
	     
	    this.setVisible(true);  //���ÿɼ�
	    this.setResizable(false);	//���ò��������С
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="��ѯ")
		{
			//String order = e.getActionCommand();
			new Login(e.getActionCommand());
		}
		else if (e.getActionCommand()=="���")
		{
			new Login(e.getActionCommand());
		}
		else if (e.getActionCommand()=="ȡ��")
		{
			new Login(e.getActionCommand());
		}
		else if (e.getActionCommand()=="ת��")
		{
			new Login(e.getActionCommand());
		}
		else if (e.getActionCommand()=="����")
		{
			new Login(e.getActionCommand());
		}
		else if (e.getActionCommand()=="����")
		{
			new Register();  //��ת��������
		}
		else if (e.getActionCommand()=="��ʧ")
		{
			new ReportLose();  
		}
		else if (e.getActionCommand()=="�˿�")
		{
			System.exit(0);;
		}
		
		
	}

}
