import sys
__operators = ('+','-', '/' , '//', '*', '**', '%')
 
def caltulator():
    first = input()
    operator = input()
    second = input()
    if operator not in __operators:
        sys.exit("wrong operator")
    print eval("first" + operator + "second")
 
if __name__ == "__main__":
    caltulator() 
