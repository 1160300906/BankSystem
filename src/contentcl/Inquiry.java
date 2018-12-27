package contentcl;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
/**
 * 此类时对用户信息查询的编写，  我们将查询出用户的姓名身份证号和余额
 * @author contentcl
 * @Date 2017年12月27日 下午8:54:17
 *
 */
public class Inquiry extends JFrame implements ActionListener{

	JLabel jlb1, jlb2, jlb3;  //标签
	JTextField jtf1,jtf2,jtf3;   //文本框
	JPasswordField jpf; //密码框
	JPanel jp1,jp2,jp3;		//面板
	
	public Inquiry(String countname) throws IOException {
		// TODO Auto-generated constructor stub
		//标签信息
		
		jlb1 = new JLabel("        姓名");
		jlb2 = new JLabel("身份证号");
		jlb3 = new JLabel("        余额");
		
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
		
	    //设置布局
	    this.setTitle("查询");
	    this.setLayout(null);   //采用空布局
	    
	    jp1.setBounds(-10, 40, 300 ,50);   //-别问我为什么-10 因为 界面好看一点啊
	    jp2.setBounds(-10, 110, 300 ,50);
	    jp3.setBounds(-10, 180, 300 ,50);
	    
	    //将JPane加入JFrame中  
	    this.add(jp1);  
	    this.add(jp2);  
	    this.add(jp3); 
	    
	    this.setSize(300, 300);   //设置窗体大小
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
	    jtf3.setText(message[4]);
	    
	    
	    
	    
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
