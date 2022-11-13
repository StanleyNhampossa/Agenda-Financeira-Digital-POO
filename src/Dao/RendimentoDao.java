package Dao;

import Banco.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Rendimento;

/**
 * Classe responsável por estabelecer a comunicação entre a tela de rendimentos
 * com a tabela de rendimentos na base de dados
 * @author Massingue
 */
public class RendimentoDao {
    
    /**
     * Realiza o cadastro de rendimentos na base de dados.
     * @param p o rendimento a ser cadastrado
     * @return {@code true} se o cadastro for executado com êxito, 
     * ou {@code false} se não for concluído com sucesso
     */
    public static boolean cadastrar(Rendimento p){        
        String sql = "INSERT INTO `gestaofinanceira`.`rendimentos` (`tipoRendimento`, `rendimento`,`fonteRendimento`, `utilizador_id`) VALUES (?, ?, ?, ?)";
        
        try{
            Connection con = Conectar.getConection();
            PreparedStatement smt= con.prepareStatement(sql);
            smt.setString(1, p.getTipoRendimento());
            smt.setDouble(2, p.getRendimento());
            smt.setString(3,p.getFonteRendimento());        
            smt.setInt(4, p.getUtilizador_id());
            smt.executeUpdate();
            Conectar.closeConnection(con, smt);
            
            return true;
        }catch(Exception ex){          
            ex.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * Realiza a actualização de rendimentos na base de dados.
     * @param p objecto com os dados do rendimento a ser actualizado
     * @return {@code true} se a ação tiver sido executada com sucesso,
     * {@code false} se a operação não for conluída
     */
    public static boolean actualizar(Rendimento p){        
        String sql = "UPDATE  `gestaofinanceira`.`rendimentos` SET `tipoRendimento` = ?, `rendimento` = ?, `fonteRendimento` = ? WHERE `id` = ?";
        
        try{
           Connection con=Conectar.getConection();
           PreparedStatement smt= con.prepareStatement(sql);
           smt.setString(1, p.getTipoRendimento());
           smt.setDouble(2, p.getRendimento());
           smt.setString(3, p.getFonteRendimento());
           smt.setInt(4, p.getId());
           smt.executeUpdate();
           Conectar.closeConnection(con, smt);
           
           return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }    
        
        return false;
    }
    
    /**
     * Realiza a exclusão de rendimentos na base de dados
     * @param p objecto com os dados do rendimento a ser excluído
     * @return {@code true} se a ação for executada com sucesso,
     * {@code false} caso contrário
     */
    public static boolean excluir(Rendimento p){
        String sql = "DELETE FROM `gestaofinanceira`.`rendimentos` WHERE `id` = ?";

        try{
            Connection con = Conectar.getConection();
            PreparedStatement smt = con.prepareStatement(sql);
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
    
    /**
     * Faz a listagem com filtro por utilizador e por designação(opcional) 
     * dos rendimentos que estão na base de dados
     * @param id o id do utilizador associado
     * @param chave a designação do rendimento
     * @return a lista de rendimentos já cadastrados para o utilizador com id igual a {@code id} e chave igual ou similar a {@code chave}
     */
    public static List<Rendimento> listar(int id, String chave){        
        List<Rendimento> lista = new ArrayList<>();
        String sql = "SELECT * FROM `gestaofinanceira`.`rendimentos` WHERE `utilizador_id` = ? ORDER BY `fonteRendimento`";// para ordenar atraves da fonte de rendimento 
        String sql2 = "SELECT * FROM `gestaofinanceira`.`rendimentos` WHERE `fonteRendimento` LIKE '" + chave + "%' AND `utilizador_id` = " + id;
        try{
            Connection con = Conectar.getConection();
            PreparedStatement smt;
            
            //Se a chave for vazia, fará a listagem de todos os rendimentos associados ao utilizador identificado
            //caso contrário, será feita a listagem considerando também a designação do rendimento
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
                p.setFonteRendimento(resulto.getNString("fonteRendimento"));
                p.setUtilizador_id(resulto.getInt("utilizador_id"));
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