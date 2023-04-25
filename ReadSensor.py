import serial

f = open("SensorData.txt", "w")
sensorInfo = ""

ser = serial.Serial('COM3', 9600, timeout=60) # COM3 is the port used by Alex's computer. Might be different on other machines

# makeshift do while
sensorInfo = ser.readline().decode().strip() 
sensorInfo += "\n"
f.write(sensorInfo)
while sensorInfo[-1] == "\n": # if readline times out no new line character will be read
    f.close() # close file while ser.readline() blocks
    sensorInfo = ser.readline().decode().strip() # blocking call. Sleep is not needed
    f = open("SensorData.txt", "a")
    f.write(sensorInfo + "\n")


f.close()   # good practice or something
ser.close() # not again!