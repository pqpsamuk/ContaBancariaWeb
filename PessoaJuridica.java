public class PessoaJuridica extends Cliente {
	 private static final long serialVersionUID = 1L;
	private String cnpj;

	public PessoaJuridica(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}
	public String getCnpj(){
		return cnpj;
	}

} 