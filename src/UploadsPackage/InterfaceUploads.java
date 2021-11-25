package UploadsPackage;

import java.util.Iterator;

public interface InterfaceUploads extends Comparable<String>{
	/**
	 * Metodo que devolve o iterador do arraylist dos atores
	 * @return iterador do arraylist cast do objeto
	 */
	Iterator<String> listCast();
	/**
	 * Metodo que, apartir de uma string separa os numeros inteiros para poder obter em inteiro
	 * a classificacao etaria do/da filme/serie, dado que a classificacao etaria de cada filme/serie
	 * e lida na forma de string
	 */
	void Split();
	/**
	 * Metodo que retorna a data de lancamento de um/uma filme/serie
	 * @return data de lancamento do objeto
	 */
	int getRelease();
	/**
	 * Metodo que retorna a classificacao etaria do/da filme/serie em inteiro
	 * @return classificacao etaria do objeto
	 */
	int getSplit();
	/**
	 * Metodo que retorna a classificacao media do/da filme/serie
	 * @return classificacao media do objeto
	 */
	float getRate();
	/**
	 * Metodo que retorna o titulo de um/uma filme/serie
	 * @return titulo do objeto
	 */
	String getTitle();
	/**
	 * Metodo que retorna o diretor/criador do/da filme/serie
	 * @return diretor/criador do objeto
	 */
	String getDirector();
	/**
	 * Metodo que retorna a classificacao etaria do/da filme/serie
	 * @return classificacao do etaria do objeto
	 */
	String getAge();
	/**
	 * Metodo que retorna o genero do/da filme/serie
	 * @return genero do objeto
	 */
	String getGenre();
	/**
	 * Metodo que adiciona uma classificacao ao/a filme/serie
	 * @param i, classificacao a adicionar
	 */
	void rate(int i);	
	/**
	 * Metodo que permte comparar este objeto com outro, neste caso comparando titulos
	 */
	int compareTo(String title);
	/**
	 * Metodo que retorna uma representação string do objeto
	 * @return representação string do objeto
	 */
	abstract String toString();
}
