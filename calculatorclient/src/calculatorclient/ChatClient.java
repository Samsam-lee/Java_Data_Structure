package calculatorclient;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements Runnable {

   DataInputStream din;// 들어오는 놈
   DataOutputStream dout;// 나가는 놈
   JTextArea ta;

   public ChatClient() {
      super("채팅클라이언트");
      setLayout(new BorderLayout());
      JTextField tf = new JTextField();
      ta = new JTextArea();
      JScrollPane jsp = new JScrollPane(ta);

      tf.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // 글을 쓰고 엔터를 치면 정보가 나가게 됨
            try {
               dout.writeUTF(tf.getText());
               // 버퍼가 아니기 때문에 flush 필요없음
               tf.setText("");
            } catch (IOException e1) {
               e1.printStackTrace();
            }
         }
      });
      add(tf, BorderLayout.NORTH);
      add(jsp, BorderLayout.CENTER);

      setSize(300, 200);
      setVisible(true);
   }
   public static void main(String[] args) {
      ChatClient chat = new ChatClient();
      Thread th = new Thread(chat);
      th.start();// 러너블 스레드를 실행시는 구조
   }
   @Override
   public void run() {
      try {
         Socket socket = new Socket("192.168.43.90", 5000);
         din = new DataInputStream(socket.getInputStream());
         //소켓을 통해 들어오는것
         dout = new DataOutputStream(socket.getOutputStream());
         //소켓을 통해 내보낼것
         ta.append("서버 접속\n");
         while (true) {
            String str = din.readUTF();// 서버로부터 들어온것을 str로 하고
            ta.append(str+"\n");// ta에 출력
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }