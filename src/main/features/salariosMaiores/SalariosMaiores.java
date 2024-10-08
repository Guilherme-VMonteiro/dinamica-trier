package main.features.salariosMaiores;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import main.utils.Funcionario;

public class SalariosMaiores {

	public static List<Funcionario> listaMaioresSalarios(List<Funcionario> list) {

		return list
			.stream()
			.filter(Objects::nonNull)
			.sorted(Comparator.comparing(Funcionario::getSalario).reversed())
			.limit(10)
			.collect(Collectors.toList());
	}
}