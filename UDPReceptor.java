package udpreceptor;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class UDPReceptor extends JFrame{
    
    final static int MAX_SIZE = 26627;
    public static BufferedImage receivedImage;
    
    public UDPReceptor(){
        super();
        this.setTitle("VIDEO RECIBIDO");
        this.setSize(650,500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
    }
    
    
    public static void main(String[] args) throws SocketException, IOException {
        
        UDPReceptor temp =new UDPReceptor();
        MiPanel imagen = new MiPanel();
        temp.add(imagen);
        
        
        int count=0;
        while(count<100){
            //File  myFile = new File("temp/archivo"+count+".jpg");
            DatagramSocket socketReceptor = new DatagramSocket(9876);
            System.out.println("Waiting for an Image at port:"+socketReceptor.getLocalPort());
            byte[] receiverData = new byte[MAX_SIZE];
            DatagramPacket packet = new DatagramPacket(receiverData, receiverData.length);

            socketReceptor.receive(packet);
             // Transformando imagen en byte en una Imagen
            receivedImage = ImageIO.read(new ByteArrayInputStream(packet.getData()));
           
            //escribiendo Imagen en archivo temporal
            
            imagen.repaint();
            
            socketReceptor.close();
            count++;
        }
    }
}
