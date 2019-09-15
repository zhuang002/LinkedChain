/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedchain;

/**
 *
 * @author zhuan
 */
public class LinkedChain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Chain chain=new Chain();
        chain.add(1);
        chain.add(3);
        chain.add(4);
        
        System.out.println(chain);
        
        chain.insert(3,2);
        
        System.out.println(chain);
        
        chain.remove(3);
        
        System.out.println(chain);
        
    }
    
}
