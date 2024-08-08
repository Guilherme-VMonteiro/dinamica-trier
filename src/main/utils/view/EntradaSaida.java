package main.utils.view;

import java.util.Objects;

import javax.swing.JOptionPane;

public class EntradaSaida {

	public static int coletaOpcaoMenu() {

		String opcao = JOptionPane.showInputDialog("Sistema Relatório TelecoTeco Telecom\n\n"
				+ "1 - 10 maiores salários da empresa\n" + "2 - Média de salário por cargo\n"
				+ "3 - Impacto do reajuste de 10%\n" + "4 - Percentual de funcionários para cada cargo\n"
				+ "5 - Menor salário, maior, média, moda e mediana\n" + "6 - Departamento com maior orçamento\n"
				+ "7 - Departamento com maior média salarial\n\n" + "8 - Sair");

		try {

			if (Objects.isNull(opcao)) {
				throw new NullPointerException();
			}

			return Integer.parseInt(opcao);

		} catch (NullPointerException e) {
			// SAIR
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente!");
			return coletaOpcaoMenu();
		}

		return 8;
	}
	
	
}
