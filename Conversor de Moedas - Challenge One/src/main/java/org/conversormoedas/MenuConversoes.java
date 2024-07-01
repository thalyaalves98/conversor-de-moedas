package org.conversormoedas;

import java.io.BufferedReader;
import java.io.IOException;

public class MenuConversoes {
    public static void exibirOpcoesDeConversao() throws IOException {
        ExchangeRate converteMoeda = new ExchangeRate();
        BufferedReader reader = ConversorMain.getReader();
        boolean voltarMenu = false;

        while (!voltarMenu) {
            exibirMenuConversao();

            String entrada = reader.readLine();

            switch (entrada) {
                case "1":
                    converteMoeda.convert("USD", "EUR");
                    break;
                case "2":
                    converteMoeda.convert("USD", "BRL");
                    break;
                case "3":
                    converteMoeda.convert("BRL", "USD");
                    break;
                case "4":
                    converteMoeda.convert("BRL", "EUR");
                    break;
                case "5":
                    converteMoeda.convert("EUR", "USD");
                    break;
                case "6":
                    converteMoeda.convert("EUR", "BRL");
                    break;
                case "0":
                    System.out.println("Voltando ao Menu Principal...");
                    voltarMenu = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        }
    }

    private static void exibirMenuConversao() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Converter de USD para EUR");
        System.out.println("2. Converter de USD para BRL");
        System.out.println("3. Converter de BRL para USD");
        System.out.println("4. Converter de BRL para EUR");
        System.out.println("5. Converter de EUR para USD");
        System.out.println("6. Converter de EUR para BRL");
        System.out.println("0. Voltar ao Menu Principal");
    }
}