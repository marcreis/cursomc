package com.marcreis.cursomc;

import com.marcreis.cursomc.domain.*;
import com.marcreis.cursomc.domain.enums.EstadoPagamento;
import com.marcreis.cursomc.domain.enums.TipoCliente;
import com.marcreis.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


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

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
        cli1.getTelefonesSet().addAll(Arrays.asList("27363323", "93838393"));
        Endereco end1 = new Endereco(null, "Rua Flores", "300", "apto 203",
                "jardim", "38220834", cli1,c1);
        Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(end1, end2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Pedido ped1 = new Pedido( null, sdf.parse("30/09/2017 10:32"),cli1,end1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:356"), cli1, end2);

        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 10:31"), null);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

        p1.getItens().addAll(Arrays.asList(ip1, ip2));
        p2.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));



    }
}
