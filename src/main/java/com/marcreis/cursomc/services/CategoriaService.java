package com.marcreis.cursomc.services;

import com.marcreis.cursomc.domain.Categoria;
import com.marcreis.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Long id) {

        Optional<Categoria>categoria = categoriaRepository.findById(id);

        return categoria.orElse(null);
    }
}
