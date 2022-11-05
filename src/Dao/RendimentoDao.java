package Dao;

import Banco.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Rendimento;

/**
 *
 * @author Massingue
 */
public class RendimentoDao {
    
    public static boolean cadastrar(Rendimento p){        
        String sql="INSERT INTO `gestaofinanceira`.`rendimentos` (`tipoRendimento`, `rendimento`, `periodo`, `fonteRendimento`, `utilizador_fk`) VALUES (?, ?, ?, ?, ?)";
        
        try{
            Connection con = Conectar.getConection();
            PreparedStatement smt= con.prepareStatement(sql);
            smt.setString(1, p.getTipoRendimento());
            smt.setDouble(2, p.getRendimento());
            smt.setString(3, p.getPeriodo());
            smt.setString(4,p.getFonteRendimento());        
            smt.setInt(5, p.getUtilizador_fk());
            smt.executeUpdate();
            Conectar.closeConnection(con, smt);
            
            return true;
        }catch(Exception ex){          
            ex.printStackTrace();
        }
        
        return false;
    }
     public static boolean actualizar(Rendimento p){        
        String sql="UPDATE  `gestaofinanceira`.`rendimentos` SET `tipoRendimento` = ?, `rendimento` = ?, `periodo` = ?, `fonteRendimento` = ? WHERE `id` = ?";
        
        try{
           Connection con=Conectar.getConection();
           PreparedStatement smt= con.prepareStatement(sql);
           smt.setString(1, p.getTipoRendimento());
           smt.setDouble(2, p.getRendimento());
           smt.setString(3, p.getPeriodo());
           smt.setString(4, p.getFonteRendimento());
           smt.setInt(5, p.getId());
           smt.executeUpdate();
           Conectar.closeConnection(con, smt);
           
           return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }    
        
        return false;
    }
    
     public static boolean excluir(Rendimento p){
        String sql="DELETE FROM `gestaofinanceira`.`rendimentos` WHERE `id` = ?";

        try{
            Connection con =Conectar.getConection();
            PreparedStatement smt= con.prepareStatement(sql);
            smt.setInt(1,p.getId());
            smt.executeUpdate();
            Conectar.closeConnection(con, smt);

            return true;
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null,"Erro ao excluir o registro");
            ex.printStackTrace();
        }        
        
        return false;
     }
    
    public static List<Rendimento> listar(int id, String chave){        
        List<Rendimento> lista=new ArrayList<>();
        String sql="SELECT * FROM `gestaofinanceira`.`rendimentos` WHERE `utilizador_fk` = ? ORDER BY `fonteRendimento`";// para ordenar atraves da fonte de rendimento 
        String sql2 = "SELECT * FROM `gestaofinanceira`.`rendimentos` WHERE `fonteRendimento` LIKE '" + chave + "%' AND `utilizador_fk` = " + id;
        try{
            Connection con = Conectar.getConection();
            PreparedStatement smt;
            
            if(chave.equals("")) {
                smt = con.prepareStatement(sql);
                smt.setInt(1, id);
            }else
                smt = con.prepareStatement(sql2);
            
            
            ResultSet resulto = smt.executeQuery();
            
            while (resulto.next()){
                Rendimento p = new Rendimento();
                p.setId(resulto.getInt("id"));
                p.setTipoRendimento(resulto.getNString("tipoRendimento"));
                p.setRendimento(resulto.getDouble("rendimento"));
                p.setPeriodo(resulto.getNString("periodo"));
                p.setFonteRendimento(resulto.getNString("fonteRendimento"));
                p.setUtilizador_fk(resulto.getInt("utilizador_fk"));
                lista.add(p);
            }

            Conectar.closeConnection(con, smt, resulto);
       }catch(Exception ex){
          //JOptionPane.showMessageDialog(null,"Erro ao buscar o registro");  
          ex.printStackTrace();
       }
     
        return lista;
    }
         
}