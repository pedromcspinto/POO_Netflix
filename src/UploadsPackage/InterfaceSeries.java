package UploadsPackage;

public interface InterfaceSeries extends InterfaceUploads{
	/**
	 * Metodo que retorna o numero de seasons da serie
	 * @return numero de seasons do objeto
	 */
	int getSeasons();
	/**
	 * Metodo que retorna o numero de episodios total de uma serie
	 * @return retorna o numero de episodios do objeto
	 */
	int getEpisodes(); 
}
