package org.sid.testprep;

import org.sid.testprep.dto.AvionDto;
import org.sid.testprep.service.AvionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TestPrepApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestPrepApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AvionService avionService){
        return args -> {
            avionService.saveAvions(
                    List.of(
                            AvionDto.builder().model("model1").matricul("ef6e55").color("pink").price(65559).build(),
                            AvionDto.builder().model("model2").matricul("ef6e+6").color("green").price(65489).build(),
                            AvionDto.builder().model("model3").matricul("ef64we8").color("yellow").price(89789).build(),
                            AvionDto.builder().model("model4").matricul("wrdqwqw").color("black").price(67489).build()
                    )
            );
        };
    }
}

