import csv
import os

networks_file = open("networks", "w")

"""
all_files = os.listdir("outputs/")
full_paths = [os.path.join("outputs/", file) for file in all_files]

newest_file = max(full_paths, key=os.path.getctime)

with open(newest_file, newline='') as csvfile:
	reader = csv.reader(csvfile)
	for row in reader:
		if (len(row) == 15 and row[13] != " ESSID" and row[13] != " "):
			essid = row[13][1:]
			print(essid)
"""

networks = ['network1', 'network2', 'network3', 'network4', 'network5', 'network6', 'network7', 'network8', 'network9']
for network in networks:
	networks_file.write(network + "\n")


