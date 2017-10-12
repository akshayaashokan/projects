import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aksh.service.CustomerService;
import com.aksh.service.CustomerServiceImpl;

public class Application {

	public static void main(String[] args) {
		
ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CustomerService service = (CustomerService) appContext.getBean("customerService","CustomerService.class");
		
		System.out.println(service.findAll().get(0).getFirstName());
	}

}
