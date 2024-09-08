package br.com.g5.agendacontatos.filme;

import br.com.g5.agendacontatos.util.Verificador;

import java.util.List;
import java.util.Scanner;

public class FilmeService extends Filme {
    Scanner sc = new Scanner(System.in);

    public Filme requisitarFilmeNoTerminal(List<Filme> filmes) {
        System.out.print("Digite o título: ");
        String titulo = sc.nextLine();
        do {
            if (filmeIsDuplicado(filmes,titulo)) {
                System.out.print("Filme ja existe na lista, adicione outro: ");
                titulo = sc.nextLine();
            }
        } while (filmeIsDuplicado(filmes,titulo));
        System.out.print("Digite a nota para o filme: ");
        Double nota = sc.nextDouble();
        return new Filme(titulo, nota);
    }

    public boolean filmeIsDuplicado(List<Filme> filmes, String nomeFilme) {
        return filmes.stream().anyMatch(x->x.getNome().equals(nomeFilme));
    }

}
