package com.albo.oroscopo;

import javafx.application.Application;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Oroscopo o = new Oroscopo(LocalDate.now());
        System.out.println(o.getSegnoZodiacale());
    }
}