package ir.karafarinbank;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		logger.info("###################################");
		logger.info("####### System initialized! #######");
		logger.info("### Starting ServletInitializer ###");
		logger.info("###################################");

		return application.sources(KcsApplication.class);
	}

}
