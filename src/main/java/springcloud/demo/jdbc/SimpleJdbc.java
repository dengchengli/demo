package springcloud.demo.jdbc;

import springcloud.demo.rpc.serializable.Student;

import java.sql.*;

/**
 * @Author: Dely
 * @Date: 2019/12/4 12:08
 */

public class SimpleJdbc {

    private final static String url = "springcloud.demo.jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private final static String user = "root";
    private final static String ps = "123456";

    public static void main(String[] args) {
        try {
            /**
             * 加载数据库驱动
             */
            Class.forName("com.mysql.jdbc.Driver");
            //DriverManager类检查所加载的驱动是否可以建立连接，并返回连接对象。
            Connection connection = DriverManager.getConnection(url, user, ps);
            //Statement对象用来执行静态sql语句并返回执行结果。
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("insert into student(name) values('kkk')");
            System.out.println(i);
            //通过statement对象调用方法执行sql语句并返回结果
            ResultSet resultSet = statement.executeQuery("select * from  student ");
            //ResultSet刚开始指向第一行的前面


            while (resultSet.next()) {
                Object obj = getObject(resultSet);
                System.out.println(obj);
            }

            /**
             * 关闭数据库连接
             */
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Student getObject(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt(1));
        student.setName(resultSet.getString(2));
        return student;
    }
}
