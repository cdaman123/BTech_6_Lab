import socket               

s = socket.socket()         
print("\nSocket successfully created")

port = 8458
s.bind(('', port))        
print("socket binded to",port)
s.listen(5)     
print("socket is listening.\n")

while True:
   c, addr = s.accept()     
   print('\nGot connection from', addr)

   data=c.recv(1024).decode()
   print("Message Recieved :",data)   
  
   c.sendall(bytes("Hello, I am Server.",'utf-8'))
   c.close()
   print("Connection Closed!!\n")
