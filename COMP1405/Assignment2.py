#Name:Liu haofan
#ID:101106658
import pandas as pd
import csv
#ask user save or not
def save_file(data):
    ask_name_save=input("Do you wish to save this Pokemon in a separate file (Y/N)?")
    if ask_name_save=='Y':
            try:
                save_name=input("Please input the file name to save these pokemon:")
                dual_data.to_csv(save_name+'.csv')
            except:
                print('File error. Please make sure that the file is not being accessed by another program, and that there is sufficient disc space.')         
                save_file(data)
    else:
        print(" ")

#sort the file by speed
def sort_data():
    df=pd.read_csv('pokemon.csv',index_col=False)
    dual_data=df.sort_values(by='Speed',ascending=False)
    print(dual_data)
    answer=input("Do you wish to save this Pokemon in a separate file (Y/N)?")
    if answer=='Y':
        save_name=input("Please input the file name to save these pokemon:")
        try:
            dual_data.to_csv(save_name+'.csv')
        except:
            print('File error. Please make sure that the file is not being accessed by another program, and that there is sufficient disc space.')
            save_file(dual_data)                  
    else:
        print(" ")

num = 0
#Use case 1
#ask the user for file name
while True:
        try:
            Filename = input("Please input the file name: ")
            File = open(Filename,'r')
        except FileNotFoundError:
            print("Pokemon file is not found. Please enter the name of the file again!")
            continue
        except:
            print("Unspecified file error. Please make sure that the file is not being accessed by another program.")
            continue
        File.close()
        break
#User make selection
while True:
    print("1. Name search  2. Type search  3. Sort by speed  4. Exit the program.")
    selection = input("Please enter your selection:")
#Use case 2
#Name Search
    if selection == "1":
        while True:
            Pokemon_name = input("Please enter a Pokemon name: ")
            File = open(Filename,'r')
            readlines = File.readlines()
            for line in readlines:
                    if Pokemon_name in line:
                        num += 1
                        ask_name_save = input("Do you wish to save this Pokemon in a separate file (Y/N)?")
                        if ask_name_save == "Y":
                            pokemon_name_file = open("New Pokemon.csv", "a")
                            pokemon_name_file.write(line)
                            pokemon_name_file.close()
                            break
                        break
                    else:
                        continue
            File.close()
            break
    #use case 3
    if selection == "2":
        while True:
            PokemonType = []
            Pokemon_type1 = input("Please enter a Pokemon Type 1: ")
            File = open("pokemon.csv",'r')
    #change the file as a list
            readlines = File.readlines()
            for line in readlines:
                lines = line.split(',') 
                if lines[2] == Pokemon_type1:
                    PokemonType.append(lines)
            ask_type_save = input("Do you wish to save these Pokemons into a separate file (Y/N)?")
            if ask_type_save == "Y":
                        #error check
                try:
                    typefilename = input("Please input the file name to save these pokemon: ")
                    typefile = open(typefilename+".csv","w")
                    writer = csv.writer(typefile)
                    for row in readlines:
                            writer.writerow(row)
                except FileNotFoundError:
                    print("Pokemon file is not found. Please enter the name of the file again!")
                break
    #Use case 4 selection
    if selection == "3":
        num+=1
        sort_data()
        continue


    #exit
    if selection == "4":
        print(f' the total number of queries and sorts executed by the Gamer during the session is:{num}' )
        if ask_type_save == "Y":
            print(f'the new file name: New Pokemon.csv {typefilename}.csv')
        else:
            break

        break
    






        






                
