//package calculatorclient;
//
//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//
//public class CalculatorServer extends JFrame {
//   private Socket socket;
//   private JTextArea ta;
//
//   public CalculatorServer() {
//      super("계산기 서버");
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      Container c = getContentPane();
//
//      ta = new JTextArea();
//      JScrollPane jsp = new JScrollPane(ta);
//
//      c.add(jsp, BorderLayout.CENTER);
//
//      setSize(250, 250);
//      setVisible(true);
//
//      // 클라이언트롸 연결, 계산하는 부분
//      ServerSocket listener = null;
//
//      try {
//         listener = new ServerSocket(7777);// 서버 소켓 생성
//         while (true) {// 몇명이 언제 몇시에 올지 모르기 때문에 무한 루프
//            socket = listener.accept();// 클라로 부터 연결요청 대기
//            ta.append("클라이언트 연결됨\n");
//
//            CalThread ct = new CalThread();// 내부클래스로 작성
//            ct.start();
//         }
//
//      } catch (IOException e) {
//         System.out.println(e.getMessage());
//      } finally {
//         try {
//            if (socket != null)
//               socket.close();
//            if (listener != null)
//               listener.close();
//         } catch (IOException e) {
//            System.out.println("오류발생");
//         }
//      }
//
//   }
//
//   public static void main(String[] args) {
//      new CalculatorServer();
//   }
//
//   class CalThread extends Thread {// 내부클래스로 하면 멤버변수 공유함
//      BufferedReader br;
//      BufferedWriter bw;
//
//      // 클라이언트 연결로 생성자
//      public CalThread() {
//         try {
//            br = new BufferedReader
//                    (new InputStreamReader(socket.getInputStream()));
//            // inputStream으로 읽어와서 Buffered에 축적해서 출력/입력
//            bw = new BufferedWriter
//                    (new OutputStreamWriter(socket.getOutputStream()));
//         } catch (IOException e) {
//            e.printStackTrace();
//         }
//      }
//
//      @Override
//      public void run() {// run에서는 계산 담당
//         while (true) {
//            // 첫번째 수
//            try {
//               String first = br.readLine();// 첫번째로 입력된 값 읽음
//               String op = br.readLine();// 두번째로 입력된 값 읽음(연산자)
//               String second = br.readLine();// 세번째로 입력된 값 읽음
//
//               String dap = "";// 사칙연산 결과 담음
//
//               switch (op) {
//               case "+":
//            dap = Integer.parseInt(first) + Integer.parseInt(second) +"";
//                  break;
//               case "-":
//            dap = Integer.parseInt(first) - Integer.parseInt(second) +"";
//                  break;
//               case "*":
//            dap = Integer.parseInt(first) * Integer.parseInt(second) +"";
//                  break;
//               case "/":
//                  if (second.equals("0")) {
//                  dap = "0으로 나눌수 없음";
//                  } else {
//               dap = Integer.parseInt(first)/Integer.parseInt(second)+"";
//                  }
//                  break;
//               default:
//                  dap = "잘못된 입력\n";
//                  break;
//               }
//
//               bw.write(dap + "\n");
//               bw.flush();
//               ta.append(first + op + second + "=" + dap + "\n");
//                    // 서버 ta에 출력
//            } catch (IOException e) {
//               e.printStackTrace();
//            }catch(NumberFormatException e) {
//               e.printStackTrace();
//            }
//         }
//      }
//   }
//}