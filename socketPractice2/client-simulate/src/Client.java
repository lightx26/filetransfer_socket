import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // Replace with the server's IP address
        int serverPort = 12345; // Replace with the server's port

        Socket clientSocket = new Socket(serverAddress, serverPort);
        System.out.println("Connected to server");

        // File to send
        String filePath = "D:\\QUANG\\Hoctap\\Java\\Assignment\\dbconnect_vsc\\socketPractice2\\client-simulate\\asset\\file.txt"; // Replace with the file path you want to send

        // Get the file name and size
        File fileToSend = new File(filePath);
        String fileName = fileToSend.getName();
        long fileSize = fileToSend.length();

        // Output stream to send data to the server
        OutputStream outputStream = clientSocket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);

        // Send file name and size to the server
        dataOutputStream.writeUTF(fileName);
        dataOutputStream.writeLong(fileSize);

        // Input stream to read the file and send it to the server
        FileInputStream fileInputStream = new FileInputStream(filePath);
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            dataOutputStream.write(buffer, 0, bytesRead);
        }

        System.out.println("File sent successfully");

        // Close streams and socket
        fileInputStream.close();
        dataOutputStream.close();
        clientSocket.close();
    }
}
