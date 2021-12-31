package br.com.dio.desafio.dominio;

import lombok.*;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Data
@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Dev {
    private final String nome;

    private final Set<Conteudo> conteudosInscritos;
    private final Set<Conteudo> conteudosConcluidos;

    public void progredir(Bootcamp bootcamp) {
        Optional<Conteudo> conteudo = bootcamp.getConteudos().stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public static class DevBuilder {
        private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
        private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

        public DevBuilder bootcamp(Bootcamp bootcamp) {
            this.conteudosInscritos.addAll(bootcamp.getConteudos());
            return this;
        }
    }
}
