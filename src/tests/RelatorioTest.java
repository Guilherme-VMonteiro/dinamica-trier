package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.features.relatorios_por_cargo.Relatorio;
import main.utils.DepartamentoEnum;
import main.utils.Funcionario;
import main.utils.MapeiaDados;

class RelatorioTest {

	private static List<Funcionario> funcionarios;
	private static Map<DepartamentoEnum, List<Funcionario>> mapFuncionarios;

	@BeforeAll
	static void init() {
		funcionarios = new ArrayList<Funcionario>();

		funcionarios.add(new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000")));
		funcionarios.add(new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000")));
		funcionarios.add(new Funcionario("Pedro Souza", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7000")));
		funcionarios.add(new Funcionario("Ana Santos", DepartamentoEnum.SUPORTE, new BigDecimal("100")));
		funcionarios.add(new Funcionario("Paula Rocha", DepartamentoEnum.VENDAS, new BigDecimal("7500")));
		funcionarios.add(new Funcionario("Carlos Alves", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9200")));
		funcionarios.add(new Funcionario("Fernanda Ribeiro", DepartamentoEnum.RH, new BigDecimal("8100")));
		funcionarios.add(new Funcionario("Juliana Costa", DepartamentoEnum.SUPORTE, new BigDecimal("6100")));
		funcionarios.add(new Funcionario("Camila Lima", DepartamentoEnum.VENDAS, new BigDecimal("17600")));
		funcionarios.add(new Funcionario("Bruno Gomes", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9400")));
		funcionarios.add(new Funcionario("Renata Martins", DepartamentoEnum.SUPORTE, new BigDecimal("6200")));
		funcionarios.add(new Funcionario("Beatriz Araujo", DepartamentoEnum.VENDAS, new BigDecimal("7700")));
		funcionarios.add(new Funcionario("André Melo", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9600")));
		funcionarios.add(new Funcionario("Letícia Santos", DepartamentoEnum.SUPORTE, new BigDecimal("6300")));

		mapFuncionarios = new MapeiaDados().mapeiaFuncionariosPorCargo(funcionarios);
	}

	@Test
	void deveColetarOMaiorSalario() {
		BigDecimal maiorSalario = Relatorio.coletaMaiorSalario(funcionarios);
		assertEquals(BigDecimal.valueOf(17600.00).setScale(2), maiorSalario);
	}

	@Test
	void deveColetarOMenorSalario() {
		BigDecimal maiorSalario = Relatorio.coletaMenorSalario(funcionarios);
		assertEquals(BigDecimal.valueOf(100.00).setScale(2), maiorSalario);
	}

	@Test
	void deveColetarAMedianaDosSalarios() {

		BigDecimal medianaRH = Relatorio.coletaMedianaSalarios(mapFuncionarios.get(DepartamentoEnum.RH));
		BigDecimal medianaADM = Relatorio.coletaMedianaSalarios(mapFuncionarios.get(DepartamentoEnum.ADMINISTRACAO));
		BigDecimal medianaDEV = Relatorio.coletaMedianaSalarios(mapFuncionarios.get(DepartamentoEnum.DESENVOLVIMENTO));
		BigDecimal medianaSUP = Relatorio.coletaMedianaSalarios(mapFuncionarios.get(DepartamentoEnum.SUPORTE));
		BigDecimal medianaQUA = Relatorio.coletaMedianaSalarios(mapFuncionarios.get(DepartamentoEnum.QUALIDADE));
		BigDecimal medianaVENDAS = Relatorio.coletaMedianaSalarios(mapFuncionarios.get(DepartamentoEnum.VENDAS));

		assertEquals(BigDecimal.valueOf(8050.00).setScale(2), medianaRH);
		assertEquals(BigDecimal.valueOf(9300.00).setScale(2), medianaADM);
		assertEquals(BigDecimal.valueOf(7000.00).setScale(2), medianaDEV);
		assertEquals(BigDecimal.valueOf(6150.00).setScale(2), medianaSUP);
		assertEquals(BigDecimal.valueOf(0), medianaQUA);
		assertEquals(BigDecimal.valueOf(7700.00).setScale(2), medianaVENDAS);
	}

	@Test
	void deveColetarAModaDosSalarios() {
		BigDecimal modaRH = Relatorio.coletaModaSalarios(mapFuncionarios.get(DepartamentoEnum.RH));
		BigDecimal modaADM = Relatorio.coletaModaSalarios(mapFuncionarios.get(DepartamentoEnum.ADMINISTRACAO));
		BigDecimal modaDEV = Relatorio.coletaModaSalarios(mapFuncionarios.get(DepartamentoEnum.DESENVOLVIMENTO));
		BigDecimal modaSUP = Relatorio.coletaModaSalarios(mapFuncionarios.get(DepartamentoEnum.SUPORTE));
		BigDecimal modaQUA = Relatorio.coletaModaSalarios(mapFuncionarios.get(DepartamentoEnum.QUALIDADE));
		BigDecimal modaVENDAS = Relatorio.coletaModaSalarios(mapFuncionarios.get(DepartamentoEnum.VENDAS));

		assertEquals(BigDecimal.valueOf(8000.00).setScale(2), modaRH);
		assertEquals(BigDecimal.valueOf(9200.00).setScale(2), modaADM);
		assertEquals(BigDecimal.valueOf(7000.00).setScale(2), modaDEV);
		assertEquals(BigDecimal.valueOf(6300.00).setScale(2), modaSUP);
		assertEquals(BigDecimal.valueOf(0.00).setScale(2), modaQUA);
		assertEquals(BigDecimal.valueOf(7500.00).setScale(2), modaVENDAS);
	}

	@Test
	void deveGerarORelatorio() {
		String relatorio = Relatorio.gerarRelatorio(mapFuncionarios);

		assertEquals(
				"Departamento: RH - Menor salário: R$8000.00 - Maior salário: R$8100.00 - Média salarial: R$8050.00 - Moda: R$8000.00 - Mediana: R$8050.00\n"
						+ "Departamento: ADMINISTRACAO - Menor salário: R$9000.00 - Maior salário: R$9600.00 - Média salarial: R$9300.00 - Moda: R$9200.00 - Mediana: R$9300.00\n"
						+ "Departamento: DESENVOLVIMENTO - Menor salário: R$7000.00 - Maior salário: R$7000.00 - Média salarial: R$7000.00 - Moda: R$7000.00 - Mediana: R$7000.00\n"
						+ "Departamento: SUPORTE - Menor salário: R$100.00 - Maior salário: R$6300.00 - Média salarial: R$4675.00 - Moda: R$6300.00 - Mediana: R$6150.00\n"
						+ "Departamento: QUALIDADE - Menor salário: R$0.00 - Maior salário: R$0.00 - Média salarial: R$0.00 - Moda: R$0.00 - Mediana: R$0\n"
						+ "Departamento: VENDAS - Menor salário: R$7500.00 - Maior salário: R$17600.00 - Média salarial: R$10933.33 - Moda: R$7500.00 - Mediana: R$7700.00\n"
						+ "",
				relatorio);
	}

}
