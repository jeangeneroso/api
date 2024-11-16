package com.api.corretora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.corretora.datasource.model.Titulo;
import com.api.corretora.repository.TituloRepository;
import com.api.corretora.service.BuscarTituloServiceImpl;
import com.api.corretora.service.BuscarTitulosMasterServiceImpl;
import com.api.corretora.service.BuscarTitulosOutrosEmissoresServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class TituloController {

	@Autowired
	private TituloRepository tituloRepository;

	@Autowired
	private BuscarTituloServiceImpl serviceBuscarTodos;
	private BuscarTitulosMasterServiceImpl serviceBuscarMaster;
	private BuscarTitulosOutrosEmissoresServiceImpl serviceBuscarOutros;

	@GetMapping
	public List<Titulo> buscarTitulo() {
		return serviceBuscarTodos.buscarTodosOsTitulos();
	}

	/*
	 * @GetMapping(path = "api/titulo-emissor_master") public ResponseEntity<Object>
	 * buscarTitulosMaster(@PathVariable(name = "emissor", required = true) String
	 * emissor) { return serviceBuscarMaster.buscarTitulosMaster(emissor); }
	 */

	@GetMapping(path = "/api/titulo-emissor_master/{emissor}")
	public ResponseEntity<Object> buscarTitulosMaster(@PathVariable(name = "emissor", required = true) String emissor) {
		return serviceBuscarMaster.buscarTitulosMaster(emissor);
	}

	@GetMapping(path = "/api/titulo-emissor/{emissor}")
	public ResponseEntity<Object> buscarTitulosOutrosEmissores(
			@PathVariable(name = "emissor", required = true) String emissor) {
		return serviceBuscarOutros.buscarTitulosOutrosEmissores(emissor);
	}

	@GetMapping(path = "api/lastro")
	public List<Titulo> buscarTituloLastro() {
		return serviceBuscarTodos.buscarLastro();

	}

}
