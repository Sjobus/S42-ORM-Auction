/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.domain;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author sibev
 */
@Entity
public class Furniture extends Item implements Serializable{
    
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
