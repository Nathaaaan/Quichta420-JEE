/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;


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
            ArrayList<InternshipInfo> infos = new ArrayList<InternshipInfo>(k.getInternshipInfoCollection());
            for(InternshipInfo info : infos){
                if(info.getInternshipId() == id){
                    words.add(k.getWord());
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
            ArrayList<InternshipInfo> infos = new ArrayList<InternshipInfo>(keyWord.getInternshipInfoCollection());
            boolean is = false;
            for(InternshipInfo info : infos){
                if(info.getInternshipId() == id){
                    is = true;
                    break;
                }
            }
            if(!is){
                words.add(keyWord.getWord());
            }
        }
        
        return words;
    }
    
    
    public static void removeKeyWord(String word, int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        TypedQuery<KeyWord> query = em.createNamedQuery("KeyWord.findByKeyWord", KeyWord.class);
        query.setParameter("keyWord", word);
        KeyWord keyWord = query.getSingleResult();
        TypedQuery<InternshipInfo> qInfo = em.createNamedQuery("InternshipInfo.findByInternshipId",InternshipInfo.class);
        qInfo.setParameter("internshipId", id);
        InternshipInfo info = qInfo.getSingleResult();
        keyWord.getInternshipInfoCollection().remove(info);
        em.getTransaction().begin();
        em.persist(keyWord);
        em.flush();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public static void insertKeyWord(String word, int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        KeyWord keyWord = new KeyWord(word);
        em.persist(keyWord);
        em.flush();
        em.getTransaction().commit();
        em.close();
        emf.close();
        addKeyWord(word, id);
    }
    
    public static void addKeyWord(String word, int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        TypedQuery<KeyWord> query = em.createNamedQuery("KeyWord.findByKeyWord", KeyWord.class);
        query.setParameter("keyWord", word);
        KeyWord keyWord = query.getSingleResult();
        TypedQuery<InternshipInfo> qInfo = em.createNamedQuery("InternshipInfo.findByInternshipId",InternshipInfo.class);
        qInfo.setParameter("internshipId", id);
        InternshipInfo info = qInfo.getSingleResult();
        keyWord.getInternshipInfoCollection().add(info);
        em.getTransaction().begin();
        em.persist(keyWord);
        em.flush();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
