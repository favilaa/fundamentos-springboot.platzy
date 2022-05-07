package com.fundamentos.platzy.springboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWhitDependencyImplement implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWhitDependencyImplement.class);
   private MyOperation myOperation;

    public MyBeanWhitDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos ingresado al meto PrintWhitDependency");
        int numero=1;
        LOGGER.debug("El numero enviado como parametro a la dependencia operacion es: " + numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde mi BEAN con dependencia");
    }
}
