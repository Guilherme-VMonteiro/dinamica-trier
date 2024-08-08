package main;

import java.util.List;

import javax.swing.JOptionPane;

import main.features.calculo_impacto.CalculoImpacto;
import main.features.media_por_cargo.MediaPorCargo;
import main.features.percentual_cada_cargo.PercentualCadaCargo;
import main.features.salariosMaiores.SalariosMaiores;
import main.utils.CargaDados;
import main.utils.Formatador;
import main.utils.Funcionario;
import main.utils.MapeiaDados;
import main.utils.view.EntradaSaida;

public class Main {

	public static void main(String[] args) {

		List<Funcionario> dados = CargaDados.getListaFuncionarios();

		int opcao;

		do {

			opcao = EntradaSaida.coletaOpcaoMenu();

			switch (opcao) {
			case 1: {
				JOptionPane.showMessageDialog(null,
						Formatador.formatarListaDeFuncionarios(SalariosMaiores.listaMaioresSalarios(dados)));
				break;
			}
			case 2: {
				JOptionPane.showMessageDialog(null, "Média salarial por cargo:\n\n"
						+ Formatador.formatarMapaDeMediaSalarial(MediaPorCargo.media(dados)));
				break;
			}
			case 3: {
				JOptionPane.showMessageDialog(null,
						"Impacto do reajuste de 10%: R$" + CalculoImpacto.calcularImpactoDeAumento(dados));
				break;
			}
			case 4: {
				JOptionPane.showMessageDialog(null,
						"Percentual de funcionários para cada cargo:\n\n"
								+ Formatador.formatarMapaDePorcentagemDeFuncionarios(PercentualCadaCargo
										.quantidadeFuncionarios(new MapeiaDados().mapeiaFuncionariosPorCargo(dados))));

				break;
			}
			case 5: {

				break;
			}
			case 6: {

				break;
			}
			case 7: {

				break;
			}
			case 8: {

				break;
			}

			default: {
				JOptionPane.showMessageDialog(null, "Opcão inválida, tente novamente!");
			}
			}

		} while (opcao != 8);

	}

}
