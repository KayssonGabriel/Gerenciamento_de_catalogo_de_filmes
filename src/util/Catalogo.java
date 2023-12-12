package util;

import util.algoritmoDeOrdenacao.MergeSort;
import util.arvore.AVLTree;

import java.util.ArrayList;

public class Catalogo {
    AVLTree arvoreAVL = new AVLTree();
    MergeSort mergeSort = new MergeSort();

    public void inserir(Movie movie) {
        arvoreAVL.raiz = arvoreAVL.insertNo(arvoreAVL.raiz, movie);
    }

    public void imprimirAlfabeticamente() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Catálogo de filmes ordenado alfabeticamente: ");
        arvoreAVL.inOrder(arvoreAVL.raiz);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }


    public void ordenarPorNota() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Catálogo de filmes ordenado por nota do IMDb: ");
        ArrayList<Movie> movieList = new ArrayList<>();
        arvoreAVL.inOrderList(arvoreAVL.raiz, movieList);
        Movie[] movieArray = movieList.toArray(new Movie[0]);
        mergeSort.mergeSort(movieArray, 0, movieArray.length - 1);
        for (Movie movie : movieArray) {
            System.out.println(movie);
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void buscar(String title) {
        arvoreAVL.search(arvoreAVL.raiz, title);
    }

    public void remover(String title) {
        arvoreAVL.raiz = arvoreAVL.deleteNo(arvoreAVL.raiz, title);
    }
}

