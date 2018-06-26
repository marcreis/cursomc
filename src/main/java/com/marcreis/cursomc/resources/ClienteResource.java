package com.marcreis.cursomc.resources;

import com.marcreis.cursomc.domain.Categoria;
import com.marcreis.cursomc.domain.Cliente;
import com.marcreis.cursomc.services.CategoriaService;
import com.marcreis.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable Long id) {

        Cliente cliente = clienteService.buscar(id);
        return ResponseEntity.ok().body(cliente);
    }

}
