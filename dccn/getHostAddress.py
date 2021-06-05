import socket
try:
    host = "stackoverflow.com"
    host_ip =  socket.gethostbyname(host) 
    print("Host Name : ",host)
    print("Host Addr:",host_ip)
    
except:
    print("Error")