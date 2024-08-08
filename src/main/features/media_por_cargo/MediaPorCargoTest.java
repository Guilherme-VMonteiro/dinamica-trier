package main.features.media_por_cargo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.utils.DepartamentoEnum;
import main.utils.Funcionario;

class MediaPorCargoTest {

    @DisplayName("testando a media do programa")
    @Test
    public void testandoRetornoMedia() {
    	
  

        Funcionario func1 = new Funcionario("João", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("2000.00"));
        Funcionario func2 = new Funcionario("Maria", DepartamentoEnum.RH, new BigDecimal("3000.00"));
        Funcionario func3 = new Funcionario("Carlos", DepartamentoEnum.RH, new BigDecimal("4000.00"));

        Map<DepartamentoEnum, List<Funcionario>> mapaFunc = new HashMap<>();
        mapaFunc.put(DepartamentoEnum.ADMINISTRACAO, Arrays.asList(func1));
        mapaFunc.put(DepartamentoEnum.RH, Arrays.asList(func2, func3));

        Map<DepartamentoEnum, BigDecimal> resultado = calcularMediaPorDepartamento(mapaFunc);

        assertEquals(new BigDecimal("2000.00"), resultado.get(DepartamentoEnum.ADMINISTRACAO));
        assertEquals(new BigDecimal("3500.00"), resultado.get(DepartamentoEnum.RH)); 
    }

    private Map<DepartamentoEnum, BigDecimal> calcularMediaPorDepartamento(Map<DepartamentoEnum, List<Funcionario>> mapaFunc) {
        Map<DepartamentoEnum, BigDecimal> mediaPorDepartamento = new HashMap<>();

        for (Map.Entry<DepartamentoEnum, List<Funcionario>> entry : mapaFunc.entrySet()) {
            DepartamentoEnum departamento = entry.getKey();
            List<Funcionario> funcionarios = entry.getValue();

            BigDecimal somaSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal media = somaSalarios.divide(BigDecimal.valueOf(funcionarios.size()), 2, RoundingMode.HALF_EVEN);
            mediaPorDepartamento.put(departamento, media);
        }

        return mediaPorDepartamento;
    }
}
