import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.Frame;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import javax.imageio.*;

public class ServerP
{
ServerSocket ss;
Socket s;
static ArrayList<Socket> al;
static String Clientname;
static String[] strArray;
public static DefaultListModel<String> l1=new DefaultListModel<String>();
public static ArrayList<String> aname=new ArrayList<String>();
public static JList<String> name=new JList<String>();
public static JList<String> jli=new JList<>(l1);
//static JScrollBar jsb=new JScrollBar();
//jsb.setViewportView(jli);
static String pchat1=null;
static int x=0;


public ServerP()
{
	JScrollPane scrollPane = new JScrollPane();
scrollPane.setViewportView(jli);
jli.setLayoutOrientation(JList.VERTICAL);
	//jsb.getViewport.setView(jli);
	jli.setVisibleRowCount(6);
	try{
	ss=new ServerSocket(7777);
	al=new ArrayList<Socket>();
	aname=new ArrayList<String>();
	System.out.println(aname);
	
	while(true)
	{
	
		s=ss.accept();
		al.add(s);
		l1.addElement(Clientname);
		System.out.println("Client Connected");
		
				System.out.println(al+"\n\n");	
					
		
		MyThread1 t=new MyThread1(s,al,aname,l1,Clientname);
		t.start();
		
	}
	}catch(Exception e){}
	
	
	jli.addContainerListener(new ContainerListener()
{
	public void componentAdded(ContainerEvent ae)
	{
		jli.setVisibleRowCount(6);
		jli.setModel(l1);
	
	
	}
	
	public void componentRemoved(ContainerEvent ae)
	{
	
	
	
	}
});
}


	


	
public static void main(String args[]) throws IOException
{
new ServerP();	
}

}

class MyThread1 extends Thread
{
	Socket s;
	Socket s1,sprivate;
	ArrayList<Socket> al;
	DataInputStream din;
	DataOutputStream dos;
	String data;
	DefaultListModel<String> l1;
	static String Clientname;
	public static ArrayList<String> aname;
	static int i=0;
	static String[] strArray;
	
	MyThread1(Socket s,ArrayList<Socket> al,ArrayList<String> aname,DefaultListModel<String> l1,String Clientname)
	{
		
		this.s=s;
		this.al=al;
		MyThread1.aname=aname;
		this.l1=l1;
		MyThread1.Clientname=Clientname;
		MyThread1.strArray=ServerP.strArray;
	}
	
	public ArrayList<String> getList()
{
	return aname;
}

public void writeDataFile()
{
	try{
	FileOutputStream file=new FileOutputStream("Clients.txt");
				PrintStream ps=new PrintStream(file);
				
				strArray = aname.toArray(new String[aname.size()]);
				for(int n=0;n<strArray.length;n++)
				{
				System.out.println("strArray: "+strArray[n]);
				ps.println(strArray[n]);
				
				}
			ps.close();
	}catch(Exception e){System.out.println(e);}
}
	
	public void run()
	{
		try{
		
		
		do{
			
			din=new DataInputStream(s.getInputStream());
			
			if(i<al.size())
			{
				FileOutputStream file=new FileOutputStream("Clients.txt");
				PrintStream ps=new PrintStream(file);
				Clientname=din.readUTF();
				aname.add(Clientname);
				strArray = aname.toArray(new String[aname.size()]);
				for(int n=0;n<strArray.length;n++)
				{
				System.out.println("strArray: "+strArray[n]);
				ps.println(strArray[n]);
				
				}
			ps.close();
			i++;
			}
			
			System.out.println(aname);
			
			
				data=din.readUTF();
				System.out.println(data);
			Iterator<Socket> itr=al.iterator();
			if(data.contains("private"))
			{
				StringTokenizer st=new StringTokenizer(data,";");
				String sendClient=st.nextToken();
				//System.out.println("data: "+data);
				data=data.replace(sendClient+";","");
				System.out.println("data: "+data);
				//System.out.println("in private thread1");
				//PrivateThread pt=new PrivateThread(data.replace("private",""));
				//pt.start();
				System.out.println("in private");
	//clientnamep=clientname;
		String user;
//System.out.println(clientnamep);
int y=0;
String receiveClient="";
//System.out.println(ServerP.aname.get(1));
for(int x=0;x<aname.size();x++)
{System.out.println(aname.get(x));
	if(data.contains(aname.get(x)))
	{
		receiveClient=aname.get(x);
		System.out.println("index y: "+x);
		y=x;
	}
}

System.out.println("sendClient: "+sendClient);
System.out.println("receiveClient: "+receiveClient);
//int y=ServerP.aname.indexOf(data.replace("private",""));
System.out.println(y);
sprivate=al.get(y);
System.out.println(s);
dos=new DataOutputStream(sprivate.getOutputStream());
				data=data.replace(receiveClient,sendClient);
				dos.writeUTF("(private) "+data.replace("private",""));
				dos.flush();
				//ServerP.getPrivateChat(Clientname);
				
			}
			else if(!Stringfind.find(data,"stop"))
			{
			while(itr.hasNext())
			{
				
			
				s1= itr.next();
			
		dos=new DataOutputStream(s1.getOutputStream());
			
				dos.writeUTF(data);
				dos.flush();
			
			
			}
			}
			else
			{
				dos=new DataOutputStream(s.getOutputStream());
				dos.writeUTF(data);
				int w=al.indexOf(s);
				aname.remove(w);
				al.remove(s);
				i--;
				writeDataFile();
				System.out.println("in else");
				
			}
			
			
			
		}
		while(true);
		}catch(Exception e){}
	}
}

class PrivateThread extends Thread
{
	String clientnamep;
	Socket s;
	DataInputStream din;
	String data="";
	DataOutputStream dos;
	
	PrivateThread(String clientname)
	{
	System.out.println("in private");
	clientnamep=clientname;
		
System.out.println(clientnamep);
//System.out.println(ServerP.aname.get(1));
int y=ServerP.aname.indexOf(clientnamep);
System.out.println(y);
s=ServerP.al.get(y);
System.out.println(s);

	}
	
	public void run()
	{
		try{
		din=new DataInputStream(s.getInputStream());
		while(true){
		
		System.out.println("reached read");
		data=din.readUTF();
		System.out.println(data);
		if(data.contains("button"))
		{
		dos=new DataOutputStream(s.getOutputStream());	
		dos.writeUTF(data);
		dos.flush();
		}
		}
	}catch(Exception e){}
	}
}