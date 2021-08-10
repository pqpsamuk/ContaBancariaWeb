import java.io.Serializable;

public abstract class Cliente implements Serializable {
   private static final long serialVersionUID = 1L;
   enum TipoCliente {
       pessoaFisica, pessoaJuridica
    }

    private String nome; 

   protected Cliente(String nome) {
     this.nome = nome;
   }

   public String getNome() {
       return nome;
   }

} 