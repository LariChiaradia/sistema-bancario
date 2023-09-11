package services;

import java.util.Scanner;

import models.Conta;
import repositories.ListaDeContas;

public class ContaService {

	
	private ListaDeContas _contaRepository;
	private Scanner _leitor;

	public ContaService(ListaDeContas contaRepository, Scanner leitor) {
		super();
		this._contaRepository = contaRepository;
		this._leitor = leitor;
	}
	
	public void Cadastro() {
		System.out.println();
		System.out.println("........................");
		System.out.println("Cadastro da sua conta");
		System.out.println("........................");
		System.out.println();

		System.out.print("Número da Conta: ");
		int codigoDaConta = _leitor.nextInt();
		Conta contaExistente = _contaRepository.GetContaByCodigo(codigoDaConta);
		
		if(contaExistente != null) {
			System.out.println("Conta existente.");
			System.out.println();
			return;
		}

		System.out.print("Nome do Responsavel: ");
		String nome = _leitor.nextLine();
		nome = _leitor.nextLine();

		System.out.print("Valor de conta: ");
		double valor = _leitor.nextDouble();

		System.out.println("Você gostaria de ativar o Limite em sua conta? Para Sim digite true / Para Não digite false.");
		boolean usaLimite = _leitor.nextBoolean();
		Conta novaConta;
		
		if(!usaLimite) {
			novaConta = new Conta(codigoDaConta, nome, valor);
		}else {
			System.out.print("Valor do Limite: ");
			double limite = _leitor.nextDouble();
			novaConta = new Conta(codigoDaConta, nome, valor, limite);
		}

		Conta result = _contaRepository.InserirConta(novaConta);

		if (result == null) {
			return;
		}

		System.out.println("Conta Cadastrada com Sucesso!!!!!");
		System.out.println();
	}

	public void MostrarTodos() {

		System.out.println("........................");
		System.out.println("Mostrar Todas as Contas");
		System.out.println("........................");
		System.out.println();

		_contaRepository.PrintAll();
		System.out.println();

	}

	public void MostrarConta() {
		System.out.println("........................");
		System.out.println("Mostrar Conta");
		System.out.println("........................");
		System.out.println();

		System.out.print("Digite o Número da Conta: ");
		int codigo = _leitor.nextInt();

		Conta resultado = _contaRepository.GetContaByCodigo(codigo);

		if (resultado == null) {
			System.out.println("Conta Não Existe.");
			return;
		}

		resultado.exibir();
	}

	public void AtualizarConta() {
		System.out.println("........................");
		System.out.println("Alterar Dados da Conta");
		System.out.println("........................");
		System.out.println();

		System.out.print("Digite o Número da Conta: ");
		int codigo = _leitor.nextInt();
		
		System.out.println("Nome do Responsável: ");
		String nome = _leitor.nextLine();
		nome = _leitor.nextLine();
		
		System.out.println("Valor em Conta: ");
		double valor = _leitor.nextDouble();
		
		System.out.println("Limite: ");
		double limite = _leitor.nextDouble();

		Conta contaAtualizada = new Conta(codigo, nome, valor, limite);

		_contaRepository.UpdateConta(contaAtualizada);
		System.out.println();
	}

	public void RemoverConta() {
		System.out.println("........................");
		System.out.println("Remover a Conta");
		System.out.println("........................");
		System.out.println();

		System.out.print("Digite o Número da Conta: ");
		int codigo = _leitor.nextInt();

		_contaRepository.DeleteContaByCodigo(codigo);
		System.out.println();
	}

	public void Deposito() {
		System.out.println("........................");
		System.out.println("Depósito");
		System.out.println("........................");
		System.out.println();

		System.out.print("Digite o Número da Conta: ");
		int codigo = _leitor.nextInt();

		System.out.print("Digite o Valor do Depósito: ");
		double valorDep = _leitor.nextDouble();

		Conta contaPesquisa = _contaRepository.GetContaByCodigo(codigo);

		if (contaPesquisa == null) {
			return;
		}

		double valorTotal = contaPesquisa.getValor() + valorDep;
		contaPesquisa.setValor(valorTotal);

		_contaRepository.UpdateConta(contaPesquisa);
		System.out.println();
	}

	public void Pagamento() {
		System.out.println("........................");
		System.out.println("Pagamento");
		System.out.println("........................");
		System.out.println();

		System.out.print("Digite o Número da Conta: ");
		int codigo = _leitor.nextInt();

		System.out.print("Digite o Valor do Pagamento: ");
		double pagamento = _leitor.nextDouble();

		Conta contaPagamento = _contaRepository.GetContaByCodigo(codigo);

		if (contaPagamento == null) {
			return;
		}

		boolean pagamentoValido = contaPagamento.habilitadoParaTransferencia(pagamento);

		if (!pagamentoValido) {
			System.out.println("Pagamento inválido: Sem saldo ou sem limite");
			return;
		}

		double saldoNovo = contaPagamento.getValor() - pagamento;
		contaPagamento.setValor(saldoNovo);
		_contaRepository.UpdateConta(contaPagamento);
		System.out.println();
	}

	public void Transferencia() {
		System.out.println("........................");
		System.out.println("Transferência entre Contas");
		System.out.println("........................");
		System.out.println();

		System.out.print("Digite o Número da Conta Remetente: ");
		int codigoRemetente = _leitor.nextInt();

		System.out.print("Digite o Número da conta do Destinatario: ");
		int codigoDestinatario = _leitor.nextInt();

		System.out.print("Digite o Valor da Transferência: ");
		double valorTransferencia = _leitor.nextDouble();

		Conta contaRemetente = _contaRepository.GetContaByCodigo(codigoRemetente);
		if (contaRemetente == null) {
			return;
		}

		Conta contaDestinatario = _contaRepository.GetContaByCodigo(codigoDestinatario);
		if (contaDestinatario == null) {
			return;
		}
		
		boolean transferenciaValida = contaRemetente.habilitadoParaTransferencia(valorTransferencia);
		
		if (!transferenciaValida) {
			System.out.println("Transferencia invalida: sem saldo ou limite");
			return;
		}

		double saldoContaRemetente = contaRemetente.getValor() - valorTransferencia;
		contaRemetente.setValor(saldoContaRemetente);
		_contaRepository.UpdateConta(contaRemetente);

		double saldoContaDestinatario = contaDestinatario.getValor() + valorTransferencia;
		contaDestinatario.setValor(saldoContaDestinatario);
		_contaRepository.UpdateConta(contaDestinatario);
	}
	
	public void Finalizar() {
		System.out.println("........................");
		System.out.println("Finalizando");
		System.out.println("........................");
		_leitor.close();
	}
	
	
	
	
	
}
