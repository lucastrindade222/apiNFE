package br.com.lucas.project.notafiscal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.project.notafiscal.domain.Autorizador;
import br.com.lucas.project.notafiscal.repository.AutorizadorRespository;

@Service
public class AutorizadorService {
    @Autowired
	private AutorizadorRespository repo;

    public List<Autorizador> findall(){
    return	repo.findAll();
    }
    
	public Autorizador findByNome(String nome) {
		return repo.findByNome(nome);
	}

	public Autorizador salve(Autorizador obj) {
		return repo.save(obj);
	}

}
