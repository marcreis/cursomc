package com.marcreis.cursomc.repositories;

import com.marcreis.cursomc.domain.Categoria;
import com.marcreis.cursomc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
