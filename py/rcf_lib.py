#!/usr/bin/python3

import os
import random
import unittest
import pandas as pd
import xlrd
from rcf_logs import dbg

e = False  # Debug.


def title(title_string):
    """Prints a fancy title to be called at the start of a program."""
    print("\n\t "+title_string)
    print("\t+"+(len(title_string)*"-")+"+\n")


def subtitle(subtitle_string):
    """Prints a more subtle section divider in the same style as title()"""
    print(" "+subtitle_string)
    print("-"+(len(subtitle_string)*"-")+"-+\n")


# Excel Spreadsheet I/O

class TableGlob:
    """TableGlob - Excel Table Data-Glob.
    An object that holds an excel table, with methods to update, maniuplate
    and save a copy of the table to disk. Treats the original excel table as
    immutable, preventing the destruction of data. The mutated file is saved
    with a mutated filename that is overwritten when run through the system
    more than once.
    """

    filepath = ""

    def __init__(self, name):
        self.name = name

    def import_table(self, filepath):
        """Given a path to an excel table, attempts to ingest the table's sheets."""
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
    def get_df(self, sheetid):
        """Docs"""
        if str(sheetid) in self.sheetlist:
            return self.tablefile.parse(sheetid)
        return False

    def data_shape_tuple(self):
        """Docs"""
        tuples = []
        for sheetid in self.sheetlist:
            temptable = self.get_df(str(sheetid))
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

    def import_word_document(self):
        """Docs"""
        return 0

    def export_word_document(self):
        """Docs"""
        return 0

    # TODO: Implement me :)


# Unit Tests for RCF-Lib methods.

class TestMethods(unittest.TestCase):
    """Run unit tests on trivial methods"""

    def test_title(self):
        """Docs"""
        dbg(True, "good", "Unit", "Testing title.")
        print("A title and subtitle should be visible below:")
        title("Wow, Look, a Title!")
        subtitle("Wow, Look, a SubTitle!")


class TestTableGlob(unittest.TestCase):
    """Run unit tests on TableGlob
    CONFIG: testTablePath must be set to a valid excel spreadsheet.
    """

    TEST_TABLE_PATH = "py/tables/TestTable.xlsx"

    def test_01_import(self):
        """Confirms that """
        dbg(True, "good", "Unit", "Testing table import.")
        table = TableGlob("Primary Table")
        self.assertTrue(table.import_table(self.TEST_TABLE_PATH))
        self.assertFalse(table.import_table(self.TEST_TABLE_PATH))

    def test_02_dataframe(self):
        """Ensures that the table is imported correctly by verifying the data
        in each sheet has a shape.
        """
        dbg(True, "good", "Unit", "Testing table import: data shape tuples.")
        table = TableGlob("Primary Table")
        self.assertTrue(table.import_table(self.TEST_TABLE_PATH))
        self.assertIsNotNone(table.data_shape_tuple())


if __name__ == '__main__':
    e = True  # Debug is ON when unit testing.
    unittest.main()
