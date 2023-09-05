package com.gyd.springboothello;

import com.gyd.springboothello.inherited.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class SpringbootHelloApplicationTests {

	@Test
	void testInherited() {
		{
			//类继承关系中，子类会继承父类使用的注解中被@Inherited修饰的注解
			Annotation[] annotations = MyInheritedClass.class.getAnnotations();
			assertTrue("", Arrays.stream(annotations).anyMatch(l -> l.annotationType().equals(IsInheritedAnnotation.class)));
			assertTrue("", Arrays.stream(annotations).noneMatch(l -> l.annotationType().equals(NoInherritedAnnotation.class)));
		}
		{
			//类实现接口时不会继承任何接口中定义的注解
			Annotation[] annotations = MyInheritedClassUseInterface.class.getAnnotations();
			assertTrue("", Arrays.stream(annotations).noneMatch(l -> l.annotationType().equals(IsInheritedAnnotation.class)));
			assertTrue("", Arrays.stream(annotations).noneMatch(l -> l.annotationType().equals(NoInherritedAnnotation.class)));
		}
		{
			//接口定义注解时，可以通过接口获取注解信息
			Annotation[] annotations = IInheritedInterface.class.getAnnotations();
			assertTrue("", Arrays.stream(annotations).anyMatch(l -> l.annotationType().equals(IsInheritedAnnotation.class)));
			assertTrue("", Arrays.stream(annotations).anyMatch(l -> l.annotationType().equals(NoInherritedAnnotation.class)));
		}
		{
			//接口继承关系中，子接口不会继承父接口中的任何注解，不管父接口中使用的注解有没有被@Inherited修饰
			Annotation[] annotations = IInheritedInterfaceChild.class.getAnnotations();
			assertTrue("", Arrays.stream(annotations).noneMatch(l -> l.annotationType().equals(IsInheritedAnnotation.class)));
			assertTrue("", Arrays.stream(annotations).noneMatch(l -> l.annotationType().equals(NoInherritedAnnotation.class)));
		}
	}



}
