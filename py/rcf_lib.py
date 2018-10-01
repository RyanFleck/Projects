#!/usr/bin/python3
"""RCF-LIB.py

A useful collection of functions primarily for I/O on the command line and to
or from Microsoft file formats. Notable functionality includes:

    TableGlob()
        Object that holds mutable copies of all sheets within an MS-Excel file.

    DocuGlob()
        Object that holds a mutable copy of a MS-Word document.

Todo:
    * Fix TableGlob
    * Implement DocuGlob

Additional modules required:
    * xlrd
    * openpyxl
    * pandas
"""

import os
from datetime import datetime as dt
import unittest
import pandas as pd
from colorama import init as cinit
from rcf_logs import dbg
cinit()  # Filters ANSI escape sequences and inserts Win32 calls.

e = False  # Debug.
TIME = dt.now()


def title(title_string):
    """Prints a fancy title to be called at the start of a program."""
    print("\n\t "+title_string)
    print("\t+"+(len(title_string)*"-")+"+\n")


def subtitle(subtitle_string):
    """Prints a more subtle section divider in the same style as title()"""
    print("\n "+subtitle_string)
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
        self.filepath = ""
        self.tablefile = None
        self.sheetlist = None  # Deprecated.
        self.sheet_data_frames = {}
        self.test_date = TIME.strftime("%Y%m%d")

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
                self.__process_sheets_to_dataframes()
                return True
            else:
                dbg(e, "fail", "TblGlb", "Path incorrect or table invalid!")
                return False
        else:
            dbg(e, "fail", "TblGlb", "Table already imported!")
            return False

    # Import/export functionality.

    def __process_sheets_to_dataframes(self):
        """Places each sheet into a Pandas dataframe for processing."""
        for sheet in self.tablefile.sheet_names:
            dbg(e, "good", "TblGlb", "Importing sheet: {0}".format(sheet))
            self.sheet_data_frames[sheet] = pd.read_excel(
                self.tablefile, sheet)
        return True

    def export_excel_table(self):
        """Saves all dataframe sheets to an excel table. Returns saved filename."""
        new_file_name = self.filepath[0:-5] + \
            "-auto-{0}".format(TIME.strftime("%Y%m%d-%H%M.xlsx"))
        dbg(e, "good", "TblGlb",
            "Exporting excel table as {0}".format(new_file_name))
        writer = pd.ExcelWriter(new_file_name)
        for dataframe in self.sheet_data_frames:
            print(self.sheet_data_frames[dataframe].to_string())
            self.sheet_data_frames[dataframe].to_excel(writer, dataframe)

        writer.save()
        return new_file_name

    # Modification methods.

    def get_sheet(self, sheetid):
        """passes the dataframe by reference for modification."""
        if self.sheet_data_frames.__contains__(sheetid):
            return self.sheet_data_frames[sheetid]
        return False

    # Debugging methods.

    def dump_table(self, sheetid):
        """Given a sheet id, prints the corresponding table."""
        if self.sheet_data_frames.__contains__(sheetid):
            frame = self.sheet_data_frames[sheetid]
            subtitle("Sheet {0}".format(sheetid))
            print(frame.to_string())
            return True
        return False

    def dump_all_tables(self):
        """Prints all tables in glob to console."""
        title("Dump Table '{0}'".format(self.name))
        x = 0
        for sheet in self.sheet_data_frames:
            self.dump_table(sheet)
            x += 1

        print("\nDumped {0} tables from '{1}'.\n".format(x, self.name))

    def sheets(self):
        """Returns the original list of excel sheets."""
        return self.sheetlist

    def data_shape_tuple(self):
        """Deprecated method."""
        tuples = []
        for sheet in self.sheet_data_frames:
            tuples.append(
                (self.sheet_data_frames[sheet].shape[1], self.sheet_data_frames[sheet].shape[0]))

        dbg(e, "good", "TblGlb", "Data Shape (ROW,COL): {0}".format(tuples))
        return tuples


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


# BrowserUnit creates UnitTest objects.

class BrowserUnit:
    def __init__(self, name, destructive=True):
        self.name = name


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

    def test_03_export(self):
        """Ensures that the table is imported correctly by verifying the data
        in each sheet has a shape.
        """
        dbg(True, "good", "Unit", "Testing table import: data shape tuples.")
        table = TableGlob("Primary Table")
        self.assertTrue(table.import_table(self.TEST_TABLE_PATH))

        # To reduce disk R/W, this unit test is disabled for now.
        '''
        write_name = table.export_excel_table()
        self.assertIsNotNone(write_name)
        written = os.path.exists(write_name)
        self.assertTrue(written)
        if(written):
            os.remove(write_name)
        self.assertFalse(os.path.exists(write_name))
        '''

    def test_04_dumping(self):
        """Ensures debugging dump-table methods work."""
        dbg(True, "good", "Unit", "Testing table import: data shape tuples.")
        table = TableGlob("Primary Table")
        self.assertTrue(table.import_table(self.TEST_TABLE_PATH))
        table.dump_all_tables()

    def test_05_bu_init(self):
        """Ensures BrowserUnit can be instantiated correctly."""
        dbg(True, "good", "Unit", "Testing BrowserUnit: ")
        table = TableGlob("Primary Table")
        self.assertTrue(table.import_table(self.TEST_TABLE_PATH))
        table.dump_all_tables()

if __name__ == '__main__':
    e = True  # Debug is ON when unit testing.
    unittest.main()
