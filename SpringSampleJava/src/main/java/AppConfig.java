import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.aksh.repository.CustomerRepository;
import com.aksh.repository.HibernateCustomerRepositoryImpl;
import com.aksh.service.CustomerService;
import com.aksh.service.CustomerServiceImpl;

@Configuration
@ComponentScan({"com.aksh"})
@PropertySource("app.properties")
public class AppConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcePlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	/*@Bean(name="customerService")
	public CustomerService getCustomerService()
	{
		//CustomerServiceImpl service = new CustomerServiceImpl(getCustomerRepository());
		CustomerServiceImpl service = new CustomerServiceImpl();
		//service.setCustomerRepository(getCustomerRepository());
		return service;
	}*/
	/*
	@Bean(name="customerRepository")
	public CustomerRepository getCustomerRepository()
	{
		return new HibernateCustomerRepositoryImpl();
	}*/
}
