package main.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapeiaDados {

	public Map<DepartamentoEnum, List<Funcionario>> mapeiaFuncionariosPorCargo(List<Funcionario> funcionarios) {

		Map<DepartamentoEnum, List<Funcionario>> mapaDeFuncionarios = new HashMap<DepartamentoEnum, List<Funcionario>>();

		for (DepartamentoEnum departamento : DepartamentoEnum.values()) {
			mapaDeFuncionarios.put(departamento, new ArrayList<>());
		}

		for (Funcionario funcionario : funcionarios) {
			mapaDeFuncionarios.get(funcionario.getCargo()).add(funcionario);
		}

		return mapaDeFuncionarios;
	}
}
