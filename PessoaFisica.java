public class PessoaFisica extends Cliente {
 private static final long serialVersionUID = 1L;
 private String cpf;

    public PessoaFisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }


   public String getCpf() {
       return cpf;
   }

} 
