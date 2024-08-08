package main.features.salariosMaiores;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import main.utils.CargaDados;
import main.utils.Funcionario;

public class salariosMaiores {

	public List<Funcionario> listaMaioresSalarios() {
		return CargaDados.getListaFuncionarios()
				.stream()
				.sorted(Comparator.comparing(Funcionario::getSalario).reversed())
				.limit(10)
				.collect(Collectors.toList());
	}
}