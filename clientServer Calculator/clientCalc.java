public class ClientUDP {
    // connecting port for server
    public final static int portAddress=3296;
 void ClientUdpCalc() throws IOException {
while(true){
    try {
        //specify the port
        DatagramSocket socket=new DatagramSocket();

        //calling the ip address
        InetAddress address= InetAddress.getByName("192.168.137.81");

        //corresponding buffers
        byte[]receiveData=new byte[1024];

        //input the message which require to send to server
        System.out.println("Enter the value1 ");
        Scanner sc=new Scanner(System.in);
        String message=sc.nextLine();
        byte[]sendData=message.getBytes();

        //creating UDP packet
        DatagramPacket packetSend=new DatagramPacket(sendData,sendData.length,address,portAddress);

        //send data to server
        socket.send(packetSend);


        //get response from server
        DatagramPacket packetReceive=new DatagramPacket(receiveData,receiveData.length);
        socket.receive(packetReceive);

        // printing message from server
        String DataClient=new String(packetReceive.getData());
        System.out.println("Data from Server: "+DataClient);

        //connection close
        socket.close();

    } catch (SocketException e) {
        e.printStackTrace();
    }

}
}