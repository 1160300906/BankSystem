package contentcl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * ����ʵ�ֶ�ת�˵Ĳ����� ע����Ĵ���
 * @author contentcl
 * @Date 2017��12��25�� ����8:00:05
 *
 */
public class Transfer extends JFrame implements ActionListener{
	String countname;
	JButton jb1, jb2, jb3;  //��ť
	JLabel jlb1, jlb2, jlb3; //��ǩ
	JTextArea jta1,jta2;    //�ı���
	JTextField jtf1;
	JPanel jp1;
	
	public static boolean flag=true;
	
	public Transfer(String countname) {
		this.countname = countname;
		
		// TODO Auto-generated constructor stub
		jb1 = new JButton("ȷ��");
		jb2 = new JButton("����");
		//���ð�ť����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		
		jlb1 = new JLabel("����������");  //��ӱ�ǩ
		jlb2 = new JLabel("�Է��˺�");
		
		//�����ı���
		 jta1 = new JTextArea();   //ת�����
		 jtf1 = new JTextField(13);
		
		//�Է��˻��������
		 jp1 = new JPanel();
		 jp1.add(jlb2);
		 jp1.add(jtf1);
		 
       //���ò���
        this.setTitle("ת��");
        this.setLayout(null);
        this.setSize(300, 300); 
        
        //�����Է��˻��ı�ǩ
        jp1.setBounds(20, 20, 210, 60);
        
        //�����ǩ���ı���
        jlb1.setBounds(20, 80, 200, 20);
        jta1.setBounds(20, 110, 250, 50);
        jta1.setFont(new   java.awt.Font("Dialog",   0,   15));
        
        //ȷ�������ð�ť
        jb1.setBounds(60, 180, 62, 28);
        jb2.setBounds(160, 180, 62, 28);
        
        
        this.add(jp1);
       this.add(jlb1);
       this.add(jta1);
       this.add(jb1);
       this.add(jb2);
        
       this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����
        
       this.setVisible(true);  //���ÿɼ�
       this.setResizable(false);	//���ò��������С
		
	}
	
	//����˺ź������
	private void clear() 
	{
		// TODO Auto-generated method stub
		jtf1.setText("");
		jta1.setText("");    //����Ϊ��
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="ȷ��")
		{
			
			try {
				transfer();
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

	private void transfer() throws IOException {
		// TODO Auto-generated method stub
		if (jta1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "���Ϊ�գ����������룡","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		else if (jtf1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "ת���˺ţ����������룡","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		else if(new Check().checkmoney(jta1.getText()))  //��֤����Ƿ�Ϸ�
		{
			if(new Check().check2(jtf1.getText()))   //��֤�˻��Ƿ����
			{
				new TransferToOthers(countname,jtf1.getText(),jta1.getText());  //�������˻��� �Է��˻����ͽ��ݹ�ȥ
				clear();
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "�˻�������","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
				clear();
			}
			
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "���Ϸ�","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
			clear();
		}
		
	}
	

}
