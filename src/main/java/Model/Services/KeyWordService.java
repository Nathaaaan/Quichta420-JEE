/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;

import Database.InternDAOImpl;
import Model.Beans.KeyWord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gohu
 */
public class KeyWordService {
    public KeyWord createKeyWordModel(ResultSet rs) throws SQLException{
        KeyWord keyWord = new KeyWord();
        keyWord.setWord(rs.getString("key_word"));
        keyWord.setInternship_ids(new ArrayList<Integer>());
        
        return keyWord;
    }
    
    public ArrayList<KeyWord> getAllKeyWords() throws SQLException{
        ArrayList<KeyWord> keyWords = new ArrayList<KeyWord>();
        InternDAOImpl intern = new InternDAOImpl();
        ResultSet rs = intern.getAllKeyWords();
        while(rs.next()){
            keyWords.add(createKeyWordModel(rs));
        }
        
        for(KeyWord keyWord : keyWords){
            rs = intern.getInternshipIdByKeyWord(keyWord.getWord());
            while(rs.next()){
                keyWord.getInternship_ids().add(rs.getInt("internship_id"));
            }
        }
        
        return keyWords;
    }
    
    public ArrayList<String> getAllKeyWordsOf(int id) throws SQLException{
        ArrayList<String> keyWords = new ArrayList<String>();
        InternDAOImpl inter = new InternDAOImpl();
        ResultSet rs = inter.getAllKeyWordsOf(id);
        
        while(rs.next()){
            keyWords.add(rs.getString("key_word"));
        }
        
        return keyWords;
    }
    
    public ArrayList<String> getAllKeyWordsExceptOf(int id) throws SQLException{
        ArrayList<String> keyWords = new ArrayList<String>();
        InternDAOImpl inter = new InternDAOImpl();
        ResultSet rs = inter.getAllKeyWordsExceptOf(id);
        
        while(rs.next()){
            keyWords.add(rs.getString("key_word"));
        }
        
        return keyWords;
    }
    
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
    }
}
