import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;

import entidades.Hospede;
import entidades.Quarto;
import entidades.Reserva;
import enums.TipoQuarto;
import gerenciadores.GerenciadorDeHospede;
import gerenciadores.GerenciadorDeQuartos;
import gerenciadores.GerenciadorDeReserva;

public class App {

    private static GerenciadorDeQuartos gerenciadorDeQuartos = new GerenciadorDeQuartos();
    private static GerenciadorDeReserva gerenciadorDeReserva = new GerenciadorDeReserva();
    private static GerenciadorDeHospede gerenciadorDeHospede = new GerenciadorDeHospede();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu = "Escolha uma opcao>\n(1) - Gerenciar Quartos" +
                "\n(2) - Gerenciar Hospedes" +
                "\n(3) - Gerenciar Reservas" +
                "\n(0) - Sair!";
        while (true) {
            System.out.println(menu);
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    menuGerenciadorQuartos(sc);
                    break;
                case 2:
                    menuGerenciadorHospedes(sc);
                    break;
                case 3:
                    menuGerenciadorReservas(sc);
                    break;
                case 0:
                    System.out.println("Saindo do programa!");
                    System.exit(0);
                default:
                    System.out.println("Opcao Inválida, selecione uma opção válida!");
                    break;
            }
        }

    }

    private static void menuGerenciadorReservas(Scanner sc) {
        String menuReservas = "Escolha uma opcao>\n(1) - Nova Reserva" +
                "\n(2) - Cancelar reserva" +
                "\n(3) - Realizar Checkin" +
                "\n(4) - Realizar Checkout";
        System.out.println(menuReservas);
        int escolha = sc.nextInt();
        switch (escolha) {
            case 1:
                System.out.println(novaReserva(sc));
                break;
            case 2:
                System.out.println(cancelarReserva(sc));
                break;
            case 3:
                System.out.println(checkInReserva(sc));
                break;
            case 4:
                System.out.println(checkoutReserva(sc));
                break;
            default:
                break;
        }
        sc.nextLine();
    }

    private static String checkoutReserva(Scanner sc) {
        System.out.print("Digite o id da reserva que deseja fazer checkout: ");
        int idReserva = sc.nextInt();
        return checkOut(idReserva);
    }

    private static String checkInReserva(Scanner sc) {
        System.out.print("Digite o id da reserva que deseja fazer checkin: ");
        int idReserva = sc.nextInt();
        return checkIn(idReserva);
    }

    private static String novaReserva(Scanner sc) {
        sc.nextLine();
        System.out.println("Informe o quarto que deseja reservar: ");
        String q = sc.nextLine();
        Quarto quarto = gerenciadorDeQuartos.findQuartoByNumeroQuarto(q);
        System.out.println("Informe o cpf do hospede que deseja reservar: ");
        String h = sc.nextLine();
        Hospede hospede = gerenciadorDeHospede.getHospedeByCpf(h);
        System.out.print("Digite a data de entrada (Formato: YYYY/MM/DD): ");
        String dataEntradaStr = sc.nextLine();
        System.out.print("Digite a data de saída (Formato: YYYY/MM/DD): ");
        String dataSaidaStr = sc.nextLine();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dataEntrada = LocalDate.parse(dataEntradaStr, formatador);
        LocalDate dataSaida = LocalDate.parse(dataSaidaStr, formatador);
        System.out.println("Digite o numero de hospedes que serão abrigados");
        int numHospedes = sc.nextInt();
        sc.nextLine();
        return gerenciadorDeReserva.novaReserva(quarto, hospede, dataEntrada, dataSaida, numHospedes);
    }

    private static void menuGerenciadorHospedes(Scanner sc) {
        String menuHospedes = "Escolha uma opcao>\n(1) - Cadastrar hospede" +
                "\n(2) - Remover hospede";
        System.out.println(menuHospedes);
        int escolha = sc.nextInt();
        sc.nextLine();
        switch (escolha) {
            case 1:
                System.out.println(cadastrarHospede(sc));
                ;
                break;
            case 2:
                System.out.println(removerHospede(sc));
                break;
            default:
                break;
        }

    }

    private static String removerHospede(Scanner sc) {
        System.out.println("Digite o cpf do hospede a ser removido: ");
        String cpf = sc.nextLine();
        return gerenciadorDeHospede.removerHospede(cpf);
    }

    private static String cadastrarHospede(Scanner sc) {
        System.out.print("Digite o nome do novo hospede: ");
        String nome = sc.nextLine();
        System.out.print("Digite o cpf do novo hospede: ");
        String cpf = sc.nextLine();
        System.out.print("Digite a data de nascimento do novo hospede (Formato: YYYY/MM/DD): ");
        String dataNascimentoStr = sc.nextLine();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatador);
        System.out.print("Digite o endereco do novo hospede: ");
        String endereco = sc.nextLine();
        System.out.print("Digite o numero de telefone do novo hospede: ");
        String numero = sc.nextLine();
        return gerenciadorDeHospede.cadastrarNovoHospede(nome, cpf, dataNascimento, endereco, numero);
    }

    private static void menuGerenciadorQuartos(Scanner sc) {
        String menuQuartos = "Escolha uma opcao>\n(1) - Adicionar quarto" +
                "\n(2) - Remover quarto" +
                "\n(3) - Ver quais quartos estão disponiveis agora" +
                "\n(4) - Ver informaçoes de quarto específico" +
                "\n(5) - Checar disponibilidade em periodo específico";
        System.out.println(menuQuartos);
        int escolha = sc.nextInt();
        sc.nextLine();
        switch (escolha) {
            case 1:
                System.out.println(adicionadorQuarto(sc));
                break;
            case 2:
                System.out.println(removedorQuarto(sc));
                break;
            case 3:
                System.out.println(gerenciadorDeQuartos.getAllQuartosDisponiveis());
                break;
            case 4:
                System.out.println(informacoesQuarto(sc));
                break;
            case 5:
                System.out.println(consultarQuartosDisponiveisPeriodo(sc));
            default:
                break;
        }
    }

    private static String consultarQuartosDisponiveisPeriodo(Scanner sc) {
        System.out.print("Digite a data de entrada (Formato: YYYY/MM/DD): ");
        String dataEntradaStr = sc.nextLine();
        System.out.print("Digite a data de saída (Formato: YYYY/MM/DD): ");
        String dataSaidaStr = sc.nextLine();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dataEntrada = LocalDate.parse(dataEntradaStr, formatador);
        LocalDate dataSaida = LocalDate.parse(dataSaidaStr, formatador);
        return conferirQuartosDisponiveisPorData(dataEntrada, dataSaida);
    }

    private static String informacoesQuarto(Scanner sc) {
        System.out.print("Digite o numero do quarto: ");
        String numQuarto = sc.nextLine();
        Quarto quarto = gerenciadorDeQuartos.findQuartoByNumeroQuarto(numQuarto);
        if (quarto == null)
            return "O quarto desejado não existe!";
        return quarto.toString();
    }

    private static String removedorQuarto(Scanner sc) {
        System.out.println("Insira o numero do quarto a ser removido: ");
        String quarto = sc.nextLine();
        return gerenciadorDeQuartos.removerQuarto(quarto);
    }

    private static String conferirQuartosDisponiveisPorData(LocalDate dataEntrada, LocalDate dataSaida) {
        HashSet<Quarto> quartosIndisponiveis = gerenciadorDeReserva.quartosIndisponiveis(dataEntrada, dataSaida);

        HashSet<Quarto> todosOsQuartos = gerenciadorDeQuartos.getTodosQuartos();

        HashSet<String> quartosDisponiveisNoPeriodo = new HashSet<>();

        for (Quarto q : todosOsQuartos) {
            if (!quartosIndisponiveis.contains(q)) {
                quartosDisponiveisNoPeriodo.add(q.getNumeroQuarto());
            }
        }
        return "Os quartos disponiveis no periodo solicitados são: " + quartosDisponiveisNoPeriodo.toString();
    }

    public static String cancelarReserva(Scanner sc) {
        System.out.print("Insira o id da reserva que deseja cancelar: ");
        int numReserva = sc.nextInt();
        return gerenciadorDeReserva.cancelarReserva(numReserva);
    }

    private static String checkIn(int idReserva) {
        Reserva r = gerenciadorDeReserva.findReservaId(idReserva);
        if (r == null)
            return "Não há reserva com esse id!";
        gerenciadorDeReserva.checkIn(r);
        return gerenciadorDeQuartos.checkIn(r.getQuartoReservado().getNumeroQuarto());
    }

    private static String checkOut(int idReserva) {
        Reserva r = gerenciadorDeReserva.findReservaId(idReserva);
        if (r == null)
            return "Não há reserva com esse id!";
        gerenciadorDeQuartos.checkOut(r.getQuartoReservado().getNumeroQuarto());
        return gerenciadorDeReserva.checkOut(r);
    }

    private static String adicionadorQuarto(Scanner sc) {
        System.out.print("Digite o numero do quarto: ");
        String numeroQuarto = sc.nextLine();
        System.out.print("Qual o tipo de quarto?\n- (S)olteiro\n- (C)asal\n- S(U)ite\n>>>");
        String tipoQuarto = sc.nextLine().toUpperCase();
        TipoQuarto tipo = null;
        switch (tipoQuarto) {
            case "S":
                tipo = TipoQuarto.SOLTEIRO;
                break;
            case "C":
                tipo = TipoQuarto.CASAL;
                break;
            case "U":
                tipo = TipoQuarto.SUITE;
            default:
                break;
        }
        if (tipo == null)
            return "Por favor informe um tipo de quarto valido!";
        System.out.println("Qual a capacidade do quarto? ");
        int capacidade = sc.nextInt();
        System.out.println("Qual o valor da diaria do quarto? ");
        double preco = sc.nextDouble();
        return gerenciadorDeQuartos.cadastrarNovoQuarto(numeroQuarto, tipo, capacidade, preco);
    }
}