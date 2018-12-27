package contentcl;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
/**
 * ����ʱ���û���Ϣ��ѯ�ı�д��  ���ǽ���ѯ���û����������֤�ź����
 * @author contentcl
 * @Date 2017��12��27�� ����8:54:17
 *
 */
public class Inquiry extends JFrame implements ActionListener{

	JLabel jlb1, jlb2, jlb3;  //��ǩ
	JTextField jtf1,jtf2,jtf3;   //�ı���
	JPasswordField jpf; //�����
	JPanel jp1,jp2,jp3;		//���
	
	public Inquiry(String countname) throws IOException {
		// TODO Auto-generated constructor stub
		//��ǩ��Ϣ
		
		jlb1 = new JLabel("        ����");
		jlb2 = new JLabel("���֤��");
		jlb3 = new JLabel("        ���");
		
		jtf1 = new JTextField(13);
		jtf2 = new JTextField(13);
		jtf3 = new JTextField(13);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jp1.add(jlb1);
		jp1.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jtf2);
		jp3.add(jlb3);
		jp3.add(jtf3);
		
	    //���ò���
	    this.setTitle("��ѯ");
	    this.setLayout(null);   //���ÿղ���
	    
	    jp1.setBounds(-10, 40, 300 ,50);   //-������Ϊʲô-10 ��Ϊ ����ÿ�һ�㰡
	    jp2.setBounds(-10, 110, 300 ,50);
	    jp3.setBounds(-10, 180, 300 ,50);
	    
	    //��JPane����JFrame��  
	    this.add(jp1);  
	    this.add(jp2);  
	    this.add(jp3); 
	    
	    this.setSize(300, 300);   //���ô����С
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
	    jtf3.setText(message[4]);
	    
	    
	    
	    
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
