import socket
def client_program():
	n = 4
	win_start = 0
	win_end = win_start + n - 1
	host = socket.gethostname()
	port = 12344 
	sender = []
	flag = 0 
	client_socket = socket.socket()
	client_socket.connect((host, port))
	print( 'Window Size is ', n)
	print ('******** Enter "bye" to ',
		'close connection ***************')
	message = input("Hit any key to start sending frames -> ")
	while message.lower().strip() != 'bye':
		print("Sending frames...")
		if flag == 0 :
			for i in range(n):
				sender.append(win_start + i)
			for i in sender :
				print( "Frame -> ", i)
		else:
			print ("Frame -> ", win_start)
		msg = str(win_start)
		client_socket.send(msg.encode())  
		data = client_socket.recv(1024).decode() 
		msg = str(data)
		ack = int(msg)
		if ack not in sender:
			win_start = ack
			win_end = win_start + n - 1
			flag = 0  
			for i in range(n):
				sender.pop()
		else:
			win_start = int(msg)
			flag = 1
		print( "******************************")
		print( 'Received ACK server: ' + data )
		message = input("Hit any key to start sending frames -> ")
	client_socket.close()


if __name__ == '__main__':
    client_program()



