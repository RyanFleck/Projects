#!/usr/bin/python3
# Test program rcf006_SimpleOps.py
# Tested in program rcf005_UnitTest.py

import os
import random
import unittest
import pandas as pd
import xlrd
from rcf_logs import dbg

e = False  # Debug.


def title(title_string):
    """Docs"""
    print("\n\t "+title_string)
    print("\t+"+(len(title_string)*"-")+"+\n")


def subtitle(subtitle_string):
    """Docs"""
    print(" "+subtitle_string)
    print("-"+(len(subtitle_string)*"-")+"-+\n")


# Excel Spreadsheet I/O

class TableGlob:
    """Docs"""

    filepath = ""

    def __init__(self, name):
        self.name = name

    def importExcelTable(self, filepath):
        """Docs"""
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
        """Docs"""
        return self.sheetlist

    # Returns a pandas dataframe from the excel sheet specified.
    def getdf(self, sheetid):
        """Docs"""
        if str(sheetid) in self.sheetlist:
            return self.tablefile.parse(sheetid)
        return False

    def dataShapeTuple(self):
        """Docs"""
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
        """Docs"""
        return 0

# Word Document I/O


class DocuGlob:
    """Docs"""

    def __init__(self, name):
        self.name = name

    def importWordDocument(self):
        """Docs"""
        return 0

    def exportWordDocument(self):
        """Docs"""
        return 0

    # TODO: Implement me :)


# Unit Tests for RCF-Lib methods.

class TestMethods(unittest.TestCase):
    """Docs"""

    def test_title(self):
        """Docs"""
        dbg(True, "good", "Unit", "Testing title.")
        print("A title and subtitle should be visible below:")
        title("Wow, Look, a Title!")
        subtitle("Wow, Look, a SubTitle!")


class TestTableGlob(unittest.TestCase):
    """Docs"""

    # Change to match current test table.
    testTablePath = "py/tables/TestTable.xlsx"

    def test_01_import(self):
        """Docs"""
        dbg(True, "good", "Unit", "Testing table import.")
        table = TableGlob("Primary Table")
        self.assertTrue(table.importExcelTable(self.testTablePath))
        self.assertFalse(table.importExcelTable(self.testTablePath))

    def test_02_dataframe(self):
        """Docs"""
        dbg(True, "good", "Unit", "Testing table import: data shape tuples.")
        table = TableGlob("Primary Table")
        self.assertTrue(table.importExcelTable(self.testTablePath))
        self.assertIsNotNone(table.dataShapeTuple())


if __name__ == '__main__':
    e = True  # Debug is ON when unit testing.
    unittest.main()
