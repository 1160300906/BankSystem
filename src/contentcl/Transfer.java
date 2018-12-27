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
 * 本类实现对转账的操作， 注意金额的处理
 * @author contentcl
 * @Date 2017年12月25日 下午8:00:05
 *
 */
public class Transfer extends JFrame implements ActionListener{
	String countname;
	JButton jb1, jb2, jb3;  //按钮
	JLabel jlb1, jlb2, jlb3; //标签
	JTextArea jta1,jta2;    //文本框
	JTextField jtf1;
	JPanel jp1;
	
	public static boolean flag=true;
	
	public Transfer(String countname) {
		this.countname = countname;
		
		// TODO Auto-generated constructor stub
		jb1 = new JButton("确定");
		jb2 = new JButton("重置");
		//设置按钮监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		
		jlb1 = new JLabel("请输入存入金额：");  //添加标签
		jlb2 = new JLabel("对方账号");
		
		//创建文本框
		 jta1 = new JTextArea();   //转出金额
		 jtf1 = new JTextField(13);
		
		//对方账户加入面板
		 jp1 = new JPanel();
		 jp1.add(jlb2);
		 jp1.add(jtf1);
		 
       //设置布局
        this.setTitle("转账");
        this.setLayout(null);
        this.setSize(300, 300); 
        
        //创建对方账户的标签
        jp1.setBounds(20, 20, 210, 60);
        
        //存入标签和文本框
        jlb1.setBounds(20, 80, 200, 20);
        jta1.setBounds(20, 110, 250, 50);
        jta1.setFont(new   java.awt.Font("Dialog",   0,   15));
        
        //确定和重置按钮
        jb1.setBounds(60, 180, 62, 28);
        jb2.setBounds(160, 180, 62, 28);
        
        
        this.add(jp1);
       this.add(jlb1);
       this.add(jta1);
       this.add(jb1);
       this.add(jb2);
        
       this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口
        
       this.setVisible(true);  //设置可见
       this.setResizable(false);	//设置不可拉伸大小
		
	}
	
	//清空账号和密码框
	private void clear() 
	{
		// TODO Auto-generated method stub
		jtf1.setText("");
		jta1.setText("");    //设置为空
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="确定")
		{
			
			try {
				transfer();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getActionCommand()=="重置")
		{
			clear();
		}
		
	}

	private void transfer() throws IOException {
		// TODO Auto-generated method stub
		if (jta1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "金额为空，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
		}
		else if (jtf1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "转入账号，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
		}
		else if(new Check().checkmoney(jta1.getText()))  //验证金额是否合法
		{
			if(new Check().check2(jtf1.getText()))   //验证账户是否存在
			{
				new TransferToOthers(countname,jtf1.getText(),jta1.getText());  //将本人账户名 对方账户名和金额传递过去
				clear();
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "账户不存在","消息提示",JOptionPane.WARNING_MESSAGE);
				clear();
			}
			
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "金额不合法","消息提示",JOptionPane.WARNING_MESSAGE);
			clear();
		}
		
	}
	

}
