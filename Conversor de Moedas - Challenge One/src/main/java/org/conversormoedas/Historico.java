package org.conversormoedas;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Historico {
    private static final String ARQUIVO_HISTORICO = "historico.txt";
    private static List<String> historico = new ArrayList<>();

    public static void registrarConversao(String fromCurrency, String toCurrency, double amount, double convertedAmount) {
        String registro = LocalDateTime.now() + " | " + amount + " " + fromCurrency + " = " + convertedAmount + " " + toCurrency;
        historico.add(registro);
        salvarHistorico();
    }

    public static void exibirHistoricoConversao() {
        carregarHistorico();
        if (historico.isEmpty()) {
            System.out.println("Nenhuma conversão registrada.");
        } else {
            System.out.println("\n### Histórico de Conversão ###");
            for (String registro : historico) {
                System.out.println(registro);
            }
        }
    }

    private static void salvarHistorico() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_HISTORICO))) {
            for (String registro : historico) {
                writer.println(registro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void carregarHistorico() {
        historico.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_HISTORICO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                historico.add(linha);
            }
        } catch (IOException e) {
            // Arquivo não existe ou ocorreu um erro ao ler o arquivo
        }
    }
}
