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

}
