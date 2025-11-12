countries = {
    'United States': 'Washington, D.C.',
    'Canada': 'Ottawa',
    'Mexico': 'Mexico City',
    'France': 'Paris',
    'Lebanon': 'Beirut'
}

def whatIsCapital():
    inputCountry = input("Enter the name of a country: ")
    for country in countries:
        if country == inputCountry:
            print(f"The capital city of {country} is {countries[country]}!")

whatIsCapital()