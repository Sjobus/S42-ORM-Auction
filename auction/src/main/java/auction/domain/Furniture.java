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
    
    Furniture(String material)
    {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
        
}
