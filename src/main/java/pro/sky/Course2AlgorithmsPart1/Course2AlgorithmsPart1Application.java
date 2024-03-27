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
		System.out.println("http://localhost:8080/list/add?index=0&item=added1");
		System.out.println("http://localhost:8080/list/add?index=4&item=added2");
		System.out.println("http://localhost:8080/list/add?index=5&item=added3");
		System.out.println("http://localhost:8080/list/equals?otherList=first");
		System.out.println("http://localhost:8080/list/equals?otherList=second");
	}

}
