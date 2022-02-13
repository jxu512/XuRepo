package demos.java8;

public class interfaceDefaultMethod1 implements Interface1
{
	public void loglocal(String str)
	{
		System.out.println("Caling default method from interface");
		log(str);
	}
	
	public static void main(String[] args)
	{
		interfaceDefaultMethod1 m = new interfaceDefaultMethod1();
		m.log("Calling default interface method");
		m.loglocal("Call local log");
	}

	@Override
	public void method1(String str)
	{
		
	}
}