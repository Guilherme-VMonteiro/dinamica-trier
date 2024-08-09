package main.features.maiormedia;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import main.utils.DepartamentoEnum;
import main.utils.Funcionario;

public class MaiorMedia {

    public static DepartamentoEnum encontrarDepartamentoComMaiorMedia(Map<DepartamentoEnum, List<Funcionario>> mapaDeFuncionarios) {
        DepartamentoEnum departamentoComMaiorMedia = null;
        BigDecimal maiorMedia = BigDecimal.ZERO;

        for (Map.Entry<DepartamentoEnum, List<Funcionario>> entry : mapaDeFuncionarios.entrySet()) {
            DepartamentoEnum departamento = entry.getKey();
            List<Funcionario> funcionarios = entry.getValue();

            BigDecimal somaSalarios = BigDecimal.ZERO;
            for (Funcionario funcionario : funcionarios) {
                somaSalarios = somaSalarios.add(funcionario.getSalario());
            }

            BigDecimal mediaSalarial = somaSalarios.divide(new BigDecimal(funcionarios.size()), RoundingMode.HALF_UP);

            if (mediaSalarial.compareTo(maiorMedia) > 0) {
                maiorMedia = mediaSalarial;
                departamentoComMaiorMedia = departamento;
            }
        }

        return departamentoComMaiorMedia;
    }
}
