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
 * 实现改密操作
 * @author contentcl
 * @Date 2017年12月27日 上午9:53:18
 *
 */
public class Modify extends JFrame implements ActionListener{
	JButton jb1, jb2, jb3;  //按钮
	JPanel jp1,jp2,jp3, jp4;		//面板
	JPasswordField jtf1,jtf2;   //文本框
	JLabel jlb1, jlb2, jlb3; //标签
	
	String name = "123";   //账号密码
	String pwd = "123"; 
	String countname;
	
	public Modify(String countname) {
		this.countname = countname;
		// TODO Auto-generated constructor stub
		jb1 = new JButton("确定");
		jb2 = new JButton("重置");
		//设置按钮监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jp1 = new JPanel();  //创建面板
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jlb1 = new JLabel("    新密码");  //添加标签
		jlb2 = new JLabel("重复密码");
		
		jtf1 = new JPasswordField(10);	//创建文本框
		jtf2 = new JPasswordField(10);
		
		//加入面板中
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		jp2.add(jlb2);
		jp2.add(jtf2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//将JPane加入JFrame中  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        
       //设置布局
        this.setTitle("用户登录");
        this.setLayout(new GridLayout(3,1));  //利用网格布局
        this.setSize(300, 200);   //设置窗体大小
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
				modify();  //进行信息核对
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		}
		else if (e.getActionCommand()=="重置")
		{
			clear();   //清楚信息
		}
		
	}

	private void modify() throws IOException {
		// TODO Auto-generated method stub
		if (jtf1.getText().isEmpty()||jtf2.getText().isEmpty())  //判断信息是否为空
		{
			JOptionPane.showMessageDialog(null, "信息未填写完成！","消息提示",JOptionPane.WARNING_MESSAGE);
		}
		else if (jtf1.getText().equals(jtf2.getText()))
		{
			new UserMessage().updatepwd(countname, jtf1.getText());   //调用UserMessage的updatepwd函数更新密码
			JOptionPane.showMessageDialog(null, "修改成功！","消息提示",JOptionPane.WARNING_MESSAGE);
			dispose();
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "2次密码不一致，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
			clear();
		}
		
	}
	//清空密码框
	private void clear() 
	{
		// TODO Auto-generated method stub
		jtf1.setText("");    //设置为空
        jtf2.setText("");  
	}
	

}
