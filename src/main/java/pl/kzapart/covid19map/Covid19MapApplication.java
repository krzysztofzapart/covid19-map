package pl.kzapart.covid19map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;

@SpringBootApplication
public class Covid19MapApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(Covid19MapApplication.class, args);
	}
}