package com.fundamentos.platzy.springboot.fundamentos.bean;

public class MiPracticaDepende implements MiPractica {

    @Override
    public int sum(int numero) {
        int num=10;
        System.out.println(num+5);
        return num;

    }
}
