package br.edu.cruzeirodosul.service;

import br.edu.cruzeirodosul.model.ResultadosProvaDTO;

public class CorrecaoProvaService {

	public ResultadosProvaDTO obtemResultados(String numeroProva) {
		ResultadosProvaDTO resultado = new ResultadosProvaDTO();
		
		resultado.setProva(numeroProva);
		resultado.setNomeAluno("eder lino rodrigues".toUpperCase());
		resultado.setAusente("0");
		resultado.setRespostas("1059532333134234131255542312112200000000000000000000000000000000000000000000000000000000000000000000");
		resultado.setQuestoes(32);
		
		return resultado;
	}
	
}
