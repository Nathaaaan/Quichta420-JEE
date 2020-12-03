/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;

import Database.InternDAOImpl;
import Model.Beans.InternshipInfo;
import Model.Beans.KeyWord;
import static Utils.Constants.PERSISTENCE_UNIT;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gohu
 */
public class KeyWordService {/*
    public KeyWord createKeyWordModel(ResultSet rs) throws SQLException{
        KeyWord keyWord = new KeyWord();
        keyWord.setWord(rs.getString("key_word"));
        keyWord.setInternship_ids(new ArrayList<Integer>());
        
        return keyWord;
    }*/
    
    public static ArrayList<KeyWord> getAllKeyWords(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        TypedQuery<KeyWord> query = em.createNamedQuery("KeyWord.findAll", KeyWord.class);
        List<KeyWord> res = query.getResultList();
        return new ArrayList<>(res);
    }
    
    public static ArrayList<String> getAllKeyWordsOf(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        TypedQuery<KeyWord> query = em.createNamedQuery("KeyWord.findAll", KeyWord.class);
        List<KeyWord> res = query.getResultList();
        ArrayList<String> words = new ArrayList<String>();
        for(KeyWord k : res){
            ArrayList<InternshipInfo> infos = new ArrayList<InternshipInfo>(k.getInternshipinfoCollection());
            for(InternshipInfo info : infos){
                if(info.getInternshipId() == id){
                    words.add(k.getKeyWord());
                }
            }
        }
        return words;
    }
    
    public static ArrayList<String> getAllKeyWordsExceptOf(int id){
        ArrayList<String> words = new ArrayList<String>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        TypedQuery<KeyWord> query = em.createNamedQuery("KeyWord.findAll", KeyWord.class);
        List<KeyWord> res = query.getResultList();
        ArrayList<KeyWord> keyWords = new ArrayList<KeyWord>(res);
        for(KeyWord keyWord : keyWords){
            ArrayList<InternshipInfo> infos = new ArrayList<InternshipInfo>(keyWord.getInternshipinfoCollection());
            boolean is = false;
            for(InternshipInfo info : infos){
                if(info.getInternshipId() == id){
                    is = true;
                    break;
                }
            }
            if(!is){
                words.add(keyWord.getKeyWord());
            }
        }
        
        return words;
    }
    
    /*
    public void removeKeyWord(String keyWord, int id) throws SQLException{
        InternDAOImpl inter = new InternDAOImpl();
        inter.removeKeyWord(keyWord,id);
    }
    
    public void insertKeyWord(String keyWord, int id) throws SQLException{
        InternDAOImpl inter = new InternDAOImpl();
        inter.insertKeyWord(keyWord);
        addKeyWord(keyWord,id);
    }
    
    public void addKeyWord(String keyWord, int id) throws SQLException{
        InternDAOImpl inter = new InternDAOImpl();
        inter.addKeyWord(keyWord,id);
    }*/
}
