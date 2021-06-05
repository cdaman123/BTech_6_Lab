import socket       
s = socket.socket()         
print("\nSocket successfully created")
 
port = 8457  #randomly taken    
s.bind(('', port))        
print("socket binded to",port) 

s.listen(5)     
print("socket is listening\n")
while True:
   c, addr = s.accept()     
   print('\nGot connection from', addr)
   c.close()
   print("Connection Closed\n")