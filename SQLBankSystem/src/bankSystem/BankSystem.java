package bankSystem;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class BankSystem {
//	public static int i=0;
	public static Connection connection() throws SQLException, ClassNotFoundException{
		//1.加载驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.得到连接
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","jmq.990467");
	      return conn;
	}
   public static int openAccount(String name,String pwd,String pwd1,float money,String work) throws ClassNotFoundException, SQLException{
	   Connection conn=connection();
	   //验证两次输入的密码是否相同
	   if(pwd.equals(pwd1))
	   {
		 //创建新用户
	//	   i++;
		String sql1="insert into t_user(username,password,balance) values(?,?,?)";
	      PreparedStatement psmt=conn.prepareStatement(sql1);
	    //  psmt.setInt(1, i);
	      psmt.setString(1, name);
	      psmt.setString(2, pwd);
	      psmt.setFloat(3,money);
	     int rs= psmt.executeUpdate();
	     Calendar calendar= Calendar.getInstance();
	     SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
	      if(rs!=0)
	      {
	    //返回新用户分配到的账号
	    	  Statement sm =conn.createStatement();
	    	  ResultSet rs1=sm.executeQuery("select accountnumber from t_user where username='"+name+"'");
	    	  while(rs1.next())
	    	  {
				int str =rs1.getInt(1);
				String sql2="insert into t_history(accountnumber,money,content,time,worker) values("+str+","+money+",'开户',?,'"+work+"')";
			      psmt=conn.prepareStatement(sql2);	
			      psmt.setString(1,dateFormat.format(calendar.getTime()));
			      psmt.executeUpdate();
				return str;
	    	  }
	      }
	   }
	  
	   return 0;
   }
   public static String[] balanceInquiry(int num,String psw) throws ClassNotFoundException, SQLException
   {
	   //查询账户信息
	   Connection conn=connection();
	   String sql="select * from t_user where accountnumber='"+num+"' and password='"+psw+"'";
	   PreparedStatement psmt=conn.prepareStatement(sql);
	   ResultSet rs=psmt.executeQuery();
	   if(rs.next())
		{
		String[] str =new String[3];
			str[0]=rs.getString(1);//记录账号
			str[1]=rs.getString(2);//记录用户名
			str[2]=rs.getString(4);//记录余额
			return str;
			}
	return null;
   }
   public static Boolean deposite(int num,String psw,Float money,String work) throws ClassNotFoundException, SQLException{
	   Connection conn=connection();
	   	//存款
	   String sql1="update t_user set balance=balance+? where accountnumber=? and password=?";
	      PreparedStatement psmt=conn.prepareStatement(sql1);
	      psmt.setFloat(1, money);
	      psmt.setInt(2, num);
	      psmt.setString(3, psw);
	      int rs1=psmt.executeUpdate();
//	     //同时将交易记录存入数据库
//	      Calendar calendar= Calendar.getInstance();
//		     SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//	     String sql2="insert into t_history(accountnumber,money,content,time) values("+num+","+money+",'存款','"+dateFormat.format(calendar.getTime())+"')";
//	      psmt=conn.prepareStatement(sql2);	
//	      psmt.executeUpdate();
	      if(rs1>0)
			{
	    	  //同时将交易记录存入数据库
		      Calendar calendar= Calendar.getInstance();
			     SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		     String sql2="insert into t_history(accountnumber,money,content,time,worker) values("+num+","+money+",'存款','"+dateFormat.format(calendar.getTime())+"','"+work+"')";
		      psmt=conn.prepareStatement(sql2);	
		      psmt.executeUpdate();
	    	  return true;
			}
			else
			{
				return false;
			}
   }
   public static boolean withdraw(int num,String psw,float money,String work) throws ClassNotFoundException, SQLException{
	   //取款
	   Connection conn=connection();
	   String sql1="update t_user set balance=balance-? where accountnumber=? and password=?";
	      PreparedStatement psmt=conn.prepareStatement(sql1);
	      psmt.setFloat(1, money);
	      psmt.setInt(2, num);
	      psmt.setString(3, psw);
	      int rs1=psmt.executeUpdate();
//	    //同时将交易记录存入数据库
//	      Calendar calendar= Calendar.getInstance();
//		     SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//	     String sql2="insert into t_history(accountnumber,money,content,time) values("+num+","+money+",'取款','"+dateFormat.format(calendar.getTime())+"')";
//	     psmt=conn.prepareStatement(sql2);	
//	     psmt.executeUpdate();
	      if(rs1>0)
			{
	    	  //同时将交易记录存入数据库
		      Calendar calendar= Calendar.getInstance();
			     SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		     String sql2="insert into t_history(accountnumber,money,content,time,worker) values("+num+","+money+",'取款','"+dateFormat.format(calendar.getTime())+"','"+work+"')";
		     psmt=conn.prepareStatement(sql2);	
		     psmt.executeUpdate();
				return true;
			}
			else
			{
				return false;
			}
   }
   public static boolean transferAccounts(int fromNum,String psw,int toNum,float money,String work) throws ClassNotFoundException, SQLException
   {
	   //转账
	   Connection conn=connection();
	   conn.setAutoCommit(false);//取消自动提交事务
	   String sql1="update t_user set balance=balance-"+money+" where accountnumber="+fromNum+" and password="+psw+"";
	   String sql2="update t_user set balance=balance+"+money+" where accountnumber="+toNum+"";
	   //将交易记录存入数据库
	   Calendar calendar= Calendar.getInstance();
	     SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
	   String sql3="insert into t_history(accountnumber,money,content,time,worker) values("+fromNum+","+money+",'转账給账号"+toNum+"','"+dateFormat.format(calendar.getTime())+"','"+work+"')";
	   String sql4="insert into t_history(accountnumber,money,content,time,worker) values("+toNum+","+money+",'收到转账来自账号"+fromNum+"','"+dateFormat.format(calendar.getTime())+"','"+work+"')";
	   PreparedStatement pstmt=conn.prepareStatement(sql1);
	   int result1=pstmt.executeUpdate();
	   pstmt=conn.prepareStatement(sql2);
	   int result2=pstmt.executeUpdate();
	   pstmt=conn.prepareStatement(sql3);	
	   pstmt.executeUpdate();
	   pstmt=conn.prepareStatement(sql4);	
	   pstmt.executeUpdate();
	   if(result1>0&&result2>0)
		{
			
			conn.commit();//提交事务
			return true;
		}
		else
		{
			conn.rollback();//回滚事务
			return false;
			
		}
   }
   public static boolean accountBalance(int num,float money) throws ClassNotFoundException, SQLException
   {//用来判断转账和取款时是否余额不足
	   Connection conn=connection();
	   String sql="select balance from t_user where accountnumber=?";
	   PreparedStatement psmt =conn.prepareStatement(sql);
	   psmt.setInt(1, num);
	   ResultSet rs = psmt.executeQuery();
	   if(rs.next()) 
	   {
		   float balance=rs.getFloat(1);
		   if(money>balance)
			   return false;
		   else	
			   return true; 
	   }
	return false;
   }
   public static int adminlogin(String num,String psw) throws ClassNotFoundException, SQLException {
	   Connection conn=connection();
	   String sql="select * from t_admin where name='"+num+"'";
	   PreparedStatement psmt=conn.prepareStatement(sql);
	   ResultSet rs = psmt.executeQuery();
	   if(rs.next()) 
	   {
		   String[] str =new String[2];
			str[0]=rs.getString(1);//记录用户名
			str[1]=rs.getString(2);//记录密码
			if(str[1].equals(psw)) {
				if(str[0].equals("admin1"))
					return 1;
				if(str[0].equals("admin2"))
					return 2;
				if(str[0].equals("admin3"))
					return 3;
			}else
				return 0;
//		   String pwd=rs.getString(1);
//		   if(pwd.equals(psw))
//			   return true;
//		   else	
//			   return false; 
	   }
	return 0;
   }
   public static JTable readLogin() throws ClassNotFoundException, SQLException {
	   Connection conn=connection();
	   DefaultTableModel model=new DefaultTableModel();
	   model.setColumnIdentifiers(new Object[]{"hid","accountnumber","money","content","time","worker"});
	   String sql="select * from t_history";
	   PreparedStatement psmt=conn.prepareStatement(sql);
	   ResultSet rs = psmt.executeQuery();
	   while(rs.next()) 
	   {
			int hid=rs.getInt(1);
			int num=rs.getInt(2);
			float money=rs.getFloat(3);
			String content=rs.getString(4);
			String time=rs.getString(5);
			String work=rs.getString(6);
			model.addRow(new Object[]{hid,num,money,content,time,work});
	   }
	   JTable table=new JTable(model);
	   return table;
   }
   public static JTable readLoginBynum(int cusnum) throws ClassNotFoundException, SQLException {
	   Connection conn=connection();
	   DefaultTableModel model=new DefaultTableModel();
	   model.setColumnIdentifiers(new Object[]{"hid","accountnumber","money","content","time","work"});
	   String sql="select * from t_history";
	   PreparedStatement psmt=conn.prepareStatement(sql);
	   ResultSet rs = psmt.executeQuery();
	   while(rs.next()) 
	   {
			int hid=rs.getInt(1);
			int num=rs.getInt(2);
			float money=rs.getFloat(3);
			String content=rs.getString(4);
			String time=rs.getString(5);
			String work=rs.getString(6);
			if(cusnum==num)
			model.addRow(new Object[]{hid,num,money,content,time,work});
	   }
	   JTable table=new JTable(model);
	   return table;
   }
   public static JTable readBalance() throws ClassNotFoundException, SQLException {
	   Connection conn=connection();
	   DefaultTableModel model=new DefaultTableModel();
	   model.setColumnIdentifiers(new Object[]{"accountnumber","username","balance"});
	   String sql="select * from t_user";
	   PreparedStatement psmt=conn.prepareStatement(sql);
	   ResultSet rs = psmt.executeQuery();
	   while(rs.next()) 
	   {
			int num=rs.getInt(1);
			float money=rs.getFloat(4);
			String name=rs.getString(2);
			model.addRow(new Object[]{num,name,money});
	   }
	   JTable table=new JTable(model);
	   return table;
   }
   public static JTable readPasswd() throws ClassNotFoundException, SQLException {
	   Connection conn=connection();
	   DefaultTableModel model=new DefaultTableModel();
	   model.setColumnIdentifiers(new Object[]{"accountnumber","username","password"});
	   String sql="select * from t_user";
	   PreparedStatement psmt=conn.prepareStatement(sql);
	   ResultSet rs = psmt.executeQuery();
	   while(rs.next()) 
	   {
			int num=rs.getInt(1);
			String pass=rs.getString(3);
			String name=rs.getString(2);
			model.addRow(new Object[]{num,name,pass});
	   }
	   JTable table=new JTable(model);
	   return table;
   }
   public static int Workerlogin(String num,String psw) throws ClassNotFoundException, SQLException {
	   Connection conn=connection();
	   String sql="select * from t_worker where WorkerName='"+num+"'";
	   PreparedStatement psmt=conn.prepareStatement(sql);
	   ResultSet rs = psmt.executeQuery();
	   if(rs.next()) 
	   {
		   String[] str =new String[2];
			str[0]=rs.getString(1);//记录用户名
			str[1]=rs.getString(2);//记录密码
			if(str[1].equals(psw)) {
				return 1;
			}else
				return 0;
	   }
	return 0;
   }
}
