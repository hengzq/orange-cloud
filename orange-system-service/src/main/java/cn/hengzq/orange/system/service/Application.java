package cn.hengzq.orange.system.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;


@Slf4j
@SpringBootApplication(scanBasePackages = {"cn.hengzq.orange.system"})
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(Application.class, args);
        Environment environment = application.getEnvironment();
        log.warn("{} started successfully.", environment.getProperty("spring.application.name"));
        printUrl(environment);
    }

    private static void printUrl(Environment env) {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            String port = env.getProperty("server.port");
            String name = env.getProperty("spring.application.name");
            log.info("""
                            
                            --------------------------------------------------------------------
                            Application {} is running! Access URLs:
                            Local: \t\t\thttp://localhost:{}/
                            External: \t\thttp://{}:{}/
                            Swagger Doc: \thttp://{}:{}/doc.html
                            --------------------------------------------------------------------""",
                    name, port, ip, port, ip, port);
        } catch (UnknownHostException ignored) {
            log.error("Get ip is failed.");
        }
    }
}
