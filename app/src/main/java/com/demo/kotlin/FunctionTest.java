package com.demo.kotlin;

import com.demo.kotlin.util.Const;
import com.demo.kotlin.util.HttpUtils;

public class FunctionTest {
    public static void main(String[] args){
        //访问静态常量
        String url = Const.URL;
        Const.Companion.getKey();
        //java 和 kotlin混合开发 通过Companion调用静态方法
        String param = Const.Companion.getParam();
        //companion 中的属性(方法)可以用jvmStatic注解即可类名.属性(方法)直接访问
        String result = Const.result;
        String host = Const.getHost();
        //声明了companion对象名字则不需要通过Companion来访问方法
        HttpUtils.Server.getTest_address();
        HttpUtils.getHost();
        String apiKey = GlobalStaticKt.API_KEY;
        //java类中调用kotlin companion object方法需要通过Companion对象来间接调用
//        GlobalStaticKt.goToPage(MyApplication.Companion.getInstance(),DataBindingActivity.class,null);
        Const.InnerStaticClass.INSTANCE.test();
        new Const();
        new Const.InnerClass();
        Const.Companion.getHost();
        String name = new ConstructorModel("Jack", 23).getName();
        ConstructorModel constructorModel = new ConstructorModel("", 23, 1);
        System.out.println(constructorModel.getAge());



    }

    /**
     * 位运算实现交换(按位异或) a^b = b^a,不需要引入第三个是数
     * 运算规则：0^0=0；  0^1=1；  1^0=1；   1^1=0；
     * 异或运算的逆运算是它本身，也就是说两次异或同一个数最后结果不变 a^b^b= a;
     */
    public void exchange(){
        int a = 3, b = 5;
        System.out.println("a^b=" + (a^b) + ",b^a = " + (b^a));
        a ^= b;//a = a^b
        b ^= a;//b = b^a = b^(a^b) = a = 3;
        a ^= b;//a = a^b = (a^b)^(b^(a^b)) = b = 5
        System.out.println("交换后：a = " + a + ",b = " + b);
    }

}
