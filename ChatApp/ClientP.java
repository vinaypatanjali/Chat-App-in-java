import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import javax.imageio.*;


	//indexOfTab(String title)
//Returns the first tab index with a given title, or -1 if no tab has this title.

class ClientP extends Thread
{
	
JFrame jfrm;
JTabbedPane jtb;
JTextArea jta;
//JTextArea jta[]=new JTextArea[20];
ArrayList<JTextArea> ajta=new ArrayList<JTextArea>();
JPanel p[]=new JPanel[20];

static int i=0,tabCount=0;


	static Socket s;
	JButton jb,jb1,clients,pchat,add,Add1,remove;
	//JTextArea jta;
	JTextField jtf,jtf1,jtf2,jtf3,jtext;
	JPanel jp1,jp2,jp3;
	JList<String> jli;
	JLabel jl,jl1,jl2,jl3,n,label;
	JInternalFrame jif;
	//Socket s;
	static DefaultListModel<String> l1; 
	String data;
	String clientname;
	JScrollPane sp1,sp2;
	int j=0,cp=0;

ClientP()
{
	WindowUtilities.setNativeLookAndFeel();
	jfrm=new JFrame("vChat");
	
		jfrm.setLayout(new BorderLayout());
jfrm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
jfrm.setSize(550,500);
jfrm.setLocationRelativeTo(null);

jtb=new JTabbedPane(2);
//jtb1=new JTabbedPane(2);

add=new JButton("ADD");

//p[i]=new JPanel(new FlowLayout());

//jta[i]=new JTextArea("Hello");

//p[i].add(jta[i]);
//jtb.addTab("First",p[i]);
//i++;



//jta[i][i]=new JTextArea("Hello1111");
//p[i]=new JPanel(new FlowLayout());
//p[i].add(jta[i]);
//jtb.addTab("Second",p[i]);
//i++;






clientname=LoginP.clientname;
jta =new JTextArea(40,40);
jta.setEditable(false);
ajta.add(jta);
l1 = new DefaultListModel<String>(); 

jli=new JList<String>(l1);

//l1.addElement("ssss");

jl1=new JLabel("Client list");
jl1.setBounds(350,20,100,20);

jl=new JLabel(clientname+":");
jl.setBounds(50,400,100,20);


jb=new JButton("Send");
ImageIcon ii =new ImageIcon(new ImageIcon("C:/Users/pvina/Documents/Java Programs/ChatApp/sendicon.PNG").getImage().getScaledInstance(70,10,Image.SCALE_DEFAULT));
jb.setIcon(ii);
jb.setBounds(100,400,70,20);

remove=new JButton("Remove");
//remove.setBounds(100,400,70,20);

jb1=new JButton("Close");
jb1.setBounds(200,400,70,20);

clients=new JButton("Clients");
clients.setBounds(300,400,70,20);

pchat=new JButton("Private chat");
pchat.setBounds(400,400,130,20);

jtf=new JTextField("Enter text to send",10);
jtf.setBounds(50,20,200,20);

jtf1=new JTextField("clients: ",10);

jl2=new JLabel("Private Chat: "); 
jl2.setBounds(240,300,100,20);
jl3=new JLabel("Private Chat Client name "); 
jl3.setBounds(240,350,150,20);
jtf2=new JTextField("",20);
jtf2.setBounds(400,350,70,20);

jtf3=new JTextField("",20);
jtf3.setBounds(400,300,70,20);

sp2=new JScrollPane(jli);
sp2.setBounds(350,80,100,180);

sp1 = new JScrollPane(jta);
sp1.setBounds(50,80,300,200);

//scrollPane.setViewportView(ServerP.jlentation(JList.VERTICAL);

//ServerP.jli.setLayoutOri
p[i]=new JPanel();
//jp2=new JPanel();
//jp3=new JPanel();

//jfrm.add(jta[i]);
p[i].add(sp1);
//p[i].add(sp2);

//p[i].add(jl);
//p[i].add(jl2);
//p[i].add(jl3);

//p[i].add(jtf1);
//p[i].add(jtf2);
//p[i].add(jtf3);

//UIManager.put("ToolTip.background", Color.WHITE);
//UIManager.put("ToolTip.border", new BorderUIResource(new LineBorder(Color.BLACK)));
//jtb.updateUI();
jtb.addTab(/*<html><body bgcolor=yellow face=green>*/"Public"/*</body></html>"*/,p[i]);
i++;


tabCount=jtb.getTabCount();

//jtb.setBackgroundAt(jtb.getSelectedIndex(),Color.YELLOW);

add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
		createJInternalFrame();		
		//new JInternalFrameTest();
		Add1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("in add");
		p[i]=new JPanel();	
		jta=new JTextArea(10,10);
		jta.setEditable(false);
		ajta.add(jta);
		p[i].add(jta);
		jtb.addTab(jtext.getText(),p[i]);
		i++;
		jif.dispose();
		}
		}
		);
	
			}
		});
		
		
		jb1.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
	DataOutputStream dos;
	
	

	try{
				dos=new DataOutputStream(s.getOutputStream());	
				
				dos.writeUTF("stop");
				cp=1;
			dos.flush();
			System.exit(0);
			}catch(Exception e){
				System.out.println(e);
			}
	
	
	}
});


