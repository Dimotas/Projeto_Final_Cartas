package com.company;

import java.util.Random;
import java.util.Scanner;

public class JogoCartas extends Jogo {
    public int[] Cartas = new int[]{1,1,1,1};
    protected InterfaceCartasIguais_Listener lst;

    public JogoCartas(String jogador) {
        super(jogador);
    }

    public void menu() {

        System.out.println("--------------------------");
        System.out.println("Bem Vindo " + get_jogador() + " Montante Atual: " + get_montante());
        System.out.println("--------------------------");
        System.out.println("Valor em Divida: " + valoremdivida);
        System.out.println("--------------------------");
        System.out.println("Escolha uma das opções! ");
        System.out.println("1. REGRAS!");
        System.out.println("2. JOGAR!");
        System.out.println("3. SAIR!");
        System.out.println("--------------------------");
    }

    public void regras() {
        System.out.println("--------------------------");
        System.out.println("Aposta já, iguala o valor das cartas e já tens prémio!");
        System.out.println("--------------------------");
        System.out.println("Objetivo: Passa por conseguir em 4 cartas, obter 2 ou 3 cartas iguais, ou,");
        System.out.println("conseguir o JACKPOT com as 4 cartas iguais.");
        System.out.println("--------------------------");
        System.out.println("Valores das Cartas:");
        System.out.println("A's=1,2,3,4,5,6,7,8,9,10,Valete=11,Dama=12,Rei=13");
        System.out.println("--------------------------");
        System.out.println("Premios:");
        System.out.println("Para 2 cartas iguais é feita a multiplicação por 4 da soma das 4 cartas.");
        System.out.println("Para 4 cartas iguais é feita a multiplicação por 13 da soma das 4 cartas,");
        System.out.println("que é basicamente um nype inteiro de 13 cartas.");
        System.out.println("Será que a sorte está do seu lado? ou irá ficar a dever dinheiro ao nosso casino?");
        System.out.println("--------------------------");
        System.out.println("Pedir empréstimo!");
        System.out.println("Pode pedir um empréstimo de 300 euros, que terá de devolver na saida do casino!");
        System.out.println("Caso, não tenha para devolver, irá assinar um documento de crédito com uma taxa de juro");
        System.out.println("de 12% sobre o valor da divida, de forma a colmatar os danos ao casino!");
        System.out.println("--------------------------");
        System.out.println("Bons Jogos!");

    }

    public void sair() {
        System.out.println("Adeus, volte sempre, necessitamos do seu dinheiro!");
        System.out.println("A divida foi subtraida");
        set_montante(get_montante()- valoremdivida);
        System.out.println("O seu montante final: " + get_montante());
        System.exit(0);
    }


    public void verJogo() {
        super.verJogo();
        System.out.println("Carta1:" + this.Cartas[0] + "\tCarta2:" + this.Cartas[1] + "\tCarta3:" + this.Cartas[2] +
                "\tCarta4:" + this.Cartas[3]);
        System.out.println("---------------------------------------------");
    }

    public JogoCartas(String jogador, int montante) {
        super(jogador, montante);
    }

    public void setOnIguais_listener(InterfaceCartasIguais_Listener l) {
        this.lst = l;
    }

    public void jogar(int aposta) {
        if (this.get_montante() >= aposta) {
            this.set_montante(this.get_montante() - aposta);
            Random r = new Random();
            this.Cartas[0] = r.nextInt(13) + 1;
            this.Cartas[1] = r.nextInt(13) + 1;
            this.Cartas[2] = r.nextInt(13) + 1;
            this.Cartas[3] = r.nextInt(13) + 1;
            CartasIguaisEvent evt = new CartasIguaisEvent(this, aposta);
            this.lst.CartasIguais_Handler(evt);




            this.verJogo();
        } else {
            System.out.println("Ficou sem créditos! Recarregue para jogar novamente!!");
            System.out.println("R para recarregar ou qualquer outra tecla para sair!");
            Scanner recarregar = new Scanner(System.in);
            String R = recarregar.nextLine();
            if (R.equals("r") || R.equals("R")){
                set_montante(300);
                valoremdivida = valoremdivida+300;
            }
            else{
                sair();
            }
        }
    }
}