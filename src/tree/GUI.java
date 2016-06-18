/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class GUI extends JFrame{
    
    int row;
    int column;
    int[] number;
    int[] distance;
    Node[][]nodes; 
    JLabel[][] array;
    JLabel[] actual;
     
     int d;
     Node mm;
    public GUI(int n) {
        
        super();
       // initComponents();
        JPanel jPanel1=new JPanel();
         row=n;
         column=(int)(double)Math.pow(2, n);
        number=new int[n];
        distance=new int[n];
        nodes=new Node[n-1][];
        for(int i=0;i<n;i++)
        number[i]=(int)(double)Math.pow(2, i);
        
        for(int i=0;i<n;i++)
            distance[i]=number[number.length-1-i];
        
      array=new JLabel[n][column];
      actual=new JLabel[column-1];
        
        jPanel1.setLayout(new GridLayout(n, column));
        
        for (int i=0;i<n;i++){
        for (int j=0;j<column;j++){
        array[i][j]=new JLabel(" ");
        array[i][j].setBackground(Color.red);
        jPanel1.add(array[i][j]);
       
        }
        }
        getContentPane().add(jPanel1,BorderLayout.CENTER);
       // this.setVisible(true);
           addWindowListener(new	WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//myAgent.doDelete();
                            System.exit(0);
			}
		} );
    
    }
    
    public void showGui() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
                  setSize(800, 500);
		super.setVisible(true);
	}	
    
    public void display(Node n){
        
        for(int f=0;f<column;f++){
    
        for(int i=1;i<=row;i++){
            
//            System.out.println("number[i]="+number[i-1]);
//            System.out.println("distance[i]="+distance[i-1]);
      //  array[i-1][distance[i-1]].setText("555");
        for (int j=1;j<=number[i-1];j++){
             
            if(j==1){
                
                    array[i-1][distance[i-1]].setText("0");
                    actual[f]=array[i-1][distance[i-1]];
                    f++;}
                    
            else if(j==2){
               d=distance[i-1]+distance[i-2];  
               
              array[i-1][d].setText("0");
             actual[f]=array[i-1][d];
             f++;
            d=d+distance[i-2];
            }
            else if(j>2){
            array[i-1][d].setText("0"); 
            actual[f]=array[i-1][d];
            f++;
            array[i-1][d].setBackground(Color.red);
            d+=distance[i-2];}
        }
         d=0;
             
         }
    
    }
        
//        //display node values
//         for(int i=0;i<row;i++){
//         for(int j=0;j<column;j++){
//         if(array[i][j].getText().equals("0"))
//            
//             
//         }
//         }
        
//       for (int i=0;i<number.length;i++){
//       nodes[i]=new Node[number[i]];
//       }
//       
//       nodes[0][0]=n;
//       for(int i=0;i<row-1;i++){
//           for(int j=0;j<nodes[i].length;j++){
//        nodes[i][j]=       
//               }
//       }
//       System.out.println(" ");
//      n.displayNode(n);
//        n.displayNode(n.left);
//        n.displayNode(n.right);
        


//************************* Breadth first search ************************/


        Queue<Node> list=new LinkedList<Node>();
         Queue<Node> other=new LinkedList<Node>();
       // list.add(n);
     //    other.add(n);
        list.add(n.left);
        list.add(n.right);
        other.add(n.left);
        other.add(n.right);
      //  System.out.println("size ="+list.size());
     //  System.out.println("size other="+other.size());
        
        Iterator t=list.iterator();
 Iterator it=other.iterator();
       // Node x=(Node)list.peek();

   int dd=(int)(double)Math.pow(2, row)-2;
   
        while(other.size()!=(dd)){
         Node x=(Node)list.poll();
         if(x==null){
             list.add(null);
             list.add(null);
             other.add(null);
             other.add(null);
         }
         else{
         list.add(x.left);
         list.add(x.right);
         other.add(x.left);
         other.add(x.right);
         }
         // Node n=(Node) t.next();
        
        }
        System.out.println(" ");
     //    System.out.println("size other="+other.size());
        //importantttttttttttttttttttt
       //  System.out.println("Breadth first search >>>>>>>>");
      /*   System.out.print(n.data+" ");
          for(Node s : other) {
              if(s!=null)
              System.out.print(s.data+" ");
              else
             System.out.print(" null ");     
           }
*/
          
       //  array[0][0].setText((Integer.toString(other.poll().data)));
         actual[0].setText((Integer.toString(n.data)));
         for(int i=1;i<=column-2;i++){
             Node mm=other.poll();
             if(mm!=null)
         actual[i].setText((Integer.toString(mm.data)));
             else
            actual[i].setText("null");     
         }
         
//       System.out.print(" "+other.poll().data);
//        System.out.print(" "+other.poll().data);
//       System.out.print(" "+other.poll().data);
//        System.out.print(" "+other.poll().data);
//       System.out.print(" "+other.poll().data);
         
         
//      while(it.hasNext())
//        {
//            String iteratorValue=(String)it.next();
//            System.out.println("Queue Next Value :"+iteratorValue);
//        }
      //  System.out.println("size other="+other.size());
        
//        System.out.print(" "+list.poll().data);
//       System.out.print(" "+list.poll().data);
//        System.out.print(" "+list.poll().data);
//       System.out.print(" "+list.poll().data);
//        System.out.print(" "+list.poll().data);
//       System.out.print(" "+list.poll().data);
////        while(t.hasNext()){
//        
//        System.out.print(" "+(String)t.next());
//        }
//        
//        System.out.println("size ="+list.size());




//
////*********************************** depth *********************************/
//System.out.println(" ");
//        System.out.println(" ");
//        System.out.println("depth first search is:");
//int limit=1;
////      Node n=t.root;
//        Stack<Node> list1 = new Stack<Node>();
//        Stack<Node> other1 = new Stack<Node>();
//
//        list1.add(n.right);
//        list1.add(n.left);
//        while (!list1.isEmpty()) {   //      other.size()!=dd
//            Node x = list1.pop();
//            other1.add(x);
//            if (x.right != null) {
//                list1.add(x.right);
//            }
//            if (x.left != null) {
//                list1.add(x.left);
//            }
//        }
//        System.out.print(n.data + " ");
//        for (int c = 0; c <= other1.indexOf(other1.lastElement()); c++) {
//            
//            System.out.print(other1.elementAt(c).data + " ");
//
//        }
























    }
}
