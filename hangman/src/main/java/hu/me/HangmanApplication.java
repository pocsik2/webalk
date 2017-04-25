package hu.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class HangmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HangmanApplication.class, args);
	}
	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory(){
		return new HibernateJpaSessionFactoryBean();
	}
}
