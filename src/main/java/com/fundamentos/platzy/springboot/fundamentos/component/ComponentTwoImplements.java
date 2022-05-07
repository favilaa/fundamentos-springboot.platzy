package com.fundamentos.platzy.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplements implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Hola mundo desde mi consola... este es nuevo, o sea la numero dooooooos!!!!!!");
    }
}
