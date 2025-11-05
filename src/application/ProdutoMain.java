package application;


import java.util.Scanner;

import DAO.ProdutoDAO;

import java.util.List;

import entity.Produtos;

public class ProdutoMain {


    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ProdutoDAO pd = new ProdutoDAO();

            int opcao = 0;

            do {
                System.out.println("------MENU------");
                System.out.println("1-Cadastrar produto");
                System.out.println("2-Exibir produto");
                System.out.println("3-Atualizar produto ");
                System.out.println("4-Apagar produto");
                System.out.println("5-Sair");

                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("Cadastrando produto");
                        cadastrarProduto(sc);
                        break;
                    case 2:
                        System.out.println("Exibindo produtos");
                        exibirDadosProdutos(sc);
                        break;
                    case 3:
                        System.out.println("Atualizando dados");
                        atualizarProdutos(sc);
                    case 4:
                        System.out.println("Apagando produto sistema");
                        apagarProduto(sc);
                        break;
                    case 5:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        break;

                }


            } while (opcao != 5);

        }
    }


    public static void cadastrarProduto(Scanner sc) {
        ProdutoDAO pd = new ProdutoDAO();
        Produtos p = new Produtos();

        System.out.println("Qual o nome do produto que você deseja cadastrar?");
        p.setNome(sc.nextLine());
        System.out.println("Qual o valor do produto?");
        p.setPreco(sc.nextDouble());
        System.out.println("Qual a quantidade de produtos?");
        p.setEstoque(sc.nextInt());

        pd.cadastrarProduto(p);
    }


    public static void exibirDadosProdutos(Scanner sc) {
        ProdutoDAO pd = new ProdutoDAO();
        List<Produtos> produtos = pd.listarProdutos();
        for (Produtos p : produtos) {
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Preço: " + p.getPreco());
            System.out.println("Quantidade em estoque: " + p.getEstoque());
            System.out.println();

        }


    }


    public static void atualizarProdutos(Scanner sc) {
        ProdutoDAO pd = new ProdutoDAO();
        Produtos p = new Produtos();

        System.out.println("Digite o ID do produto que deseja alterar: ");
        p.setId(sc.nextInt());
        sc.nextLine(); // limpa o buffer

        System.out.print("Novo nome: ");
        p.setNome(sc.nextLine());

        System.out.print("Novo preço: ");
        p.setPreco(sc.nextDouble());

        System.out.print("Novo estoque: ");
        p.setEstoque(sc.nextInt());
        sc.nextLine();

        pd.atualizarProduto(p);


    }

    public static void apagarProduto(Scanner sc) {
        ProdutoDAO pd = new ProdutoDAO();
        Produtos p = new Produtos();

        System.out.println("Digite o ID do produto que você deseja apagar: ");
        int id = sc.nextInt();

        p.setId(id);
        pd.apagarProduto(p);

    }
}


