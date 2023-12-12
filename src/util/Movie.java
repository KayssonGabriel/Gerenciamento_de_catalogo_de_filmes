package util;

public class Movie {
    private String title;
    private int year;
    private double imdb; // nota do imdb

    public Movie(String title, int year, double imdb) {
        this.title = title;
        this.year = year;
        this.imdb = imdb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    @Override
    public String toString() {
        return "Título: '" + title + '\'' +
                ", Ano de lançamento: " + year +
                ", Nota no IMDb: " + imdb + "\n";
    }
}
