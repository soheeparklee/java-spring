package com.example.spring_basic.beanFind;

import com.example.spring_basic.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("print all beans")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        System.out.println("Arrays.toString(beanDefinitionNames) = " + Arrays.toString(beanDefinitionNames));
    }

    @Test
    @DisplayName("print all beans")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name: "+ beanDefinitionName+ " bean = " + bean);
            }
        }    }
}
