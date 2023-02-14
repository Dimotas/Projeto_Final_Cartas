package com.company;

public interface InterfaceJogo {
    int VALORMAXIMO = 5000;

    void jogar(int var1);

    void verJogo();

    default int compraFichas(SLOTS[] slots) {
        int soma = 0;
        SLOTS[] var3 = slots;
        int var4 = slots.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            SLOTS f = var3[var5];
            soma += f.get_valor();
        }

        return soma;
    }

    static void publicidade() {
        System.out.println("BEM VINDO AO CASINO DO TM");
    }
}