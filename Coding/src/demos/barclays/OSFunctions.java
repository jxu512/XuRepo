/*
 Assume the native functions can only be executed from main thread
 Write library function to server the functions for call from any threads / clients
 
*/
package demos.barclays;

class OSFunctions {
	//public static native String getOSValue (int a);
	//public static native void setOSValue (int c, String d);
	public static String getOSValue (int a) { return String.valueOf(a); }
	public static void setOSValue (int c, String d) {};
}