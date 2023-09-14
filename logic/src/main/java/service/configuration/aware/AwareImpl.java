package service.configuration.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class AwareImpl implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {
    static {
        System.out.println("AwareImpl static bloc");
    }

    {
        System.out.println("AwareImpl non-static bloc");
    }

    private Dependency dependency;
    @Override
    public void setBeanName(String s) {
        System.out.println("Aware class - " + this.getClass().getName() + ", bean name - " + s + " interface - BeanNameAware");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Aware class - " + this.getClass().getName() + ", beanFactoryClass - " + beanFactory.getClass().getName() + " interface - BeanFactoryAware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Aware class - " + this.getClass().getName() + ", applicationContext - " + applicationContext.getClass().getName() + " interface - ApplicationContextAware");
    }

    public AwareImpl() {
        System.out.println("AwareImpl constructor without parameters");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PreInitialization class - " + this.getClass().getName() + " interface - InitializingBean");
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct method for AwareImpl");
    }

    @Autowired
    public AwareImpl(Dependency dependency) {
        System.out.println("AwareImpl constructor with parameter");
        this.dependency = dependency;
    }
}

