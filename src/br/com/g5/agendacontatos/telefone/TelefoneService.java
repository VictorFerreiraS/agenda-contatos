package br.com.g5.agendacontatos.telefone;

import br.com.g5.agendacontatos.contato.Contato;

import java.util.List;
import java.util.Scanner;

public class TelefoneService extends Telefone{

    Scanner sc = new Scanner(System.in);
    public Telefone requisitarTelefoneNoTerminal(List<Contato> contatos) {
        Telefone telefone = new Telefone();
        System.out.println("Digite o numero de telefone:");
        String numero = sc.next();
        do {
            if (!isTelefoneValido(numero)) {
                System.out.print("Formato de telefone inválido, tente novamente: ");
                numero = sc.next();
            } else if (checarSeTelefoneExiste(contatos, numero)) {
                System.out.print("Telefone ja existe, tente novamente: ");
                numero = sc.next();
            }
        } while (!isTelefoneValido(numero) || checarSeTelefoneExiste(contatos,numero));
        telefone.setNumero(numero);
        System.out.println("""
                Escolha o tipo do telefone:\s
                
                 1 - Celular\
                
                 2 - Casa\
                
                 3 - Trabalho\
                
                 4 - Escola\
                
                 5 - Principal\
                
                 6 - Outro""");
        int opcao = sc.nextInt();
        super.setTipo(opcao);
        return telefone;
    }

    public String requisitarStringTelefoneNoTerminal() {
        System.out.println("Escreva o número que deseja localizar:");
        return sc.nextLine();
    }

    public Boolean checarSeTelefoneExiste(List<Contato> contatos, String numero) {
        return contatos.stream().anyMatch(x->x.getNumeroTelefone().equals(numero));
    }

    public boolean isTelefoneValido(String numero) {
        return numero.matches("^[0-9]{8,11}");
    }

}
