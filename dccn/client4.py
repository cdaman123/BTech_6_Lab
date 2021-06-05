import socket               
 
s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)         

port = 8461            
 

s.connect(('127.0.0.1', port))
print("\n Connected !!!")
while True:
    a = input("Enter Message : ")
    if len(a) != 0:
        s.sendall(bytes(a,'utf-8'))
        print("Message Recieved : ",s.recv(1024).decode())
    if len(a) == 0:
        break
s.close()