/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Dao.*;
import Banco.Conectar;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Despesa;
import model.Gasto;
import model.Rendimento;
import model.SimuladorEmprestimos;
import view.EmuladorDeGastos.SimuladorDeGastos;
import view.menu.MenuView;

/**
 *
 * @author berna
 */
public class GastosDAO {

    public static boolean guardar(Gasto gasto) {
        Connection conexao = Conectar.getConection();
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        try {
          
           //Query para inserir dados na tabela de gastos
            statement = conexao.prepareStatement("INSERT INTO gastos (utilizador_id,valor_gasto,fonte_valor,prioridade,descricao,valor_poupado,categoria)VALUES(?,?,?,?,?,?,?)");
            statement.setInt(1, MenuView.user.getId());
            statement.setDouble(2, gasto.getValorGasto());
            statement.setString(3, gasto.getFonteValor());
            statement.setString(4, gasto.getPrioridade());
            statement.setString(5, gasto.getDescricao());
            statement.setDouble(6, gasto.getValorPoupado());
            statement.setString(7, gasto.getCategoria());
            
            statement.executeUpdate();
            

            JOptionPane.showMessageDialog(null, "Gasto  salvo com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            Conectar.closeConnection(conexao, statement);
        }

        return true;
    }

    public static List<Rendimento> carregarRendimentos() {
        List<Rendimento> listaRendimento = new ArrayList<>();
        List<Despesa> listaDespesa = new ArrayList<>();

        String sql1 = "SELECT * FROM `gestaofinanceira`.`rendimentos` WHERE `utilizador_id` = " + MenuView.user.getId();
        try {
            Connection con = Conectar.getConection();
            PreparedStatement smt = con.prepareStatement(sql1);

            ResultSet resulto = smt.executeQuery();

            while (resulto.next()) {
                Rendimento p = new Rendimento();
                p.setId(resulto.getInt("id"));
                p.setTipoRendimento(resulto.getNString("tipoRendimento"));
                p.setRendimento(resulto.getDouble("rendimento"));
                p.setPeriodo(resulto.getNString("periodo"));
                p.setFonteRendimento(resulto.getNString("fonteRendimento"));
                listaRendimento.add(p);
            }

            Conectar.closeConnection(con, smt, resulto);
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null,"Erro ao buscar o registro");  
            ex.printStackTrace();
        }

        return listaRendimento;
    }

    public static List<Despesa> carregarDespesas() {

        List<Despesa> listaDespesa = new ArrayList<>();

        String sql1 = "SELECT * FROM `gestaofinanceira`.`despesas` WHERE `utilizador_id` = " + MenuView.user.getId();
        try {
            Connection con = Conectar.getConection();
            PreparedStatement smt = con.prepareStatement(sql1);

            ResultSet resulto = smt.executeQuery();

            while (resulto.next()) {
                Despesa d = new Despesa();
                d.setCusto(resulto.getDouble("custo"));
                d.setPrioridade(resulto.getNString("prioridade"));
                d.setTipoDespesa(resulto.getNString("tipoDespesa"));
                d.setCategoria(resulto.getNString("categoria"));
                listaDespesa.add(d);
            }

            Conectar.closeConnection(con, smt, resulto);
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null,"Erro ao buscar o registro");  
            ex.printStackTrace();
        }

        return listaDespesa;
    }

    public static List<Gasto> fillTable() {

        List<Gasto> gastos = new ArrayList<>();
        String sql = "SELECT * FROM `gestaofinanceira`.`gastos` WHERE `utilizador_id` = " + MenuView.user.getId();

        try {
            Connection con = Conectar.getConection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs = smt.executeQuery();

            while (rs.next()) {

                Gasto gasto = new Gasto();
                gasto.setCategoria(rs.getNString("categoria"));
                gasto.setDescricao(rs.getNString("descricao"));
                gasto.setFonteValor(rs.getNString("fonte_valor"));
                gasto.setPrioridade(rs.getNString("prioridade"));
                gasto.setValorGasto(rs.getDouble("valor_gasto"));
                gasto.setValorPoupado(rs.getDouble("valor_poupado"));

                gastos.add(gasto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GastosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gastos;
    }

}
