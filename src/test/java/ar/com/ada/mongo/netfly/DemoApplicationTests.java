package ar.com.ada.mongo.netfly;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ada.mongo.netfly.entities.*;
import ar.com.ada.mongo.netfly.services.SerieService;
import ar.com.ada.mongo.netfly.services.SerieService.*;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void verificarSerie() {
		SerieService service = new SerieService();

		Serie serie = new Serie();
	
		SerieValidationType validationType = service.verificarSerie(serie);
		
		assertEquals(SerieValidationType.SERIE_DATOS_INVALIDOS, validationType);
	}

	@Test
	void verificarSerieTempDuplicada() {
		SerieService service = new SerieService();

		Serie serie = new Serie();
		serie.setTitulo("Breaking Bad");
		serie.setAnio(2008);
		serie.setGenero("Drama");
		Temporada temporada = new Temporada();

		temporada.setNroTemporada(3);

		serie.getTemporadas().add(temporada);

		Episodio e = new Episodio();

		temporada.getEpisodios().add(e);

		Temporada temporada2 = new Temporada();

		temporada2.setNroTemporada(3);
		
		serie.getTemporadas().add(temporada2);
		
		e = new Episodio();

		temporada2.getEpisodios().add(e);
		

		SerieValidationType serieValidationType = service.verificarSerie(serie);
		
		assertEquals(SerieValidationType.TEMPORADA_DUPLICADA, serieValidationType);

	}

}