package application;

import util.Catalogo;
import util.Movie;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Catalogo catalogo = new Catalogo();

        Movie[] movies = {
                new Movie("Feriado Sangrento", 2023, 6.9),
                new Movie("Fale Comigo", 2022, 7.1),
                new Movie("Jogos Mortais X", 2023, 6.6),
                new Movie("Midsommar: O Mal Não Espera a Noite", 2019, 7.1),
                new Movie("Psicopata Americano", 2000, 7.6),
                new Movie("Hereditário", 2018, 7.3),
                new Movie("O Exorcista", 1973, 8.1),
                new Movie("O Iluminado", 1980, 8.4),
        };

        for (Movie movie : movies) {
            catalogo.inserir(movie);
        }

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("1 - Inserir filme");
            System.out.println("2 - Buscar filme");
            System.out.println("3 - Remover filme");
            System.out.println("4 - Imprimir filmes ordenados alfabeticamente");
            System.out.println("5 - Imprimir filmes ordenados por nota do IMDb");
            System.out.println("6 - Sair");
            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do filme: ");
                    String title = scanner.nextLine();
                    System.out.print("Digite o ano de lançamento do filme: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite a nota do IMDb do filme: ");
                    double imdb = scanner.nextDouble();
                    scanner.nextLine();
                    catalogo.inserir(new Movie(title, year, imdb));
                    break;
                case 2:
                    System.out.print("Digite o título do filme: ");
                    title = scanner.nextLine();
                    catalogo.buscar(title);
                    break;
                case 3:
                    System.out.print("Digite o título do filme: ");
                    title = scanner.nextLine();
                    catalogo.remover(title);
                    break;
                case 4:
                    catalogo.imprimirAlfabeticamente();
                    break;
                case 5:
                    catalogo.ordenarPorNota();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }


    }
}