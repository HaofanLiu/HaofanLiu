#Name:Liu Haofan
#ID:101106658
black = 0
white = 0
grey = 0
nums = 0
totalWeight = 0
totalLength = 0
skinny = 0
obese = 0
firstName = list(input("Please enter your First name:"))
lastName = list(input("Please enter your Last name:"))
ID = input("Please enter your identification number(within 5 characters long):")
if len(firstName)>9:
    firstName = firstName[:10]
if len(lastName)>9:
    lastName = lastName[:10]
first = "".join(firstName)
last = "".join(lastName)
print(f'Welcome! {first} {last}!')
while True:
    print("##################################################")
    print("# To enter another obervation please press:      1")
    print("# To view the report press:                      2")
    print("# To exit the program please press:              3")
    print("##################################################")
    selection = int(input("Please enter your selection:"))
    if selection == 1:
        while True:
            color = input("Please enter mouse colour(Mouse colour can be either “black”, “white”, or “grey”.):")
            colour = str.lower(color)
            if colour == "black":
                black += 1
                nums += 1 
                break
            if colour == "white":
                white += 1
                nums += 1
                break
            if colour == "grey":
                grey += 1
                nums += 1
                break
        while True:
            Length = float(input("Please enter mouse length(length within 2 ~ 20cm):"))
            length = int(round(Length,0))
            if 2 <= length <= 20:
                totalLength += length
                break
        while True:
            Weight = float(input("Please enter mouse weight(weight within 3 ~ 30 g):"))
            weight = int(round(Weight,0))
            if 3 <= weight <= 30:
                totalWeight += weight
                if 3 <= weight <= 10:
                    skinny += 1
                    break
                if 25 <= weight <= 30:
                    obese += 1
                    break
                else:
                   break
    if selection == 2:
        averageWeight = float(round(totalWeight/nums,1))
        averageLength = float(round(totalLength/nums,1))
        proportionBlack = float(round(black/nums*100,1))
        proportionWhite = float(round(white/nums*100,1))
        proportionGrey = float(round(grey/nums*100,1))
        proportionObese = float(round(obese/nums*100,1))
        proportionSkinny = float(round(skinny/nums*100,1))
        print(f'''##################################################  
Data collected by technician ID {ID} {first} {last}
Total number of mice entered:                    {nums}
Average mouse weight:                         {averageWeight}
Average mouse length:                         {averageLength}
proportion of black mice (%):                 {proportionBlack}
proportion of white mice (%):                 {proportionWhite}
proportion of grey mice (%):                  {proportionGrey}
proportion of obese mice (%):                 {proportionObese}
proportion of skinny mice (%):                {proportionSkinny}
##################################################''')
    if selection == 3:
        print(f'''##################################################  
Data collected by technician ID {ID} {first} {last}
Total number of mice entered:                    {nums}
Average mouse weight:                         {averageWeight}
Average mouse length:                         {averageLength}
proportion of black mice (%):                 {proportionBlack}
proportion of white mice (%):                 {proportionWhite}
proportion of grey mice (%):                  {proportionGrey}
proportion of obese mice (%):                 {proportionObese}
proportion of skinny mice (%):                {proportionSkinny}
##################################################''')
        break
    

    
