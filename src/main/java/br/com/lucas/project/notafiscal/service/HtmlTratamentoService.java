package br.com.lucas.project.notafiscal.service;

import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.lucas.project.notafiscal.domain.Autorizador;
import br.com.lucas.project.notafiscal.domain.NotaFiscalStatus;
import br.com.lucas.project.notafiscal.repository.NotaFiscalStatusRepository;

@Service
public class HtmlTratamentoService {

	@Value("${api.teste}")
	private String url;
	@Value("${api.uri}")
	private String uri1;
	@Value("${api.userAgunt}")
	private String userAgunt;
	@Autowired
	private NotaFiscalStatusRepository repo;
	@Autowired
	private AutorizadorService AutorizadorService;

	public void get() {
	 
		try {

			NotaFiscalStatus obj = new NotaFiscalStatus();

			final Document documeto = Jsoup.connect(this.url).followRedirects(true).userAgent(userAgunt).timeout(30000)
					.get();
			
			System.out.println("elementos NotaFiscalStatus:"+documeto);
			int t = 0;

			for (Element row : documeto.select("table.tabelaListagemDados td")) {

				if (t >= 9) {

					obj.setCriacao(new Date());
					this.incert(obj);
					t = 0;
					obj = null;
					obj = new NotaFiscalStatus();
				}
 
				String ax = documeto.select("th").get(t).text();

				String tex = row.text();

				if (tex.equals("")) {
					Elements au = row.getElementsByTag("img");
 
					if(ax.equals("Inutilização4") && obj.getAutorizador().getId() == 13) {
						System.out.println("tets");
					}
					this.from(obj, ax, this.verificacao(au.attr("src")));
				} else {

					this.from(obj, ax, row.text());
				}

				t++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
	}

	public void from(NotaFiscalStatus obj, String type, String status) {

		if (status == null) {
			status = "indisponibilidade";
		}
	

		switch (type) {
		case "Autorizador":
			Autorizador autorizador = new Autorizador();
			autorizador = AutorizadorService.findByNome(status);

			if (autorizador == null) {
				autorizador = AutorizadorService.salve(new Autorizador(null, status));
			}

			obj.setAutorizador(autorizador);

			break;

		case "Autorização4":

			obj.setAutorizacao4(status);

			break;

		case "Retorno Autorização4":

			obj.setRetornoAutorizacao4(status);

			break;

		case "Inutilização4":

			obj.setInutilizacao4(status);
			;

			break;

		case "Consulta Protocolo4":

			obj.setConsultaProtocolo4(status);
			;

		case "Status Serviço4":

			obj.setStatusServico4(status);
			;

			break;
		case "Tempo Médio":

			obj.setTempoMedio(status);
			;

			break;

		case "Consulta Cadastro4":

			obj.setConsultaCadastro4(status);
			;

			break;

		case "Recepção Evento4":

			obj.setRecepcaoEvento4(status);

			break;
		default:
			System.out.println("||??" + type);

		}

	}

	public String verificacao(String json) {

		String x = json;
		int indexArroba = x.indexOf("a_");

		int indexEComercial = x.indexOf("_P");
		if (indexArroba != -1 && indexEComercial != -1) {
			String obj = x.substring(indexArroba + 2, indexEComercial);

			return obj;
		} else {
			return null;
		}

	}

	public NotaFiscalStatus incert(NotaFiscalStatus obj) {

		obj = repo.save(obj);
		System.out.println(obj.toString());
		return obj;
	}

}
