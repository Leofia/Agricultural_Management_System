/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author ANIL
 */
class FruitNotFoundException extends RuntimeException{
    public FruitNotFoundException(String message) {
        super(message);
    }
}
