def stuffing(bit_str):
    bits = list(bit_str)
    stuffing_count = 0
    for i,bit in enumerate(bits):
        if bit == '1':
            stuffing_count+= 1
        if bit == '0':
            stuffing_count = 0
        if stuffing_count == 5:
            stuffing_count = 0
            bits.insert(i+1,"0")
    return ''.join(bits)

def destuffing(bit_str):
    bits = list(bit_str)
    destuffing_count = 0
    for i,bit in enumerate(bits):
        if destuffing_count == 5 and bit == "0":
            destuffing_count = 0
            del bits[i]
        if bit == '1':
            destuffing_count+= 1
        if bit == '0':
            destuffing_count = 0 
    return ''.join(bits)

bit_str = input("\nEnter the Bit String : ")

print(f"\nOriginal String : {bit_str}\n")
print(f"Stuffed String : {stuffing(bit_str)}\n")
print(f"Destuffed String : {destuffing(bit_str)}\n")