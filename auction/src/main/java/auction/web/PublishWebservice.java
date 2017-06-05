/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.web;

import javax.xml.ws.Endpoint;

/**
 *
 * @author Kevin
 */
public class PublishWebservice {
    
    private static final String url = "http://localhost:6080/WebAuction";
    private static final String url2 = "http://localhost:6080/WebRegistration";
    
    public static void main(String[] args){
        Endpoint.publish(url, new Auction());
        Endpoint.publish(url2, new Registration());
    }
}
