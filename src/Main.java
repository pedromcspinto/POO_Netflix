
import java.util.*;
import ExceptionPackage.*;
import ExceptionPackage.IllegalArgumentException;
import Netflix.*;
import UploadsPackage.*;
import UsersPackage.*;

public class Main {
	/*
	 * Metodo que enumera os comandos da main
	 */
	private static enum Command {
		upload, register, login, disconnect, logout, membership, profile, select, watch, rate, infoaccount, searchbygenre, searchbyname, searchbyrate, desconhecido, exit;
		;
	};

	/*
	 * Constantes utilizadas nos prints de mensagens
	 */
	private static final String WELCOME = "Welcome";
	private static final String GOODBYE = "Goodbye";
	private static final String CONNECTED = "connected";
	private static final String DISCONNECTED = "disconnected";
	private static final String SPACE = " ";
	private static final String SPACE2 = "; ";
	private static final String P1 = "(";
	private static final String P2 = ")";
	private static final String DOT = ".";
	private static final String DOTS = "...";
	private static final String DOTS2 = ":";
	public static final String EXIT = "Exiting...";
	public static final String CHILD = "CHILDREN";
	public static final String NEW_PROFILE = "New profile added.";
	public static final String MEMBERSHIP = "Membership plan was changed from ";
	public static final String UPDATED = "Database was updated:";
	public static final String LOADING = "Loading";
	public static final String PROFILE = "Profile";
	public static final String EMPTY_WATCH = "Empty list of recently seen shows.";
	public static final String EMPTY_PROFILES = "No profiles defined.";
	public static final String RATE = "Thank you for rating ";
	public static final int ONE = 1;
	public static final String D1 = "[";
	public static final String D2 = "]";
	public static final String STILL = "still";
	public static final String WAS = "was";
	public static final String TO = "to";

	/*
	 * Linha de comandos
	 */
	public static void main(String[] args) {
		InterfaceNetflix net = new NetflixClass();
		Scanner in = new Scanner(System.in);
		Command comm = getCommand(in);
		w: while (!comm.equals(Command.exit)) {
			switch (comm) {
			case upload:
				processUpload(in, net);
				break;
			case register:
				processRegister(in, net);
				break;
			case login:
				processLogin(in, net);
				break;
			case disconnect:
				processDisconnect(net);
				break;
			case logout:
				processLogout(net);
				break;
			case membership:
				processMembership(in, net);
				break;
			case profile:
				processProfile(in, net);
				break;
			case select:
				processSelect(in, net);
				break;
			case watch:
				processWatch(in, net);
				break;
			case rate:
				processRate(in, net);
				break;
			case infoaccount:
				processInfoAccount(in, net);
				break;
			case searchbygenre:
				processByGenre(in, net);
				break;
			case searchbyname:
				processByName(in, net);
				break;
			case searchbyrate:
				processByRate(in, net);
				break;
			case desconhecido:
				unknown();
				break;
			default:
				break;
			case exit:
				break w;
			}
			System.out.println();
			comm = getCommand(in);
		}
		System.out.println(EXIT);
	}

