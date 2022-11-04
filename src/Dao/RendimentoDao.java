package Dao;

import Banco.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Rendimento;

/**
 *
 * @author Massingue
 */
public class RendimentoDao {
     //metodo  que adiciona rendimento ao banco de dados
    public void cadastrar(Rendimento p){
        Connection con=Conectar.getConection();
        String sql="INSERT INTO rendimentos (tipoRendimento,rendimento,periodo,fonteRendimento) VALUES(?,?,?,?)";
        try(PreparedStatement smt= con.prepareStatement(sql)){
            smt.setString(1, p.getTipoRendimento());
            smt.setDouble(2, p.getRendimento());
            smt.setString(3, p.getPeriodo());
            smt.setString(4,p.getFonteRendimento());        
            smt.executeUpdate();
            smt.close();
            con.close();// para nao sobrecarregar o sistema
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null,"erro ao cadastrar"+ex.getMessage());            
            ex.printStackTrace();
        }
    }
     public void actualizar(Rendimento p){
         // metodo para actualizar 
        Connection con=Conectar.getConection();
        String sql="UPDATE  rendimentos SET tipoRendimento=?, rendimento=?, periodo=?, fonteRendimento=? WHERE id=?";
        try(PreparedStatement smt= con.prepareStatement(sql)){
           smt.setString(1, p.getTipoRendimento());
           smt.setDouble(2, p.getRendimento());
           smt.setString(3, p.getPeriodo());
           smt.setString(4, p.getFonteRendimento());
           smt.setInt(5,p.getId());
           smt.executeUpdate();
           smt.close();
           con.close();// para nao sobrecarregar o sistema
           JOptionPane.showMessageDialog(null,"Actualizado com sucesso!");
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null,"erro ao actualiar o registro"+ex.getMessage());
            ex.printStackTrace();
    }    
    }
    
     public void excluir(Rendimento p){
         // metodo para excluir dados no banco de dados
     
        Connection con =Conectar.getConection();
        String sql="DELETE FROM rendimentos WHERE id=?";
        int opcao=JOptionPane.showConfirmDialog(null,"Deseja exluir o rendimento "+p.getFonteRendimento()+" ?","Exluir",JOptionPane.YES_NO_OPTION);
        if(opcao==JOptionPane.YES_NO_OPTION){
            try(PreparedStatement smt= con.prepareStatement(sql)){
                smt.setInt(1,p.getId());
                smt.executeUpdate();
                smt.close();
                con.close();
                JOptionPane.showMessageDialog(null,"Excluido com sucesso");
            }catch(Exception ex){
                //JOptionPane.showMessageDialog(null,"Erro ao excluir o registro");
                ex.printStackTrace();
            }
        }
     }
    
     public List<Rendimento> listar(){
        Connection con =Conectar.getConection();
        List<Rendimento> lista=new ArrayList<>();

        String sql="SELECT * FROM rendimentos";// para ordenar atraves da fonte de rendimento 
        try(PreparedStatement smt =con.prepareStatement(sql)){
          ResultSet resulto=smt.executeQuery();
          while (resulto.next()){
              Rendimento p =new Rendimento();
              p.setId(resulto.getInt("id"));
              p.setTipoRendimento(resulto.getNString("tipoRendimento"));
              p.setRendimento(resulto.getDouble("rendimento"));
              p.setPeriodo(resulto.getNString("periodo"));
              p.setFonteRendimento(resulto.getNString("fonteRendimento"));
              lista.add(p);
          }
       }catch(Exception ex){
          //JOptionPane.showMessageDialog(null,"Erro ao buscar o registro");  
          ex.printStackTrace();
       }
     
       return lista;//vai nos retornar a lista
  }
    
}
