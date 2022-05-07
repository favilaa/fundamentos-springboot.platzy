package com.fundamentos.platzy.springboot.fundamentos.configuration;

import com.fundamentos.platzy.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBeanTwoImplement();
    }
    @Bean
    public MyOperation beanOpeartionOperation() {
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOpeartionOperationWithDependency(MyOperation myOperation) {
        return new MyBeanWhitDependencyImplement(myOperation);
    }
    @Bean
    public MiPractica miPractica(){
        return new MiPracticaDepende();
    }

}
