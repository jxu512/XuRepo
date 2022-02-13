package demos.java8;

public class lambdaExpression 
{
	public void useLambdaExpression()
	{
		Interface1 i1 = (s) -> 
		{
			System.out.println(s);
		} ;
		i1.method1("abc...");
		
		Interface1 i2 = (s) -> System.out.println(s);
		i2.method1("xya...");
	}
	
	public static void main(String[] args)
	{
		new lambdaExpression().useLambdaExpression();
	}
}
