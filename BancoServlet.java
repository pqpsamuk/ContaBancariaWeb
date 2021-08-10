import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BancoServlet")
public class BancoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static int deposito;
    private static int saque;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoCliente = request.getParameter("tipoCliente");
        String Operacao = request.getParameter("operacao");

        if (tipoCliente.equals("pessoaFisica")) {

            String nome = request.getParameter("nomeCliente");
            String cpf = request.getParameter("cpfCnpj");

            PessoaFisica pessoaFisica = new PessoaFisica(nome, cpf);
            ContaBancaria contaPessoaFisica = new ContaBancaria(pessoaFisica);

            if (Operacao.equals("recuperarNomeCliente")) {
                String resposta = pessoaFisica.getNome();

                request.setAttribute("resposta", resposta);
                request.getRequestDispatcher("resposta.jsp").forward(request, response);

            } else if (Operacao.equals("recuperarCpfCliente")) {
                String resposta = pessoaFisica.getCpf();

                request.setAttribute("resposta", resposta);
                request.getRequestDispatcher("resposta.jsp").forward(request, response);

            } else if (Operacao.equals("depositarValor")) {

                deposito = Integer.parseInt(request.getParameter("valorDeposito"));
                contaPessoaFisica.depositar(deposito);
                request.setAttribute("resposta", contaPessoaFisica.getSaldo());
                request.getRequestDispatcher("resposta.jsp").forward(request, response);

            } else if (Operacao.equals("recuperarSaldo")) {

                request.setAttribute("resposta", contaPessoaFisica.getSaldo());
                request.getRequestDispatcher("resposta.jsp").forward(request, response);

            } else if (Operacao.equals("sacarValor")) {

                saque = Integer.parseInt(request.getParameter("valorSaque"));
                contaPessoaFisica.sacar(saque);
                request.setAttribute("resposta", contaPessoaFisica.getSaldo());
                request.getRequestDispatcher("resposta.jsp").forward(request, response);

            } else if (Operacao.equals("depositarSacarValor")) {

                deposito = Integer.parseInt(request.getParameter("valorDeposito"));
                contaPessoaFisica.depositar(deposito);
                saque = Integer.parseInt(request.getParameter("valorSaque"));
                contaPessoaFisica.sacar(saque);

                request.setAttribute("resposta", contaPessoaFisica.getSaldo());
                request.getRequestDispatcher("resposta.jsp").forward(request, response);
            };

        }
        if (tipoCliente.equals("pessoaJuridica")) {

            String nome = request.getParameter("nomeCliente");
            String cnpj = request.getParameter("cpfCnpj");

            PessoaJuridica pessoaJuridica = new PessoaJuridica(nome, cnpj);
            ContaBancaria contaPessoaJuridica = new ContaBancaria(pessoaJuridica);

            if (Operacao.equals("recuperarNomeCliente")) {
                String resposta = pessoaJuridica.getNome();

                request.setAttribute("resposta", resposta);
                request.getRequestDispatcher("resposta.jsp").forward(request, response);

            } else if (Operacao.equals("recuperarCnpjCliente")) {
                String resposta = pessoaJuridica.getCnpj();

                request.setAttribute("resposta", resposta);
                request.getRequestDispatcher("resposta.jsp").forward(request, response);
            } else if (Operacao.equals("depositarValor")) {

                deposito = Integer.parseInt(request.getParameter("valorDeposito"));
                contaPessoaJuridica.depositar(deposito);
                request.setAttribute("resposta", contaPessoaJuridica.getSaldo());
                request.getRequestDispatcher("resposta.jsp").forward(request, response);

            } else if (Operacao.equals("recuperarSaldo")) {

                request.setAttribute("resposta", contaPessoaJuridica.getSaldo());
                request.getRequestDispatcher("resposta.jsp").forward(request, response);

            } else if (Operacao.equals("sacarValor")) {

                saque = Integer.parseInt(request.getParameter("valorSaque"));
                contaPessoaJuridica.sacar(saque);
                request.setAttribute("resposta", contaPessoaJuridica.getSaldo());
                request.getRequestDispatcher("resposta.jsp").forward(request, response);

            } else if (Operacao.equals("depositarSacarValor")) {

                deposito = Integer.parseInt(request.getParameter("valorDeposito"));
                contaPessoaJuridica.depositar(deposito);
                saque = Integer.parseInt(request.getParameter("valorSaque"));
                contaPessoaJuridica.sacar(saque);

                request.setAttribute("resposta", contaPessoaJuridica.getSaldo());
                request.getRequestDispatcher("resposta.jsp").forward(request, response);
            };

        }
    }
}