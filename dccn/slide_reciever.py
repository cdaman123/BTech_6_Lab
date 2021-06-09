import socket
import random
def server_program():
    host = socket.gethostname()
    port = 12344
    exp = 0
    n = 4
    new = 1
    win_start = 0
    win_end   = win_start + n - 1
    receiver = []
    server_socket = socket.socket()
    server_socket.bind((host, port))
    server_socket.listen(2)
    conn, address = server_socket.accept()
    print("Connection from: ", str(address))
    while True:
        data = conn.recv(1024).decode()
        if not data:
            break
        rec = int(data)
        lim = rec + n - 1
        count = 0
        flag = 0
        ack = rec
        randy = random.randint(1, 4)
        if new == 1 :
            while(count != randy):
                temp = random.randint(rec, lim)
                if temp not in receiver:
                    print( "Received Frame -> ", temp)
                    count+=1
                    flag = 1
                    receiver.append(temp)
        else:
            print( "Received Frame -> ", rec)
            receiver.append(rec)
            flag = 1
        if(flag == 1):
            for i in range(rec,lim+1):
                if i not in receiver:
                    ack = i
                    break
                ack = i+1
        print( "Sending ACK    -> ", ack)
        print('******************************')
        data = str(ack)
        conn.send(data.encode())
        if ack > win_end :
            win_start = ack
            win_end   = win_start + n - 1
            new = 1
        else :
            new = 0 
    conn.close()

if __name__ == '__main__':
    server_program()


