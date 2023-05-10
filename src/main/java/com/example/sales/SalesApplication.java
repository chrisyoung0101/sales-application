package com.example.sales;

import com.example.sales.model.Sale;
import com.example.sales.repository.SalesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.Arrays;
// TODO implements CommandLineRunner

@SpringBootApplication
@EnableSwagger2
public class SalesApplication {

	private final SalesRepository salesRepository;

	public SalesApplication(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SalesApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			Sale sale1 = new Sale(null, LocalDate.now(), "Hand Saw", 10.0, "Jerry Smith");
			Sale sale2 = new Sale(null, LocalDate.now(), "Screwdriver", 20.0, "Tyrone Biggs");
			Sale sale3 = new Sale(null, LocalDate.now(), "Glue Gun", 30.0, "Leroy Jenkins");
			Sale sale4 = new Sale(null, LocalDate.now(), "Step Ladder", 40.0, "Leanne Graham");
			Sale sale5 = new Sale(null, LocalDate.now(), "Paint Gallon", 50.0, "Ervin Howell");
			salesRepository.saveAll(Arrays.asList(sale1, sale2, sale3, sale4, sale5));
		};
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.sales"))
				.paths(PathSelectors.any())
				.build();
	}
}

