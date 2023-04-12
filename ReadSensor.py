import serial
import time

f = open("SensorData.txt", "a")
SLEEPTIME = 60
sensorInfo = ""

ser = serial.Serial('COM4', 9600, timeout=None) # COM4 is a stand in, actual port may vary
while True: # maybe replace with an exit condition at some point
    sensorInfo = ser.readline().decode().strip()
    f.write(sensorInfo + "\n")
    f.flush()
    time.sleep(SLEEPTIME) # sleep some amount of time, should depend on sensor read interval



f.close()   # good practice or something
ser.close() # not again!