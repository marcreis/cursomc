package com.marcreis.cursomc.repositories;

import com.marcreis.cursomc.domain.Pagamento;
import com.marcreis.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
