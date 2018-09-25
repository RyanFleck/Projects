#!/usr/bin/python3
# Test program rcf006_SimpleOps.py
# Tested in program rcf005_UnitTest.py

import random
from rcf_logs import dbg
import unittest
import os
import pandas as pd
import xlrd

e = False  # Debug.


def title(title_string):
    print("\n\t "+title_string)
    print("\t+"+(len(title_string)*"-")+"+\n")


def subtitle(subtitle_string):
    print(" "+subtitle_string)
    print("-"+(len(subtitle_string)*"-")+"-+\n")


# Excel Spreadsheet I/O

class TableGlob:

    filepath = ""

    def __init__(self, name):
        self.name = name

    def importExcelTable(self, filepath):
        if not self.filepath:
            if(os.path.isfile(str(filepath)) and str(filepath[-4:]) == 'xlsx'):
                dbg(e, "good", "TblGlb",
                    "Data found, importing {0}...".format(filepath))
                self.tablefile = pd.ExcelFile(filepath)
                self.sheetlist = self.tablefile.sheet_names
                dbg(e, "good", "TblGlb", "Sheets: {0}".format(self.sheetlist))
                self.filepath = filepath
                return True
            else:
                dbg(e, "fail", "TblGlb", "Path incorrect or table invalid!")
                return False
        else:
            dbg(e, "fail", "TblGlb", "Table already imported!")
            return False

    def sheets(self):
        return self.sheetlist

    # Returns a pandas dataframe from the excel sheet specified.
    def getdf(self, sheetid):
        if str(sheetid) in self.sheetlist:
            return self.tablefile.parse(sheetid)
        return False

    def dataShapeTuple(self):
        tuples = []
        for sheetid in self.sheetlist:
            temptable = self.getdf(str(sheetid))
            tuples.append((temptable.shape[0], temptable.shape[1]))

        dbg(e, "good", "TblGlb", "Data Shape (ROW,COL): {0}".format(tuples))
        return tuples

    # Exports to the same directory as the imported file with a mutated
    # filename. Mutation in the form string, "{0}-out" , where {0} inserts
    # the original filename. ".xslx" is automatically appended.
    def exportExcelTable(self, mutation):
        return 0

# Word Document I/O


class DocuGlob:

    def __init__(self, name):
        self.name = name

    def importWordDocument(self):
        return 0

    def exportWordDocument(self):
        return 0

    # TODO: Implement me :)


# Unit Tests for RCF-Lib methods.

class TestMethods(unittest.TestCase):

    def test_title(self):
        dbg(True, "good", "Unit", "Testing title.")
        print("A title and subtitle should be visible below:")
        title("Wow, Look, a Title!")
        subtitle("Wow, Look, a SubTitle!")


class TestTableGlob(unittest.TestCase):

    # Change to match current test table.
    testTablePath = "py/tables/TestTable.xlsx"

    def test_01_import(self):
        dbg(True, "good", "Unit", "Testing table import.")
        t = TableGlob("Primary Table")
        self.assertTrue(t.importExcelTable(self.testTablePath))
        self.assertFalse(t.importExcelTable(self.testTablePath))

    def test_02_dataframe(self):
        dbg(True, "good", "Unit", "Testing table import: data shape tuples.")
        t = TableGlob("Primary Table")
        self.assertTrue(t.importExcelTable(self.testTablePath))
        self.assertIsNotNone(t.dataShapeTuple())


if __name__ == '__main__':
    e = True  # Debug is ON when unit testing.
    unittest.main()
