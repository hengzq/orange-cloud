package cn.hengzq.orange.ai.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestClient;

import java.net.InetAddress;
import java.net.UnknownHostException;


@Slf4j
@SpringBootApplication(scanBasePackages = {"cn.hengzq.orange.ai.core"})
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(Application.class, args);
        Environment environment = application.getEnvironment();
        log.warn("{} started successfully.", environment.getProperty("spring.application.name"));
        printUrl(environment);
    }

    private static void printUrl(Environment environment) {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            String port = environment.getProperty("server.port");
            log.info("\n--------------------------------------------------------------------\n\t" +
                    "Application " + environment.getProperty("spring.application.name") + " is running! Access URLs:\n\t" +
                    "Local: \t\t\thttp://localhost:" + port + "/\n\t" +
                    "External: \t\thttp://" + ip + ":" + port + "/\n\t" +
                    "Swagger Doc: \thttp://" + ip + ":" + port + "/doc.html\n" +
                    "--------------------------------------------------------------------");
        } catch (UnknownHostException ignored) {
            log.error("Get ip is failed.");
        }
    }
}
