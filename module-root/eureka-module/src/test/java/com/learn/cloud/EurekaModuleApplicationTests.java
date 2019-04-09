package com.learn.cloud;

import com.learn.cloud.annotation.MyAnno;
import com.learn.cloud.annotation.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaModuleApplicationTests {

	@MyAnno(mName = "test", mAge = 20)
	public User user;

	@Test
	public void contextLoads() throws NoSuchFieldException {
		Field field = this.getClass().getField("user");
		if(field.isAnnotationPresent(MyAnno.class)){
			MyAnno myAnno = field.getAnnotation(MyAnno.class);
			System.out.println(myAnno.mName());
			System.out.println(myAnno.mAge());
		}
	}

}
