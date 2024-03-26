package pro.sky.Course2AlgorithmsPart1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Course2AlgorithmsPart1Application {

	public static void main(String[] args) {
		SpringApplication.run(Course2AlgorithmsPart1Application.class, args);
		System.out.println("http://localhost:8080/list/create?size=6");
		System.out.println("http://localhost:8080/list/add?item=111");
		System.out.println("http://localhost:8080/list/add?item=222");
		System.out.println("http://localhost:8080/list/add?item=333");
		System.out.println("http://localhost:8080/list/add?item=444");
		System.out.println("http://localhost:8080/list/add?item=555");
		System.out.println("http://localhost:8080/list/add?item=666");
		System.out.println("http://localhost:8080/list/add?index=3&item=ADDED");
		System.out.println("http://localhost:8080/list/print");
		System.out.println("http://localhost:8080/list/indexOf?item=222");
		System.out.println("http://localhost:8080/list/indexOf?item=add");
		System.out.println("http://localhost:8080/list/indexOf?item=");
		System.out.println("http://localhost:8080/list/lastIndexOf?item=add");
		System.out.println("http://localhost:8080/list/lastIndexOf?item=444");
		System.out.println("http://localhost:8080/list/set?index=1&item=changed1");
		System.out.println("http://localhost:8080/list/set?index=4&item=changed4");
		System.out.println("http://localhost:8080/list/removeOnIndex?index=4");
		System.out.println("http://localhost:8080/list/removeOnIndex?index=1");
		System.out.println("http://localhost:8080/list/removeOnItem?item=111");
		System.out.println("http://localhost:8080/list/removeOnItem?item=444");
		System.out.println("http://localhost:8080/list/get?index=1");
		System.out.println("http://localhost:8080/list/get?index=5");
	}

}
