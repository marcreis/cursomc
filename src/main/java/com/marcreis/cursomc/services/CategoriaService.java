package com.marcreis.cursomc.services;

import com.marcreis.cursomc.domain.Categoria;
import com.marcreis.cursomc.repositories.CategoriaRepository;
import com.marcreis.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Long id) {

        Optional<Categoria>categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(
                () -> new ObjectNotFoundException("Objeto nao encontrado id: " + id + " tipo: " + Categoria.class.getName())
        );

    }
}
