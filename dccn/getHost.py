import socket
try:
    localhost = socket.gethostname()
    localhost_ip =  socket.gethostbyname(localhost) 
    print("LocalHost Addr:",localhost_ip)
    print("LocalHost Name : ",localhost)
except:
    print("Error")