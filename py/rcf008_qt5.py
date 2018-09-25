#!/usr/bin/python3
# PEP-8 STANDARD

import unittest
from PyQt5.QtWidgets import QApplication, QWidget, QPushButton, QVBoxLayout, QLabel, QMessageBox
from rcf_logs import dbg

dbg(True, "Good", "QT5", "Modules loaded.")

APP = QApplication(["Test"])
APP.setStyle('Fusion')
window = QWidget()
window.setWindowTitle("Test")
layout = QVBoxLayout()
window.setGeometry(500, 500, 320, 40)

button = QPushButton("Run tests")


def activate_tests():
    """Docstring. """
    alert = QMessageBox()
    alert.setWindowTitle("Alert")
    alert.setText("Running...")
    alert.exec_()


button.clicked.connect(activate_tests)

layout.addWidget(button)

window.setLayout(layout)
window.show()
APP.exec_()


class TestMethods(unittest.TestCase):
    """Docstring. """

    def unit_tests_functional(self):
        """Docstring. """
        self.assertTrue(1 > 0.9)

    def unit_tests_two(self):
        """Docstring. """
        self.assertTrue(1 > 0.9)


if __name__ == '__main__':
    unittest.main()
