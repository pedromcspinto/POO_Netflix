package Netflix;

import java.util.*;

import ExceptionPackage.*;
import UploadsPackage.*;
import UsersPackage.*;

public interface InterfaceNetflix {
	
	/**
	 * Metodo que adiciona objetos da classe FilmClass e da classe SerieClass nos mapas, title e genre
	 * e nas colecoes CompareByTitle e CompareBydate
	 * @param title, nome do titulo do filme/serie
	 * @param genre, genero do filme/serie
	 * @param t, Objeto da classe FilmClass/SerieClass
	 */
	public void addUpload(String title, String genre, InterfaceUploads t);
	/**
	 * Metodo auxiliar ao metodo addUpload, que adiciona objetos da classe FilmClass e da classe
	 *  SerieClass no map actors, tendo atores e diretores como chaves
	 * @param director, nome do diretor/criador do objeto da classe FilmClass/SerieClass
	 * @param cast, arraylist de atores do objeto da classe FilmClass/SerieClass
	 * @param t, Objeto da classe FilmClass/SerieClass
	 */
	public void AuxListByNameMap(String director, List<String> cast, InterfaceUploads t);
	/**
	 * Metodo que regista um objeto da classe Account na arraylist account, e tambem faz Login no sistema
	 * conectando o respetivo device, e adicionando um plano basico
	 * @param name, nome do objeto da classe Account
	 * @param email, email do objeto da classe Account
	 * @param password password do objeto da classe Account
	 * @param device dispositivo do objeto da classe Account
	 * @throws AlreadyEmailException 
	 * @throws AlreadyLoginException 
	 */
	public void RegistUser(String name, String email, String password, String device) throws AlreadyLoginException, AlreadyEmailException;
	/**
	 * Metodo que introduz na variavel activeAccount o objeto da classe Account que ira ser a conta
	 * que pode realizar as operacoes permitidas pelo programa, conectando o respetivo device
	 * @param p, objeto da classe Account aque ira ser inserida na variavel activeAccount
	 * @param email, email da conta a efetuar o login
	 * @param password, password da conta a efetuar o login
	 * @param device, device da conta a efetuaro login
	 * @throws ExceedDevicesException 
	 * @throws IncorrectPassException 
	 * @throws NoAccountException 
	 * @throws AlreadyLoginException 
	 * @throws ClientLoginException 
	 */
	public void login(InterfaceAccount p, String email, String password, String device) throws ClientLoginException, AlreadyLoginException, NoAccountException, IncorrectPassException, ExceedDevicesException;
	/**
	 * Metodo que adiciona um objeto da classe Profile num objeto da classe Account, que existe na activeAccount
	 * @param name, nome do objeto da classe Profile a adicionar
	 * @param type, tipo do objeto da classe Profile a adicionar, que pode ser normal ou de crianca
	 * @param age, idade do objeto da classe Profile a adicionar.
	 *  Menos de 12 anos considerado perfil de crianca
	 * @throws ExceedProfileException 
	 * @throws AlreadyProfileException 
	 * @throws NoClientLoginException 
	 */
	public void addProfile(String name, String type, int age) throws NoClientLoginException, AlreadyProfileException, ExceedProfileException;
	/**
	 * Metodo que seleciona o objeto da classe Profile existente na classe Account selecionada
	 * na variavel activeAccount
	 * @param name, nome do objeto da classe Profile a selecionar
	 * @throws ProfileNotExistException 
	 * @throws NoClientLoginException 
	 */
	public void selectProfile(String name) throws NoClientLoginException, ProfileNotExistException;
	/**
	 * Metodo que faz upgrade/downgrade de um plano de um objeto Account
	 * @param type, tipo do plano em que a conta ira ter
	 * @throws DowngradeMembershipException 
	 * @throws NoMembershipChangeException 
	 * @throws NoClientLoginException 
	 */
	public void processMembership(String type) throws NoClientLoginException, NoMembershipChangeException, DowngradeMembershipException;
	/**
	 * Metodo auxiliar ao metodo login
	 * Introduz na variavel activeAccount o objeto da classe Account que pretende fazer login no sistema
	 * @param a, o objeto da classe Account que pretende fazer login no sistema
	 */
	public void LogIn(InterfaceAccount a);
	/**
	 * Metodo de verificaçao de condicao
	 * Verifica se a conta ja estara com o login feito, devolvendo true, para que nao possa fazer login duas vezes
	 * neste caso devolve false
	 * @param a, o objeto da classe Account que pretende fazer login no sistema
	 * @return true/false
	 */
	public boolean isLogedIn(InterfaceAccount a);
	/**
	 * Devolve o nome do objeto da classe Account que esta na variavel activeAccount
	 * @return nome da activeAccount
	 */
	public String getActiveAccount();
	/**
	 * Devolve o objeto da classe Account que esta na variavel activeAccount
	 * @return activeAccount
	 */
	public InterfaceAccount activeAccount();
	/**
	 * Devolve a idade do objeto da classe Account que esta na variavel activeAccount
	 * @return idade da activeAccount
	 */
	public int activeAccountAge();
	/**
	 * Devolve o ultimo dispositivo conectado da activeAccount se e crianca
	 * @return ultimo dispositivo da activeAccount
	 */
	public String getLastDevice();
	/**
	 * Metodo que faz logout da conta que esta na variavel activeAccount mantendo o dispositivo conetado
	 * Poe a variavel activeAccount a null
	 * Faz o disconnect do profile atual da activeAccount
	 * @throws NoClientLoginException 
	 */
	public void LogOut() throws NoClientLoginException;
	/**
	 * Metodo de verificacao de condicao
	 * Verifica se alguma conta ja esta com o login feito devolvendo true, contrariamente devolve false
	 * impedindo outra conta diferente de o fazer
	 * @return true/false
	 */
	public boolean isSomeoneLogedIn();
	/**
	 * Metodo que permite a activeAccount fazer a conexao de um device
	 * @param dev, nome do dispositivo a conetar
	 */
	public void connectDevice(String dev);
	/**
	 * Metodo que faz a desconexao do ultimo dispositivo conectado 
	 * @throws NoClientLoginException 
	 */
	public void disconnectDevice() throws NoClientLoginException;
	/**
	 * Metodo que permite ao profile selecionado da activeAccount ver um/uma filme/serie
	 * @param name, nome do filme/serie a ver
	 * @throws ShowNotAvailableExceptions 
	 * @throws ShowNotExistsExceptions 
	 * @throws NoSelectedProfileExceptions 
	 * @throws NoClientLoginException 
	 */
	public void watch(String name) throws NoClientLoginException, NoSelectedProfileExceptions, ShowNotExistsExceptions, ShowNotAvailableExceptions;
	/**
	 * Metodo que devolve a classificacao etaria de um objeto da classe FilmClass ou da classe SeriesClass
	 * @param u, objeto da classe FilmClass ou da classe SeriesClass
	 * @return classificacao etaria em Integer
	 */
	public int getUploadSplit(InterfaceUploads u);
	/**
	 * Metodo que encontra o objeto da classe FilmClass ou da classe SeriesClass dando um nome
	 * @param name, nome do/da filme/serie a procurar
	 * @return o objeto da classe FilmClass ou da classe SeriesClass
	 */
	public InterfaceUploads findUpload(String name);
	/**
	 * Metodo da verificacao de condicao
	 * Verifica se ja ha um profile selecionado, devolvendo true, caso contrario devolve false, impedindo que se
	 * possa selecionar varios perfis por conta
	 * @return true/false
	 */
	public boolean isProfileSelected();
	/**
	 * Metodo que permite a um perfil classificar um/uma filme/serie
	 * @param name, nome do/da filme/serie a ser classificado
	 * @param rate, valor da classificacao a ser atribuida ao/a filme/serie
	 * @throws ShowAlreadyRatedException 
	 * @throws ShowNotRecentException 
	 * @throws ShowNotExistsExceptions 
	 * @throws NoSelectedProfileExceptions 
	 * @throws NoClientLoginException 
	 */
	public void rate(String name, int rate) throws NoClientLoginException, NoSelectedProfileExceptions, ShowNotExistsExceptions, ShowNotRecentException, ShowAlreadyRatedException;
	/**
	 * Metodo auxiliar ao metodo rate
	 * Permite guardar as classificacoes atribuidas aos/as filmes/series atribuidas por cada profile
	 * @param u, objeto da classe FilmClass ou da classe SeriesClass a ser classificado
	 * @param rate, valor da classificacao atribuido ao/a filme/serie
	 */
	public void rateAux(InterfaceUploads u, int rate);
	/**
	 * Metodo de verificacao de condicao
	 * Verificaca se um/uma filme/serie esta na lista dos/das filmes/series recentemente vistos devolvendo true,
	 * false caso contrario
	 * @param u, objeto da classe FilmClass ou da classe SeriesClass
	 * @param p, objeto da classe Profile
	 * @return true/false
	 */
	public boolean isRecentShow(InterfaceUploads u, InterfaceProfile p);
	/**
	 * Metodo de verificacao de condicao
	 * Verifica se um/uma filme/serie ja foi classificado/classificada por um determinado profile devolvendo true,
	 * devolvendo false caso contrario, nao permitindo 
	 * @param u, objeto da classe FilmClass ou da classe SeriesClass
	 * @param p, objeto da classe Profile
	 * @return true/false
	 */
	public boolean showAlreadyRated(InterfaceUploads u, InterfaceProfile p);
	/**
	 * Metodo auxiliar do metodo rate, que permite atualizar a posicao do filme no mapa rating,
	 * que utiliza as classificacoes como chave, removendo o filme da classificacao anterior
	 * @param u, objeto da classe FilmClass ou da classe SeriesClass
	 */
	public void removeFilm(InterfaceUploads u);
	/**
	 * Devolve o iterador da lista de filmes/series vistas ultimamente de um profile
	 * @param p, objeto da classe Profile
	 * @return iterador da lista de filmes/series vistas ultimamente
	 */
	public Iterator<InterfaceUploads> getWatchList(InterfaceProfile p);
	/**
	 * Devolve o iterador dos/das filmes/series classificados por um profile
	 * @param p, objeto da classe Profile
	 * @return iterador dos/das filmes/series classificados
	 */
	public Iterator<InterfaceUploads> getRateList(InterfaceProfile p);
	/**
	 * Devolve o iterador das classificacoes dadas por um profile
	 * @param p, objeto da classe Profile
	 * @return iterador das classificacoes dadas
	 */
	public Iterator<Integer> getRate(InterfaceProfile p);
	/**
	 * Devolve o iterador dos profiles de uma conta
	 * @return iterador dos profiles de uma conta
	 */
	public Iterator<InterfaceProfile> getProfiles();
	/**
	 * Devolve o iterador de devices de uma conta
	 * @return iterador de devices de uma conta
	 */
	public Iterator<String> getDevices();
	/**
	 * Metodo que vai buscar o plano da activeAccount
	 */
	public void getTypeOfPlan();
	/**
	 * Metodo de verificao de condicao
	 * verifica de uma conta ja existe devolvendo true, contrariamente false, nao permitindo haver
	 * contas duplicadas no sistema
	 * @param a, objeto da classe Account
	 * @return true/false
	 */
	public boolean existsAccount(InterfaceAccount a);
	/**
	 * Metodo que devolve o iterador da colecao de filmes/series comparados e organizados por titulo
	 * @return iterador da colecao de filmes/series
	 */
	public Iterator<InterfaceUploads> listByName();
	/**
	 * Metodo que devolve o iterador da colecao de filmes/series comparados e organizados por datas
	 * @return iterador da colecao de filmes/series
	 */
	public Iterator<InterfaceUploads> listByDate();
	/**
	 * Metodo de verificacoes de excecoes
	 * @param genre, genero dos/das filmes/series a listar
	 * @throws NoShowFoundException 
	 * @throws NoSelectedProfileExceptions 
	 * @throws NoClientLoginException 
	 */
	public void listByGenre(String genre) throws NoClientLoginException, NoSelectedProfileExceptions, NoShowFoundException;
	/**
	 * Metodo que devolve o iterador da colecao guardada no mapa genre dada a chave
	 * @param genero, chave em que a colecao esta guardada
	 * @return iterador da colecao guardada
	 */
	public Iterator<InterfaceUploads> iteratorListByGenre(String genero);
	/**
	 * Metodo que devolve os iteradores da colecao guardada no mapa actor dada a chave
	 * @param name nome do actor,realizador ou director, chave em que a colecao esta guardada
	 * @return iterador da colecao guardada
	 */
	Iterator<InterfaceUploads> iteratorListByActor(String name);
	/**
	 * Metodo de verificacoes de excecoes
	 * @param name nome a procurar para poder listar
	 * @throws NoClientLoginException
	 * @throws NoSelectedProfileExceptions
	 * @throws NoShowFoundException
	 */
	void listByName(String name) throws NoClientLoginException, NoSelectedProfileExceptions, NoShowFoundException;
	/**
	 * Metodo que devolve os iteradores de cada colecao de filmes com classificacoes atribuidas por um profile
	 * ordenadas por chaves que sao as classificacoes atribuidas.
	 * Aqui quer se devolver todos os iteradores com classificacao igual ou superior a classificacao dada
	 * @param rate, classificacao que se procura
	 * @return iterador
	 */
	public Iterator<Iterator<InterfaceUploads>> iteratorListByRating(int rate);
	/**
	 * Metodo auxiliar que limpa a lista criada para obter os iteradores de cada colecao de filmes com classificacoes
	 * atribuidas por um profile, de modo a poder buscar outros iteradores de um outro profile e listar de novo
	 */
	public void clearAux();
	/**
	 * Metodo de verificacoes de excecoes
	 * @param rate rate, que ira listar acima desse valor
	 * @throws NoClientLoginException
	 * @throws NoSelectedProfileExceptions
	 * @throws NoShowFoundException
	 */
	void listByRating(int rate) throws NoClientLoginException, NoSelectedProfileExceptions, NoShowFoundException;
	/**
	 * Metodo de verificacao de condicao
	 * Verifica se existe um/uma filme/serie com classificacao atribuida por um profile devolvendo true,
	 * ou false caso contrario
	 * @param rate, classificacao atribuida
	 * @return true/false
	 */
	public boolean existShow(int rate);
	/**
	 * Metodo que devolve o iterador da lista de atores de um/uma filme/serie
	 * @param t, objeto da classe FilmClass ou da classe SeriesClass 
	 * @return
	 */
	public Iterator<String> listCast(InterfaceUploads t);
	/**
	  * Metodo que devolve o iterador da lista da conta existentes no sistema
	 * @return iterador da lista da conta existentes
	 */
	public Iterator<Account> listAccounts();
	/**
	 * Metodo que devolve o tamanho da arraylist de contas do sistema
	 * @return tamanho da arraylist de contas do sistema
	 */
	public int getNumAccounts();
	/**
	 * Metodo que vai buscar o numero de dispositivos que uma conta pode ter, sabendo o tipo de plano
	 * @param p, objeto da classe Account
	 * @return numero de dispositivos que uma conta pode ter
	 */
	public int getTypeDevices(InterfaceAccount p);
	/**
	 * Metodo de verificacao de condicao
	 * Verifica se um dispositivo esta conetado devolvendo true, caso contrario devolve false
	 * @param p, objeto da classe Account
	 * @param dev, nome do dispositivo a verificar
	 * @return true/false
	 */
	public boolean isConnected(InterfaceAccount p, String dev);
	/**
	 * Metodo que devolve o indice de um objeto da classe Account dando o seu nome
	 * @param name, nome de um objeto da classe Account
	 * @return indice do objeto da classe Account
	 */
	public int indexOfUser(String name);
	/**
	 * Metodo que devolve o indice de um objeto da classe Account dando o seu email
	 * @param email, email de um objeto da classe Account
	 * @return indice do objeto da classe Account
	 */
	public int indexOfEmail(String email);
	/**
	 * Metodo de verificacao de condicao
	 * Verifica se ja existe uma conta com o email dado devolvendo true, falso caso contrario, impedindo 
	 * contas com o mesmo email
	 * @param email, email a procurar
	 * @return true/false
	 */
	public boolean existsEmail(String email);
	/**
	 * Metodo de verificacao de condicao
	 * Verifica se a password dada pertende a um objeto da classe Account devolvendo true, ou false caso 
	 * contrario, impedindo de fazer login de uma conta com a password errada
	 * @param u, objeto da classe Account
	 * @param pass, password a verificar
	 * @return true/false
	 */
	public boolean isPassword(InterfaceAccount u, String pass);
	/**
	 * Metodo que encontra o objeto da class Account dado um nome
	 * @param name, nome a encontrar
	 * @return objeto da class Account
	 */
	public InterfaceAccount objName(String name);
	/**
	 * Metodo que encontra o objeto da class Account dado um email
	 * @param email, email a encontrar
	 * @return objeto da classe Account
	 */
	public InterfaceAccount objEmail(String email);
	/**
	 * Metodo que muda o numero de profiless que uma conta pode ter
	 * @param type, tipo do plano da conta
	 * @return o numero de profiles
	 */
	public int changePlanProfile(String type);
	/**
	 * Metodo que muda o numero de dispositivos que uma conta pode ter
	 * @param type, tipo do plano a mudar para
	 * @return o novo numero de dispositivos que uma conta pode ter
	 */
	public int changePlanDevices(String type);
	/**
	 * Verifica de a conta atual pode realizar uma mudanca de plano devolvendo true, ou falso caso contrario
	 * @param type, tipo de plano a mudar para
	 * @return true/false
	 */
	public boolean canChangePlan(String type);
	/**
	 * Metodo que devolve consoante o tipo de plano de uma conta o maximo de profiles que pode ter
	 * @return numero de profiles que uma conta pode ter
	 */
	public int getTypeProfiles();
	/**
	 * Metodo para lancar excecoes quando se usa o comando InfoAccount
	 * @throws NoClientLoginException
	 */
	void processInfoAccount() throws NoClientLoginException;
	
}
