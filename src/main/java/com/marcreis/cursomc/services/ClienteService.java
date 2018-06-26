package com.marcreis.cursomc.services;

import com.marcreis.cursomc.domain.Categoria;
import com.marcreis.cursomc.domain.Cliente;
import com.marcreis.cursomc.repositories.ClienteRepository;
import com.marcreis.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(Long id) {

        Optional<Cliente>cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(
                () -> new ObjectNotFoundException("Objeto nao encontrado id: " + id + " tipo: " + Cliente.class.getName())
        );

    }
}
