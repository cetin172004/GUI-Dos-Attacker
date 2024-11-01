#airmon-ng start wlp0s20f3
#xterm -hold -T 'PayDOS - Networks' -geometry 100x25 -fa 'FreeMono' -fs 14 -bg rgb:25/217/7 -fg white -e 'airodump-ng wlp0s20f3mon -w outputs/output --output-format csv'
#airmon-ng stop wlp0s20f3mon
python3 get_wifi_adapter_name.py
python3 get_network_name.py