package models;

public class Conta{
    
	public Conta(int codigo, String nome, double valor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.limite = 0;
		this.usaLimite = false;
	}
	
	public Conta(int codigo, String nome, double valor, double limite) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.limite = limite;
		this.usaLimite = true;
	}
    
    private int codigo;
    private String nome;
    private double valor;
    private double limite;
    private boolean usaLimite;
    
     public boolean isUsaLimite() {
		return usaLimite;
	}

	public void setUsaLimite(boolean usaLimite) {
		this.usaLimite = usaLimite;
	}

	public int getCodigo (){
        return this.codigo;
     }

     public void setCodigo (int codigo){
        this.codigo = codigo;
     }

    public String getNome (){
        return this.nome;
     }

     public void setNome (String nome){
         this.nome = nome;
      }

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public void exibir() {
		System.out.println("Número Da Conta:" + this.getCodigo());
		System.out.println("Nome:" + this.getNome());
		System.out.println("Saldo:" + this.getValor());
		System.out.println("Usa Limite: " + this.isUsaLimite());
		System.out.println("Limite Da Conta: " + this.getLimite());
		System.out.println();
	}
	
	public boolean habilitadoParaTransferencia(double valorDaTransacao) {
		boolean validaSemLimite = valorDaTransacao <= this.getValor();
		
		boolean validaComLimite = valorDaTransacao <= this.getValor() && valorDaTransacao <= this.getLimite();
		
		boolean transferenciaValida = this.isUsaLimite() ? validaComLimite : validaSemLimite;
		return transferenciaValida;
	}
}