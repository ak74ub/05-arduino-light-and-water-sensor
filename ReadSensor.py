import serial

f = open("SensorData.txt", "w")
sensorInfo = ""

ser = serial.Serial('COM3', 9600, timeout=5) # COM3 is the port used by Alex's computer. Might be different on other machines

# do while (sort of)
sensorInfo = ser.readline().decode().strip() 
sensorInfo += "\n"
f.write(sensorInfo)
while sensorInfo[-1] == "\n": # if readline times out no new line character will be read
    f.close() # close file while ser.readline() blocks
    sensorInfo = ser.readline().decode() # blocking call. Sleep is not needed
    f = open("SensorData.txt", "a")
    f.write(sensorInfo)


f.close()   # good practice or something
ser.close() # not again!