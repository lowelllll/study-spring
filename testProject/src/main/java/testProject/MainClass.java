package testProject;

import org.springframework.context.support.GenericXmlApplicationContext;

import config.DatabaseConfig;

public class MainClass {
	
	public static void main(String[] args) {
		
		// 스프링 컨테이너 접근하기 외부 리소
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml"); // 컨테이너
		
		DatabaseConfig dbConfig = ctx.getBean("databaseConfig", DatabaseConfig.class);
		dbConfig.print();
		
		ctx.close();	
		
	}

}
