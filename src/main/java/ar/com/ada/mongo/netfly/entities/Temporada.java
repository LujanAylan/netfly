package ar.com.ada.mongo.netfly.entities;

import java.util.*;

/**
 * Temporada
 */
public class Temporada {

    public int nroTemporada;
    public List<Episodio> episodios = new ArrayList<Episodio>();

    public Episodio getNumeroEpisodio(int nro) {
        for (Episodio e : this.episodios) {
            if (e.nroEpisodio == nro) {
                return e;
            }
        }
        return null;
    }

    public Episodio getTituloEpisodio(String titulo) {

        for (Episodio e : this.episodios) {
            if (titulo.equals(e.titulo)) {
                return e;
            }
        }
        return null;
    }

    public int getNroTemporada() {
        return nroTemporada;
    }

    public void setNroTemporada(int nroTemporada) {
        this.nroTemporada = nroTemporada;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }
    
}