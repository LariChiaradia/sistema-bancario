package runables;

import java.util.ArrayList;
import java.util.Scanner;

import models.Conta;
import repositories.ListaDeContas;
import services.ContaService;

public class Main {
	private static ListaDeContas _listaDeContas = new ListaDeContas(new ArrayList<Conta>());
	private static Scanner _leitor = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Conta> contas = new ArrayList<>();

		contas.add(new Conta(1111, "Larissa Trump", 100, 100));
		contas.add(new Conta(2222, "Emilly Lula", 200, 200));
		contas.add(new Conta(3333, "Tarita Bolsonaro", 300, 0));

		_listaDeContas.InserirContas(contas);
		var contaService = new ContaService(_listaDeContas, _leitor);

		int opcao;

		do {
			PrintMenu();

			System.out.print("Opção:");
			opcao = _leitor.nextInt();

			switch (opcao) {
				case 1:
					
					contaService.Cadastro();
					break;
	
				case 2:
					
					contaService.MostrarTodos();
					break;
	
				case 3:
	
					contaService.MostrarConta();
					break;
					
				case 4:
	
					contaService.AtualizarConta();
					break;
	
				case 5:
	
					contaService.RemoverConta();
					break;
	
				case 6:
	
					contaService.Deposito();
					break;
	
				case 7:
					
					contaService.Pagamento();
					break;
	
				case 8:
	
					contaService.Transferencia();
					break;
	
				case 9:
	
					contaService.Finalizar();
					break;
	
				default:
					
					System.out.println("OPÇÃO INVÁLIDA!!!!");
					break;		
			}
			
		} while (opcao != 9);

	}
	
	private static void PrintMenu() {
		System.out.println("*****MENU PRINCIPAL*****");
		System.out.println();
		System.out.println("1 - Cadastro de Conta");
		System.out.println("2 - Mostrar Todas as Contas");
		System.out.println("3 - Mostrar Dados de Conta Específica");
		System.out.println("4 - Alterar Dados em Conta");
		System.out.println("5 - Excluir Conta");
		System.out.println("6 - Efetuar Depósito");
		System.out.println("7 - Pagamento");
		System.out.println("8 - Transferência entre contas");
		System.out.println("9 - Sair");
	}
}