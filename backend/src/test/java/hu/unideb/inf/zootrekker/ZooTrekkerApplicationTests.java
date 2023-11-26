package hu.unideb.inf.zootrekker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
class ZooTrekkerApplicationTests {
	@Autowired
	private Environment environment;
	@Test
	void contextLoads() {
		System.out.println("Database url" + environment.getProperty("spring.datasource.url"));
	}

}
