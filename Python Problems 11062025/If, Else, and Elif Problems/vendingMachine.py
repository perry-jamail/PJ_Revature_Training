import sys


def vendingMachine():
    # Part 1
    btn: int
    drink: str
    price: float
    try:
        btn = int(input("Please enter an integer between 1 and 3: "))
    except ValueError:
        print("Input must be a number!")
        sys.exit()

    if btn == 1:
        drink = "water"
        price = 1.00
    elif btn == 2:
        drink = "soda"
        price = 1.50
    elif btn == 3:
        drink = "gatorade"
        price = 2.00
    else:
        print("Not a valid option")
        sys.exit()

    print(f"You have selected {drink}, which costs ${round(price, 2)}.\n")

    # Part 2
    coins = ["quarters", "dimes", "nickels", "pennies"]
    numOfEach = list(map(lambda x: int(input(f"Please enter how many {x} you are entering into the machine: ")), coins))

    # Part 3
    totVal = 0
    totVal += numOfEach[0] * 0.25
    totVal += numOfEach[1] * 0.10
    totVal += numOfEach[2] * 0.05
    totVal += numOfEach[3] * 0.01

    # Part 4
    if totVal == price:
        print(f"\nThank you for using the vending machine! You have entered the exact amount for this item, so you will not "
              f"receive any change. Enjoy your {drink}!")
    elif totVal > price:
        remainder = totVal - price
        print(f"\nThank you for using the vending machine! You have entered ${totVal}, which is more than needed for this item"
              f" that costs {round(price, 2)}, so you will receive ${round(remainder, 2)} back. Enjoy your {drink}!")
    else:
        print(f"\nYou have only entered ${totVal}, which is not enough for your {drink} which costs {round(price, 2)}. "
              f"Please try again.")

vendingMachine()