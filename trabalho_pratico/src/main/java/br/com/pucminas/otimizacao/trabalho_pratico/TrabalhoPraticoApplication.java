package br.com.pucminas.otimizacao.trabalho_pratico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


@SpringBootApplication
public class TrabalhoPraticoApplication extends SpringBootServletInitializer {
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(TrabalhoPraticoApplication.class);
	    }

	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(TrabalhoPraticoApplication.class, args);
	    }
}
