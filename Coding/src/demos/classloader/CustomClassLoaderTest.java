package demos.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoaderTest {

    public static void main(String[] args) throws Exception {
        CustomClassLoader classLoader = new CustomClassLoader();
        try {
            Class<?> dynamicClass = classLoader.loadClass("demos.classloader.ClassLoaderTest");
            ClassLoaderTest classLoaderTest = (ClassLoaderTest) dynamicClass.getConstructor().newInstance();
            classLoaderTest.printClassLoaders();
            System.out.println(classLoaderTest.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}

class CustomClassLoader extends ClassLoader {

    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassFromFile(String fileName)  {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                fileName.replace('.', File.separatorChar) + ".class");
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ( (nextValue = inputStream.read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }
}
