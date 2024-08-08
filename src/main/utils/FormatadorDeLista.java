package main.utils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class FormatadorDeLista {

	public static String formatarListaDeFuncionarios(List<Funcionario> funcionarios) {

		List<String> funcionariosString = funcionarios.stream()
				.map(funcionario -> "Funcionario: " + funcionario.getNome() + " - Departamento: "
						+ funcionario.getCargo() + " - Salário: R$" + String.format("%.2f", funcionario.getSalario())
						+ "\n")
				.collect(Collectors.toList());

		StringBuilder builder = new StringBuilder();

		for (String string : funcionariosString) {
			builder.append(string);
		}

		return builder.toString();
	}
	
}
