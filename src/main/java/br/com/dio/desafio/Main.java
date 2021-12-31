package br.com.dio.desafio;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = Curso.builder()
                .titulo("curso java")
                .descricao("descrição curso java")
                .cargaHoraria(8).build();

        Curso curso2 = Curso.builder()
                .titulo("curso js")
                .descricao("descrição curso js")
                .cargaHoraria(4).build();

        Mentoria mentoria = Mentoria.builder()
                .titulo("mentoria de java")
                .descricao("descrição mentoria java")
                .data(LocalDate.now())
                .build();

        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);

        Bootcamp bootcamp = Bootcamp.builder()
                .nome("Bootcamp Java Developer")
                .descricao("Descrição Bootcamp Java Developer")
                .conteudo(curso2)
                .conteudo(mentoria)
                .build();

        Dev devCamila = Dev.builder()
                .nome("Camila")
                .bootcamp(bootcamp)
                .build();

        Dev devJoao = Dev.builder()
                .nome("Joao")
                .bootcamp(bootcamp)
                .build();

        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir(bootcamp);
        devCamila.progredir(bootcamp);
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());

        System.out.println("-------");

        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir(bootcamp);
        devJoao.progredir(bootcamp);
        devJoao.progredir(bootcamp);
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());

    }

}
