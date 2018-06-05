package com.marcreis.cursomc.services;

import com.marcreis.cursomc.domain.Estado;
import com.marcreis.cursomc.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class EstadoService{

    @Autowired
    private EstadoRepository estadoRepository;

}