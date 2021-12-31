package br.com.dio.desafio.dominio;

import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Bootcamp {
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private final String nome;
    private final String descricao;

    private final Set<Dev> inscritos;
    private final Set<Conteudo> conteudos;

    public static class BootcampBuilder {
        private Set<Dev> inscritos = new HashSet<>();
        private Set<Conteudo> conteudos = new LinkedHashSet<>();

        public BootcampBuilder inscrever(Dev dev) {
            this.inscritos.add(dev);
            return this;
        }

        public BootcampBuilder conteudo(Conteudo conteudo) {
            this.conteudos.add(conteudo);
            return this;
        }
    }


}
