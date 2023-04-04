package com.neonatal.backend.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.neonatal.backend.utility.BasicConstants;

@EnableSpringConfigured
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.neonatal.backend")
public class Application extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	// static ProcedureEmailNotification procedureEmailObj =null;

	public Application() {
		System.out.println("---------Application--------");
		logger.info("Logger Enabled ::");
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

		try {

			System.getProperties().put("server.port", 8383);
			BasicConstants.applicatonContext = SpringApplication.run(Application.class, args);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
