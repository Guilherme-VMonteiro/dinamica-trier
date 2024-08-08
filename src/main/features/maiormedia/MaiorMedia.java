package main.features.maiormedia;

import java.math.BigDecimal;
import java.util.Map;

import main.utils.DepartamentoEnum;

public class MaiorMedia {


	    public DepartamentoEnum encontrarDepartamentoComMaiorMedia(Map<DepartamentoEnum, BigDecimal> mapaMedias) {
	        DepartamentoEnum departamentoComMaiorMedia = null;
	        BigDecimal maiorMedia = BigDecimal.ZERO;

	        for (Map.Entry<DepartamentoEnum, BigDecimal> entry : mapaMedias.entrySet()) {
	            if (entry.getValue().compareTo(maiorMedia) > 0) {
	                maiorMedia = entry.getValue();
	                departamentoComMaiorMedia = entry.getKey();
	            }
	        }

	        return departamentoComMaiorMedia;
	    }
	


}
