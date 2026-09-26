package com.ordermgmt.order_mgmt;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderMgmtApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(OrderMgmtApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){return new ModelMapper();}

}
