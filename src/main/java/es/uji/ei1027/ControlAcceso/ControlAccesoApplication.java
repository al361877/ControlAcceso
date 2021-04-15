package es.uji.ei1027.ControlAcceso;

import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class ControlAccesoApplication {

	private static final Logger log = Logger.getLogger(ControlAccesoApplication.class.getName());

	public static void main(String[] args) {
		new SpringApplicationBuilder(ControlAccesoApplication.class).run(args);
	}
}