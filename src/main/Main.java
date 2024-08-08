package main;

import javax.swing.JOptionPane;

import main.features.salariosMaiores.SalariosMaiores;
import main.utils.view.EntradaSaida;

public class Main {

	public static void main(String[] args) {

		int opcao;

		do {

			opcao = EntradaSaida.coletaOpcaoMenu();
			
			

			switch (opcao) {
				case 1: {
					JOptionPane.showMessageDialog(null, SalariosMaiores.listaMaioresSalarios(null));
					break;
				}
				case 2: {
	
					break;
				}
				case 3: {
					
					break;
				}
				case 4: {
	
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
