import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aksh.service.CustomerService;
import com.aksh.service.CustomerServiceImpl;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		//CustomerService service = new CustomerServiceImpl();
		CustomerService service = appContext.getBean("customerService",CustomerService.class);
		System.out.println(service);
		
		CustomerService service1 = appContext.getBean("customerService",CustomerService.class);
		System.out.println(service1);
		
		System.out.println(service1.findAll().get(0).getFirstName());
	}

}
