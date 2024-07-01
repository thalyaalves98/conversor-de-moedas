package org.conversormoedas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConversorMain {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            boolean sair = false;

            while (!sair) {
                exibirMenuPrincipal();

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        MenuConversoes.exibirOpcoesDeConversao();
                        break;
                    case "2":
                        Historico.exibirHistoricoConversao();
                        break;
                    case "0":
                        System.out.println("Saindo...");
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n\n### Conversor de Moedas ###");
        System.out.println("1. Converter Moeda");
        System.out.println("2. Exibir Histórico");
        System.out.println("0. Sair");
        System.out.print("Digite sua opção: ");
    }

    public static BufferedReader getReader() {
        return reader;
    }
}