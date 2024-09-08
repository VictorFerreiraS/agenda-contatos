package br.com.g5.agendacontatos.contato;

import br.com.g5.agendacontatos.filme.FilmeService;
import br.com.g5.agendacontatos.telefone.TelefoneService;
import br.com.g5.agendacontatos.util.Verificador;

import java.util.List;
import java.util.Scanner;

public class ContatoService extends  Contato{
    TelefoneService telefoneService = new TelefoneService();
    FilmeService filmeService = new FilmeService();


    public Contato requisitarContatoNoTerminal(List<Contato> contatos) {
        Contato contato = new Contato();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        contato.setNome(sc.nextLine());
        contato.setTelefone(telefoneService.requisitarTelefoneNoTerminal(contatos));
        System.out.println("Digite o endereço: ");
        contato.setEndereco(sc.nextLine());
        System.out.println("Digite o e-mail: ");
        String email = sc.nextLine();
        do {
            if (!Verificador.emailIsValido(email)) {
                System.out.print("Formato inválido, tente novamente: ");
                email = sc.nextLine();
            }
        } while (!Verificador.emailIsValido(email));
        contato.setEmail(email);


        System.out.println("Contato salvo com sucesso");
        return  contato;
    }


    public void detalharContato(Contato contato) {
        StringBuilder sb = new StringBuilder();
        sb.append("Contato {")
                .append("\n  Nome: ").append(contato.getNome())
                .append("\n  Email: ").append(contato.getEmail())
                .append("\n  Endereço: ").append(contato.getEmail())
                .append("\n  Telefone: ").append(contato.getNumeroTelefone())
                .append("\n  Filmes: ").append(contato.getListaFilmes())
                .append("\n}");

        System.out.println(sb);
    }

    public void adicionarFilmeEmContato(Contato contato) {
        contato.cadastrarFilme(filmeService.requisitarFilmeNoTerminal(contato.getListaFilmes()));
    }

}
