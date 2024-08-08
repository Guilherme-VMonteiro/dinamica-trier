package main.features.percentual_cada_cargo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import main.utils.CargaDados;
import main.utils.DepartamentoEnum;
import main.utils.Funcionario;

public class PercentualCadaCargo {		
	public static Map<DepartamentoEnum, BigDecimal> quantidadeFuncionarios(Map<DepartamentoEnum, List<Funcionario>> mapeado) {
		Map<DepartamentoEnum, BigDecimal> mapaPorcentagem = new HashMap<>();
		int totalFunc = new CargaDados().getListaFuncionarios().size();
		for (DepartamentoEnum departamento: DepartamentoEnum.values()) {
			BigDecimal decimal = BigDecimal.valueOf(buscaTotal(new CargaDados().getListaFuncionarios(), departamento));
			mapaPorcentagem.put(departamento, decimal.multiply(BigDecimal.valueOf(100D)).divide(BigDecimal.valueOf(totalFunc), 3, RoundingMode.HALF_EVEN) );			
		}
		return mapaPorcentagem;
	}
	
	public static int buscaTotal(List<Funcionario> funcionarios, DepartamentoEnum departamento) {
		Map<DepartamentoEnum, Funcionario> mapaFuncionario = new HashMap<>();
		return funcionarios.stream().filter(f -> f.getCargo() == departamento).collect(Collectors.toList()).size();	
	}
}
