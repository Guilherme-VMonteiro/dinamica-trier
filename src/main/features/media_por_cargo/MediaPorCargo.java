package main.features.media_por_cargo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.utils.CargaDados;
import main.utils.DepartamentoEnum;
import main.utils.Funcionario;
import main.utils.MapeiaDados;

public class MediaPorCargo {
	

	Map<DepartamentoEnum, List<Funcionario>> mapaFunc = new MapeiaDados()
			.mapeiaFuncionariosPorCargo(CargaDados.getListaFuncionarios());

	public Map<DepartamentoEnum, BigDecimal> media(Map<DepartamentoEnum, List<Funcionario>> mapaFunc) {
		Map<DepartamentoEnum, BigDecimal> mapaMedias = new HashMap<>();

		for (DepartamentoEnum iterador : DepartamentoEnum.values()) {
			mapaMedias.put(iterador, BigDecimal.ZERO);
		}

		for (DepartamentoEnum iterador : DepartamentoEnum.values()) {
			List<Funcionario> funcionarios = mapaFunc.get(iterador);

			for (Funcionario func : funcionarios) {
				BigDecimal salarioAtual = mapaMedias.get(iterador);
				mapaMedias.put(iterador, salarioAtual.add(func.getSalario()));
			}
		}

		for (DepartamentoEnum departamento : DepartamentoEnum.values()) {
			List<Funcionario> funcionarios = mapaFunc.get(departamento);
			if (funcionarios != null && !funcionarios.isEmpty()) {
				BigDecimal soma = mapaMedias.get(departamento);
				BigDecimal media = soma.divide(BigDecimal.valueOf(funcionarios.size()), 2, RoundingMode.HALF_EVEN);
				mapaMedias.put(departamento, media);
			}
		}

		return mapaMedias;
	}
}
