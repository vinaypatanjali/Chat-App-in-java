import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import javax.imageio.*;



class LoginP
{
	JFrame jfrm;
	JTextField jtf;
	JButton jb;
	ArrayList<String> aname;
	static String clientname;
	
	LoginP()
	{
		jfrm=new JFrame("Login");
	
		jfrm.setLayout(new BorderLayout());
jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jfrm.setSize(400,400);
jfrm.setLocationRelativeTo(null);


jtf=new JTextField(40);
jb=new JButton("Login");

jb.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
		clientname=jtf.getText();
		
		
	ServerP.jli.setModel(ServerP.l1);
		
		//Server.jli.setListData(Server.strArray);
		try{
		ClientP c=new ClientP();
		c.start();
		jfrm.dispose();
			}catch(Exception e){System.out.println(e+"");
			e.printStackTrace();}
	}
});

jfrm.add(jtf,BorderLayout.CENTER);
jfrm.add(jb,BorderLayout.SOUTH);


jfrm.setVisible(true);

	}
public static void main(String args[]) throws IOException
{
	new LoginP();
}
}