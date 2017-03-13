import math

def makeTable(start,end):
    table = {}
    for i in range(start,end+1):
        tuple = (int(math.pow(i,2)),
                 int(math.pow(i,3)),
                 round(math.sqrt(i),5))
        table[i] = tuple
    return table

if __name__ == "__main__":
    start = input()
    end = input()
    target = input()
    table = makeTable(start, end)
    if target < start or target > end:
        print "nema podatoci"
    else:
        print table[target]
    print sorted(table.items())
