package ar.com.ada.mongo.netfly.entities;

import org.bson.types.ObjectId;

/**
 * Contenido
 */
public class Contenido {

    private ObjectId _id;
    private String titulo;
    private String genero;
    private int anio;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
   
}