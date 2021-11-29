package br.com.lucas.project.notafiscal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.lucas.project.notafiscal.domain.Autorizador;
@Repository
public interface AutorizadorRespository extends JpaRepository<Autorizador, Integer>, PagingAndSortingRepository<Autorizador, Integer> {

	 
	
	
   
   
  Autorizador findByNome(String nome);
}
