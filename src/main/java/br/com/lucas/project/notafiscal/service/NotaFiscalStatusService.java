package br.com.lucas.project.notafiscal.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.lucas.project.notafiscal.domain.Autorizador;
import br.com.lucas.project.notafiscal.domain.Aux;
import br.com.lucas.project.notafiscal.domain.NotaFiscalStatus;
import br.com.lucas.project.notafiscal.repository.NotaFiscalStatusRepository;

@Service
public class NotaFiscalStatusService {

	@Autowired
	private NotaFiscalStatusRepository repo;
	@Autowired
	private AutorizadorService autorizadorService;

	public Aux getMaior(Integer estado) {

		List<Aux> list = new ArrayList<Aux>();

		list.add(new Aux("autorizacao4", repo.autorizacao4(estado)));
		list.add(new Aux("consulta_cadastro4", repo.consulta_cadastro4(estado)));
		list.add(new Aux("consulta_protocolo4", repo.consulta_protocolo4(estado)));
		list.add(new Aux("inutilizacao4", repo.inutilizacao4(estado)));
		list.add(new Aux("recepcao_evento4", repo.recepcao_evento4(estado)));
		list.add(new Aux("retorno_autorizacao4", repo.retorno_autorizacao4(estado)));
		list.add(new Aux("status_servico4", repo.status_servico4(estado)));
		list.add(new Aux("tempo_medio", repo.tempo_medio(estado)));

		for (Aux aux : list) {
			System.out.println(aux.toString());
		}

		Collections.sort(list);

		return list.get(0);

	}

	public Integer maior(Integer estado) {
		Integer aux = 0;
		aux = aux + repo.autorizacao4(estado);
		aux = aux + repo.consulta_cadastro4(estado);
		aux = aux + repo.consulta_protocolo4(estado);
		aux = aux + repo.inutilizacao4(estado);
		aux = aux + repo.recepcao_evento4(estado);
		aux = aux + repo.retorno_autorizacao4(estado);
		aux = aux + repo.status_servico4(estado);
		aux = aux + repo.tempo_medio(estado);

		return aux;
	}

	public Aux maiorAux() {
		List<Autorizador> list = autorizadorService.findall();

		Aux maior = new Aux("", 0);

		for (Autorizador autorizador : list) {
			Integer tes = 0;
			tes = this.maior(autorizador.getId());
			if (tes > maior.getQuantidade()) {
				maior.setNome(autorizador.getNome());
				maior.setQuantidade(tes);
			}
		}
		return maior;
	}

	public List<NotaFiscalStatus> getemo() {

		List<NotaFiscalStatus> list = new ArrayList<NotaFiscalStatus>();
		list = repo.ultimoRegistro();

		Collections.reverse(list);

		return list;
	}

	public NotaFiscalStatus estado(String estado) {
		Autorizador autorizador = autorizadorService.findByNome(estado);
		NotaFiscalStatus obj = repo.estado(autorizador.getId());

		return obj;
	}

	public String estadoStauts(String estado, String type) {
		Autorizador autorizador = autorizadorService.findByNome(estado);
		NotaFiscalStatus obj = repo.estado(autorizador.getId());
		String s = this.type(obj, type);
		return s;
	}

	public NotaFiscalStatus estadoData(String estado, String date) {
		Autorizador autorizador = autorizadorService.findByNome(estado);

		return repo.estadoData(autorizador.getId(), date);
	}

	public List<NotaFiscalStatus> estadoall(String estado) {

		return repo.estadoall(estado);
	}

	public Page<NotaFiscalStatus> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public String type(NotaFiscalStatus obj, String servico) {

		switch (servico) {

		case "Autorização4":

			return obj.getAutorizacao4();

		case "Retorno Autorização4":

			return obj.getRecepcaoEvento4();

		case "Inutilização4":

			return obj.getInutilizacao4();

		case "Consulta Protocolo4":

			return obj.getConsultaProtocolo4();

		case "Status Serviço4":

			return obj.getStatusServico4();

		case "Tempo Médio":

			return obj.getTempoMedio();

		case "Consulta Cadastro4":

			return obj.getConsultaCadastro4();

		case "Recepção Evento4":

			return obj.getRecepcaoEvento4();

		default:
			return servico;

		}

	}

}
