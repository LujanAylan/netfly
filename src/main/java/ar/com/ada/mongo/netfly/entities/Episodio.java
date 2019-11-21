package ar.com.ada.mongo.netfly.entities;

/**
 * Episodio
 */
public class Episodio{

    public int nroEpisodio;
    public String titulo;
    public int duracion;

    public Episodio() {
	}

	public void reproducir() {
        System.out.println("Reproduciendo " + this.nroEpisodio + " " + this.titulo);
    }

    public int getNroEpisodio() {
        return nroEpisodio;
    }

    public void setNroEpisodio(int nroEpisodio) {
        this.nroEpisodio = nroEpisodio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
}