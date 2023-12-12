package util.algoritmoDeOrdenacao;

import util.Movie;

public class MergeSort {
    //Função para mesclar os subvetores de a[]
    void merge(Movie a[], int inicio, int meio, int fim) {
        int i, j, k;
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;


        Movie[] leftArray = new Movie[n1];
        Movie[] rightArray = new Movie[n2];

        // Copia os dados para os arrays temporários
        for (i = 0; i < n1; i++)
            leftArray[i] = a[inicio + i];
        for (j = 0; j < n2; j++)
            rightArray[j] = a[meio + 1 + j];

        i = 0; // Índice inicial do primeiro subvetor
        j = 0; // Índice inicial do segundo subvetor
        k = inicio; // Índice inicial do subvetor mesclado


        // Mescla os subvetores ordenadamente
        while (i < n1 && j < n2) {
            if (leftArray[i].getImdb() >= rightArray[j].getImdb()) {  // >= para ordenar em ordem decrescente
                a[k] = leftArray[i];
                i++;
            } else {
                a[k] = rightArray[j];
                j++;
            }
            k++;
        }


        // Copia os elementos restantes, se houver, dos subvetores da esquerda e direita
        while (i < n1) {
            a[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Função principal do Merge Sort usando recursão
    public void mergeSort(Movie a[], int inicio, int fim) { // Recursão
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            // Chama a mergeSort recursivamente para os subvetores esquerdo e direito
            mergeSort(a, inicio, meio);
            mergeSort(a, meio + 1, fim);
            // Mescla os subvetores ordenados
            merge(a, inicio, meio, fim);
        }
    }

    // Função para imprimir o array
    void printArray(Movie a[], int n) {
        int i;
        for (i = 0; i < n; i++)
            System.out.print(a[i] + "\n");
    }
}