remove.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
	
	createJInternalFrame();
	
	Add1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("in add");
		//p[i]=new JPanel();	
		//jtb.indexOfTab("Public")
		String removeClient=jtext.getText();
		ajta.remove(jtb.indexOfTab(removeClient));
		//p[i].remove(jta);
		
		jtb.remove(jtb.indexOfTab(removeClient));
		//jtb.addTab(jtext.getText(),p[i]);
		//i++;
		jif.dispose();
		}
		}
		);
	
	}
});
		
	jp1=new JPanel(new BorderLayout());
	jp1.add(jl1,BorderLayout.NORTH);	
	jp1.add(sp2,BorderLayout.CENTER);
	
	
jfrm.add(jtb,BorderLayout.CENTER);

jfrm.add(jp1,BorderLayout.EAST);


	jp2=new JPanel(new FlowLayout());
	
	jp2.add(add);
	
	jp2.add(remove);
	jp2.add(jb1);
	
	//jp2.add(clients);
	//jp2.add(pchat);
	
	jp3=new JPanel();
	jp3.add(jl);
	jp3.add(jtf);
	jp3.add(jb);
	try{
		
		
	s=new Socket("localhost",7777);
	
	//ServerP.l1.removeAllElements();
	/*try{
FileInputStream fin=new FileInputStream("Clients.txt");
DataInputStream din=new DataInputStream(fin);
String s="";
while(!s.equals(null))
{
	s=din.readLine();
	ServerP.l1.addElement(s);
}	

	}catch(Exception e){e.printStackTrace();}*/		
	//l1.addElement(clientname);
	MyThread2 t=new MyThread2(s,clientname,data,jtf,jb,jfrm,jp2,jtf3,cp,jtb);
	t.start();
	
	ThreadList tl=new ThreadList();
	tl.start();
	
	}catch(Exception e){}	


jfrm.add(jp2,BorderLayout.SOUTH);
jfrm.add(jp3,BorderLayout.NORTH);
jfrm.setVisible(true);
	
}	

public void createJInternalFrame()
{
	jif=new JInternalFrame("ADD",true,true,true,true);
				jif.setLayout(new FlowLayout());
				jif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				label=new JLabel("Enter Client Name: ");
				jtext=new JTextField("",20);
				Add1=new JButton("OK");
				
				
				
				jif.add(label);
				jif.add(jtext);
				jif.add(Add1);
				/*try{
				jif.setSelected(true);
				}catch(Exception e)
				{
					System.out.println(e);
				}*/
				//jif.addInternaFrameListener(this);
				
				jif.setVisible(true);
				
				jfrm.add(jif,BorderLayout.WEST);
}


