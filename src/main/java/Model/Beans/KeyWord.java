/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Beans;

import java.util.ArrayList;

/**
 *
 * @author Gohu
 */
public class KeyWord {
    private String word;
    private ArrayList<Integer> internship_ids;
    
    public KeyWord(){
        
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<Integer> getInternship_ids() {
        return internship_ids;
    }

    public void setInternship_ids(ArrayList<Integer> internship_ids) {
        this.internship_ids = (ArrayList<Integer>)internship_ids.clone();
    }
}