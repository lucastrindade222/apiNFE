package br.com.lucas.project.notafiscal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.lucas.project.notafiscal.domain.NotaFiscalStatus;

@Repository
public interface NotaFiscalStatusRepository
		extends JpaRepository<NotaFiscalStatus, Integer>, PagingAndSortingRepository<NotaFiscalStatus, Integer> {

	@Query(value = "  SELECT COUNT(*) FROM nota_fiscal_status nota WHERE nota.autorizacao4 LIKE 'indisponibilidade' and autorizador_id = ?1 ;", nativeQuery = true)
	Integer autorizacao4(Integer estado);

	@Query(value = " SELECT COUNT(*) FROM nota_fiscal_status nota WHERE nota.consulta_cadastro4 LIKE 'indisponibilidade' and autorizador_id = ?1 ;", nativeQuery = true)
	Integer consulta_cadastro4(Integer estado);

	@Query(value = " SELECT COUNT(*) FROM nota_fiscal_status nota WHERE nota.consulta_protocolo4 LIKE 'indisponibilidade' and autorizador_id = ?1 ;", nativeQuery = true)
	Integer consulta_protocolo4(Integer estado);

	@Query(value = " SELECT COUNT(*) FROM nota_fiscal_status nota WHERE nota.inutilizacao4 LIKE 'indisponibilidade' and autorizador_id = ?1 ;", nativeQuery = true)
	Integer inutilizacao4(Integer estado);

	@Query(value = " SELECT COUNT(*) FROM nota_fiscal_status nota WHERE nota.recepcao_evento4 LIKE 'indisponibilidade' and autorizador_id = ?1 ;", nativeQuery = true)
	Integer recepcao_evento4(Integer estado);

	@Query(value = " SELECT COUNT(*) FROM nota_fiscal_status nota WHERE nota.retorno_autorizacao4 LIKE 'indisponibilidade' and autorizador_id = ?1 ;", nativeQuery = true)
	Integer retorno_autorizacao4(Integer estado);

	@Query(value = " SELECT COUNT(*) FROM nota_fiscal_status nota WHERE nota.status_servico4 LIKE 'indisponibilidade' and autorizador_id = ?1 ;", nativeQuery = true)
	Integer status_servico4(Integer estado);

	@Query(value = " SELECT COUNT(*) FROM nota_fiscal_status nota WHERE nota.tempo_medio LIKE 'indisponibilidade' and autorizador_id = ?1 ;", nativeQuery = true)
	Integer tempo_medio(Integer estado);

	@Query(value = "  SELECT  * FROM nota_fiscal_status noti WHERE noti.autorizador_id=?1 ORDER BY id DESC LIMIT 1 ;", nativeQuery = true)
	NotaFiscalStatus estado(Integer estado);
	
	
	
	@Query(value = " SELECT  * FROM nota_fiscal_status noti WHERE noti.autorizador_id=?1 and noti.criacao = ?2 ", nativeQuery = true)
	NotaFiscalStatus estadoData(Integer estado,String date);
	
	@Query(value = "SELECT  * FROM nota_fiscal_status noti WHERE noti.autorizador_id=?1 ;", nativeQuery = true)
	List<NotaFiscalStatus> estadoall(String estado);
	
	@Query(value = "SELECT  * FROM nota_fiscal_status noti ORDER BY id DESC LIMIT 14;", nativeQuery = true)
	List<NotaFiscalStatus> ultimoRegistro();
	
	

}
