package UsersPackage;

import java.util.*;

public interface InterfaceAccount {
	/**
	 * Metodo que retorna o nome da conta
	 * @return nome do objeto
	 */
	String getName();
	/**
	 * Metodo que retorna o email da conta
	 * @return email do objeto
	 */
	String getEmail();
	/**
	 * Metodo que retorna a password da conta
	 * @return password do objeto
	 */
	String getPassword();	
	/**
	 * Metodo que retorna o nome do dispositivo atualmente selecionado da conta
	 * @return dispositivo atualmente selecionado do objeto
	 */
	String getDevice();
	/**
	 * Metodo que retorna o numero de dispositivos da conta
	 * @return numero dispositivos do objeto
	 */
	int getNumDevices();
	/**
	 * Metodo que retona o nome de dispositivos conectados
	 * @return tamanho da arraylist dos dispositivos conectados
	 */
	int numConnectedDevices();
	/**
	 * Metodo que atualiza o ultimo dispositivo conectado com a conta
	 * @param dev dispositivo a ser conectado
	 */
	void lastConnected(String dev);
	/**
	 * Metodo que retorna o nome do ultimo dispositivo conectado
	 * @return nome do ultimo dispositivo conectado
	 */
	String getLast();
	/**
	 * Metodo que descobre o indice de um dispositivo dado o nome
	 * @param dev, nome do dispositivo
	 * @return indice do dispisitivo
	 */
	int indexOfDevice(String dev);
	/**
	 * Metodo que retorna o indice de um dispositivo conetado
	 * @param dev, indice do dispositivo
	 * @return indice do dispositivo conectado
	 */
	int indexOfConnected(String dev);
	/**
	 * Metodo que verifica se o dispositivo esta conectado, dando o nome do dispositivo devolvendo true, ou false 
	 * caso contrario
	 * @param dev, nome do dispositivo
	 * @return true/false
	 */
	boolean isConnected(String dev);
	/**
	 * Metodo que adiciona um dispositivo a conta
	 * @param dev nome do dispositivo a adicionar
	 */
	void addDevice(String dev);
	/**
	 * Metodo que faz a conexao de um dispositivo
	 * @param dev nome do dispositivo
	 */
	void connectDevice(String dev);
	/**
	 * Metodo que faz a desconexao de um dispositivo
	 * @param dev nome do dispositivo
	 */
	void disconnectDevice(String dev);
	/**
	 * Metodo que adiciona um novo profile a conta
	 * @param name, nome do profile a adicionar
	 * @param type, tipo do  profile a adicionar
	 * @param age, idade do perfil a adicionar
	 */
	void addProfile(String name, String type, int age);
	/**
	 * Metodo que procura o indice do profile dando o nome
	 * @param name, nome do dispositivo
	 * @return indice do dispositivo
	 */
	int searchIndexOfProfile(String name);
	/**
	 * Metodo de verificacao de condicao
	 * Verifica se a conta tem o profile, dando o nome devolvendo true, e falso caso contrario
	 * @param name, nome do profile
	 * @return true/false
	 */
	boolean hasProfile(String name);
	/**
	 * Metodo que retorna o numero de profiles que existem na conta
	 * @return numero de profiles existentes
	 */
	int getNumProfiles();
	/**
	 * Devolve o objeto Profile da conta, dando o nome do profile
	 * @param name nome do profile
	 * @return objeto profile associado ao nome
	 */
	InterfaceProfile getProfile(String name);
	/**
	 * Devolve o objeto Profile que esta selecionado atualmente
	 * @return objeto Profile que esta selecionado
	 */
	InterfaceProfile getSelectedProfile();
	/**
	 * Metodo que adiciona um novo plano a conta
	 */
	void addPlan();
	/**
	 * Metodo que retorna o objeto Plans da conta
	 * @return objeto plans
	 */
	InterfacePlans getPlan();
	/**
	 * Metodo que permite a atualizacao do plano da conta
	 * @param type, tipo do plano a ser atualizado para
	 */
	void setPlan(String type);
	/**
	 * Metodo que introduz na variavel oldPlans o ultimo plano da conta antes da ultima atualizacao do plano
	 */
	void planOld();
	/**
	 * Metodo que retorna o ultimo plano da conta antes da ultima atualizacao do plano
	 * @return
	 */
	String getOldPlan();
	/**
	 * Metodo que retorna o indice do dispositivo, dando o nome
	 * @param dev, nome do dispositivo
	 * @return indice do dispositivo
	 */
	int indexOfDevices(String dev);
	/**
	 * Metodo que permite selecionar um perfil
	 * @param p Objeto Profile a selecionar
	 */
	void SelectProfile(InterfaceProfile p);
	/**
	 * Metodo que devolve o iterador da arraylist dos profiles da conta
	 * @return iterador da arraylist profiles
	 */
	Iterator<InterfaceProfile> listProfiles();
	/**
	 * Metodo que devolve o nome tipo de plano da conta
	 * @return nome tipo de plano da conta
	 */
	String getTypeOfPlan();
	/**
	 * Metodo que devolve o iterador da arraylist dos dispositivos da conta
	 * @return iterador da arraylist devices
	 */
	Iterator<String> listDevices();
	/**
	 * Metodo que faz a disconexao do ultimo profile selecionado
	 */
	void disconnectProfile();
}
