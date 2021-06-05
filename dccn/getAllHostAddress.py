import socket
try:
    host = "stackoverflow.com"
    host_ip =  socket.gethostbyname_ex(host) 
    print("Host Name : ",host)
    print("All address of Host :")
    print(*host_ip[2],sep = "\n")
    
except:
    print("Error")