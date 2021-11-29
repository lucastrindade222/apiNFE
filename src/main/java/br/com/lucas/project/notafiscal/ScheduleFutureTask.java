package br.com.lucas.project.notafiscal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.lucas.project.notafiscal.service.HtmlTratamentoService;

@Component
@EnableScheduling
public class ScheduleFutureTask {

	@Autowired
	HtmlTratamentoService service;

	private final long MINUT = 300000 ;

	@Scheduled(fixedDelay = MINUT, zone = "GMT-3")
	public void schedulefuturetaskProdutoUpdate() {

		service.get();

	}

}