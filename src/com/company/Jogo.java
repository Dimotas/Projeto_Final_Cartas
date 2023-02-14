package com.company;

public abstract class Jogo implements InterfaceJogo {
    private String _jogador;
    protected int _montante;
    public int valoremdivida;


    public void verJogo() {
        System.out.println("--------------------------");
        System.out.println("Jogador:" + this._jogador);
        System.out.println("Montante:" + this._montante);
        System.out.println("As suas cartas foram as seguintes:");
    }

    public abstract void jogar(int var1);

    public String get_jogador() {
        return this._jogador;
    }

    public int get_montante() {
        return this._montante;
    }

    public void set_montante(int _montante) {
        if (_montante >= 0) {
            this._montante = _montante;
        }

    }

    public Jogo(String jogador) {
        this._montante = 0;
        this._jogador = jogador;
    }

    public Jogo(String jogador, int montante) {
        this(jogador);
        this._montante = montante;
    }
}
