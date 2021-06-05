def convert_ip_dec_bin(ip):
    ip_dec = list(map(int,ip.split(".")))
    return '{:08b}.{:08b}.{:08b}.{:08b}'.format(*ip_dec)

ip = input("\nEnter Decimal ip Address : ")
print()
print(f"32-bit conversion of ip {ip} : \n{convert_ip_dec_bin(ip)} \n")
