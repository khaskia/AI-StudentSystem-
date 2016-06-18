/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammed
 */
public class first extends Agent{

    @Override
    protected void setup() {
        // Send The Data If Exitst To Other Agent 
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                try {
                    Tree.performall();
                    
                    ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                    msg.setContent(Tree.id+"");
                    
                    msg.addReceiver(new AID("second",AID.ISLOCALNAME));
                    send(msg);
                    
                    
     
                } catch (SQLException ex) {
                    Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });


    }
    
    
    
}
