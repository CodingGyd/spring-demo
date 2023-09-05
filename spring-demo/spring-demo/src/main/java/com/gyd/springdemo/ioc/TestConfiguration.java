package com.gyd.springdemo.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestConfiguration
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/17 15:30
 * @Version 1.0
 */
public class TestConfiguration {
    public static void main(String[] args) {
        //方式1  结合@Configuration注解类使用
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //方式2  直接注入指定bean类
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentInfo.class,ClassesInfo.class);
        //方式3 通过使用 register(Class<?>…​) 以编程方式构建容器。
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(StudentInfo.class,ClassesInfo.class);
        applicationContext.refresh();

        //方式4 用 scan(String…) 启用组件扫描。
//        @Configuration
//        @ComponentScan(basePackages = "com.acme")
//        public class AppConfig  {
//            // ...
//        }

        StudentInfo studentInfo = applicationContext.getBean(StudentInfo.class);
        ClassesInfo classesInfo = applicationContext.getBean(ClassesInfo.class);
        System.out.println(studentInfo);
        System.out.println(classesInfo);
    }
}
