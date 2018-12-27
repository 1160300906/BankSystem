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
 * @Date 2017年12月24日 下午6:52:47
 *
 *此类是对挂失模块的编写，用户利用身份证号和姓名， 进行对户名下的账号进行找回密码操作
 */
public class ReportLose extends JFrame implements ActionListener{
	JButton jb1, jb2, jb3;  //按钮
	JPanel jp1,jp2,jp3, jp4;		//面板
	JTextField jtf1,jtf2,jtf3,jtf4;   //文本框
	JLabel jlb1, jlb2, jlb3; //标签
	JTextArea jta;
	public ReportLose() 
	{
		// TODO Auto-generated constructor stub
		jb1 = new JButton("确定");
		jb2 = new JButton("重置");
		//设置按钮监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jp1 = new JPanel();  //创建面板
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		
		jlb1 = new JLabel("        姓名");  //添加标签
		jlb2 = new JLabel("身份证号");
		jlb3 = new JLabel("        账号");
		
		jtf1 = new JTextField(13);	//创建文本框
		jtf2 = new JTextField(13);
		jtf3 = new JTextField(13);
		
		//创建文本框
		 jta = new JTextArea();
		
		//加入面板中
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		jp2.add(jlb2);
		jp2.add(jtf2);
		
		jp3.add(jlb3);
		jp3.add(jtf3);
		
		jp4.add(jb1);
		jp4.add(jb2);
		
       //设置布局
        this.setTitle("找回密码");
        this.setLayout(new GridLayout(6,1));  //采用网格布局 6,1
        this.setSize(400, 350); 
		//this.setLocation(400, 200);
        
        //将JPane加入JFrame中  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp4);
        this.add(jta);
        
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口
        
        this.setVisible(true);  //设置可见
        this.setResizable(false);	//设置不可拉伸大小
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="确定")
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
		else if(e.getActionCommand()=="重置")  
        {  
             clear();  
        }
	}
	//
	private void ok() throws HeadlessException, IOException {
		// TODO Auto-generated method stub
		//信息有空缺
		if (jtf1.getText().isEmpty()||jtf2.getText().isEmpty()||
				jtf3.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "信息有空缺，请补全！","消息提示",JOptionPane.WARNING_MESSAGE);
		}
		//判断身份证号是否为18位
		else if (jtf2.getText().length()!=18)
		{
			JOptionPane.showMessageDialog(null, "非法身份证号，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			String []message = new String[3]; 
			message[0] = jtf1.getText();
			message[1] = jtf2.getText();
			message[2] = jtf3.getText();
			if (new Check().check2(message[2]))   //调用Check的check方法检测用户是否存在， 如果存在
			{
				String nowpwd = new Check().check3(message[0],message[1],message[2]);//判断姓名，身份证号， 用户名，是否匹配
				if (nowpwd!=null)
				{
					JOptionPane.showMessageDialog(null,"请点击确定查看！","提示消息",JOptionPane.WARNING_MESSAGE);
					jta.setText("您的密码为："+nowpwd+"  ,请妥善保存！");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"用户信息和该账号不匹配，请核对！","提示消息",JOptionPane.WARNING_MESSAGE);
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"账号不存在，请核对账户信息！","提示消息",JOptionPane.WARNING_MESSAGE);
				//dispose();
			}
		}
	}

	//清空账号和密码框
	private void clear() {
			// TODO Auto-generated method stub
			jtf1.setText("");    //设置为空
	        jtf2.setText("");
	        jtf3.setText("");  
			
	}

}
