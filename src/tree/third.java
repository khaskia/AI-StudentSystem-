/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammed
 */
public class third extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage rec = receive();
                if (rec != null) {
                    
                    int rec_deg = Integer.parseInt(rec.getContent());
                    
                    if (rec_deg != -1){
                    JOptionPane.showMessageDialog(null, "your Marks is " + rec_deg,"Agent -->"+myAgent.getLocalName(),3,null);

                    if (rec_deg >= 85 && rec_deg < 100) {
                        JOptionPane.showMessageDialog(null, "Student Degree is Excellent ","Agent -->"+myAgent.getLocalName(),3,null);
                    } else if (rec_deg >= 75 && rec_deg < 85) {
                        JOptionPane.showMessageDialog(null, "Student Degree is Very Good ","Agent -->"+myAgent.getLocalName(),3,null);
                    } else if (rec_deg >= 65 && rec_deg < 75) {
                        JOptionPane.showMessageDialog(null, "Student Degree is Good ","Agent -->"+myAgent.getLocalName(),3,null);
                    } else if (rec_deg >= 50 && rec_deg < 65) {
                        JOptionPane.showMessageDialog(null, "Student Degree is Acceptable ","Agent -->"+myAgent.getLocalName(),3,null);
                    } else if (rec_deg >= 45 && rec_deg < 50) {
                        JOptionPane.showMessageDialog(null, "Student Degree is Passed in critical ways ","Agent -->"+myAgent.getLocalName(),3,null);
                    } else if (rec_deg >= 0 && rec_deg < 45) {
                        JOptionPane.showMessageDialog(null, "Student failed ","Agent -->"+myAgent.getLocalName(),3,null);
                    }

                } else {
                    block();
                }
                }else{

                }
            }
        });

    }

}
