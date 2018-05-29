package com.marcreis.cursomc.resources;

import com.marcreis.cursomc.domain.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar() {

        Categoria cat1 = new Categoria(1L, "Informatica");
        Categoria cat2 = new Categoria(2L, "Escritorio");

        List<Categoria> categoriaList = new ArrayList<>();

        categoriaList.add(cat1);
        categoriaList.add(cat2);
        return categoriaList;
    }

}
