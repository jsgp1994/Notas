package com.fundamentos.springboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private Log LLOGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDepedency() {
        LLOGER.info("Esta en la linea 17 de la clase MyBeanWithDependencyImplement");
        int numero = 1;
        LLOGER.debug("El número enviado como parametro a la dependencia operacion es " + numero);
        System.out.println("Se imprime la sumatoria del numero " + myOperation.suma(numero));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
