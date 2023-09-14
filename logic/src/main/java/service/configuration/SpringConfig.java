package service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.configuration.aware.AwareImpl;
import service.configuration.aware.Dependency;
import service.configuration.aware.DependencyImpl;

@Configuration
public class SpringConfig {

    private Dependency dependency;

    @Bean(name = "myCustomBeanName")
    public AwareImpl getMyBeanName() {
        System.out.println("@Bean method for AwareImpl");
        return new AwareImpl(dependency);
    }

    @Bean()
    public Dependency getDependency() {
        System.out.println("@Bean method for DependencyImpl");
        return new DependencyImpl();
    }

    @Autowired
    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }
}
