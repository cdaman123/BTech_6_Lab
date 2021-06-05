import socket               
 
s = socket.socket()         

port = 8457             
 

s.connect(('127.0.0.1', port))
print("\nConnected !!!!!!!!!!!\n")
s.close()