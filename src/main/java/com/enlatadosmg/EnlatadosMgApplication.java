package com.enlatadosmg;

import com.enlatadosmg.entity.Cliente;
import com.enlatadosmg.entity.Producto;
import com.enlatadosmg.entity.Repartidor;
import com.enlatadosmg.repository.IClienteRepository;
import com.enlatadosmg.repository.IProductoRepository;
import com.enlatadosmg.repository.IRepartidorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EnlatadosMgApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnlatadosMgApplication.class, args);
    }

    @Bean
    public CommandLineRunner producto(IProductoRepository productoRepository) {
        return args -> {
            Producto producto = new Producto(
                    "P001",
                    "Frijoles enlatados",
                    "Legumbres",
                    9.50,
                    120
            );
            productoRepository.save(producto);
            System.out.println("Producto insertado en la base de datos");
        };
    }


    @Bean
    public CommandLineRunner cliente(IClienteRepository clienteRepo, IRepartidorRepository repartidorRepo) {
        return args -> {
            clienteRepo.save(new Cliente("1001", "Lucía", "Méndez", "5555-1234"));
            repartidorRepo.save(new Repartidor("2001", "Marco", "Díaz", "B", "5555-5678"));
            System.out.println("Cliente y Repartidor insertados.");
        };
    }



}