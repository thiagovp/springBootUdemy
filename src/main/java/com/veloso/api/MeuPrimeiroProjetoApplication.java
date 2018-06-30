package com.veloso.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.veloso.api.entities.Empresa;
import com.veloso.api.repositories.EmpresaRepository;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
		System.out.println("Meu primeiro projeto...");
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		/*return args -> {
			System.out.println("### Quantidade de elementos por página = "+this.qtdPorPagina);
		};*/
		
		return args ->{
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Veloso TI");
			empresa.setCnpj("71770169000179");
			
			this.empresaRepository.save(empresa);
			
			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			Empresa empresaDb = empresaRepository.findById(1L).get();
			System.out.println("Empresa por ID: "+empresaDb);
			
			empresaDb.setRazaoSocial("Veloso TI Web");
			this.empresaRepository.save(empresaDb);
			
			Empresa empresaCnpj = empresaRepository.findByCnpj("71770169000179");
			System.out.println("Empresa por CNPJ: "+empresaCnpj);
			
			this.empresaRepository.deleteById(1L);
			empresas = empresaRepository.findAll();
			System.out.println("Empresas: "+empresas.size());
		};
	}
	
}
