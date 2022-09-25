package com.example.springSecurityTest.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean(name = "studentBean")
    CommandLineRunner run(StudentRepository studentRepository){
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "Jones",
                    "mariam@gmail.com"
            );
            Student samuel = new Student(
                    "Samuel",
                    "Fulgini",
                    "samuel@gmail.com"
            );

            Student gareth = new Student(
                    "Gareth",
                    "Bale",
                    "gareth@gmail.com"
            );

            Student scott = new Student(
                    "Scott",
                    "McTominay",
                    "scott@gmail.com"
            );

            Student alex = new Student(
                    "Alex",
                    "Morgan",
                    "alex@gmail.com"
            );

            Student dakota = new Student(
                    "Dakota",
                    "Johnson",
                    "dakota@gmail.com"
            );

            Student harry = new Student(
                    "Harry",
                    "Kane",
                    "harry@gmail.com"
            );

            Student alexander = new Student(
                    "Alexander",
                    "Arnold",
                    "arnold@gmail.com"
            );

            Student luke = new Student(
                    "Luke",
                    "Shaw",
                    "luke@gmail.com"
            );

            Student declan = new Student(
                    "Declan",
                    "Rice",
                    "declan@gmail.com"
            );

            studentRepository.saveAll(
                    List.of(mariam, samuel, gareth, scott, alex, dakota, harry, alexander, luke, declan)
            );

        };
    }
}
