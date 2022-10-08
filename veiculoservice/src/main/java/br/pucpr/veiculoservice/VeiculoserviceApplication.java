package br.pucpr.veiculoservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class VeiculoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeiculoserviceApplication.class, args);
	}

}
