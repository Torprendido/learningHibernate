/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.learninghibernate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author giovanni
 */
@Entity
public class QuickMessage implements Serializable
{
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name="MESSAGE")
    private String msg;

    private QuickMessage()
    {
    }
    
    public QuickMessage(String msg)
    {
        this.msg = msg;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the msg
     */
    public String getMsg()
    {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    
    
    
}
