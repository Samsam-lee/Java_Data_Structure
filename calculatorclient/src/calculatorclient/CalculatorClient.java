//package calculatorclient;
//
//import java.awt.Container;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//
//import java.io.*;
//import java.net.*;
//import java.util.*;
//
//public class CalculatorClient extends JFrame{
//   BufferedReader br;
//   BufferedWriter bw;
//   
//   public CalculatorClient() {
//      super("계산기 클라이언트");
//      
//
//      Socket socket = null;
//      
//      setLayout(new FlowLayout());
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      Container c = getContentPane();
//      
//      JTextField first = new JTextField(7);
//      JTextField op = new JTextField(3);
//      JTextField second = new JTextField(7);
//      JLabel lbl = new JLabel("=");
//      JTextField result = new JTextField(10);
//      JButton btn = new JButton("계산");
//      
//      //서버 연결 준비
//      try {
//         socket = new Socket("192.168.43.90", 7777);
//         br = new BufferedReader
//               (new InputStreamReader(socket.getInputStream()));
//         bw = new BufferedWriter
//               (new OutputStreamWriter(socket.getOutputStream()));
//         
//      } catch (UnknownHostException e1) {
//         e1.printStackTrace();
//      } catch (IOException e1) {
//         e1.printStackTrace();
//      }
//      
//      //서버한테 계산할 값 (first, op, second를 보냄)
//      //서버가 보낸 답을 result에 출력
//      btn.addActionListener(new ActionListener() {   
//         @Override
//         public void actionPerformed(ActionEvent e) {
//                  String f = first.getText().trim();
//                  String x = op.getText().trim();
//                  String s = second.getText().trim();
//                  if(f.length()==0||x.length()==0||s.length()==0) {
//                     return;
//                  }
//                  
//                  
//                  try {
//                  //서버한테 보냄
//                  bw.write(f+"\n");
//                  bw.write(x+"\n");
//                  bw.write(s+"\n");
//                  bw.flush();
//                  
//                  
//                  //서버에서 답이 옴
//                  String dap = br.readLine();//한줄씩 불러옴
//                  result.setText(dap);//결과 입력
//            }catch(IOException a) {
//               System.out.println("서버로부터 연결 종료");
//            }            
//         }
//      });
//      
//      c.add(first);
//      c.add(op);
//      c.add(second);
//      c.add(lbl);
//      c.add(result);
//      c.add(btn);
//      setSize(400, 100);
//      setVisible(true);
//      
//
//   }
//public static void main (String[]args) {
//   new CalculatorClient();
//}
//}