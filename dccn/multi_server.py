import socket
import threading

def threaded(c,addr):
    while True:
        data = c.recv(1024).decode()
        if not data:
            print(f'{addr[0]}:{addr[1]} disconnected !! Bye...')
            break
        print(f'msg recieved from {addr[0]}:{addr[1]} : {data}')
        data = data.upper()
        c.send(bytes(data,'utf-8'))
    c.close()
  
  
def Main():
    host = "127.0.0.1"
    port = 8461
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind((host, port))
    print("socket binded to port", port)
    s.listen(5)
    print("socket is listening")
    while True:
        c, addr = s.accept()
        print('Connected to :', addr[0], ':', addr[1])
        thread = threading.Thread(target=threaded, args=(c,addr))
        thread.start()
    s.close()
  
  
if __name__ == '__main__':
    Main()