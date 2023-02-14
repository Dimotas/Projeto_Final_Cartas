package com.company;

import java.util.EventObject;

public class CartasIguaisEvent extends EventObject {
    public int Aposta;

    public CartasIguaisEvent(Object source, int aposta) {
        super(source);
        this.Aposta = aposta;
    }
}
