package br.com.coiso.screenmatch;

import br.com.coiso.screenmatch.model.DadosSerie;
import br.com.coiso.screenmatch.service.ConsumoApi;
import br.com.coiso.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// &apikey=a252f7a5
@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=a252f7a5");
		System.out.println(json);
		var convertor = new ConverteDados();
		DadosSerie dados = convertor.obterDados(json, DadosSerie.class);
		System.out.println(dados);


	}
}
