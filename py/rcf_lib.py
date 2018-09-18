#!/usr/bin/python3
# Test program rcf006_SimpleOps.py
# Tested in program rcf005_UnitTest.py

import random
from rcf_logs import dbg
import unittest
import os
import pandas as pd
import xlrd

# True for debugging:
e = True

def title( title_string ):
    print("\n\t "+title_string)
    print("\t+"+(len(title_string)*"-")+"+\n")

class TableGlob:

    filepath = ""

    def __init__(self, name):
        self.name = name

    def importExcelTable(self, filepath):
        if not self.filepath:
            if( os.path.isfile(str(filepath)) and str(filepath[-4:]) == 'xlsx'):
                dbg(e,"good","TblGlb","Data found, importing {0}...".format(filepath))
                self.tablefile = pd.ExcelFile(filepath)
                self.sheetlist = self.tablefile.sheet_names
                dbg(e,"good","TblGlb","Sheets: {0}".format(self.sheetlist))
                self.filepath = filepath
                return True
            else:
                dbg(e,"fail","TblGlb","Path incorrect or table invalid!")
                return False
        else:
            dbg(e,"fail","TblGlb","Table already imported!")
            return False

    def sheets(self):
        return self.sheetlist

    # Returns a pandas dataframe from the excel sheet specified.
    def getdf(self, sheetid):
        if str(sheetid) in self.sheetlist:
            return self.tablefile.parse(sheetid)

    def dataShapeTuple(self):
        tuples = []
        for sheetid in self.sheetlist:
            temptable = self.getdf(str(sheetid))
            tuples.append((temptable.shape[0],temptable.shape[1]))

        dbg(e,"good","TblGlb","Data Shape (ROW,COL): {0}".format(tuples))
        return tuples





class TestMethods(unittest.TestCase):

  def test_title(self):
      dbg(e,"good","Unit","Testing title.")
      print("This should display as a title:")
      title("Wow, Look, a Title!")

class TestTableGlob(unittest.TestCase):

    def test_01_import(self):
        dbg(e,"good","Unit","Testing table import.")
        t = TableGlob("Primary Table")
        self.assertTrue(t.importExcelTable("tables/TestTable.xlsx"))
        self.assertFalse(t.importExcelTable("tables/TestTable.xlsx"))

    def test_02_dataframe(self):
        dbg(e,"good","Unit","Testing table import: data shape tuples.")
        t = TableGlob("Primary Table")
        self.assertTrue(t.importExcelTable("tables/TestTable.xlsx"))
        self.assertIsNotNone(t.dataShapeTuple())

if __name__ == '__main__':
  unittest.main()
