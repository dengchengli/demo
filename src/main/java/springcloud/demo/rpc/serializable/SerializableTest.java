package springcloud.demo.rpc.serializable;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @Author: Dely
 * @Date: 2019/11/27 14:46
 */
public class SerializableTest {
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * Kryo
         */
        testKyro();

    }


    /**
     * Kyro序列化和反序列化的测试,需要序列化的类不继承Serializable接口也不抛异常
     */
    private static void testKyro() throws FileNotFoundException {
        Student student = new Student();
        student.setId(11);
        student.setName("dely");
        /**
         * 创建Kryo对象
         */
        Kryo kryo = new Kryo();
        /**
         * 创建输出对象
         */
        Output output = new Output(new FileOutputStream("student.db"));

        /**
         * 写到文件中
         */
        // kryo.writeObject(output, student); //对象不能为空，如果为空，IllegalArgumentException异常
        // kryo.writeObjectOrNull(output, student,Student.class);
         kryo.writeClassAndObject(output, student);


        /**
         * 关闭输出流文及其文件
         */
        output.close();

        /**
         * 创建输入流对象
         */
        Input input = new Input(new FileInputStream("student.db"));
        /**
         * 读取文件数据并反序列化
         */
        Student readObject = null;
        // readObject = kryo.readObject(input, Student.class); //如果文件内容为空，KryoException异常，  //该方法用在类字节码已知，对象不为空的情况
        //readObject = kryo.readObjectOrNull(input, Student.class);  //已知类的字节码的情况
         readObject = (Student) kryo.readClassAndObject(input);  //该方法用在类字节码未知的情况  //在序列化的时候把类的字节码信息也一并存储在文件中了。故而读取的时候就不需要知道字节码

        /**
         * 关闭文件
         */
        input.close();

        /**
         * 结果测试
         */

        Class<?>[] interfaces = readObject.getClass().getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println(interfaces[i]);
        }

        System.out.println(readObject.getId() + ":" + readObject.getName());
    }
}
