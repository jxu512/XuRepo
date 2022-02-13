package demos.java8;

public class interfaceStaticMethod 
{
	public void log(String str)
	{
		System.out.println("Caling static method from interface without implementing the interface");
		Interface1.print(str);
	}
	
	public static void main(String[] args)
	{
		new interfaceStaticMethod().log("ABC...");
	}
}