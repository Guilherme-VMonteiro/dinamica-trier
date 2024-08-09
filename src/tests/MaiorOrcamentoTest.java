package tests;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.features.maior_orcamento.MaiorOrcamento;
import main.utils.DepartamentoEnum;
import main.utils.Funcionario;

class MaiorOrcamentoTest {

	@DisplayName("Deve retornar o valor do departamento com o maior orcamento")
	@Test
	public void testarMariorOrcamento() {

		Funcionario func1 = new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000"));
		Funcionario func2 = new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000"));
		Funcionario func3 = new Funcionario("Pedro Souza", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7000"));
		Funcionario func4 = new Funcionario("Carlos Alves", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9200"));

		Map<DepartamentoEnum, List<Funcionario>> mapaDeFuncionarios = new HashMap<>();

		mapaDeFuncionarios.put(DepartamentoEnum.ADMINISTRACAO, new ArrayList<>(Arrays.asList(func1, func4)));
		mapaDeFuncionarios.put(DepartamentoEnum.RH, new ArrayList<>(Arrays.asList(func2)));
		mapaDeFuncionarios.put(DepartamentoEnum.DESENVOLVIMENTO, new ArrayList<>(Arrays.asList(func3)));

		DepartamentoEnum resultado = new MaiorOrcamento().encontrarDepartamentoComMaiorOrcamento(mapaDeFuncionarios);

		Assertions.assertEquals(DepartamentoEnum.ADMINISTRACAO, resultado);
	}
}
