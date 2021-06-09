import time, socket, sys
import random


s = socket.socket()
port = 1234
s.connect(('localhost', port))
print("Connected...\n")

while True:
    m=s.recv(1024)
    m=m.decode()
    k=s.recv(1024)
    k=k.decode()
    try:
      k=int(k)
      i=0
      a=""
      b=""
      f=random.randint(0,1)
      message=""
      while i!=k:      
         f=random.randint(0,1)
         if(f==0):
            b="ACK Lost"
            message = s.recv(1024)
            message = message.decode()
            s.send(b.encode())
         
         elif(f==1):
            b="ACK "+str(i)
            message = s.recv(1024)
            message = message.decode()
          
            s.send(b.encode())
            a=a+message
            i=i+1
    except:
       print(k)
       break
    print("The message received is :", m)