package yfckevin.springcachepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringCachePracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCachePracticeApplication.class, args);
	}

}