public void run()
{
	//ClientList.add(clientname);
	//jfrm.repaint();
//new Client();
try{
DataInputStream din=new DataInputStream(s.getInputStream());
	do
	{
		//addList(Server.name);
		//addList();
	data=din.readUTF();
	System.out.println(data);
	
	if(data.contains("private"))
	{ArrayList<String> astr=new ArrayList<String>();
		try{
			FileInputStream fin=new FileInputStream("Clients.txt");
BufferedReader bdin=new BufferedReader(new InputStreamReader(fin));

String string="";
while(string!=null)
{
	
	if(string.equals(null))
		break;
	
	
	string=bdin.readLine();
	astr.add(string);
	
	
}	


		}catch(Exception e)
		{
		e.printStackTrace();	
		}
		System.out.println("in private data contains");
		
String[] strArray = astr.toArray(new String[astr.size()]);
 //int tabCount=jtb.getTabCount();
 //System.out.println(tabCount);
 //System.out.println(jtb.getTitleAt(tabCount--));
 for(int i=0;i<astr.size();i++)
 {
	//System.out.println(jtb.getTitleAt(tabCount));
	 if(data.contains(strArray[i]))
	 {
		 System.out.println("in private data contains1111111");
		  int index=jtb.indexOfTab(strArray[i]);
		 String text=ajta.get(index).getText();
		ajta.get(index).setText(text+"\n"+data);	
		 break;
	 }
	 
	 
	 
 }
 astr.clear();
	}
	else
	{
		System.out.println("else of   in pta contains");
	String text=ajta.get(jtb.indexOfTab("Public")).getText();
	ajta.get(jtb.indexOfTab("Public")).setText(text+"\n"+data);	
	}
	}while(!data.equals(clientname+": "+"stop"));	
}catch(Exception e){};
}
	
public static void main(String args[])
{
new ClientP();	
}
}

class MyThread2 extends Thread
{
	Socket s;
	DataInputStream din;
	DataOutputStream dos;
	String datas,datas1;
	BufferedReader br;
	String clientname;
	JTextField jtf,jtf3;
	JButton jb;
	static int i=0,cp;
	JFrame jfrm;	
	JPanel jp2;
	JTabbedPane jtb;
	
	
MyThread2(Socket s,String clientname,String data,JTextField jtf,JButton jb,JFrame jfrm,JPanel jp2,JTextField jtf3,int cp,JTabbedPane jtb)
	{
		
		
		this.clientname=clientname;
		this.s=s;
		this.datas=data;
		this.jtf=jtf;
		this.jtf3=jtf3;
		this.jb=jb;
		this.jfrm=jfrm;
		this.jp2=jp2;
		MyThread2.cp=cp;
		this.jtb=jtb;
	}
	
	public void run()
	{
		try{
		din=new DataInputStream(s.getInputStream());
		dos=new DataOutputStream(s.getOutputStream());
		br=new BufferedReader(new InputStreamReader(System.in));
		
		do{
			
			if(i==0)
			{
			
			
			dos.writeUTF(clientname);
			i=1;
			
			}
			jb.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent ae)
			{
				try{
					
	String pdata="";
	String d="";
	
if(!jtb.getTitleAt(jtb.getSelectedIndex()).equalsIgnoreCase("public")){
	System.out.println("in public ");
				d=clientname+";"+jtb.getTitleAt(jtb.getSelectedIndex())+": "+jtf.getText();
				dos.writeUTF(d+"private");
				//cp=1;
			dos.flush();
			
			
}
else
{
			System.out.println("in private ");		
					datas=jtf.getText();
				dos.writeUTF(clientname+": "+datas);	
			dos.flush();
}
			}catch(Exception e){
				System.out.println(e);
			}
			}
			});

			
	
		}while(!Stringfind.find(datas,"stop"));
		}catch(Exception e)
		{}
	}
}


class ThreadList extends Thread
{ 
int x=0,y=0;

	public void run()
	{
		while(true)
		{
		try{
			FileInputStream fin=new FileInputStream("Clients.txt");
BufferedReader din=new BufferedReader(new InputStreamReader(fin));
String s="";
//x=0;
while(s!=null)
{
	
	if(s.equals(null))
		break;
	
	
	s=din.readLine();
	//if(x==y)
	//{
	ClientP.l1.addElement(s);
	//y++;
	//break;
	//}
	//x++;
}	
Thread.sleep(1000);
ClientP.l1.removeAllElements();
		}catch(Exception e)
		{
		e.printStackTrace();	
		}
		}
	}
}