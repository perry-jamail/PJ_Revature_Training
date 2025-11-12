from abc import ABC, abstractmethod
import math

class Shape(ABC):
    @abstractmethod
    def calculateArea(self):
        pass

class Rectangle(Shape):
    def __init__(self, width, height):
        self.width = width
        self.height = height

    def calculateArea(self):
        return self.height * self.width

class Triangle(Shape):
    def __init__(self, width, height):
        self.width = width
        self.height = height

    def calculateArea(self):
        return (self.height * self.width) / 2

class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius

    def calculateArea(self):
        return (self.radius * self.radius) * math.pi