package ar.com.ada.mongo.netfly.services;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.mongo.netfly.entities.Serie;

/**
 * Netflix
 */
@Service
public class NetflixService {

    @Autowired
    SerieService serieService;
    
    public void grabar(Serie serie) {
        serieService.grabar(serie);
    }

    public Serie buscarSerie(String nombre) {
        return serieService.buscarPorNombre(nombre);
    }

    public Serie buscarSerie(ObjectId id) {
        return serieService.buscarPorId(id);
    }

    public List<Serie> getCatalogoSeries() {
        return serieService.getCatalogo();
    }

}
