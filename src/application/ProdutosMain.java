package application;

import java.util.Scanner;
import java.util.ArrayList;
import entities.Produtos;

public class ProdutosMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Produtos> listaProdutos = new ArrayList<>();

        System.out.println("Quantos produtos deseja cadastrar? ");
        int quantidade = sc.nextInt();
        sc.nextLine();
        double totalEstoque = 0;

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Produto: " + (i + 1));

            System.out.println("Digite o nome do produto:");
            String nome = sc.nextLine();

            System.out.println("Digite o preço do produto: ");
            double preco = sc.nextDouble();
            sc.nextLine();

            System.out.println("Digite a quantidade de produtos no estoque: ");
            int estoque = sc.nextInt();
            sc.nextLine();

            listaProdutos.add(new Produtos(nome, preco, estoque));
        }

        System.out.println("Lista de produtos:");
        for (Produtos p : listaProdutos) {
            totalEstoque += p.getPreco() * p.getEstoque();
            System.out.println("Nome:" + p.getNome());
            System.out.printf("Preço: R$ %.2f reais%n", p.getPreco());
            System.out.println("Estoque:" + p.getEstoque() + " unidades");
            System.out.println();

        }
        System.out.println("\nProdutos com estoque baixo:");
        for (Produtos p : listaProdutos) {
            if (p.getEstoque() < 5) {
                System.out.println(p.getNome() + " (" + p.getEstoque() + " unidades)");
            }
        }
        System.out.println();
        System.out.printf("Valor total do estoque: R$ %.2f reais%n", totalEstoque);

        sc.close();
    }

}
