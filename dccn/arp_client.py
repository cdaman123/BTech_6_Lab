import socket  
s = socket.socket()         
 
port = 8458 
s.connect(('127.0.0.1', port))
print("\n Connected !!!")
opt = input("ARP or RARP : ")
if opt == "ARP":
    inp = input("EnterIP : ")
elif opt == 'RARP':
    inp = input('Enter Mac : ')
s.sendall(bytes(inp,'utf-8'))
if opt == 'ARP':
    print("Mac ID : ",s.recv(1024).decode())
elif opt == 'RARP':
    print("IP : ",s.recv(1024).decode())
s.close()