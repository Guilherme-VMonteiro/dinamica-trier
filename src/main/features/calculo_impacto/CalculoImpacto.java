package main.features.calculo_impacto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import main.utils.Funcionario;

public class CalculoImpacto {

	public static BigDecimal calcularImpactoDeAumento(List<Funcionario> funcionarios) {
		BigDecimal somaSalario = new BigDecimal(0);
		BigDecimal porcentagem = new BigDecimal(1.1);
		somaSalario = funcionarios.stream().map(Funcionario::getSalario).reduce(somaSalario, BigDecimal::add);

		BigDecimal impacto = somaSalario.multiply(porcentagem);
		return impacto.subtract(somaSalario).setScale(2, RoundingMode.HALF_EVEN);
	}
}
