package com.thoughtworks.capability.gtb.entrancequiz;

import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Created by wudibin
 * 2020/10/27
 */
@Configuration
public class CorsConfig {

    @Autowired
    StudentRepository studentRepository;

    @Bean
    public StudentService studentService() {
        return new StudentService(studentRepository);
    }

    private static String[] originsVal = new String[]{
            "127.0.0.1:8080",
            "localhost:8080",
    };

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        this.addAllowedOrigins(corsConfiguration);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin("*");
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }

    private void addAllowedOrigins(CorsConfiguration corsConfiguration) {
        for (String origin : originsVal) {
            corsConfiguration.addAllowedOrigin("http://" + origin);
            corsConfiguration.addAllowedOrigin("https://" + origin);
        }
    }

}
