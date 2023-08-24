package dev.danvega.contentcalendar.service;

import dev.danvega.contentcalendar.config.ContentCalendarProperties;
import dev.danvega.contentcalendar.model.Content;
import dev.danvega.contentcalendar.model.ContentRepository;
import dev.danvega.contentcalendar.model.Status;
import dev.danvega.contentcalendar.model.Type;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);


    }
    @Bean
    CommandLineRunner commandLineRunner(ContentRepository repository){
        return args -> {
            Content content = new Content(null,"Hello chat GPT",
                    "All about GPT",
                    Status.IDEA,
                    Type.ARTICLE,
                    LocalDateTime.now(),
                    null,
                    "");
            repository.save(content);
        };
    }
}
