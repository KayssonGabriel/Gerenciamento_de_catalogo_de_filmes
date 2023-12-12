package util.arvore;

import util.Movie;

public class No {
    Movie movie;
    int altura;
    No left;
    No right;

    No(Movie movie) {
        this.movie = movie;
        this.altura = 1;
    }
}

