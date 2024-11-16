package com.api.corretora.service;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BuscarTitulosMasterServiceImpl {
    
    private static final Logger LOG = Logger.getLogger(BuscarTitulosMasterServiceImpl.class.getName());

    public ResponseEntity<Object> buscarTitulosMaster(String emissor) {
        LOG.info("Iniciando o serviço");
        if (emissor.equals("Banco Master SA") || emissor.equals("Banco Master de Investimentos SA")) {
            return ResponseEntity.ok("Emissor válido");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emissor não encontrado");
        }
    }
}