	/*
	 * Lista os fillmes e series de televisao com a classicacao igual a superior ao
	 * valor dado
	 */
	private static void processByRate(Scanner in, InterfaceNetflix net) {
		int rate = in.nextInt();
		in.nextLine();
		try {
			net.listByRating(rate);
			Iterator<Iterator<InterfaceUploads>> it = net.iteratorListByRating(rate);
			while (it.hasNext()) {
				Iterator<InterfaceUploads> it2 = it.next();
				while (it2.hasNext()) {
					InterfaceUploads u = it2.next();
					Iterator<String> it3 = u.listCast();
					if (!(net.activeAccount().getSelectedProfile() instanceof ChildInterface
							&& net.activeAccountAge() < u.getSplit())) {
						System.out.print(u);
						while (it3.hasNext()) {
							String c = it3.next();
							System.out.print(SPACE2 + c);
						}
						System.out.print(DOT + SPACE + D1);
						System.out.printf("%.1f", u.getRate());
						System.out.println(D2);
					}
				}
			}
			net.clearAux();
		} catch (NoClientLoginException e) {
			System.out.println(e.getMessage());
		} catch (NoSelectedProfileExceptions e) {
			System.out.println(e.getMessage());
		} catch (NoShowFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Lista os filmes e series de televisao em que tenha participado o membro do
	 * elenco, realizador ou criador com o nome dado
	 */
	private static void processByName(Scanner in, InterfaceNetflix net) {
		String name = in.nextLine();
		try {
			net.listByName(name);
			Iterator<InterfaceUploads> it = net.iteratorListByActor(name);
			while (it.hasNext()) {
				InterfaceUploads u = it.next();
				Iterator<String> it2 = u.listCast();
				System.out.print(u);
				while (it2.hasNext()) {
					String c = it2.next();
					System.out.print(SPACE2 + c);
				}
				System.out.println(DOT);
			}
		} catch (NoClientLoginException e) {
			System.out.println(e.getMessage());
		} catch (NoSelectedProfileExceptions e) {
			System.out.println(e.getMessage());
		} catch (NoShowFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Lista os filmes e series de televisao de um dado genero
	 */
	private static void processByGenre(Scanner in, InterfaceNetflix net) {
		String genre = in.nextLine();
		try {
			net.listByGenre(genre);
			Iterator<InterfaceUploads> it = net.iteratorListByGenre(genre);
			while (it.hasNext()) {
				InterfaceUploads u = it.next();
				Iterator<String> it2 = u.listCast();
				System.out.print(u);
				while (it2.hasNext()) {
					String c = it2.next();
					System.out.print(SPACE2 + c);
				}
				System.out.println(DOT);
			}
		} catch (NoClientLoginException e) {
			System.out.println(e.getMessage());
		} catch (NoSelectedProfileExceptions e) {
			System.out.println(e.getMessage());
		} catch (NoShowFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Mostra toda a informacao associada a uma conta
	 */
	private static void processInfoAccount(Scanner in, InterfaceNetflix net) {
		try {
			net.processInfoAccount();
			InterfaceAccount u = net.activeAccount();
			Iterator<String> it = net.getDevices();
			System.out.println(u.getName() + DOTS2);
			System.out.print(u.getTypeOfPlan() + SPACE + P1);
			while (it.hasNext()) {
				String device = it.next();
				System.out.print(device);
				if (u.numConnectedDevices() > ONE)
					System.out.print(SPACE2 + it.next());
			}
			System.out.println(P2 + DOT);
			processAuxInfo(u, net);
		} catch (NoClientLoginException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 *Metodo auxiliar que ajuda a printar a informacao relativa ao profile da conta ativa 
	 */
	private static void processAuxInfo(InterfaceAccount u, InterfaceNetflix net) {
		InterfaceProfile p = null;
		if (u.getNumProfiles() != 0) {
			Iterator<InterfaceProfile> prof = net.getProfiles();
			while (prof.hasNext()) {
				p = prof.next();
				if (p instanceof ChildInterface) {
					ChildInterface c = (ChildInterface) p;
					System.out.println(PROFILE + DOTS2 + SPACE + p.getProfileName() + SPACE + P1 + c.getAge() + P2);
				} else
					System.out.println(PROFILE + DOTS2 + SPACE + p.getProfileName());
				if (p.isEmptyWatch())
					System.out.println(EMPTY_WATCH);
				else {
					Iterator<InterfaceUploads> up = net.getWatchList(p);
					AuxInfo(up, net, p);
				}
			}
		} else
			System.out.println(EMPTY_PROFILES);
	}

	/*
	 * Metodo auxiliar que ajuda a printar a informacao relativa aos filmes/series do profile ativo
	 */
	private static void AuxInfo(Iterator<InterfaceUploads> up, InterfaceNetflix net, InterfaceProfile p) {
		while (up.hasNext()) {
			InterfaceUploads ups = up.next();
			if (p.getWatchSize() > ONE) {
				System.out.print(ups.getTitle());
				if (up.hasNext())
					System.out.print(SPACE2);
			} else {
				System.out.print(ups.getTitle());
			}
		}
		System.out.println(DOT);
		if (!p.isEmptyRate()) {
			Iterator<InterfaceUploads> rated = net.getRateList(p);
			Iterator<Integer> integ = net.getRate(p);
			while (rated.hasNext() && integ.hasNext()) {
				InterfaceUploads ups = rated.next();
				Integer rate = integ.next();
				if (p.getRateSize() > 1) {
					System.out.print(ups.getTitle() + SPACE + P1 + rate + P2);
					if (rated.hasNext() && integ.hasNext())
						System.out.print(SPACE2);
				} else {
					System.out.print(ups.getTitle() + SPACE + P1 + rate + P2);
				}
			}
			System.out.println(DOT);
		}
	}

	/*
	 * Classifica um filme ou serie de televisao visto recentemente
	 */
	private static void processRate(Scanner in, InterfaceNetflix net) {
		String name = in.nextLine();
		int rate = in.nextInt();
		in.nextLine();
		try {
			net.rate(name, rate);
			System.out.println(RATE + name + DOT);
		} catch (NoClientLoginException e) {
			System.out.println(e.getMessage());
		} catch (NoSelectedProfileExceptions e) {
			System.out.println(e.getMessage());
		} catch (ShowNotExistsExceptions e) {
			System.out.println(e.getMessage());
		} catch (ShowNotRecentException e) {
			System.out.println(e.getMessage());
		} catch (ShowAlreadyRatedException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Visualizacao de um filme ou serie de televisao.
	 */
	private static void processWatch(Scanner in, InterfaceNetflix net) {
		String name = in.nextLine();
		try {
			net.watch(name);
			System.out.println(LOADING + SPACE + name + DOTS);
		} catch (NoClientLoginException e) {
			System.out.println(e.getMessage());
		} catch (NoSelectedProfileExceptions e) {
			System.out.println(e.getMessage());
		} catch (ShowNotExistsExceptions e) {
			System.out.println(e.getMessage());
		} catch (ShowNotAvailableExceptions e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Seleciona um perfil da conta
	 */
	private static void processSelect(Scanner in, InterfaceNetflix net) {
		String name = in.nextLine();
		try {
			net.selectProfile(name);
			System.out.println(WELCOME + SPACE + name + DOT);
		} catch (NoClientLoginException e) {
			System.out.println(e.getMessage());
		} catch (ProfileNotExistException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Adiciona um perfil a conta
	 */
	private static void processProfile(Scanner in, InterfaceNetflix net) {
		String name = in.nextLine();
		String type = in.nextLine().toUpperCase().trim();
		int age = 50;
		if (type.equals(CHILD)) {
			age = in.nextInt();
			in.nextLine();
		}
		try {
			net.addProfile(name, type, age);
			System.out.println(NEW_PROFILE);
		} catch (NoClientLoginException e) {
			System.out.println(e.getMessage());
		} catch (AlreadyProfileException e) {
			System.out.println(e.getMessage() + name + DOT);
		} catch (ExceedProfileException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Altera o plano de adesao.
	 */
	private static void processMembership(Scanner in, InterfaceNetflix net) {
		String type = in.nextLine();
		try {
			net.processMembership(type);
			String x = net.activeAccount().getOldPlan();
			System.out.println(MEMBERSHIP + x + SPACE + TO + SPACE + type + DOT);
		} catch (NoClientLoginException e) {
			System.out.println(e.getMessage());

		} catch (NoMembershipChangeException e) {
			System.out.println(e.getMessage());

		} catch (DowngradeMembershipException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Termina a sessao de um cliente mantendo o acesso do dispositivo ao servico
	 */
	private static void processLogout(InterfaceNetflix net) {
		try {
			if (net.isSomeoneLogedIn()) {
				System.out.println(GOODBYE + SPACE + net.getActiveAccount() + SPACE + P1 + net.getLastDevice() + SPACE
						+ STILL + SPACE + CONNECTED + P2 + DOT);
			}
			net.LogOut();
		} catch (NoClientLoginException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Termina a sessao de um cliente eliminando o acesso do dispositivo ao serviço
	 */
	private static void processDisconnect(InterfaceNetflix net) {
		try {
			String dev = net.getLastDevice();
			net.disconnectDevice();
			System.out.println(GOODBYE + SPACE + net.getActiveAccount() + SPACE + P1 + dev + SPACE + WAS + SPACE
					+ DISCONNECTED + P2 + DOT);
			net.LogOut();
		} catch (NoClientLoginException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Inicia a sessao de um cliente
	 */
	private static void processLogin(Scanner in, InterfaceNetflix net) {
		String email = in.nextLine();
		String password = in.nextLine();
		String device = in.nextLine();
		InterfaceAccount u = null;
		if (net.existsEmail(email)) {
			u = net.objEmail(email);
		}
		try {
			net.login(u, email, password, device);
			System.out.println(WELCOME + SPACE + u.getName() + SPACE + P1 + device + P2 + DOT);
		} catch (ClientLoginException e) {
			System.out.println(e.getMessage());
		} catch (AlreadyLoginException e) {
			System.out.println(e.getMessage());
		} catch (NoAccountException e) {
			System.out.println(e.getMessage());
		} catch (IncorrectPassException e) {
			System.out.println(e.getMessage());
		} catch (ExceedDevicesException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Regista uma nova conta
	 */
	private static void processRegister(Scanner in, InterfaceNetflix net) {
		String name = in.nextLine();
		String email = in.nextLine();
		String password = in.nextLine();
		String device = in.nextLine();
		try {
			net.RegistUser(name, email, password, device);
			System.out.println(WELCOME + SPACE + name + SPACE + P1 + device + P2 + DOT);
		} catch (AlreadyLoginException e) {
			System.out.println(e.getMessage());
		} catch (AlreadyEmailException e) {
			System.out.println(e.getMessage() + SPACE + email + DOT);
		}
	}

	/*
	 * Carrega base de dados de filmes
	 */
	private static void processUpload(Scanner in, InterfaceNetflix net) {
		List<String> cast;
		int nFilmes = in.nextInt();
		in.nextLine();
		for (int i = 0; i < nFilmes; i++) {
			String title = in.nextLine();
			String director = in.nextLine();
			int duration = in.nextInt();
			in.nextLine();
			String age = in.nextLine();
			int release = in.nextInt();
			in.nextLine();
			String genre = in.nextLine();
			int nCast = in.nextInt();
			in.nextLine();
			cast = new ArrayList<String>();
			for (int z = 0; z < nCast; z++) {
				String a = in.nextLine();
				cast.add(a);

			}
			FilmClass f = new FilmClass(title, director, duration, age, release, genre, cast);
			f.Split();
			net.addUpload(title, genre, f);
			net.AuxListByNameMap(director, cast, f);
		}
		UploadAux(in, net);
		PrintUpload(in, net);
	}

	/*
	 * Carrega base de dados de series de televisao
	 */
	private static void UploadAux(Scanner in, InterfaceNetflix net) {
		List<String> cast;
		int nSeries = in.nextInt();
		in.nextLine();
		for (int i = 0; i < nSeries; i++) {
			String stitle = in.nextLine();
			String creator = in.nextLine();
			int nseasons = in.nextInt();
			in.nextLine();
			int nepisodes = in.nextInt();
			in.nextLine();
			String sage = in.nextLine();
			int srelease = in.nextInt();
			in.nextLine();
			String sgenre = in.nextLine();
			int nsCast = in.nextInt();
			in.nextLine();
			cast = new ArrayList<String>();
			for (int z = 0; z < nsCast; z++) {
				String a = in.nextLine();
				cast.add(a);
			}
			SeriesClass s = new SeriesClass(stitle, creator, nseasons, nepisodes, sage, srelease, sgenre, cast);
			s.Split();
			net.addUpload(stitle, sgenre, s);
			net.AuxListByNameMap(creator, cast, s);
		}
	}

	/*
	 * Metodo auxiliar que da print das series e filmes de televisao por ordem
	 * alfabetica
	 */
	private static void PrintUpload(Scanner in, InterfaceNetflix net) {
		System.out.println(UPDATED);
		Iterator<InterfaceUploads> it = net.listByName();
		while (it.hasNext()) {
			int counter = 0;
			InterfaceUploads t = it.next();
			System.out.print(t);
			Iterator<String> it2 = t.listCast();
			while (it2.hasNext()) {
				if (counter < 3) {
					System.out.print(SPACE2 + it2.next());
					counter++;
				} else {
					break;
				}
			}
			System.out.print(DOT);
			System.out.println();
		}
	}

	private static Command getCommand(Scanner in) {
		String comm = in.nextLine().toLowerCase();
		if (!belongsToCommand(comm)) {
			return Command.desconhecido;
		} else {
			return Command.valueOf(comm);
		}
	}

	private static boolean belongsToCommand(String comm) {
		for (Command c : Command.values()) {
			if (c.name().equals(comm)) {
				return true;
			}
		}
		return false;
	}

	private static void unknown() {
		try {
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
