package tests;

import static org.junit.jupiter.api.Assertions.*;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.features.calculo_impacto.CalculoImpacto;
import main.utils.DepartamentoEnum;
import main.utils.Funcionario;

class CalculoImpactoTest {

	private static CalculoImpacto calculoImpacto;
	private List<Funcionario> funcionarios;

	@BeforeAll
	static void init() {
		calculoImpacto = new CalculoImpacto();
	}

	@DisplayName("Deve retornar o valor do impacto")
	@Test
	void deveRetornarOValorDoImpactoEmReais() {
		funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000")));
		funcionarios.add(new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000")));
		funcionarios.add(new Funcionario("Pedro Souza", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7000")));
		funcionarios.add(new Funcionario("Ana Santos", DepartamentoEnum.SUPORTE, new BigDecimal("6000")));
		funcionarios.add(new Funcionario("José Lima", DepartamentoEnum.QUALIDADE, new BigDecimal("5500")));
		funcionarios.add(new Funcionario("Paula Rocha", DepartamentoEnum.VENDAS, new BigDecimal("7500")));
		funcionarios.add(new Funcionario("Carlos Alves", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9200")));
		funcionarios.add(new Funcionario("Fernanda Ribeiro", DepartamentoEnum.RH, new BigDecimal("8100")));
		funcionarios.add(new Funcionario("Lucas Fernandes", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7200")));
		funcionarios.add(new Funcionario("Juliana Costa", DepartamentoEnum.SUPORTE, new BigDecimal("6100")));
		
		BigDecimal bd = BigDecimal.valueOf(7360.00).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal retorno = calculoImpacto.calcularImpactoDeAumento(funcionarios);
		assertEquals(bd, retorno.setScale(2, RoundingMode.HALF_EVEN));
	}

	@DisplayName("Deve retornar o valor 0.00")
	@Test
	void ListaFuncionariosVazio() {
		funcionarios = new ArrayList<>();
		BigDecimal bd = BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal retorno = calculoImpacto.calcularImpactoDeAumento(funcionarios);
		assertEquals(bd, retorno.setScale(2, RoundingMode.HALF_EVEN));
	}

}
