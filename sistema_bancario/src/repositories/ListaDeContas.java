package repositories;

import java.util.ArrayList;

import models.Conta;

public class ListaDeContas {

	private ArrayList<Conta> Contas;

	public ListaDeContas(ArrayList<Conta> contas) {
		super();
		Contas = contas;
	}
	
	public ListaDeContas() {
		super();
		Contas = new ArrayList<Conta>();
	}
	
	public Conta InserirConta(Conta insertConta) {
		for(Conta conta:this.Contas) {
			if(conta.getCodigo() == insertConta.getCodigo()) {
				System.out.println("Conta ja existente");
				return null;
			}
		}
		
		this.Contas.add(insertConta);
		return insertConta;
	}
	
	public void InserirContas(ArrayList<Conta> contas) {
		for(Conta conta:contas) {
			this.InserirConta(conta);
		}
	}
	
	public Conta GetContaByCodigo(int codigo) {
		
		for(Conta conta:this.Contas) {
			if(conta.getCodigo() == codigo) {
				return conta;
			}
		}
		return null;		
	}
	
	public Conta UpdateConta(Conta updatedConta) {
		
		for(Conta conta:this.Contas) {
			if(conta.getCodigo() == updatedConta.getCodigo()) {
				conta.setNome(updatedConta.getNome());
				conta.setValor(updatedConta.getValor());
				conta.setLimite(updatedConta.getLimite());
				return conta;
			}
		}
		
		System.out.println("Conta não existe");
		return null;
	}
	
	public void DeleteContaByCodigo(int codigo) {
		for (Conta conta:this.Contas) {
			if(conta.getCodigo() == codigo) {
				this.Contas.remove(conta);
				return;
			}
		}
	}
	
	public void PrintAll() {
        for(Conta conta:this.Contas){
            conta.exibir();
        }
	}
}
