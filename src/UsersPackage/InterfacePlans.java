package UsersPackage;

public interface InterfacePlans {
	/**
	 * Metodo que retorna o maximo de dispositivos que cada tipo de plano pode ter
	 * @return maximo de devices
	 */
	int getDevices();
	/**
	 * Metodo que retorna o maximo de profiles que cada tipo de plano pode ter
	 * @return maximo de profiles
	 */
	int getProfiles();
	/**
	 * Metodo que retorna o nome de um plano
	 * @return nome do plano
	 */
	String getName();
}
