package com.marcreis.cursomc;

import com.marcreis.cursomc.domain.Categoria;
import com.marcreis.cursomc.domain.Produto;
import com.marcreis.cursomc.repositories.CategoriaRepository;
import com.marcreis.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "informática");
        Categoria cat2 = new Categoria(null, "escritorio");
        Categoria cat3 = new Categoria(null, "Almoxarifado");


        Produto p1 = new Produto(null, "computador", 2000.0);
        Produto p2 = new Produto(null, "impressora", 800.0);
        Produto p3 = new Produto(null, "Mouse", 80.0);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));

        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategoria().add(cat1);
        p2.getCategoria().add(cat1);
        p2.getCategoria().add(cat2);

        p3.getCategoria().add(cat1);


        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        categoriaRepository.flush();
        produtoRepository.flush();
    }
}
