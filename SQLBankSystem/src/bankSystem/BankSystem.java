package bankSystem;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class BankSystem {
//	public static int i=0;
	public static Connection connection() throws SQLException, ClassNotFoundException{
		//1.��������
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.�õ�����
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","jmq.990467");
	      return conn;
	}
   public static int openAccount(String name,String pwd,String pwd1,float money,String work) throws ClassNotFoundException, SQLException{
	   Connection conn=connection();
	   //��֤��������������Ƿ���ͬ
	   if(pwd.equals(pwd1))
	   {
		 //�������û�
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
	    //�������û����䵽���˺�
	    	  Statement sm =conn.createStatement();
	    	  ResultSet rs1=sm.executeQuery("select accountnumber from t_user where username='"+name+"'");
	    	  while(rs1.next())
	    	  {
				int str =rs1.getInt(1);
				String sql2="insert into t_history(accountnumber,money,content,time,worker) values("+str+","+money+",'����',?,'"+work+"')";
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
	   //��ѯ�˻���Ϣ
	   Connection conn=connection();
	   String sql="select * from t_user where accountnumber='"+num+"' and password='"+psw+"'";
	   PreparedStatement psmt=conn.prepareStatement(sql);
	   ResultSet rs=psmt.executeQuery();
	   if(rs.next())
		{
		String[] str =new String[3];
			str[0]=rs.getString(1);//��¼�˺�
			str[1]=rs.getString(2);//��¼�û���
			str[2]=rs.getString(4);//��¼���
			return str;
			}
	return null;
   }
   public static Boolean deposite(int num,String psw,Float money,String work) throws ClassNotFoundException, SQLException{
	   Connection conn=connection();
	   	//���
	   String sql1="update t_user set balance=balance+? where accountnumber=? and password=?";
	      PreparedStatement psmt=conn.prepareStatement(sql1);
	      psmt.setFloat(1, money);
	      psmt.setInt(2, num);
	      psmt.setString(3, psw);
	      int rs1=psmt.executeUpdate();
//	     //ͬʱ�����׼�¼�������ݿ�
//	      Calendar calendar= Calendar.getInstance();
//		     SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//	     String sql2="insert into t_history(accountnumber,money,content,time) values("+num+","+money+",'���','"+dateFormat.format(calendar.getTime())+"')";
//	      psmt=conn.prepareStatement(sql2);	
//	      psmt.executeUpdate();
	      if(rs1>0)
			{
	    	  //ͬʱ�����׼�¼�������ݿ�
		      Calendar calendar= Calendar.getInstance();
			     SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		     String sql2="insert into t_history(accountnumber,money,content,time,worker) values("+num+","+money+",'���','"+dateFormat.format(calendar.getTime())+"','"+work+"')";
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
	   //ȡ��
	   Connection conn=connection();
	   String sql1="update t_user set balance=balance-? where accountnumber=? and password=?";
	      PreparedStatement psmt=conn.prepareStatement(sql1);
	      psmt.setFloat(1, money);
	      psmt.setInt(2, num);
	      psmt.setString(3, psw);
	      int rs1=psmt.executeUpdate();
//	    //ͬʱ�����׼�¼�������ݿ�
//	      Calendar calendar= Calendar.getInstance();
//		     SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//	     String sql2="insert into t_history(accountnumber,money,content,time) values("+num+","+money+",'ȡ��','"+dateFormat.format(calendar.getTime())+"')";
//	     psmt=conn.prepareStatement(sql2);	
//	     psmt.executeUpdate();
	      if(rs1>0)
			{
	    	  //ͬʱ�����׼�¼�������ݿ�
		      Calendar calendar= Calendar.getInstance();
			     SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		     String sql2="insert into t_history(accountnumber,money,content,time,worker) values("+num+","+money+",'ȡ��','"+dateFormat.format(calendar.getTime())+"','"+work+"')";
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
	   //ת��
	   Connection conn=connection();
	   conn.setAutoCommit(false);//ȡ���Զ��ύ����
	   String sql1="update t_user set balance=balance-"+money+" where accountnumber="+fromNum+" and password="+psw+"";
	   String sql2="update t_user set balance=balance+"+money+" where accountnumber="+toNum+"";
	   //�����׼�¼�������ݿ�
	   Calendar calendar= Calendar.getInstance();
	     SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
	   String sql3="insert into t_history(accountnumber,money,content,time,worker) values("+fromNum+","+money+",'ת�˽o�˺�"+toNum+"','"+dateFormat.format(calendar.getTime())+"','"+work+"')";
	   String sql4="insert into t_history(accountnumber,money,content,time,worker) values("+toNum+","+money+",'�յ�ת�������˺�"+fromNum+"','"+dateFormat.format(calendar.getTime())+"','"+work+"')";
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
			
			conn.commit();//�ύ����
			return true;
		}
		else
		{
			conn.rollback();//�ع�����
			return false;
			
		}
   }
   public static boolean accountBalance(int num,float money) throws ClassNotFoundException, SQLException
   {//�����ж�ת�˺�ȡ��ʱ�Ƿ�����
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
			str[0]=rs.getString(1);//��¼�û���
			str[1]=rs.getString(2);//��¼����
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
			str[0]=rs.getString(1);//��¼�û���
			str[1]=rs.getString(2);//��¼����
			if(str[1].equals(psw)) {
				return 1;
			}else
				return 0;
	   }
	return 0;
   }
}
