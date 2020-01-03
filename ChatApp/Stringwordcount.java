import java.util.Scanner;

public class Stringwordcount
{
	
	public int wordcount(String s)
	{
		int c=1;
		
		
		if(s.length()==0)
			c=0;
		else{
		for(int i=0;i<s.length();i++)
		{

			if(i>0){
			if(s.charAt(i-1)!=' ')
			{
			if(s.charAt(i)==' ')
			c++;
			}
			}
		}
		}
		
		return c;
	}
	
public static void main(String args[])
{
	Stringwordcount sw= new Stringwordcount();
Scanner sc=new Scanner(System.in);
System.out.println("Enter a string.");	
String s1=sc.nextLine();
System.out.println("Entered string is: "+ s1);
String s2= s1.trim();

System.out.println("Number of words in the String you entered is: "+ sw.wordcount(s2));
}
}