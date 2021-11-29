package br.com.lucas.project.notafiscal.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.project.notafiscal.domain.Aux;
import br.com.lucas.project.notafiscal.domain.NotaFiscalStatus;
import br.com.lucas.project.notafiscal.dto.EstadofilterDTO;
import br.com.lucas.project.notafiscal.service.NotaFiscalStatusService;

@RestController
@RequestMapping(value = "api/notafical")
public class Controle {

	@Autowired
	private NotaFiscalStatusService service;

	@GetMapping(value = "/mais")
	public ResponseEntity<Aux> findByidCong() {

		Aux obj = service.maiorAux();

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/ut")
	public ResponseEntity<List<NotaFiscalStatus>> findBy() {

		List<NotaFiscalStatus> obj = service.getemo();

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/estado")
	public ResponseEntity<NotaFiscalStatus> estado(@RequestParam(value = "estado", defaultValue = "PE") String estado) {
		System.out.println("UF" + estado);
		NotaFiscalStatus obj = service.estado(estado);

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "status/estado")
	public ResponseEntity<String> Status(@RequestParam(value = "estado", defaultValue = "PE") String estado,
			@RequestParam(value = "servico", defaultValue = "Inutilização4") String servico) {

		String obj = service.estadoStauts(estado, servico);

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "date/estado")
	public ResponseEntity<NotaFiscalStatus> StatusDate(@Valid @RequestBody EstadofilterDTO objDTO) {

		NotaFiscalStatus obj = service.estadoData(objDTO.getEstado(), objDTO.getDate());

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "all/estado")
	public ResponseEntity<List<NotaFiscalStatus>> estadoall(
			@RequestParam(value = "estado", defaultValue = "PE") String estado) {

		List<NotaFiscalStatus> obj = service.estadoall(estado);

		return ResponseEntity.ok().body(obj);
	}

}
