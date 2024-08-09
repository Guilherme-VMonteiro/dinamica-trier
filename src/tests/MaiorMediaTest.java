package tests;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.features.maiormedia.MaiorMedia;
import main.features.media_por_cargo.MediaPorCargo;
import main.utils.DepartamentoEnum;
import main.utils.Funcionario;

class MaiorMediaTest {

	@DisplayName("Deve retornar o valor do departamento com o maior media salarial")
	@Test
	public void testeMaiorMediaSalarial() {

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		Funcionario func1 = new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000"));
		Funcionario func2 = new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000"));
		Funcionario func3 = new Funcionario("Pedro Souza", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7000"));
		Funcionario func4 = new Funcionario("Carlos Alves", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9200"));
		
		funcionarios.add(func1);
		funcionarios.add(func2);
		funcionarios.add(func3);
		funcionarios.add(func4);

		DepartamentoEnum resultado = new MaiorMedia().encontrarDepartamentoComMaiorMedia(MediaPorCargo.media(funcionarios));
		
		Assertions.assertEquals(DepartamentoEnum.ADMINISTRACAO, resultado);
		
	}

}
