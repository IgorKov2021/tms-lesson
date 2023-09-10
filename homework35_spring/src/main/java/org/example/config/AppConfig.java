package org.example.config;

import org.example.domain.Horse;
import org.example.domain.Pair;
import org.example.domain.Rider;
import org.example.impl.GeneratePairs;
import org.example.impl.ServiceStartsImpl;
import org.example.impl.ValidateBetImpl;
import org.example.impl.ValidateNumberImpl;
import org.example.service.ServiceStarts;
import org.example.service.ValidateScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public ValidateScanner validateScanner1() {
        return new ValidateBetImpl();
    }
    @Bean
    public ValidateScanner validateScanner2() {
        return new ValidateNumberImpl();
    }
    @Bean
    public Horse horse1() {
        return new Horse("Appy", 12);
    }
    @Bean
    public Horse horse2() {
        return new Horse("Lokky", 12);
    }
    @Bean
    public Horse horse3() {
        return new Horse("Amori", 12);
    }
    @Bean
    public Rider rider1() {
        return new Rider("Petr", 28, "Winner of the European Championship 2021");
    }
    @Bean
    public Rider rider2() {
        return new Rider("Mark", 29, "Winner of the European Championship 2022");
    }
    @Bean
    public Rider rider3() {
        return new Rider("Polo", 30, "Winner of the European Championship 2023");
    }
    @Bean
    public Pair pair1(Horse horse1, Rider rider1) {
        return new Pair(horse1, rider1);
    }
    @Bean
    public Pair pair2(Horse horse2, Rider rider2) {
        return new Pair(horse2, rider2);
    }
    @Bean
    public Pair pair3(Horse horse3, Rider rider3) {
        return new Pair(horse3, rider3);
    }
    @Bean
    public GeneratePairs generatePairs(Pair pair1, Pair pair2, Pair pair3) {
        return new GeneratePairs(pair1,pair2,pair3);
    }

    @Bean
    public ServiceStarts serviceStarts(GeneratePairs generatePairs, List<ValidateScanner> validateScanners) {
        return new ServiceStartsImpl(generatePairs,validateScanners);
    }

}





