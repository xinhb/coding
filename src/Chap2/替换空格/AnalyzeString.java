package Chap2.替换空格;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
* 读String源码
*
*
* */
public class AnalyzeString {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        final int a = 10;
        /**
         * final 变量与 final类
         * */
        String str0 = new String("huang xin");
        str0 = str0+1; //类型转换？
        StringBuffer str1 = new StringBuffer();
        //当前字符长度
        System.out.println(str1.length());
        //容量
        System.out.println(str1.capacity());

        Connection cn = null; //数据库连接对象

        //强制JVM将org.postgresql.Driver这个类加载入内存，以便将其注册到DriverManager类上去。在Driver类加载时自动完成的
        Class.forName("com.mysql.jdbc.Driver");
        //利用JDBC提供的DriverManager（已经注册过Driver（某个数据库驱动对象））创建连接对象
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");


    }




}
