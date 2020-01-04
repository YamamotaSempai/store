package kz.aa.store;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.aa.store.global.proxy.NamedParameterJdbcTemplateProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class StoreApplication {

	private final ApplicationContext applicationContext;

	public StoreApplication(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	@Bean
	public NamedParameterJdbcTemplateProxy detectorJdbcProxy() {
		return new NamedParameterJdbcTemplateProxy(applicationContext.getBean(NamedParameterJdbcTemplate.class));
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
