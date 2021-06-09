import time, socket, sys

def decimalToBinary(n):  
    return n.replace("0b", "")

def binarycode(s):
    a_byte_array = bytearray(s, "utf8")
    byte_list = []
    for byte in a_byte_array:
        binary_representation = bin(byte)
        byte_list.append(decimalToBinary(binary_representation))
    a=""
    for i in byte_list:
        a=a+i
    return a


s = socket.socket()
port = 1234
s.bind(('', port))
print('Sender bind to port ',port)
s.listen(5)
print("socket is listening\n")
conn, addr = s.accept()
print("Received connection from ", addr[0], "(", addr[1], ")\n")
while True:
    message = input(str("Me : "))
    conn.send(message.encode())
    if message == "[e]":
        message = "Left chat room!"
        conn.send(message.encode())
        print("\n")
        break
    f=str(len(message))
    conn.send(f.encode())   
    i,j=0,0
    j=int(input("Enter the window size -> "))  
    b=""   
    j=j-1
    f=int(f)
    k=j
    while i!=f:
        while(i!=(f-j)):
            conn.send(message[i].encode())
            b=conn.recv(1024)
            b=b.decode()
            print(b)
            if(b!="ACK Lost"):
                time.sleep(1)
                print("Acknowledgement Received! range (",str(i+1),str(k+1),").")
                i=i+1
                k=k+1
            else:
                print("Acknowledgement of the data bit is LOST! range (",str(i+1),str(k+1),").")
        while(i!=f):            
            conn.send(message[i].encode())
            b=conn.recv(1024)
            b=b.decode()
            print(b)
            if(b!="ACK Lost"):
                print("Acknowledgement Received! range (",str(i+1),str(k+1),").")
                i=i+1
            else:
                print("Acknowledgement of the data bit is LOST! range (",str(i+1),str(k+1),").")