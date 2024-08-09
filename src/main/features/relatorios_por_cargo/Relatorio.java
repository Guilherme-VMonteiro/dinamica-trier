package main.features.relatorios_por_cargo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import main.utils.DepartamentoEnum;
import main.utils.Funcionario;

public class Relatorio {

	public static String gerarRelatorio(Map<DepartamentoEnum, List<Funcionario>> mapaDepartamentos) {

		StringBuilder builder = new StringBuilder();

		for (DepartamentoEnum departamento : DepartamentoEnum.values()) {
			builder.append("Departamento: " + departamento + " - Menor salário: R$"
					+ coletaMenorSalario(mapaDepartamentos.get(departamento)) + " - Maior salário: R$"
					+ coletaMaiorSalario(mapaDepartamentos.get(departamento)) + " - Média salarial: R$"
					+ coletaMediaDeSalario(mapaDepartamentos.get(departamento)) + " - Moda: R$"
					+ coletaModaSalarios(mapaDepartamentos.get(departamento)) + " - Mediana: R$"
					+ coletaMedianaSalarios(mapaDepartamentos.get(departamento)) + "\n");
		}

		return builder.toString();
	}

	public static BigDecimal coletaMaiorSalario(List<Funcionario> funcionarios) {
		return BigDecimal
				.valueOf(funcionarios.stream().map(funcionario -> funcionario.getSalario())
						.mapToDouble(salario -> salario.doubleValue()).max().orElse(0))
				.setScale(2, RoundingMode.HALF_EVEN);
	}

	public static BigDecimal coletaMenorSalario(List<Funcionario> funcionarios) {
		return BigDecimal
				.valueOf(funcionarios.stream().map(funcionario -> funcionario.getSalario())
						.mapToDouble(salario -> salario.doubleValue()).min().orElse(0))
				.setScale(2, RoundingMode.HALF_EVEN);
	}

	public static BigDecimal coletaMediaDeSalario(List<Funcionario> funcionarios) {
		return BigDecimal
				.valueOf(funcionarios.stream().map(funcionario -> funcionario.getSalario())
						.mapToDouble(salario -> salario.doubleValue()).average().orElse(0))
				.setScale(2, RoundingMode.HALF_EVEN);
	}

	public static BigDecimal coletaMedianaSalarios(List<Funcionario> funcionarios) {

		if (funcionarios.size() >= 2) {
			if (funcionarios.size() % 2 == 0) {
				if (funcionarios.size() == 2) {
					return funcionarios.stream().map(funcionario -> funcionario.getSalario()).sorted()
							.collect(Collectors.toList()).get(0)
							.add(funcionarios.stream().map(funcionario -> funcionario.getSalario()).sorted()
									.collect(Collectors.toList()).get(1))
							.divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_EVEN);

				}
				return funcionarios.stream().map(funcionario -> funcionario.getSalario()).sorted()
						.collect(Collectors.toList()).get(((funcionarios.size() - 1) / 2))
						.add(funcionarios.stream().map(funcionario -> funcionario.getSalario()).sorted()
								.collect(Collectors.toList()).get(((funcionarios.size() - 1) / 2) + 1))
						.divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_EVEN);
			}

			return funcionarios.stream().map(funcionario -> funcionario.getSalario()).sorted()
					.collect(Collectors.toList()).get((funcionarios.size() - 1) / 2)
					.setScale(2, RoundingMode.HALF_EVEN);

		}

		return funcionarios.isEmpty() ? BigDecimal.ZERO
				: funcionarios.get(0).getSalario().setScale(2, RoundingMode.HALF_EVEN);

	}

	public static BigDecimal coletaModaSalarios(List<Funcionario> funcionarios) {
		Map<BigDecimal, Integer> mapaFrequencia = new HashMap<BigDecimal, Integer>();

		for (Funcionario funcionario : funcionarios) {
			mapaFrequencia.put(funcionario.getSalario(), mapaFrequencia.getOrDefault(funcionario.getSalario(), 0) + 1);
		}

		BigDecimal moda = BigDecimal.ZERO;
		int maiorFrequencia = 0;

		for (BigDecimal salario : mapaFrequencia.keySet()) {
			if (mapaFrequencia.get(salario) > maiorFrequencia) {
				maiorFrequencia = mapaFrequencia.get(salario);
				moda = salario;
			}
		}

		return moda.setScale(2, RoundingMode.HALF_EVEN);
	}
}
