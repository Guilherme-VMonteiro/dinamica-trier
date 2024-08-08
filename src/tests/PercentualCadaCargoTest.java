package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.features.percentual_cada_cargo.PercentualCadaCargo;
import main.utils.CargaDados;
import main.utils.DepartamentoEnum;
import main.utils.MapeiaDados;

class PercentualCadaCargoTest {

	@DisplayName("Testar o buscaTotal, deve retornar o total de cada departamento") 
	@Test
	void deveRetornarTotalCadaTipoDeCargo() {
		
		PercentualCadaCargo percentualCadaCargo = new PercentualCadaCargo();
		Map<DepartamentoEnum, BigDecimal> retorno = percentualCadaCargo.quantidadeFuncionarios(new MapeiaDados().mapeiaFuncionariosPorCargo(new CargaDados().getListaFuncionarios()));
		assertEquals("{ADMINISTRACAO=17.143, DESENVOLVIMENTO=17.143, RH=17.143, QUALIDADE=15.714, VENDAS=15.714, SUPORTE=17.143}", retorno.toString());
	}

}
