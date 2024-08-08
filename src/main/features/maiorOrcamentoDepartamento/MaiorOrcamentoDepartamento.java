package main.features.maiorOrcamentoDepartamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import main.utils.CargaDados;
import main.utils.DepartamentoEnum;
import main.utils.Funcionario;

public class MaiorOrcamentoDepartamento {

	static List<Funcionario> rh;
	static List<Funcionario> desenvolvimento;
	static List<Funcionario> administracao;
	static List<Funcionario> qualidade;
	static List<Funcionario> suporte;
	static List<Funcionario> vendas;
	
	public static void separarCargos(List<Funcionario> listaSepara) {
		rh = listaSepara.stream().filter(r -> r.getCargo().equals(DepartamentoEnum.RH)).collect(Collectors.toList());
		desenvolvimento = listaSepara.stream().filter(r -> r.getCargo().equals(DepartamentoEnum.DESENVOLVIMENTO)).collect(Collectors.toList());
		administracao = listaSepara.stream().filter(r -> r.getCargo().equals(DepartamentoEnum.ADMINISTRACAO)).collect(Collectors.toList());
		qualidade = listaSepara.stream().filter(r -> r.getCargo().equals(DepartamentoEnum.QUALIDADE)).collect(Collectors.toList());
		suporte = listaSepara.stream().filter(r -> r.getCargo().equals(DepartamentoEnum.SUPORTE)).collect(Collectors.toList());
		vendas = listaSepara.stream().filter(r -> r.getCargo().equals(DepartamentoEnum.VENDAS)).collect(Collectors.toList());
	}
	
	public static BigDecimal somaCargo(List<Funcionario> listaSoma) {
		
		
	}
}