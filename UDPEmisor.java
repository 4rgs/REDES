
package udpemisor;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.imageio.ImageIO;



public class UDPEmisor {
    final static String imagenes = "img/o_cb51ff420acea884-";
    final static String ip = "127.0.0.1";
    final static int port = 9876;
    
    public static void main(String[] args) throws IOException {
        int count=0;
        while(count<100){
            BufferedImage img = ImageIO.read(new File(imagenes+count+".jpg"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            baos.flush();
            byte[] sendData = baos.toByteArray();
            
            DatagramSocket senderSocket = new DatagramSocket(); 
            InetAddress IPReceptor = InetAddress.getByName(ip);
            System.out.println("UDP has sent an image of size:"+sendData.length);
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, IPReceptor, port);
            senderSocket.send(packet);
            senderSocket.close();
            count++;
        }
    }
    
}
