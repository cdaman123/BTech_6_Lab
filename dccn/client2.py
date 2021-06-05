import socket  
s = socket.socket()         
 
port = 8459 
s.connect(('127.0.0.1', port))
print("\n Connected !!!")

a = input("Enter Message:")
s.sendall(bytes(a,'utf-8'))

print("Message Recieved :",s.recv(1024).decode())
print()
s.close()