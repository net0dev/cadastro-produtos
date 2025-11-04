package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;


import entity.Produtos;
import connectionFactory.Conexao;

public class ProdutoDAO {

    public void cadastrarProduto(Produtos produto) {
        String sql = "  INSERT INTO produtos (nome, preco, estoque) VALUES (?,?,?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setInt(3, produto.getEstoque());
            ps.execute();

            System.out.println("Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            System.err.println("ERRO AO INSERIR OS DADOS DO PRODUTO: " + e.getMessage());

        }

    }

    public List<Produtos> listarProdutos() {
        List<Produtos> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection conn = Conexao.getConexao();
             Statement smt = conn.createStatement();
             ResultSet rs = smt.executeQuery(sql)) {

            while (rs.next()) {

                Produtos p = new Produtos();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setEstoque(rs.getInt("estoque"));
                lista.add(p);

            }

        } catch (SQLException e) {
            System.err.println("ERRO AO LISTAR PRODUTOS: " + e.getMessage());

        }
        return lista;

    }

    public void atualizarProduto(Produtos produto) {
        String sql = " UPDATE produtos SET nome=?, preco=?, estoque=? WHERE id =? ";


        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {


            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setInt(3, produto.getEstoque());
            ps.setInt(4, produto.getId());

            ps.executeUpdate();
            System.out.println("\nProduto atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("ERRO AO ATUALIZAR O PRODUTO: " + e.getMessage());
        }
    }

        public void apagarProduto(Produtos produto){

            String sql = "DELETE FROM produtos WHERE id = ?";

           try(Connection conexao = Conexao.getConexao();
                   PreparedStatement ps = conexao.prepareStatement(sql)) {

               ps.setInt(1, produto.getId());
               ps.executeUpdate();
               System.out.println("Produto apagado com sucesso!");

           } catch(SQLException e){
               System.out.println("ERRO AO DELETAR PRODUTO: " + e.getMessage());

           }


        }



}



