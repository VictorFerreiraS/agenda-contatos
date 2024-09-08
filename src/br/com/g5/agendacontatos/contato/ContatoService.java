package br.com.g5.agendacontatos.contato;

import br.com.g5.agendacontatos.filme.FilmeService;
import br.com.g5.agendacontatos.telefone.TelefoneService;

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
        contato.setEmail(sc.nextLine());


            System.out.println("Contato salvo com sucesso");
            return  contato;
    }


    public void detalharContato(Contato contato) {
        String sb = "Contato {" +
                "\n  Nome: " + contato.getNome() +
                "\n  Email: " + contato.getEmail() +
                "\n  Endereço: " + contato.getEndereco() +
                "\n  Telefone: " + contato.getNumeroTelefone() +
                "\n  Tipo de telefone: " + contato.getTipoTelefone() +
                "\n  Filmes: " + contato.getListaFilmes() +
                "\n}";

        System.out.println(sb);
    }

    public void adicionarFilmeEmContato(Contato contato) {
        contato.cadastrarFilme(filmeService.requisitarFilmeNoTerminal());
    }

}
