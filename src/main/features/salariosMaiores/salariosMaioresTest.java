package main.features.salariosMaiores;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.utils.DepartamentoEnum;
import main.utils.Funcionario;

class salariosMaioresTest {

	private List<Funcionario> lista;
	private static salariosMaiores salariosMaiores;

	@BeforeAll
	static void init() {
		salariosMaiores = new salariosMaiores();
	}

	@BeforeEach
	void limpaLista() {
		lista = new ArrayList<>();
	}

	@DisplayName("Se possuir um nulo, ele deverá pular e considerar o próximo")
	@Test
	void naoConsiderNulo() {

		lista.add(new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000")));
		lista.add(new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000")));
		lista.add(null);
		lista.add(new Funcionario("Ana Santos", DepartamentoEnum.SUPORTE, new BigDecimal("6000")));
		lista.add(new Funcionario("José Lima", DepartamentoEnum.QUALIDADE, new BigDecimal("5500")));

		lista = salariosMaiores.listaMaioresSalarios();
		
		assertFalse(lista.contains(null));
		//assertTrue(lista.contains("João Lima"));
	}

}
