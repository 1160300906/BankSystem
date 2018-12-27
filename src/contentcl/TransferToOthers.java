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
	JButton jb1, jb2, jb3;  //按钮
	JLabel jlb1, jlb2, jlb3,jlb4;  //标签
	JTextField jtf1,jtf2,jtf3;   //文本框
	JPasswordField jpf; //密码框
	JPanel jp1,jp2,jp3,jp4;		//面板
	String wantsave,countname,mycountname;
	//private boolean flag;
	
	public TransferToOthers(String mycountname, String countname, String wantsave) throws IOException {
		// TODO Auto-generated constructor stub
		this.wantsave = wantsave;
		this.countname = countname;
		this.mycountname = mycountname;
		
		jb1 = new JButton("确定");
		jb2 = new JButton("取消");
		//设置按钮监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		//标签信息
		
		jlb1 = new JLabel("对方姓名");
		jlb2 = new JLabel("身份证号");
		jlb3 = new JLabel("        账号");
		jlb4 = new JLabel("请确认对方账户信息");
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
		
	    //设置布局
	    this.setTitle("确认信息");
	    this.setLayout(null);
	    
	    jlb4.setBounds(65, 20, 300 ,50);
	    jp1.setBounds(-10, 80, 300 ,50);
	    jp2.setBounds(-10, 150, 300 ,50);
	    jp3.setBounds(-10, 220, 300 ,50);
	    jp4.setBounds(-10, 290, 300 ,50);
	    
	    //将JPane加入JFrame中  
	    this.add(jp1);  
	    this.add(jp2);  
	    this.add(jp3);
	    this.add(jp4);
	    this.add(jlb4);
	    
	    this.setSize(300, 400);   //设置窗体大小
	    this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口
	        
	    this.setVisible(true);  //设置可见
	    this.setResizable(false);	//设置不可拉伸大小
	    String []message = new UserMessage().read(countname);
	    //将姓名的第一个字变为*
	    message[0] ="*"+message[0].substring(1,message[0].length());
	    //将身份证号第6到12位变成*
	    message[1] =message[1].substring(0,6)+"*******"+message[1].substring(13,message[1].length());
	    
	    jtf1.setText(message[0]);
	    jtf2.setText(message[1]);
	    jtf3.setText(countname);
	    
	    
	    
	    
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="确定")
		{
			String nowmoney="";
			try {
				nowmoney = new UserMessage().updatemoney(mycountname,-Integer.parseInt(wantsave));
			} catch (NumberFormatException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			if (!nowmoney.equals("负数"))
			{
				//jta2.setText("您的余额为:\n "+nowmoney);
				//jta1.setText("");
				//对方账户存钱
				try {
					nowmoney = new UserMessage().updatemoney(countname,Integer.parseInt(wantsave));
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if (!nowmoney.equals("负数"))
				{
					
					JOptionPane.showMessageDialog(null, "存入成功，您的余额为："+nowmoney,"消息提示",JOptionPane.PLAIN_MESSAGE);
					dispose();
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "余额不足请重新输入:","消息提示",JOptionPane.WARNING_MESSAGE);
				dispose();
			}
		}
		else if (e.getActionCommand()=="取消")
		{
			dispose();
		}
		
	}

	
	

}
