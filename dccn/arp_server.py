import socket               
table = {'192.168.1.1':'1E.4A.4A.11',
         '192.168.2.1':'5E.51.4B.01',
         '192.168.1.3':'4B.35.6D.32',
         '192.168.4.1':'AF.4D.1F.FF',
         '192.168.3.2':'C3.C5.EE.C2',
         '1E.4A.4A.11':'192.168.1.1',
         '5E.51.4B.01':'192.168.2.1',
         '4B.35.6D.32':'192.168.1.3',
         'AF.4D.1F.FF':'192.168.4.1',
         'C3.C5.EE.C2':'192.168.3.2'}
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
   send = table[data]   
   c.sendall(bytes(send,'utf-8'))
   c.close()
   print("Connection Closed!!\n")
