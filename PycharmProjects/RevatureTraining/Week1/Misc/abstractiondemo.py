from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def Shape(self):
        pass

class Circle(Shape):
    def Shape(self):
        return "Circle"

class Rectangle(Shape):
    def Shape(self):
        return "Rectangle"

circle = Circle()
print(circle.Shape())