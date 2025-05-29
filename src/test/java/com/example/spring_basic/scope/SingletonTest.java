package com.example.spring_basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonTest.class);
        SingletonTest bean1 = ac.getBean(SingletonTest.class);
        SingletonTest bean2 = ac.getBean(SingletonTest.class);
        Assertions.assertThat(bean1).isSameAs(bean2);

        ac.close();

    }

    @Scope("singleton")
    static class SingletonBean{
        @PostConstruct
        public void init(){
            System.out.println("singleton init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("singleton destroy");
        }
    }

}
