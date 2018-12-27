package contentcl;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @author contentcl
 * @Date 2017��12��24�� ����6:52:47
 *
 *�����ǶԹ�ʧģ��ı�д���û��������֤�ź������� ���жԻ����µ��˺Ž����һ��������
 */
public class ReportLose extends JFrame implements ActionListener{
	JButton jb1, jb2, jb3;  //��ť
	JPanel jp1,jp2,jp3, jp4;		//���
	JTextField jtf1,jtf2,jtf3,jtf4;   //�ı���
	JLabel jlb1, jlb2, jlb3; //��ǩ
	JTextArea jta;
	public ReportLose() 
	{
		// TODO Auto-generated constructor stub
		jb1 = new JButton("ȷ��");
		jb2 = new JButton("����");
		//���ð�ť����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jp1 = new JPanel();  //�������
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		
		jlb1 = new JLabel("        ����");  //��ӱ�ǩ
		jlb2 = new JLabel("���֤��");
		jlb3 = new JLabel("        �˺�");
		
		jtf1 = new JTextField(13);	//�����ı���
		jtf2 = new JTextField(13);
		jtf3 = new JTextField(13);
		
		//�����ı���
		 jta = new JTextArea();
		
		//���������
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		jp2.add(jlb2);
		jp2.add(jtf2);
		
		jp3.add(jlb3);
		jp3.add(jtf3);
		
		jp4.add(jb1);
		jp4.add(jb2);
		
       //���ò���
        this.setTitle("�һ�����");
        this.setLayout(new GridLayout(6,1));  //�������񲼾� 6,1
        this.setSize(400, 350); 
		//this.setLocation(400, 200);
        
        //��JPane����JFrame��  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp4);
        this.add(jta);
        
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
				ok();
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand()=="����")  
        {  
             clear();  
        }
	}
	//
	private void ok() throws HeadlessException, IOException {
		// TODO Auto-generated method stub
		//��Ϣ�п�ȱ
		if (jtf1.getText().isEmpty()||jtf2.getText().isEmpty()||
				jtf3.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "��Ϣ�п�ȱ���벹ȫ��","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		//�ж����֤���Ƿ�Ϊ18λ
		else if (jtf2.getText().length()!=18)
		{
			JOptionPane.showMessageDialog(null, "�Ƿ����֤�ţ����������룡","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			String []message = new String[3]; 
			message[0] = jtf1.getText();
			message[1] = jtf2.getText();
			message[2] = jtf3.getText();
			if (new Check().check2(message[2]))   //����Check��check��������û��Ƿ���ڣ� �������
			{
				String nowpwd = new Check().check3(message[0],message[1],message[2]);//�ж����������֤�ţ� �û������Ƿ�ƥ��
				if (nowpwd!=null)
				{
					JOptionPane.showMessageDialog(null,"����ȷ���鿴��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
					jta.setText("��������Ϊ��"+nowpwd+"  ,�����Ʊ��棡");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"�û���Ϣ�͸��˺Ų�ƥ�䣬��˶ԣ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"�˺Ų����ڣ���˶��˻���Ϣ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
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
			
	}

}
