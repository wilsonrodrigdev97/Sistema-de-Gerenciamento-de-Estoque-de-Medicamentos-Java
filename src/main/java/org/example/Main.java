package org.example;

import java.util.Scanner;

public class Main {
    public static void mostrarEstoque(String[] nomes, int[] quantidade) {
        System.out.println("-------------------------------------");
        System.out.println(" Sistema de Gerenciamento de Estoque ");
        System.out.println("-------------------------------------");
        for (int i = 0; i < nomes.length; i++) {
            System.out.println(i + " - Medicamento " + nomes[i] + ": " + quantidade[i] + " unidades");
        }
    }

    public static void atualizarQuantidade(String[] nomes, int[] quantidade, Scanner sc) {

        System.out.print("Digite o ID do medicamento: ");
        int id = sc.nextInt();

        if (id < 0 || id >= quantidade.length) {
            System.out.println("ID Inválido!");
        } else {
            System.out.print("Quanto foi vendido do(a) " + nomes[id] + "? ");
            int vendida = sc.nextInt();

            if (vendida <= quantidade[id]) {
                quantidade[id] -= vendida;
                System.out.println("Venda registrada!");
            } else {
                System.out.println("Erro: Estoque insuficiente!");
            }
        }
        sc.nextLine();
    }

    public static void main(String[] args) {
        String[] nomes = {"Paracetamol", "Dipirona", "Torsilax", "Dorflex", "Benegrip"};
        int[] quantidade = {8, 11, 10, 15, 6};
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarEstoque(nomes, quantidade);

            System.out.print("[V] para Vender ou [S] para Sair: ");
            String opcao = scanner.nextLine();

            if (opcao.equalsIgnoreCase("S")) {
                System.out.println("Encerrando o Sistema...");
                break;
            }

            if (opcao.equalsIgnoreCase("V")) {
                atualizarQuantidade(nomes, quantidade, scanner);
            } else {
                System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}