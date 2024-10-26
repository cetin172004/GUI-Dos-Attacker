import subprocess

wireless_interface_command = ["iw", "dev"]

def get_wifi_adapter_name():
	result = subprocess.run(wireless_interface_command, capture_output=True, text=True)
	lines = result.stdout.splitlines()
	
	adapter_lines = []
	adapter_names = []
	
	# select related line
	for line in lines:
		if ("Interface" in line):
			adapter_lines.append(line)
			
	# get only name
	for adapter_line in adapter_lines:
		counter = 0
		adapter_line_without_tab = adapter_line.replace("\t", "")
		adapter_name = ""
		for letter in adapter_line_without_tab:
			if (counter >= 10) : 
				adapter_name += letter
				counter += 1
			else:
				counter += 1
		
		adapter_names.append(adapter_name)
	
	return adapter_names
	
print(get_wifi_adapter_name())