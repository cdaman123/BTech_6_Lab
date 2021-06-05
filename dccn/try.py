import re
def EvenPairs(strParam):
  r = '[0-9]+'
  s = '[0,2,4,6,8]{1}'
  l = re.findall(r,strParam)
  for i in l:
    print(re.findall(s,i))
    if len(re.findall(s,i)) >=2:
      return True

  # code goes here
  return False

# keep this function call here 
print(EvenPairs(input()))