package org.ehrbase.fhirbridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

@SpringBootApplication(
    exclude = {
      QuartzAutoConfiguration.class,
      ElasticsearchRestClientAutoConfiguration.class,
      ThymeleafAutoConfiguration.class
    })
public class FhirBridgeApplication {

  public static void main(String[] args) {
    SpringApplication.run(FhirBridgeApplication.class, args);
  }
}
