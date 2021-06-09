import socket
serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
host = "localhost"
port = 8001
serversocket.bind((host, port))
serversocket.listen(5)
print ('Sender ready and is listening')
while (True):
    clientsocket, address = serversocket.accept()
    print("Receiver "+str(address)+" connected")
    while True:
        r=input("Send data -->")
        if r == '':
            print('Exit')
            break
        clientsocket.send(r.encode())
        print(clientsocket.recv(1024).decode())
    clientsocket.close()
    break
    