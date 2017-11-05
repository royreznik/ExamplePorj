# Programed by RoyReznik
# Github: https://github.com/royreznik
import kivy
from kivy.properties import StringProperty, ObjectProperty
from kivy.uix.screenmanager import ScreenManager, Screen
from kivy.app import App
from kivy.lang import Builder
from kivy.uix.widget import Widget
from kivy.graphics import Line
from sklearn.externals import joblib
from scipy import misc
import random
"""
Debug
import matplotlib
import matplotlib.pyplot as plt
matplotlib.use("TkAgg")
"""

# TODO: Info Screen(about the application), Option Screen(Colors, Sounds)
# TODO: Alphabetic recognize, Number Sounds


class MainScreen(Screen):
    pass


class InfoScreen(Screen):
    pass


class OptionScreen(Screen):
    pass


class ScreenManagement(ScreenManager):
    pass


class DrawInput(Widget):
    # Touch Controller
    def on_touch_down(self, touch):
        with self.canvas:
            touch.ud["line"] = Line(points=(touch.x, touch.y), width=100)

    def on_touch_move(self, touch):
        touch.ud["line"].points += (touch.x, touch.y)

    def on_touch_up(self, touch):
        self.export_to_png("roy.png")

    # Clean Method
    def cleaner(self):
        self.canvas.clear()

    # Main Method of the Program, ML Number Classifier
    @staticmethod
    def analysis(num):
        model = joblib.load("NumberClasser")
        img = misc.imread("roy.png")
        img = misc.imresize(img, (8, 8))
        """
        Only Used to Debug
        plt.imshow(img, cmap=plt.cm.gray_r, interpolation="nearest")
        plt.show()
        """
        img = img.astype("float64")
        img = misc.bytescale(img, high=16, low=0)
        x_test = []

        for eachRow in img:
            for eachPixel in eachRow:
                x_test.append(sum(eachPixel) / 3.0)
        res = model.predict([x_test])
        results = {'theAnswer': res, 'theImage': x_test}
        print(num)
        print(res[0])
        if int(res[0]) is int(num):
            print("nice")
        else:
            print("nope")
        return results


class AnotherScreen(Screen):
    random_number = StringProperty()
    save_number = int()

    def __init__(self, **kwargs):
        super(AnotherScreen, self).__init__(**kwargs)
        self.random_number = str(random.randint(1, 9))
        self.save_number = self.random_number

    def change_text(self):
        print(DrawInput.analysis(self.random_number))

        self.random_number = str(random.randint(1, 9))
        self.save_number = self.random_number


    pass

presentation = Builder.load_file("main2.kv")


class MainApp(App):

    def build(self):
        return presentation

    def clean(self):
        pass

MainApp().run()