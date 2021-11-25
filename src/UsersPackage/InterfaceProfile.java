package UsersPackage;

import java.util.Iterator;

import UploadsPackage.InterfaceUploads;

public interface InterfaceProfile{
	/**
	 * Metodo que retorna o nome do profile
	 * @return nome do objeto
	 */
	String getProfileName();
	/**
	 * Metodo que permite ao profile visualizar um filme, adicionando-o na arraylist dos ultimos/ultimas
	 * filmes/series vistas
	 * @param u, filme/serie a ser visualizada
	 */
	void Watch(InterfaceUploads u);
	/**
	 * Metodo de verificacao de condicao
	 * Verifica de a lista dos ultimos/ultimas filmes/series vistas esta vazio devolvendo true, caso contrario
	 * retorna false
	 * @return true/false
	 */
	boolean isEmptyWatch();
	/**
	 * Metodo que permite a um profile classificar um/uma filme/serie
	 * @param u, filme/serie a classificar
	 * @param rate, classificacao a dar ao/a filme/serie
	 */
	void rateFilm(InterfaceUploads u, int rate);
	/**
	 * Metodo que devolve o iterador da arraylist dos ultimos/ultimas filmes/series
	 * @return interador do arraylist watched
	 */
	public Iterator<InterfaceUploads> listLastWatched();
	/**
	 * Metodo que retorna o tamanho da arraylist watched
	 * @return tamanho da arraylist watched
	 */
	int getWatchSize();
	/**
	 * Metodo que retorna o iterator dos/das filmes/series que foramm classificados/classificadas
	 * @return iterator dos/das filmes/series que foramm classificados/classificadas
	 */
	Iterator<InterfaceUploads> listRated();
	/**
	 * Metodo que retorna o tamanho da arraylist dos/das filmes/series que obtiveram uma classificacao deste
	 * profile
	 * @return tamanho da arraylist rated
	 */
	int getRateSize();
	/**
	 * Metodo que verifica se a arraylist dos/das filmes/series está vazio retornando true, ou false no caso
	 * contrario
	 * @return true/false
	 */
	boolean isEmptyRate();
	/**
	 * Metodo que retorna o iterator das classificacoes dos/das filmes/series vistos
	 * @return iterator das classificacoes dos/das filmes/series vistos
	 */
	Iterator<Integer> listRates();
}
