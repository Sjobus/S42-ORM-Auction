/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.domain;

import javax.persistence.Entity;

@Entity
/**
 *
 * @author sibev
 */
public class Painting extends Item {
    
    public String title;
    public String painter;

    public Painting(String title, String painter, User seller, Category category, String description) {
        super(seller, category, description);
        this.title = title;
        this.painter = painter;
    }   
    
    public Painting(){}
    
    public String getTitle() {
        return title;
    }

    public String getPainter() {
        return painter;
    }
    
}
