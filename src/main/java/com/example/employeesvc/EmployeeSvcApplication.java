package com.example.employeesvc;

import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class EmployeeSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSvcApplication.class, args);

	}

}
