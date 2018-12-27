package contentcl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * ����ʵ�� ��ȡǮ������ʵ�֣� ��Ҫ˼· ʵ�ֶ��û������޸�
 * ������������ Ҫ�ж� ���Ĵ�С �Ƿ��ܹ�ȡ��  �Ҳ��ܳ��ָ���
 * 
 * @author contentcl
 * @Date 2017��12��25�� ����7:58:09
 *
 */
public class DrawMoney extends JFrame implements ActionListener{
	String countname;
	JButton jb1, jb2, jb3;  //��ť
	JLabel jlb1, jlb2, jlb3; //��ǩ
	JTextArea jta1,jta2;
	
	public DrawMoney(String countname) {
		this.countname = countname;
		
		// TODO Auto-generated constructor stub
		jb1 = new JButton("ȷ��");
		jb2 = new JButton("����");
		//���ð�ť����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		
		jlb1 = new JLabel("������ȡ����");  //��ӱ�ǩ
		
		//�����ı���
		 jta1 = new JTextArea();
		 jta2 = new JTextArea();
		
		
       //���ò���
        this.setTitle("ȡǮ");
        this.setLayout(null);
        this.setSize(300, 300); 
        
        //�����ǩ���ı���
        jlb1.setBounds(5, 20, 200, 20);
        jta1.setBounds(20, 50, 250, 50);
        jta1.setFont(new   java.awt.Font("Dialog",   0,   15));
        
        //ȷ�������ð�ť
        jb1.setBounds(60, 120, 62, 28);
        jb2.setBounds(160, 120, 62, 28);
        
        //��ʾ����ı���
        //jlb1.setBounds(5, 20, 200, 20);
        jta2.setBounds(20, 160, 300, 50);
        jta2.setFont(new   java.awt.Font("Dialog",   1,   15));
        //jta2.setText("�������Ϊ:\n ");
        
       this.add(jlb1);
       this.add(jta1);
       this.add(jb1);
       this.add(jb2);
       this.add(jta2);
        
       this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����
        
       this.setVisible(true);  //���ÿɼ�
       this.setResizable(false);	//���ò��������С
		
	}
	
	//����˺ź������
		private void clear() 
		{
			// TODO Auto-generated method stub
			jta1.setText("");    //����Ϊ��
	        jta2.setText("");  
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="ȷ��")
		{
			
			try {
				drawmoney();   //����������ж��Ƿ�Ϸ�
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

	private void drawmoney() throws IOException {
		// TODO Auto-generated method stub
		if (jta1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "���Ϊ�գ����������룡","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		else if(new Check().checkmoney(jta1.getText()))
		{
			String nowmoney = new UserMessage().updatemoney(countname,-Integer.parseInt(jta1.getText()));
			if (!nowmoney.equals("����"))
			{
				jta2.setText("�������Ϊ:\n "+nowmoney);
				jta1.setText("");
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "��������������:","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
				clear();
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "������Ϸ�!","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		
	}
	

}
