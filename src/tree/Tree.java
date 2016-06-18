/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Tree {
     static String search = "notfound";   
        static BinaryTree t = new BinaryTree();
        static int id = -1;
    /**
     * @param args the command line arguments
     */
    
    public  static void performall() throws SQLException, ClassNotFoundException{
        t.insertRoot(4);
        t.insertLeft(4, 5);
        t.insertRight(4, 6);
        t.insertLeft(5, 2);
        t.insertRight(5, 3);
        t.insertLeft(2, 9);
        t.insertRight(2, 10);

        t.insertLeft(3, 11);
        t.insertRight(3, 12);

        t.insertLeft(6, 1);
        t.insertRight(6, 8);

        t.insertLeft(1, 15);
        t.insertRight(1, 20);

        t.insertLeft(8, 30);
        t.insertRight(8, 31);
      
        GUI g = new GUI(t.getheight(t.root));
        g.display(t.root);
        g.showGui();
        
        
        
        
//*********************************** JDBC *********************************/
            
            String name =JOptionPane.showInputDialog("Enter Student Name To Search ...");
            //Connection
             Class.forName("com.mysql.jdbc.Driver");
             Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","1994");
                         // Connection mycon2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","1994");

              Statement st = mycon.createStatement();

           // Statement st1 = mycon.createStatement();
             String select = "select * from student where name='"+name+"'";
             ResultSet rs = st.executeQuery(select);
             while(rs.next()){
                id=rs.getInt(1);
             }
        
 

     System.out.println(" ");
        System.out.println("iterative search is:");

      Node  n = t.root;

        Stack<Node> list11 = new Stack<Node>();
        Stack<Node> other11 = new Stack<Node>();

        list11.add(n);

        while (!list11.isEmpty()) {   //      other.size()!=dd
            Node x = list11.pop();
            other11.add(x);

            if (x.right != null) {

                list11.add(x.right);
            }
            if (x.left != null) {
                list11.add(x.left);
            }
        }

        //System.out.println(other11.indexOf(other11.lastElement()));
        for (int level = 0; level <= t.getheight(n) - 1; level++) {
            System.out.print("level>>" + level + " is:  ");
            
            for (int c = 0; c <= other11.indexOf(other11.lastElement()); c++) {
                if (level >= (t.getheight(n)) - (t.getheight(other11.elementAt(c)))) {

                    System.out.print(other11.elementAt(c).data + " ");
                    // if ( other11.elementAt(c).data ==4 )break;
                         
                     
                }
            }
            
            System.out.println(" ");
        }
    }
        
    
    
 
}
