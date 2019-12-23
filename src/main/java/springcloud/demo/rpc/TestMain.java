package springcloud.demo.rpc;

import springcloud.demo.rpc.serializable.*;

import java.io.IOException;

/**
 * @Author: Dely
 * @Date: 2019/11/27 14:45
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        Student res = null;
        Student student = new Student();
        student.setId(333);
        student.setName("dely");

        Serialization serialization;
        byte[] bytes;

        /**
         * Kryo实现
         */
        /*serialization = new KryoSerialization();
        bytes = serialization.serialize(student);
        res = serialization.deserialize(bytes,Student.class);
        System.out.println(res);*/

        /**
         * Hessian2 实现
         */
        serialization = new HessianSerialization();
        bytes = serialization.serialize(student);
        res = serialization.deserialize(bytes, Student.class);

        /**
         *jdk
         */
        serialization = new JdkSerialization();
        bytes = serialization.serialize(student);
        serialization.deserialize(bytes, Student.class);

        /**
         *fastJson
         */




        System.out.println(res);


    }


}
