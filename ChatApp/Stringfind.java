import java.util.Scanner;



public class Stringfind
{
	
	public static boolean find(String s,String s1)
	{
		int x=0;
		Stringwordcount wc=new Stringwordcount();
		int number=wc.wordcount(s);
		
		String words[]=new String[number]; 
		s=s+" ";
		int start=0;
				int current=0;
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch==' ')
			{
				
				String word=s.substring(start,i);
				words[current]=word;
				start=i+1;
				current++;
			}
		}
		
	
		
		for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length ; j++) {
              if(words[i].equals(s1))
			  {
				  x++;
			  }
            }
        }
		
		 if(x>0)
			 return true;
		 else
			 return false;
		

	}
	
/*public static void main(String args[])
{
	
Scanner sc=new Scanner(System.in);
System.out.println("Enter a string1.");	
String s1=sc.nextLine();
System.out.println("Entered string1 is: "+ s1);
System.out.println("Enter a string2.");	
String s2=sc.nextLine();
System.out.println("Entered string1 is: "+ s2);



System.out.println("Entered string2 is in string1: "+ find(s1,s2));

}*/
}