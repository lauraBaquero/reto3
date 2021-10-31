package backend;

//1. Modelo
//2. Interface
//3. Repositorio
//4. Servicios
//5. Controlador o Web

// Categoria, Computador,Cliente,Mensaje y Reservacion



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"backend.Modelo"})
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
