package service.configuration.bean_initialization;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("myCustomBeanName")) {
            System.out.println("Post Process Before Initialization method is called : Bean Name " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("myCustomBeanName")) {
            System.out.println("Post Process After Initialization method is called : Bean Name " + beanName);
        }
        return bean;
    }

}
