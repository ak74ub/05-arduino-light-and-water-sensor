import unittest
from ReadSensor import fileWrite

class testSensor(unittest.TestCase):
    
    def testWrite(self):
        try:
            fileWrite("1 2 3")
        except OSError:
            self.fail("file could not be opened")

    def testClose(self):
        f = fileWrite("1 2 3")
        f.close()
        assert(f.closed)


if __name__ == "__main__":
    unittest.main() # run all tests
