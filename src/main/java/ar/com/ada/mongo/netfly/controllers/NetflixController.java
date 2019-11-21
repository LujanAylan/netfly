package ar.com.ada.mongo.netfly.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.mongo.netfly.entities.Serie;
import ar.com.ada.mongo.netfly.models.request.PeliculaRequest;
import ar.com.ada.mongo.netfly.models.response.PeliculaResponse;
import ar.com.ada.mongo.netfly.models.response.SerieResponse;
import ar.com.ada.mongo.netfly.services.NetflixService;
import ar.com.ada.mongo.netfly.services.PeliculaService;

/**
 * NetflixController
 */
@RestController
public class NetflixController {

    @Autowired
    NetflixService netflixService;

    @Autowired
    PeliculaService peliculaService;

    @PostMapping("/series")
    public SerieResponse postRegisterUser(@RequestBody Serie reqSerie) {
        SerieResponse r = new SerieResponse();

        netflixService.grabar(reqSerie);

        r.isOk = true;
        r.message = "Realizado con éxito.";
        r.id = reqSerie.get_id().toString();
        return r;

    }

    @GetMapping("/series")
    public ResponseEntity<?> GetSeries() throws Exception {

        List<Serie> series = netflixService.getCatalogoSeries();
        if (series.size() == 0)
            return (ResponseEntity<?>) ResponseEntity.notFound();

        return ResponseEntity.ok(series);

    }

    @PostMapping("/peliculas")
    public PeliculaResponse postRegistrarPelicula(@RequestBody PeliculaRequest req) {

        PeliculaResponse p = new PeliculaResponse();

        peliculaService.registrarPelicula(req.titulo, req.genero, req.anio, req.ganoOscar);

        p.message= "Pelicula registrada con exito";
        return p;
    }
    
}