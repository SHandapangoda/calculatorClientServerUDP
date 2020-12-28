public class ServerUDP {
    public final static int portAddress = 3296;
  void ServerUdpCalc() {
        {
            while (true) {
                try {
                    // Receive feed back from client side
                    DatagramSocket socket = new DatagramSocket(portAddress);

                    // Instantiate a udp to store client data using buffer
                    byte[] sendingBuffer = null;
                    byte[] receivingBuffer = new byte[1024];

                    int result;

                    DatagramPacket inputPacket = new DatagramPacket(receivingBuffer, receivingBuffer.length);
                    System.out.println("Receiving values as operand operator operand ");

                    //Receive data from client and store as packets.
                    socket.receive(inputPacket);


                    //prints data from client
                    String dataReceived = new String(inputPacket.getData());
                    dataReceived = dataReceived.trim();
                    System.out.println("Received value  " + dataReceived);

                    StringTokenizer stringTokenizer = new StringTokenizer(dataReceived);
                    int value1 = Integer.parseInt(stringTokenizer.nextToken());
                    String operand = stringTokenizer.nextToken();
                    int value2 = Integer.parseInt(stringTokenizer.nextToken());

                    if (operand.equals("+")) {
                        result = value1 + value2;
                        String res = Integer.toString(result);
                        sendingBuffer = res.getBytes();
                        //message to client

                        //get the client side port
                        InetAddress sendAddress = inputPacket.getAddress();
                        int portSender = inputPacket.getPort();

                        //New udp packet with data to send to client
                        DatagramPacket outputPacket = new DatagramPacket(sendingBuffer, sendingBuffer.length, sendAddress, portSender);

                        //send packets to client
                        socket.send(outputPacket);
                        //socket close
                        socket.close();
                    }
                    if (operand.equals("-")) {
                        result = value1 - value2;
                        String res1 = Integer.toString(result);
                        sendingBuffer = res1.getBytes();
                        //message to client

                        //get the client side port
                        InetAddress sendAddress = inputPacket.getAddress();
                        int portSender = inputPacket.getPort();

                        //New udp packet with data to send to client
                        DatagramPacket outputPacket = new DatagramPacket(sendingBuffer, sendingBuffer.length, sendAddress, portSender);

                        //send packets to client
                        socket.send(outputPacket);
                        //socket close
                        socket.close();
                    }

                    if (operand.equals("*")) {
                        result = value1 * value2;
                        String res1 = Integer.toString(result);
                        sendingBuffer = res1.getBytes();
                        //message to client

                        //get the client side port
                        InetAddress sendAddress = inputPacket.getAddress();
                        int portSender = inputPacket.getPort();

                        //New udp packet with data to send to client
                        DatagramPacket outputPacket = new DatagramPacket(sendingBuffer, sendingBuffer.length, sendAddress, portSender);

                        //send packets to client
                        socket.send(outputPacket);
                        //socket close
                        socket.close();
                    }

                    if (operand.equals("f")) {
                        result = (5 * (value1 - 32)) / 9;
                        String res1 = Integer.toString(result);
                        sendingBuffer = res1.getBytes();
                        //message to client

                        //get the client side port
                        InetAddress sendAddress = inputPacket.getAddress();
                        int portSender = inputPacket.getPort();

                        //New udp packet with data to send to client
                        DatagramPacket outputPacket = new DatagramPacket(sendingBuffer, sendingBuffer.length, sendAddress, portSender);

                        //send packets to client
                        socket.send(outputPacket);
                        //socket close
                        socket.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
     }
}