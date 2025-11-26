package Principal;

import modelo.*;
import servico.Catalogo;
import servico.MidiaNaoEncontradaException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MidiaNaoEncontradaException {
        Catalogo meuCatalogo = new Catalogo();
        Scanner scan = new Scanner(System.in);

        meuCatalogo.adicionarMidia(new Musica() {
            @Override
            public void exibirInfor() {

            }
        });

        while (true) {
            System.out.println("Bem vindo ao menu principal Do Spotify ");
            System.out.println("\nOpçoes disponiveis:\n1-Musicas.\n2-Podcast\n3-Audiosbooks.\n0-sair.");
            System.out.print("\nDigite a opçao disponivel: ");
            String opcao = scan.nextLine();

            if (opcao.equals("1")) {
                System.out.println("Bem vindo a Central de Musicas.");
                System.out.println("\n1-Pesquisar musicas Existentes\n2-Adicionar musica\n3-Remover Musica ");
                System.out.print("Digite Qual funçao voce deseja acessar: ");
                String opcaomusica = scan.nextLine();

                switch (opcaomusica) {
                    case "1":
                        System.out.print("Digite a musica que voce deseja Pesquisar: ");
                        String titulo = scan.nextLine();

                        try {
                            Midia midiaEncontrada = meuCatalogo.buscarPorTitulo(titulo);
                            System.out.println("\nMúsica encontrada!");
                            System.out.println("Título: " + midiaEncontrada.getTitulo());
                            System.out.println("Artista: " + midiaEncontrada.getArtista());
                            System.out.println("Duraçao: " + midiaEncontrada.getDuracao());
                        } catch (MidiaNaoEncontradaException e) {
                            System.err.println("\nErro: " + e.getMessage());
                        }
                        break;

                    case "2":
                        System.out.print("Digite o título da música: ");
                        String novoTitulo = scan.nextLine();

                        System.out.print("Digite o artista da música: ");
                        String novoArtista = scan.nextLine();

                        System.out.print("Digite a duração da música (em segundos): ");
                        double novaDuracao = Double.parseDouble(scan.nextLine());

                        System.out.print("Digite o gênero da música: ");
                        String generoStr = scan.nextLine();
                        Genero novoGenero = Genero.valueOf(generoStr.toUpperCase());

                        Musica novaMusica = new Musica(novoTitulo, novoArtista, novaDuracao, novoGenero) {
                            @Override
                            public void exibirInfor() {
                                System.out.println("Título: " + getTitulo() +
                                        " | Artista: " + getArtista() +
                                        " | Duração: " + getDuracao() +
                                        " | Gênero: " + getGenero());
                            }
                        };

                        meuCatalogo.adicionarMidia(novaMusica);
                        System.out.println("Música adicionada com sucesso!");
                        break; 

                    case "3":
                        System.out.print("Digite o titulo da musica que Deseja remover: ");
                        String RemoverMusica = scan.nextLine();
                        try {
                            meuCatalogo.removerPorTitulo(RemoverMusica);
                            System.out.println("O titulo foi removido com sucesso! ");
                        } catch (MidiaNaoEncontradaException e) {
                            System.err.println("Titulo Nao encontrado" + e.getMessage());
                        }
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            } else if (opcao.equals("0")) {
                System.out.println("Saindo...");
                scan.close();
                break;

            } else if (opcao.equals("2")) {
                System.out.println("Bem vindo a central de podcasts");
                System.out.println("\n1-Pesquisar Episodios Existentes\n2-Adicionar novo episodio\n3-Remover Episodio ");
                System.out.print("Digite Qual funçao voce deseja acessar: ");
                String opcaopodcast = scan.nextLine();

                switch (opcaopodcast) {
                    case "1":
                        System.out.print("Digite o titulo do Episodio que voce deseja: ");
                        String tituloPodcast = scan.nextLine();

                        try {
                            Midia podcastEncontrado = meuCatalogo.buscarPorTitulo(tituloPodcast);
                            System.out.println("\nPodcast encontrado!");
                            System.out.println("Título: " + podcastEncontrado.getTitulo());
                            System.out.println("Apresentador: " + podcastEncontrado.getArtista());
                            System.out.println("Duração: " + podcastEncontrado.getDuracao());
                        } catch (MidiaNaoEncontradaException e) {
                            System.err.println("\nErro: " + e.getMessage());
                        }
                        break;

                    case "2":
                        System.out.print("Digite o título do novo episódio: ");
                        String novoTituloPodcast = scan.nextLine();

                        System.out.print("Digite o nome do apresentador: ");
                        String novoApresentador = scan.nextLine();

                        System.out.print("Digite a duração do episódio (em segundos): ");
                        double novaDuracaoPodcast = Double.parseDouble(scan.nextLine());

                        Podcast novoPodcast = new Podcast(novoTituloPodcast, novoApresentador, novaDuracaoPodcast, Genero.PODCAST) {
                            @Override
                            public void exibirInfor() {
                                System.out.println("Título: " + getTitulo() +
                                        " | Apresentador: " + getArtista() +
                                        " | Duração: " + getDuracao() +
                                        " | Gênero: " + getGenero());
                            }
                        };

                        meuCatalogo.adicionarMidia(novoPodcast);
                        System.out.println("Podcast adicionado com sucesso!");
                        break;

                    case "3":
                        System.out.print("Digite o titulo do podcast que deseja remover: ");
                        String removerPodcast = scan.nextLine();
                        try {
                            meuCatalogo.removerPorTitulo(removerPodcast);
                            System.out.println("O podcast foi removido com sucesso!");
                        } catch (MidiaNaoEncontradaException e) {
                            System.err.println("Podcast não encontrado" + e.getMessage());
                        }
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            } else if (opcao.equals("3")) {
                System.out.println("Bem vindo a central de Audiobooks");
                System.out.println("\n1-Pesquisar Audiobooks Existentes\n2-Adicionar novo audiobook\n3-Remover Audiobook ");
                System.out.print("Digite Qual funçao voce deseja acessar: ");
                String opcaoAudiobook = scan.nextLine();

                switch (opcaoAudiobook) {
                    case "1":
                        System.out.print("Digite o título do Audiobook que voce deseja: ");
                        String tituloAudiobook = scan.nextLine();

                        try {
                            Midia audiobookEncontrado = meuCatalogo.buscarPorTitulo(tituloAudiobook);
                            System.out.println("\nAudiobook encontrado!");
                            System.out.println("Título: " + audiobookEncontrado.getTitulo());
                            System.out.println("Narrador: " + audiobookEncontrado.getArtista());
                            System.out.println("Duraçao: " + audiobookEncontrado.getDuracao());
                        } catch (MidiaNaoEncontradaException e) {
                            System.err.println("\nErro: " + e.getMessage());
                        }
                        break;

                    case "2":
                        System.out.print("Digite o título do novo audiobook: ");
                        String novoTituloAudiobook = scan.nextLine();

                        System.out.print("Digite o nome do narrador: ");
                        String novoNarrador = scan.nextLine();

                        System.out.print("Digite a duração do audiobook (em segundos): ");
                        double novaDuracaoAudiobook = Double.parseDouble(scan.nextLine());

                        Audiobook novoAudiobook = new Audiobook(novoTituloAudiobook, novoNarrador, novaDuracaoAudiobook, Genero.AUDIOBOOK) {
                            @Override
                            public void exibirInfor() {
                                System.out.println("Título: " + getTitulo() +
                                        " | Narrador: " + getArtista() +
                                        " | Duração: " + getDuracao() +
                                        " | Gênero: " + getGenero());
                            }
                        };

                        meuCatalogo.adicionarMidia(novoAudiobook);
                        System.out.println("Audiobook adicionado com sucesso!");
                        break;

                    case "3":
                        System.out.print("Digite o título do audiobook que dEseja remover: ");
                        String removerAudiobook = scan.nextLine();
                        try {
                            meuCatalogo.removerPorTitulo(removerAudiobook);
                            System.out.println("O audiobook foi removido com sucesso");
                        } catch (MidiaNaoEncontradaException e) {
                            System.err.println("Audiobook não encontrado" + e.getMessage());
                        }
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }else {
                System.out.println("Opção inválida!");
            }
        }
    }
}