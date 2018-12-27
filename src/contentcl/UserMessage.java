package contentcl;
import java.io.*;  
/**
 * �����¶��û���Ϣ�� д��Ͷ�ȡ����
 * @author contentcl
 * @Date 2017��12��28�� ����8:24:56
 *
 */
public class UserMessage
{
	/*
	 * ��ע�����Ϣд���ı�
	 */
	public void write(String[] message)throws IOException
	{
		File file=new File("Message.txt");
		String messagesum="";
		for (int i=0; i<5; i++)  //����Ϣ��ʽ���洢
			messagesum+=message[i]+"~";
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file,true); //�����������true��ʾ׷��       
        StringBuffer sb=new StringBuffer();      //�����ַ�����
        sb.append(messagesum+"\n");				//���ַ������������Ϣ
         out.write(sb.toString().getBytes("gb2312"));         //���ַ������е���Ϣд���ı�
        out.close();			//�ر�
	}
    /*
     *   ��ȡ��Ϣ�����û�����Ϣ���أ���������ڷ���null������Check�����ʹ��  
     */
	public String[] read(String countname) throws IOException
	{
        File file=new File("Message.txt");
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();
        temp=br.readLine();
        
        String []message = new String[5];     //��~��� ��5���ַ������飬���˺ź����������Ϣ��֤
        while(temp!=null){
        	String sbstring = temp.toString();
        	int n = sbstring.length();            //���ַ�������
        	for (int i=0; i<5; i++)
        		message[i] = "";
        	
        	int k=0;
        	for (int i=0; i<n; i++)
        	{
        		if(sbstring.charAt(i)=='~')
        		{
        			//System.out.println("@"+message[k]);
        			k++;
        		}
        		else 
        		{
        			message[k] += sbstring.charAt(i);
        		}
        	}
        	if (message[2].equals(countname))  //�����ҵ��û�����Ϣ
        	{
        		return message;
        	}
            temp=br.readLine();
        }
        return null;
	}
	 
	/*�ڴ��ȡ����� ʱ ���½��
	 * 
	 */
	public String updatemoney(String countname,int wangsave) throws IOException
	{
        File file=new File("Message.txt");
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException(); 
        //���ļ�  
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();  //�����ַ�����
        StringBuffer sb1=new StringBuffer();
        
        String moneystring="";
        
        temp=br.readLine();
        String []message = new String[5];     //��~��� ��5���ַ������飬���˺ź����������Ϣ��֤
        while(temp!=null){
        	String sbstring = temp.toString();
        	int n = sbstring.length();            //���ַ�������
        	for (int i=0; i<5; i++)
        		message[i] = "";
        	
        	int k=0;
        	for (int i=0; i<n; i++)      //���5��String
        	{
        		if(sbstring.charAt(i)=='~')
        		{
        			//System.out.println("@"+message[k]);
        			k++;
        		}
        		else 
        		{
        			message[k] += sbstring.charAt(i);
        		}
        	}
        	
        	if (message[2].equals(countname))   //�ҵ����˻���
        	{
        		String newmessage="";
        		int moneyint;
        		moneyint=Integer.parseInt(message[4])+wangsave;  //���תΪint����
        								//ԭ���                                   //������
        		
        		if (moneyint<0)
        		{
        			return "����";
        		}
        		moneystring  = String.valueOf(moneyint);	//��Stringתint
        		for (int i=0; i<4; i++)				//ת��Ϊ�涨��ʽ�ļ� 
        			newmessage += message[i]+"~";
        		newmessage += moneystring+"~";
        		sb1.append(newmessage+"\n");
        	}
        	else
        	{
        		sb1.append(temp+"\n");
        	}
        	temp=br.readLine();
        }
        /*
         * ˵����
         * �������뷨����ԭ�ļ������и������ݣ����Ƿ��ָ��Ǻ��ı�Ϊ�գ� �޷����
         * �����´����ļ������������ɲ���
         */
        File file1=new File("Message.txt");   //���½����ļ����� ����д���ı�
        if(!file1.exists())
           file1.createNewFile();
        FileOutputStream out=new FileOutputStream(file1,false);  //falseΪ��д����
        out.write(sb1.toString().getBytes("gb2312"));
        out.close();
        
		return moneystring;
	}
	
	
	//
	//��������
	public String updatepwd(String countname,String pwd) throws IOException
	{
        File file=new File("Message.txt");
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException(); 
        //���ļ�  
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();
        //д�ļ�
        //FileOutputStream out=new FileOutputStream(file,false);        
        StringBuffer sb1=new StringBuffer();
        
        String moneystring="";
        
        temp=br.readLine();
        String []message = new String[5];     //��~��� ��5���ַ������飬���˺ź����������Ϣ��֤
        while(temp!=null){
        	String sbstring = temp.toString();
        	int n = sbstring.length();            //���ַ�������
        	for (int i=0; i<5; i++)
        		message[i] = "";
        	
        	int k=0;
        	for (int i=0; i<n; i++)      //���5��String
        	{
        		if(sbstring.charAt(i)=='~')
        		{
        			//System.out.println("@"+message[k]);
        			k++;
        		}
        		else 
        		{
        			message[k] += sbstring.charAt(i);
        		}
        	}
        	
        	if (message[2].equals(countname))   //�ҵ����˻���
        	{
        		//�޸�����
        		for (int i=0; i<3; i++)
        			sb1.append(message[i]+"~");
        		sb1.append(pwd+"~");
        		sb1.append(message[4]+"~\n");
        	}
        	else
        	{
        		sb1.append(temp+"\n");
        	}
        	temp=br.readLine();
        }
        /*
         * ˵����
         * �������뷨����ԭ�ļ������и������ݣ����Ƿ��ָ��Ǻ��ı�Ϊ�գ� �޷����
         * �����´����ļ������������ɲ���
         */
        File file1=new File("Message.txt");
        if(!file1.exists())
           file1.createNewFile();
        FileOutputStream out=new FileOutputStream(file1,false);
        out.write(sb1.toString().getBytes("gb2312"));
        out.close();
        
		return moneystring;
	}
	
	
	
	

}
