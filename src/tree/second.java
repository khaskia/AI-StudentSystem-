/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.tools.sniffer.Message;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammed
 */
public class second extends Agent {

    String alldata = null;
    int deg = -1;

    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                // Recieve the other
                ACLMessage msg = receive();
                if (msg != null) {

                    try {
                        
                        
                        
                        int Recievedid = Integer.parseInt(msg.getContent());
                        depthsearch(Recievedid);
                        if (Recievedid != -1) {
                            JOptionPane.showMessageDialog(null,"The Data Is \n\n" + alldata,"Agent -->"+myAgent.getLocalName(),3,null);
                        } else {
                            JOptionPane.showMessageDialog(null, "Sorry Data Not Found ... ","Agent -->"+myAgent.getLocalName(),3,null);

                        }
                        
                        //*********** Send The Degree To the Third Agent 
                        addBehaviour(new OneShotBehaviour() {
                            @Override
                            public void action() {
                                ACLMessage sendDegree = new ACLMessage(Message.INFORM);
                                sendDegree.setContent(deg + "");
                                sendDegree.addReceiver(new AID("third", AID.ISLOCALNAME));
                                send(sendDegree);

                            }
                        });

                    } catch (SQLException ex) {
                        Logger.getLogger(second.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(second.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    block();
                }

            }
        });

    }

    public void depthsearch(int id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu", "root", "1994");
        // Connection mycon2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","1994");

        Statement st = mycon.createStatement();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Your Search path and Result");

        Node n1 = Tree.t.root;
        Stack<Node> firstS = new Stack<Node>();
        Stack<Node> mainS = new Stack<Node>();
        mainS.add(n1);
        firstS.add(n1.right);
        firstS.add(n1.left);
        while (!firstS.isEmpty()) {   //      other.size()!=dd
            Node x = firstS.pop();
            mainS.add(x);
            if (x.right != null) {
                firstS.add(x.right);
            }
            if (x.left != null) {
                firstS.add(x.left);
            }
        }
        System.out.println("id is " + id);
        //  System.out.print(n1.data + " ");
        for (int c = 0; c <= mainS.indexOf(mainS.lastElement()); c++) {
            int e = mainS.elementAt(c).data;
            // System.out.print(other1.elementAt(c).data + " ");

            String selectdata = "select * from student where id=" + e;
            ResultSet rsdata = st.executeQuery(selectdata);
            while (rsdata.next()) {
                System.out.println("id =" + rsdata.getInt(1) + " Name =" + rsdata.getString(2));

                if (e == id) {
                    alldata = "The Name Is :" + rsdata.getString(2) + "\n"
                            + "The Age is :" + rsdata.getString(3) + "\n"
                            + "The Address is :" + rsdata.getString(4) + "\n"
                            + "The Phone is :" + rsdata.getString(5) + "\n"
                            + "The Class is :" + rsdata.getString(6) + "\n"
                            + "The Email is :" + rsdata.getString(7) + "\n";
                    deg = Integer.parseInt(rsdata.getString(8));
                    System.out.println("--------------------------------------------");
                    System.out.println(rsdata.getString(2) + " Found ");
                    System.out.println("Age =" + rsdata.getString(3));
                    System.out.println("Adress =" + rsdata.getString(4));
                    System.out.println("Phone =" + rsdata.getString(5));
                    System.out.println("Class =" + rsdata.getString(6));
                    System.out.println("Email =" + rsdata.getString(7));
                    return;
                }

            }

        }
    }
}
