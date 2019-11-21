package ar.com.ada.mongo.netfly.services;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.mongo.netfly.entities.Pelicula;
import ar.com.ada.mongo.netfly.repo.PeliculaRepository;

/**
 * PeliculaService
 */
@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    public void registrarPelicula(String titulo, String genero, int anio, Boolean ganoOscar){
        Pelicula p = new Pelicula();
        p.setTitulo(titulo);
        p.setGenero(genero);
        p.setAnio(anio);
        p.setGanoOscar(ganoOscar);

        peliculaRepository.save(p);
    }

    public List<Pelicula> buscarPorGenero(String genero) {
        List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();

        for (Pelicula p : peliculaRepository.findAll()) {
            if (p.getGenero().equals(genero)) {
                listaPeliculas.add(p);
            }
        }
        return listaPeliculas;
    }

    public void grabar(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    public Pelicula buscarPorId(ObjectId id) {
        return peliculaRepository.findBy_id(id);
    }

    public Pelicula buscarPorTitulo(String titulo) {
        return peliculaRepository.findByTitulo(titulo);
    }

    public List<Pelicula> getCatalogo() {
        return peliculaRepository.findAll();
    }
}