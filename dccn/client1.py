import socket  
s = socket.socket()         
 
port = 8458 
s.connect(('127.0.0.1', port))
print("\n Connected !!!")

s.sendall(bytes('Hi, I am Clint.','utf-8'))

print("Message Recieved :",s.recv(1024).decode())
print()
s.close()