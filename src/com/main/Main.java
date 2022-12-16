package com.main;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int option = 0;
            do {
                System.out.println("Digite o que fazer: 1 - criar Usuário, 2 - criar Pessoa(precisa de usuário para criar): ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        MainCreateUser.main(args);
                        System.out.println("Criando usuário");
                        break;
                    case 2:
                        MainCreatePerson.main(args);
                        System.out.println("Criando pessoa");
                        break;
                    case 0:
                        System.out.println("Saindo");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }while (option != 0);
        }
}
