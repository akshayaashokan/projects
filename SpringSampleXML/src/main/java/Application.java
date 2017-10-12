import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aksh.service.CustomerService;

public class Application {

	public static void main(String[] args) {
		
		//CustomerService service = new CustomerServiceImpl();
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CustomerService service = (CustomerService) appContext.getBean("customerService","CustomerService.class");
		System.out.println(service);
		
		CustomerService service2 = (CustomerService) appContext.getBean("customerService","CustomerService.class");
		System.out.println(service2);
		System.out.println(service.findAll().get(0).getFirstName());
	}

}
