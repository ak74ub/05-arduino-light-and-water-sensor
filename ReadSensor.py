import serial

f = open("SensorData.txt", "w")
sensorInfo = ""

ser = serial.Serial('COM3', 9600, timeout=None) # COM3 is the port used by Alex's computer. Might be different on other machines

# makeshift do while
sensorInfo = ser.readline().decode().strip() 
f.write(sensorInfo + "\n")
while True: # maybe replace with an exit condition at some point
    f.close() # close file while ser.readline() blocks
    sensorInfo = ser.readline().decode().strip() # blocking call. Sleep is not needed
    f = open("SensorData.txt", "a")
    f.write(sensorInfo + "\n")
    print("Writen : ", sensorInfo)


f.close()   # good practice or something
ser.close() # not again!