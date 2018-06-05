package com.marcreis.cursomc.services;

import com.marcreis.cursomc.domain.Cidade;
import com.marcreis.cursomc.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
    @Autowired
    CidadeRepository cidadeRepository;

}