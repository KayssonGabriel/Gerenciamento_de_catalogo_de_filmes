package util.arvore;

import util.Movie;

import java.util.ArrayList;

public class AVLTree {
    public No raiz;

    int altura(No n) {
        if (n == null)
            return 0;
        return n.altura;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    No rightRotate(No y) {
        No x = y.left;
        No t2 = x.right;
        x.right = y;
        y.left = t2;
        y.altura = max(altura(y.left), altura(y.right)) + 1;
        x.altura = max(altura(x.left), altura(x.right)) + 1;
        return x;
    }

    No leftRotate(No x) {
        No y = x.right;
        No t2 = y.left;
        y.left = x;
        x.right = t2;
        x.altura = max(altura(x.left), altura(x.right)) + 1;
        y.altura = max(altura(y.left), altura(y.right)) + 1;
        return y;
    }

    // Retorna o fator de balanceamento do No n
    int getBalanceFactor(No n) {
        if (n == null)
            return 0;
        return altura(n.left) - altura(n.right);
    }

    // Insere um novo No
    // Insere um novo No
    public No insertNo(No no, Movie movie) {
        // Encontra a posição correta e insere o No (até o no folha apropriado)
        if (no == null)
            return (new No(movie));

        if (movie.getTitle().compareTo(no.movie.getTitle()) <= 0)
            no.left = insertNo(no.left, movie);
        else
            no.right = insertNo(no.right, movie);

        // Atualiza o fator de balanceamento de cada No e faz o balanceamento da árvore
        no.altura = 1 + max(altura(no.left), altura(no.right));
        int balanceFactor = getBalanceFactor(no);

        if (balanceFactor > 1) {
            if (movie.getTitle().compareTo(no.left.movie.getTitle()) <= 0) {
                return rightRotate(no);
            } else {
                no.left = leftRotate(no.left);
                return rightRotate(no);
            }
        }

        if (balanceFactor < -1) {
            if (movie.getTitle().compareTo(no.right.movie.getTitle()) > 0) {
                return leftRotate(no);
            } else {
                no.right = rightRotate(no.right);
                return leftRotate(no);
            }
        }

        return no;
    }

    // Encontra o No com o valor mínimo
    No noWithMimumValue(No no) {
        No atual = no;
        while (atual.left != null)
            atual = atual.left;
        return atual;
    }

    // Deletar o No
    public No deleteNo(No raiz, String title) {
        // Encontrar o No e deletar
        if (raiz == null)
            return raiz;

        if (title.compareTo(raiz.movie.getTitle()) < 0)
            raiz.left = deleteNo(raiz.left, title);
        else if (title.compareTo(raiz.movie.getTitle()) > 0)
            raiz.right = deleteNo(raiz.right, title);
        else {
            if ((raiz.left == null) || (raiz.right == null)) {
                No temp = null;
                if (temp == raiz.left)
                    temp = raiz.right;
                else
                    temp = raiz.left;
                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else
                    raiz = temp;
            } else {
                No temp = noWithMimumValue(raiz.right);
                raiz.movie = temp.movie;
                raiz.right = deleteNo(raiz.right, temp.movie.getTitle());
            }
        }
        if (raiz == null)
            return raiz;

        // Atualiza o fator de balanceamento de cada No e faz o balanceamento da árvore
        raiz.altura = max(altura(raiz.left), altura(raiz.right)) + 1;
        int balanceFactor = getBalanceFactor(raiz);
        if (balanceFactor > 1) {
            if (getBalanceFactor(raiz.left) >= 0) {
                return rightRotate(raiz);
            } else {
                raiz.left = leftRotate(raiz.left);
                return rightRotate(raiz);
            }
        }
        if (balanceFactor < -1) {
            if (getBalanceFactor(raiz.right) <= 0) {
                return leftRotate(raiz);
            } else {
                raiz.right = rightRotate(raiz.right);
                return leftRotate(raiz);
            }
        }
        return raiz;
    }

    public void inOrder(No no) {
        if (no != null) {
            inOrder(no.left);
            System.out.print(no.movie + "\n");
            inOrder(no.right);
        }
    }

    public void inOrderList(No no, ArrayList<Movie> movieList) {
        if (no != null) {
            inOrderList(no.left, movieList);
            movieList.add(no.movie);
            inOrderList(no.right, movieList);
        }
    }


    public void search(No raiz, String title) {
        if (raiz != null) {
            int comparison = title.compareTo(raiz.movie.getTitle());
            if (comparison == 0) {
                System.out.println("O filme com o título " + title + " está no catálogo");
            } else if (comparison < 0) {
                search(raiz.left, title);
            } else {
                search(raiz.right, title);
            }
        } else {
            System.out.println("O filme com o título " + title + " não está no catálogo");
        }
    }

}
