import math

def makeTable(start,end):
    table = {}
    for i in range(start,end+1):
        table[int(math.pow(i,3))] = i
    return table

if __name__ == "__main__":
    start = input()
    end = input()
    target = input()
    table = makeTable(start,end)    
    if target not in table:
        print "nema podatoci"	
    else:
        print int(round(math.pow(target, 1/3.0)))
    print sorted(table.items())
