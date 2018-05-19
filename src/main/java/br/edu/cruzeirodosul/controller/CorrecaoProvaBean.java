package br.edu.cruzeirodosul.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.xml.bind.DatatypeConverter;

import br.edu.cruzeirodosul.model.ResultadosProvaDTO;
import br.edu.cruzeirodosul.service.CorrecaoProvaService;

@ManagedBean
public class CorrecaoProvaBean {

	private String imageBase64_1;
	private String imageBase64_2;
	private String imageBase64_3;
	private String imageBase64_4;

	private CorrecaoProvaService correcaoProvaService;

	private BufferedImage bufferedImg = null;
	private List<Integer> listaQuestoes;
	private ResultadosProvaDTO resultados;
	private String numeroProva;

	private Integer linha = 225;
	private Integer incremento = 38;

	private Integer coluna101 = 110;
	private Integer coluna102 = 156;
	private Integer coluna103 = 202;
	private Integer coluna104 = 248;
	private Integer coluna105 = 294;

	private Integer coluna201 = 420;
	private Integer coluna202 = 466;
	private Integer coluna203 = 512;
	private Integer coluna204 = 558;
	private Integer coluna205 = 604;

	private Integer coluna301 = 730;
	private Integer coluna302 = 776;
	private Integer coluna303 = 822;
	private Integer coluna304 = 868;
	private Integer coluna305 = 914;

	private Integer coluna401 = 1050;
	private Integer coluna402 = 1096;
	private Integer coluna403 = 1142;
	private Integer coluna404 = 1188;
	private Integer coluna405 = 1234;

	@PostConstruct
	public void init() {

		this.imageBase64_1 = obtemBase64("/home/eric/cadernos/p1.jpg");
		this.imageBase64_2 = obtemBase64("/home/eric/cadernos/p2.jpg");
		this.imageBase64_3 = obtemBase64("/home/eric/cadernos/p3.jpg");
		this.imageBase64_4 = obtemBase64("/home/eric/cadernos/p4.jpg");

		correcaoProvaService = new CorrecaoProvaService();

		this.numeroProva = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("prova");

		resultados = correcaoProvaService.obtemResultados(this.numeroProva);

		this.listaQuestoes = new ArrayList<>();

		Integer x;
		for (x = 0; x < 25; x++) {
			listaQuestoes.add(x);
		}

	}

