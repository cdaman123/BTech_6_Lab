import socket

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
host ="localhost"
port =8001
s.connect((host,port))



while True:
    try:
        data=s.recv(1024).decode()
        print("Received --> "+data)
        str="Acknowledgement: Message Received"
        s.send(str.encode())
    except:
        s.close ()
        break