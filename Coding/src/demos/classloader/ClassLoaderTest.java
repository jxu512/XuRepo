/*
there are three different class loaders here: application, extension, and bootstrap (displayed as null).

The application class loader loads the class where the example method is contained.
An application or system class loader loads our own files in the classpath.

Next, the extension class loader loads the DriverManager class. Extension class loaders
load classes that are an extension of the standard core Java classes.

Finally, the bootstrap class loader loads the ArrayList class. A bootstrap or primordial
class loader is the parent of all the others.

However, we can see that for the ArrayList, it displays null in the output. This is because
the bootstrap class loader is written in native code, not Java, so it doesn’t show up as a
Java class. As a result, the behavior of the bootstrap class loader will differ across JVMs.

 */

package demos.classloader;

import java.sql.DriverManager;
import java.util.ArrayList;

public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        classLoaderTest.printClassLoaders();
    }
    public void printClassLoaders() throws ClassNotFoundException {
        System.out.println("Classloader of this class:"
                + ClassLoaderTest.class.getClassLoader());

        System.out.println("Classloader of DriverManager:"
                + DriverManager.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }
}
