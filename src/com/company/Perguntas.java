package com.company;

import java.util.Scanner;

public class Perguntas{
    public void perguntar()
    {
        int bolsa;
        Scanner valoraposta = new Scanner(System.in);
        Scanner nomeutilizador = new Scanner(System.in);
        System.out.println("Qual é o seu nome?");
        String nome = nomeutilizador.nextLine();
        System.out.println("Qual a slot que pretende comprar??(Cem,Duzentos,Trezentos,Quinhentos ou Mil?");
        String teste = valoraposta.nextLine();
        try{
            SLOTS escolha = SLOTS.valueOf(teste);
            switch (escolha)
                {
                    case Cem:
                        System.out.println("Comprou o valor de 100!");
                        bolsa = 100;
                        MenuJogo(nome, bolsa);
                        break;
                    case Duzentos:
                        System.out.println("Comprou o valor de 200!");
                        bolsa = 200;
                        MenuJogo(nome, bolsa);
                        break;
                    case Trezentos:
                        System.out.println("Comprou o valor de 300!");
                        bolsa = 300;
                        MenuJogo(nome, bolsa);
                        break;
                    case Quinhentos:
                        System.out.println("Comprou o valor de 500!");
                        bolsa = 500;
                        MenuJogo(nome, bolsa);
                        break;
                    case Mil:
                        System.out.println("Comprou o valor de 1000!");
                        bolsa = 1000;
                        MenuJogo(nome, bolsa);
                        break;
                }

            }
            catch (Exception e)
            {
                System.out.println("Insira um slot correto(Cem,Duzentos,Trezentos, Quinhentos ou Mil!!");
            }

    }

    public void MenuJogo(String nome, int carteira){
        JogoCartas utilizador = new JogoCartas(nome, carteira);
        utilizador.menu();

        Scanner opcao= new Scanner(System.in);
        int opcaoescolhida = opcao.nextInt();

        while(opcaoescolhida !=3){
            switch (opcaoescolhida) {
                case 1:
                    utilizador.regras();
                    utilizador.menu();
                    opcaoescolhida=opcao.nextInt();
                    break;

                case 2:
                    utilizador.setOnIguais_listener(new InterfaceCartasIguais_Listener() {

                        public void CartasIguais_Handler(CartasIguaisEvent evt) {
                            if (utilizador.Cartas[0] == utilizador.Cartas[1] || utilizador.Cartas[0] == utilizador.Cartas[2]
                                    || utilizador.Cartas[0] == utilizador.Cartas[3]
                                    || utilizador.Cartas[1] == utilizador.Cartas[2] || utilizador.Cartas[1] == utilizador.Cartas[3]
                                    || utilizador.Cartas[2] == utilizador.Cartas[3])
                            {
                                JogoCartas j = (JogoCartas) evt.getSource();
                                if (utilizador.Cartas[0] == utilizador.Cartas[1] && utilizador.Cartas[2] == utilizador.Cartas[3]
                                        && utilizador.Cartas[0] == utilizador.Cartas[3])
                                {

                                    int premio2 = (j.Cartas[0] + j.Cartas[1] + j.Cartas[2] + j.Cartas[3])  * 13 + evt.Aposta;
                                    j.set_montante(j.get_montante() + premio2);
                                    System.out.println("JACKPOT 4 CARTAS IGUAIS!!! " + premio2);
                                }
                                else {
                                    int premio = (j.Cartas[0] + j.Cartas[1] + j.Cartas[2] + j.Cartas[3]) * 4 + evt.Aposta;
                                    j.set_montante(j.get_montante() + premio);
                                    System.out.println("Que sorte ganhou " + premio);
                                }
                            }
                        }
                    });


                    for (int i = 0; i < 10; ++i) {
                        utilizador.jogar(100);
                    }
                    utilizador.menu();
                    opcaoescolhida=opcao.nextInt();
                    break;

                default:
                    System.out.println("Opção inexistente, por favor escolha uma opção!(1-3)");
                    utilizador.menu();
                    opcaoescolhida=opcao.nextInt();
                    break;
            }
        }
        utilizador.sair();
    }


}
