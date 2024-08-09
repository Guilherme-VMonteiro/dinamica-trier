package main.features.maior_orcamento;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import main.utils.CargaDados;
import main.utils.DepartamentoEnum;
import main.utils.Funcionario;
import main.utils.MapeiaDados;

public class MaiorOrcamento {
	

	public static DepartamentoEnum encontrarDepartamentoComMaiorOrcamento(
		Map<DepartamentoEnum, List<Funcionario>> mapaDeFuncionarios) {
		DepartamentoEnum departamentoComMaiorOrcamento = null;
		BigDecimal maiorOrcamento = BigDecimal.ZERO;

		for (Map.Entry<DepartamentoEnum, List<Funcionario>> entry : mapaDeFuncionarios.entrySet()) {
			DepartamentoEnum departamento = entry.getKey();
			List<Funcionario> funcionarios = entry.getValue();

			BigDecimal orcamentoTotal = BigDecimal.ZERO;
			for (Funcionario funcionario : funcionarios) {
				orcamentoTotal = orcamentoTotal.add(funcionario.getSalario());
			}

			if (orcamentoTotal.compareTo(maiorOrcamento) > 0) {
				maiorOrcamento = orcamentoTotal;
				departamentoComMaiorOrcamento = departamento;
			}
		}

		return departamentoComMaiorOrcamento;

	}
}
