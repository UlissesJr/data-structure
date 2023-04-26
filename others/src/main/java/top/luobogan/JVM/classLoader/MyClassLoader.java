package top.luobogan.JVM.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by LuoboGan
 * Date:2023-03-31
 */
public class MyClassLoader extends ClassLoader{

    private String myName = "";

    public MyClassLoader(String myName){
        this.myName = myName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }

    private byte[] loadClassData(String clsName){
        byte[] data = null;
        InputStream in = null;

        clsName = clsName.replace(".","/");

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            in = new FileInputStream(new File("classes/" + clsName + ".class"));

            int a  = 0;
            while((a = in.read()) != -1) {
                out.write(a);
            }

            data = out.toByteArray();
        }catch (Exception err){
            err.printStackTrace();
        }

        return data;
    }
}
