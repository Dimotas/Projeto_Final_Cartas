package com.company;

public enum SLOTS {
    Cem(100),
    Duzentos(200),
    Trezentos(300),
    Quinhentos(500),
    Mil(1000);

    private int _valor;

    SLOTS(int valor) {
        this._valor = valor;
    }

    public int get_valor() {
        return this._valor;
    }

}
