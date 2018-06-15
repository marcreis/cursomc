package com.marcreis.cursomc;

import com.marcreis.cursomc.domain.Categoria;
import com.marcreis.cursomc.domain.Cidade;
import com.marcreis.cursomc.domain.Estado;
import com.marcreis.cursomc.domain.Produto;
import com.marcreis.cursomc.repositories.CategoriaRepository;
import com.marcreis.cursomc.repositories.CidadeRepository;
import com.marcreis.cursomc.repositories.EstadoRepository;
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

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

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

        Estado e1 = new Estado(null, "Minas Gerais");
        Estado e2 = new Estado(null, "São Paulo");


        Cidade c1 = new Cidade(null, "Uberlandia", e1);
        Cidade c2 = new Cidade(null, "São Paulo", e2);
        Cidade c3 = new Cidade(null, "Campinas", e2);

        e1.getCidades().addAll(Arrays.asList(c1));
        e2.getCidades().addAll(Arrays.asList(c2,c3));

        estadoRepository.saveAll(Arrays.asList(e1, e2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        estadoRepository.flush();
        cidadeRepository.flush();


    }
}
