import serial
import time

f = open("SensorData.txt", "w")
SLEEPTIME = 1
sensorInfo = ""

serial.Serial('COM5').close() # not again!
ser = serial.Serial('COM5', 115200, timeout=None) # COM4 is a stand in, actual port may vary
while True: # maybe replace with an exit condition at some point
    sensorInfo = ser.readline().decode().strip()
    print("Write")
    f.write(sensorInfo + "\n")
    f.close()
    time.sleep(SLEEPTIME) # sleep some amount of time, should depend on sensor read interval
    f = open("SensorData.txt", "a")


f.close()   # good practice or something
ser.close() # not again!