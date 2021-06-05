def find_class(ip):
    ip = list(map(int,ip.split(".")))
    if ip[0]>=0 and ip[0]<128:
        return "A"
    elif ip[0]>=128 and ip[0]<192 :
        return "B"
    elif ip[0]>=192 and ip[0]<224:
        return "C"
    elif ip[0]>=224 and ip[0]<240 :
        return "D"
    elif ip[0]>=240 and ip[0]<256 :
        return "E"

ip = input("Enter ip Address : ")
print()
print(f"Entered IP address is in Class : {find_class(ip)} \n")
