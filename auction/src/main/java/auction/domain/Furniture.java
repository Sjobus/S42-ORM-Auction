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
public class Furniture extends Item{
    
    public String material;

    public Furniture(String material, User seller, Category category, String description) {
        super(seller, category, description);
        this.material = material;
    }
    
    
    public Furniture(){}

    public String getMaterial() {
        return material;
    }
        
}