	private String obtemBase64(String arquivo) {
		String retorno;
		File arq1 = new File(arquivo);
		byte[] imageBytes = null;
		try {
			imageBytes = Files.readAllBytes(arq1.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		retorno = "data:application/pdf;base64," + DatatypeConverter.printBase64Binary(imageBytes);
		return retorno;
	}

	public String opcaoDM(int coluna, int pergunta) {
		int posicao = retornaPosicao(coluna, pergunta);
		if (this.resultados.getRespostas().substring(posicao, posicao + 1).equals("9")) {
			return "block";
		} else {
			return "none";
		}
	}

	public String opcaoSM(int coluna, int pergunta) {
		int posicao = retornaPosicao(coluna, pergunta);
		if ((posicao < this.resultados.getQuestoes())
				&& (this.resultados.getRespostas().substring(posicao, posicao + 1).equals("0"))) {
			return "block";
		} else {
			return "none";
		}
	}

	private int retornaPosicao(int coluna, int pergunta) {
		int posicao = 0;
		if (coluna == 4) {
			posicao = 75 + pergunta;
		} else if (coluna == 3) {
			posicao = 50 + pergunta;
		} else if (coluna == 2) {
			posicao = 25 + pergunta;
		} else if (coluna == 1) {
			posicao = pergunta;
		}
		return posicao;
	}

	public String opcao(int coluna, int pergunta, int resposta) {
		String retorno = "";
		int posicao = retornaPosicao(coluna, pergunta);
		try {
			if (this.resultados.getRespostas().substring(posicao, posicao + 1).equals(Integer.toString(resposta))) {
				retorno = "checked";
			} else {
				retorno = "";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}

	public BufferedImage getBufferedImg() {
		return bufferedImg;
	}

	public void setBufferedImg(BufferedImage bufferedImg) {
		this.bufferedImg = bufferedImg;
	}

	public List<Integer> getListaQuestoes() {
		return listaQuestoes;
	}

	public void setListaQuestoes(List<Integer> listaQuestoes) {
		this.listaQuestoes = listaQuestoes;
	}

	public String getNumeroProva() {
		return numeroProva;
	}

	public void setNumeroProva(String numeroProva) {
		this.numeroProva = numeroProva;
	}

	public ResultadosProvaDTO getResultados() {
		return resultados;
	}

	public void setResultados(ResultadosProvaDTO resultados) {
		this.resultados = resultados;
	}

	public Integer getLinha() {
		return linha;
	}

	public void setLinha(Integer linha) {
		this.linha = linha;
	}

	public Integer getIncremento() {
		return incremento;
	}

	public void setIncremento(Integer incremento) {
		this.incremento = incremento;
	}

	public Integer getColuna101() {
		return coluna101;
	}

	public void setColuna101(Integer coluna101) {
		this.coluna101 = coluna101;
	}

	public Integer getColuna102() {
		return coluna102;
	}

	public void setColuna102(Integer coluna102) {
		this.coluna102 = coluna102;
	}

	public Integer getColuna103() {
		return coluna103;
	}

	public void setColuna103(Integer coluna103) {
		this.coluna103 = coluna103;
	}

	public Integer getColuna104() {
		return coluna104;
	}

	public void setColuna104(Integer coluna104) {
		this.coluna104 = coluna104;
	}

	public Integer getColuna105() {
		return coluna105;
	}

	public void setColuna105(Integer coluna105) {
		this.coluna105 = coluna105;
	}

	public Integer getColuna201() {
		return coluna201;
	}

	public void setColuna201(Integer coluna201) {
		this.coluna201 = coluna201;
	}

	public Integer getColuna202() {
		return coluna202;
	}

	public void setColuna202(Integer coluna202) {
		this.coluna202 = coluna202;
	}

	public Integer getColuna203() {
		return coluna203;
	}

	public void setColuna203(Integer coluna203) {
		this.coluna203 = coluna203;
	}

	public Integer getColuna204() {
		return coluna204;
	}

	public void setColuna204(Integer coluna204) {
		this.coluna204 = coluna204;
	}

	public Integer getColuna205() {
		return coluna205;
	}

	public void setColuna205(Integer coluna205) {
		this.coluna205 = coluna205;
	}

	public Integer getColuna301() {
		return coluna301;
	}

	public void setColuna301(Integer coluna301) {
		this.coluna301 = coluna301;
	}

	public Integer getColuna302() {
		return coluna302;
	}

	public void setColuna302(Integer coluna302) {
		this.coluna302 = coluna302;
	}

	public Integer getColuna303() {
		return coluna303;
	}

	public void setColuna303(Integer coluna303) {
		this.coluna303 = coluna303;
	}

	public Integer getColuna304() {
		return coluna304;
	}

	public void setColuna304(Integer coluna304) {
		this.coluna304 = coluna304;
	}

	public Integer getColuna305() {
		return coluna305;
	}

	public void setColuna305(Integer coluna305) {
		this.coluna305 = coluna305;
	}

	public Integer getColuna401() {
		return coluna401;
	}

	public void setColuna401(Integer coluna401) {
		this.coluna401 = coluna401;
	}

	public Integer getColuna402() {
		return coluna402;
	}

	public void setColuna402(Integer coluna402) {
		this.coluna402 = coluna402;
	}

	public Integer getColuna403() {
		return coluna403;
	}

	public void setColuna403(Integer coluna403) {
		this.coluna403 = coluna403;
	}

	public Integer getColuna404() {
		return coluna404;
	}

	public void setColuna404(Integer coluna404) {
		this.coluna404 = coluna404;
	}

	public Integer getColuna405() {
		return coluna405;
	}

	public void setColuna405(Integer coluna405) {
		this.coluna405 = coluna405;
	}

	public String getImageBase64_1() {
		return imageBase64_1;
	}

	public void setImageBase64_1(String imageBase64_1) {
		this.imageBase64_1 = imageBase64_1;
	}

	public String getImageBase64_2() {
		return imageBase64_2;
	}

	public void setImageBase64_2(String imageBase64_2) {
		this.imageBase64_2 = imageBase64_2;
	}

	public String getImageBase64_3() {
		return imageBase64_3;
	}

	public void setImageBase64_3(String imageBase64_3) {
		this.imageBase64_3 = imageBase64_3;
	}

	public String getImageBase64_4() {
		return imageBase64_4;
	}

	public void setImageBase64_4(String imageBase64_4) {
		this.imageBase64_4 = imageBase64_4;
	}

}
